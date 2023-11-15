package com.example.backend.core;

import java.util.List;

public interface PersonPersistence {

    Person save(Person person);

    List<Person> findAll(List<Person> people);
}
