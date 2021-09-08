package resources.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.testng.Assert;
import resources.hooks.InitialHook;

import java.io.IOException;


public class ValidateActingTimeline extends InitialHook {
    @Given("the user selects a movie with actors")
    public void theUserSelectsAMovieWithActors() throws IOException {
        setup();
        homePage.search("Black Widow");
        movieResultsPage.firstResult();
    }

    @And("the user selects an actor from the top billed cast")
    public void theUserSelectsAnActorFromTheTopBilledCast() {
        moviePage.searchFirstActor();
    }

    @When("the user checks the actor's acting timeline")
    public void theUserChecksTheActorSActingTimeline() {
        Assert.assertNotNull(actorPage.getTimeline());
    }

    @Then("the title of the movie should be in the timeline")
    public void theTitleOfTheMovieShouldBeInTheTimeline() {
        Assert.assertTrue(actorPage.isMovieName("Black Widow"));
        driver.quit();
    }
}
