package resources.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import utils.Hooks;

import java.io.IOException;

public class FailedLogin extends Hooks {
    //Test1
    @Given("the user wants to login")
    public void theUserWantsToLogin() throws IOException {
        setup();
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
    }

    @When("the user enters the credentials")
    public void theUserEntersTheCredentials() {
        LoginPage loginPage = new LoginPage(driver,readPropertiesFile);
        loginPage.loginValidCredentials();
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        UserPage userPage = new UserPage(driver,readPropertiesFile);
        Assert.assertEquals(userPage.getUserName(),readPropertiesFile.getUser());
        driver.quit();
    }
}
