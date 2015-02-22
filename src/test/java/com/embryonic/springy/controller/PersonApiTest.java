package com.embryonic.springy.controller;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

import com.embryonic.springy.Application;
import com.embryonic.springy.model.Person;



@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = Application.class)
public class PersonApiTest {
	private final String TEST_URL = "http://localhost:8080";

	private PersonApi personApi = new RestAdapter.Builder()
			.setEndpoint(TEST_URL).setLogLevel(LogLevel.FULL).build().create(PersonApi.class);
	
	Person person = new Person("Paul", 29);
	
	@Test
	public void testPersonAddAndList() {
		
		personApi.addPerson(person);
		
		Collection<Person> persons = personApi.getPersons();
		Assert.assertTrue(persons.contains(person));		
	}
	
}
