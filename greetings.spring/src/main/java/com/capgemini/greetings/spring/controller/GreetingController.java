package com.capgemini.greetings.spring.controller;

import com.capgemini.greetings.spring.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController extends ServiceLayer {

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }

    @PostMapping("/greeting/{name}")
    public ResponseEntity<String> postGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Create, %s", name), HttpStatus.OK);
    }

    @PutMapping("/greeting/put/{name}")
    public ResponseEntity<String> putGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Update, %s", name), HttpStatus.OK);
    }

    @DeleteMapping("/greeting/delete/{name}")
    public ResponseEntity<String> deleteGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Delete, %s", name), HttpStatus.OK);
    }

    @GetMapping("/greeting/default")
    public ResponseEntity<String> greetings
            (@RequestParam(value = "firstName", defaultValue = "Hello") String firstName
                    , @RequestParam(value = "lastName", defaultValue = "World") String lastName){
        return new ResponseEntity<>(firstName + " " + lastName, HttpStatus.OK);
    }
}


