package com.prometheus.pull.model.demo.web.rest;

import com.prometheus.pull.model.demo.dao.model.Person;
import com.prometheus.pull.model.demo.services.PersonService;
import com.prometheus.pull.model.demo.web.models.PersonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        return  ResponseEntity.ok(personService.save(person));
    }

    @GetMapping
    public List<PersonResponseDto> getAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> getPerson(@PathVariable int id) {
        return ResponseEntity.ok(personService.findOne(id));
    }


    @DeleteMapping
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        personService.delete(id);
        return ResponseEntity.ok("PersonRequestDto with id : " + id + " removed");
    }
}
