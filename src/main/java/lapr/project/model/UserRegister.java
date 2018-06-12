/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class UserRegister {
    
    private List<User> userList;
    
    /**
     * Constructor
     *
     * @param userList List of user to be considered
     */
    public UserRegister(List<User> userList) {
        this.userList = userList;
    }
    
    /**
     * Constructor
     */
    public UserRegister() {
        this.userList = new ArrayList<>();
    }
    
    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }
    
    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    /**
     *
     * @param user to be added
     * @return boolean value according to the user add
     */
    public boolean addUser(User user) {
        if (userExists(user)) {
            return false;
        } else {
            this.userList.add(user);
            return true;
        }
//        return this.userList.add(user);
//        return ((userExists(user) ? false : this.userList.add(user)));
    }
    
    /**
     * Method to check if the user already exists
     *
     * @param user User to be validated
     * @return boolean value relative to the user existence
     */
    public boolean userExists(User user) {
        //email e username são únicos no sistema
        for (User temp : this.userList) {
            if (temp.getUsername().equals(user.getUsername())) {
                return true;
            }
            if (temp.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
    
    public List<User> getAvailableUsersWithoutOrganisers(List<Organiser> organisers) {
        List<User> usersExhibitionCentreCopyWithoutOrganisers = new ArrayList<>();
        usersExhibitionCentreCopyWithoutOrganisers = Utils.getCopia(this.userList);
        
        List<User> usersToRemove = new ArrayList<>();
        
        for (Organiser org : organisers) {
            
            for (User user : usersExhibitionCentreCopyWithoutOrganisers) {
                if (user.equalsUser(org.getOrganiser())) {
                    usersToRemove.add(user);
                    
                }
                
            }
            
        }
        
        usersExhibitionCentreCopyWithoutOrganisers.removeAll(usersToRemove);
        return usersExhibitionCentreCopyWithoutOrganisers;
    }
    
    public List<User> getAvailableUsersWithoutStaffMember(List<StaffMember> staffList, List<User> filterUserRegisterByNoOrganiserEventSelectedCopy) {
        
        List<User> filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = new ArrayList<>();
        filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = filterUserRegisterByNoOrganiserEventSelectedCopy;
        
        List<User> usersToRemove = new ArrayList<>();
        
        for (StaffMember staffMember : staffList) {
            
            for (User user : filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff) {
                
                if (user.equalsUser(staffMember.getStaff()) || !user.getRole().equals(Role.EMPLOYEE)) {
                    
                    usersToRemove.add(user);
                    
                }
                
            }
        }
        
        filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff.removeAll(usersToRemove);
        return filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff;
        
    }
}
