
package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 
//Get users 
https://reqres.in/api/users?page=2

//Post Create users 
https://reqres.in/api/users
body 
{
    "name": "morpheus",
    "job": "leader"
}

//Put Update user 
https://reqres.in/api/users/2
{
    "name": "morpheus",
    "job": "zion resident"
}


//Delete 
https://reqres.in/api/users/2
 */

import org.testng.annotations.Test;
public class HttpRequest {
int id;
	@Test (priority =1)
	void getUsers() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then().
			statusCode(200).
			body("page", equalTo(2)).
			log().all();
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test (priority =2)
	void creatUser()
	{
		HashMap data = new HashMap(); 
		data.put("name", "Shubham");
		data.put("job", "Test specialist");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log()
			.all();
		//To capture the ID
		id = given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("https://reqres.in/api/users").jsonPath().getInt("id");
		
		
			
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test (priority =3 , dependsOnMethods = {"creatUser"})
	void updateUser()
	{
		HashMap data = new HashMap(); 
		data.put("name", "Pangu");
		data.put("job", "Quak Quak");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log()
			.all();
			}
	@Test(priority =4)
	void deleteUser(){
		given().
		when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204);
	}
	}


