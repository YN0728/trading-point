package flows;

import api.SwapiHelpers;
import io.restassured.response.Response;

import java.util.logging.Logger;
import java.util.*;
import java.util.stream.IntStream;

import static utils.TestUtils.*;
import static org.apache.http.HttpStatus.*;

public class SwapiFlows {

    private static final Logger LOGGER = Logger.getLogger(SwapiFlows.class.getName());

    public static Response findFilmWithMinPlanets(final Response personInfo) {
        return ((List<String>) personInfo.path("results[0].films")).stream()
                .map(SwapiHelpers::getApiResponse)
                .map(response -> validate(response, SC_OK))
                .min(Comparator.comparing(item ->
                        item.path("planets.size()"))).get();
    }

    public static List<String> getStarshipsFromFilms(final Response response) {
        return response.path("starships");
    }

    public static List<String> getStarshipsFromPerson(final Response response) {
        return response.path("results[0].starships");
    }

    public static boolean isVaderStarshipInFilm(final Response vaderResponse, final Response filmResponse) {
        return isFullySubList(getStarshipsFromFilms(filmResponse), getStarshipsFromPerson(vaderResponse));
    }

    private static boolean isFullySubList(final List<String> list1, final List<String> list2) {
        final Set<String> set1 = new HashSet<>(list1);
        final Set<String> set2 = new HashSet<>(list2);

        return set1.containsAll(set2);
    }

    public static void findOldestPerson() {
        final List<Map<String, String>> birthYearsAndNames = new ArrayList<>();
        final Response firstPageOfPeople = validate(SwapiHelpers.getPeople(1), SC_OK);
        addBirthYearAndNameToList(firstPageOfPeople, birthYearsAndNames);

        final int count = firstPageOfPeople.path("count");
        final int pageCount = (int) Math.ceil(count / 10d);

        IntStream.range(2, pageCount)
                .forEach(i -> addBirthYearAndNameToList(validate(SwapiHelpers.getPeople(i), SC_OK), birthYearsAndNames));
        LOGGER.info("The oldest person is " + findOldestPersonFromList(birthYearsAndNames));
    }

    private static void addBirthYearAndNameToList(Response peopleResponse, List<Map<String, String>> birthYearsAndNames) {
        final List<Map<String, String>> birthYearAndNames = peopleResponse.path("results.flatten().findAll { it.birth_year != 'unknown' }.collect { [birth_year: it.birth_year, name: it.name] }");
        birthYearsAndNames.addAll(birthYearAndNames);
    }

    private static String findOldestPersonFromList(List<Map<String, String>> birthYearAndNames) {
        double oldestBirthYear = Double.MAX_VALUE;
        String oldestPersonName = null;

        for (Map<String, String> entry : birthYearAndNames) {
            final String birthYear = entry.get("birth_year");
            final double yearsBeforeOrAfterYavin = Double.parseDouble(birthYear.substring(0, birthYear.length() - 3));
            final double personBirthYear = birthYear.endsWith("BBY") ?
                    -yearsBeforeOrAfterYavin : yearsBeforeOrAfterYavin;
            if (personBirthYear < oldestBirthYear) {
                oldestBirthYear = personBirthYear;
                oldestPersonName = entry.get("name");
            }
        }
        return oldestPersonName;
    }


}
