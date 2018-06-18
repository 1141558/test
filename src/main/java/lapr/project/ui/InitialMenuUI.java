/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class InitialMenuUI {
    private ExhibitionCentre centre;
    
    public InitialMenuUI(ExhibitionCentre centre){
     
        String opt;
        this.centre=centre;
        System.out.println((char)27 + "[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        System.out.println("             WELLCOME            ");
        System.out.println((char)27 + "[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        
     
        
        System.out.println("             1.LOGIN             ");
        System.out.println("            2.REGISTER           ");
        System.out.println((char)27 + "[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
      
        opt = Utils.readLineFromConsole("INSERT OPTION: ");
        switch(Integer.parseInt(opt)){
         
            case 1:
                new MainMenu(centre);    
            break;  
             case 2:
                 new UserRegistrationUI(centre);
            break; 
        }
    }
}
