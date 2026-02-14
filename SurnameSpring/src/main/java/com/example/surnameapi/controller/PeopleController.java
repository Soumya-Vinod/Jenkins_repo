package com.example.surnameapi.controller;

import com.example.surnameapi.model.Person;
import com.example.surnameapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private final PersonService personService;

    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public ResponseEntity<Object> getBySurname(@RequestParam(value = "surname", required = false) String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            Map<String, String> err = new HashMap<>();
            err.put("error", "Missing required query parameter: surname");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
        }

        List<Person> matched = personService.findBySurnameExact(surname);

        Map<String, Object> body = new HashMap<>();
        body.put("count", matched.size());
        body.put("results", matched);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/people/search")
    public ResponseEntity<Object> searchBySurname(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.trim().isEmpty()) {
            Map<String, String> err = new HashMap<>();
            err.put("error", "Missing required query parameter: q");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
        }
        List<Person> matched = personService.findBySurnameContains(q);

        Map<String, Object> body = new HashMap<>();
        body.put("count", matched.size());
        body.put("results", matched);
        return ResponseEntity.ok(body);
    }
}
