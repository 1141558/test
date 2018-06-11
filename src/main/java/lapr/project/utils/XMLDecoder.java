/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MariaJoão
 */
public class XMLDecoder {
    private static final String USER_TAG = "user";
    private static final String EVENT_TAG = "event";

    public static void readExhibitionCentreFile(String filePath, ExhibitionCentre centre) throws ParserConfigurationException, SAXException, IOException {

        try {
        
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filePath));
            Element docElement = doc.getDocumentElement();
            Event e = new Event();    
            String title = docElement.getElementsByTagName("title").item(0).getTextContent();
            StandRegister sr= buildStandRegister(docElement);          
            StaffRegister stffr= buildStaffRegister(docElement, centre);

        } catch (ParserConfigurationException | IOException | SAXException e) {
                Utils.printError("FAILED TO LOAD FILE : "+e.getMessage());
                
        }

    }

    private static StandRegister buildStandRegister(Element docElement) {
        NodeList s2 = docElement.getElementsByTagName("stands");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        StandRegister sr= new StandRegister();
        NodeList stands = el.getElementsByTagName("stand");
        for (int i = 0; i < stands.getLength(); i++) {
            Stand stand_obj= new Stand();
            Node stand = stands.item(i);
            Element stand_element = (Element) stand;
            String description = stand_element.getElementsByTagName("description").item(0).getTextContent();
            String area = stand_element.getElementsByTagName("area").item(0).getTextContent();
            stand_obj.setDescription(description);
            stand_obj.setArea(Double.parseDouble(area));           
            NodeList distances= stand_element.getElementsByTagName("distance");

            if(distances.getLength()>0){
            for (int j = 0; j < distances.getLength(); j++) {
                Distance distance_obj= new Distance();
                Node distance = distances.item(j);
                Element distance_element = (Element) distance;
                String description_d = distance_element.getElementsByTagName("description").item(0).getTextContent();
                String value_d = distance_element.getElementsByTagName("value").item(0).getTextContent();            
                distance_obj.setDescription(description_d);
                distance_obj.setValue(Double.parseDouble(value_d));
                stand_obj.addDistance(distance_obj);
            }
            }
            sr.addStand(stand_obj);
            
        }
        return sr;
    }

    private static StaffRegister buildStaffRegister(Element docElement, ExhibitionCentre centre) {
        
        StaffRegister sr= new StaffRegister();
        
        NodeList s2 = docElement.getElementsByTagName("StaffSet");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        NodeList staffs = el.getElementsByTagName("staff");
        UserRegister ur= new UserRegister();
        
        for (int i = 0; i < staffs.getLength(); i++) {
            User u= new User();
            StaffMember sm= new StaffMember();
            Node staff_node = staffs.item(i);
            Element staff_element = (Element) staff_node;
            String name = staff_element.getElementsByTagName("name").item(0).getTextContent();
            String email = staff_element.getElementsByTagName("email").item(0).getTextContent();
            String username = staff_element.getElementsByTagName("username").item(0).getTextContent();
            String password = staff_element.getElementsByTagName("password").item(0).getTextContent();
            u.setEmail(email);
            u.setName(name);
            u.setPassword(Double.parseDouble(password));
            u.setUsername(username);
            sm.setStaff(u);
            ur.addUser(u);
            sr.addStaffMember(sm);
        }
        centre.setUserRegister(ur);
        return sr;
    }
}
