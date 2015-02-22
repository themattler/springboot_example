package com.embryonic.springy.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.embryonic.springy.model.Person;
import com.embryonic.springy.repository.PersonRepository;

public class PersonControllerTest {

	@Mock
	private PersonRepository repo;
	
	@InjectMocks
	private PersonController personController;
	
	private Person person;
	
	
	@Before
	public void setUp() {
		person = new Person() {{
			setName("age"); setAge(33);
		}};
		MockitoAnnotations.initMocks(this);

		when(repo.findAll()).thenReturn(Arrays.asList(person));
	}
	
	@Test
	public void test() {
		Collection<Person> persons = personController.getPersons();
		Assert.assertTrue(persons.contains(person));
	}
	
}
