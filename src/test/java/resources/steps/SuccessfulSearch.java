package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.MovieResultsPage;
import utils.Hooks;
import java.io.IOException;

public class SuccessfulSearch  extends Hooks {

    @Given("the user wants to search for a movie")
    public void theUserWantsToSearchForAMovie() throws IOException {
        setup();
    }
    @When("the user enters the title Fight Club")
    public void theUserEntersTheTitleFightClub() {
        HomePage homePage = new HomePage(driver);
        homePage.search("Fight Club");
    }
    @Then("the user should see the movie as the first result")
    public void theUserShouldSeeTheMovieAsTheFirstResult() {
        MovieResultsPage movieResultsPage = new MovieResultsPage(driver);
        Assert.assertEquals(movieResultsPage.firstResult(),"Fight Club");
        driver.close();
    }
}
