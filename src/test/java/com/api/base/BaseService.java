package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    //handles base URI
    //creating the request
    //handling the response
    //abstraction

//    private static final String BASE_URL = "http://64.227.160.186:8080";
    private static final String BASE_URL;

    static {
        String env = System.getProperty("env", "dev");
        switch (env.toLowerCase()) {
            case "qa":
                BASE_URL = "http://64.227.160.186:8080";
                break;
            case "staging":
                BASE_URL = "http://64.227.160.186:8080";
                break;
            case "prod":
                BASE_URL = "http://64.227.160.186:8080";
                break;
            default:
                BASE_URL = "http://64.227.160.186:8080";
        }
    }
    private final RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        this.requestSpecification = RestAssured.given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(Object payload, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
    }

    protected Response getRequest(String endPoint) {
        return requestSpecification.get(endPoint);
    }

    protected Response putRequest(Object payload, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
    }


}
