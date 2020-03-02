package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class CheckFormyDropdownMenu {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(Consts.FORMY_BASE_URL + "/dropdown");
    }


    @DataProvider(name="DropdownItems")
    public Object[] dropdownsLinksElementsProvider() {
       return new Object[] {
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(1)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(2)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(3)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(4)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(5)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(6)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(7)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(8)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(9)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(10)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(11)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(12)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(13)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(14)",
                "#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(15)",
       };
    }

    @Test(dataProvider="DropdownItems")
    public void verifyRedirectionLinkMatchOneSpecified(String dropdownItemCss) {
        driver.findElement(By.id("dropdownMenuButton")).click();

        WebElement dropdownItem = driver.findElement(By.cssSelector(dropdownItemCss));
        String href = dropdownItem.getAttribute("href");

        dropdownItem.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(href, url,
                "Redirection url doesn't equals reference (href=\"" + href + "\", url=\"" + url + "\")");

    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }
}
