package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headers_demo {
	@Test
	void test_headers_basic() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Server","gws")
			.and() //optional to add
			.header("Content-Encoding","gzip");
	}
	
	@Test
	void test_headers_basic2() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.log().headers();
	}
	
	@Test
	void test_headers_basic3() {
		Response res = given().when().get("https://www.bing.com/");
		
		//To print single value 
		String header_va = res.getHeader("Content-Type");
		System.out.println("Valur of content-type is "+header_va);
		
		//To print all values 
		Headers myHeaders = res.getHeaders();
		for(Header hd:myHeaders) {
			System.out.println(hd.getName()+" : "+hd.getValue());
		}
		
	}
}
