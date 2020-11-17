/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Assassin;
import ch.bbw.yr.repositories.AssassinRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/assassins")
public class AssassinController {
    AssassinRepository assassinRepository = new AssassinRepository();

    List<Assassin> assassins = assassinRepository.getAllAssassins();

    @GetMapping
    public String requestJobList(Model model) {
        Assassin assassin = new Assassin();

        model.addAttribute("assassin", assassin);
        model.addAttribute("assassins", assassins);
        return "assassin";
    }

    @PostMapping
    public void createAssassin(@RequestBody Assassin assassin){
        assassinRepository.createAssassin(assassin);
        assassinRepository.closeup();
    }
}
