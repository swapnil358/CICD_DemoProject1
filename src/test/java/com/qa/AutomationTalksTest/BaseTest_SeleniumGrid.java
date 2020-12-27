package com.qa.AutomationTalksTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This base class is configured for seleniumGrid 
 * @author swapn
 *
 */

public class BaseTest_SeleniumGrid {

	WebDriver driver;

	@BeforeMethod
	public void setUP() throws InterruptedException, MalformedURLException {

	

		 DesiredCapabilities dr = DesiredCapabilities.chrome();
		 dr.setBrowserName("chrome");
		 dr.setPlatform(Platform.LINUX);
		
		 System.setProperty("webdriver.chrome.driver", "D:\\Desktop_Data\\chromedriver_win32\\chromedriver1.exe");
		 
		// System.setProperty("webdriver.geckodriver.driver", "D:\\SeleniumGrid\\geckodriver.exe");

	driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), dr);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.automationtalks.com");
		Thread.sleep(5000);

	}

	@Test(description = "Validate login page")
	public void ValidateLoginPage() {
		// test.log(Status.PASS, "Login to application with valid credentials");
		System.out.println("ValidateLoginPage: " + driver.getTitle());
		
	}

	@Test(description = "Validate Home page")
	public void ValidateHomepage() {
		System.out.println("ValidateHomepage: " + driver.getTitle());

	}

	@Test(description = "Validate Registration page")
	public void ValidateRegistrationpage() {
		// test.log(Status.PASS, "Validate registration page with details");
		
		System.out.println("ValidateRegistrationpage : " + driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
