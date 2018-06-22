/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.Serializable;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Role;


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
        UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        UtilsUI.printLine("                       MAIN MENU                         ");
        UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        
        /*
        * Não apagar, comentado temporariamente
        */
        
        if(centre.getEventRegister().userIsStaffMember(centre.getUserOnline())){
            UtilsUI.printLine("               1.SUBMIT APPLICATION REVIEW               ");
            UtilsUI.printLine("               2.CALCULATE MINIMUM ELECTRICAL CABLE               ");
            UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    /*TO DO*/
                    break;
                case 2:
                    new CalculateCableUI(centre);
                    break;
                default:
                    break;

            }
        }
        else if(centre.getEventRegister().userIsOrganiser(centre.getUserOnline())){
            UtilsUI.printLine("               1.ASSIGN STAFF MEMBER TO EVENT            ");
            UtilsUI.printLine("       2.START EVENT'S APPLICATION SUBMISSION PERIOD     ");
            UtilsUI.printLine("                  3.EVALUATE APPLICATION                 ");
            UtilsUI.printLine("              4.ASSIGN STAFF MEMBER TO REVIEW            ");
            UtilsUI.printLine("           5.LIST AN EVENT'S SUBMITTED APPLICATIONS      ");
            UtilsUI.printLine("       6.LIST AN EVENT'S REVIEW-PENDING APPLICATIONS     ");
            UtilsUI.printLine("          7.LIST AN EVENT'S ACCEPTED APPLICATIONS        ");
            UtilsUI.printLine("          8.LIST AN EVENT'S REJECTED APPLICATIONS        ");
            UtilsUI.printLine("                9.LIST AN EVENT'S TOPICS                ");/*frequencias*/
            UtilsUI.printLine("            10.LIST AN EVENT'S STAND INFORMATION         ");/*frequencias*/

            System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");

            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new AssignStaffMemberUI(centre);    
                break; 
                
                case 2:
                    new StartSubmissionPeriodUI(centre);    
                break;
                case 3:
                    /*TO DO*/
                break;
                
                case 4:
                    /*TO DO*/
                case 5:
                    new ListEventsUI(centre, "SUBMITTED");                    
                break;
                case 6:
                    new ListEventsUI(centre, "REVIEW-PENDING");                    
                break;   
                case 7:
                   new ListEventsUI(centre, "ACCEPTED");                    
                break;
                case 8:
                   new ListEventsUI(centre, "REJECTED");                    
                break;    
                case 9:
                    /*TO DO*/
                break;
                case 10:
                    /*TO DO*/
                break;    
            }
        }
        else if(centre.getEventRegister().userIsEventManager(centre.getUserOnline())){
       UtilsUI.printLine("                         1.CREATE EVENT                       ");
       UtilsUI.printLine("                   2.SHOW EVENT'S ACCEPTANCE RATE            ");
       UtilsUI.printLine("                  3.SHOW STAFF MEMBER MEAN RATING            ");
       UtilsUI.printLine("4.SHOW MEAN DEVIATION BETWEEN STAFF MEMBERS' AVERAGE RATINGS AND EVENTS MEAN RATINGS");

       UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new CreateEventUI(centre);    
                break; 
                case 2:
                    /*TO DO*/
                break;    
                case 3:
                    new MeanRatingUI(centre);
                break; 
                case 4:
                    /*TO DO*/
                break;                 
            }         
        }else if(centre.getUserOnline().getRole().equals(Role.PARTICIPANT)){
        UtilsUI.printLine("                1.SUBMIT APPLICATION TO EVENT            ");       
        UtilsUI.printLine("               2.UPDATE OR WITHDRAW APPLICATION          ");       
        UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new SubmitApplicationToEventUI(centre);  
                break;
                case 2:
                    new UpdateOrWithdrawApplicationUI(centre);
                break; 
            } 
        }else if(centre.getUserOnline().getRole().equals(Role.ATENDEE)){
        UtilsUI.printLine("                1.SUBMIT WORKSHOP SURVEY            ");       
        UtilsUI.printLine((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(Integer.parseInt(opt)){         
                case 1:
                    new SubmitWorkshopSurveyUI(centre);
                break; 
            }     
        }
                
    }
    
}

