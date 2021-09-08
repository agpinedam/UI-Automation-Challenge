package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class ActorPage {

    private final WebDriver driver;
    private final By timeline = By.cssSelector(".credits_list > table:nth-child(2) > tbody");
    private final Logger log = LoggerFactory.getLogger(ActorPage.class);

    public ActorPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getTimeline(){
        log.debug("Get Acting Timeline");
        return driver.findElements(timeline);
    }

    public Boolean isMovieName(String movieName) {
        By movie = By.linkText(movieName);
        String nameMovie = driver.findElement(movie).getText();
        log.info("The movie is in the Timeline");
        return nameMovie.equals(movieName);
    }
}
