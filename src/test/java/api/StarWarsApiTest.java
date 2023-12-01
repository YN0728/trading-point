package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static flows.SwapiFlows.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertTrue;

import static org.apache.http.HttpStatus.*;
import static utils.TestUtils.*;


public class StarWarsApiTest {

    @Test
    public void vaderStarshipOnFilm() {
        final Response vaderPersonResponse = validate(SwapiHelpers.getPeople("Vader"), SC_OK);
        final Response filmWithMinPlanets = findFilmWithMinPlanets(vaderPersonResponse);

        assertTrue(isVaderStarshipInFilm(vaderPersonResponse, filmWithMinPlanets),
                "Vader's starship is NOT on the film with minimum planets");
    }

    @Test
    public void findOldest() {
        findOldestPerson();
    }

    @Test
    public void checkPeopleJSONSchema() {
        SwapiHelpers.getPeople().then()
                .statusCode(SC_OK)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/people.json"));
    }

}
