import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailHappyPath {
    @DataProvider(name="EmailsForHappyPath")
    public static Object[] happyPathEmails() {
        return new Object[] {
                "Rag@Ma.ru",
                "!_123456789012345678@23213.adddd",
        };
    }

    @Test(dataProvider="EmailsForHappyPath")
    public void testEmailFormatHappyPath(String email) {
        boolean actualResult = Email.isEmailCorrect(email);
        Assert.assertTrue(actualResult,"Email format is not correct: " + email);
    }
}
