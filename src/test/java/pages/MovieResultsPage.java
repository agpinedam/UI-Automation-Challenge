package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReadPropertiesFile;

public class MovieResultsPage {
    private By name =By.linkText("Fight Club");
    private WebDriver driver;

    public MovieResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String firstResult(){
        return driver.findElement(name).getText();
    }
}
