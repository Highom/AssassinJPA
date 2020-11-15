/**
 * @Author: Yannick Ruck
 * @Date: 14/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Assassin;
import ch.bbw.yr.Entities.Job;
import ch.bbw.yr.Entities.Target;
import ch.bbw.yr.Entities.Weapon;
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

        model.addAttribute("assassins", assassins);
        model.addAttribute("jobs", jobs );
        model.addAttribute("targets", targets );
        model.addAttribute("weapons", weapons);
        return "joblist";
    }

    @PostMapping
    public void createJob(@RequestBody Job job){
        jobRepository.createJob(job);

        jobRepository.closeup();
        assassinRepository.closeup();
        targetRepository.closeup();
        weaponRepository.closeup();
    }
}
