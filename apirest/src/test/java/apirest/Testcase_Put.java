package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Testcase_Put {
	
	@Test //Testing the Put or update Request / statusCode / by using json file
	public void tc_01()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		given().contentType(ContentType.JSON).body(new File("C:\\Javasetup\\apirest\\Testdata\\emp1.json"))
		.when().put("/108")
		.then().statusCode(200).and().body("msg", equalTo("Student Updated"));		
	}
}
