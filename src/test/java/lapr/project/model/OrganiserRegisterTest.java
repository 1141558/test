/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class OrganiserRegisterTest {
    
    
    @Test
    public void organiserRegisterTest(){
          //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);

        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        OrganiserRegister organiserRegister = new OrganiserRegister();
        organiserRegister.addOrganiser(organiser);
        organiserRegister.registerOrganiser(user);
        
    }
         
    
}
