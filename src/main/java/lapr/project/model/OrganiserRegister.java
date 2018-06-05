/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;

/**
 *
 * @author MariaJoão
 */
public class OrganiserRegister {
        private ArrayList<Organiser> organiserList;

    public OrganiserRegister(ArrayList<Organiser> organiserList) {
        this.organiserList = organiserList;
    }

    public OrganiserRegister() {
        
        this.organiserList= new ArrayList<Organiser>();
    }

    /**
     * @return the organiserList
     */
    public ArrayList<Organiser> getOrganiserList() {
        return organiserList;
    }

    /**
     * @param organiserList the organiserList to set
     */
    public void setOrganiserList(ArrayList<Organiser> organiserList) {
        this.organiserList = organiserList;
    }

}
