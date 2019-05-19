package com.rybickim.cityrestconsumer.controller;

import com.rybickim.cityrestconsumer.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private CityService cityService;

    public HomeController(CityService cityService) {
        this.cityService = cityService;
        logger.debug("HomeController(): " + cityService);
    }

    @GetMapping("/cities")
    public String homePage(Model model){
        model.addAttribute("connectionAddress",cityService.getConnectionAddress());
        model.addAttribute("cities",cityService.getCities());

        return "home";
    }
}
