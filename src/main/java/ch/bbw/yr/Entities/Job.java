/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="job")
@NamedQuery(name="Job.findAll", query="SELECT e FROM Job e")
public class Job {
    @Id @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    @ManyToOne
    private Assassin assassin;

    @OneToOne
    private Target target;

    @ManyToMany
    private List<Weapon> weaponsUsed;

    public Job() {
    }

    public Job(Assassin assassin, Target target, List<Weapon> weaponsUsed) {
        this.assassin = assassin;
        this.target = target;
        this.weaponsUsed = weaponsUsed;
    }

    public int getId() {
        return id;
    }
}
