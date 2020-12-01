/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.entities;


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

    public void setId(int id) {
        this.id = id;
    }

    public Assassin getAssassin() {
        return assassin;
    }

    public void setAssassin(Assassin assassin) {
        this.assassin = assassin;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<Weapon> getWeaponsUsed() {
        return weaponsUsed;
    }

    public void setWeaponsUsed(List<Weapon> weaponsUsed) {
        this.weaponsUsed = weaponsUsed;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", assassin=" + assassin +
                ", target=" + target +
                ", weaponsUsed=" + weaponsUsed +
                '}';
    }
}
