package ArrowMiiUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ArrowMiiConstants.Constants;

public class Setup {
	
	public static WebDriver chromedriver = new ChromeDriver();
	//static ChromeDriver chromedriver  = new ChromeDriver();
	
	private static String driverPath = "/Users/chamaraperera/Documents/chromedriver/";
	
	public static void navigateArrowMiiUrl() {
		// need to give path as chromedriver not as chromedriver.exe, as mac does not recognize .exe extension
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
		chromedriver.navigate().to(Constants.arrowMiiURL);
	}
	
	public static void quitArrowMii() {
		chromedriver.close();
		//chromedriver.quit();
	}

}
