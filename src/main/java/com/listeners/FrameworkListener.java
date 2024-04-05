package com.listeners;

import com.annotations.FrameworkAnnotation;
import com.aventstack.extentreports.Status;
import com.reports.ExtendLogger;
import com.reports.ExtentReport;
import org.testng.*;

public class FrameworkListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {

        ExtentReport.initReport();

    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .authors();
        ExtentReport.printAuthor(authors);
        String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .categories();
        ExtentReport.printCategory(categories);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendLogger.log(Status.PASS, result.getMethod().getMethodName()
                + " is Passed ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendLogger.log(Status.FAIL, result.getMethod().getMethodName() + " is Fail ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendLogger.log(Status.SKIP, result.getMethod().getMethodName() + " is Skipped ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}


