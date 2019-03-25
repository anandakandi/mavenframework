package com.test.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.test.base.BaseTest;
import com.test.base.GeneralFunc;

public class Test2 extends GeneralFunc implements Test1Page {
	// constructor for this class to invoke driver
	public Test2() throws Exception {
		super();
	}

	public void categoryList() {
		System.out.println("test started....");
		
		Select s = new Select(driver.findElement(By.xpath("//select[@class='select-main']")));

		List<WebElement> cateoryLisst = s.getOptions();
		System.out.println(cateoryLisst.size());

		// creating array list to add all items
		List actualCategories = new ArrayList<>();
		List expectedCategories = new ArrayList<>(
				Arrays.asList("Categories:", "Fashion", "Food", "Home", "Collections"));
		for (WebElement ee : cateoryLisst) {
			// System.out.println(ee.getText());
			actualCategories.add(ee.getText());

		}
		System.out.println(expectedCategories);
		System.out.println(actualCategories);
		Assert.assertEquals(expectedCategories, actualCategories, "this is passed");		
		

	}
}
