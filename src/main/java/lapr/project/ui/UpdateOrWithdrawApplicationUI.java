/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.UpdateOrWithdrawApplicationController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Workshop;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public final class UpdateOrWithdrawApplicationUI {
    
    UpdateOrWithdrawApplicationController controller;
    
    public UpdateOrWithdrawApplicationUI(ExhibitionCentre centre ){
        
        this.controller= new UpdateOrWithdrawApplicationController(centre);
        
        
        String description, keyTemp, companyName;        
        int nInvites=-1, nKeywords=0, n=1, app_number=-1, phoneNumber=0, vatNumber=0;
        double area=-1;
        List<Keyword> keywords= new ArrayList<>(); 
        UtilsUI.printLine("");        
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        UtilsUI.printLine("           UPDATE OR WITHDRAW APPLICATION TO EVENT           ");
        UtilsUI.printLine((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        while(app_number==-1){
                UtilsUI.printLine("--------------------------");
                UtilsUI.printLine("     YOUR APPLICATIONS    ");
                UtilsUI.printLine("--------------------------");

                for (Application a : controller.getUserApplications()) {
                        UtilsUI.printLine(n+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine("--------------------------");

                try{
                        app_number = Integer.parseInt(Utils.readLineFromConsole("PICK APPLICATION: "));
                        controller.setA(n-2);
                        if(app_number <1 || app_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            app_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        app_number=-1;                            

                    }           
        }
        
        String resposta1="";
        while(!resposta1.equalsIgnoreCase("w") && !resposta1.equalsIgnoreCase("u")){
            resposta1=Utils.readLineFromConsole("DO YOU WISH TO WITHDRAW OR UPDATE APPLICATION? (WRITE 'W' TO WHITHDRAW OR 'U' TO UPDATE): ");
            if(!resposta1.equalsIgnoreCase("w") && !resposta1.equalsIgnoreCase("u")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        
        if(resposta1.equalsIgnoreCase("w")){
            if(controller.withdrawApplication()){
                UtilsUI.printConfirmation("APPLICATION REMOVED");
                new MainMenu(centre);
            }else{
                UtilsUI.printError("AN ERROR HAS OCCOURED. WITHDRAW FAILED.");
                new MainMenu(centre);
            }
        }
        
        if(resposta1.equalsIgnoreCase("u")){
        
        System.out.println("******WRITE 'M' TO MAINTAIN PREVIOUS FIELD OR WRITE NEW CHOICE (ON ALL FIELDS) ******");    
        description = Utils.readLineFromConsole("DESCRIPTION (CURRENT ONE IS '"+controller.getA().getDescription()+"'): ");
        if(description.equalsIgnoreCase("m")){
            description= controller.getA().getDescription();
        }
        String inv_string;
        while(nInvites<0){
            try{

                inv_string = Utils.readLineFromConsole("NUMBER OF INVITES (CURRENT ONE IS '"+controller.getA().getNumberInvites()+"'): ");
                if(inv_string.equalsIgnoreCase("m")){
                    nInvites=controller.getA().getNumberInvites();
                }else{
                    nInvites=Integer.parseInt(inv_string);
                }
                if(nInvites<0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER OR EQUAL TO 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        String maintain_keywords="";
        UtilsUI.printLine("CURRENT KEYWORDS: ");
        controller.getA().getKeywordList().forEach(keyword -> {
            UtilsUI.printLine("- "+keyword.getValue());
            });
        while(!maintain_keywords.equalsIgnoreCase("y") && !maintain_keywords.equalsIgnoreCase("n")){
            maintain_keywords = Utils.readLineFromConsole("DO YOU WISH TO MAINTAIN THIS KEYWORDS? (WRITE 'y' IF YES OR 'n' IF NO) : ");   
            if(!maintain_keywords.equalsIgnoreCase("y") && !maintain_keywords.equalsIgnoreCase("n")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(maintain_keywords.equalsIgnoreCase("y")){
           keywords = controller.getA().getKeywordList();
        }
        
        if(maintain_keywords.equalsIgnoreCase("n")){
            while(nKeywords<5){
                    keyTemp=Utils.readLineFromConsole("ISERT A KEYWORD (MINUMUM 2 MAXIMUM 5) (WRITE X WHEN YOU ARE DONE) : ");
                    if(!keyTemp.equalsIgnoreCase("x")){
                        Keyword k= new Keyword();
                        k.setValue(keyTemp);
                        keywords.add(k);
                        nKeywords++;                   
                    }else{
                       if(nKeywords<2){

                            UtilsUI.printError("YOU NEED AT LEAST 2 KEYWORDS.");

                       }else{
                           break;
                       } 
                    }
            }
        }
        
        String area_string;
        while(area<=0){
            try{
                area_string = Utils.readLineFromConsole("WANTED BOOTH AREA (m2) (CURRENT ONE IS "+controller.getA().getBoothArea()+" m2) : ");
                if(area_string.equalsIgnoreCase("m")){
                    area= controller.getA().getBoothArea();
                }else{
                    area=Double.parseDouble(area_string);                   
                }
                if(area<=0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        companyName = Utils.readLineFromConsole("COMPANY NAME (CURRENT ONE IS "+controller.getA().getNameOfCompany()+") :");
        if(companyName.equalsIgnoreCase("m")){
            companyName= controller.getA().getNameOfCompany();
        }
        String phone_number_string;
        while(!controller.validatePhoneNumber(phoneNumber)){
            try{
                phone_number_string = Utils.readLineFromConsole("PHONE NUMBER (CURRENT ONE IS "+controller.getA().getPhoneNumber()+") :");
                if(phone_number_string.equalsIgnoreCase("m")){
                    phoneNumber=controller.getA().getPhoneNumber();
                }else{
                    phoneNumber=Integer.parseInt(phone_number_string);
                }
                if(!controller.validatePhoneNumber(phoneNumber)){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. YOU SHOULD INSERT 9 DIGIT NUMBER. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        boolean vat=false;
        String vat_string;
        while(!vat){
            try{
                vat_string = Utils.readLineFromConsole("VAT NUMBER: ");
                if(vat_string.equalsIgnoreCase("m")){
                    vatNumber=controller.getA().getVatNumber();
                }else{
                    vatNumber= Integer.parseInt(vat_string);
                }
                vat=true;
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        } 
        List<Workshop> workshop_list = new ArrayList<>();
        
        String maintain_workshops="";
        UtilsUI.printLine("CURRENT WORKSHOPS: ");
        controller.getA().getWorkshopList().forEach((w) -> {
            System.out.println("- "+w.getDescription());
            });
        while(!maintain_workshops.equalsIgnoreCase("y") && !maintain_workshops.equalsIgnoreCase("n")){
            maintain_workshops = Utils.readLineFromConsole("DO YOU WISH TO MAINTAIN THIS WORSHOPS? (WRITE 'y' IF YES OR 'n' IF NO) : ");   
            if(!maintain_workshops.equalsIgnoreCase("y") && !maintain_workshops.equalsIgnoreCase("n")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if(maintain_workshops.equalsIgnoreCase("y")){
           workshop_list = controller.getA().getWorkshopList();
        }
        else{
            String resposta_workshops="";
            while(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                resposta_workshops=Utils.readLineFromConsole("DO YOU WISH TO DO WORKSHOPS? (WRITE 'Y' IF YES OR 'N' IF NO): ");
                if(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                    UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                }               
            }

            if(resposta_workshops.equalsIgnoreCase("y")){
                workshop_list=readWorkshops(controller.getEvent());   
            }
        }
        String resposta="";
        while(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
            resposta=Utils.readLineFromConsole("DO YOU CONFIRM THIS APPLICATION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        
        if(resposta.equalsIgnoreCase("c")){
            UtilsUI.printWarning("APPLICATION CANCELED");
            new MainMenu(centre);
        }else if(resposta.equalsIgnoreCase("y")){
            controller.setData(description,nInvites,keywords,area,companyName, phoneNumber, vatNumber,workshop_list );
            controller.updateApplication();
            UtilsUI.printConfirmation("APPLICATION SAVED");
            new MainMenu(centre);        

        }
            
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
                        UtilsUI.printLine("---------------------------");    
                        UtilsUI.printLine("       WORKSHOP "+(i+1)+"  ");                     
                        UtilsUI.printLine("---------------------------");    
                        description = Utils.readLineFromConsole("DESCRIPTION: ");
                        boolean ans=false;
                        while(!ans){
                            try{
                                duration = Integer.parseInt(Utils.readLineFromConsole("DURATION (HOURS): "));
                                ans=true;
                                }catch(NumberFormatException ex){

                                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
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
