package day3;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
     
	@Test
	void testCookies() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","AQTF6HyLjgKHYicmKicHQ8M2iUH1vlyUy09HlSYEBhyksxUKu5om1l0nkjw")
			.log().all();
	}
	
	@Test
	void testECookies() {
		Response res = given().when().get("https://www.bing.com/");
		
		//Get single cookie getCookie() method is used
		String get_cookie= res.getCookie("MUID");
		System.out.println("Value of cookie is "+get_cookie);
		
		//Get all cookies key set value getCookies() method is used
		Map<String,String> cookie_set = res.getCookies();
		System.out.println(cookie_set.keySet()); //to print only keyset not values in the form of map
	
		//To print all key set value 
		for(String k : cookie_set.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+" : "+cookie_value);
		}
	}
	
	
	@Test
	void testCookies3() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.log().cookies();
	}
}
