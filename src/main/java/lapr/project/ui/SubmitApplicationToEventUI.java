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
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventUI {
   
       private SubmitApplicationToEventController controller;
       
       public SubmitApplicationToEventUI(ExhibitionCentre centre){
           
        this.controller= new SubmitApplicationToEventController(centre);
        String description, keyTemp="", event="", companyName="";        
        int nInvites=-1, nKeywords=0, n=1, event_number=-1, phoneNumber=0, vatNumber=0;
        double area=-1;
        List<String> keywords= new ArrayList<>(); 
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           SUBMIT APPLICATION TO EVENT           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        while(event_number==-1){
                System.out.println("--------------------------");
                System.out.println("          EVENTS          ");
                System.out.println("--------------------------");

                for (Event e : controller.getEventsReadyForApplications()) {
                        System.out.println(n+" - "+e.getTitle());
                        n++;
                    }
                System.out.println("--------------------------");

                try{
                        event_number = Integer.parseInt(Utils.readLineFromConsole("PICK EVENT: "));
                        controller.setEvent(n-2);
                        if(event_number <1 || event_number>n){
                            Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }
        
        description = Utils.readLineFromConsole("DESCRIPTION: ");
        while(nInvites<0){
            try{
                nInvites = Integer.parseInt(Utils.readLineFromConsole("NUMBER OF INVITES: "));
                if(nInvites<0){
                 Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER OR EQUAL TO 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        while(nKeywords<5){
                keyTemp=Utils.readLineFromConsole("ISERT A KEYWORD (MINUMUM 2 MAXIMUM 5) (WRITE X WHEN YOU ARE DONE): ");
                if(!keyTemp.equalsIgnoreCase("x")){
                    keywords.add(keyTemp);
                    nKeywords++;                   
                }else{
                   if(nKeywords<2){
                       
                        Utils.printError("YOU NEED AT LEAST 2 KEYWORDS.");
                       
                   }else{
                       break;
                   } 
                }
        }        
        while(area<=0){
            try{
                area = Double.parseDouble(Utils.readLineFromConsole("WANTED BOOTH AREA (m2): "));
                if(area<=0){
                 Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        companyName = Utils.readLineFromConsole("COMPANY NAME: ");

        while(!controller.validatePhoneNumber(phoneNumber)){
            try{
                phoneNumber = Integer.parseInt(Utils.readLineFromConsole("PHONE NUMBER: "));
                if(!controller.validatePhoneNumber(phoneNumber)){
                 Utils.printError("NUMBER INSERTED NOT VALID. YOU SHOULD INSERT 9 DIGIT NUMBER. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        boolean vat=false;
        while(!vat){
            try{
                vatNumber = Integer.parseInt(Utils.readLineFromConsole("VAT NUMBER: "));
                vat=true;
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        } 
        String resposta_workshops="";
        List<Workshop> workshop_list = new ArrayList<>();
        while(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
            resposta_workshops=Utils.readLineFromConsole("DO YOU WISH TO DO WORKSHOPS? (WRITE 'Y' IF YES OR 'N' IF NO): ");
            if(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                Utils.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }               
        }
        
        if(resposta_workshops.equalsIgnoreCase("y")){
            workshop_list=readWorkshops(controller.getEvent());   
        }
        
        String resposta="";
        while(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
            resposta=Utils.readLineFromConsole("DO YOU CONFIRM THIS APPLICATION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
                Utils.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(resposta.equalsIgnoreCase("c")){
            Utils.printWarning("APPLICATION CANCELED");
            new MainMenu(centre);
        }else if(resposta.equalsIgnoreCase("y")){
            controller.setData(description,nInvites,keywords,area,companyName, phoneNumber, vatNumber, workshop_list );
            controller.registerApplication();
            controller.registerLog();
            Utils.printConfirmation("APPLICATION SAVED");
            new MainMenu(centre);        

        }
        
       }
       
       public List<Workshop> readWorkshops(Event e){
        boolean vat=false;
        List<Workshop> list= new ArrayList<>();
        int number_of_workshops;
        while(!vat){
            try{
                number_of_workshops = Integer.parseInt(Utils.readLineFromConsole("HOW MANY WORKSHOPS DO YOU WISH TO EXECUTE (NOTE: EVENT HAS "+e.getRooms()+" ROOMS AVAILABLE): "));
                if(number_of_workshops<=e.getRooms()){                   
                    
                    for (int i = 0; i < number_of_workshops; i++) {
                        Workshop w= new Workshop();
                        String description;
                        int duration=0;
                        List<String> equip= new ArrayList<>();
                        System.out.println("---------------------------");    
                        System.out.println("       WORKSHOP "+(i+1)+"  ");                     
                        System.out.println("---------------------------");    
                        description = Utils.readLineFromConsole("DESCRIPTION: ");
                        boolean ans=false;
                        while(!ans){
                            try{
                                duration = Integer.parseInt(Utils.readLineFromConsole("DURATION (HOURS): "));
                                ans=true;
                                }catch(NumberFormatException ex){

                                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                                ans=false;    
                            }           
                        }
                        String done="";
                        while(!done.equalsIgnoreCase("x")){
                            done=Utils.readLineFromConsole("NECESSARY EQUIPMENT (WRITE 'X' WHEN YOU ARE DONE):  ");
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
                Utils.printError("NUMBER OF WORSHOPS EXCEEDED. PLEASE TRY AGAIN.");
                 vat=false;   
                }
                }catch(NumberFormatException ex){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        }
        return list;
       }
}
