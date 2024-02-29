package XmlReaderPrac;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EmployeeXml {

	public static void main(String[] args) {
		try {
	        File inputFile = new File("C:\\Users\\vrvam\\eclipse-workspace\\Rest_Practise\\src\\XmlReaderPrac\\emp.xml");
	        
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize(); //removing extra space or indentation
	        
	        
	        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        
	        NodeList nList = doc.getElementsByTagName("employee");
	        System.out.println("----------------------------");
	        
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Element nNode = (Element) nList.item(temp);
	            System.out.println("id:"
	            
	                    + nNode.getAttribute("id"));
	            System.out.println(" Name : "
	                    + nNode.getElementsByTagName("name")
	                    .item(0)
	                    .getTextContent());
	            
	            System.out.println("Postion : "
	                    + nNode.getElementsByTagName("position")
	                    .item(0)
	                    .getTextContent());
	            System.out.println("Salary : "
	                    + nNode.getElementsByTagName("salary")
	                    .item(0)
	                    .getTextContent());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
}





