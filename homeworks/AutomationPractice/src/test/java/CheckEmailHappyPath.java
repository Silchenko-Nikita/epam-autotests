import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Email;

public class CheckEmailHappyPath {
    @DataProvider(name="Emails")
    public static Object[] credentials() {
        return new Object[] {   "nikitiuss@gmail.com",
                                "rag@mail.ru",
                                "pivo21@23.adddd",
                                "!_123456789012345678@23213.adddd",
                                "HAPPY_EMAIL@CO2M.com",
                                "dD3_!@fA8.dd"};
    }

    @Test(dataProvider="Emails")
    public void test(String emailStr) {
        Assert.assertTrue(Email.isEmailCorrect(emailStr));
    }
}
