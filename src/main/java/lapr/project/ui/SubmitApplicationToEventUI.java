/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.SubmitApplicationToEventController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Workshop;

/**
 *
 * @author MariaJoão
 */
public final class SubmitApplicationToEventUI {
   
       private SubmitApplicationToEventController controller;
       
       public SubmitApplicationToEventUI(ExhibitionCentre centre){
           
        this.controller= new SubmitApplicationToEventController(centre);
        String description, keyTemp, companyName;        
        int nInvites=-1, nKeywords=0, n=1, event_number=-1, phoneNumber=0, vatNumber=0;
        double area=-1;
        List<String> keywords= new ArrayList<>(); 
        UtilsUI.printLine("");        
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        UtilsUI.printLine("           SUBMIT APPLICATION TO EVENT           ");
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        while(event_number==-1){
                UtilsUI.printLine("--------------------------");
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine("--------------------------");

                for (Event e : controller.getEventsReadyForApplications()) {
                        UtilsUI.printLine(n+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine("--------------------------");

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT: "));
                        controller.setEvent(event_number-1);
                        if(event_number <1 || event_number>n-1){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }
        
        
        description = UtilsUI.readLineFromConsole("DESCRIPTION: ");
        while(nInvites<0){
            try{
                nInvites = Integer.parseInt(UtilsUI.readLineFromConsole("NUMBER OF INVITES: "));
                if(nInvites<0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER OR EQUAL TO 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
            }           
        }
        while(nKeywords<5){
                keyTemp=UtilsUI.readLineFromConsole("ISERT A KEYWORD (MINUMUM 2 MAXIMUM 5) (WRITE X WHEN YOU ARE DONE): ");
                if(!keyTemp.equalsIgnoreCase("x")){
                    keywords.add(keyTemp);
                    nKeywords++;                   
                }else{
                   if(nKeywords<2){
                       
                        UtilsUI.printError("YOU NEED AT LEAST 2 KEYWORDS.");
                       
                   }else{
                       break;
                   } 
                }
        }        
        while(area<=0){
            try{
                area = Double.parseDouble(UtilsUI.readLineFromConsole("WANTED BOOTH AREA (m2): "));
                if(area<=0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        companyName = UtilsUI.readLineFromConsole("COMPANY NAME: ");

        while(!controller.validatePhoneNumber(phoneNumber)){
            try{
                phoneNumber = Integer.parseInt(UtilsUI.readLineFromConsole("PHONE NUMBER: "));
                if(!controller.validatePhoneNumber(phoneNumber)){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. YOU SHOULD INSERT 9 DIGIT NUMBER. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        boolean vat=false;
        while(!vat){
            try{
                vatNumber = Integer.parseInt(UtilsUI.readLineFromConsole("VAT NUMBER: "));
                vat=true;
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        } 
        String resposta_workshops="";
        List<Workshop> workshop_list = new ArrayList<>();
        while(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
            resposta_workshops=UtilsUI.readLineFromConsole("DO YOU WISH TO DO WORKSHOPS? (WRITE 'Y' IF YES OR 'N' IF NO): ");
            if(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }               
        }
        
        if(resposta_workshops.equalsIgnoreCase("y")){
            workshop_list=readWorkshops(controller.getEvent());   
        }
        
        String resposta="";
        while(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
            resposta=UtilsUI.readLineFromConsole("DO YOU CONFIRM THIS APPLICATION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(resposta.equalsIgnoreCase("c")){
            UtilsUI.printWarning("APPLICATION CANCELED");
            new MainMenu(centre);
        }else if(resposta.equalsIgnoreCase("y")){
            controller.setData(description,nInvites,keywords,area,companyName, phoneNumber, vatNumber, workshop_list );
            controller.registerApplication();
            controller.registerLog();
            UtilsUI.printConfirmation("APPLICATION SAVED");
            new MainMenu(centre);        

        }
        
       }
       
       public List<Workshop> readWorkshops(Event e){
        boolean vat=false;
        List<Workshop> list= new ArrayList<>();
        int number_of_workshops;
        while(!vat){
            try{
                number_of_workshops = Integer.parseInt(UtilsUI.readLineFromConsole("HOW MANY WORKSHOPS DO YOU WISH TO EXECUTE (NOTE: EVENT HAS "+e.getRooms()+" ROOMS AVAILABLE): "));
                if(number_of_workshops<=e.getRooms()){                   
                    
                    for (int i = 0; i < number_of_workshops; i++) {
                        Workshop w= new Workshop();
                        String description;
                        int duration=0;
                        List<String> equip= new ArrayList<>();
                        UtilsUI.printLine("---------------------------");    
                        UtilsUI.printLine("       WORKSHOP "+(i+1)+"  ");                     
                        UtilsUI.printLine("---------------------------");    
                        description = UtilsUI.readLineFromConsole("DESCRIPTION: ");
                        boolean ans=false;
                        while(!ans){
                            try{
                                duration = Integer.parseInt(UtilsUI.readLineFromConsole("DURATION (HOURS): "));
                                ans=true;
                                }catch(NumberFormatException ex){

                                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                                ans=false;    
                            }           
                        }
                        String done="";
                        while(!done.equalsIgnoreCase("x")){
                            done=UtilsUI.readLineFromConsole("NECESSARY EQUIPMENT (WRITE 'X' WHEN YOU ARE DONE):  ");
                            if(!done.equalsIgnoreCase("x")){ 
                                equip.add(done);
                            }
                        }
                        w.setDescription(description);
                        w.setDurationInHours(duration);
                        w.setNecessaryEquipment(equip);
                        list.add(w);
                    }
                    vat=true;
                }else{
                UtilsUI.printError("NUMBER OF WORSHOPS EXCEEDED. PLEASE TRY AGAIN.");
                 vat=false;   
                }
                }catch(NumberFormatException ex){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        }
        return list;
       }
}