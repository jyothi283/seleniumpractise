package XmlReaderPrac;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class StudentXml {

	public static void main(String[] args) {

		try {
            File inputFile = new File("C:\\Users\\vrvam\\eclipse-workspace\\Rest_Practise\\src\\student.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); //removing extra space or indentation
            
            
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element nNode = (Element) nList.item(temp);
                System.out.println("Student id : "
                        + nNode.getAttribute("id"));
                System.out.println("First Name : "
                        + nNode.getElementsByTagName("firstname")
                        .item(0)
                        .getTextContent());
                System.out.println("Last Name : "
                        + nNode.getElementsByTagName("lastname")
                        .item(0)
                        .getTextContent());
                System.out.println("Subject : "
                        + nNode.getElementsByTagName("subject")
                        .item(0)
                        .getTextContent());
                System.out.println("Marks : "
                        + nNode.getElementsByTagName("marks")
                        .item(0)
                        .getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	
	
	
	
	
	
	
	}
}