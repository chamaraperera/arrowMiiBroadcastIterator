package ArrowMiiTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ArrowMiiConstants.Constants;
import ArrowMiiPages.ArrowMiiLoginPage;
import ArrowMiiPages.ArrowMiiAdminHome;
import ArrowMiiPages.ArrowMiiBroadcastingIterator;
import ArrowMiiUtils.Setup;

public class BroadcastIteratorTest {
	
	public WebDriverWait wait = new WebDriverWait(Setup.chromedriver, 5);
	
	@BeforeTest
	public void launch() {
		Setup.navigateArrowMiiUrl();
	}
	
	@Test
	public void broadcastIterator() {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		
		//System.out.println("Text:" + ArrowMiiAdminHome.menuListTools(Setup.chromedriver).getText());
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		ArrowMiiBroadcastingIterator.txtJobCreatedAt(Setup.chromedriver).clear();
		ArrowMiiBroadcastingIterator.txtJobCreatedAt(Setup.chromedriver).sendKeys("2018-03-14 10:00:00");
		ArrowMiiBroadcastingIterator.txtJobStartsAt(Setup.chromedriver).clear();
		ArrowMiiBroadcastingIterator.txtJobStartsAt(Setup.chromedriver).sendKeys("2018-03-15 10:00:00");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblTotalHours(Setup.chromedriver).getText(), "Total Hours: 24", "Passed");
		
	}
	
	@AfterTest
	public void exit() {
		Setup.quitArrowMii();
	}
	

}
