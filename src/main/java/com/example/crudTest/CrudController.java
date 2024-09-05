package com.example.crudTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CrudController {

    private final CrudRepository crudRepository;
    private final CrudService crudService;

    @GetMapping("/")
    public String main() {
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String board(Model model) {
        List<Crud> result = crudRepository.findAll();
        model.addAttribute("crud", result);
        return "board";
    }

    @GetMapping("/board/write-form")
    public String write() {
        return "write-form";
    }

    @PostMapping("/board/write-form")
    public String addpost(Integer user_id, String title, String content) {
        crudService.addpost(user_id, title, content);
        return "redirect:/board";
    }

    @GetMapping("/board/post/{post_id}")
    public String post(@PathVariable Integer post_id, Model model) {
        Optional<Crud> result = crudRepository.findById(post_id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "post";
        } else {
            return "redirect:/board";
        }
    }

    @GetMapping("/board/post/{post_id}/edit")
    public String edit(@PathVariable Integer post_id, Model model) {
        Optional<Crud> result = crudRepository.findById(post_id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit";
        } else {
            return "redirect:/board";
        }
    }

    @PostMapping("/board/post/{post_id}/edit")
    public String editpost(@PathVariable Integer post_id, Integer user_id, String title, String content) {
        crudService.updatepost(post_id, user_id, title, content);
        return "redirect:/board";
    }
}
