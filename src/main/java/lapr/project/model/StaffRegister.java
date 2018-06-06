/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author André Silva
 */
public class StaffRegister implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private List<StaffMember> staffList;
    
    public StaffRegister(){
        this.staffList = new ArrayList<>();
    }

    public StaffRegister(StaffRegister staffList) {
        this.staffList = new ArrayList<>(staffList.getListStaff());
    }
    
    public List<StaffMember> getListStaff(){
        return new ArrayList<>(staffList);
    }
    
    /**
     *
     * @param indice
     * @return staff
     */
    public StaffMember getStaff(int indice){
        return staffList.get(indice);
    }
    
    /**
     *
     * @param staff
     * @return true or false
     * Valida se já existe o staff passado por parametro, caso não exista adiciona à List
     */
    public boolean registerStaff(StaffMember staff){
        return staffList.contains(staff)
               ? false
               :staffList.add(staff);
    }
    
    public boolean isEmpty() {
        return staffList.isEmpty();
    }
    
    @Override
    public String toString() {
        List<StaffMember> copy = new ArrayList<>(staffList);
        Collections.sort(copy);

        StringBuilder s = new StringBuilder();
        for (StaffMember staff : copy) {
            s.append(staff);
            s.append("\n");
        }
        
        return s.toString().trim();
    }
    
 
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StaffRegister otherStaffRegister = (StaffRegister) otherObject;

        List<StaffMember> copyThis = new ArrayList<>(staffList);
        List<StaffMember> copyOther = new ArrayList<>( otherStaffRegister.staffList);

        return copyThis.equals(copyOther);
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.staffList);
        return hash;
    }
    
}
