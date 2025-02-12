package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestChaining4Deleteuser {
	@Test
	void Delete_User(ITestContext Context) {
		System.out.println("Delete user ");

	//	int id = (int) Context.getAttribute("User_id"); //Runs at test level only 
		int id = (int) Context.getSuite().getAttribute("User_id"); //Runs at Suite level 

		String bearer_token = "3891240c7ab9e62c8e7545be6d7c4b4a810d13e7715ce17741d3e3af8e1532e1";

		given()
			.header("Authorization", "Bearer "+bearer_token)
			.pathParam("ID", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{ID}")
		.then()
		.statusCode(204).log().all();
		
	}
}
