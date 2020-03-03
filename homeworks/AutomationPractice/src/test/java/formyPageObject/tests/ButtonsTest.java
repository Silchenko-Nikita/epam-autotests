package formyPageObject.tests;

import formyPageObject.Consts;
import formyPageObject.pages.ButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class ButtonsTest extends FunctionalTest {

    @DataProvider(name="ButtonsXpath")
    public Object[] buttonsXpathProvider() {
        return new Object[] {
                "//div[@class='col-sm-8']/button[@type='button'][1]",
                "//div[@class='col-sm-8']/button[@type='button'][2]",
                "//div[@class='col-sm-8']/button[@type='button'][3]",
                "//div[@class='col-sm-8']/button[@type='button'][4]",
                "//div[@class='col-sm-8']/button[@type='button'][5]",
                "//div[@class='col-sm-8']/button[@type='button'][6]",
                "//div[@aria-label='Basic example']/button[@type='button'][1]",
                "//div[@aria-label='Basic example']/button[@type='button'][2]",
                "//div[@aria-label='Basic example']/button[@type='button'][3]",
                "//div[@aria-label='Button group with nested dropdown']/button[@type='button'][1]",
                "//div[@aria-label='Button group with nested dropdown']/button[@type='button'][2]",
                "//button[@id='btnGroupDrop1']",
        };
    }

    @BeforeMethod
    public static void beforeMethod(){
        driver.get(Consts.FORMY_BASE_URL + "/buttons");
    }

    @DataProvider(name="DropdownLinksXpath")
    public Object[] linksXpathProvider() {
        return new Object[] {
                "//div[@aria-labelledby='btnGroupDrop1']/a[@class='dropdown-item'][1]",
                "//div[@aria-labelledby='btnGroupDrop1']/a[@class='dropdown-item'][2]",
        };
    }

    @Test(dataProvider="ButtonsXpath")
    public void clickOnButton(String buttonXpath) {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        assertTrue(buttonsPage.isInitialized());

        driver.findElement(By.xpath(buttonXpath)).click();
    }

    @Test(dataProvider="DropdownLinksXpath")
    public void clickOnDropdownLink(String linkXpath) {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        assertTrue(buttonsPage.isInitialized());

        buttonsPage.openDropdown();
        driver.findElement(By.xpath(linkXpath)).click();
    }
}
