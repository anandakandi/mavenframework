package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.reporting.TestLogger;

public class GeneralFunc extends InitialSetUp {

	public GeneralFunc() throws Exception {
		super();

	}

	public String getExcelValue(String fileName, String sheetName, String columnName, int rowNum) throws IOException {

		int colNum = 0;
		Workbook mWorkbook = null;

		// Create a file object and provide the file path, dataFilePath is a
		// static variable read from config file
		File file = new File("src/test/resources/" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check the extension of the excel and create the workbook object
		// accordingly
		if (fileExtensionName.equals(".xlsx")) {
			mWorkbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			mWorkbook = new HSSFWorkbook(inputStream);
		}

		Sheet mSheet = mWorkbook.getSheet(sheetName);
		Row headerRow = mSheet.getRow(0);

		// Getting the the column number from the column name, which is passed
		// as a parameter
		for (int j = 0; j < headerRow.getLastCellNum(); j++) {
			String colValue = headerRow.getCell(j).getStringCellValue();
			if (colValue.equalsIgnoreCase(columnName)) {
				colNum = j;
			}
		}
		String rowValue = String.valueOf(mSheet.getRow(rowNum).getCell(colNum));
		// Getting and returning the value from excel form the row number and
		// column number
		// return mSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return rowValue;
	}

	public boolean isElementExists(WebElement we, String message) {
		try {
			we.isDisplayed();
			TestLogger.log("Pass", "(Validation)-" + message);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
