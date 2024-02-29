import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		 
        try {
            // Read JSON file into JsonNode object
            JsonNode jsonNode = objectMapper.readTree(new File("./src/main/resources/example.json"));
 
            // Print JSON content
            System.out.println("JSON Content:");
            System.out.println(jsonNode.toPrettyString());
 
            // Access specific fields
            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();
            
            JsonNode phoneNumbers = jsonNode.get("phoneNumbers");
            

            String firstPhoneNumber = phoneNumbers.get(0).asText();
            String secondPhoneNumber = phoneNumbers.get(1).asText();
           
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("first phone number: " + firstPhoneNumber);
            System.out.println("second phone number: " +secondPhoneNumber );
            System.out.println("phonenumbers: " +phoneNumbers);
            JsonNode address = jsonNode.get("address");
            System.out.println("address: " +address);
            String streetName=address.get("street").asText();
            System.out.println("streetName: " +streetName);
            String zipcode=address.get("zipcode").asText();
            System.out.println("zipcode: " +zipcode); 
            
            boolean active=jsonNode.get("active").asBoolean();
       System.out.println("active: " +active);
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	
	
	
	
	}

}
