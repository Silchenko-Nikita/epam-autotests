package formyPageObject.tests;

import formyPageObject.Consts;
import formyPageObject.pages.DropdownPage;
import formyPageObject.pages.ThanksForSubmitPage;
import formyPageObject.pages.WebFormPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectPractice.pages.ReceiptPage;
import pageObjectPractice.pages.SignUpPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebFormTest extends FunctionalTest {
    @DataProvider(name="FormData")
    public Object[][] formDataProvider() {
        return new Object[][] {
                {"Nick", "S", "Tester", "radio-button-1", "checkbox-1", "0-1", "03/03/2020"},
                {"DSA", "DASsda", "EWW", "radio-button-3", "checkbox-2", "2-4", "01/03/2020"},
                {"ADS", "das", "ADS", "radio-button-2", "checkbox-3", "10+", "01/02/2020"},
        };
    }

    @BeforeMethod
    public static void beforeMethod(){
        driver.get(Consts.FORMY_BASE_URL + "/form");
    }

    @Test(dataProvider="FormData")
    public void fillAndSubmitForm(String[] data) {
        WebFormPage webFormPage = new WebFormPage(driver);
        assertTrue(webFormPage.isInitialized());

        webFormPage.enterName(data[0], data[1]);
        webFormPage.enterJobData(data[2], data[5]);
        webFormPage.enterDate(data[6]);

        driver.findElement(By.id(data[3])).click();
        driver.findElement(By.id(data[4])).click();

        ThanksForSubmitPage thanksForSubmitPage = webFormPage.submit();
        assertTrue(thanksForSubmitPage.isInitialized());

        assertEquals(thanksForSubmitPage.confirmationHeader(), "Thanks for submitting your form",
                "Headline text on thanking for form submission page doesn't equal expected one");
    }
}
