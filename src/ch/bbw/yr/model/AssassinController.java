/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssassinController {
    AssassinRepository assassinRepository = new AssassinRepository();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/assassins")
    public List<Assassin> allSql() {
        return assassinRepository.getAllAssassins();
    }

}
