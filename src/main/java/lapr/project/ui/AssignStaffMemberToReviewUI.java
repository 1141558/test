/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.AssignStaffMemberToReviewController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StaffMember;

/**
 *
 * @author MariaJoão
 */
public class AssignStaffMemberToReviewUI {
    
    AssignStaffMemberToReviewController controller;
    public AssignStaffMemberToReviewUI(ExhibitionCentre centre) {
        this.controller= new AssignStaffMemberToReviewController(centre);
       
        UtilsUI.printLine("");        
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        UtilsUI.printLine("           ASSIGN STAFF MEMBER TO REVIEW           ");
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        choseEvent();
        choseApplication();
        choseStaffMember();
        boolean confirm = askConfirmation();
        if(confirm){
            controller.assignMember();
            controller.registerLog();
            UtilsUI.printConfirmation("ASSIGNMENT SAVED");
            new MainMenu(centre);

        }else{
            UtilsUI.printWarning("APPLICATION CANCELED");
            new MainMenu(centre);
        }
    }

    private void choseEvent() {
        int event_number=-1;
        int n=0;
        while(event_number==-1){
                UtilsUI.printLine("--------------------------");
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine("--------------------------");

                for (Event e : controller.getEventsFromOrganiser()) {
                        UtilsUI.printLine((n+1)+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine("--------------------------");

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT: "));
                        controller.setEvent(event_number-1);
                        if(event_number <1 || event_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        } 
    }

    private void choseApplication() {
        int app_number=-1;
        int n=0;
        while(app_number==-1){
                UtilsUI.printLine("-------------------------------------------");
                UtilsUI.printLine("       APPLICATIONS FROM "+controller.getEvent().getTitle()+"      ");
                UtilsUI.printLine("-------------------------------------------");

                for (Application a : controller.getApplicationsFromEvent()) {
                        UtilsUI.printLine((n+1)+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine("-------------------------------------------");

                try{
                        app_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK APPLICATION: "));
                        controller.setApplication(app_number-1);
                        if(app_number <1 || app_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            app_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        app_number=-1;                            

                    }           
        }

    }

    private void choseStaffMember() {
        int staff_number=-1;
        int n=0;
        while(staff_number==-1){
                UtilsUI.printLine("-------------------------------------------");
                UtilsUI.printLine("       STAFF MEMBERS FROM "+controller.getEvent().getTitle()+"      ");
                UtilsUI.printLine("-------------------------------------------");

                for (StaffMember sm : controller.getStaffMembersFromEvent()) {
                        UtilsUI.printLine((n+1)+" - "+sm.getStaff().getUsername());
                        n++;
                    }
                UtilsUI.printLine("------------------------------------------");

                try{
                        staff_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK STAFF MEMBER: "));
                        controller.setStaff(staff_number-1);
                        if(staff_number <1 || staff_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            staff_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        staff_number=-1;                            

                    }           
        }    }

    private boolean askConfirmation() {
    String resposta="",y="y", c="c";
        while(!c.equalsIgnoreCase(resposta) && !y.equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("DO YOU WISH TO ASSIGN "+controller.getStaff().getStaff().getUsername()+" TO APPLICATION "+controller.getApplication().getDescription()+" ? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!c.equalsIgnoreCase(resposta) && !y.equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        return y.equalsIgnoreCase(resposta);
    }
 
    
}
