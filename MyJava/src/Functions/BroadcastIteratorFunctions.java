package Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ArrowMiiData.TestData;
import ArrowMiiPages.ArrowMiiBroadcastingIterator;
import ArrowMiiUtils.Setup;

public class BroadcastIteratorFunctions {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelPath(String excelPath, String excelFilename) {
		try {
		FileInputStream ExcelFile;
		ExcelFile = new FileInputStream(excelPath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(excelFilename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readCellData(int rowNumber, int columnNumber) {
		
		Cell=ExcelWSheet.getRow(rowNumber).getCell(columnNumber);
		String cellData = Cell.getStringCellValue();
		return cellData;
	}
	
	// enter values for Job Schedule before searching
	public static void enterJobSchedule(String createdAtTime, String startsAtTime, String filterByType) {
		ArrowMiiBroadcastingIterator.txtJobCreatedAt(Setup.chromedriver).clear();
		ArrowMiiBroadcastingIterator.txtJobCreatedAt(Setup.chromedriver).sendKeys(createdAtTime);
		ArrowMiiBroadcastingIterator.txtJobStartsAt(Setup.chromedriver).clear();
		ArrowMiiBroadcastingIterator.txtJobStartsAt(Setup.chromedriver).sendKeys(startsAtTime);
		if (filterByType == "Regular") {
			ArrowMiiBroadcastingIterator.radiobtnRegular(Setup.chromedriver).click();
		}
		if ((filterByType == "VIP")) {
			ArrowMiiBroadcastingIterator.radiobtnVIP(Setup.chromedriver).click();
		}
		else {
			System.out.println("Invalid config.Default will be Regular.");
		}
			
	}
	
	// compare table values after doing search
	public static void compareGroupsToTrigger(String arrExpected1[], String arrExpected2[], String x1, String x2, String x3) {
	
		for (int i = 2; i <= ArrowMiiBroadcastingIterator.tblBroadcastRowCount(Setup.chromedriver); i++)
		{
			WebElement cellValueElement1 = Setup.chromedriver.findElement(By.xpath(x1+i+x2));
			String cellValue1 = cellValueElement1.getText();
			Assert.assertEquals(cellValue1, arrExpected1[i-2], "Passed");
		}
		
		for (int i = 2; i <= ArrowMiiBroadcastingIterator.tblBroadcastRowCount(Setup.chromedriver); i++)
		{
			WebElement cellValueElement2 = Setup.chromedriver.findElement(By.xpath(x1+i+x3));
			String cellValue2 = cellValueElement2.getText();
			Assert.assertEquals(cellValue2, arrExpected2[i-2], "Passed");	
		}		
		
	}

}
