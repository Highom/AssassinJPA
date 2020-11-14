/**
 * @Author: Yannick Ruck
 * @Date: 14/11/2020
 */
package ch.bbw.yr.model.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import main.java.ch.bbw.yr.model.Entities.Job;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobListController {
    Job myJob = new Job();

    @GetMapping("/jobs")
    public String requestJobList(Model model) {
        model.addAttribute("jobList", myJob );
        return "joblist";
    }
}
