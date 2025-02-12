package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class QueryAnsPathParameters {
	//http://localhost:3000/students
	@Test
	void testPathAndQueryParameters(){
	//https://reqres.in/api/users?page=2&id=8	
		given()
				.pathParam("mypath1","api")
				.pathParams("mypath","users")
				.queryParam("page",2)
				.queryParam("id",8)
			.when()
				.get("https://reqres.in/{mypath1}/{mypath}")
			.then()
				.statusCode(200)
				.log().all();
		Response res = given()
		.when()
			.get("http://localhost:3000/students");
		
	}
	
	
	
	
	

}
