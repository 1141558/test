/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        System.out.println((char)27 + "[33m                    "+message+(char)27 + "[0m");
        System.out.println((char)27 + "[33m---------------------------------------------------\n"+ (char)27 + "[0m");
    } 
    
     public static void printConfirmation(String message){
        
        System.out.println((char)27 + "[32m\n----------------------SUCCESS----------------------" + (char)27 + "[0m");
        System.out.println((char)27 + "[32m                    "+message+(char)27 + "[0m");
        System.out.println((char)27 + "[32m---------------------------------------------------\n"+ (char)27 + "[0m");
    }     
    
}
