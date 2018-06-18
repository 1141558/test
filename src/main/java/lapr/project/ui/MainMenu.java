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
            System.out.println("               1.SUBMIT APPLICATION REVIEW               ");
            System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
            opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                break; 
                
                case 2:
                break;    
                    
            }
        }
        else if(centre.getEventRegister().userIsOrganiser(centre.getUserOnline())){
            System.out.println("               1.ASSIGN STAFF MEMBER TO EVENT            ");
            System.out.println("       2.START EVENT'S APPLICATION SUBMISSION PERIOD     ");
            System.out.println("                  3.EVALUATE APPLICATION                 ");
            System.out.println("              4.ASSIGN STAFF MEMBERS TO REVIEW           ");
            System.out.println("           5.LIST AN EVENT'S SUBMITTED APPLICATIONS      ");
            System.out.println("       6.LIST AN EVENT'S REVIEW-PENDING APPLICATIONS     ");
            System.out.println("          7.LIST AN EVENT'S ACCEPTED APPLICATIONS        ");
            System.out.println("          8.LIST AN EVENT'S REJECTED APPLICATIONS        ");
            System.out.println("                9.LIST AN EVENT'S TOPICS                ");
            System.out.println("            10.LIST AN EVENT'S STAND INFORMATION         ");

            System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");

            opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new AssignStaffMemberUI(centre);    
                break; 
                
                case 2:
                    new StartSubmissionPeriodUI(centre);    
                break;
                case 3:
                break;
                case 5:
                    new ListEventsUI(centre, "SUBMITTED");                    
                break;
                    
            }
        }
        else if(centre.getEventRegister().userIsEventManager(centre.getUserOnline())){
       System.out.println("                         1.CREATE EVENT                       ");
       System.out.println("                   2.SHOW EVENT'S ACCEPTANCE RATE            ");
       System.out.println("                  3.SHOW STAFF MEMBER MEAN RATING            ");
       System.out.println("4.SHOW MEAN DEVIATION BETWEEN STAFF MEMBERS' AVERAGE RATINGS AND EVENTS MEAN RATINGS");

       System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
            opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new CreateEventUI(centre);    
                break; 
            }         
        }else if(centre.getUserOnline().getRole().equals(Role.PARTICIPANT)){
        System.out.println("                1.SUBMIT APPLICATION TO EVENT            ");       
        System.out.println("               2.UPDATE OR WITHDRAW APPLICATION          ");       
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new SubmitApplicationToEventUI(centre);  
                break; 
            } 
        }else if(centre.getUserOnline().getRole().equals(Role.ATENDEE)){
        System.out.println("                1.SUBMIT WORKSHOP SURVEY            ");       
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        opt = Utils.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                break; 
            }     
        }
                
    }
    
}
