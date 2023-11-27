package com.dmc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sunbeam.Account;
import com.sunbeam.AccountImpl;
import com.sunbeam.Person;
import com.sunbeam.PersonImpl;

@Configuration
public class BankConfig {

	@Bean
	public Person p2() {
		Person p=new PersonImpl();
		p.setAge(24);
		p.setName("samyak");
		return p;
	}
	
	@Bean
	public Account a3() {
		Account a=new AccountImpl();
		a.setId(303);
		a.setPerson(p2());
		a.setType("saving");
		a.setBalance(13000);
		return  a;
		
	}
	
	@Bean
	public Account a4() {
		Account a=new AccountImpl(404,"current",5200,p2());
		return a;
	}
	
	//method a5 in com.sunbeam.BankConfig required a single bean, but 2 were found:
	//@Bean
//	public Account a5(Person p) {//inject accHolder via @Bean method param.
//		Account a=new AccountImpl(405,"current",45890,p);
//		return a;
//	}
	//Resolve the conﬂict by name and by using @Qualiﬁer.
	
	@Bean
	public Account a6(Person p2) {// inject p2 by name
		Account a= new AccountImpl(505,"current",100000,p2);
	return a;	
	}
	
	@Bean
	public Account a7(@Qualifier("p1") Person p)//inject p1 bean (by qualifier)
	{
		Account a=new AccountImpl(606,"saving",58989,p);
		return a;
	}
}
