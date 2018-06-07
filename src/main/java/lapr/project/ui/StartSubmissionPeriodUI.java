/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
import lapr.project.controller.StartSubmissionPeriodController;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodUI {
    
    StartSubmissionPeriodController controller;
    
    public StartSubmissionPeriodUI(ExhibitionCentre exhibitionCentre){
        this.controller = new StartSubmissionPeriodController(exhibitionCentre);
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           START EVENT'S APPLICATION SUBMISSION PERIOD           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
    
    }
    
    
}
