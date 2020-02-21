import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {
    @DataProvider(name="EmailsForUnhappyPath")
    public static Object[] unhappyPathEmails() {
        return new Object[] {   "nikitiuss~/@gmail.com",
                "a@2.sdf",
                "!_1234567890123456789@23213.adddd",
                "unHAPPY_EMAIL@CO2Mcom",
                "dD3_!@!fA8.dd",
                "dD3_!@fA8.dddddd",
                null,
                "   ",
                "\tRag@mail.ru"};
    }

    @Test(dataProvider="EmailsForUnhappyPath")
    public void testEmailFormatUnhappyPath(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertFalse(actualResult, "Email format is correct: "  + email);
    }
}

