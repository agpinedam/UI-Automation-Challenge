package pages.componets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuComponent extends BasePage {
    private final By login = By.linkText("Login");
    private final By topRated = By.linkText("Top Rated");
    private final By movieOptions = By.linkText("Movies");
    private final Logger log = LoggerFactory.getLogger(MenuComponent.class);

    public MenuComponent(WebDriver driver) {
        super(driver);
    }
    public void movieOptions(){
        driver.findElement(movieOptions).click();
        log.debug("See Dropdown movie options");
    }
    public void topRated(){
        driver.findElement(topRated).click();
        log.debug("Click on Top Rated");
    }
    public void clickLoginButton(){
        driver.findElement(login).click();
        log.debug("Click on Login Button");
    }
}
