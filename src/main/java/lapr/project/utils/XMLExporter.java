/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Organiser;
import lapr.project.model.Review;
import lapr.project.model.StaffMember;
import lapr.project.model.Stand;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author MariaJoão
 */
public class XMLExporter {
    
    public XMLExporter(ExhibitionCentre centre) throws ParserConfigurationException, SAXException, IOException{
                        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file= new File("./src/main/resources/exhibition1_v0.1_1.xml");
        file.delete();
        Document document = builder.newDocument();
        
        for (Event e : centre.getEventRegister().getEventList()) {
                Element exhibitionEl = document.createElement("event");
                Element titleEl = document.createElement("title");
                titleEl.setTextContent(e.getTitle());
                Element nrRoomsEl = document.createElement("numberRooms");
                if(e.getRooms()!=0){
                    nrRoomsEl.setTextContent(String.valueOf(e.getRooms()));
                }
                Element placeEl = document.createElement("place");

                if(isEmpty(e.getPlace())){
                    placeEl.setTextContent(e.getPlace());
                }
                Element startDateEl = document.createElement("startDate");

                if(e.getStartDate()!=null){
                    startDateEl.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(e.getStartDate()));
                }
                Element endDateEl = document.createElement("endDate");

                if(e.getEndDate()!=null){
                    endDateEl.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(e.getEndDate()));
                }               
                Element standsEl = document.createElement("stands");
                for (Stand s : e.getStandRegister().getStandList()) {                
           
                    Element standEl = document.createElement("stand");
                    Element descriptionEl = document.createElement("description");
                    descriptionEl.setTextContent(s.getDescription());
                    Element areaEl = document.createElement("area");
                    areaEl.setTextContent(String.valueOf(s.getArea()));
                    Element relativeDistanceSetEl = document.createElement("relativeDistanceSet");
                    
                    for (Distance d  : s.getDistanceList()) {
                        Element distanceEl = document.createElement("distance");
                        Element distanceDescriptionEl = document.createElement("description");
                        distanceDescriptionEl.setTextContent(d.getDescription());
                        Element distanceValueEl = document.createElement("value");
                        distanceValueEl.setTextContent(String.valueOf(d.getValue()));
                        relativeDistanceSetEl.appendChild(distanceEl);
                        distanceEl.appendChild(distanceDescriptionEl);
                        distanceEl.appendChild(distanceValueEl);                        
                    }

                    standEl.appendChild(descriptionEl);
                    standEl.appendChild(areaEl);
                    standEl.appendChild(relativeDistanceSetEl);
                    standsEl.appendChild(standEl);
                    
                }
                Element StaffsEl = document.createElement("StaffSet");
                for (StaffMember s : e.getStaffRegister().getStaffList()) {
                    Element staffEl = document.createElement("staff");
                    Element userEl = document.createElement("user");
                    Element staffNameEl = document.createElement("name");
                    staffNameEl.setTextContent(s.getStaff().getName());
                    Element usernameEl = document.createElement("username");
                    usernameEl.setTextContent(s.getStaff().getUsername());
                    Element emailEl = document.createElement("email");
                    emailEl.setTextContent(s.getStaff().getEmail());
                    Element passwordEl = document.createElement("password");
                    passwordEl.setTextContent(String.valueOf(s.getStaff().getPassword()));
                    userEl.appendChild(staffNameEl);
                    userEl.appendChild(usernameEl);
                    userEl.appendChild(emailEl);
                    userEl.appendChild(passwordEl);
                    staffEl.appendChild(userEl);
                    StaffsEl.appendChild(staffEl);
                }
                Element OrganisersEl = document.createElement("organiserSet");
                for (Organiser o : e.getOrganiserRegister().getOrganiserList()) {
                    Element organiserEl = document.createElement("organiser");
                    Element user2El = document.createElement("user");
                    Element organiserNameEl = document.createElement("name");
                    organiserNameEl.setTextContent(o.getOrganiser().getName());
                    Element username2El = document.createElement("username");
                    username2El.setTextContent(o.getOrganiser().getUsername());
                    Element email2El = document.createElement("email");
                    email2El.setTextContent(o.getOrganiser().getEmail());
                    Element password2El = document.createElement("password");
                    password2El.setTextContent(String.valueOf(o.getOrganiser().getPassword()));
                    user2El.appendChild(organiserNameEl);
                    user2El.appendChild(username2El);
                    user2El.appendChild(email2El);
                    user2El.appendChild(password2El);
                    organiserEl.appendChild(user2El);
                    OrganisersEl.appendChild(organiserEl);
                }
                

