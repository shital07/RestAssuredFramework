package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtendReportDemo {

    @Test
    public void test() {
        ExtentReports reports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Test Extend Report");
        reports.setSystemInfo("Hostname", System.getProperty("user.name"));
        reports.setSystemInfo("Env", "dev");
        reports.setSystemInfo("Username", "Shital Malviya");
        reports.attachReporter(extentSparkReporter);

        ExtentTest test = reports.createTest("Demo", "Checking Extend report in API automation");
        test.log(Status.PASS, "This is the logging for the demo TCs and it is pass");
        reports.flush();

    }


}
