package com.test.base;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;

public class InitialSetUp {

	public static WebDriver driver;
	public String chromeDriver;
	public String browser;
	public String url;
	public static int implicitTimeout;
	public Properties config;
	public String firefoxpath;
	public static ExtentTest test = new ExtentTest("test1", "test1");

	// adding constructor to initiate the webdriver.
	public InitialSetUp() throws Exception {
		// creating object reference for config to get the properties files.
		config = new Properties();
		// declaring the properties file variable name.
		String propFilename = "config.properties";
		// using input stream to access the values from properties file.
		InputStream inputstream = getClass().getClassLoader().getResourceAsStream(propFilename);
		// loading the properties file.
		config.load(inputstream);
		// get the browser name from properties file.
		browser = config.getProperty("BROWSER");
		chromeDriver = config.getProperty("CHROME_DRIVER_LOC");
		url = config.getProperty("URL");

	}

	// Method to initiate browser and set browser capabilities at the before
	// executing the test suite.
	@BeforeSuite(alwaysRun = true)
	public void instantiateWebDriver() throws Exception {
		try {
			if (browser.equalsIgnoreCase("CHROMEbrouserstack")) {
				ChromeOptions options = new ChromeOptions();
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				caps.setCapability("browser", "Chrome");
				caps.setCapability("os", "WINDOWS");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1366x768");
				caps.setCapability("browserstack.debug", "true");
				String brwsStackURL = "https://" + "anandakumarkandi1" + ":" + "DATYJP4H5sVcdAFNbEU2"
						+ "@hub-cloud.browserstack.com/wd/hub";

				java.net.URL myURL = new java.net.URL(brwsStackURL);
				driver = new RemoteWebDriver(myURL, caps);

			} else if (browser.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", chromeDriver);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("FIREFOX")) {
				System.setProperty("webdriver.gecko.driver", firefoxpath);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", "sadf");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "fsad");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
			driver.get(url);
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this meths will execute after the test suite.
	@AfterSuite(alwaysRun = true)
	public void generateReport() throws InterruptedException {

		driver.quit();

	}

}
