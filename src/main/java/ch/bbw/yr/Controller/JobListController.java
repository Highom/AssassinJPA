/**
 * @Author: Yannick Ruck
 * @Date: 14/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Assassin;
import ch.bbw.yr.Entities.Job;
import ch.bbw.yr.Entities.Target;
import ch.bbw.yr.Entities.Weapon;
import ch.bbw.yr.FormObjects.JobForm;
import ch.bbw.yr.repositories.AssassinRepository;
import ch.bbw.yr.repositories.JobRepository;
import ch.bbw.yr.repositories.TargetRepository;
import ch.bbw.yr.repositories.WeaponRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/jobs")
public class JobListController {
    JobRepository jobRepository = new JobRepository();
    AssassinRepository assassinRepository = new AssassinRepository();
    TargetRepository targetRepository = new TargetRepository();
    WeaponRepository weaponRepository = new WeaponRepository();

    @GetMapping
    public String requestJobList(Model model) {
        List<Job> jobs =  jobRepository.getAllJobs();
        List<Assassin> assassins =  assassinRepository.getAllAssassins();
        List<Target> targets = targetRepository.getAllTargets();
        List<Weapon> weapons = weaponRepository.getAllWeapons();

        Job job = new Job();

        model.addAttribute("job", job);
        model.addAttribute("assassins", assassins);
        model.addAttribute("jobs", jobs );
        model.addAttribute("targets", targets );
        model.addAttribute("weapons", weapons);
        return "joblist";
    }

    @PostMapping
    public void createJob(@RequestBody JobForm formResult){
        Job job = new Job();

        job.setAssassin(assassinRepository.readAssassin(formResult.getAssassin()));
        job.setTarget(targetRepository.readTarget(formResult.getTarget()));
        job.setWeaponsUsed(formResult.getWeaponsUsed().stream().map(w -> weaponRepository.readWeapon(w)).collect(Collectors.toList()));

        jobRepository.createJob(job);

        jobRepository.closeup();
        assassinRepository.closeup();
        targetRepository.closeup();
        weaponRepository.closeup();
    }
}
