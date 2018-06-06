/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;
import lapr.project.controller.CreateEventController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class CreateEventUI {

    private CreateEventController controller;

    public CreateEventUI(ExhibitionCentre exhibitionCentre){
        this.controller= new CreateEventController(exhibitionCentre);
        String title, description, startDateString, endDateString, place, user1="";
        Date startDate = new Date(), endDate= new Date();
        
        System.out.println("");        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
        System.out.println("           \u2619CREATE EVENT           ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
        title = Utils.readLineFromConsole("TITLE: ");
        description = Utils.readLineFromConsole("DESCRIPTION: ");
        startDateString =Utils.readLineFromConsole("START DATE (YYYY-MM-DD): ");
        startDate= validateStartDateFormat(startDateString);
        endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");
        endDate=validateEndDateFormat(endDateString, startDate);        
        place = Utils.readLineFromConsole("PLACE: ");
        
        while(!user1.equals("X")){
            int n=1;
            System.out.println("--------------------------");
            System.out.println("          USERS           ");
            System.out.println("--------------------------");

            for (User user : controller.getUsersAvailable()) {
                System.out.println(n+" - "+user.getUsername());
                n++;
            }
            System.out.println("--------------------------");
            user1=Utils.readLineFromConsole("PICK ORGANISER (WRITE X WHEN YOU ARE DONE): ");
            try{
                Integer.parseInt(user1);
            }catch(NumberFormatException e){
                System.out.println("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
            }
        }
    }

    private Date validateStartDateFormat(String startDateString) {
    boolean validate=false;
    Date today= new Date();
    Date startDate=new Date();
    //Validates date format
        while(!validate){
            startDate=controller.checkFormat(startDate,startDateString);
            if(controller.checkFormat(startDate,startDateString)==null){
                System.out.println("Invalid Date, Please try again.");
                startDateString =Utils.readLineFromConsole("START DATE (YYYY-MM-DD): ");               
               
            }else if(!controller.compareDates(today,startDate)){
                System.out.println("Date Expired, Please try again.");
                startDateString =Utils.readLineFromConsole("START DATE (YYYY-MM-DD): ");                

            }else{

                validate=true;

            }
        }
        
        return startDate;
        //validates date timming

    }

    private Date validateEndDateFormat(String endDateString, Date startDate) {
    boolean validate=false;
    Date endDate= new Date();            
        while(!validate){
            endDate=controller.checkFormat(endDate,endDateString);
            if(controller.checkFormat(endDate,endDateString)==null){
                System.out.println("Invalid Date, Please try again.");
                endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");
                
            }else if(!controller.compareDates(startDate, endDate)){
                
                System.out.println("End Date must be after start date, Please try again.");
                endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");                

            }else{
                validate=true;
            }
        }
        return endDate;
    }
}
