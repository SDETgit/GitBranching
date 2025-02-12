package day7;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

//Basic
//digest 
//preemptive
//bearer token 
//Api key
//oAuth 1.0 --outdated 
//oAuth 2.0 
public class testAuthorisation {
	@Test 
	void basicAuthorisation() {

		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();

		

		}
	
	@Test
	void digestAuthorisation() {

		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode (200)
			.body("authenticated", equalTo (true))
			.log().all();
	}
	
	@Test
	void preemptiveAuthorisation() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode (200)
			.body("authenticated", equalTo (true))
			.log().all();
	}
	@Test 
	
	void bearerTokenAuthentication() { 

		String bearer_token = "CjXK1Ye3LFVIdKeV7WNgUW1VOurdGSM01"; 
	
	given()
		.headers("Authorization", "Bearer "+bearer_token) 
	.when()
		.get("https://httpbin.org/bearer")
	.then()
		.statusCode(200)
		.body("authenticated", equalTo(true)) 
		.body("token", equalTo(bearer_token))
		.log().all();
	}
	
	@Test 
	void testoauth1auth()
	{
		String Consumer_secret = "D+EdQ-gs$-%@2Nu7";
		String consumer_key ="D+EdQ-gs$-%@2Nu7";
		String Access_token ="value1111111111";
		String TokenSecret = "vaue2"; 

		given()
			.auth().oauth(consumer_key, Consumer_secret, Access_token, TokenSecret)
		.when()
			.get("https://postman-echo.com/oauth1")
		.then()	
			.statusCode(200)
			.body("status" , equalTo("pass"))
			.body("message", equalTo("OAuth-1.0a signature verification was successful"))
			.log().all();
	}
	
	@Test 
	void testoAuth2auth()
	{
		
		given()
			.auth().oauth2("A21AALhAljmsKG7iMPVer8-XvXqx7hB0-TjyJJbZryANJrjxXdCZJl_uNOvV6JeQz1cgH5NE_vjNSj0aS04BPdpUHUCOR5lYA")
		.when()
			.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true")
		.then()	
			.statusCode(200)
			//.body("status" , equalTo("pass"))
			.log().all();
	}
	
	@Test 
	void testAPI_Key()
	{
		
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
			.pathParam("mypath", "data/2.5/forecast/daily")
			.queryParam("q", "Ghaziabad")
			.queryParam("units", "metric")
			.queryParam("cnt", "7")
		.when()
			.get("https://api.openweathermap.org/{mypath}")
		.then()
			.statusCode(200)
		//.body("total_count", equalTo(8))
		//.body("message", equalTo("OAuth-1.0a signature verification was successful")) 
			.log().all();
		}
}
