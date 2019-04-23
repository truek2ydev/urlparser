package com.example.urlparser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class SampleController {
    @RequestMapping()
    public String main(Model model) {
        model.addAttribute("name", "Test");
        return "main";
    }
}
