package com.example.springbootstarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Contains @Controller and @ResponseBody annotations
@RestController
public class HelloWorldController {

    // HTTP GET REQUEST
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
