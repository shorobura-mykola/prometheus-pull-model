package com.prometheus.pull.model.demo.dao.repositories;

import com.prometheus.pull.model.demo.dao.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Integer> {

}
