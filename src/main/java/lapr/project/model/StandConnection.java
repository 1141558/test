/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author JM
 */
public class StandConnection implements Comparable <StandConnection> {
    String a;
    String b;
    double dist;
    
    public StandConnection(String a, String b, double dist){
        this.a=a;
        this.b=b;
        this.dist=dist;
    }
    
    
    public String getA(){
        return this.a;
    }
    
    public String getB(){
        return this.b;
    }
    
    public double getDist(){
        return this.dist;
    }
    public void setA(String a){
        this.a=a;
    }
    
    public void setB(String b){
        this.b=b;
    }
    
    public void setDist(double dist){
        this.dist=dist;
    }
    


    @Override
    public int compareTo(StandConnection o) {
        if(this.dist<o.getDist()){
            return -1;
        }
        if(this.dist>o.getDist()){
            return 1;
        }
        if(this.dist==o.getDist()){
            return 0;
        }
        return 0;
    }
    
    
    @Override
    public String toString(){
        return a+" --> "+b+"  ("+dist+" meters)";
    }
}


       