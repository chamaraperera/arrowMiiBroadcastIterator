package ArrowMiiPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrowMiiBroadcastingIterator {

	public static WebElement element;
	public WebDriver driver;
	
	public static String xpath1 = "//table[@class='bordered alternate-color responsive-table']/tbody/tr[";
	public static String xpath2 = "]/td[1]";
	public static String xpath3 = "]/td[3]";

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
	
	public static WebElement lblType(WebDriver driver) {
		element = driver.findElement((By.xpath("//div[@class='col s6']/..//div[2]/div[1]")));
		return element;
	}
	
	public static WebElement radiobtnRegular(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='col s6']/..//div[1]/div[1]/label"));
		return element;
	}
	
	public static WebElement radiobtnVIP(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='col s6']/..//div[1]/div[2]/label"));
		return element;
	}
	
	public static WebElement tblBroadcastRows(WebDriver driver) {
		element = driver.findElement(By.xpath("//table[@class='bordered alternate-color responsive-table']/tbody/tr"));
		return element;
	}
	
	public static int tblBroadcastRowCount(WebDriver driver) {
		List<WebElement> rowsList = driver.findElements(By.xpath("//table[@class='bordered alternate-color responsive-table']/tbody/tr"));
		int rowCount = rowsList.size();
		return rowCount;
	}
	
	public static WebElement tblBroadcastColumns(WebDriver driver) {
		element = driver.findElement(By.xpath("//table[@class='bordered alternate-color responsive-table']/tbody/tr[2]"));
		return element;
	}
	
	public static int tblBroadcastColumnCount(WebDriver driver) {
		// using /tbody/tr[1]/td wont work as this is the header, the column count can only be taken from the data rows.
		List<WebElement> columnList = driver.findElements(By.xpath("//table[@class='bordered alternate-color responsive-table']/tbody/tr[2]/td"));
		int columnCount = columnList.size();
		return columnCount;
	}
	
	public static WebElement tblBroadcastColumnIterate(WebDriver driver) {
		element = driver.findElement(By.xpath("//table[@class='bordered alternate-color responsive-table']/tbody/tr[1]"));
		return element;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
