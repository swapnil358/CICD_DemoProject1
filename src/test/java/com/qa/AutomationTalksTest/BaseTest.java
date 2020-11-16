package com.qa.AutomationTalksTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver;

	@BeforeMethod
	public void setUP() {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\n\\Desktop\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.automationtalks.com");

	}

	@Test
	public void test1() {
		System.out.println("test case 1: "+driver.getTitle());

	}

	@Test
	public void test2() {
		System.out.println("test case 2: "+driver.getTitle());

	}

	@Test
	public void test3() {
		System.out.println("test case 3: "+driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
