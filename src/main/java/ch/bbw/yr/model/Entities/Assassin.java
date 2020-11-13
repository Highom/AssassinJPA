/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package main.java.ch.bbw.yr.model.Entities;


import javax.persistence.*;

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

    public Assassin() {
    }

    public Assassin(String codename, int kills) {
        this.codename = codename;
        this.kills = kills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
