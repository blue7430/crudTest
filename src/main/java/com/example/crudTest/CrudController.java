package com.example.crudTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CrudController {

    @GetMapping("/")
    public String main() {
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }
}
