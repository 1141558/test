/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MariaJoão
 */
public class StandRegister {
    
        private List<Stand> organiserList;

    public StandRegister(List<Stand> organiserList) {
        this.organiserList = organiserList;
    }

    public StandRegister() {
        this.organiserList= new ArrayList<>();
    }

    /**
     * @return the organiserList
     */
    public List<Stand> getOrganiserList() {
        return organiserList;
    }

    /**
     * @param organiserList the organiserList to set
     */
    public void setOrganiserList(List<Stand> organiserList) {
        this.organiserList = organiserList;
    }

}
