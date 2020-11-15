package ch.bbw.yr;

import ch.bbw.yr.repositories.AssassinRepository;
import ch.bbw.yr.repositories.JobRepository;
import ch.bbw.yr.repositories.TargetRepository;
import ch.bbw.yr.repositories.WeaponRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssassinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssassinApplication.class, args);
	}

}
