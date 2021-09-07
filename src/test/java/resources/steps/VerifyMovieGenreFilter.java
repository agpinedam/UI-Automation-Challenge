package resources.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.TopRatedPage;
import utils.Hooks;

import java.io.IOException;

public class VerifyMovieGenreFilter extends Hooks {
    @Given("the user wants to see the top-rated movies")
    public void theUserWantsToSeeTheTopRatedMovies() throws IOException {
        setup();
        HomePage homePage = new HomePage(driver);
        homePage.movieOptions();
        homePage.topRated();
    }

    @And("the user wants to filter for ‘action’ movies")
    public void theUserWantsToFilterForActionMovies() {
        TopRatedPage topRatedPage = new TopRatedPage(driver);
        topRatedPage.filterOptions();
    }

    @When("the user applies the ‘action’ filter")
    public void theUserAppliesTheActionFilter() {
        TopRatedPage topRatedPage = new TopRatedPage(driver);
        topRatedPage.actionFilter();
        topRatedPage.applyFilter();
    }

    @And("the user selects any movie")
    public void theUserSelectsAnyMovie() {
        TopRatedPage topRatedPage = new TopRatedPage(driver);
        topRatedPage.selectMovie("My Hero Academia: Heroes Rising");
    }

    @Then("the user should see the genre of the movie includes action")
    public void theUserShouldSeeTheGenreOfTheMovieIncludesAction() {
        TopRatedPage topRatedPage = new TopRatedPage(driver);
        Assert.assertEquals(topRatedPage.verifyGenre(),"Action");
    }
}
