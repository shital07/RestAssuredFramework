package com.tests;

import com.annotations.FrameworkAnnotation;
import com.utils.ApiBuilders;
import io.restassured.response.Response;
import org.testng.annotations.Test;



public class Get {



    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"},categories = {"Regression","Smoke"})
    public void testGet() {


        Response response = new ApiBuilders().requestBuilderForGetCalls().get("/booking");
        response.then().statusCode(200);
        response.then().log().all();

    }
}
