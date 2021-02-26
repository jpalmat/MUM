package com.example.greet.controller;

import com.example.greet.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmypalma
 */
@RestController
public class GreetingController {
    @RequestMapping("/greeting/{message}")
    public ResponseEntity<?> getGreeting(@PathVariable("message") String message){
        Greeting greeting = new Greeting("");
        greeting.setContent("Hello world "+message);
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}
