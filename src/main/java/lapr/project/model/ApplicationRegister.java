/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public boolean addApplication(Application a){
        return this.ApplicationList.add(a);
    }    
    /**
     * @return the ApplicationList
     */
    public List<Application> getApplicationList() {
        return ApplicationList;
    }
    
    @Override
    public boolean equals(Object o){
        ApplicationRegister other= (ApplicationRegister)o;

       
        return this.ApplicationList.equals(other.getApplicationList());
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.ApplicationList);
        return hash;
    }
    /**
     * @param ApplicationList the ApplicationList to set
     */
    public void setApplicationList(List<Application> ApplicationList) {
        this.ApplicationList = ApplicationList;
    }

}
