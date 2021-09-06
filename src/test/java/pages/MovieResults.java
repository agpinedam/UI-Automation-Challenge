package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadPropertiesFile;

public class MovieResults {
    private By name =By.tagName("h2");
    private WebDriver driver;
    private ReadPropertiesFile readPropertiesFile;

    public MovieResults(WebDriver driver,ReadPropertiesFile readPropertiesFile){
        this.driver = driver;
        this.readPropertiesFile = readPropertiesFile;
    }

    public String firstResult(){
        return driver.findElement(name).getText();
    }
}
