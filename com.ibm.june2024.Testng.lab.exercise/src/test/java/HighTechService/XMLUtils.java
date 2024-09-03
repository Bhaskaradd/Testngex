package HighTechService;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {
    public static String[][] readFile(String fileName) throws Exception { // Do not change the method signature
	
		//Using the file name passed to this method, parse the XML file, read the XML data and store it in a string array.
		//Store XML values in a string array xmlData[][] 
		//xmlData[0][0]  is 'CustomerName' read from xml file
		//xmlData[0][1]  is 'MobileNumber' read from xml file  
		//xmlData[0][2]  is 'Email' read from xml file  
		//xmlData[0][3]  is 'Address' read from xml file  
		//xmlData[0][4]  is 'ACType' read from xml file  
		//xmlData[0][5]  is 'ServiceType' read from xml file 
		//xmlData[0][6]  is 'Maintenance' read from xml file 
		//xmlData[0][7]  is 'Duration' read from xml file 
		
		//Return the array.   
    	
    	
    	String[][] xmlData = new String[1][8];
    	
    	
		try   
        {	 	  	  		 	     	     	      	 	
            
            //creating a constructor of file class and parsing an XML file  
            File file = new File(fileName);  
            //an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            //an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);  
            doc.getDocumentElement().normalize();  
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
            NodeList nodeList = doc.getElementsByTagName("Service");  
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++)   
            { 
                
                Node node = nodeList.item(itr);  
                System.out.println("\nNode Name :" + node.getNodeName());  
                if (node.getNodeType() == Node.ELEMENT_NODE)   
                {  
                        Element eElement = (Element) node;  
                        
                        xmlData[0][0] = eElement.getElementsByTagName("CustomerName").item(0).getTextContent();
                        xmlData[0][1] = eElement.getElementsByTagName("MobileNumber").item(0).getTextContent();
                        xmlData[0][2] = eElement.getElementsByTagName("Email").item(0).getTextContent();
                        xmlData[0][3] = eElement.getElementsByTagName("Address").item(0).getTextContent();
                        xmlData[0][4] = eElement.getElementsByTagName("ACType").item(0).getTextContent();
                        xmlData[0][5] = eElement.getElementsByTagName("ServiceType").item(0).getTextContent();
                        xmlData[0][6] = eElement.getElementsByTagName("Maintenance").item(0).getTextContent();
                        xmlData[0][7] = eElement.getElementsByTagName("Duration").item(0).getTextContent();
                }  
            }  
        }   
        catch (Exception e)   
        {	 	  	  		 	     	     	      	 	
            e.printStackTrace();  
        }  
        
        return xmlData;
        

	
		
      
       
    }

    
}