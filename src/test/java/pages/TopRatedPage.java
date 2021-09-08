package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ChangeDateFormat;

import java.util.Date;
import java.text.ParseException;


public class TopRatedPage {
    private WebDriver driver;
    private By filter = By.className("closed");
    private By action = By.linkText("Action");
    private By searchButton = By.linkText("Search");
    private By actionMovie;
    private By sortOptions = By.cssSelector(".filter > span > span > span.k-select");
    private By ascendingOrder = By.cssSelector("#sort_by_listbox > li:nth-child(6)");
    private By page = By.cssSelector("#page_1");
    private By firstMovie = By.linkText("The Arrival of a Train at La Ciotat");

    public TopRatedPage(WebDriver driver){
        this.driver = driver;
    }
    public void filterOptions(){
        driver.findElement(filter).click();
    }
    public void actionFilter(){
        driver.findElement(action).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600)", "");
    }

    public void applyFilter(){
        wait(searchButton);
        driver.findElement(searchButton).click();
    }
    private void wait(By element){
        WebDriverWait wait = new WebDriverWait(driver,3);
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

    public void sortOptions(){
        driver.findElement(sortOptions).click();
    }
    public void sortByAscendingOrder(){
        wait(ascendingOrder);
        driver.findElement(ascendingOrder).click();
    }
    public Date[] getMovieDates(int arg) throws ParseException {
        wait(firstMovie);
        String[] response = driver.findElements(page).get(0).getText().split("\n");
        ChangeDateFormat changeFormat = new ChangeDateFormat();
        Date[] dates= new Date[arg];
        for(int i = 1; i< arg*2;i+=2){
            String date = response[i];
            Date date1 = changeFormat.date(date);
            dates[i/2] = date1;
        }
        return dates;
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(dates.get(0));
        Date date2 = sdf.parse(dates.get(1));

        System.out.println("date1 : " + date1);
        System.out.println("date2 : " + date2);

        int result = date1.compareTo(date2);
        System.out.println("result: " + result);

        if (result == 0) {
            System.out.println("Date1 is equal to Date2");
        } else if (result > 0) {
            System.out.println("Date1 is after Date2");
        } else {
            System.out.println("Date1 is before Date2");
        }
         */
    }
}