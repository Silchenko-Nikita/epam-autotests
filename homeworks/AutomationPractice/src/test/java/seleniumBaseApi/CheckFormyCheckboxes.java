package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CheckFormyCheckboxes {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_BASE_URL + "/checkbox");
    }

    @DataProvider(name="CheckboxesCss")
    public Object[] checkboxesCssProvider() {
        return driver.findElements(By.className("input[type=\"checkbox\"]")).toArray();
    }

    @DataProvider(name="CheckboxesXpath")
    public Object[] checkboxesXpathProvider() {
        return driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).toArray();
    }

    @Test(dataProvider = "CheckboxesCss")
    public void clickOnCheckboxCss(WebElement checkbox) {
        checkbox.click();
    }

    @Test(dataProvider = "CheckboxesXpath")
    public void clickOnCheckboxXpath(WebElement checkbox) {
        checkbox.click();
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }
}
