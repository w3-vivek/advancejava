package com.sunbeam;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Filelogger implements Logger{
    @Value("${logFilePath}")
	 private String logFilePath="msg.txt";
	 
	 
	public String getLogFilePath() {
		return logFilePath;
	}


	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}


	@Override
	public void log(String msg) {
		try(FileOutputStream fout=new FileOutputStream(logFilePath,true))
		{
			try(PrintWriter pw=new PrintWriter(fout)){
				pw.println("File:"+msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


		
		

		
	}


