package Testcases;

import org.testng.annotations.Test;

import Utilites.Resource;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class createIssue 
{
	@Test
	public void createIssue()
	{
		RestAssured.baseURI="http://localhost:8081";
		
		Response resp = RestAssured.given()
		.header("Content-Type","application/json")
		.header("Cookie","JSESSIONID="+Resource.sessionkey())
		.body("{ \r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": \r\n"
				+ "        {\r\n"
				+ "            \"key\": \"QA\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"Blocker homepage is not opening\",\r\n"
				+ "        \"description\" :\" creating of an issue using project keys and issue using rest api \",\r\n"
				+ "        \"issuetype\" : {\r\n"
				+ "            \"name\" : \"Bug\"\r\n"
				+ "        }\r\n"
				+ "}\r\n"
				+ "}").when().post("/rest/api/2/issue").then().assertThat().statusCode(201).extract().response();
		
		
		
		
		
	}

}
