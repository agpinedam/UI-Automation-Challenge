package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MovieResultsPage extends BasePage{
    private final By name =By.cssSelector(".title .result");
    private final Logger log = LoggerFactory.getLogger(MovieResultsPage.class);

    public MovieResultsPage(WebDriver driver){
        super(driver);
    }

    public String firstNameResult(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(name));
        log.info("Get the name of the first movie result");
        return driver.findElement(name).getText();
    }

    public void firstResult(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(name));
        log.debug("Click on the first movie result");
        driver.findElement(name).click();
    }

}
