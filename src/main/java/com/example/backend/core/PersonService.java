package com.example.backend.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonPersistence persistence;

    public Person create(Person person){
        return persistence.save(person);
    }

    public List<Person> findAll(){
        return persistence.findAll();
    }
}
