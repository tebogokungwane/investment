package com.investment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("Im saying hello");
        return "Say hello world";
    }
}
