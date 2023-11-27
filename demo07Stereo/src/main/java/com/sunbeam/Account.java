package com.sunbeam;

public interface Account {
	
		int getId();
		void setId(int id);
		double getBalance();
		void setBalance(double balance);
	
		String getType();
		void setType(String type);
		Logger getLogger();
		void setLogger(Logger logger);
		void deposit(double amount);
		void withdraw(double amount);
}
