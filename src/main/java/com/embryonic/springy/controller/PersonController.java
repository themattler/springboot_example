package com.embryonic.springy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embryonic.springy.model.Person;
import com.embryonic.springy.repository.PersonRepository;

@RestController
public class PersonController implements PersonApi {

	@Autowired
	private PersonRepository repo;
	
	@Override
	@RequestMapping(value = PersonApi.PERSON_SVC_PATH, method = RequestMethod.GET)
	public Collection<Person> getPersons() {
		return repo.findAll();
	}

	@Override
	@RequestMapping(value = PersonApi.PERSON_SVC_PATH, method = RequestMethod.POST)
	public Boolean addPerson(@RequestBody Person person) {
		repo.save(person);
		return true;
	}

	@Override
	@RequestMapping(value = PersonApi.NAME_SEARCH_PATH, method = RequestMethod.GET)
	public Collection<Person> findByName(@RequestParam(PersonApi.NAME_PARAMETER) String name) {
		return repo.findByName(name);
	}

	@Override
	@RequestMapping(value = PersonApi.AGE_SEARCH_PATH, method = RequestMethod.GET)
	public Collection<Person> findByAge(@RequestParam(PersonApi.VALUE_PARAMETER) int age) {
		return repo.findByAge(age);
	}

}
