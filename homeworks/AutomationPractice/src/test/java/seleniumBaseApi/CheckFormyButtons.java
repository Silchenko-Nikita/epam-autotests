package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class CheckFormyButtons {

    @Test
    public void clickOnAllButtons() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_URL + "/buttons");

        List<WebElement> buttons = driver.findElements(By.className("btn"));
        for (WebElement button : buttons) {
            button.click();
        }
    }
}
