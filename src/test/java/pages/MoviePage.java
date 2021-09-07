package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MoviePage {
    private By name;
    private WebDriver driver;

    public MoviePage (WebDriver driver){
        this.driver = driver;
    }
    public void searchFirstActor(){
        name = By.cssSelector("#cast_scroller > ol > li:nth-child(1) > p:nth-child(2) > a");
        driver.findElement(name).click();
    }
}
