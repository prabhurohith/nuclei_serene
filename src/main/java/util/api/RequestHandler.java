package util.api;

import io.restassured.specification.RequestSpecification;
import questions.EnvironmentInfo;

public class RequestHandler {

    public static RequestSpecification enableLoggingIfRequired(RequestSpecification requestSpec) {
        if (EnvironmentInfo.isLoggingEnabled()) {
            return requestSpec.log().all();
        } else return requestSpec;
    }
}
