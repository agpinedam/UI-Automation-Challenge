package resources.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.hooks.InitialHook;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ValidateActingTimeline extends InitialHook {
    @Given("the user selects a movie with actors \\({string})")
    public void theUserSelectsAMovieWithActors(String movieName) throws IOException {
        setup();
        homePage.search(movieName);
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

    @Then("the title of the movie {string} should be in the timeline")
    public void theTitleOfTheMovieShouldBeInTheTimeline(String movieName) {
        String productions = actorPage.getProductionsList();
        assertThat(productions,containsString(movieName));
        driver.quit();
    }
}
