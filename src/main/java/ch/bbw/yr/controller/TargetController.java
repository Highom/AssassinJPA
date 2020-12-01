/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.entities.Target;
import ch.bbw.yr.repositories.TargetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/targets")
public class TargetController {
    TargetRepository targetRepository = new TargetRepository();

    List<Target> targets = targetRepository.getAllTargets();

    @GetMapping
    public String getAllTargets(Model model) {
        Target target = new Target();

        model.addAttribute("target", target);
        model.addAttribute("targets", targets);
        return "target";
    }

    @PostMapping
    public String createTarget(@RequestBody Target target){
        targetRepository.createTarget(target);
        targetRepository.closeup();
        return  "redirect:/targets";
    }

    @GetMapping("/edit")
    public String editTargetForm(Model model, @RequestParam(name = "id", required = true)int id) {
        Object target = targetRepository.readTarget(id);
        model.addAttribute(target);
        return "targetEdit";
    }

    @GetMapping("/edit/post")
    public String editTargetPost(Target target) {
        targetRepository.updateTarget(target);
        return  "redirect:/targets";
    }

    @GetMapping("/delete")
    public String deleteTarget(@RequestParam(name = "id", required = true)int id) {
        targetRepository.deleteTarget(id);
        return  "redirect:/targets";
    }
}
