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
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
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
        /***
         * 
         */
        AssignStandToApplicationController nreAssignStaffToApplicationController = new AssignStandToApplicationController();
        
       //********************************************************************************************************************* 
        
        
        ExhibitionCentre centre = new ExhibitionCentre();
        /*
         * descomentem esta linha se quiserem testar a leitura, mudem o path para o path do vosso PC
        */

        Console c= System.console();
        if(c==null){
        XMLDecoder.readExhibitionCentreFile("./src/main/resources/exhibition1_v0.1.xml", centre);
            
        }else{
        XMLDecoder.readExhibitionCentreFile("../src/main/resources/exhibition1_v0.1.xml", centre);
           
        }
        
        /*dados de teste (APAGAR FUTURAMENTE)
        User u1 = new User("nome1", "email1", "username1", 0.0);
        User u2 = new User("nome2", "email2", "username2", 0.0);
        UserRegister ur = new UserRegister();
        StaffRegister staffRegs = new StaffRegister();
        ur.addUser(u1);
        ur.addUser(u2);
        
        //*****************************************************************************************
        //************************Criar registo de utilizadores***********************************
        User uloged = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
        User u2A = new User("jose", "mail2@hotmail.com", "jo", 123);
        User u12 = new User("manuel2", "mjdg111@hotmail.com", "garnel2", 123);
        User u123 = new User("manuel23", "mjdg111@hotmail.com", "garnel23", 123);
        User u1234 = new User("Josel234", "Jose@hotmail.com", "Jose1234", 123);
        User u22 = new User("jo", "mail2@hotmail.com", "jo", 123);
        
        User u3 = new User("Andre", "mailu3", "andr", 133);
        User u4 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
        
        User u5 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133);
        User u6 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
        
        ur.addUser(u2A);
        ur.addUser(u12);
        ur.addUser(u4);
        ur.addUser(u5);
        ur.addUser(u6);
        ur.addUser(uloged);
        
        User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
        User user2 = new User("jose", "mail2@hotmail.com", "jo", 123);
        Organiser org1 = new Organiser();
        org1.setOrganiser(user1);
        Organiser org2 = new Organiser();
        org2.setOrganiser(user2);
        OrganiserRegister organiserRegister1 = new OrganiserRegister();
        organiserRegister1.addOrganiser(org1);
        organiserRegister1.addOrganiser(org2);
        
        StaffMember staffMember1= new StaffMember();
        staffMember1.setStaff(u1);
        List<StaffMember> staffList = new ArrayList<StaffMember>();
        staffList.add(staffMember1);
                
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.add(staffList);
        centre.setStaffRegister(staffRegister);
        //*********************************************************************************************
        centre.setUserRegister(ur);
        centre.setOrganiserRegister(organiserRegister1);
        
       fim dados de teste*/
        
                //*****************************************************************************************************
        /*Testar Assign event*/
        
        System.out.println("Teste atribuir stands");
        nreAssignStaffToApplicationController.matchsApplicationOnEventListByOrganiserWithStandList();
        
        
       // ***************************************************/
        new InitialMenuUI(centre);
        
    }
    
}
