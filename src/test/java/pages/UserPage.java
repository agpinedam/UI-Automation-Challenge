package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadPropertiesFile;

public class UserPage {
    private final WebDriver driver;
    private final ReadPropertiesFile readPropertiesFile;

    public UserPage(WebDriver driver, ReadPropertiesFile readPropertiesFile){
        this.driver=driver;
        this.readPropertiesFile = readPropertiesFile;
    }

    public String getUserName(){
        By userName = By.linkText(readPropertiesFile.getUser());
        return driver.findElement(userName).getText();
    }
}
