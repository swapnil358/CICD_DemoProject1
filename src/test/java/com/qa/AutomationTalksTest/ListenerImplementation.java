package com.qa.AutomationTalksTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerImplementation extends ObjectRepository implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// before each test case

		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");

		// log the exception

		test.log(Status.FAIL, result.getThrowable());

		// add screenshot for failed test

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String ScreenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/ExtentReport_" + actualDate
				+ ".png";

		File dest = new File(ScreenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//to add screenshot to the extent report

		try {
			test.addScreenCaptureFromPath(ScreenshotPath, "Tese case failure screenshot");
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// set up method call
		extent = ExtentReportsBasicDemo.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// close extent
		extent.flush();

	}

}
