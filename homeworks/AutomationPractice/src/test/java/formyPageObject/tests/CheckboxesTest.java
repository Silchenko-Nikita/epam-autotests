package formyPageObject.tests;

import formyPageObject.Consts;
import formyPageObject.pages.ButtonsPage;
import formyPageObject.pages.CheckboxesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckboxesTest extends FunctionalTest {
    @DataProvider(name="CheckboxesXpath")
    public Object[] checkboxesXpathProvider() {
        return new Object[] {
                "//input[@id='checkbox-1']",
                "//input[@id='checkbox-2']",
                "//input[@id='checkbox-3']",
        };
    }

    @BeforeMethod
    public static void beforeMethod(){
        driver.get(Consts.FORMY_BASE_URL + "/checkbox");
    }

    @Test(dataProvider="CheckboxesXpath")
    public void clickOnCkecbox(String checkboxXpath) {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        assertTrue(checkboxesPage.isInitialized());

        driver.findElement(By.xpath(checkboxXpath)).click();
    }
}
