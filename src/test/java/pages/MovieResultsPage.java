package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MovieResultsPage {
    private final By name =By.cssSelector(".wrapper > div > div > a > h2");
    private final WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MovieResultsPage.class);

    public MovieResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String firstNameResult(){
        log.info("Get the name of the first movie result");
        return driver.findElement(name).getText();
    }

    public void firstResult(){
        log.debug("Click on the first movie result");
        driver.findElement(name).click();
    }

}
