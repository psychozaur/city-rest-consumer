package com.rybickim.cityrestconsumer.controller;

import com.rybickim.cityrestconsumer.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private DataRepository dataRepository;

    @GetMapping("/cities")
    public String homePage(Model model){
        model.addAttribute("connectionAddress",dataRepository.getConnectionAddress());
//        model.addAttribute("connectionAddress",dataRepository.getRestTemplate());

        return "home";
    }
}
