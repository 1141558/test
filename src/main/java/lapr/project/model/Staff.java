/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author André Silva
 */
public class Staff implements Comparable<Staff>, Serializable{
    
    private User staff;

    /**
     * @return the staff
     */
    public User getStaff() {
        return staff;
    }

    public Staff() {
        this.staff = new User();
    }

    public Staff(User staff) {
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
        Staff otherStaff = (Staff) otherObject;
        
        return staff == otherStaff.staff;
    }

    @Override
    public int compareTo(Staff o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
