package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Update profile")
    public void updateProfile() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("testusername245", "disha123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.prettyPrint());
        System.out.println("----------------------------------------------");
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        Assert.assertEquals(userProfileResponse.getUsername(), "testusername245");

        response = userProfileManagementService.updateProfile(loginResponse.getToken(), new ProfileRequest.Builder().firstName("Raj").lastName("bhat").email("gmail@gmail.com").mobileNumber("7777677778").build());
        System.out.println(response.asPrettyString());
    }

}
