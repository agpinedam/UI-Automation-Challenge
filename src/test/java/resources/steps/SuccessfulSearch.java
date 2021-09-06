package resources.steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MovieResults;
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
        MovieResults movieResults = new MovieResults(driver,readPropertiesFile);
        Assert.assertEquals(movieResults.firstResult(),"Fight Club");
        driver.close();
    }
}
