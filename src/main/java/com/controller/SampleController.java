package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
public class SampleController extends SpringBootServletInitializer {
	
	@Autowired
	CustomerRepository repo;
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/create")
    @ResponseBody
    String save(String firstName, String lastName) {
    	Customer cus = new Customer(firstName,lastName);
    	repo.save(cus);
        return "check your DB";
    }
    
    @RequestMapping("/find")
    @ResponseBody
    String find(String firstName) {
    	Customer cus = repo.findByFirstName(firstName);
        return cus.lastName;
    }
    


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SampleController> applicationClass = SampleController.class;
}