package com.embryonic.springy.controller;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

import com.embryonic.springy.model.Person;

public interface PersonApi {
	public static final String NAME_PARAMETER = "name";
	
	public static final String VALUE_PARAMETER = "age";

	public static final String PERSON_SVC_PATH = "/person";

	public static final String NAME_SEARCH_PATH = PERSON_SVC_PATH + "/search/findByName";
	
	public static final String AGE_SEARCH_PATH = PERSON_SVC_PATH + "/search/findByAge";

	@GET(PERSON_SVC_PATH)
	public Collection<Person> getPersons();
	
	@POST(PERSON_SVC_PATH)
	public Boolean addPerson(@Body Person person);
	
	@GET(NAME_SEARCH_PATH)
	public Collection<Person> findByName(@Query(NAME_PARAMETER) String name);
	
	@GET(AGE_SEARCH_PATH)
	public Collection<Person> findByAge(@Query(VALUE_PARAMETER) int age);
	
}
