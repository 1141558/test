/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.SubmitApplicationToEventController;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventUI {
   
       private SubmitApplicationToEventController controller;
       
       public SubmitApplicationToEventUI(ExhibitionCentre centre){
           
           this.controller= new SubmitApplicationToEventController(centre);
           
           
       }
}
