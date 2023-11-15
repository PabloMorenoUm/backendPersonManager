package com.example.backend.rest;

import com.example.backend.core.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@ToString
public class PersonDto {
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

    public static PersonDto toDto(Person person){
        return PersonDto.builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .age(person.getAge())
                .build();
    }

    public static List<PersonDto> toDtos(List<Person> people){
        return people.stream().map(PersonDto::toDto).collect(Collectors.toList());
    }
}
