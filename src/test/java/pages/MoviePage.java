package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoviePage extends BasePage{
    private By name = By.cssSelector("#cast_scroller .card");
    private final Logger log = LoggerFactory.getLogger(MoviePage.class);

    public MoviePage (WebDriver driver){
        super(driver);
    }
    public void searchFirstActor(){
        driver.findElement(name).click();
        log.debug("Select the first actor from the top billed cast");
    }
}
