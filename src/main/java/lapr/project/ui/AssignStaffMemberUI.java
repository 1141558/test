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
import lapr.project.controller.AssignStandToApplicationController;
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
        staffMemberAssign(eventList, centre);
    }
    
    private void showOrganiserEventsList(List<Event> organiserValidatedList) {
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("                   EVENTOS ASSOCIADOS                      ");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        for (Event event : organiserValidatedList) {
            
            System.out.println("EVENTO:" + event);
                  
        /***
         *
         */
       
         /*Testar Assign event*/
        
        System.out.println("Teste atribuir stands");
         AssignStandToApplicationController nreAssignStaffToApplicationController = new AssignStandToApplicationController();
        nreAssignStaffToApplicationController.matchsApplicationOnEventListByOrganiserWithStandList();
        
        
       //********************************************************************************************************************* 
        
        
        }
        

        
        
        
        
        
    }
    
    private void staffMemberAssign(List<Event> events, ExhibitionCentre exhibitionCentre) {
        
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
        
        List<User> availableUserToAssignToEvent = assignStaffMemberController.getAvailableUsers();
        
        showAvaiableUsersForEvent(exhibitionCentre, availableUserToAssignToEvent, eventSelected);
        
        printStaffMemberList(assignStaffMemberController.getStaffMemberList());
        String resposta = "";
        while (!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")) {
            resposta = Utils.readLineFromConsole("DO YOU CONFIRM ATRIBUITION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if (!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")) {
                Utils.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if (resposta.equalsIgnoreCase("c")) {
            Utils.printWarning("Staff Member Atribuition Cancelled");
            new MainMenu(exhibitionCentre);
        } else if (resposta.equalsIgnoreCase("y")) {
            assignStaffMemberController.saveStaffMemberList();
            
            
            Utils.printConfirmation("STAFF MEMBER ATRIBUITION SAVED");
              printStaffMemberList(assignStaffMemberController.getStaffMemberList());
            assignStaffMemberController.registerLog();
            new MainMenu(exhibitionCentre);
            
        }
        
    }
    
    private Event eventChoose(int option, List<Event> events) {
        if (option == 0) {
            return null;
        }
        return events.get(option - 1);
    }
    
    private void showStaffListByEvent(Event eventSelected) {
        
        List<StaffMember> staff = eventSelected.getStaffRegister().getStaffList();
        for (StaffMember staffMember : staff) {
            System.out.println("Staff member´s event: " + staffMember + eventSelected.toString2());
            
        }
    }
    
    private void showAvaiableUsersForEvent(ExhibitionCentre exhibitionCentre, List<User> availableUserToAssignToEvent, Event eventSelected) {
        String user1 = "";
        
        while (!user1.equalsIgnoreCase("X")) {
            int userPos = 0;
            int n = 1;
            System.out.println("--------------------------");
            System.out.println(" List of Available Users  ");
            System.out.println("--------------------------");
            for (User user : availableUserToAssignToEvent) {
                
                System.out.println(n + "- " + user);
                n++;
            }
            System.out.println("--------------------------");
            
            user1 = Utils.readLineFromConsole("PICK USER (WRITE X WHEN YOU ARE DONE): ");
            readStaffMember(user1, userPos, n, availableUserToAssignToEvent, exhibitionCentre);
        }
    }
    
    private void readStaffMember(String user1, int userPos, int n, List<User> availableUserToAssignToEvent, ExhibitionCentre exhibitionCentre) {
        try {
            userPos = Integer.parseInt(user1);
            System.out.println("UserPOs" + userPos);
            System.out.println("N" + n);
            List<StaffMember> staffMembers = new ArrayList<>();
            if (userPos > 0 && userPos < n) {
                
                StaffMember staffMember = assignStaffMemberController.assignUser(availableUserToAssignToEvent, userPos);
                
                boolean answer = assignStaffMemberController.addStaffMemberToEvent(staffMember);
                if (!answer) {
                    Utils.printError("USER ALLREADY ADDED. PLEASE TRY AGAIN.");
                } else {
                    staffMembers.add(staffMember);
                }
            } else {
                Utils.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");
                
            }
        } catch (NumberFormatException e) {
            if (!user1.equalsIgnoreCase("X")) {
                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                
            }
        }
    }
    
    private void printStaffMemberList(List<StaffMember> staffMembers) {
        System.out.println("--------------------------");
        System.out.println("       StaffMembers       ");
        System.out.println("--------------------------");
        int n = 1;
        for (StaffMember staffMember : staffMembers) {
            System.out.println(n + " - " + staffMember.getStaff());
            n++;
        }
        System.out.println("--------------------------");
    }
    
}
