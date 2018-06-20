/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class StandRegisterTest {
    
    private Stand stand1 = new Stand();
    private Stand stand2 = new Stand();
    private Stand stand3 = new Stand();
    StandRegister standRegister = new StandRegister();
    private List<Distance> distanceList;
    
    @Test
    public void registerEventTrueTest() {
        
        //Arrange
        standRegister.addStand(stand1);
        
        //Act
        boolean expectedResult = true;
        boolean result = standRegister.addStand(stand1);
        
        //Assert
        Assert.assertEquals(result, expectedResult);
    }
    
    @Test
    public void getStandListTest() {
        
        //Arrange
        standRegister.addStand(stand1);
        
        //Act
        List<Stand> standsList = standRegister.getStandList();
        String resultExpected = "Stand{description=null, area=0.0, distanceList=}\n";
        
        //Assert
        Assert.assertEquals(resultExpected, standsList.get(0).toString());
    }
    
    @Test
    public void getStandByDescritionNullTest() {
        
        StandRegister standRegister = new StandRegister();
        Stand s = new Stand("STAND1", 2.50);
        standRegister.addStand(stand1);
        standRegister.addStand(s);
        List<Distance> distance = new ArrayList<>();
        //Act
        List<Stand> standsList1 = new ArrayList<>();
        standRegister.setStandList(standsList1);
        standRegister.getStandByDescriptionStand(s);
        Assert.assertTrue(standRegister.isEmptyStandList());
    }
    
    @Test
    public void getStandByDescritionTest() {
        List<Distance> distance = new ArrayList<>();
        StandRegister standRegister = new StandRegister();
        Stand s = new Stand("STAND1", 2.50);
        stand1.setDistanceList(distanceList);
        standRegister.addStand(stand1);
        standRegister.addStand(s);
        stand1.setDistanceList(distance);
        
        //Act
    }
    
    @Test
    public void hashCodeTest() {
        
        StandRegister standRegister = new StandRegister();
        StandRegister standRegister1 = new StandRegister();
        
        Assert.assertEquals(standRegister.hashCode(), 260);
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Stand s = new Stand("STAND1", 2.50);
        Stand stand1 = new Stand("STAND1", 2.50);
        StandRegister standReg = new StandRegister();
        
        standReg.getStandByDescriptionStand(s);
        
        System.out.println("" + standRegister.getStandByDescriptionStand(stand1));
        
        assertNull(standRegister.getStandByDescriptionStand(stand1));
    }
    
    @Test
    public void testEqualsTwo() {
        
        Stand s = new Stand("STAND1", 2.50);
        Stand s2 = new Stand("STAND1", 2.50);
        StandRegister standReg = new StandRegister();
        List<Stand> standList = new ArrayList<>();
        standList.add(s);
        standList.add(s2);
        standReg.setStandList(standList);
        Stand stand3 = standReg.getStandByDescriptionStand(s);
        System.out.println("stan3" + stand3);
        Assert.assertNotNull(stand3);
        
    }
    
    @Test
    public void testEqualFalse() {
        
        Stand s = new Stand("STAND1", 2.50);
        
        StandRegister standReg = new StandRegister();
        
        standReg.getStandByDescriptionStand(s);
        
        boolean result = standReg.equals(s);
        
        Assert.assertFalse(result);
    }
}
