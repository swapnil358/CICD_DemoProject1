package com.qa.AutomationTalksTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsBasicDemo extends ObjectRepository{


	/*
	 * public static ExtentTest test; public static String actualDate;
	 */

	public static ExtentReports setUpExtentReport()  {

		//ITestlistener
		// 1.Set up report ---> One time activity / before test begin
		// 2. Create test -->before each test
		// 3. attachScreenshot -- on Failure
		// 4. close report -- after execution

		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yy HH-mm-ss");

		Date date = new Date();
		actualDate = format.format(date);
		System.out.println("/Reports/ExtentReport_" + actualDate + " is created");

		String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + actualDate + "_.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

		// ExtentReports extent = new ExtentReports();

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("CICD Execution Report");

		return extent;

	}

}
