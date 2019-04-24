package com.example.urlparser.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/boot")
    public String boot(Model model) {
        return "sample/bootexam";
    }

    @RequestMapping("/boot2")
    public String boot2(Model model) {
        return "sample/bootBodySample";
    }
}
