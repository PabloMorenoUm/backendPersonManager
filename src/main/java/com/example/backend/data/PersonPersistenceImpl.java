package com.example.backend.data;

import com.example.backend.core.Person;
import com.example.backend.core.PersonPersistence;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonPersistenceImpl implements PersonPersistence {

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public Person save(Person person) {
        PersonEntity entity = PersonEntity.toEntity(person);
        manager.persist(entity);
        return entity.toBusinessObject();
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<PersonEntity> query = manager.createQuery("SELECT p FROM PERSON p", PersonEntity.class);
        List<PersonEntity> entities = query.getResultList();
        return PersonEntity.toBusinessObjects(entities);
    }
}
