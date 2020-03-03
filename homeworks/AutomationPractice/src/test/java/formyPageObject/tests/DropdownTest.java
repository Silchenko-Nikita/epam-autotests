package formyPageObject.tests;

import formyPageObject.Consts;
import formyPageObject.pages.ButtonsPage;
import formyPageObject.pages.DropdownPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DropdownTest extends FunctionalTest {
    @DataProvider(name="DropdownItemsXpath")
    public Object[] dropdownItemsXpathProvider() {
        return new Object[] {
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][1]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][2]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][3]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][4]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][5]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][6]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][7]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][8]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][9]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][10]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][11]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][12]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][13]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][14]",
                "//div[@class='dropdown-menu show']/a[@class='dropdown-item'][15]",
        };
    }

    @BeforeMethod
    public static void beforeMethod(){
        driver.get(Consts.FORMY_BASE_URL + "/dropdown");
    }

    @Test(dataProvider="DropdownItemsXpath")
    public void clickOnDropdownItem(String dropdownItemXpath) {
        DropdownPage dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.isInitialized());

        dropdownPage.openDropdown();
        driver.findElement(By.xpath(dropdownItemXpath)).click();
    }
}
