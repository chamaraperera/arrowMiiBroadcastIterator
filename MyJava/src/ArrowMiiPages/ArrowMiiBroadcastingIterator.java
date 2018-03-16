package ArrowMiiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrowMiiBroadcastingIterator {

public static WebElement element;
	
	public static WebElement txtJobCreatedAt(WebDriver driver) {
		element = driver.findElement((By.xpath("//input[@id='created_at']")));
		return element;
	}
	
	public static WebElement txtJobStartsAt(WebDriver driver) {
		element = driver.findElement((By.xpath("//input[@id='starts_at']")));
		return element;
	}
	
	public static WebElement btnSearch(WebDriver driver) {
		element = driver.findElement((By.xpath("//button[@class='btn blue white-text']")));
		return element;
	}
	
	public static WebElement lblTotalHours(WebDriver driver) {
		element = driver.findElement((By.xpath("//div[@class='col s6']/..//div[2]/div[2]")));
		return element;
	}
	
	
	
	
	
	
	
	
	
	
	
}
