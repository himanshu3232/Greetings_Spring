package com.capgemini.greetings.spring.service;

import com.capgemini.greetings.spring.entity.Greeting;
import com.capgemini.greetings.spring.exception.InvalidIdException;
import com.capgemini.greetings.spring.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAllMessages(){
        List<Greeting> greetings = (List<Greeting>) greetingRepo.findAll();
        return mapToString(greetings);
    }

    public String patchMessage(Long id, String message){
        Greeting greeting = greetingRepo.findById(id).orElseThrow();
        greeting.setMessage(message);
        return greetingRepo.save(greeting).getMessage();
    }

    public void deleteMessage(Long id){
        greetingRepo.deleteById(id);
    }

    private List<String> mapToString(List<Greeting> greetings){
        List<String> messages = new ArrayList<>();

        for(Greeting greeting : greetings){
            messages.add(greeting.getMessage());
        }
        return messages;
    }
}
