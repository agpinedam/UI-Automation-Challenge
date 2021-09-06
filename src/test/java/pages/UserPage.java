package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ReadPropertiesFile;

public class UserPage {
    private By userName;
    private WebDriver driver;
    private ReadPropertiesFile readPropertiesFile;


    public UserPage(WebDriver driver, ReadPropertiesFile readPropertiesFile){
        this.driver=driver;
        this.readPropertiesFile = readPropertiesFile;
    }

    public String getUserName(){
        userName= By.linkText(readPropertiesFile.getUser());
        String user = driver.findElement(userName).getText();
        return user;
    }
}
