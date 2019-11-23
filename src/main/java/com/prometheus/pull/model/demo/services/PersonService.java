package com.prometheus.pull.model.demo.services;

import com.prometheus.pull.model.demo.dao.model.Person;
import com.prometheus.pull.model.demo.web.models.PersonResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Person save(Person person);

    PersonResponseDto findOne(int id);

    List<PersonResponseDto> findAll();

    void delete(int id);

}
