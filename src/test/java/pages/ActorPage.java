package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Hooks;

import java.util.List;

public class ActorPage extends Hooks {

    private WebDriver driver;
    private By timeline = By.cssSelector(".credits_list > table:nth-child(2) > tbody");

    public ActorPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getTimeline(){
        return driver.findElements(timeline);
    }

    public Boolean isMovieName(String movieName){
        By movie = By.linkText(movieName);
        String nameMovie = driver.findElement(movie).getText();
        if(nameMovie.equals(movieName)){
            return true;
        }else {return false;}
    }


}
