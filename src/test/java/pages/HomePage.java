package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.componets.MenuComponent;

public class HomePage extends BasePage{

    private final By searchBar = By.id("inner_search_v4");
    private final Logger log = LoggerFactory.getLogger(HomePage.class);
    public MenuComponent menuComponent;

    public HomePage(WebDriver driver){
        super(driver);
        menuComponent = new MenuComponent(driver);
    }

    public void search(String search){
        driver.findElement(searchBar).sendKeys(search+" \n");
        log.debug("Typing and search");
    }

}
