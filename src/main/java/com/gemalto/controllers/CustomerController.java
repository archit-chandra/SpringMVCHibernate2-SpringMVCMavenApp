package com.gemalto.controllers;

import com.gemalto.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model customerModel) {
        customerModel.addAttribute("customer", new Customer());
        return "customer-form";
    }
}
