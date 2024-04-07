package com.tests;

import com.annotations.FrameworkAnnotation;
import com.builder.requestbody.AllRequestBuilderImpl;
import com.builder.requestbody.FileRequestBuilderImpl;
import com.constants.FrameworkConstantSingleton;
import com.github.javafaker.Faker;
import com.pojo.Booking;
import com.pojo.BookingDates;
import com.reports.ExtendLogger;
import com.utils.ApiBuilders;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.utils.RandomUtils.getId;
import static com.utils.RandomUtils.getName;


public class Post extends BaseTest {

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void testPost() {

        String body = "{\n" + "    \"firstname\" : \"Jim\",\n" + "    \"lastname\" : \"Brown\",\n" + "    \"totalprice\" : 111,\n" + "    \"depositpaid\" : true,\n" + "    \"bookingdates\" : {\n" + "        \"checkin\" : \"2018-01-01\",\n" + "        \"checkout\" : \"2019-01-01\"\n" + "    },\n" + "    \"additionalneeds\" : \"Breakfast\"\n" + "}";
        RequestSpecification requestSpecification = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(body);
        ExtendLogger.printRequestBody(requestSpecification);

        Response response = requestSpecification.post("/booking");

        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/" +
                "/schema.json")));


        ExtendLogger.printResponseBody(response.asPrettyString());
    }

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void testPostFile() {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/data.json");


        RequestSpecification requestSpecification = new ApiBuilders(new FileRequestBuilderImpl()).requestBuilderForPostCalls(file);
        ExtendLogger.printRequestBody(requestSpecification);
        Response response = requestSpecification.post("/booking");

        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

    }

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void testPostFileAsString() throws IOException {

        String resBody = Files.readString(Paths.get(System.getProperty("user.dir") + "/src/main/resources/data.json"));
        String replaceBody = resBody.replace("111", String.valueOf(new Faker().number().numberBetween(100, 1000))).replace("fname", new Faker().name().firstName());

        RequestSpecification requestSpecification = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(replaceBody);

        ExtendLogger.printRequestBody(requestSpecification);
        Response response = requestSpecification.post("/booking");

        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

    }

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void testPostWithMap() {

        Map<String, Object> mp = new HashMap<>();
        mp.put("firstname", new Faker().name().firstName());
        mp.put("lastname", new Faker().name().lastName());
        mp.put("totalprice", new Faker().number().numberBetween(100, 1000));
        mp.put("depositpaid", true);
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");
        mp.put("bookingdates", bookingdates);
        mp.put("additionalneeds", "Breakfast");


        RequestSpecification requestSpecification1 = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(mp);
        ExtendLogger.printRequestBody(requestSpecification1);
        Response response = requestSpecification1.post("/booking");

        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

    }


    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void testPostByJson() {

        JSONObject object = new JSONObject();
        object.put("firstname", new Faker().name().firstName());
        object.put("lastname", new Faker().name().lastName());
        object.put("totalprice", new Faker().number().numberBetween(100, 1000));
        object.put("depositpaid", true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");
        object.put("bookingdates", bookingdates);
        object.put("additionalneeds", "Breakfast");
        //// object.accumulate("additionalneeds","") --- create an array with already use key
        // object.putOpt()   - when we want to add only if value in non-null

        Response response = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(object.toMap()).post("/booking");


        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

    }

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void TestPostByPojo() throws IOException {

        BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
        Booking booking = new Booking(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(100, 1000), true, bookingDates, "Breakfast");

        Response response = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(booking).post("/booking");

        response.then().log().all();
        response.then().statusCode(200);

        Booking booking1 = response.jsonPath().getObject("booking", Booking.class);
        System.out.println(booking1.getFirstname());

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

        Files.write(Paths.get(System.getProperty("user.dir") + "/output.json"), response.asByteArray());


    }

    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void TestPostByBuilder() {
        BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");


        // using lombok builder
/*Booking.builder().firstname(new Faker().name().firstName())
        .lastname(new Faker().name().lastName())
        .totalprice(388)
        .setBookingdates(bookingDates).build();*/

        Booking booking = Booking.BookingBuilder.builder().setFirstname(getName()).setLastname(new Faker().name().lastName()).setTotalprice(getId()).setDepositpaid(true).setBookingdates(bookingDates).setAdditionalneeds("Breakfast").build();


        Response response = new ApiBuilders(new AllRequestBuilderImpl()).requestBuilderForPostCalls(booking).post("/booking");

        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));

    }


    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void TestPostByFunctionalInterface() {
        BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");
        Booking booking = Booking.BookingBuilder.builder().setFirstname(getName()).setLastname(new Faker().name().lastName()).setTotalprice(getId()).setDepositpaid(true).setBookingdates(bookingDates).setAdditionalneeds("Breakfast").build();

        ApiBuilders apiBuilders = new ApiBuilders((o) -> {

            if (o instanceof Booking) return o;
            else {
                throw new RuntimeException("testing");
            }
        });

        Response response = apiBuilders.requestBuilderForPostCalls(booking).post("/booking");

        response.then().log().all();
        response.then().statusCode(200);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstantSingleton.getInstance().getResourcePath() + "/schema.json")));
    }

}
