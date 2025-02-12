package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener; 
import org.testng.annotations.Test;

import java.io.FileReader;

/*
Different ways to create Post Request body 
1) Using HashMap 
2) Using Org.Json
3) Using POJO class
4) Using external json files
 */

public class waysToPostRequest {
 String id;
	
	@Test (priority =1)
	void testPostUsingHashMap() {
		HashMap data = new HashMap(); 
		data.put("name", "Bumbum");
		data.put("active", true);
		data.put("yearsOLD", 18);
		
		int gradesarr[] = {3,5,5};
		data.put("grades", gradesarr);
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Bumbum"))
			.body("yearsOLD", equalTo(18))
			.body("active", equalTo(true))
			.body("grades[0]", equalTo(3))
			.body("grades[1]", equalTo(5))
			.body("grades[2]", equalTo(5))
			.header("Content-Type", "application/json")
			.log()
			.all();
		
		
		
	}
	
	@Test (priority =2)
	void testDelete() {
		given().
		when().delete("http://localhost:3000/students/d54a")
		.then().statusCode(200);
	}
	@Test (priority =3)
	void testPostUsingJsonLibrary() {
		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("active", true);
		data.put("yearsOLD", 18);
		
		int gradesarr[] = {1,2,3};
		data.put("grades", gradesarr);
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Scott"))
			.body("yearsOLD", equalTo(18))
			.body("active", equalTo(true))
			.body("grades[0]", equalTo(1))
			.body("grades[1]", equalTo(2))
			.body("grades[2]", equalTo(3))
			.header("Content-Type", "application/json")
			.log()
			.all();
		
		
		
	}
	@Test (priority =4)
	void testPostUsingPOJO() {
		Pojo_PostRequest_Java data = new Pojo_PostRequest_Java();
		data.setName("Baki");
		data.setActive(true);
		data.setYearsOLD("18");
		int coursesArr[] = {1,2};
		data.setGrades(coursesArr);
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Baki"))
			.body("yearsOLD", equalTo("18"))
			.body("active", equalTo(true))
			.body("grades[0]", equalTo(1))
			.body("grades[1]", equalTo(2))
			.header("Content-Type", "application/json")
			.log()
			.all();
		
		
		
	}
	
	@Test (priority =5)
	void testPostUsigExternalJsonFile() throws FileNotFoundException {
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("kaku"))
			.body("yearsOLD", equalTo("18"))
			.body("active", equalTo(true))
			.body("grades[0]", equalTo(1))
			.body("grades[1]", equalTo(2))
			.header("Content-Type", "application/json")
			.log()
			.all();
		
		
		
	}
}