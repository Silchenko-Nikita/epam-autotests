package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CheckFormyCheckboxes {

    @Test
    public void clickOnAllCheckboxesCss() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_URL + "/checkbox");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }

    @Test
    public void clickOnAllCheckboxesXpath() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_URL + "/checkbox");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
