package com.simple.showhostname.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("hostname", "Host : "+System.getenv("HOSTNAME"));
        return "home";
    }
}
