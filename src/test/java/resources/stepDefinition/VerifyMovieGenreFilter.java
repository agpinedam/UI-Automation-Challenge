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
        homePage.movieOptions();
        homePage.topRated();
    }
    @And("the user wants to filter for action movies")
    public void theUserWantsToFilterForActionMovies() {
        topRatedPage.filterOptions();
    }

    @When("the user applies the action filter")
    public void theUserAppliesTheActionFilter() {
        topRatedPage.genreFilter("Action");
        topRatedPage.clickOnSearch();
    }

    @And("the user selects any movie")
    public void theUserSelectsAnyMovie() {
        topRatedPage.selectMovie("The Dark Knight");
    }

    @Then("the user should see the genre of the movie includes action")
    public void theUserShouldSeeTheGenreOfTheMovieIncludesAction() {
        Assert.assertEquals(topRatedPage.verifyGenre("Action"),"Action");
        driver.quit();
    }
}
