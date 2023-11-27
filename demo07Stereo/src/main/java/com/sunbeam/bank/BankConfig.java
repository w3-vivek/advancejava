package com.sunbeam.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sunbeam.AccountImpl;
import com.sunbeam.ConsoleLogger;
import com.sunbeam.Filelogger;


@Configuration
public class BankConfig {
@Bean
public AccountImpl acc() {
	AccountImpl a=new AccountImpl();
	a.setId(202);
	a.setBalance(40000);
	a.setType("saving");
	return a;
}

}
