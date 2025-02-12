package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class parsingXMLBody {
      @Test 
      //Approach 1 Plain direct methods 
      void testXMLresponse(){
    	  given()
    	  	.accept("application/xml")
    	  .when()
    	  	.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
    	  .then()
    	  	.statusCode(200)
    	  	.header("Content-Type", "application/xml")
    	  	.body("pets.Pet[0].status[0]", equalTo("available"));
    	  	//.log().all();
      }
      
      
      //Approach 2 using assertions 
      @Test 
      void testXMLResponse2() {
    	Response res =  given().accept("application/xml").when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
      //Response code 
    	Assert.assertEquals(res.getStatusCode(),200);
    	Assert.assertEquals(res.header("Content-Type"), "application/xml");
    	
    	String status = res.xmlPath().get("pets.Pet[0].status[0]").toString();
    	
    	Assert.assertEquals(status, "available");
    	
      }
      
      //Approach 3 using Collections 
      @Test 
      void testXMLResponse3() {
    	Response res =  given().accept("application/xml").when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
      //Response code 
    	XmlPath xmlobj = new XmlPath(res.asString());
    	
    	//verify total number of pets 
    	List<String> pet_info = xmlobj.getList("pets.Pet");
    	
    	//to print information //pet_info :- it contains all information about the pets in each tag of pets 
//    	for(String pe:pet_info)
//    	{
//    		System.out.println(pe);
//    	}
//    	
    	//Assertions on number of pets present in it 
    	//Assert.assertEquals(pet_info.size(), 323);
    	
    	//Validate a id is present or not 
    	List<String> pet_info2 = xmlobj.getList("pets.Pet.id");
    	boolean status = false;
    	for(String id : pet_info2)
    	{
    		//System.out.println(id);
    		if(id.equals("9223372016900016123"))
    			
    		{
    			status = true;
    			break;
    		}
    	}
    	
    	Assert.assertEquals(status, true);
    	
    	
      }
}
 