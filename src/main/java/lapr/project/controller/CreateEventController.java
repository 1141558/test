/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class CreateEventController {

    private ExhibitionCentre exhibitionCentre;
    public CreateEventController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre=exhibitionCentre;
    }
        
    public List<User> getUsersAvailable(){
        return this.exhibitionCentre.getUserRegister().getUserList();
    }
    
    public Date checkFormat(Date startDate, String startDateString) {
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            try {
                startDate = format.parse(startDateString);
                return startDate;
                
            } catch (ParseException ex) {
                
                return null;
                
            }    
    }

    public boolean validateDateGap(Date date1, Date date2) {
        date1.setMinutes(0);
        date1.setHours(0);
        date1.setSeconds(0);
        if(date1.after(date2)){
            return false;
        }
        return true;   
    }


    
}
