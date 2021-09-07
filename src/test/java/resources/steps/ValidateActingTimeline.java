package resources.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Hooks;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ValidateActingTimeline extends Hooks {
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
    }
}
