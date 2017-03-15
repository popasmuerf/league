package io.mdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mikeyb on 3/5/17.
 */
@Entity
public class Teammate {
    @Id @GeneratedValue
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String posistion ;
    @ManyToOne
    private Team team ;
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPosistion() {
        return posistion;
    }
    public void setPosistion(String posistion) {
        this.posistion = posistion;
    }
    private Teammate(){
    }
    public Teammate(String firstName,String lastName){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        //return id + ": " + firstName + " " + lastName + " is playing " + posistion + " for the " + team.getName();
        return id.toString()  + ": " + firstName + " "+ lastName + " is playing "+ posistion+ " for the " + team.getName();
    }

}
