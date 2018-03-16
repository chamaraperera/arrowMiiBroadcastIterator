package MyTest;

//import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class TestClass {
	public WebDriver driver;
	
	@BeforeTest
	public static void main(String[] args) {
		System.out.println("Java Test");
	}

}
