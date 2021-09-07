package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.io.IOException;

public class Hooks {
    protected WebDriver driver;
    protected ReadPropertiesFile readPropertiesFile;
    protected HomePage homePage;
    protected TopRatedPage topRatedPage;
    protected LoginPage loginPage;
    protected UserPage userPage;
    protected MovieResultsPage movieResultsPage;
    protected MoviePage moviePage;
    protected ActorPage actorPage;
    @BeforeMethod
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
        readPropertiesFile =ReadPropertiesFile.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(readPropertiesFile.getDomain());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver,readPropertiesFile);
        userPage = new UserPage(driver,readPropertiesFile);
        movieResultsPage= new MovieResultsPage(driver);
        topRatedPage = new TopRatedPage(driver);
        moviePage = new MoviePage(driver);
        actorPage = new ActorPage(driver);
    }
}
