/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Assassin;
import ch.bbw.yr.Entities.Job;
import ch.bbw.yr.Entities.Target;
import ch.bbw.yr.repositories.AssassinRepository;
import ch.bbw.yr.repositories.JobRepository;
import ch.bbw.yr.repositories.TargetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/targets")
public class TargetController {
    TargetRepository targetRepository = new TargetRepository();

    List<Target> targets = targetRepository.getAllTargets();

    @GetMapping
    public String requestJobList(Model model) {
        model.addAttribute("targets", targets);
        return "target";
    }

    @PostMapping
    public void createTarget(@RequestBody Target target){
        targetRepository.createTarget(target);
        targetRepository.closeup();
    }
}
