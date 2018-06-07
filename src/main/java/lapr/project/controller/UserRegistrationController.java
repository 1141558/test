/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Arrays;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class UserRegistrationController {
    
    private User user;
    
    public UserRegistrationController(){
        this.user=new User();
    }
    
    
    
    
    public boolean setData(String name, String email, String username, String password){
        
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        
        System.out.println(encryptPassword(password));
        user.setPassword(encryptPassword(password));
        
     
        
        return true;
    }
    
    
    
    
    private double encryptPassword(String password){
        double encrypted=0.0;
        
        int [] numCount=new int [10];
        Arrays.fill(numCount,0);
        
        //conta as repetições de cada algarismo
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            int digit=Character.getNumericValue(c);
            numCount[digit]++;
            
        }
        
        //Calcula as probabilidades
        double [] probArray=new double [10];
        
        probArray[0]=((double)numCount[0]/password.length());
        for(int i=1;i<probArray.length;i++){
            probArray[i]=((double)numCount[i]/password.length())+probArray[i-1];
        }
        
        
        double I=0.0, F=1.0;
        double x=0.0,y=1.0;
        
        //Codifica
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            int digit=Character.getNumericValue(c);
            
            //I+delta*probC(digit-1)
            
            x=(digit==0)? I:I+((F-I)*probArray[digit-1]);
            y=I+((F-I)*probArray[digit]);
            
            I=x;
            F=y;
            
        }
        encrypted=I;
        return encrypted;
    }
    
    
    
    
    
}
