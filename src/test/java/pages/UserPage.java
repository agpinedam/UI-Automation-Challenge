package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.GetData;

public class UserPage {
    private final WebDriver driver;
    private final GetData getData;
    private final Logger log = LoggerFactory.getLogger(UserPage.class);

    public UserPage(WebDriver driver, GetData getData){
        this.driver=driver;
        this.getData = getData;
    }

    public String getUserName(){
        By userName = By.linkText(getData.getUser());
        log.info("Compare the user name");
        return driver.findElement(userName).getText();
    }
}
