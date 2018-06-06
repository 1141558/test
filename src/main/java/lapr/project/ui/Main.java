package lapr.project.ui;

import lapr.project.model.CalculatorExample;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

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
    public static void main(String[] args) {

        CalculatorExample calculatorExample = new CalculatorExample();
        System.out.println(calculatorExample.sum(3, 5));
        ExhibitionCentre centre= new ExhibitionCentre();
        
        /*dados de teste (APAGAR FUTURAMENTE)*/
        User u1= new User("nome1", "email1","username1",0.0);       
        User u2= new User("nome2", "email2","username2",0.0);
        UserRegister ur= new UserRegister();
        ur.addUser(u1);
        ur.addUser(u2);
        centre.setUserRegister(ur);
        /*fim dados de teste*/
        
        
        new MainMenu(centre);   
        
    }

}
