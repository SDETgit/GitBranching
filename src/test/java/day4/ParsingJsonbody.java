package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonbody {
	
	@Test
	void testbasic(){
	//http://localhost:3000/store
	 given()
	 	.contentType(ContentType.JSON)
	.when()
		.get("http://localhost:3000/store")
	.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		//Can be done for very basic json 
		.body("book[1].title",equalTo("Sword of Honour"));
	
		}
	
	
	@Test
	void test(){
	//https://reqres.in/api/users?page=2&id=8	
		Response res = given()//.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
		
		//res.prettyPrint();
		
		//JSONObject class
		JSONObject jo=new JSONObject(res.asString()); // converting response to json object type
		
		//Assertion 1 
		boolean status = false;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		//System.out.println(bookTitle);
		if(bookTitle.equals("Sword of Honour"))
				status = true;
		}
		Assert.assertEquals(status, true);
		
		//Assertion 2 
		double total =0 ;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
		String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		//System.out.println(bookTitle);
			total = total+Double.parseDouble(price);
		}
		
		System.out.println(total);
		
		Assert.assertEquals(total, 526.0);		
	}
}
