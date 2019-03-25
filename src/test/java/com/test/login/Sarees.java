package com.test.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.reporting.TestLogger;
import com.test.base.GeneralFunc;
import com.test.pages.HomePage;
import com.test.pages.SareesPage;

//@Listeners(com.utility.Listener.class)
public class Sarees extends GeneralFunc {

	public Sarees() throws Exception {
		super();
	}

	@Test
	public void testPAges() throws Exception {
//		String fileName = "data2.xls";
		String fileName = "data1.xlsx";
		String sheetName = "TestData";
		int rowNum = 1;
		
		HomePage hm = new HomePage();
		SareesPage sr = new SareesPage();
		TestLogger.log("Info","(Validation)-  " + "TestData");
		System.out.println(sr.getExcelValue(fileName, sheetName, "UserEmail", rowNum));

		System.out.println(sr.getExcelValue(fileName, sheetName, "Password", rowNum));

		System.out.println(sr.getExcelValue(fileName, sheetName, "FirstName", rowNum));

		System.out.println(sr.getExcelValue(fileName, sheetName, "LastName", rowNum));

		hm.verifyHeaderLabels();
		System.out.println("verifyHeaderLabels");
		hm.searchSarees();
		System.out.println("search sarees");
		Thread.sleep(5000);
		sr.testSarees();
		System.out.println("test sarees");
		// WebDriver augmentedDriver = new Augmenter().augment(driver);
		// File screenshot = ((TakesScreenshot)augmentedDriver).
		// getScreenshotAs(OutputType.FILE);

	}

}
