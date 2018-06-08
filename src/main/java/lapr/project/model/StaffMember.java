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
 * @author André Silva
 */
public class StaffMember implements Comparable<StaffMember>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    private User staff;
   
   

    /**
     * @return the staff
     */
    public User getStaffUser() {
        return staff;
    }

    public StaffMember() {
        this.staff = new User();
    }

    public StaffMember(User staff) {
        this.staff = staff;
    }

    /**
     * @param staff the staff to set
     */
    public void setStaff(User staff) {
        this.staff = staff;
    }
    
    @Override
    public String toString() {
        return String.format("UserName:%s Nome:%s", staff.getUsername(), staff.getName());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StaffMember otherStaff = (StaffMember) otherObject;
        
        return staff == otherStaff.staff;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.staff);
        return hash;
    }

    @Override
    public int compareTo(StaffMember otherStaff) {
        return this.staff.getUsername().compareTo(otherStaff.staff.getUsername());
    }

    
}
