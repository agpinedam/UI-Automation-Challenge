package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Hooks;
import java.io.IOException;

public class SuccessfulSearch  extends Hooks {

    @Given("the user wants to search for a movie")
    public void theUserWantsToSearchForAMovie() throws IOException {
        setup();
    }
    @When("the user enters the title ‘Fight Club’")
    public void theUserEntersTheTitleFightClub() {
        HomePage homePage = new HomePage(driver);
        homePage.search("Fight Club");
    }
    @Then("the user should see the movie as the first result")
    public void theUserShouldSeeTheMovieAsTheFirstResult() {
        //By name =By.id("4bc88fc1017a3c122d009254");
        //System.out.println(driver.findElement(name).getText());
    }

}
