import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Email;

public class CheckEmailUnhappyPath {
    @DataProvider(name="Emails")
    public static Object[] credentials() {
        return new Object[] {   "nikitiuss~/@gmail.com",
                "a@2.sdf",
                "pivo21@23.3",
                "!_1234567890123456789@23213.adddd",
                "unHAPPY_EMAIL@CO2Mcom",
                "dD3_!@!fA8.dd",
                "dD3_!@fA8.dddddd"};
    }

    @Test(dataProvider="Emails")
    public void test(String emailStr) {
        Assert.assertFalse(Email.isEmailCorrect(emailStr));
    }
}

