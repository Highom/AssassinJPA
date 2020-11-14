/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="assassin")
@NamedQuery(name="Assassin.findAll", query="SELECT e FROM Assassin e")
public class Assassin {
    @Id @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "codename")
    private String codename;

    @Column(name = "kills")
    private int kills;

    @OneToMany(mappedBy = "assassin")
    private List<Job> jobs;

    public Assassin() {
    }

    public Assassin(String codename, int kills) {
        this.codename = codename;
        this.kills = kills;
    }

    public int getId() {
        return id;
    }
}
