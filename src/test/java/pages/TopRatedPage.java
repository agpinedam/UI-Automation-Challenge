package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ChangeDateFormat;

import java.util.Date;
import java.text.ParseException;


public class TopRatedPage {
    private final WebDriver driver;
    private final By filter = By.className("closed");
    private final By searchButton = By.linkText("Search");
    private final By sortOptions = By.cssSelector(".filter > span > span > span.k-select");
    private final By ascendingOrder = By.cssSelector("#sort_by_listbox > li:nth-child(6)");
    private final By page = By.cssSelector("#page_1");
    private final By firstMovie = By.linkText("The Arrival of a Train at La Ciotat");
    private final Logger log = LoggerFactory.getLogger(TopRatedPage.class);
    private  By genreFilter;

    public TopRatedPage(WebDriver driver){
        this.driver = driver;
    }

    public void filterOptions(){
        driver.findElement(filter).click();
        log.debug("Deploy filter options");
    }
    public void genreFilter(String filter){
        genreFilter = By.linkText("Action");
        driver.findElement(genreFilter).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600)", "");
        log.debug("Select action filter");
    }

    public void clickOnSearch(){
        wait(searchButton);
        driver.findElement(searchButton).click();
        log.debug("Click on Search Button");
    }
    private void wait(By element){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.debug("Wait for elements");
    }
    public void selectMovie(String name){
        By actionMovie = By.linkText(name);
        wait(actionMovie);
        driver.findElement(actionMovie).click();
        log.debug("Select a movie");
    }

    public String verifyGenre(String filter){
        genreFilter = By.linkText("Action");
        log.info("Verify the movie genre");
        return driver.findElement(genreFilter).getText();
    }

    public void sortOptions(){
        log.info("Deploy sort options");
        driver.findElement(sortOptions).click();
    }
    public void sortByAscendingOrder(){
        wait(ascendingOrder);
        driver.findElement(ascendingOrder).click();
        log.debug("Sort by ascending order");
    }
    public Date[] getMovieDates(int arg) throws ParseException {
        wait(firstMovie);
        String[] response = driver.findElements(page).get(0).getText().split("\n");
        log.info("Get movie dates");
        return changeDateFormat(arg,response);
    }

    private Date[] changeDateFormat(int arg, String[] response) throws ParseException {
        ChangeDateFormat changeFormat = new ChangeDateFormat();
        Date[] dates= new Date[arg];
        for(int i = 1; i< arg*2;i+=2){
            String date = response[i];
            Date date1 = changeFormat.date(date);
            dates[i/2] = date1;
        }
        return dates;
    }
}