/**
 * @Author: Yannick Ruck
 * @Date: 13/11/2020
 */
package main.java.ch.bbw.yr.model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "weapons")
@NamedQuery(name = "Weapons.findall", query = "SELECT e FROM Weapons e")
public class Weapon {
    @Id @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lethality")
    private int lethality;

    public Weapon() {
    }

    public Weapon(String name, int lethality) {
        this.name = name;
        this.lethality = lethality;
    }

    public int getId() {
        return id;
    }
}
