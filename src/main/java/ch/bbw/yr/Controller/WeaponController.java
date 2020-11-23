/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.Controller;

import ch.bbw.yr.Entities.Weapon;
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
    public String requestJobList(Model model) {
        Weapon weapon = new Weapon();

        model.addAttribute("weapon", weapon);
        model.addAttribute("weapons", weapons);
        return "weapon";
    }

    @PostMapping
    public void createWeapon(Weapon weapon){
        weaponRepository.createWeapon(weapon);
    }

    @GetMapping("/edit")
    public String editWeaponForm(Model model, @RequestParam(name = "id", required = true)int id) {
        model.addAttribute("weapon",weaponRepository.readWeapon(id));
        return "weaponEdit";
    }

    @GetMapping("/edit/post")
    public void editWeaponPost(Weapon weapon) {
        weaponRepository.updateWeapon(weapon);
    }

    @GetMapping("/delete")
    public void deleteWeapon(@RequestParam(name = "id", required = true)int id) {
        weaponRepository.deleteWeapon(id);
    }
}