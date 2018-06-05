/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.utils.Utils;


/**
 *
 * @author MariaJoão
 */
public class MainMenu {
 
    public MainMenu(){
     
        String opt;
        System.out.println("            MAIN MENU             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("          1.CREATE EVENT          ");
        System.out.println("       2.ASSIGN STAFF MEMBER      ");
        opt = Utils.readLineFromConsole("Introduza opção\n");
        switch(Integer.parseInt(opt)){
         
            case 1:
                System.out.println("111111");    
            break;  
        }
    }
    
}
