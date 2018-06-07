/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Organiser extends User implements  Serializable{
    
    private static final long serialVersionUID = 1L;
 
    private User organiser = new User();
    private User orUser = new User();

    /**
     * @return the organiser
     */
    public User getOrganiser() {
        return organiser;
    }

    public Organiser() {
        this.organiser = new User();
    }

    public Organiser(String nome, String email, String userName, double pass){
        super(nome,email,userName,pass);
    }
    public Organiser(User organiser) {
        this.organiser = organiser;
    }

    /**
     * @param organiser the organiser to set
     */
    public void setOrganiser(User organiser) {
        this.organiser = organiser;
    }
    
    @Override
    public String toString() {
        return String.format("UserName:%s Nome:%s", organiser.getUsername(), organiser.getName());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Organiser otherOrganiser = (Organiser) otherObject;
        
        return organiser == otherOrganiser.organiser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.organiser);
        return hash;
    }
    
//    @Override
//    public int compareTo(Organiser otherOrganiser) {
//        return this.organiser.getUsername().compareTo(otherOrganiser.organiser.getUsername());
//    }
    
}
