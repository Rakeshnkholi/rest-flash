package Utilites;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Resource 
{
     public static String sessionkey()
	
	{	RestAssured.baseURI="http://localhost:8081";
		Response resp = RestAssured.given()
		.header("content-type","application/json")
		.body("{ \"username\": \"rakeshkumar\", \"password\": \"Mar@2020\"}")
		.when()
		.post("/rest/auth/1/session").then().statusCode(200).extract().response();
		
		String responseString = resp.asString();
		JsonPath js=new JsonPath(responseString);
		String sessionID=js.get("session.value");
		
		return sessionID;
	
	}

}
