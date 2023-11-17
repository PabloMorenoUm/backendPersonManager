package com.example.backend.data;

import com.example.backend.core.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class PersonEntity implements Serializable {
    @Id
    /*@TableGenerator(
            name = "companyGen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL",
            pkColumnValue = "CompanyGen", initialValue = 10, allocationSize = 1
    )*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID personId;
    @Column(length = 20)
    private String name;
    @Column()
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
                .id(null)
                .personId(person.getPersonId())
                .name(person.getName())
                .age(person.getAge())
                .build();
    }
}
