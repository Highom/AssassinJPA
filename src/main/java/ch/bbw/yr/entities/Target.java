/**
 * @Author: Yannick Ruck
 * @Date: 13/11/2020
 */
package ch.bbw.yr.entities;

import javax.persistence.*;

@Entity
@Table(name="target")
@NamedQuery(name="Target.findAll", query="SELECT e FROM Target e")
public class Target {
    @Id
    @GeneratedValue
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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
