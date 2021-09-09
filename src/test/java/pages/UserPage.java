package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesReader;

public class UserPage extends BasePage{
    private final PropertiesReader propertiesReader;
    private final Logger log = LoggerFactory.getLogger(UserPage.class);

    public UserPage(WebDriver driver, PropertiesReader propertiesReader){
        super(driver);
        this.propertiesReader = propertiesReader;
    }

    public String getUserName(){
        By userName = By.linkText(propertiesReader.getUser());
        log.info("Compare the user name");
        return driver.findElement(userName).getText();
    }
}
