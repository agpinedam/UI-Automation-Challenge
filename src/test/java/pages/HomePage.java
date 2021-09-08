package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage{
    private final By login = By.linkText("Login");
    private final By searchBar = By.id("inner_search_v4");
    private final By movieOptions = By.linkText("Movies");
    private final By topRated = By.linkText("Top Rated");
    private final WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickLoginButton(){
        driver.findElement(login).click();
        log.debug("Click on Login Button");
    }
    public void search(String search){
        driver.findElement(searchBar).sendKeys(search+" \n");
        log.debug("Typing and search");
    }
    public void movieOptions(){
        driver.findElement(movieOptions).click();
        log.debug("See Dropdown movie options");
    }
    public void topRated(){
        driver.findElement(topRated).click();
        log.debug("Click on Top Rated");
    }
}
