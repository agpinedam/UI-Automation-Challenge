package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadPropertiesFile;

public class LoginPage {
    private By username = By.id("username");
    private WebDriver driver;
    private ReadPropertiesFile readPropertiesFile;
    private By password =By.id("password");
    private By loginButton = By.id("login_button");

    public LoginPage(WebDriver driver, ReadPropertiesFile readPropertiesFile){
        this.driver=driver;
        this.readPropertiesFile = readPropertiesFile;
    }

    public void loginValidCredentials(){
        driver.findElement(username).sendKeys(readPropertiesFile.getUser());
        driver.findElement(password).sendKeys(readPropertiesFile.getValidPassword());
        driver.findElement(loginButton).click();
    }
}
