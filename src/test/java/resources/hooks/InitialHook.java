package resources.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.PropertiesReader;

import java.io.IOException;

public class InitialHook {
    protected    WebDriver driver;
    protected PropertiesReader propertiesReader;
    protected HomePage homePage;
    protected TopRatedPage topRatedPage;
    protected LoginPage loginPage;
    protected UserPage userPage;
    protected MovieResultsPage movieResultsPage;
    protected MoviePage moviePage;
    protected ActorPage actorPage;

    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
        propertiesReader = PropertiesReader.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(propertiesReader.getDomain());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver, propertiesReader);
        userPage = new UserPage(driver, propertiesReader);
        movieResultsPage= new MovieResultsPage(driver);
        topRatedPage = new TopRatedPage(driver);
        moviePage = new MoviePage(driver);
        actorPage = new ActorPage(driver);
    }
}
