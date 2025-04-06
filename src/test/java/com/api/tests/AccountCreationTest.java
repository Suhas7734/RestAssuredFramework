package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "account creation test")
    public void createAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("testusername245")
                .email("krime1234@gmail.com")
                .firstName("suhas")
                .lastName("manager")
                .password("disha123")
                .mobileNumber("0765772785")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.prettyPrint(),"User registered successfully!");
    }

}
