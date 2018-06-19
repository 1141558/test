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
public class Workshop {

    /**
     * @return the wantToAttend
     */
    public List<Boolean> getWantToAttend() {
        return wantToAttend;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param durationInHours the durationInHours to set
     */
    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    /**
     * @param necessaryEquipment the necessaryEquipment to set
     */
    public void setNecessaryEquipment(List<String> necessaryEquipment) {
        this.necessaryEquipment = necessaryEquipment;
    }
    
    private String description;
    private int durationInHours;
    private List<Boolean> wantToAttend;
    private List<String> necessaryEquipment;

    public Workshop(String description, int durationInHours, List<String> necessaryEquipment) {
        this.description = description;
        this.durationInHours = durationInHours;
        this.necessaryEquipment = necessaryEquipment;
    }

    public Workshop() {
        this.necessaryEquipment= new ArrayList<>();
        this.wantToAttend= new ArrayList<>();
    }
    public void addAtendeeDecision(Boolean d){
        this.getWantToAttend().add(d);
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the durationInHours
     */
    public int getDurationInHours() {
        return durationInHours;
    }
    
}
