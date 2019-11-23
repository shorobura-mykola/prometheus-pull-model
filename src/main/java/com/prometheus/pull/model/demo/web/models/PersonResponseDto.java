package com.prometheus.pull.model.demo.web.models;

import com.prometheus.pull.model.demo.dao.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDto {
    private String firstName;
    private String lastName;
    private String email;

    public PersonResponseDto(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
    }
}
