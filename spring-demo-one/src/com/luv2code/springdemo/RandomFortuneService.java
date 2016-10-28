package com.luv2code.springdemo;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"¤¿","¦N","¤j¦N"};
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortunes[randomWithRange(0,2)];
	}
	
	private int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

}
