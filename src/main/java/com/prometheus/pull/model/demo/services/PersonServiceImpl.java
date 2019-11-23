package com.prometheus.pull.model.demo.services;

import com.prometheus.pull.model.demo.dao.model.Person;
import com.prometheus.pull.model.demo.dao.repositories.PersonRepository;
import com.prometheus.pull.model.demo.web.models.PersonResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public PersonResponseDto findOne(int id) {
		Person person = personRepository.getOne(id);
		return new PersonResponseDto(person);
	}

	@Override
	public List<PersonResponseDto> findAll() {
		return personRepository.findAll().stream()
				.map(PersonResponseDto::new)
				.collect(toList());
	}

	@Override
	public void delete(int id) {
		personRepository.deleteById(id);
	}
}
