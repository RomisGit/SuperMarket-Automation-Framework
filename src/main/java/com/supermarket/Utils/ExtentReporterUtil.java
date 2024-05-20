package com.supermarket.Utils;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Context.Constants;

public class ExtentReporterUtil {
	public static ExtentReports extent;
	public static ExtentReports getReporter() {
		//String reportPath = System.getProperty("user.dir")+"//Reports//AutomationReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.REPORTPATH);
		reporter.config().setReportName("Obsqura Automation Report");
		reporter.config().setDocumentTitle("Obsqura Zone");
        extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Romy");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}

}
