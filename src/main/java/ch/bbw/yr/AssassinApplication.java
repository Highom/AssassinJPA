package main.java.ch.bbw.yr;

import main.java.ch.bbw.yr.model.repositories.AssassinRepository;
import main.java.ch.bbw.yr.model.repositories.JobRepository;
import main.java.ch.bbw.yr.model.repositories.TargetRepository;
import main.java.ch.bbw.yr.model.repositories.WeaponRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssassinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssassinApplication.class, args);

		AssassinRepository assassinRepository = new AssassinRepository();
		assassinRepository.setup();

		JobRepository jobRepository = new JobRepository();
		jobRepository.setup();

		TargetRepository targetRepository = new TargetRepository();
		targetRepository.setup();

		WeaponRepository weaponRepository = new WeaponRepository();
		weaponRepository.setup();
	}

}
