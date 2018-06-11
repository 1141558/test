/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MariaJoão
 */
public class Stand {
   
    private String title;
    private double area;
    private List<Distance> distanceList;
    
    public Stand() {
        this.distanceList= new ArrayList<>();

    }

    public Stand(String title, double area) {
        this.title = title;
        this.area = area;
        this.distanceList= new ArrayList<>();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the distanceList
     */
    public List<Distance> getDistanceList() {
        return distanceList;
    }

    /**
     * @param distanceList the distanceList to set
     */
    public void setDistanceList(List<Distance> distanceList) {
        this.distanceList = distanceList;
    }
    
}
