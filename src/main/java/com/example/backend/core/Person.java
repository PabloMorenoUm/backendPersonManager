package com.example.backend.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Person {
    private UUID personId;
    private String name;
    private int age;
}
