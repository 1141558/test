/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;
import lapr.project.controller.CreateEventController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.StaffMember;
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
        String title="", description="", startDateString, endDateString, place="", user1="", fromFile="";
        boolean file=false, answer=false;
        Date startDate = new Date(), endDate= new Date();
        List<Organiser> organisersToPrint = new ArrayList<>();
        int userPos=0, nDays=0;
       
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           CREATE EVENT           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        while(!answer){
    
            fromFile= Utils.readLineFromConsole("DO YOU WISH TO LOAD EVENT FROM FILE OR DO YOU WISH TO CREATE HERE A NEW ONE? ENTER 'Y' TO LOAD EVENT FROM FILE OR 'N' TO CREATE A NEW ONE: ");
            if(fromFile.equalsIgnoreCase("y")){
                    answer=true;
                    String filename= Utils.readLineFromConsole("NAME OF FILE (ALL FILES MUST BE IN 'resources' FOLDER): ");
                    
                    if(controller.getEventFromFile(filename)){ 
                        title=controller.getEvent().getTitle();
                        description= controller.getEvent().getDescription();
                        place = controller.getEvent().getPlace();
                        List<StaffMember> list= controller.getEvent().getStaffRegister().getStaffList();
                        List<Organiser> list2=controller.getEvent().getOrganiserRegister().getOrganiserList();
                        printEventFile(title, description, startDate, endDate, place,list, list2, nDays);
                    }else{
                        new MainMenu(exhibitionCentre);
                    }
            }else if(fromFile.equalsIgnoreCase("n")){
                    answer=true;
                    title = Utils.readLineFromConsole("TITLE: ");
                    description = Utils.readLineFromConsole("DESCRIPTION: ");
                    startDateString =Utils.readLineFromConsole("START DATE (YYYY-MM-DD): ");
                    startDate= validateStartDateFormat(startDateString);
                    endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");
                    endDate=validateEndDateFormat(endDateString, startDate);        
                    place = Utils.readLineFromConsole("PLACE: ");
                    while(nDays<1){
                        try{
                            nDays = Integer.parseInt(Utils.readLineFromConsole("NUMBER OF DAYS FOR OPEN APPLICATIONS: "));
                            if(nDays<1){
                             UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                            }    
                            }catch(NumberFormatException e){

                            UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

                        }           
                    }
                    while(!user1.equalsIgnoreCase("X")){

                        int n=1;
                        userPos=0;
                        System.out.println("--------------------------");
                        System.out.println("          USERS           ");
                        System.out.println("--------------------------");

                        for (User user : controller.getUsersAvailable()) {
                            System.out.println(n+" - "+user.getUsername());
                            n++;
                        }
                        System.out.println("--------------------------");

                        user1=Utils.readLineFromConsole("PICK ORGANISER (WRITE X WHEN YOU ARE DONE): ");
                        readOrganiser(user1, userPos, n, organisersToPrint);


                    }
            controller.setData(title, description, startDate, endDate, place);
            printEvent(title, description, startDate, endDate, place,organisersToPrint, nDays);
            
            }else{
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                
            }


        }
        
        
        String resposta="";
        while(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
            resposta=Utils.readLineFromConsole("DO YOU CONFIRM THIS EVENT? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(resposta.equalsIgnoreCase("c")){
            UtilsUI.printWarning("EVENT CANCELED");
            new MainMenu(exhibitionCentre);
        }else if(resposta.equalsIgnoreCase("y")){
            controller.registerEvent(); 
            controller.registerLog();
            UtilsUI.printConfirmation("EVENT SAVED");
            new MainMenu(exhibitionCentre);        

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

                UtilsUI.printError("INVALID FORMAT, PLEASE TRY AGAIN.");                
                startDateString =Utils.readLineFromConsole("START DATE (YYYY-MM-DD): ");               
               
            }else if(!controller.compareDates(today,startDate)){
                UtilsUI.printError("DATE EXPIRED, PLEASE TRY AGAIN.");
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
                UtilsUI.printError("INVALID FORMAT, PLEASE TRY AGAIN.");                
                endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");
                
            }else if(!controller.compareDates(startDate, endDate)){
                
                UtilsUI.printError("END DATE MUST BE AFTER START DATE. PLEASE TRY AGAIN.");
                endDateString =Utils.readLineFromConsole("END DATE (YYYY-MM-DD): ");                

            }else{
                validate=true;
            }
        }
        return endDate;
    }
    
    private void printEventFile(String title, String description, Date startDate, Date endDate, String place, List<StaffMember> list, List<Organiser> list2, int nDays){
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           CREATED EVENT          ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("TITLE: "+title);
        System.out.println("DESCRIPTION: "+description);
        System.out.println("START DATE : "+startDate.toString());
        System.out.println("END DATE : "+endDate.toString());
        System.out.println("PLACE: "+place);
        System.out.println("NUMBER OF DAYS FOR OPEN APPLICATIONS: "+nDays);
        System.out.println("--------------------------");
        System.out.println("      STAFF MEMBERS        ");
        System.out.println("--------------------------");
        int n=1;
            for (StaffMember o : list) {
                System.out.println(n+" - "+o.getStaff().getUsername());
                n++;
            }
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("        ORGANISERS        ");
        System.out.println("--------------------------");
        int n2=1;
            for (Organiser o : list2) {
                System.out.println(n2+" - "+o.getOrganiser().getUsername());
                n2++;
            }
        System.out.println("--------------------------");
    }
    private void printEvent(String title, String description, Date startDate, Date endDate, String place, List<Organiser> list, int nDays){
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           CREATED EVENT          ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("TITLE: "+title);
        System.out.println("DESCRIPTION: "+description);
        System.out.println("START DATE : "+startDate.toString());
        System.out.println("END DATE : "+endDate.toString());
        System.out.println("PLACE: "+place);
        System.out.println("NUMBER OF DAYS FOR OPEN APPLICATIONS: "+nDays);
        System.out.println("--------------------------");
        System.out.println("        ORGANISERS        ");
        System.out.println("--------------------------");
        int n=1;
            for (Organiser o : list) {
                System.out.println(n+" - "+o.getOrganiser().getUsername());
                n++;
            }
        System.out.println("--------------------------");
    }

    private void readOrganiser(String user1, int userPos, int n, List<Organiser> organisersToPrint) {
        try{
                userPos= Integer.parseInt(user1);
                if(userPos<n){
                    Organiser o = controller.createOrganiser(controller.getUsersAvailable(), userPos);
                    boolean answer = controller.addOrganiser(o);
                    if(!answer){
                        UtilsUI.printError("USER ALLREADY ADDED. PLEASE TRY AGAIN.");
                    }else{
                        organisersToPrint.add(o);
                    }
                }else{
                    UtilsUI.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");

                }
            }catch(NumberFormatException e){
                if(!user1.equalsIgnoreCase("X")){
                    UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

                }
            }           
    }
}
