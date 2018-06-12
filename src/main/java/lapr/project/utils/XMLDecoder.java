/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.Decision;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.PasswordEncryption;
import lapr.project.model.Review;
import lapr.project.model.Role;
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
            e.setTitle(title);
            System.out.println("--------------------TITLE------------------");
            System.out.println(title);
            System.out.println("------------------------------------------");
            StandRegister sr= buildStandRegister(docElement);
            System.out.println("-------------------STANDS------------------");
            for (Stand s : sr.getStandList()) {
                System.out.println(s.getDescription());
                System.out.println(s.getArea());
                for (Distance d : s.getDistanceList()) {
                    System.out.println("****Distances****");    
                    System.out.println(d.getDescription());
                    System.out.println(d.getValue());
                }
                System.out.println("------------------------------------------");

            }
            e.setStandRegister(sr);
            StaffRegister stffr= buildStaffRegister(docElement, centre);
            System.out.println("-------------------STAFFS------------------");

            for (StaffMember sm : stffr.getStaffList()) {
                System.out.println(sm.getStaff().getName());
                System.out.println(sm.getStaff().getEmail());
                System.out.println(sm.getStaff().getPassword());
                System.out.println(sm.getStaff().getUsername());
                System.out.println(sm.getStaff().getRole());
                System.out.println("------------------------------------------");

            }
            e.setStaffRegister(stffr);
            ApplicationRegister  ar= buildApplicationRegister(docElement, e);
            e.setApplicationRegister(ar);
            System.out.println("---------------APPLICATIONS-------------------");
            for (Application app : ar.getApplicationList()) {
                System.out.println(app.getDescription());
                System.out.println(app.getBoothArea());
                System.out.println(app.getNumberInvites());
                System.out.println("****Reviews****");    
                for (Review r : app.getListReview()) {
                    System.out.println(r.getAssignedStaffMember().getStaff().getUsername());
                    System.out.println(r.getText());
                    System.out.println(r.getDecision());
                    System.out.println(r.getEventAdequacy());
                    System.out.println(r.getRecommendation());
                    System.out.println(r.getInviteAdequacy());
                    System.out.println(r.getRecommendation());

                }
                    System.out.println("************");    

                System.out.println("****Keywords****");    
                for (Keyword k : app.getKeywordList()) {
                    System.out.println(k.getValue());

                }
                    System.out.println("************");    

                System.out.println("------------------------------------------");
                
            }
            
            centre.getEventRegister().addEvent(e);
            
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
            u.setPassword(PasswordEncryption.encryptPassword(password));
            u.setUsername(username);
            u.setRole(Role.EMPLOYEE);
            sm.setStaff(u);
            ur.addUser(u);
            sr.addStaffMember(sm);
        }
        centre.setUserRegister(ur);
        return sr;
    }

    private static ApplicationRegister buildApplicationRegister(Element docElement, Event event) {
        
        ApplicationRegister ar= new ApplicationRegister();
        
        NodeList s2 = docElement.getElementsByTagName("applicationSet");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        NodeList applications = el.getElementsByTagName("application");
        for (int i = 0; i < applications.getLength(); i++) {
            Application a= new Application();
            Node application_node = applications.item(i);
            Element application_element = (Element) application_node;
            String accepted = application_element.getElementsByTagName("accepted").item(0).getTextContent();
            String boothArea = application_element.getElementsByTagName("boothArea").item(0).getTextContent();
            String invitesQuantity = application_element.getElementsByTagName("invitesQuantity").item(0).getTextContent();
            String description = application_element.getElementsByTagName("description").item(0).getTextContent();

            NodeList reviews= application_element.getElementsByTagName("reviews");
            Node sr = reviews.item(0);
            Element elr = (Element) sr; 
            NodeList reviews_list = elr.getElementsByTagName("review");
            List<Review> list_reviews= new ArrayList<>();
            NodeList keywords= application_element.getElementsByTagName("topic");
            List<Keyword> list_keywords= new ArrayList<>();
            
            for (int j = 0; j < keywords.getLength(); j++) {
                Keyword k= new Keyword();
                Node keyword_node = keywords.item(j);
                Element keyord_element = (Element) keyword_node;
                String value = keyord_element.getTextContent();
                k.setValue(value);
                list_keywords.add(k);
            }
            for (int j = 0; j < reviews_list.getLength(); j++) {
                Review r= new Review();
                Node review_node = reviews_list.item(j);
                Element review_element = (Element) review_node;
                String text = review_element.getElementsByTagName("text").item(0).getTextContent();
                String staffTopicKnowledge = review_element.getElementsByTagName("staffTopicKnowledge").item(0).getTextContent();
                String eventAdequacy = review_element.getElementsByTagName("eventAdequacy").item(0).getTextContent();
                String inviteAdequacy = review_element.getElementsByTagName("inviteAdequacy").item(0).getTextContent();
                String recommendation = review_element.getElementsByTagName("recommendation").item(0).getTextContent();
                String decision = review_element.getElementsByTagName("decision").item(0).getTextContent();
                String username = review_element.getElementsByTagName("username").item(0).getTextContent();
                if(decision.equalsIgnoreCase("accepted")){
                    r.setDecision(Decision.ACCEPTED);
                }else{
                    r.setDecision(Decision.DECLINED);
                }
                r.setText(text);
                r.setEventAdequacy(Integer.parseInt(eventAdequacy));
                r.setStaffTopicKnowledge(Integer.parseInt(staffTopicKnowledge));
                r.setInviteAdequacy(Integer.parseInt(inviteAdequacy));
                r.setRecommendation(Integer.parseInt(recommendation));
                r.setAssignedStaffMember(event.getStaffRegister().getStaffMemberByUsername(username));
                list_reviews.add(r);
            }
            boolean accepted_bool;
            if(accepted.equalsIgnoreCase(accepted)){
                accepted_bool=true;
            }else{
                accepted_bool=false;
            }
            a.setAccepted(accepted_bool);
            a.setBoothArea(Double.parseDouble(boothArea));
            a.setNumberInvites(Integer.parseInt(invitesQuantity));
            a.setDescription(description);
            a.setKeywordList(list_keywords);
            a.setListReview(list_reviews);
            ar.addApplication(a);
        }
        return ar;
    }
}

