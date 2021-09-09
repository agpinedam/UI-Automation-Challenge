package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ActorPage extends BasePage{

    private final By timeline = By.className("credits_list");
    private final Logger log = LoggerFactory.getLogger(ActorPage.class);

    public ActorPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getTimeline(){
        log.debug("Get Acting Timeline");
        return driver.findElements(timeline);
    }

    public String getProductionsList(){
        StringBuilder productionsList = new StringBuilder();
        List<WebElement> elements = getTimeline();
        String response = elements.get(0).getText();
        String[] splitResponse = response.split("\n");
        for(int i=2;i<splitResponse.length;i+=2){
            productionsList.append(splitResponse[i]).append("\n");
        }
        return productionsList.toString();
    }
}
