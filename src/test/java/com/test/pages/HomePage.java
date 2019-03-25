package com.test.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.reporting.TestLogger;
import com.test.base.GeneralFunc;

public class HomePage extends GeneralFunc {

	public HomePage() throws Exception {
		super();
	}

	String header_labels = "//ul[@class='header-dropdown']/li";

	String inputBox = "//input[@name='term' and @placeholder='Search a product']";

	String searchIcon = "//input[@name='term' and @placeholder='Search a product']/../div";

	// Verify header leabels in home page
	public void verifyHeaderLabels() {
		System.out.println("verifying header labels.");
		TestLogger.log("Info","(Validation)-" + "verifying header labels.");
		
		List<String> labels = Arrays.asList("Register As Producer", "Neighbor Pick", "Compare", "Wishlist",
				"My Account");

		List<String> actualList = new ArrayList<>();
		List<WebElement> hd = driver.findElements(By.xpath(header_labels));
		for (WebElement abc : hd) {
			System.out.println(abc.getText());
			TestLogger.log("Info","(Validation)-" + abc.getText());
			actualList.add(abc.getText());
		}

		System.out.println(actualList + " : " + labels);

	}

	// verify search input box
	public void verifyInputBox() {
		if (driver.findElement(By.xpath(inputBox)).isDisplayed()) {
			System.out.println("search input is displayed.");
			TestLogger.log("Info","(Validation)- " + "search input is displayed.");
		}
	}

	// verify searchIcon
	public void verifySearchIcon() {
		if (driver.findElement(By.xpath(searchIcon)).isDisplayed()) {
			System.out.println("search Icon is displayed.");
			TestLogger.log("Info","(Validation)- " + "search Icon is displayed.");
		}
	}

	// Click Search Icon
	public void clickSearchIcon() {
		verifySearchIcon();
		driver.findElement(By.xpath(searchIcon)).click();
		TestLogger.log("Info","(Validation)- " + "searchIcon clicked.");
	}

	// enter text in search input box
	public void enterTextInput(String Saree) {
		verifyInputBox();
		driver.findElement(By.xpath(inputBox)).sendKeys(Saree);
		TestLogger.log("Info","(Validation)- " + "searching Saree.");
	}

	//Search with Sarees Text and click search icon.
	public void searchSarees() {
		enterTextInput("Sarees");
		clickSearchIcon();
		
	}

}
