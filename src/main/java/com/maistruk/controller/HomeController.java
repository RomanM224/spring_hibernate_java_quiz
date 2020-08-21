package com.maistruk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maistruk.service.spring.SpringAnswerService;

@Controller
public class HomeController {
    
    @Autowired
    private SpringAnswerService springAnswerService;
    
    @RequestMapping(value = "/")
    public String home(ModelMap model) {
        return "home.jsp";
    }
    
}
