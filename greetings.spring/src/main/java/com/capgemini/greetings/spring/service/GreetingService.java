package com.capgemini.greetings.spring.service;

import com.capgemini.greetings.spring.entity.Greeting;
import com.capgemini.greetings.spring.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepo greetingRepo;

    @Autowired
    public GreetingService(GreetingRepo greetingRepo) {
        this.greetingRepo = greetingRepo;
    }

    public GreetingService(){}

    public String getMessage(Long id){
        Greeting greeting = greetingRepo.findById(id).orElseThrow();
        return greeting.getMessage();
    }

    public Greeting postMessage(Greeting greeting){
        return greetingRepo.save(greeting);
    }
}
