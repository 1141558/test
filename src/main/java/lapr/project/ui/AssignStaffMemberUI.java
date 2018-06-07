/*,
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.ui;

import lapr.project.controller.AssignStaffMemberController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author Altran
 */
public class AssignStaffMemberUI {
    
    private AssignStaffMemberController assignStaffMemberController;
    
    AssignStaffMemberUI(ExhibitionCentre centre) {
        
         
      
        assignStaffMemberController.assignStaffMemberToEvent(inputOrganiserData());
        
    }
    
 public Organiser inputOrganiserData() {
        
        Organiser organiserValidated = new Organiser();
        
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("           Input organiser Data           ");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
     
        String name = Utils.readLineFromConsole("--Input organiser name--\n");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        String email = Utils.readLineFromConsole("--Input organiser email--\n");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        String userName = Utils.readLineFromConsole("--Input organiser user name--\n");
        System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
       double password = Double.parseDouble(Utils.readLineFromConsole("--Input organiser password--\n"));
       System.out.println((char) 27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
       
       
        organiserValidated.setName(name)
                ;
        organiserValidated.setEmail(email);
        organiserValidated.setUsername(userName);
        organiserValidated.setPassword(password);
       
       return   organiserValidated;
    }
    
}
