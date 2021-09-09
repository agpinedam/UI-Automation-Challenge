package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ChangeDateFormat;

import java.util.Date;
import java.text.ParseException;


public class TopRatedPage extends BasePage {

    private final By filter = By.className("closed");
    private final By searchButton = By.linkText("Search");
    private final By sortOptions = By.cssSelector(".name .chevron-right");
    private final By ascendingOrder = By.xpath("//*[@id='sort_by_listbox']//li[contains (text(),'Release Date Ascending')]");
    private final By page = By.cssSelector("#page_1");
    private final By firstMovie = By.linkText("The Arrival of a Train at La Ciotat");
    private final By deploySortList = By.xpath("//span[@role ='listbox']");
    private final Logger log = LoggerFactory.getLogger(TopRatedPage.class);
    private  By genreFilter;

    public TopRatedPage(WebDriver driver){
        super(driver);
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
        driver.findElement(deploySortList).click();
        driver.findElement(ascendingOrder).click();
        log.debug("Sort by ascending order");
    }
    public Date[] getMovieDates(int arg) {
        wait(firstMovie);
        String[] response = driver.findElements(page).get(0).getText().split("\n");
        log.info("Get movie dates");
        return changeDateFormat(arg,response);
    }

    private Date[] changeDateFormat(int arg, String[] response) {
        ChangeDateFormat changeFormat = new ChangeDateFormat();
        Date[] dates= new Date[arg];
        try {
            for (int i = 1; i < arg * 2; i += 2) {
                String date = response[i];
                Date date1 = changeFormat.date(date);
                dates[i / 2] = date1;
            }
        }catch (ParseException e){
            log.error(e.getMessage());
        }
        return dates;
    }
}