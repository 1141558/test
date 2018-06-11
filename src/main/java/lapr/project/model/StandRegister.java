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
    
    private List<Stand> standList;

    public StandRegister(List<Stand> organiserList) {
        this.standList = organiserList;
    }

    public StandRegister() {
        this.standList= new ArrayList<>();
    }

    /**
     * @return the standList
     */
    public List<Stand> getStandList() {
        return standList;
    }

    /**
     * @param standList the standList to set
     */
    public void setStandList(List<Stand> standList) {
        this.standList = standList;
    }
    public boolean addStand(Stand s){
        return this.standList.add(s);
    }
}
