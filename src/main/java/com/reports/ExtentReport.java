package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Arrays;
import java.util.Objects;


public final class ExtentReport {
    private ExtentReport() {

    }

    static ExtentReports reports;
    static ExtentTest test;

    public static void initReport() {
        if (Objects.isNull(reports)) {
            reports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports");
            extentSparkReporter.config().setDocumentTitle("Automation Report");
            extentSparkReporter.config().setReportName("Test Extend Report");
            reports.setSystemInfo("Hostname", System.getProperty("user.name"));
            reports.setSystemInfo("Env", "dev");
            reports.setSystemInfo("Username", "Shital Malviya");
            reports.attachReporter(extentSparkReporter);
        }
    }

    public static void createTest(String name) {

        System.out.println(name);
        test = reports.createTest(name);
        ExtendReportManager.setTest(test);

    }

    public static void flushReport() {
        if (Objects.nonNull(reports)) {
            reports.flush();
        }
    }

    public static void log(boolean status) {

        if (status) {
            ExtendReportManager.getTest().log(Status.PASS, "");
        } else {
            ExtendReportManager.getTest().log(Status.FAIL, "");
        }

    }

    public static void printAuthor(String[] authors){
        Arrays.stream(authors).forEach((s)-> ExtendReportManager.getTest().assignAuthor(s));
    }

    public static void printCategory(String[]  categories){
        Arrays.stream(categories).forEach((s)-> ExtendReportManager.getTest().assignCategory(s));
    }
}

