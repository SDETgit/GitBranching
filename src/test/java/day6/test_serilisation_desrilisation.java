package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test_serilisation_desrilisation {
	
	@Test
	void testSerilisation() throws JsonProcessingException {
		pojo_class_dec pcd = new pojo_class_dec();
		pcd.setName("bin");
		pcd.setLocation("Noida"); 
		pcd.setPhone(989372981);
		String courses[] = {"N", "P"};
		pcd.setCoursearr(courses);

		//Converting the Java object to ison object Serialization 
		ObjectMapper objM = new ObjectMapper();
		String jsondata =  objM.writerWithDefaultPrettyPrinter().writeValueAsString(pcd); 
		System.out.println(jsondata);

	}
	
	
	@Test
	void testDeserilisation() throws JsonProcessingException {
		String json = "{\r\n"
				+ "  \"phone\" : 989372981,\r\n"
				+ "  \"name\" : \"bin\",\r\n"
				+ "  \"location\" : \"Noida\",\r\n"
				+ "  \"coursearr\" : [ \"N\", \"P\" ]\r\n"
				+ "}";
		
		//Converting json object to java object de serialization 
		ObjectMapper objM1 = new ObjectMapper();
		pojo_class_dec javaobject = objM1.readValue(json,pojo_class_dec.class);
		System.out.println("Name is : "+javaobject.getName());
		System.out.println("Location  is : "+javaobject.getLocation());
		System.out.println("Phone is : "+javaobject.getPhone());
		System.out.println("Course is : "+javaobject.getCoursearr()[0]);
		System.out.println("Course is : "+javaobject.getCoursearr()[1]);

	}

}
