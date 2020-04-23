package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testcase_Patch {
	
	@Test //Testing the patch or update Request / statusCode / by using json object
	public void tc_01()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		JSONObject reqbody = new JSONObject();
		reqbody.put("email", "Vijay3333@gmail.com");
		
		 given().contentType(ContentType.JSON).body(reqbody)
		.when().patch("/1")
		.then().statusCode(200).and().body("msg", equalTo("Updated"));		
	}
	
	@Test //Testing the patch or update Request / statusCode / by using json file
	public void tc_02()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		JSONObject reqbody = new JSONObject();
		reqbody.put("email", "Vijay2222@gmail.com");
		
		 Response response = given().contentType(ContentType.JSON).body(reqbody)
		 .when().patch("/1");
		 
		 String respData = response.getBody().jsonPath().getString("msg");
		 int respstatuscode = response.getStatusCode();
		 System.out.println("response msg is >> " +respData);
		 Assert.assertEquals("Updated", respData);
		 Assert.assertEquals(200, respstatuscode);				
	}
}
