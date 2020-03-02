package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckFormyButtons {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_BASE_URL + "/buttons");
    }

    @DataProvider(name="Buttons")
    public Object[] buttonsElementsProvider() {
        return driver.findElements(By.className("btn")).subList(0, 11).toArray();
    }

    @DataProvider(name="DropdownLinks")
    public Object[] dropdownLinksElementsProvider() {
        return driver.findElements(By.xpath("//a[starts-with(text(),'Dropdown link')]")).subList(0, 2).toArray();
    }

    @Test(dataProvider="Buttons")
    public void clickOnButton(WebElement button) {
        button.click();
    }

    @Test(dataProvider="DropdownLinks")
    public void clickOnDropdownLink(WebElement link) {
        driver.findElement(By.id("btnGroupDrop1")).click();
        link.click();
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }

}
