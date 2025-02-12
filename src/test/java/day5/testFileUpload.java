package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class testFileUpload {
	 @Test 
	 void testSingleFileUpload() {
		File myfile = new File("D:\\Pavan Sir\\output_file.txt");
		 given()
 	  		.multiPart("file",myfile)
 	  		.contentType("multipart/form-data")
 	  .when()
 	  	.post("https://httpbin.org/post")
 	  .then()
 	  	.statusCode(200)
 	  	.header("Content-Type", "application/json").log().all();
		 
	 }
	 
	 
	 @Test
	 void testMultipleFileUpload() {
		File myfile = new File("D:\\Pavan Sir\\output_file.txt");
		File myfile2 = new File("D:\\Pavan Sir\\output_file2.txt");
		 given()
 	  		.multiPart("files",myfile)  //It passed with File also instead of Files
 	  		.multiPart("files",myfile2)
 	  		.contentType("multipart/form-data")
 	  .when()
 	  	.post("https://httpbin.org/post")
 	  .then()
 	  	.statusCode(200)
 	  	.header("Content-Type", "application/json").log().all();
		 
	 }
	 
	 @Test
	 void testMultipleFileUploadarr() {
		File myfile = new File("D:\\Pavan Sir\\output_file.txt");
		File myfile2 = new File("D:\\Pavan Sir\\output_file2.txt");
		File filearr[] = {myfile,myfile2}; 
		given()
 	  		.multiPart("files",filearr)  
 	  		.contentType("multipart/form-data")
 	  .when()
 	  	.post("https://httpbin.org/post")
 	  .then()
 	  	.statusCode(200)
 	  	.header("Content-Type", "application/json").log().all();
		 
	 }
}
