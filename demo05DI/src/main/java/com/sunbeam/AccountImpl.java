package com.sunbeam;

public class AccountImpl implements Account {
private int id;
private String type;
private double balance;
private Person person;


public AccountImpl() {
	super();
	// TODO Auto-generated constructor stub
}


public AccountImpl(int id, String type, double balance, Person person) {
	super();
	this.id = id;
	this.type = type;
	this.balance = balance;
	this.person = person;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}


public Person getPerson() {
	return person;
}


public void setPerson(Person person) {
	this.person = person;
}


@Override
public String toString() {
	return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", person=" + person + "]";
}


@Override
public void setBalance(int balance) {
	// TODO Auto-generated method stub
	
}


}
