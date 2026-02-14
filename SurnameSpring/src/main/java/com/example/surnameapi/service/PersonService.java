package com.example.surnameapi.service;

import com.example.surnameapi.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final List<Person> people = new ArrayList<>();

    public PersonService() {
        // seed sample data
        people.add(new Person(1, "Soumya", "Vinod", 20));
        people.add(new Person(2, "Rahul", "Panchal", 21));
        people.add(new Person(3, "Anushka", "Sharma", 40));
        people.add(new Person(4, "Rudra", "Mourya", 22));
        people.add(new Person(5, "Manisha", "Reddy", 23));
        people.add(new Person(6, "Manish", "Yadav", 21));
        people.add(new Person(7, "Vijay", "Mourya", 22));
        people.add(new Person(8, "Radha", "Mourya", 32));
    }

    public List<Person> findBySurnameExact(String surname) {
        if (surname == null) return List.of();
        String s = surname.trim().toLowerCase();
        return people.stream()
                .filter(p -> p.getSurname() != null && p.getSurname().toLowerCase().equals(s))
                .collect(Collectors.toList());
    }

    public List<Person> findBySurnameContains(String substring) {
        if (substring == null) return List.of();
        String s = substring.trim().toLowerCase();
        return people.stream()
                .filter(p -> p.getSurname() != null && p.getSurname().toLowerCase().contains(s))
                .collect(Collectors.toList());
    }
}
