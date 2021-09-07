package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class TopRatedPage {
    private WebDriver driver;
    private By filter = By.className("closed");
    private By action = By.linkText("Action");
    private By searchButton = By.xpath("//*[@id=\"media_v4\"]/div/div/div[2]/div[3]/p/a");
    private By actionMovie;

    public TopRatedPage(WebDriver driver){
        this.driver = driver;
    }
    public void filterOptions(){
        driver.findElement(filter).click();
    }
    public void actionFilter(){
        driver.findElement(action).click();
    }
    public void applyFilter(){
        driver.findElement(searchButton).click();
    }
    public void selectMovie(String movie){
        actionMovie = By.linkText(movie);
        wait(actionMovie);
        driver.findElement(actionMovie).click();
    }
    private void wait(By element){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public String verifyGenre(){
        return driver.findElement(action).getText();
    }
}
