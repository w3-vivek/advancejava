package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//A component required a bean named 'p2' that could not be found.

@ComponentScan("com.dmc") //  to access bankconfig.java from another package
@ImportResource("classpath:beans.xml") //beans is created in different package hence 
@SpringBootApplication

public class Demo05DiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo05DiApplication.class, args);
	}
	@Autowired // it is used for just declaration of ApplicationContext
	private ApplicationContext ctx; // initialization handled by spring boot
	
	@Override
	public void run(String... args) throws Exception {
 
		
		Person p=(Person) ctx.getBean("p1");  //getBean gives object of type person hence type casted
		System.out.println("P1:"+p.toString());
		
		Account a1=(Account) ctx.getBean("a1");
		System.out.println("a1:"+a1.toString());
		
		Account a2=(Account) ctx.getBean("a2");
		System.out.println("a2");
		
		Person p2=(Person) ctx.getBean("p2");
		System.out.println("p2:"+p2.toString());
		
		Account a3=(Account) ctx.getBean("a3");
		System.out.println("a3:"+a3.toString());
		
		Account a4=(Account) ctx.getBean("a4");
		System.out.println("a4:"+a4.toString());
		
		Account a6=(Account) ctx.getBean("a6");
		System.out.println("a6:"+a6.toString());
		
		Account a7=(Account) ctx.getBean("a7");
		System.out.println("a7:"+a7.toString());
	}

}
