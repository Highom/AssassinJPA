package main.java.ch.bbw.yr;

import main.java.ch.bbw.yr.model.AssassinRepository;
import main.java.ch.bbw.yr.model.Entities.Assassin;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssassinApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AssassinApplication.class, args);

		AssassinRepository assassinRepository = new AssassinRepository();
		assassinRepository.setup();
		assassinRepository.createAssassin(new Assassin("Agent Smith",21));
		System.out.println(assassinRepository.getAllAssassins());
	}

}
