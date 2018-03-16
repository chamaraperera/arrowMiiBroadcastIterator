package ArrowMiiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrowMiiAdminHome {
	
	public static WebElement element;
	
	public static WebElement imgArrowMiiTitle(WebDriver driver) {
		element = driver.findElement((By.xpath("//*[@href='http://staging-admin.arrowmepro.com']")));
		return element;
	}
	
	public static WebElement menuListTools(WebDriver driver) {
		element = driver.findElement((By.xpath("//li[8]/ul[@class='collapsible collapsible-accordion']")));
		return element;
	}
	
	public static WebElement menuToolsBroadcastIterator(WebDriver driver) {
		//element = driver.findElement((By.xpath("//a[contains(text(),'Broadcasting Iterator') and @href='http://staging-admin.arrowmepro.com/en/tools/broadcasting-iterator']")));
		//element = driver.findElement((By.xpath("//div/ul/li[4]/a[contains(text(),'Broadcasting Iterator')]")));
		//element = driver.findElement((By.xpath("//div/ul/li[4][@class='sidebar-admin-tools-broadcasting-iterator']")));
		element = driver.findElement((By.xpath("//a[contains(text(),'Broadcasting Iterator')]")));
		//element = driver.findElement((By.xpath("//*[@id='inactive']/div/ul/li[4]/a")));
		//element = driver.findElement((By.xpath("//li[8]/ul[@class='collapsible collapsible-accordion']/..//ul/li[4]")));
		//element = driver.findElement((By.xpath("//li[8]/ul[@class='collapsible collapsible-accordion']/..//ul/li[4]/a[@href='http://staging-admin.arrowmepro.com/en/tools/broadcasting-iterator']")));
		
		//List<WebElement> ulist = (List<WebElement>) driver.findElement(By.xpath(".//div/ul/li[4][@class='sidebar-admin-tools-broadcasting-iterator']"));
		//ulist.get(4).click();
		//findElement(By.xpath("//a[contains(text(),'Skill Tests')]")).click();
		return element;
	}
	
	
	
	
	
	
	

}
