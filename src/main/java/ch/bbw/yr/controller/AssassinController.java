/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.entities.Assassin;
import ch.bbw.yr.repositories.AssassinRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assassins")
public class AssassinController {
    AssassinRepository assassinRepository = new AssassinRepository();

    List<Assassin> assassins = assassinRepository.getAllAssassins();

    @GetMapping
    public String getAllAssassins(Model model) {
        Assassin assassin = new Assassin();

        model.addAttribute("assassin", assassin);
        model.addAttribute("assassins", assassins);
        return "assassin";
    }

    @PostMapping
    public String createAssassin(@RequestBody Assassin assassin){
        assassinRepository.createAssassin(assassin);
        assassinRepository.closeup();
        return  "redirect:/assassins";
    }

    @GetMapping("/edit")
    public String editAssassinForm(Model model, @RequestParam(name = "id", required = true)int id) {
        Object assassin = assassinRepository.readAssassin(id);
        model.addAttribute(assassin);
        return "assassinEdit";
    }

    @GetMapping("/edit/post")
    public String editAssassinPost(Assassin assassin) {
        assassinRepository.updateAssassin(assassin);
        return  "redirect:/assassins";
    }

    @GetMapping("/delete")
    public String deleteAssassin(@RequestParam(name = "id", required = true)int id) {
        assassinRepository.deleteAssassin(id);
        return  "redirect:/assassins";
    }
}
