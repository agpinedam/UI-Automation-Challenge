package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MovieResultsPage {
    private By name =By.cssSelector(".wrapper > div > div > a > h2");
    private By firstMovie;
    private WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MovieResultsPage.class);

    public MovieResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String firstNameResult(){
        log.info("Get the movie name of the first result");
        return driver.findElement(name).getText();
    }

    public void firstResult(){
        log.debug("Click on the first movie result");
        driver.findElement(name).click();
    }

}
