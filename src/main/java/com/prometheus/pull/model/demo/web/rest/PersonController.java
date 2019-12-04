package com.prometheus.pull.model.demo.web.rest;

import com.prometheus.pull.model.demo.dao.model.Person;
import com.prometheus.pull.model.demo.services.PersonService;
import com.prometheus.pull.model.demo.web.models.PersonResponseDto;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private Counter counter;

    private final PersonService personService;

    public PersonController(PersonService personService, MeterRegistry meterRegistry) {
        this.personService = personService;
        this.counter = Counter.builder("test.request.counter")
                .tag("test.request.counter.tag", "test.request.counter.value")
                .register(meterRegistry);
    }

    @GetMapping
    public List<PersonResponseDto> getAllPerson() {
        counter.increment();
        return personService.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.save(person));
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
