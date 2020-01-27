package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeimosController {

    @GetMapping("/deimos")
    @ResponseBody

    public String countdown(){
        return "31 days until Dev Day!";
    }

    @GetMapping("/deimos/{days}")
    @ResponseBody

    public String countdown(@PathVariable Integer days){
        return days + " days until Dev Day!";
    }
}
