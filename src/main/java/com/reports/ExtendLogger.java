package com.reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtendLogger {
    private ExtendLogger() {

    }

    public static void log(Status status, String message) {
        ExtendReportManager.getTest().log(status, message);

    }

    public static void pass(String message) {
        ExtendReportManager.getTest().log(Status.PASS, message);

    }

    public static void fail(String message) {
        ExtendReportManager.getTest().log(Status.FAIL, message);

    }

    public static void skip(String message) {
        ExtendReportManager.getTest().log(Status.SKIP, message);

    }

    public static void info(String message) {
        ExtendReportManager.getTest().info(message);

    }

    public static void printResponseBody(String response) {

        ExtendReportManager.getTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));


    }

    public static void printRequestBody(RequestSpecification requestSpecification) {

        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        ExtendReportManager.getTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));


    }


}
