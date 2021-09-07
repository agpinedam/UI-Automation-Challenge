package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopRatedPage {
    private WebDriver driver;
    private By filter = By.className("closed");
    private By action = By.linkText("Action");
    private By searchButton = By.cssSelector("#media_v4 > div > div > div.content > " +
            "div.apply.full.background_color.light_blue.enabled.fixed > p > a");
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
    private void wait(By element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void selectMovie(String name){
        actionMovie = By.linkText(name);
        wait(actionMovie);
        driver.findElement(actionMovie).click();
    }

    public String verifyGenre(){
        return driver.findElement(action).getText();
    }
}