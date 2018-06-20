/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StaffMember;
import lapr.project.model.Stand;
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
           
//            copia.add(user.clone());
            copia.add(new User(user));
        });
      
        return copia;
    }
//     /*
//    * Método que copia a lista de Users
//    * @param
//    */
//    public static List<StaffMember> getCopyStaffList(List<StaffMember> staffList) {
//        List<StaffMember> copy = new ArrayList<>();
//        
//        staffList.forEach((StaffMember staffMember) -> {
//           
////            copia.add(user.clone());
//            copy.add(new StaffMember(staffMember));
//        });
//      
//        return copy;
//    }
 
        /**
        *
        * Permite ler um ficheiro com a extensão 
//        */
//        public void csvFileReading(String nameFile) throws FileNotFoundException {
//
//       
//
//        ArrayList<Event> eventsList = new ArrayList<>();
//        ArrayList<Stand> standsList = new ArrayList<>();
//        ArrayList<Application> applicationList = new ArrayList<>();
//        
//        Event event = null;
//        Stand stand = null;
//        Application application = null;
//
//       
//
//        Scanner reading = new Scanner(new File(nameFile));
//        while (reading.hasNext()) {
//            String[] aux = reading.nextLine().split(";");
//            
//            
//            event = new Event((aux[0].toString()));
//            stand = new Stand(aux[1].toString());
//           
//      application= new Application((aux[2].toString()));
//            
////            listaCartoes.add(cartao);
////            listaEquipamentos.add(equipamento);
////            listaColaboradores.add(colaborador);
//        }
//
//        reading.close();
////        m_Empresa.getRegistodeCartoes().setCartoes(listaCartoes);
////        m_Empresa.getRegistoColaboradores().setColaboradores(listaColaboradores);
////        m_Empresa.getRegistoDeEquipamentos().setEquipamentos(listaEquipamentos);
//    }
 
}
    
    

