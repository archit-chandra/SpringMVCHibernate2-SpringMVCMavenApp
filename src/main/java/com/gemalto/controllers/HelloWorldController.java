package com.gemalto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    //    need a controller method to read the form data and add it to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
        //read the request parameter from HTML form
        String name = request.getParameter("studentName");
        //process the data
        name = name.toUpperCase();
        //create the message
        String result = "Yo! " + name;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }
}
