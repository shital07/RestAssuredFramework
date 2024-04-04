package com.tests;

import com.annotations.FrameworkAnnotation;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class JiraTest {

    @SneakyThrows
    @Test
    @FrameworkAnnotation(authors = {"Shital Malviya"}, categories = {"Regression", "Smoke"})
    public void createTask(){

        String body = Files.readString(Paths.get(System.getProperty("user.dir") + "/src/main/resources/jira-task.json"));
        Response response = given().baseUri("https://shital0711.atlassian.net")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic c2hpdGFsMDcxMUBnbWFpbC5jb206QVRBVFQzeEZmR0YwZ0hOTEw2RXNFYlNiSjVHUkIyTmlPbmp2aDVYeExwcFdjZktkcFBobmp1ZVctcWVfallyZnkyVXNvcW5Ydk04dXVqeE9UNWJpSVNyeTF6SGJnSlRxdlRRVS1wUmtiTkwyY3Jha2xQUnU1RWRxeTZlV1p1ZW5tNFRjVWNqbWxCSV8zTUlIbVdYd2RjNFFFLUtkLWZSelY2Qy1NMGRjWU93aGVLMUFzVE8wcEhnPUMyQjZDNzhF")
                .body(body)
                .post("/rest/api/3/issue");
        response.then().statusCode(201);
        response.asPrettyString();


    }


}
