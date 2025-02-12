package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class xmlSchemaValidation {
	
@Test 
void xmlschemaValidation() {
	given()
	.accept("application/xml")
.when()
	.get("https://petstore.swagger.io/v2/pet/9223372036854580561")
.then()
	.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschemavalidation.xsd"));
}

}
 