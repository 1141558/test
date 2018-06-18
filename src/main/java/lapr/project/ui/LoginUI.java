/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import lapr.project.controller.LoginController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class LoginUI {
    
    LoginController controller;
    public LoginUI(ExhibitionCentre centre){

        this.controller = new LoginController(centre);
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);

        String username = "", passwordString="";
        char[] password;
        boolean accepted=false;
       while(!accepted){
        //Request user data
        System.out.println("");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("        USER LOGIN        ");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");

        username = Utils.readLineFromConsole("USERNAME: ");
        if (console != null) {
        password = console.readPassword("PASSWORD: ");
        Arrays.fill(password, ' ');
        passwordString= new String(password);
        
        }else{
        passwordString = Utils.readLineFromConsole("PASSWORD: ");
            
        }

        
        if(!controller.login(username, passwordString)){
            Utils.printError("USERNAME OR PASSOWORD ARE WRONG. PLEASE TRY AGAIN");
            
        }else{
            accepted=true;
            controller.registerLog(username);
            new MainMenu(centre);
        }
        
       }
    }    
}
