package com.example.surnameapi.model;

public class Person {
    private final int id;
    private final String firstName;
    private final String surname;
    private final int age;

    public Person(int id, String firstName, String surname, int age) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
}
