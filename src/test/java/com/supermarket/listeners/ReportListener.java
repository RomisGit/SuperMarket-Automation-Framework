package com.supermarket.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarket.Utils.ExtentReporterUtil;
import com.supermarket.Utils.PageActions;
import com.supermarket.test.BaseTest;

public class ReportListener extends BaseTest implements ITestListener{

	ExtentReports extent= ExtentReporterUtil.getReporter();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "I am passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		try {
			extentTest.get().addScreenCaptureFromPath(PageActions.getScreenShot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Skipped test case");
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
