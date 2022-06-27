package com.example.demo.member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;

@Configuration
public class MemberConfig {

	@Bean
	CommandLineRunner commandLineRunner(
			MemberRepository repository) {
		return args -> {
			Member user01 = new Member(
					"user01",
					"user01@email.com",
					LocalDate.of(2000, JANUARY, 5),
					21
			);
			
			Member user02 = new Member(
					"user02",
					"user02@email.com",
					LocalDate.of(2001, JANUARY, 5),
					21
			);
			
			repository.saveAll(
					List.of(user01, user02)
			);
		};
	}
}
