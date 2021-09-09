package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoviePage {
    private By name = By.cssSelector("#cast_scroller > ol > li:nth-child(1) > p:nth-child(2) > a");;
    private WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(MoviePage.class);

    public MoviePage (WebDriver driver){
        this.driver = driver;
    }
    public void searchFirstActor(){
        driver.findElement(name).click();
        log.debug("Select the first actor from the top billed cast");
    }
}
