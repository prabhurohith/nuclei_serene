package model.api.request;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class RequestHeaders {

    public static Map<String, Object> getHeadersForCreatePet() {
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("accept", ContentType.JSON);
        requestHeaders.put("Content-Type", ContentType.JSON);
        return requestHeaders;
    }

}
