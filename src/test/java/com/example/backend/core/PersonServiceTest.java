package com.example.backend.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonPersistence persistence;
    @InjectMocks
    private PersonService service;
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(UUID.randomUUID(), "name", 42);
    }

    @Test
    void create() {
        when(persistence.save(person)).thenReturn(person);

        Person result = service.create(person);

        assertThat(result).isEqualTo(person);
    }

    @Test
    void findAll() {
        when(persistence.findAll()).thenReturn(List.of(person));

        List<Person> result = service.findAll();

        assertThat(result).containsExactly(person);
    }
}