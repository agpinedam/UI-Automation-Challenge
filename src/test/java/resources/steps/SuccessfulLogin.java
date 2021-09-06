package resources.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.Hooks;

import java.io.IOException;
import java.util.List;

public class SuccessfulLogin extends Hooks {
    /*
    @Given("the user wants to log in")
    public void theUserWantsToLogIn() throws IOException {
        setup();
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
    }

    @When("the user submits invalid credentials")
    public void theUserSubmitsInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver,readPropertiesFile);
        loginPage.loginInvalidCredentials();
    }

    @Then("the user should see a red error message")
    public void theUserShouldSeeARedErrorMessage() {
        LoginPage loginPage = new LoginPage(driver,readPropertiesFile);
        String redErrorMessage = loginPage.redErrorMessage();
        Assert.assertEquals(redErrorMessage," There was a problem");
    }

    @And("the user should see two more error messages")
    public void theUserShouldSeeTwoMoreErrorMessages() {
        By errorMessages = By.cssSelector(".carton.content");
        List<WebElement> messages= driver.findElements(errorMessages);
        String message1 = messages.get(0).getText();
        System.out.println(message1);
    }
     */
}
