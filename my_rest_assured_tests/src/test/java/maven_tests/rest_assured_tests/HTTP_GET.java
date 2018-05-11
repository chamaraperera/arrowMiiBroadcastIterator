package maven_tests.rest_assured_tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.hamcrest.generator.*;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HTTP_GET {

	@Test
    public void myFirstRestAssuredTest()
    {
        given().
            queryParam("name", "James").
        when().
            get("http://yourwebsiteaddress/api").
        then().
            body("title", equalTo("The Page Title"));
    }
	
}
