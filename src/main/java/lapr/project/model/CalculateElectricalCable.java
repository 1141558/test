/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author JM
 */
public class CalculateElectricalCable {

    
    public static ArrayList<StandConnection> cablePath(List<Stand> stands) {
        int standConnectedCount = 0;
        int standCount = 0;

        ArrayList<StandConnection> connections = new ArrayList<>();

        for (Stand temp : stands) {
            if (temp.getDistanceList() != null) {
                standCount++;
                List<Distance> distancias = temp.getDistanceList();

                for (Distance temp2 : distancias) {
                    StandConnection c = new StandConnection(temp.getDescription(), temp2.getDescription(), temp2.getValue());
                    connections.add(c);
                }
            }
        }

        //Sort connections
        Collections.sort(connections);

        ArrayList<ArrayList<StandConnection>> tree = new ArrayList<>();

        double cableLength = 0.0;

        int indexA = 0, indexB = 0;

        for (StandConnection c : connections) {

            boolean foundA = false;
            boolean foundB = false;
            for (int i = 0; i < tree.size(); i++) {
                for (StandConnection sc : tree.get(i)) {
                    if (c.getA().equals(sc.getA()) || c.getA().equals(sc.getB())) {
                        indexA = i;
                        foundA = true;
                    }
                    if (c.getB().equals(sc.getB()) || c.getB().equals(sc.getA())) {
                        indexB = i;
                        foundB = true;
                    }
                }
            }
//            System.out.println("indexA= "+indexA+foundA);
//            System.out.println("indexB= "+indexB+foundB);
            //Se não existir
            if (!foundA && !foundB) {
                ArrayList<StandConnection> novo = new ArrayList<>();
                novo.add(c);
                tree.add(novo);
                cableLength += c.getDist();
                standConnectedCount++;
//                System.out.println(c.getA()+"-->"+c.getB());
            }

            //Se existir
            if (foundA && !foundB) {
                tree.get(indexA).add(c);
                cableLength += c.getDist();
                standConnectedCount++;
//                System.out.println(c.getA()+"-->"+c.getB());
            }
            if (!foundA && foundB) {
                tree.get(indexB).add(c);
                cableLength += c.getDist();
                standConnectedCount++;
//                System.out.println(c.getA()+"-->"+c.getB());
            }

            if ((foundA && foundB) && (indexA != indexB)) {
                tree.get(indexA).add(c);
                if (indexB < indexA) {
                    int index = indexA;
                    indexA = indexB;
                    indexB = index;
                }
                for (StandConnection s : tree.get(indexB)) {
                    tree.get(indexA).add(s);
                }
                tree.remove(indexB);
                cableLength += c.getDist();
                standConnectedCount++;
//                System.out.println(c.getA()+"-->"+c.getB());
            }

            //Se árvore completa break (ramos=stands-1)
//            if (standConnectedCount >= (standCount - 1)) {
////                System.out.println("Árvore completa");
//                break;
//            }

        }
//        System.out.println("Árvore:");
//
//
//        System.out.println();

        //Ordena a final
        Collections.sort(tree.get(0));

//        for (StandConnection cc : tree.get(0)) {
//            System.out.println(cc.toString());
//        }
//
//        System.out.println("Total: " + cableLength + " metros");

        
        return tree.get(0);
    }
    
    
    public static double cableLength(ArrayList<StandConnection> tree){
        double length=0.0;
        
        for(StandConnection list:tree){
            length+=list.getDist();
        }
        return length;
    }

}

//        CalculateElectricalCable.cablePath(centre.getEventRegister().getEvent(0).getStandRegister().getStandList());
