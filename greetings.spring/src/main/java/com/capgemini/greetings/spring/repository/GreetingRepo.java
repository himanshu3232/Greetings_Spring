package com.capgemini.greetings.spring.repository;

import com.capgemini.greetings.spring.entity.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepo extends CrudRepository<Greeting, Long> {
}
