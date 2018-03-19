package MyTest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;



public class TestClassExcelCodeBackup {
	//constants
	public static final String sampleClassPath = "/Users/chamaraperera/eclipse-workspace/MyJava/src/ArrowMiiData/ArrowMiiTestData.xlsx";
	
	//functions
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		Workbook workbook = WorkbookFactory.create(new File(sampleClassPath));
		System.out.println("Work book has sheets"+workbook.getNumberOfSheets());
		
		//Get all sheet names from workbook
		workbook.getSheetAt(0);
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		System.out.println("Getting sheet names...");
		while (sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			System.out.println("Sheet: "+ sheet.getSheetName());
		}
		
		//set which sheet to read from
		Sheet sheet = workbook.getSheetAt(1);
		//dataformatter to convert the excel cell values to string
		DataFormatter dataFormatter = new DataFormatter();
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
		
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.println(cellValue+"/t");
			}	
			System.out.println("");
		}
		
		
		
	}
	
	
	

}

