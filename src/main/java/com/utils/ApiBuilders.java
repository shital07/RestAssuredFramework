package com.utils;

import com.builder.requestbody.RequestBuilderStrategy;
import com.enums.PropertiesType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class ApiBuilders {


    RequestBuilderStrategy requestBuilderStrategy;

    public ApiBuilders(RequestBuilderStrategy requestBuilderStrategy){
        this.requestBuilderStrategy = requestBuilderStrategy;
    }
    public ApiBuilders(){
    }
    public  RequestSpecification requestBuilderForGetCalls(){
      return  given()
                .baseUri(PropertyReaderUtil.getKey(PropertiesType.BASEURL))
                .header("Accept", "application/json")
                .log().all();

    }
    public RequestSpecification requestBuilderForPostCalls(Object o){
        return  given()
                .baseUri(PropertyReaderUtil.getKey(PropertiesType.BASEURL))
                .header("Accept", "application/json")
                .contentType("application/json")
                .body(requestBuilderStrategy.createRequestBuilder(o))
                .log()
                .all();

    }
}
