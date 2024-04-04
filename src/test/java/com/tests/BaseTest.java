package com.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void beforeSuiteSteps() {

    }

    @BeforeMethod
    public void beforeMethodSteps(Method method) {


    }

    @AfterMethod
    public void afterMethodSteps(ITestResult result) {

    }

    @AfterSuite
    public void afterSuiteSteps() {


    }
}
