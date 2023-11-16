package com.example.backend.rest;

import com.example.backend.core.Person;
import com.example.backend.core.PersonService;
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
class PersonControllerTest {

    @Mock
    private PersonService service;
    @InjectMocks
    private PersonController controller;
    private Person person;
    private PersonDto personDto;

    @BeforeEach
    void setUp() {
        personDto = new PersonDto(UUID.randomUUID(), "name", 42);
        person = personDto.toBusinessObject();
    }

    @Test
    void create() {
        when(service.create(person)).thenReturn(person);

        PersonDto result = controller.create(personDto);

        assertThat(result).isEqualTo(personDto);
    }

    @Test
    void getAll() {
        when(service.findAll()).thenReturn(List.of(person));

        List<PersonDto> result = controller.getAll();

        assertThat(result).containsExactly(personDto);
    }
}