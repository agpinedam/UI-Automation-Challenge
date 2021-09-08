package resources.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;
import utils.GetData;

import java.io.IOException;

public class InitialHook {
    protected    WebDriver driver;
    protected GetData getData;
    protected HomePage homePage;
    protected TopRatedPage topRatedPage;
    protected LoginPage loginPage;
    protected UserPage userPage;
    protected MovieResultsPage movieResultsPage;
    protected MoviePage moviePage;
    protected ActorPage actorPage;

    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
        getData = GetData.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(getData.getDomain());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver, getData);
        userPage = new UserPage(driver, getData);
        movieResultsPage= new MovieResultsPage(driver);
        topRatedPage = new TopRatedPage(driver);
        moviePage = new MoviePage(driver);
        actorPage = new ActorPage(driver);
    }
}
