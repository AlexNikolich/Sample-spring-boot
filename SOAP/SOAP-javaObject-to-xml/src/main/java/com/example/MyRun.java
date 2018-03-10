package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRun implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		
		Hello h = new Hello();
    	h.make( "Bonjour, madame", "fr" ); 
    	h.make( "Hey, you", "en" ); 
    	System.out.println("Marshal is starting!!!");
    	h.marshal();
    	

		
	}

	
}