package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Testcase_Post {

	@Test //Testing the Post Request / statusCode /by using json text
	public void tc_01()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		given().contentType(ContentType.JSON).body("{\r\n"+
				" \"firstName\": \"Basavaraj\",\r\n"+
				" \"lastName\": \"Sangavalli\",\r\n"+
				" \"email\": \"basava4@gmail.com\",\r\n"+
				" \"programme\": \"Computer Science\",\r\n"+
				" \"courses\": [\r\n"+
				"				\"JAVA\",\r\n"+
				"			   ]\r\n"+
			"}")
		.when().post("/")
		.then().statusCode(201).and().body("msg", equalTo("Student added"));		
	}
	
	@Test //Testing the Post Request / statusCode / by using json file
	public void tc_02()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		given().contentType(ContentType.JSON).body(new File("C:\\Javasetup\\apirest\\Testdata\\emp1.json"))
		.when().post("/")
		.then().statusCode(201).and().body("msg", equalTo("Student added"));		
	}
	
}
