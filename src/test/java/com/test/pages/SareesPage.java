package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.reporting.TestLogger;
import com.test.base.GeneralFunc;

public class SareesPage extends GeneralFunc {

	public SareesPage() throws Exception {
		super();
	}

	// verify category text
	String catgory = "//h3[contains(text(), 'Category' )]";
	String sareeslabel = "//h3[contains(text(), 'Category' )]/..//li/a";

	// verify page url
	public void verifyPageURL() {
		String actualURL = driver.getCurrentUrl();
		System.out.println("Thsi is sarees page url : " + actualURL);
		TestLogger.log("Info","(Validation)- Thsi is sarees page url  " + actualURL);
	}
	
	//Verify Sarees label
	public void verifyLabel(String Label){
		String actual_Label = driver.findElement(By.xpath(sareeslabel)).getText();
		System.out.println(actual_Label +" : "+ Label);
	}
	
	//verify page is landed or not.
	public void testSarees(){
		verifyPageURL();
		verifyLabel("Sarees");
		
	}
}
