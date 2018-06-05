/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author MariaJoão
 */
public class Organiser {
 
    private User organiser;

    /**
     * @return the organiser
     */
    public User getOrganiser() {
        return organiser;
    }

    public Organiser() {
        this.organiser = new User();
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
    
}
