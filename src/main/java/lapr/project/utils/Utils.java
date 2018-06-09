/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

/**
 *
 * @author MariaJoão
 */
public class Utils {
   static public String readLineFromConsole(String strPrompt)
   {
       try
       {
           System.out.print(strPrompt);

           InputStreamReader converter = new InputStreamReader(System.in);
           BufferedReader in = new BufferedReader(converter);

           return in.readLine();
       } catch (Exception e)
       {
           e.printStackTrace();
           return null;
       }
   }
   
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

       /*
    * Método que copia a lista de Users
    * @param
    */
    public static List<User> getCopia(List<User> userList) {
        List<User> copia = new ArrayList<>();
        
        userList.forEach((User user) -> {
           
            copia.add(user.clone());
        });
      
        return copia;
    }
    }
    

