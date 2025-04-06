package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

    @Test(description = "Verify if login API is working")
    public void loginTest() throws IOException {

//        JSONObject requestBody = new JSONObject();
//        requestBody.put("username","Krime");
//        requestBody.put("password","Krime@123");
        String reqBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/loginPayload.json")));

//        baseURI = "http://64.227.160.186:8080";
        // how the request is going to look ,
//        RequestSpecification given = RestAssured.given();
//        RequestSpecification header = RestAssured.given().header("Content-type", "application/json");
//        RequestSpecification body = RestAssured.given().header("Content-type", "application/json").body(reqBody);
//        Response response = given()
//                .baseUri("http://64.227.160.186:8080")
//                .header("Content-type", "application/json")
//                .body(reqBody)
//                .when()
//                .post("api/auth/login");
//        System.out.println(response.prettyPrint());

        LoginRequest loginRequest = new LoginRequest("Krime","Krime@123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        //as -> converts json object to java object



//        System.out.println(response.prettyPeek());
//        System.out.println(loginResponse.getToken());
//        System.out.println(loginResponse.getEmail());
//        System.out.println(loginResponse.getRoles());

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"krime123@krimee.com");
        Assert.assertEquals(loginResponse.getId(),650);

        Assert.assertEquals(response.getStatusCode(), 200);


    }

}
