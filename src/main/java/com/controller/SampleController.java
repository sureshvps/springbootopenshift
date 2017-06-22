package com.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
public class SampleController {
	

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/create")
    @ResponseBody
    String save(String firstName, String lastName) {
    	
        return "back end code is not yet integrated";
    }
    


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}