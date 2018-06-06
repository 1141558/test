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
public class MainMenu {
    private ExhibitionCentre centre;
    
    public MainMenu(ExhibitionCentre centre){
     
        String opt;
        this.centre=centre;
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        System.out.println("             MAIN MENU            ");
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
        System.out.println("          1.CREATE EVENT          ");
        System.out.println("       2.ASSIGN STAFF MEMBER      ");
        System.out.println("             3.LOGOUT             ");
        System.out.println((char)27 + "[34m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");
      
        opt = Utils.readLineFromConsole("INSERT OPTION: ");
        switch(Integer.parseInt(opt)){
         
            case 1:
                new CreateEventUI(centre);    
            break;  
        }
    }
    
}
