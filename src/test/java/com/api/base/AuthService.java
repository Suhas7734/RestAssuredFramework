package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payLoad) {
        return postRequest(payLoad, BASE_PATH + "login");
    }

    public Response signUp(SignUpRequest payLoad) {
        return postRequest(payLoad, BASE_PATH + "signup");
    }

    public Response forgotPassword(String email) {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return postRequest(payload, BASE_PATH + "forgot-password");
    }



}
