/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import lapr.project.model.User;

/**
 *
 * @author MariaJoão
 */
public class Utils {

    public static Date changeFormat(Date startDate, String startDateString) {
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
        try {

            startDate = format.parse(startDateString);

            return startDate;

        } catch (ParseException ex) {

            return null;

        }    
    }
    
    public static boolean writeLog(String log){ 
            
       Date d=new Date();
       try(FileWriter fw = new FileWriter("./src/main/resources/logs.txt", true);
               BufferedWriter bw = new BufferedWriter(fw);
               PrintWriter out = new PrintWriter(bw))
           {
              out.println("Date: "+d+" -> "+log);

           } catch (IOException e) {
               //exception handling left as an exercise for the reader
           }
            return true;

   }
       /*
    * Método que copia a lista de Users
    * @param
    */
    public static List<User> getCopia(List<User> userList) {
        List<User> copia = new ArrayList<>();
        
        userList.forEach((User user) -> {
         
            copia.add(new User(user));
        });
      
        return copia;
    }
 
}
    
    

