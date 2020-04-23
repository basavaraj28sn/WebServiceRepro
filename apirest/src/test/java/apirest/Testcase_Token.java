package apirest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testcase_Token {
	
	@Test //Testing the basic token
	public void tc_01()
	{
		baseURI = "https://api.github.com";
		basePath = "/user";
		
		given().auth().oauth2(" b2faa6b228ea69eff8d935761c348401cf285949")
		.contentType(ContentType.JSON)
		.body(new File("C:\\Javasetup\\apirest\\Testdata\\gitrepo1.json"))
		.when().post()
		.then().statusCode(200);
	}
	
	@Test //Testing the basic token
	public void tc_02()
	{
		baseURI = "https://api.github.com";
		basePath = "/repos";
		
		given().auth().oauth2(" b2faa6b228ea69eff8d935761c348401cf285949")
		.contentType(ContentType.JSON)
		.when().delete("/basavaraj28sn/WebServiceRepro1")
		.then().statusCode(204);
	}
}
