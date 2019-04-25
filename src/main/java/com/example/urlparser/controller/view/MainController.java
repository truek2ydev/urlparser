package com.example.urlparser.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class MainController {

    /**
     * main page controller
     */
    @RequestMapping("/")
    public String main() {
        return "main";
    }
}
