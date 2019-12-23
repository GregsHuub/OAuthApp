package com.springApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    //all redirects inside
    @GetMapping("/")
    public String mainPage(){
        return "mainPage";
    }
}
