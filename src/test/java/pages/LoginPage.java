package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.GetData;

public class LoginPage {
    private WebDriver driver;
    private GetData getData;
    private By username = By.id("username");
    private By password =By.id("password");
    private By loginButton = By.id("login_button");
    private By redMessage = By.className("background_color");
    private By errorMessages = By.className("carton");
    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver, GetData getData){
        this.driver=driver;
        this.getData = getData;
    }

    public void typingValidCredentials(){
        driver.findElement(username).sendKeys(getData.getUser());
        driver.findElement(password).sendKeys(getData.getValidPassword());
        log.debug("Typing valid credentials");
    }
    public void typingInvalidCredentials(){
        driver.findElement(username).sendKeys(getData.getUser());
        driver.findElement(password).sendKeys(getData.getInvalidPassword());
        log.debug("Typing invalid credentials");
    }
    public void clickSearchButton(){
        driver.findElement(loginButton).click();
        log.debug("Click on search button");
    }
    public String redErrorMessage(){
        log.info("Get red Error Messages");
        return driver.findElement(redMessage).getText();
    }
    public String[] getMessages(){
        String messages= driver.findElement(errorMessages).getText();
        log.info("Get more error messages");
        return messages.split("\n");
    }
}
