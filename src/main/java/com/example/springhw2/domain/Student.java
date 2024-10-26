package com.example.springhw2.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Student {

    private static long idCounter = 1;

    private long id;
    private String name;
    private int age;

    @JsonCreator
    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = idCounter++;
    }

}