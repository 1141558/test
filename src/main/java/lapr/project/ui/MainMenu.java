/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.Serializable;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Role;
import lapr.project.utils.Utils;


/**
 *
 * @author MariaJoão
 */
public class MainMenu implements Serializable{
    private ExhibitionCentre centre;
     private static final long serialVersionUID = 1L;
     
    public MainMenu(ExhibitionCentre centre) {
     
        String opt;
        this.centre=centre;
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        System.out.println("                       MAIN MENU                         ");
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        
        /*
        * Não apagar, comentado temporariamente
        */
        
        if(centre.getEventRegister().userIsStaffMember(centre.getUserOnline())){
           /*USE CASES DOS STAFF MEMBERS*/
        }
        else if(centre.getEventRegister().userIsOrganiser(centre.getUserOnline())){
            System.out.println("                  1.ASSIGN STAFF MEMBER                  ");
            System.out.println("       2.START EVENT'S APPLICATION SUBMISSION PERIOD     ");
            System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");

            opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new AssignStaffMemberUI(centre);    
                break; 
                
                case 2:
                    new StartSubmissionPeriodUI(centre);    
                break;    
                    
            }
        }
        else if(centre.getEventRegister().userIsEventManager(centre.getUserOnline())){
       System.out.println("                    1.CREATE EVENT                       ");
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
            opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new CreateEventUI(centre);    
                break; 
            }         }else if(centre.getUserOnline().getRole().equals(Role.PARTICIPANT)){
        System.out.println("                1.SUBMIT APPLICATION TO EVENT            ");       
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new SubmitApplicationToEventUI(centre);  
                break; 
            } 
        }
                
    }
    
}
