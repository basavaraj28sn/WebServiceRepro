package apirest;

import io.restassured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_Basics {
	
	Response response = RestAssured.get("http://localhost:8080/student/list");
	
	@Test //print response body
	public void tc_01()
	{	  
	   System.out.println("response body >> "+response.asString());
	   System.out.println("response body >> "+response.getBody().asString());
	   System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
	@Test //Testing the status code
	public void tc_02()
	{
	   int actualResponseCode = response.getStatusCode();
	   System.out.println("status code >> "+actualResponseCode);
	   Assert.assertEquals(actualResponseCode, 200);
	   System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
	@Test //Testing the Response time //Testing the actual Header 
	public void tc_03()
	{
	   	long actualResponseTime = response.getTime();
		System.out.println("Response time >> "+actualResponseTime);
		String actualHeader = response.getHeader("Content-Type");
		System.out.println("actual Header >> "+actualHeader);
		Assert.assertEquals(actualHeader, "application/json;charset=UTF-8");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
	@Test //Verify the data
	public void tc_04()
	{
	  String Data = response.getBody().asString();
	  String actualData = response.jsonPath().get("[5].firstName");
	  System.out.println("Verify the data >> " +actualData);
	  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
}
