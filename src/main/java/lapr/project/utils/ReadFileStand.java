/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class ReadFileStand {
    
    public static void main(String[] args) {

    ReadFileStand obj = new ReadFileStand();
    obj.run();
    
    }
    
    public void run() {

    String file = "./src/main/resources/exhibition1_stands_v0.1.csv";
    BufferedReader br = null;
    String line;
    String csvDivisor = ";";
    String list;
    String [] listDistance;
    int count = 0;
    try {

        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {

            String[] stand = line.split(csvDivisor);
            if(count != 0){
                System.out.println("Stand [event= " + stand[0] 
                                 + " , Stand= " + stand[1] + "]"
                                 + " , area= " + stand[2] + "]"
                                 + ""); 
                
                if(stand.length > 3){
                    list = stand[3];
                    list = list.replace("{", "");
                    list = list.replace("}", "");
                    list = list.replace(")", "");
                    list = list.replace("(", "");
                    listDistance = list.split(",");
    //                System.out.println("[ list= " + list + "]" );

                    for (String listDistance1 : listDistance) {
                        System.out.println("[ listArray= " + listDistance1 + "]");
                    }
                }

                         
            }           
            count++;        
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  }
    
}
