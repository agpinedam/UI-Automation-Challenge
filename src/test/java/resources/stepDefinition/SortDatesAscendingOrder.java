package resources.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.hooks.InitialHook;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class SortDatesAscendingOrder extends InitialHook {
    @Given("the user wants to sort top-rated movies by their date")
    public void theUserWantsToSortTopRatedMoviesByTheirDate() throws IOException {
        setup();
        homePage.menuComponent.movieOptions();
        homePage.menuComponent.topRated();
    }

    @When("the user sorts by date on ascending order")
    public void theUserSortsByDateOnAscendingOrder() {
        topRatedPage.sortOptions();
        topRatedPage.sortOptions();
        topRatedPage.sortByAscendingOrder();
        topRatedPage.clickOnSearch();
    }

    @Then("the user should see the dates of the first {int} movies in ascending order")
    public void theUserShouldSeeTheDatesOfTheFirstMoviesInAscendingOrder(int moviesQuantity) throws ParseException {
        Date[] dates= topRatedPage.getMovieDates(moviesQuantity);
        assertThat(dates[0],lessThan(dates[1]));
        assertThat(dates[1],lessThan(dates[2]));
        assertThat(dates[2],lessThan(dates[3]));
        driver.quit();
    }
}
