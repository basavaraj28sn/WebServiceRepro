package apirest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

public class Testcase_Get {

	@Test //Testing the statusCode
	public void tc_01()
	{
		 given().get("http://localhost:8080/student/list")
		.then().statusCode(200);
	}
	@Test //Testing the Response time
	public void tc_02()
	{
		 given().baseUri("http://localhost:8080/").and().basePath("/student")
		.when().get("/list")
		.then().statusCode(200).and().time(lessThan(2000L));
	}
	@Test //Testing the statusCode / baseURI / basePath
	public void tc_03()
	{	
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		given()
		.when().get("/list")
		.then().statusCode(200);
	}
	@Test //Testing the statusCode / baseURI / basePath / Query parameter
	public void tc_04()
	{
		baseURI = "https://reqres.in/";
		basePath = "/api";
		given()
		.when().get("users?page=2")
		.then().statusCode(200);
	}
	@Test //Testing the statusCode / baseURI / basePath / Verify the data and print courses
	public void tc_05()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		 given()
		.when().get("/list")
		.then().statusCode(200).and().time(lessThan(2000L))
		.and().header("Content-Type", "application/json;charset=UTF-8")
		.and().body("[0].firstName", equalTo("Vernon"));
		 
		 JsonPath jp = given().when().get("/list").jsonPath();
		 System.out.println("Name :" + jp.get("[6].courses"));
		 
		 List<String> cr = jp.get("[6].courses");
		 System.out.println("Corses :" + cr.get(0)+" - " + cr.get(1)+" - " + cr.get(2));
	}
	
	@Test //Testing the statusCode / baseURI / basePath / path parameter / Verify the data
	public void tc_06()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		 given()
		.when().get("/5")
		.then().statusCode(200)
		.and().body("firstName", equalTo("Cullen")); 
	}
	@Test //Testing the statusCode / baseURI / basePath / Query parameter / HashMap
	public void tc_07()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("programme","Computer Science");
		
		JsonPath jp = given().params(hm)
		.when().get("/list").jsonPath();
		System.out.println("Name >>>>" + jp.get());
	}
}
