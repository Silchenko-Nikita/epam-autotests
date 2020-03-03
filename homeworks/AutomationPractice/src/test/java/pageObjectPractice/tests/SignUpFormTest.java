package pageObjectPractice.tests;

import org.testng.annotations.Test;
import pageObjectPractice.pages.ReceiptPage;
import pageObjectPractice.pages.SignUpPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpFormTest extends FunctionalTest {

    @Test
    public void signUp(){
        driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");

        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInitialized());

        signUpPage.enterName("First", "Last");
        signUpPage.enterAddress("123 Street", "12345");

        ReceiptPage receiptPage = signUpPage.submit();
        assertTrue(receiptPage.isInitialized());

        assertEquals("Thank you!", receiptPage.confirmationHeader());
    }
}
