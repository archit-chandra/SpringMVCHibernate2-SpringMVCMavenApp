package com.gemalto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //    need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //    need a controller method to process form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
}
