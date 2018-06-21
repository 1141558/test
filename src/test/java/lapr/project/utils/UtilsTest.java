/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Calendar;
import java.util.Date;
import lapr.project.controller.CreateEventController;
import lapr.project.model.ExhibitionCentre;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class UtilsTest {
        
    @Test
    public void testChangeFormat(){
        System.out.println("checkFormat");
        Date startDate = new Date();        
        String startDateString = "2018-07-07";
        ExhibitionCentre centre= new ExhibitionCentre();
        Date expResult= new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );

        calendar.set( Calendar.DAY_OF_MONTH, 7 );
        calendar.set( Calendar.YEAR, 2018 );
        //6 beacuse it starts at zero
        calendar.set( Calendar.MONTH, 6 );
        expResult=calendar.getTime();
        
        Date result = Utils.changeFormat(startDate, startDateString);
        assertEquals(result, expResult);
    }
}
