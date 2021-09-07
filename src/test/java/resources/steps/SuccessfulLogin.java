package resources.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.Hooks;

import java.io.IOException;

public class SuccessfulLogin extends Hooks {

    @Given("the user wants to login")
    public void theUserWantsToLogin() throws IOException {
        setup();
        homePage.clickLoginButton();
    }

    @When("the user enters the credentials")
    public void theUserEntersTheCredentials() {
        loginPage.loginValidCredentials();
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        Assert.assertEquals(userPage.getUserName(),readPropertiesFile.getUser());
        driver.quit();
    }
}
