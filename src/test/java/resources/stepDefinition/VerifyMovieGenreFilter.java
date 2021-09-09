package resources.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.hooks.InitialHook;

import java.io.IOException;

public class VerifyMovieGenreFilter extends InitialHook {
    @Given("the user wants to see the top-rated movies")
    public void theUserWantsToSeeTheTopRatedMovies() throws IOException {
        setup();
        homePage.menuComponent.movieOptions();
        homePage.menuComponent.topRated();
    }
    @And("the user wants to filter for {string} movies")
    public void theUserWantsToFilterForMovies(String genre) {
        topRatedPage.filterOptions();
    }
    @When("the user applies the {string} filter")
    public void theUserAppliesTheFilter(String genre) {
        topRatedPage.genreFilter(genre);
        topRatedPage.clickOnSearch();
    }
    @And("the user selects {string} movie")
    public void theUserSelectsMovie(String movieName) {
        topRatedPage.selectMovie(movieName);
    }
    @Then("the user should see the genre of the movie includes {string}")
    public void theUserShouldSeeTheGenreOfTheMovieIncludes(String genre) {
        Assert.assertEquals(topRatedPage.verifyGenre(genre),genre);
        driver.quit();
    }

}
