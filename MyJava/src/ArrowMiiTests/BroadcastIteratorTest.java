package ArrowMiiTests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ArrowMiiConstants.Constants;
import ArrowMiiData.TestData;
import ArrowMiiPages.ArrowMiiLoginPage;
import ArrowMiiPages.ArrowMiiAdminHome;
import ArrowMiiPages.ArrowMiiBroadcastingIterator;
import ArrowMiiUtils.Setup;
import Functions.BroadcastIteratorFunctions;

public class BroadcastIteratorTest {
	
	public WebDriverWait wait = new WebDriverWait(Setup.chromedriver, 5);

	@BeforeTest(alwaysRun = true)
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
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-14 10:00:00", "2018-03-15 10:00:00", "Regular");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblTotalHours(Setup.chromedriver).getText(), "Total Hours: 24", "Passed");
		
	}
	
	
	
	/*
	@Test(priority=2)
	public void groupsToTriggerTestOne() {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		//BroadcastIteratorFunctions.enterJobSchedule(TestData.valueCreatedAt, TestData.valueStartsAt, "Regular");
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-12 08:00:00", "2018-03-15 12:00:00", "Regular");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblType(Setup.chromedriver).getText(), "Type: exception", "Passed");
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiBroadcastingIterator.tblBroadcastColumns(Setup.chromedriver)));
		BroadcastIteratorFunctions.compareGroupsToTrigger(TestData.arrGroupsToTriggerExpected, TestData.arrDiffFromCreatedAtExpected, ArrowMiiBroadcastingIterator.xpath1, ArrowMiiBroadcastingIterator.xpath2, ArrowMiiBroadcastingIterator.xpath3);
	
	}
	*/
	
	
	
	@Test(priority=3)
	public void groupsToTriggerTestTwo() throws InvalidFormatException, IOException {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-12 08:00:00", "2018-03-15 13:00:00", "Regular");
		//BroadcastIteratorFunctions.enterJobSchedule(TestData.valueCreatedAt, TestData.valueStartsAt, "Regular");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblType(Setup.chromedriver).getText(), "Type: standard", "Passed");
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiBroadcastingIterator.tblBroadcastColumns(Setup.chromedriver)));
		BroadcastIteratorFunctions.readExcelAndCompare(0, ArrowMiiBroadcastingIterator.xpath1, ArrowMiiBroadcastingIterator.xpath2, ArrowMiiBroadcastingIterator.xpath3);
	}
	
	
	
	@Test(priority=4)
	public void groupsToTriggerTestThree() throws InvalidFormatException, IOException {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-12 08:00:00", "2018-03-15 12:00:00", "VIP");
		//BroadcastIteratorFunctions.enterJobSchedule(TestData.valueCreatedAt, TestData.valueStartsAt, "VIP");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblType(Setup.chromedriver).getText(), "Type: exception", "Passed");
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiBroadcastingIterator.tblBroadcastColumns(Setup.chromedriver)));
		BroadcastIteratorFunctions.readExcelAndCompare(1, ArrowMiiBroadcastingIterator.xpath1, ArrowMiiBroadcastingIterator.xpath2, ArrowMiiBroadcastingIterator.xpath3);
	}
	
	
	@Test(priority=5)
	public void groupsToTriggerTestFour() throws InvalidFormatException, IOException {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-12 08:00:00", "2018-03-15 14:00:00", "VIP");
		//BroadcastIteratorFunctions.enterJobSchedule(TestData.valueCreatedAt, TestData.valueStartsAt, "VIP");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblType(Setup.chromedriver).getText(), "Type: standard", "Passed");
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiBroadcastingIterator.tblBroadcastColumns(Setup.chromedriver)));
		BroadcastIteratorFunctions.readExcelAndCompare(2, ArrowMiiBroadcastingIterator.xpath1, ArrowMiiBroadcastingIterator.xpath2, ArrowMiiBroadcastingIterator.xpath3);
	}
	
	
	
	@Test(priority=6)
	//@Parameters({ "adminEmail", "adminPassword" })
	public void groupsToTriggerTestTest() throws InvalidFormatException, IOException {
		
		ArrowMiiLoginPage.txtEmail(Setup.chromedriver).sendKeys(Constants.adminEmail);
		ArrowMiiLoginPage.txtPassword(Setup.chromedriver).sendKeys(Constants.adminPassword);
		ArrowMiiLoginPage.btnSubmitLogin(Setup.chromedriver).click();
		ArrowMiiAdminHome.menuListTools(Setup.chromedriver).click();
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver)));
		ArrowMiiAdminHome.menuToolsBroadcastIterator(Setup.chromedriver).click();
		
		BroadcastIteratorFunctions.enterJobSchedule("2018-03-12 08:00:00", "2018-03-15 14:00:00", "VIP");
		//BroadcastIteratorFunctions.enterJobSchedule(TestData.valueCreatedAt, TestData.valueStartsAt, "VIP");
		ArrowMiiBroadcastingIterator.btnSearch(Setup.chromedriver).click();
		Assert.assertEquals(ArrowMiiBroadcastingIterator.lblType(Setup.chromedriver).getText(), "Type: standard", "Passed");
		wait.until(ExpectedConditions.visibilityOf(ArrowMiiBroadcastingIterator.tblBroadcastColumns(Setup.chromedriver)));		
		BroadcastIteratorFunctions.readExcelAndCompare(3, ArrowMiiBroadcastingIterator.xpath1, ArrowMiiBroadcastingIterator.xpath2, ArrowMiiBroadcastingIterator.xpath3);
	}
	
	
	
		
	
	
	@AfterTest(alwaysRun = true)
	public void exit() {
		Setup.quitArrowMii();
	}
	

}
