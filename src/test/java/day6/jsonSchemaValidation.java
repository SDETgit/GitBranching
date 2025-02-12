package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class jsonSchemaValidation {
	
	@Test 
	void jsonSchemaVa() {
		given()
			.accept("application/json")
		.when()
			.get("https://petstore.swagger.io/v2/pet/30785")
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaHttbin.json"))
		;
		
		
	}
	@Test
	void jsonSchemaV() {
		Response  res = given().when().get("https://httpbin.org/get");
		String resbody = res.getBody().asString();
		System.out.println(resbody);
		//String jschema = generateJsonSchema(resbody);
				
	}
}
