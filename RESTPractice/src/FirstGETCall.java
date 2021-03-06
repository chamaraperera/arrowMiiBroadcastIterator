
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class FirstGETCall {
	
	@Test
	public void GetWeather() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Singapore");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		ResponseBody body = response.getBody();
		
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		String contentType = response.header("Content-Type");
		String serverType = response.header("Server");
		String acceptLanguage = response.header("Content-Encoding");
		
		System.out.println(statusCode);
		System.out.println("Content-Type: " + contentType);
		System.out.println("Server: " + serverType);
		System.out.println("Content-Encoding: " + acceptLanguage);
		System.out.println("Response Body: " + body.asString());
		Assert.assertEquals(statusCode, 200, "Correct status code returned.");
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK",  "Correct status line returned.");
		Assert.assertEquals(contentType, "application/json", "Correct content type returned.");
		Assert.assertEquals(serverType, "nginx/1.12.2", "Correct server type returned.");
		Assert.assertEquals(acceptLanguage, "gzip", "Correct language type returned.");
		
		
	}
	
	@Test
	public void GetWeatherInvalidCity() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/P3X93643");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		int statusCode = response.getStatusCode();
		Headers allHeaders = response.headers();
		
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + "Value: " + header.getValue());
		}
		Assert.assertEquals(statusCode, 400, "Correct status code returned.");
	}

}
