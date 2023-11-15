package com.example.backend.data;

import com.example.backend.core.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class PersonEntity {
    private Long id;
    private UUID personId;
    private String name;
    private int age;

    public Person toBusinessObject(){
        return Person.builder()
                .personId(personId)
                .name(name)
                .age(age)
                .build();
    }

    public static List<Person> toBusinessObjects(List<PersonEntity> personEntities){
        return personEntities.stream().map(PersonEntity::toBusinessObject).collect(Collectors.toList());
    }

    public static PersonEntity toEntity(Person person){
        return PersonEntity.builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .age(person.getAge())
                .build();
    }
}
