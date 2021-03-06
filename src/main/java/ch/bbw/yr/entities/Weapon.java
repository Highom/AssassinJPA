/**
 * @Author: Yannick Ruck
 * @Date: 13/11/2020
 */
package ch.bbw.yr.entities;

import javax.persistence.*;

@Entity
@Table(name = "weapon")
@NamedQuery(name = "Weapon.findAll", query = "SELECT e FROM Weapon e")
public class Weapon {
    @Id
    @GeneratedValue
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLethality() {
        return lethality;
    }

    public void setLethality(int lethality) {
        this.lethality = lethality;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lethality=" + lethality +
                '}';
    }
}
