import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static boolean isEmailCorrect(String email) {
        if (email == null) return false;

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!]{3,20}@[a-zA-Z0-9]{2,5}\\.[a-z]{2,5}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}