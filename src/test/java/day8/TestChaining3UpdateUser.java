package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TestChaining3UpdateUser {
	
	@Test
	void Update_User(ITestContext Context) {
		
		System.out.println("Update user ");

		Faker fake = new Faker();
		JSONObject data = new JSONObject();

		//Inserting key and value in JSONObject data.put("name", fake.name().fullName());

		data.put("gender", "Male");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "Active");

		String bearer_token = "3891240c7ab9e62c8e7545be6d7c4b4a810d13e7715ce17741d3e3af8e1532e1";

		//int id = (Integer) Context.getAttribute("User_id"); //Runs at test level only 
		int id = (int) Context.getSuite().getAttribute("User_id"); //Runs at Suite level 

		given()
			.header("Authorization", "Bearer "+bearer_token)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("ID", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{ID}")
		.then()
			.statusCode (200)
			.log().all();
		
	}

}
