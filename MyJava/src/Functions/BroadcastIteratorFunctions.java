package Functions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ArrowMiiConstants.Constants;
import ArrowMiiPages.ArrowMiiBroadcastingIterator;
import ArrowMiiUtils.Setup;

public class BroadcastIteratorFunctions {
	
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
	
	// obsolete, now replaced with readExcelAndCompare method.
	public static void compareGroupsToTrigger(String arrExpected1[], String arrExpected2[], String x1, String x2, String x3) throws InvalidFormatException, IOException {
		//readExcelAndCompare();
		
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
	
	public static void readExcelAndCompare(int scenario, String xpath1, String xpath2, String xpath3) throws IOException, InvalidFormatException{

		ArrayList<String> valueList = new ArrayList<String>();
		String cellValue = "";
		Integer init = 0;
		Integer skip1 = 1;
		Integer skip2 = 1;

			Workbook excelWorkBook = WorkbookFactory.create(new File(Constants.excelPath));
			System.out.println("Work book has sheets"+excelWorkBook.getNumberOfSheets());
			
			//Get all sheet names from workbook
			excelWorkBook.getSheetAt(0);
			Iterator<Sheet> excelSheetIterator = excelWorkBook.sheetIterator();
			System.out.println("Getting sheet names...");
			while (excelSheetIterator.hasNext()) {
				Sheet excelSheet = excelSheetIterator.next();
				System.out.println("Sheet: "+ excelSheet.getSheetName());
			}
			
			//set which sheet to read from
			Sheet excelSheet = excelWorkBook.getSheetAt(scenario);
			//dataformatter to convert the excel cell values to string
			DataFormatter excelDataFormatter = new DataFormatter();
	
			Iterator<Row> excelRowIterator = excelSheet.rowIterator();
			while(excelRowIterator.hasNext()) {
				Row excelRow = excelRowIterator.next();
	
				Iterator<Cell> cellIterator = excelRow.cellIterator();
				while(cellIterator.hasNext()) {	
					Cell excelCell = cellIterator.next();
					cellValue = excelDataFormatter.formatCellValue(excelCell);
					//System.out.println(cellValue+"of excel");
					//add both the read values of the excel rows to the arrayList
					valueList.add(cellValue);
				}
				//System.out.println("");
				//valueList.add(cellValue);
			}
			//System.out.println(valueList+"Final");
			
			for (init = 2; init <= ArrowMiiBroadcastingIterator.tblBroadcastRowCount(Setup.chromedriver); init++)
			{
				WebElement cellValueElement1 = Setup.chromedriver.findElement(By.xpath(xpath1+init+xpath2));
				String cellValue1 = cellValueElement1.getText();
				//System.out.println("row value: "+cellValue1);
				if (init<=2) {
					Assert.assertEquals(cellValue1, valueList.get(init), "Passed");
				}else {
					Assert.assertEquals(cellValue1, valueList.get(init+skip1), "Passed");
					skip1++;
					}
				}
			
			for (init = 2; init <= ArrowMiiBroadcastingIterator.tblBroadcastRowCount(Setup.chromedriver); init++)
			{
				WebElement cellValueElement2 = Setup.chromedriver.findElement(By.xpath(xpath1+init+xpath3));
				String cellValue2 = cellValueElement2.getText();
				//System.out.println("column value: "+cellValue2);
				if (init<=2) {
					Assert.assertEquals(cellValue2, valueList.get(init+skip2), "Passed");
					skip2++;
				}else {
					Assert.assertEquals(cellValue2, valueList.get(init+skip2), "Passed");
					skip2++;
					}
				}
		}
}
