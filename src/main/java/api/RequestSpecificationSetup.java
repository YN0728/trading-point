package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecificationSetup {

    private static final String BASE_URL = "https://swapi.dev/api";

    public static RequestSpecification setUpSpec(final String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(basePath)
                .setContentType(JSON)
                .build();
    }
}
