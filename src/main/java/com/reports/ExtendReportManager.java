package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtendReportManager {

    private ExtendReportManager() {

    }

    private static ThreadLocal<ExtentTest> td = new ThreadLocal<>();

    static ExtentTest getTest() {
        return td.get();
    }

    static void setTest(ExtentTest test) {
        td.set(test);
    }

    static void unload() {
        td.remove();
    }


}
