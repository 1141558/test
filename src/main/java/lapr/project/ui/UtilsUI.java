/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

/**
 *
 * @author MariaJoão
 */
public class UtilsUI {
    public static void printError(String message){
        
        System.out.println((char)27 + "[31m\n-----------------------ERROR-----------------------" + (char)27 + "[0m");
        System.out.println((char)27 + "[31m"+message+(char)27 + "[0m");
        System.out.println((char)27 + "[31m---------------------------------------------------\n"+ (char)27 + "[0m");
    } 
    
    public static void printWarning(String message){
        
        System.out.println((char)27 + "[33m\n----------------------WARNING----------------------" + (char)27 + "[0m");
        System.out.println((char)27 + "[33m"+message+(char)27 + "[0m");
        System.out.println((char)27 + "[33m---------------------------------------------------\n"+ (char)27 + "[0m");
    } 
    
     public static void printConfirmation(String message){
        
        System.out.println((char)27 + "[32m\n----------------------SUCCESS----------------------" + (char)27 + "[0m");
        System.out.println((char)27 + "[32m"+message+(char)27 + "[0m");
        System.out.println((char)27 + "[32m---------------------------------------------------\n"+ (char)27 + "[0m");
    }     

     
    
     
    public static void showUsersExhibitionCentre(ExhibitionCentre exhibitionCentre) {
       List<User> users = new ArrayList<>();
        UserRegister userRegisterCentre = exhibitionCentre.getUserRegister();
       users = userRegisterCentre.getUserList();
        for (User item : users) {
            System.out.println("\n User do centro de exibiçoes: "+ item );
        }
    }    
}
