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

public class BaseTest_SeleniumGrid {

	WebDriver driver;

	@BeforeMethod
	public void setUP() throws InterruptedException, MalformedURLException {

	

		 DesiredCapabilities dr = DesiredCapabilities.chrome();
		 dr.setBrowserName("chrome");
		 dr.setPlatform(Platform.WINDOWS);
		
		 System.setProperty("webdriver.chrome.driver", "D:\\Desktop_Data\\chromedriver_win32\\chromedriver1.exe");
		 
		// System.setProperty("webdriver.geckodriver.driver", "D:\\SeleniumGrid\\geckodriver.exe");

		driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), dr);

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
		driver.findElement(By.xpath(
				"//body/div[@id='body-core']/header/div[@id='site-header']/div[@id='header']/div[@id='header-core']/div[@id='header-links']/div[@id='header-links-inner']/ul[@id='menu-topmenu']/li[@id='menu-item-462']/a[1]"))
				.click();

	}

	@Test(description = "Validate Home page")
	public void ValidateHomepage() {
		System.out.println("ValidateHomepage: " + driver.getTitle());

	}

	@Test(description = "Validate Registration page")
	public void ValidateRegistrationpage() {
		// test.log(Status.PASS, "Validate registration page with details");
		System.out.println("ValidateRegistrationpage:");

		driver.findElement(By.xpath(
				"//body/div[@id='body-core']/header/div[@id='site-header']/div[@id='header']/div[@id='header-core']/div[@id='header-links']/div[@id='header-links-inner']/ul[@id='menu-topmenu']/li[@id='menu-item-462']/a[1]"))
				.click();
		String actualText = driver.getTitle();
		Assert.assertEquals(actualText, "Home page");
		System.out.println("ValidateRegistrationpage : " + driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
