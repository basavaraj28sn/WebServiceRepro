package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class Testcase_Delete {
	
	@Test //Testing the delete / by using path param
	public void tc_01()
	{
		baseURI = "http://localhost:8080/";
		basePath = "/student";
		
		given()
		.when().delete("/9")
		.then().statusCode(204);		
	}
}
