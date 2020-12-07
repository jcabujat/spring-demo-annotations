package com.jcabujat.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] fortunes = {
			"Be careful",
			"Be brave!",
			"Stay put"
	};
	private Random random = new Random();

	@Override
	public String getFortune() {
		int num = random.nextInt(fortunes.length);
		return fortunes[num];
	}

}
