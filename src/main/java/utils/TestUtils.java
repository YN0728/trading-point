package utils;

import io.restassured.response.Response;

public class TestUtils {

    public static String capitalize(final String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String capitalizeAndSeparate(final String inputStr) {
        final String[] words = inputStr.split("-");
        final StringBuilder formattedStr = new StringBuilder();

        for (String word : words) {
            formattedStr.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1)).append(" ");
        }
        return formattedStr.toString().trim();
    }

    public static Response validate(final Response response, final int expectedStatusCode) {
        return response.then()
                .statusCode(expectedStatusCode)
                .extract()
                .response();
    }

}
