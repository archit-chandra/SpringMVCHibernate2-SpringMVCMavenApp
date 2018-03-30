package com.gemalto.controllers;

import com.gemalto.models.Customer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        dataBinder.setDisallowedFields(new String[]{"mobile"}); // ignore this field from dtat binding

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd"); // forces to enter this format in the form
        dataBinder.registerCustomEditor(Date.class, "birthDay", new CustomDateEditor(dateFormat, false));
    }

    @ModelAttribute
    public void addingCommonHeader(Model model) {
        model.addAttribute("headerLabel", "Customer Application");
    }

    @RequestMapping("/showForm")
    public String showForm(Model customerModel) {
        customerModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
