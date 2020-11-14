/**
 * @Author: Yannick Ruck
 * @Date: 14/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Assassin;
import ch.bbw.yr.Entities.Job;
import ch.bbw.yr.repositories.AssassinRepository;
import ch.bbw.yr.repositories.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobListController {
    JobRepository jobRepository = new JobRepository();
    AssassinRepository assassinRepository = new AssassinRepository();

    List<Job> jobs =  jobRepository.getAllJobs();
    List<Assassin> assassins =  assassinRepository.getAllAssassins();

    @GetMapping("/jobs")
    public String requestJobList(Model model) {
        model.addAttribute("assassins", assassins);
        model.addAttribute("jobs", jobs );
        return "joblist";
    }
}
