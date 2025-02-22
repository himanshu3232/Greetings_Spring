package com.capgemini.greetings.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }

    @PostMapping("/greeting/{name}")
    public ResponseEntity<String> postGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> putGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }
}
