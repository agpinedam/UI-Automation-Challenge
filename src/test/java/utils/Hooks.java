package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Hooks {
    protected WebDriver driver;
    protected ReadPropertiesFile readPropertiesFile;
    @BeforeMethod
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
        readPropertiesFile =ReadPropertiesFile.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(readPropertiesFile.getDomain());
    }
}
