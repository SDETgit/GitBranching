package day7;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakerLibrary {

	@Test 
	void fakerLibraryt() {
		Faker faker = 	new Faker();

		String name = faker.name().fullName();

		String firstName = faker.name().firstName(); 
		String lastName = faker.name().lastName();

		String streetAddress =faker.address().streetAddress(); // 60018 Sawavn E String novel faker.how MetYourMother().catchphrase(); // 60018 Sawavn

		String chuck = faker.chuckNorris().fact(); 
		String 	galaxy = faker.hitchhikersGuideToTheGalaxy().marvinQuote(); 
		
		String email = faker.internet().emailAddress();

		String safemail = faker.internet().safeEmailAddress();

		String pass = faker.internet().password();

		String phone = faker.phoneNumber().cellPhone();

		String creditcard =faker.business().creditCardNumber();

		System.out.println(name); 
		System.out.println(firstName); 
		System.out.println(lastName); 
		System.out.println(streetAddress);
		System.out.println(chuck);
		System.out.println(galaxy); 
		System.out.println(email);
		System.out.println(pass);
		System.out.println(phone);
		System.out.println(creditcard);
		System.out.println(safemail);
	}
}
