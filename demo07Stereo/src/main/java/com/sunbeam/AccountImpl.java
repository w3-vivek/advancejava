package com.sunbeam;



public class AccountImpl implements Account {
	
		private int id;
		private String type;
		private double balance;
		private Logger logger;
		
		public AccountImpl() {
		
		}

		public AccountImpl(int id, String type, double balance, Logger logger) {
			this.id = id;
			this.type = type;
			this.balance = balance;
			this.logger = logger;
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

		public Logger getLogger() {
			return logger;
		}

		public void setLogger(Logger logger) {
			this.logger = logger;
		}

		@Override
		public String toString() {
			return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + "]";
		}
		
		public void deposit(double amount) {
			if(logger != null)
				logger.log("Rs. " + amount + "/- deposited to account id " + this.id);
			this.balance = this.balance + amount;
		}
		
		public void withdraw(double amount) {
			if(logger != null)
				logger.log("Rs. " + amount + "/- withdrawn from account id " + this.id);
			this.balance = this.balance - amount;
		}

		
}
