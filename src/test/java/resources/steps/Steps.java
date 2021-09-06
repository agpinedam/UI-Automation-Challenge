package resources.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ReadPropertiesFile;

import java.io.IOException;

public class Steps {
    @Given("the user wants to login")
    public void theUserWantsToLogin() throws IOException {
        ReadPropertiesFile readPropertiesFile =ReadPropertiesFile.getInstance();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(readPropertiesFile.getDomain());
        By login = By.linkText("Login");
        driver.findElement(login).click();
        //driver.quit();
        By username = By.id("username");
        driver.findElement(username).sendKeys(readPropertiesFile.getUser());
        By password =By.id("password");
        driver.findElement(password).sendKeys(readPropertiesFile.getValidPassword());
        By loginButton = By.id("login_button");
        driver.findElement(loginButton).click();
    }

    @When("the user enters the credentials")
    public void theUserEntersTheCredentials() {
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
    }
}
