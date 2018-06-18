package lapr.project.ui;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.controller.AssignStandToApplicationController;
import lapr.project.model.CalculatorExample;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import lapr.project.utils.Utils;
import lapr.project.utils.XMLDecoder;
import org.xml.sax.SAXException;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {
    
    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        CalculatorExample calculatorExample = new CalculatorExample();
        InitialMenuUI initialMenuUI;
        
      
        ExhibitionCentre centre = new ExhibitionCentre();
        /*
         * descomentem esta linha se quiserem testar a leitura, mudem o path para o path do vosso PC
        */

        Console c= System.console();
        if(c==null){
        //XMLDecoder.readExhibitionCentreFile("./src/main/resources/exhibition1_v0.1.xml", centre);
            
        }else{
        //XMLDecoder.readExhibitionCentreFile("../src/main/resources/exhibition1_v0.1.xml", centre);
           
        }
        
        /*dados de teste (APAGAR FUTURAMENTE)*/
        User u1 = new User("nome1", "email1", "username1", 0.0);
        User u2 = new User("nome2", "email2", "username2", 0.0);
        User u3 = new User("Andre", "mailu3", "andr", 133);
        User u4 = new User("Maria", "mariamail@hotmail.com", "mar", 123);        
        User u5 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133);
        User u6 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
        u1.setRole(Role.EMPLOYEE);
        u2.setRole(Role.EMPLOYEE);
        u3.setRole(Role.EMPLOYEE);
        u4.setRole(Role.EMPLOYEE);
        u5.setRole(Role.PARTICIPANT);
        u6.setRole(Role.PARTICIPANT);
        UserRegister ur = new UserRegister();
        StaffRegister staffRegs = new StaffRegister();
        ur.addUser(u1);
        ur.addUser(u2);    
        ur.addUser(u3);
        ur.addUser(u4);
        ur.addUser(u5);
        ur.addUser(u6);
        

        Organiser org1 = new Organiser();
        org1.setOrganiser(u1);
        Organiser org2 = new Organiser();
        org2.setOrganiser(u2);
        OrganiserRegister organiserRegister1 = new OrganiserRegister();
        organiserRegister1.addOrganiser(org1);
        organiserRegister1.addOrganiser(org2);
        
        StaffMember staffMember1= new StaffMember();
        staffMember1.setUser(u1);
        List<StaffMember> staffList = new ArrayList<StaffMember>();
        staffList.add(staffMember1);
                
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.add(staffList);
        centre.setStaffRegister(staffRegister);
      //  *********************************************************************************************
        centre.setUserRegister(ur);
        centre.setOrganiserRegister(organiserRegister1);
        centre.setUserOnline(u1);
//        // fim dados de teste*/
//       // *****************************************************************************************************
//         //***************************************************/
         initialMenuUI = new InitialMenuUI(centre);
//         
//        /***
//         * 
//         */
//       
//         /*Testar Assign event*/
//        
//        System.out.println("Teste atribuir stands");
//         AssignStandToApplicationController nreAssignStaffToApplicationController = new AssignStandToApplicationController();
//        nreAssignStaffToApplicationController.matchsApplicationOnEventListByOrganiserWithStandList();
//        
//        
//       //********************************************************************************************************************* 
//        
//        
    }
    
}
