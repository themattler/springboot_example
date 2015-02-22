package com.embryonic.springy.model;

import com.google.common.base.Objects;

public class Person {

	private String id;

	private String name;
	private Integer age;

	public Person() {
	}

	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person) obj;
			return Objects.equal(name, other.name)
					&& Objects.equal(age, other.age);
		} else {
			return false;
		}
	}
}
