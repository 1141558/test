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
public class ApplicationRegister {
    
        private List<Application> ApplicationList;

    public ApplicationRegister() {
        this.ApplicationList= new ArrayList<>(); 
    }

    public ApplicationRegister(List<Application> ApplicationList) {
        this.ApplicationList = ApplicationList;
    }

        
    /**
     * @return the ApplicationList
     */
    public List<Application> getApplicationList() {
        return ApplicationList;
    }

    /**
     * @param ApplicationList the ApplicationList to set
     */
    public void setApplicationList(List<Application> ApplicationList) {
        this.ApplicationList = ApplicationList;
    }

}
