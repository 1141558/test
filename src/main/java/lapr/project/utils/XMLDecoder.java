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
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
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
        
        } catch (ParserConfigurationException | IOException | SAXException e) {
                Utils.printError("FAILED TO LOAD FILE : "+e.getMessage());
                
        }

    }
}
