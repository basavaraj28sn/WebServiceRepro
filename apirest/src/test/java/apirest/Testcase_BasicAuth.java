package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testcase_BasicAuth {
	
	@Test //Testing the basic auth
	public void tc_01()
	{
		baseURI = "https://api.github.com";
		basePath = "/user";
		
		 given().auth().preemptive().basic("basavaraj28sn@gmail.com", "xxxxxxxxxx").contentType(ContentType.JSON).body(new File("C:\\Javasetup\\apirest\\Testdata\\gitrepo.json"))
		.when().post("/repos")
		.then().statusCode(201);	 
	}
	
	@Test //Testing the basic auth
	public void tc_02()
	{
		baseURI = "https://api.github.com";
		basePath = "/user";
		
		Response response = given().auth().preemptive()
		.basic("basavaraj28sn@gmail.com", "xxxxxxxxx").contentType(ContentType.JSON)
		.body(new File("C:\\Javasetup\\apirest\\Testdata\\gitrepo1.json"))
		.when().post("/repos");
		response.then().statusCode(201);
		System.out.println(response.getBody().asString()); 
	}
}
