package com.franzoso.kafka.controller;

import com.franzoso.kafka.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.franzoso.domain.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @PostMapping
    ResponseEntity<Void> createEvent(@RequestBody PersonDTO personDTO) {
        personService.createEvent(personDTO);
        return ResponseEntity.ok().build();
    }

}
