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
           System.out.println(strPrompt);

           InputStreamReader converter = new InputStreamReader(System.in);
           BufferedReader in = new BufferedReader(converter);

           return in.readLine();
       } catch (Exception e)
       {
           e.printStackTrace();
           return null;
       }
   }
}
