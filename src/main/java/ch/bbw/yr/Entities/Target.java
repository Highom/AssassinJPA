/**
 * @Author: Yannick Ruck
 * @Date: 13/11/2020
 */
package ch.bbw.yr.Entities;

import javax.persistence.*;

@Entity
@Table(name="target")
@NamedQuery(name="Target.findAll", query="SELECT e FROM Target e")
public class Target {
    @Id @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    public Target() {

    }

    public Target(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }
}
