package api;

import io.restassured.response.Response;

import static api.RequestSpecificationSetup.setUpSpec;
import static io.restassured.RestAssured.given;

public class SwapiHelpers {

    public static Response getApiResponse(final String url) {
        return given()
                .when()
                .log()
                .ifValidationFails()
                .get(url);
    }

    public static Response getPeople() {
        return given()
                .spec(setUpSpec("people"))
                .log()
                .ifValidationFails()
                .get();
    }

    public static Response getPeople(final int pageNumber) {
        return given()
                .spec(setUpSpec("people"))
                .queryParam("page", pageNumber)
                .log()
                .ifValidationFails()
                .get();
    }

    public static Response getPeople(final String name) {
        return given()
                .spec(setUpSpec("people"))
                .queryParam("search", name)
                .log()
                .ifValidationFails()
                .get();
    }
}
