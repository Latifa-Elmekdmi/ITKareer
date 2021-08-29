package com.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.platform.Entity.Client;
import com.platform.Entity.Coach;
import com.platform.dao.ClientRepository;
import com.platform.dao.CoachRepository;
import com.platform.dao.UserRepository;

@SpringBootApplication
public class CoachingPlatformApplication  implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository ; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CoachRepository coachRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoachingPlatformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// clientRepository.save(Client());
		
		//userRepository.save(new User())
		coachRepository.save(new Coach("elmekdmi", "latifa", "0762701129", "I am a professional lifestyle coach ", "Harvard university"));
		coachRepository.findAll().forEach(c -> {
			System.out.println(c.toString());
		});
		System.out.println("*******************************************************************");
	
		
	}

}
