package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//Create an array of strings
	private String[] data = {
			"Good Day",
			"Bad Day",
			"Normal Day"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick a random String from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
