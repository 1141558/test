/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.ReviewApplicationController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class ReviewApplicationUI {
    
    ReviewApplicationController controller;
    
    public ReviewApplicationUI(ExhibitionCentre centre){
        this.controller= new ReviewApplicationController(centre);
        chooseEvent(); 
        chooseApplication();
        int staffTopicKnowledge= makeReview("Topic on Knowledge (0 to 5)");
        int eventAdequacy= makeReview("Event Adequacy (0 to 5)");
        int inviteAdequacy= makeReview("Invite Adequacy (0 to 5)");
        int areaAdequacy= makeReview("Area Adequacy  (0 to 5)");
        int recommendation= makeReview("Recommendation (0 to 5)");
        
        boolean decision=getDecision();
                String resposta="";
        while(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
            resposta=UtilsUI.readLineFromConsole("DO YOU CONFIRM THIS REVIEW? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(resposta.equalsIgnoreCase("c")){
            UtilsUI.printWarning("REVIEW CANCELED");
            new MainMenu(centre);
        }else if(resposta.equalsIgnoreCase("y")){
            controller.setData(staffTopicKnowledge,eventAdequacy, inviteAdequacy, areaAdequacy, recommendation, decision);
            controller.submitReview();
            UtilsUI.printConfirmation("REVIEW SAVED");
            new MainMenu(centre);        

        }
    }

    private void chooseApplication() {
        int app_number=-1;
        int n=0;
        while(app_number==-1){
                UtilsUI.printLine("--------------------------");
                UtilsUI.printLine("     YOUR APPLICATIONS    ");
                UtilsUI.printLine("--------------------------");

                for (Application a : controller.getStaffApplications()) {
                        UtilsUI.printLine((n+1)+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine("--------------------------");

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
        }     }

    private void chooseEvent() {
        int event_number=-1;
        int n=0;
        while(event_number==-1){
                UtilsUI.printLine("--------------------------");
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine("--------------------------");

                for (Event e : controller.getEvents()) {
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
        }     }

    private int makeReview(String field) {
        int param=0;
        while(param<=0 || param>5){
            try{
                param = Integer.parseInt(UtilsUI.readLineFromConsole(field.toUpperCase()+" : "));
                if(param<=0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BETWEEN 0 AND 5. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        return param;


    }

    private boolean getDecision() {
        String resposta="", a="a", r="r";
        while(!a.equalsIgnoreCase(resposta) && !r.equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("FINAL DECISION (WRITE 'A' TO ACCEPT OR 'R' TO REJECT APPLICATION): ");
            if(!a.equalsIgnoreCase(resposta) && !r.equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        return a.equals(resposta);
    }

    
    
}

    