                Element applicationSetEl = document.createElement("applicationSet");
                for (Application a : e.getApplicationRegister().getApplicationList()) {
                    Element applicationEl = document.createElement("application");
                    Element appDescriptionEl = document.createElement("description");
                    appDescriptionEl.setTextContent(a.getDescription());
                    Element appCompanyEl = document.createElement("companyName");
                   
                    if(isEmpty(a.getNameOfCompany())){
                        appCompanyEl.setTextContent(a.getNameOfCompany());
                    }
                    Element appPhoneNumberEl = document.createElement("phoneNumber");
                    if(a.getPhoneNumber()!=0){
                        appPhoneNumberEl.setTextContent(String.valueOf(a.getPhoneNumber()));
                    }
                    Element appVatNumberEl = document.createElement("vatNumber");
                    if(a.getVatNumber()!=0){
                        appVatNumberEl.setTextContent(String.valueOf(a.getPhoneNumber()));
                    }
                    Element boothAreaEl = document.createElement("boothArea");
                    boothAreaEl.setTextContent(String.valueOf(a.getBoothArea()));
                    Element aceptedEl = document.createElement("accepted");
                    if(a.getState().equals(ApplicationState.ACCEPTED)){
                        aceptedEl.setTextContent("true");                        
                    }else if(a.getState().equals(ApplicationState.REJECTED)){
                        aceptedEl.setTextContent("false");                                              
                    }
                    Element invitesEl = document.createElement("invitesQuantity");
                    invitesEl.setTextContent(String.valueOf(a.getNumberInvites()));
                    Element topicsEl = document.createElement("topics");
                    
                    for (Keyword k : a.getKeywordList()) {
                        Element topicEl = document.createElement("topic");
                        topicEl.setTextContent(k.getValue());
                        topicsEl.appendChild(topicEl);    
                    }
                    
                    Element elementReviews = document.createElement("reviews");
                    for (Review r : a.getListReview()) {
                        Element elementReview = document.createElement("review");
                        Element elementReviewText = document.createElement("text");
                        elementReviewText.setTextContent(r.getText());
                        Element elementReviewStaffTopicKnowledge = document.createElement("staffTopicKnowledge");
                        elementReviewStaffTopicKnowledge.setTextContent(String.valueOf(r.getStaffTopicKnowledge()));
                        Element elementReviewEventAdequacy = document.createElement("eventAdequacy");
                        elementReviewEventAdequacy.setTextContent(String.valueOf(r.getEventAdequacy()));
                        Element elementReviewInviteAdequacy = document.createElement("inviteAdequacy");
                        elementReviewInviteAdequacy.setTextContent(String.valueOf(r.getInviteAdequacy()));
                        Element elementReviewRecommendation = document.createElement("recommendation");
                        elementReviewRecommendation.setTextContent(String.valueOf(r.getRecommendation()));
                        Element elementReviewDecision = document.createElement("decision");
                        elementReviewDecision.setTextContent(r.getDecision().name().toLowerCase());
                        Element elementReviewAssignment = document.createElement("assignment");
                        Element elementReviewStaff = document.createElement("staff");
                        Element elementReviewUser = document.createElement("user");
                        Element elementReviewUserName = document.createElement("name");
                        elementReviewUserName.setTextContent(r.getAssignedStaffMember().getStaff().getName());
                        Element elementReviewUserEmail = document.createElement("email");
                        elementReviewUserEmail.setTextContent(r.getAssignedStaffMember().getStaff().getEmail());
                        Element elementReviewUserUname = document.createElement("username");
                        elementReviewUserUname.setTextContent(r.getAssignedStaffMember().getStaff().getUsername());
                        Element elementReviewUserPwd = document.createElement("password");
                        elementReviewUserPwd.setTextContent(String.valueOf(r.getAssignedStaffMember().getStaff().getPassword()));

                        elementReviews.appendChild(elementReview);
                        elementReview.appendChild(elementReviewText);
                        elementReview.appendChild(elementReviewStaffTopicKnowledge);
                        elementReview.appendChild(elementReviewEventAdequacy);
                        elementReview.appendChild(elementReviewInviteAdequacy);
                        elementReview.appendChild(elementReviewRecommendation);
                        elementReview.appendChild(elementReviewDecision);
                        elementReview.appendChild(elementReviewAssignment);

                        elementReviewUser.appendChild(elementReviewUserName);
                        elementReviewUser.appendChild(elementReviewUserEmail);
                        elementReviewUser.appendChild(elementReviewUserUname);
                        elementReviewUser.appendChild(elementReviewUserPwd);
                        elementReviewStaff.appendChild(elementReviewUser);
                        elementReviewAssignment.appendChild(elementReviewStaff);                        
                    }


                    applicationEl.appendChild(appDescriptionEl);
                    applicationEl.appendChild(boothAreaEl);
                    applicationEl.appendChild(invitesEl);
                    applicationEl.appendChild(appVatNumberEl);
                    applicationEl.appendChild(appPhoneNumberEl);
                    applicationEl.appendChild(appCompanyEl);
                    applicationEl.appendChild(topicsEl);
                    applicationEl.appendChild(elementReviews);
                    applicationEl.appendChild(aceptedEl);
                    applicationSetEl.appendChild(applicationEl);
                }
                




                //Add sub-element to root element
                exhibitionEl.appendChild(titleEl);
                exhibitionEl.appendChild(startDateEl);
                exhibitionEl.appendChild(endDateEl);
                exhibitionEl.appendChild(placeEl);
                exhibitionEl.appendChild(standsEl);
                exhibitionEl.appendChild(StaffsEl);
                exhibitionEl.appendChild(OrganisersEl);
                exhibitionEl.appendChild(applicationSetEl);
                exhibitionEl.appendChild(nrRoomsEl);


                //Add root element to document
                document.appendChild(exhibitionEl);
        }
        
try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(document), 
                                 new StreamResult(new FileOutputStream("./src/main/resources/exhibition1_v0.1_1.xml")));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
   
    }
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
