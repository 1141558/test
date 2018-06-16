/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class CalculateElectricalCableTest {

    /**
     * Test of cablePath method, of class CalculateElectricalCable.
     */
    @Test
    public void testCablePath() {
        System.out.println("cablePath");
        //Arrange
        Stand s1 = new Stand("s1");
        List<Distance> distanceList = new ArrayList<>();
        Distance d1 = new Distance("s2", 13.3);
        Distance d2 = new Distance("s3", 3.3);
        distanceList.add(d1);
        distanceList.add(d2);
        s1.setDistanceList(distanceList);

        Stand s2 = new Stand("s2");
        List<Distance> distanceList2 = new ArrayList<>();
        Distance d3 = new Distance("s3", 5.5);
        distanceList2.add(d3);
        s2.setDistanceList(distanceList2);

        Stand s3 = new Stand("s3");

        List<Stand> stands = new ArrayList<>();
        stands.add(s1);
        stands.add(s2);
        stands.add(s3);

        ArrayList<StandConnection> expResult = new ArrayList<>();
        StandConnection c1 = new StandConnection("s1", "s3", 3.3);
        StandConnection c2 = new StandConnection("s2", "s3", 5.5);

        expResult.add(c1);
        expResult.add(c2);
        //Act
        ArrayList<StandConnection> result = CalculateElectricalCable.cablePath(stands);

        //Assert
        int i = 0;
        for (StandConnection e : expResult) {
            assertEquals(e.getA(), result.get(i).getA());
            assertEquals(e.getDist(), result.get(i).getDist(), 0);
            i++;
        }
    }

    /**
     * Test of cableLength method, of class CalculateElectricalCable.
     */
    @Test
    public void testCableLength() {
        System.out.println("cableLength");
        //Arrange
        ArrayList<StandConnection> tree = new ArrayList<>();
        StandConnection c1 = new StandConnection("a", "b", 5.24);
        StandConnection c2 = new StandConnection("a", "b", 5.24);
        tree.add(c1);
        tree.add(c2);
        double expResult = 10.48;
        //Act
        double result = CalculateElectricalCable.cableLength(tree);
        //Assert
        assertEquals(expResult, result, 0.0);
    }

}
