/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class DistanceTest {
    
    @Test
    public void equalsValueTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setValue(22.5);
        distance1.setValue(22.5);
        
        Assert.assertEquals(distance1.getValue(), distance.getValue());
        
    }
    
    @Test
    public void notEqualsValueTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setValue(22.5);
        distance1.setValue(21.5);
        
        Assert.assertNotEquals(distance1.getValue(), distance.getValue());
        
    }
    
    @Test
    public void equalsDescriptionTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        
        Assert.assertEquals(distance1.getDescription(), distance.getDescription());
        
    }
    
    @Test
    public void notEqualsDescriptionTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao1");
        
        Assert.assertNotEquals(distance1.getDescription(), distance.getDescription());
        
    }
    
    @Test
    public void hashCodeTest() {
        
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        Assert.assertEquals(distance.hashCode(), distance1.hashCode());
    }
    
    @Test
    public void testEqualsDistanceObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(22.5);
        distance1.setValue(22.5);
        
        Assert.assertTrue(distance.equals(distance1));
    }
    
    @Test
    public void testDiferentDistanceObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(21.5);
        distance1.setValue(22.5);
        
        Assert.assertFalse(distance.equals(distance1));
    }
    
    @Test
    public void testFalseDescritionObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao1");
        distance1.setDescription("descricao");
        
        Assert.assertFalse(distance.equals(distance1));
    }
    
    @Test
    public void testFalseClassObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        Organiser org = new Organiser();
        distance.setDescription("descricao1");
        distance1.setDescription("descricao");
        
        Assert.assertFalse(distance.equals(org));
    }
    
    @Test
    public void testEqualsObjects() {
        
        Distance distance1 = new Distance();
        
        distance1.setDescription("descricao");
        
        distance1.setValue(22.5);
        
        Assert.assertTrue(distance1.equals(distance1));
    }
    
    @Test
    public void testString() {
        Distance distance = new Distance();
        distance.setDescription("descricao1");
        distance.setValue(21.5);
        String expecteds = distance.toString();
        distance.getValue().toString();
        distance.getDescription().toString();
          
    }
       
     
    @Test
    public void testCompareTo() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(22.6);
        distance1.setValue(222222.55);
        distance.compareTo(distance1); Assert.assertTrue((distance.getValue()<distance1.getValue()));
        
    }
    
    @Test
    public void testFalseObjects() {
        
        Distance distance1 = new Distance();
        Distance distance2 = null;
        distance1.setDescription("descricao");
        
        distance1.setValue(22.5);
        
        Assert.assertFalse(distance1.equals(distance2));
    }
    
    @Test
    public void testHashCode() {
        
        Distance distance = new Distance();
        distance.setValue(21.5);
        distance.setDescription("descriction");
        int dis = distance.hashCode();
        Assert.assertEquals(-1773172174, dis);
        
    }
    
    @Test
    public void testHashCode2() {
        Distance distance = new Distance();
        distance.setValue(21.5);
        distance.setDescription("descriction");
        int dis = distance.getDescription().hashCode();
        Assert.assertEquals(-1736551825, dis);
        
    }
    
     @Test
    public void testCompareTo2() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(0.000);
        distance1.setValue(0.100001);
        distance.compareTo(distance1);
        Assert.assertTrue((distance.getValue()<distance1.getValue()));
        
    }
    
    
    
}
