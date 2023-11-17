package com.example.backend.data;

import com.example.backend.core.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonPersistenceImplTest {

    @Mock
    private EntityManager manager;
    @InjectMocks
    private PersonPersistenceImpl persistence;
    private Person person;
    private PersonEntity entity;

    @BeforeEach
    void setUp() {
        entity = new PersonEntity(null, UUID.randomUUID(), "name", 42);
        person = entity.toBusinessObject();
    }

    @Test
    void save() {
        persistence.save(person);

        verify(manager).persist(entity);
    }

    @Test
    void findAll() {
        TypedQuery<PersonEntity> query = (TypedQuery<PersonEntity>) mock(TypedQuery.class);
        when(manager.createQuery("SELECT p FROM PERSON p", PersonEntity.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(List.of(entity));

        List<Person> result = persistence.findAll();

        assertThat(result).containsExactly(person);
    }
}