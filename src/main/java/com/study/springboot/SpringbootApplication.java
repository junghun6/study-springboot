package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

		Friend friend = new Friend("park");

		System.out.println(friend.name);

	}

}

class Friend {
	String name = "kim";
	int age = 20;

	Friend (String i) {
		this.name = i;
	}
}
