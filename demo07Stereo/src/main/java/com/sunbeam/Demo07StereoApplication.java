package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
@ComponentScan("com.sunbeam.bank")
@SpringBootApplication
public class Demo07StereoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Demo07StereoApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		Logger l=  ctx.getBean(ConsoleLogger.class);
		  l.log("i am on console");
		Logger l2=ctx.getBean(Filelogger.class);
		l2.log("i am in file");
		
		Logger l3=ctx.getBean(Logger.class);
		
		AccountImpl a=(AccountImpl) ctx.getBean("acc");
		
		a.setLogger(l);//consolelogger is set
		a.deposit(2000);
		a.withdraw(1000);
		
		a.setLogger(l2);//filelogger is set
		a.deposit(1000);
		a.withdraw(20000);
		
		System.out.println("final balance:"+a.getBalance());
	
	}

}
