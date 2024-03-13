import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApiTest {

	String key = "sk_test_51OUZM5SA5PinmNiBx7ChqPh1zxWtZSMv96w00vvarKDBu1AQvhuC0Ujc2pgEySs1cgLOstAh7Bs785dJM1R4FO2k00OueVkYPj";
	String url = "https://api.stripe.com/v1/customers";
	private static String putRequestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";
	private static String patchRequestBody = "{\n" +
            "  \"title\": \"bax\" \n}";
	
	@Test()
	public void test1() throws JsonMappingException, JsonProcessingException {		
		String expectedName = "list";
		
		Response res =  given().auth()
			.basic(key, "")
			.get(url);
		
		   	ObjectMapper mapper = new ObjectMapper();
			
			JsonNode node =  mapper.readTree(res.asPrettyString());
			String actualName = node.get("object").asText();
			//System.out.println(actualName);
			assertTrue(actualName.equals(expectedName));
	}
@Test(priority=1)
	public void postData() throws JsonMappingException, JsonProcessingException {
		String expectedName="jyothi";
		String expectedMail="jyothi@gmail.com";
	    String expectedDescription="Hello how are you?";
	Response res =  given().auth()
				.basic("sk_test_51OUZM5SA5PinmNiBx7ChqPh1zxWtZSMv96w00vvarKDBu1AQvhuC0Ujc2pgEySs1cgLOstAh7Bs785dJM1R4FO2k00OueVkYPj", "")
				.formParam("name", "jyothi")
				.formParam("email", "jyothi@gmail.com")
				.formParam("description", "Hello how are you?")
				.post("https://api.stripe.com/v1/customers");
		
		System.out.println(res.asPrettyString());
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node =  mapper.readTree(res.asPrettyString());
		String actualName = node.get("name").asText();
		System.out.println(actualName);
		String actualMail = node.get("email").asText();
		String actualDescription=node.get("description").asText();
		assertTrue(actualName.equals(expectedName));
		assertTrue(actualMail.equals(expectedMail));
		assertTrue(actualDescription.equals(expectedDescription));
}
	
@Test(priority=2)
public void putRequest() {
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	int expectedStatus=200;
	 Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(putRequestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

   System.out.println(response.statusCode());		
int actualStatusCode=response.statusCode();

assertEquals(actualStatusCode, expectedStatus);
}
@Test(priority=3)
public void patchRequest() {
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	int expectedStatus=200;
    Response response = given()
            .header("Content-type", "application/json")
            .and()
            .body(patchRequestBody)
            .when()
            .patch("/posts/1")
            .then()
            .extract().response();

   System.out.println(response.statusCode());
   int actualStatusCode=response.statusCode();

   assertEquals(actualStatusCode, expectedStatus);

}
@Test(priority=4)
public void deleteRequest() {
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	int expectedStatus=200;
	Response response = given()
            .header("Content-type", "application/json")
            .when()
            .delete("/posts/1")
            .then()
            .extract().response();

    System.out.println(response.statusCode());
    int actualStatusCode=response.statusCode();

    assertEquals(actualStatusCode, expectedStatus);




}
@Test(priority=5)
public void PostDataUsingPojo() throws JsonMappingException, JsonProcessingException { 
	User u = new User("eve.hot@reqres.in","pistol");
	//System.out.println(u);
	String expEmail="eve.hot@reqres.in";
	String expPassword="pistol";
	Response response = given()
	        .auth()
	        .basic("sk_test_51OqfxQI73Ik4b15uBaQaAH0n8U2E5JBKooOoWgBZ2umpfOaMkhFjJcDFJi6GFHwPCCWXC0XFjFWApmHX8EiObXON00nJMywFEe", "")
	        .contentType("application/json") // Update content type to JSON
	        .body(u)
	        .post("https://reqres.in/api/users");

	System.out.println(response.asPrettyString());
	ObjectMapper mapper=new ObjectMapper();
	JsonNode jsonNode = mapper.readTree(response.asPrettyString());
	String actualEmail=jsonNode.get("email").asText();
	System.out.println(actualEmail);

	String actualPassword=jsonNode.get("password").asText();
	System.out.println(actualPassword);
	assertTrue(actualEmail.equals(expEmail));
	assertTrue(actualPassword.equals(expPassword));
}
}