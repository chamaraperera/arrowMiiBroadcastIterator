package MyTest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;



public class TestClass {
	//constants
	public static final String excelPath = "/Users/chamaraperera/eclipse-workspace/MyJava/src/ArrowMiiData/ArrowMiiTestData.xlsx";
	
	//functions
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		Workbook excelWorkBook = WorkbookFactory.create(new File(excelPath));
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
		Sheet excelSheet = excelWorkBook.getSheetAt(1);
		//dataformatter to convert the excel cell values to string
		DataFormatter excelDataFormatter = new DataFormatter();
		
		Iterator<Row> excelRowIterator = excelSheet.rowIterator();
		while(excelRowIterator.hasNext()) {
			Row excelRow = excelRowIterator.next();
			
			
			
			Iterator<Cell> cellIterator = excelRow.cellIterator();
			while(cellIterator.hasNext()) {
				Cell excelCell = cellIterator.next();
				String cellValue = excelDataFormatter.formatCellValue(excelCell);
				System.out.println(cellValue+"/t");
				String arr[] = {};
				
			}	
			System.out.println("");
		}
		
		
		
	}
	
	
	

}

