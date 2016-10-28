package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(){
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	//add a init method
	public void doMyStartStuff(){
		System.out.println("TrackCoach: inside method doMyStartStuff()");
	}
	
	//add a destroy method
	public void doMyCleanupStuff(){
		System.out.println("TrackCoach: inside method doMyCleanupStuff()");
	}
}
