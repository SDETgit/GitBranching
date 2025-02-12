package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class TestChaining1CreateUser {
	
	@Test
	void Creat_User(ITestContext Context) {
		System.out.println("Create user ");
		Faker fake = new Faker();

		JSONObject data = new JSONObject();

		//Inserting key and value in JSONObject
		data.put("name", fake.name().fullName());
		data.put("gender", "Male");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "Active");

		String bearer_token = "3891240c7ab9e62c8e7545be6d7c4b4a810d13e7715ce17741d3e3af8e1532e1";

		int ID = given()
					.header("Authorization", "Bearer "+bearer_token)
					.contentType("application/json")
					.body(data.toString())
				.when()
					.post("https://gorest.co.in/public/v2/users")
					.jsonPath().getInt("id");

			//Context.setAttribute("User_id", ID);  //Runs at test level only 
			Context.getSuite().setAttribute("User_id", ID);  //Runs at Suite level 
	}

}
