package com.tests;

import com.annotations.FrameworkAnnotation;
import com.builder.requestBody.AllRequestBuilderImpl;
import com.pojo.Booking;
import com.pojo.BookingDates;
import com.reports.ExtendLogger;
import com.utils.ApiBuilders;
import com.utils.RandomUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;

public class Assignment {

    @Test
    @FrameworkAnnotation(authors = "Shital Malviya",categories = "Regression")
    public void AssignmentTest(){

        Response response = new ApiBuilders().requestBuilderForGetCalls().get("/booking");
        int size = response.jsonPath().getList("$").size();
        System.out.println(size);
        BookingDates bookingDates = BookingDates.builder().checkin("2018-01-01").checkout("2019-01-01").build();
        Booking booking = Booking.builder().firstname(RandomUtils.getName()).lastname(RandomUtils.getName())
                .totalprice(RandomUtils.getId()).depositpaid(true).bookingdates(bookingDates).additionalneeds("Breakfast")
                .build();


        Response postResponse = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(booking).post("/booking");
        ExtendLogger.printResponseBody(response.asPrettyString());
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

        postResponse.then().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")
        + "/src/main/resources/schema.json")));

        Response getresponse2 = new ApiBuilders().requestBuilderForGetCalls().get("/booking");
        int s2=getresponse2.jsonPath().getList("$").size();
       // Assertions.assertThat(s2).isEqualTo(size+1);


    }



}
