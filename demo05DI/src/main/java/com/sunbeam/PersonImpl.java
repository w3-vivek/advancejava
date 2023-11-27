package com.sunbeam;

public class PersonImpl implements Person {
private int age ;
private String name;
public int getAge() {
	return age;
}

public PersonImpl() {
	
}

public PersonImpl(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}

public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "PersonImpl [age=" + age + ", name=" + name + "]";
}


}
