package com.example.crudTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
