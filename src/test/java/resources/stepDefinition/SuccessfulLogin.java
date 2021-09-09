package resources.stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.hooks.InitialHook;

import java.io.IOException;


public class SuccessfulLogin extends InitialHook {

    @Given("the user wants to login")
    public void theUserWantsToLogin() throws IOException {
        setup();
        homePage.menuComponent.clickLoginButton();
    }

    @When("the user enters the credentials")
    public void theUserEntersTheCredentials() {
        loginPage.typingValidCredentials();
        loginPage.clickSearchButton();
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        Assert.assertEquals(userPage.getUserName(), propertiesReader.getUser());
        driver.quit();
    }
}
