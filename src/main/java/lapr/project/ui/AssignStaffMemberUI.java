/*,
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.ui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.AssignStaffMemberController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.StaffMember;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author Altran
 */
public final class AssignStaffMemberUI {
    
    private AssignStaffMemberController assignStaffMemberController;
    
    AssignStaffMemberUI(ExhibitionCentre centre) {
        
        this.assignStaffMemberController = new AssignStaffMemberController(centre);
        List<Event> eventList = assignStaffMemberController.getEventsListByOrganiser();
        // showOrganiserEventsList(eventList);
        staffMemberAssign(eventList,centre);
    }
    
    private void showOrganiserEventsList(List<Event> organiserValidatedList) {
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("                   EVENTOS ASSOCIADOS                      ");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        for (Event event : organiserValidatedList) {
            
            System.out.println("EVENTO:" + event);
        }
        
    }
    
    private void staffMemberAssign(List<Event> events, ExhibitionCentre exhibitionCentre){
        
        String opcaoEq;
        int option;
        Event eventSelected;
        
        showOrganiserEventsList(events);
        do {
            opcaoEq = Utils.readLineFromConsole("\n Choose Event to assign to! (O - Exit)\n");
            option = new Integer(opcaoEq);
        } while (option < 0 || option > events.size());
        
        eventSelected = eventChoose(option, events);
        
        assignStaffMemberController.selectEvent(eventSelected);
       
        System.out.println("Antes 1 filtro"+assignStaffMemberController.filterUserRegisterByNoOrganiserEventSelected(eventSelected,exhibitionCentre.getUserOnline()));
        
        
     assignStaffMemberController.showAvailableUsers(eventSelected,exhibitionCentre.getUserOnline());
        //showStaffListByEvent(eventSelected);
  
//                if (!opcao_eq.equalsIgnoreCase("0")) {
//
//                    System.out.println("\nIntroduza o periodo de autorizacao (O para sair)");
//                    flag = introduzPeriodo();
//
//                    do {
//                        maisPeriodos = Utils.readLineFromConsole("Deseja associar mais períodos a este equipamento?\n s-sim \n n-não");
//                        if (maisPeriodos.equalsIgnoreCase("s")) {
//                            while (flag2 == false) {
//                                flag2 = introduzPeriodo();
//                                maisPeriodos = Utils.readLineFromConsole("Deseja associar mais períodos a este equipamento?\n s-sim \n n-não");
//                            }
//                        }
//
//                    } while (maisPeriodos.equalsIgnoreCase("s"));
//                }
//

    }
    
    private Event eventChoose(int option, List<Event> events) {
        if (option == 0) {
            return null;
        }
        return events.get(option - 1);
    }

    private void showStaffListByEvent(Event eventSelected) {
  
      
       List<StaffMember> staff = eventSelected.getStaffRegister().getListStaff();
        for (StaffMember staffMember : staff) {
            System.out.println("Staff member´s event: "+ staffMember +eventSelected.toString2()) ;
            
        }
    }
    
    
    
    
}
