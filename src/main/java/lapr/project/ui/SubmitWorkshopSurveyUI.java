/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.SubmitWorkshopSurveyController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Workshop;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitWorkshopSurveyUI {
    SubmitWorkshopSurveyController controller;
    public SubmitWorkshopSurveyUI(ExhibitionCentre centre){
        this.controller= new SubmitWorkshopSurveyController(centre);
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           SUBMIT WORKSHOP SURVEY           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        int event_number=-1, n=1;
        System.out.println("***NOTE: THIS SURVEY IS TOTTALY ANONYMOUS***");

        while(event_number==-1){
                System.out.println("--------------------------");
                System.out.println("          EVENTS          ");
                System.out.println("--------------------------");

                for (Event e : controller.getEvents()) {
                        System.out.println(n+" - "+e.getTitle());
                        n++;
                    }
                System.out.println("--------------------------");

                try{
                        event_number = Integer.parseInt(Utils.readLineFromConsole("PICK EVENT YOU WOULD LIKE TO ATTEND: "));
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
        List<Workshop> lista_workshops= controller.listaWorkshopsOfAcceptedApplications();
        List<Boolean> answers= new ArrayList<>();
                String resposta_workshops="";
        for (int i=0; i<lista_workshops.size();i++) {

                resposta_workshops=Utils.readLineFromConsole("WORKSHOP "+lista_workshops.get(i).getDescription()+" LASTING "+lista_workshops.get(i).getDurationInHours()+" HOURS (WRITE 'Y' IF YES OR 'N' IF NO): ");
                if(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                    Utils.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                    i--;
                }else if(resposta_workshops.equalsIgnoreCase("y")){
                    answers.add(Boolean.TRUE);
                }else if(resposta_workshops.equalsIgnoreCase("n")){
                    answers.add(Boolean.FALSE);
                }                
      }
        controller.registerAnswers(answers);
        Utils.printConfirmation("ANSWERS SUCCESSFULY SAVED");
        controller.registerLog();
        new MainMenu(centre);

        
    } 
    
}