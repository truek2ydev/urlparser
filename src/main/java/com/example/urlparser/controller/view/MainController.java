package com.example.urlparser.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class MainController {
    @RequestMapping()
    public String main() {
        // model.addAttribute("name", "Test111");
        return "main";
    }
}