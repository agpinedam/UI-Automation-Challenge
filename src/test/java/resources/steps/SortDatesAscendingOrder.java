package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class SortDatesAscendingOrder extends Hooks {
    @Given("the user wants to sort top-rated movies by their date")
    public void theUserWantsToSortTopRatedMoviesByTheirDate() throws IOException {
        setup();
        homePage.movieOptions();
        homePage.topRated();
    }

    @When("the user sorts by date on ascending order")
    public void theUserSortsByDateOnAscendingOrder() {
        topRatedPage.sortOptions();
        topRatedPage.sortByAscendingOrder();
        topRatedPage.applyFilter();
    }

    @Then("the user should see the dates of the first {int} movies in ascending order")
    public void theUserShouldSeeTheDatesOfTheFirstMoviesInAscendingOrder(int arg0) throws ParseException {
        topRatedPage.getMovieDates(arg0);
        Date[] dates= topRatedPage.getMovieDates(arg0);
        assertThat(dates[0],lessThan(dates[1]));
        assertThat(dates[1],lessThan(dates[2]));
        assertThat(dates[2],lessThan(dates[3]));
        driver.close();
    }
}
