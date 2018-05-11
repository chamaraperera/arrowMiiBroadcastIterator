package ArrowMiiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ArrowMiiUtils.Setup;

public class ArrowMiiLoginPage {
	
	public static WebElement element;
	
	public static WebElement txtEmail(WebDriver driver) {
		element = driver.findElement((By.xpath("//input[@id='email' and @name='email']")));
		return element;
	}
	
	public static WebElement txtPassword(WebDriver driver) {
		element = driver.findElement((By.xpath("//input[@id='password' and @name='password']")));
		return element;
	}
	
	public static WebElement btnSubmitLogin(WebDriver driver) {
		element = driver.findElement((By.xpath("//button[@id='login-submit' and @type='submit']")));
		return element;
	}
	
	
	
	
	
	
	
	
	

}
