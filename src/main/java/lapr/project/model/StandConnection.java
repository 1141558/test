/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author JM
 */
public class StandConnection implements Comparable<StandConnection> {

    String a;
    String b;
    double dist;

    public StandConnection(String a, String b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    public String getA() {
        return this.a;
    }

    public String getB() {
        return this.b;
    }

    public double getDist() {
        return this.dist;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    @Override
    public int compareTo(StandConnection o) {
        if (this.dist < o.getDist()) {
            return -1;
        }
        if (this.dist > o.getDist()) {
            return 1;
        }
        if (Double.compare(this.dist, o.getDist()) == 0) {
            return 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return a + " --> " + b + "  (" + dist + " meters)";
    }

    @Override
    public boolean equals(Object obj) {
        return (this.a.equals(((StandConnection) obj).getA())) && (this.b.equals(((StandConnection) obj).getB()))
                && (Double.compare(this.dist, ((StandConnection) obj).getDist()) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.a);
        hash = 43 * hash + Objects.hashCode(this.b);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.dist) ^ (Double.doubleToLongBits(this.dist) >>> 32));
        return hash;
    }
}
