package me.dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WelcomeController
 */
@RestController
public class WelcomeController {
    @GetMapping(path = "/welcome")
    public String welcome(){
        return "Welcome to my Spring Boot Web API";
    }
    
}