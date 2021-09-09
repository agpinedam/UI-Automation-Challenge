package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesReader;

public class LoginPage extends BasePage{

    private final PropertiesReader propertiesReader;
    private final By username = By.id("username");
    private final By password =By.id("password");
    private final By loginButton = By.id("login_button");
    private final By redMessage = By.className("background_color");
    private final By errorMessages = By.className("carton");
    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver, PropertiesReader propertiesReader){
        super(driver);
        this.propertiesReader = propertiesReader;
    }

    public void typingValidCredentials(){
        driver.findElement(username).sendKeys(propertiesReader.getUser());
        driver.findElement(password).sendKeys(propertiesReader.getValidPassword());
        log.debug("Typing valid credentials");
    }
    public void typingInvalidCredentials(){
        driver.findElement(username).sendKeys(propertiesReader.getUser());
        driver.findElement(password).sendKeys(propertiesReader.getInvalidPassword());
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
