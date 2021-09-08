package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{
    private By login = By.linkText("Login");
    private By searchBar = By.id("inner_search_v4");
    private By movieOptions = By.linkText("Movies");
    private By topRated = By.linkText("Top Rated");
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickLoginButton(){
        driver.findElement(login).click();
    }
    public void search(String search){
        driver.findElement(searchBar).sendKeys(search+" \n");
    }
    public void movieOptions(){
        driver.findElement(movieOptions).click();
    }
    public void topRated(){
        driver.findElement(topRated).click();
    }
}
