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

public class FailedLogin extends InitialHook {
    @Given("the user wants to log in")
    public void theUserWantsToLogIn() throws IOException {
        setup();
        homePage.menuComponent.clickLoginButton();
    }

    @When("the user submits invalid credentials")
    public void theUserSubmitsInvalidCredentials() {
        loginPage.typingInvalidCredentials();
        loginPage.clickSearchButton();
    }

    @Then("the user should see a red error message")
    public void theUserShouldSeeARedErrorMessage() {
        String redErrorMessage = loginPage.redErrorMessage();
        Assert.assertEquals(redErrorMessage," There was a problem");
    }

    @And("the user should see two more error messages")
    public void theUserShouldSeeTwoMoreErrorMessages() {
        String [] splitMessages = loginPage.getMessages();
        Assert.assertEquals(splitMessages[1],"We couldn't validate your information. Want to try again?");
        assertThat(splitMessages[2],containsString("You have"));
        driver.quit();
    }
}
