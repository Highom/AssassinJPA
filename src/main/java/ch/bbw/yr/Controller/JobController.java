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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {
    JobRepository jobRepository = new JobRepository();
    AssassinRepository assassinRepository = new AssassinRepository();
    TargetRepository targetRepository = new TargetRepository();
    WeaponRepository weaponRepository = new WeaponRepository();

    @GetMapping
    public String requestAssassinList(Model model) {
        List<Job> jobs =  jobRepository.getAllJobs();
        List<Assassin> assassins =  assassinRepository.getAllAssassins();
        List<Weapon> weapons = weaponRepository.getAllWeapons();

        Job job = new Job();
        Target target = new Target();

        model.addAttribute("job", job);
        model.addAttribute("assassins", assassins);
        model.addAttribute("jobs", jobs );
        model.addAttribute("target", target );
        model.addAttribute("weapons", weapons);
        return "job";
    }

    @PostMapping
    public String createJob(@RequestBody Job job){
        jobRepository.createJob(job);
        return  "redirect:/jobs";
    }

    @GetMapping("/edit")
    public String editJobForm(Model model, @RequestParam(name = "id", required = true)int id) {
        Object job = jobRepository.readJob(id);
        model.addAttribute(job);
        return "jobEdit";
    }

    @GetMapping("/edit/post")
    public String editJobPost(Job job) {
        jobRepository.updateJob(job);
        return  "redirect:/jobs";
    }

    @GetMapping("/delete")
    public String deleteJob(@RequestParam(name = "id", required = true)int id) {
        jobRepository.deleteJob(id);
        return  "redirect:/jobs";
    }
}
