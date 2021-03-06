/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.entities.Weapon;
import ch.bbw.yr.repositories.WeaponRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/weapons")
public class WeaponController {
    WeaponRepository weaponRepository = new WeaponRepository();

    List<Weapon> weapons = weaponRepository.getAllWeapons();

    @GetMapping
    public String getAllWeapons(Model model) {
        Weapon weapon = new Weapon();

        model.addAttribute("weapon", weapon);
        model.addAttribute("weapons", weapons);
        return "weapon";
    }

    @PostMapping
    public String createWeapon(Weapon weapon){
        weaponRepository.createWeapon(weapon);
        return  "redirect:/weapons";
    }

    @GetMapping("/edit")
    public String editWeaponForm(Model model, @RequestParam(name = "id", required = true)int id) {
        Object weapon = weaponRepository.readWeapon(id);
        model.addAttribute(weapon);
        return "weaponEdit";
    }

    @GetMapping("/edit/post")
    public String editWeaponPost(Weapon weapon) {
        weaponRepository.updateWeapon(weapon);
        return  "redirect:/weapons";
    }

    @GetMapping("/delete")
    public String deleteWeapon(@RequestParam(name = "id", required = true)int id) {
        weaponRepository.deleteWeapon(id);
        return  "redirect:/weapons";
    }
}