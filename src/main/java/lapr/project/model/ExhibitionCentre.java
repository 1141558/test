/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author MariaJoão
 */
public class ExhibitionCentre {
    
    private EventRegister eventRegister;
    private UserRegister userRegister;
    private User userOnline;
    
    public ExhibitionCentre(){
        this.eventRegister=new EventRegister();
        this.userRegister= new UserRegister(); 
    }
    public ExhibitionCentre(EventRegister eventRegister, UserRegister userRegister){
        this.eventRegister=eventRegister;
        this.userRegister= userRegister; 
    }    
    /**
     * @return the eventRegister
     */
    public EventRegister getEventRegister() {
        return eventRegister;
    }

    /**
     * @param eventRegister the eventRegister to set
     */
    public void setEventRegister(EventRegister eventRegister) {
        this.eventRegister = eventRegister;
    }

    /**
     * @return the userRegister
     */
    public UserRegister getUserRegister() {
        return userRegister;
    }

    /**
     * @param userRegister the userRegister to set
     */
    public void setUserRegister(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

 
    /**
     * @return the userOnline
     */
    public User getUserOnline() {
        return userOnline;
    }

    /**
     * @param userOnline the userOnline to set
     */
    public void setUserOnline(User userOnline) {
        this.userOnline = userOnline;
    }
    @Override
    public String toString() {
        return "ExhibitionCentre{" + "eventRegister=" + eventRegister + ", userRegister=" + userRegister + '}';

    }
    
}
