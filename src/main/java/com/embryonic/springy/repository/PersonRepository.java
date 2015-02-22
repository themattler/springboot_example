package com.embryonic.springy.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.embryonic.springy.controller.PersonApi;
import com.embryonic.springy.model.Person;

@Component
public interface PersonRepository extends MongoRepository<Person, Long> {

	public Collection<Person> findByName(
			@Param(PersonApi.NAME_PARAMETER) String name);

	public Collection<Person> findByAge(
			@Param(PersonApi.VALUE_PARAMETER) int age);

}
