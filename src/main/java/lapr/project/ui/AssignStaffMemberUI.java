/*,
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.AssignStaffMemberController;
import lapr.project.controller.AssignStandToApplicationController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StaffMember;
import lapr.project.model.User;

/**
 *
 * @author Altran
 */
public final class AssignStaffMemberUI {
    
    private AssignStaffMemberController assignStaffMemberController;
    
    
    AssignStaffMemberUI(ExhibitionCentre centre) {
        
        this.assignStaffMemberController = new AssignStaffMemberController(centre);
        List<Event> eventList = assignStaffMemberController.getEventsListByOrganiser();
        staffMemberAssign(eventList, centre);
    }
    
    private void showOrganiserEventsList(List<Event> organiserValidatedList) {
        UtilsUI.printLine((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        UtilsUI.printLine("                   EVENTOS ASSOCIADOS                      ");
        UtilsUI.printLine((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        int n=0;
        for (Event event : organiserValidatedList) {
            
            UtilsUI.printLine((n+1)+" - " + event.getTitle());
            n++;
       
       
        
        }

    }
    
    private void staffMemberAssign(List<Event> events, ExhibitionCentre exhibitionCentre) {
        
        String opcaoEq;
        int option;
        Event eventSelected;
        
        showOrganiserEventsList(events);
        do {
            opcaoEq = UtilsUI.readLineFromConsole("\n PICK EVENT (WRITE '0' TO EXIT) ");
            option = new Integer(opcaoEq);
        } while (option < 0 || option > events.size());
        
        eventSelected = eventChoose(option, events);
        
        assignStaffMemberController.selectEvent(eventSelected);
        
        List<User> availableUserToAssignToEvent = assignStaffMemberController.getAvailableUsers();
        
        showAvaiableUsersForEvent(exhibitionCentre, availableUserToAssignToEvent, eventSelected);
        
        printStaffMemberList(assignStaffMemberController.getStaffMemberList());
        String resposta = "";
        while (!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")) {
            resposta = UtilsUI.readLineFromConsole("DO YOU CONFIRM ATRIBUITION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if (!resposta.equalsIgnoreCase("y") && !resposta.equalsIgnoreCase("c")) {
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if (resposta.equalsIgnoreCase("c")) {
            UtilsUI.printWarning("Staff Member Atribuition Cancelled");
            new MainMenu(exhibitionCentre);
        } else if (resposta.equalsIgnoreCase("y")) {
            assignStaffMemberController.saveStaffMemberList();
            
            
            UtilsUI.printConfirmation("STAFF MEMBER ATRIBUITION SAVED");
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
            UtilsUI.printLine("Staff member´s event: " + staffMember + eventSelected.toString2());
            
        }
    }
    
    private void showAvaiableUsersForEvent(ExhibitionCentre exhibitionCentre, List<User> availableUserToAssignToEvent, Event eventSelected) {
        String user1 = "";
        
        while (!user1.equalsIgnoreCase("X")) {
            int userPos = 0;
            int n = 1;
            UtilsUI.printLine("--------------------------");
            UtilsUI.printLine(" List of Available Users  ");
            UtilsUI.printLine("--------------------------");
            for (User user : availableUserToAssignToEvent) {
                
                System.out.println(n + "- " + user.getUsername());
                n++;
            }
            UtilsUI.printLine("--------------------------");
            
            user1 = UtilsUI.readLineFromConsole("PICK USER (WRITE X WHEN YOU ARE DONE): ");
            readStaffMember(user1, userPos, n, availableUserToAssignToEvent, exhibitionCentre);
        }
    }
    
    private void readStaffMember(String user1, int userPos, int n, List<User> availableUserToAssignToEvent, ExhibitionCentre exhibitionCentre) {
        try {
            userPos = Integer.parseInt(user1);
            UtilsUI.printLine("UserPOs" + userPos);
            UtilsUI.printLine("N" + n);
            List<StaffMember> staffMembers = new ArrayList<>();
            if (userPos > 0 && userPos < n) {
                
                StaffMember staffMember = assignStaffMemberController.assignUser(availableUserToAssignToEvent, userPos);
                
                boolean answer = assignStaffMemberController.addStaffMemberToEvent(staffMember);
                if (!answer) {
                    UtilsUI.printError("USER ALLREADY ADDED. PLEASE TRY AGAIN.");
                } else {
                    staffMembers.add(staffMember);
                }
            } else {
                UtilsUI.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");
                
            }
        } catch (NumberFormatException e) {
            if (!user1.equalsIgnoreCase("X")) {
                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                
            }
        }
    }
    
    private void printStaffMemberList(List<StaffMember> staffMembers) {
        UtilsUI.printLine("--------------------------");
        UtilsUI.printLine("       StaffMembers       ");
        UtilsUI.printLine("--------------------------");
        int n = 1;
        for (StaffMember staffMember : staffMembers) {
            UtilsUI.printLine(n + " - " + staffMember.getStaff().getUsername());
            n++;
        }
        UtilsUI.printLine("--------------------------");
    }
    
}
