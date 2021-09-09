package resources.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.hooks.InitialHook;
import java.io.IOException;

public class SuccessfulSearch  extends InitialHook {

    @Given("the user wants to search for a movie")
    public void theUserWantsToSearchForAMovie() throws IOException {
        setup();
    }
    @When("the user enters the title {string}")
    public void theUserEntersTheTitle(String movieName) {
        homePage.search(movieName);
    }
    @Then("the user should see the movie {string} as the first result")
    public void theUserShouldSeeTheMovieAsTheFirstResult(String movieName) {
        Assert.assertEquals(movieResultsPage.firstNameResult(), movieName);
        driver.quit();
    }
}
