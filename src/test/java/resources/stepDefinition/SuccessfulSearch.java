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
    @When("the user enters the title Fight Club")
    public void theUserEntersTheTitleFightClub() {

        homePage.search("Fight Club");
    }
    @Then("the user should see the movie as the first result")
    public void theUserShouldSeeTheMovieAsTheFirstResult() {
        Assert.assertEquals(movieResultsPage.firstNameResult(), "Fight Club");
        driver.quit();
    }
}