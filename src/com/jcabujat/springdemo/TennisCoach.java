package com.jcabujat.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // default scope is singleton
public class TennisCoach implements Coach {
	
	// Field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Tennis coach constructor");
	}
	
	/*
	// Constructor injection
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public void printEmailAndTeam() {
		// TODO Auto-generated method stub
		
	}
	
	// define init method
	@PostConstruct
	public void startUpMethod() {
		System.out.println("perform some start up process");
	}
	
	// define destroy method
	@PreDestroy // not called if bean scope is "prototype"
	public void destroyMethod() {
		System.out.println("perform some pre destroy process");
	}

}
