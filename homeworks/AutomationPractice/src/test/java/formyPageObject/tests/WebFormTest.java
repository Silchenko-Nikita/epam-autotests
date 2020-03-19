package formyPageObject.tests;

import formyPageObject.Consts;
import formyPageObject.pages.ThanksForSubmitPage;
import formyPageObject.pages.WebFormPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebFormTest extends FunctionalTest {
    private static String SUBMIT_EXPECTED_HEADER = "Thanks for submitting your form";

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
    public void fillAndSubmitForm(String firstName, String lastName, String jobTitle,
                                  String educationLevelRadiobuttonId, String sexCheckboxId,
                                  String levelOfExperience, String date) {
        WebFormPage webFormPage = new WebFormPage(driver);
        assertTrue(webFormPage.isInitialized());

        webFormPage.enterFullName(firstName, lastName);
        webFormPage.enterJobData(jobTitle, levelOfExperience);
        webFormPage.enterDate(date);

        driver.findElement(By.id(educationLevelRadiobuttonId)).click();
        driver.findElement(By.id(sexCheckboxId)).click();

        ThanksForSubmitPage thanksForSubmitPage = webFormPage.submit();
        assertTrue(thanksForSubmitPage.isInitialized());

        assertEquals(thanksForSubmitPage.confirmationHeader(), SUBMIT_EXPECTED_HEADER,
                "Headline text on thanking for form submission page doesn't equal expected one");
    }
}
