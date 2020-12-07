package com.jcabujat.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {
	
	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	private FortuneService fortuneService;
	
	// Setter/Method injection
	@Autowired
	@Qualifier("randomFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
//	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Study pawn positions";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public void printEmailAndTeam() {
		System.out.println(email + " : " + team);
		
	}
	
	
		

}
