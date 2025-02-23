package com.capgemini.greetings.spring.controller;

import com.capgemini.greetings.spring.entity.Greeting;
import com.capgemini.greetings.spring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaveGreeting {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    public SaveGreeting(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    private SaveGreeting(){}

    @PostMapping("/greeting/post")
    public ResponseEntity<Greeting> postGreeting(@RequestParam String message){
        Greeting greeting = greetingService.postMessage(new Greeting(message));
        return new ResponseEntity<>(greeting, HttpStatus.CREATED);
    }

    @GetMapping("/greeting/get/{id}")
    public ResponseEntity<String> postGreeting(@PathVariable Long id){
       return new ResponseEntity<>(greetingService.getMessage(id), HttpStatus.CREATED);
    }

    @GetMapping("/greeting/get-all")
    public ResponseEntity<List<String>> getAllMessages(){
        return new ResponseEntity<>(greetingService.getAllMessages(), HttpStatus.OK);
    }

    @PatchMapping("/greeting/patch/{id}")
    public ResponseEntity<String> patchMessage(@PathVariable Long id, @RequestParam String message){
        return new ResponseEntity<>(greetingService.patchMessage(id, message), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/greeting/delete/v2/{id}")
    public void deleteMessage(@PathVariable Long id){
        greetingService.deleteMessage(id);
    }
}
