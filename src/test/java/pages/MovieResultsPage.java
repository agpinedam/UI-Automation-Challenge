package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MovieResultsPage {
    private By name =By.cssSelector("#main > section > div > div > div.white_column > section > " +
            "div.search_results.movie > div > div > div > div.details > div.wrapper > div > div > a > h2");
    private By firstMovie;
    private WebDriver driver;

    public MovieResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String firstNameResult(){
        return driver.findElement(name).getText();
    }

    public void firstResult(){
        driver.findElement(name).click();
    }

}
