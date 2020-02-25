package variant3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {
    static WebElement getLastWebElementOfMatched(WebDriver driver, By by) {
        List<WebElement> webElements = driver.findElements(by);
        return webElements.get(webElements.size() - 1);
    }
}
