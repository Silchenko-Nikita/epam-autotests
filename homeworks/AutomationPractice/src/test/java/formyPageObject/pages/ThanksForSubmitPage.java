package formyPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThanksForSubmitPage extends PageObject {
    @FindBy(xpath = "//h1[text()='Thanks for submitting your form']")
    private WebElement headline;

    public ThanksForSubmitPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return headline.isDisplayed();
    }

    public String confirmationHeader(){
        return headline.getText();
    }
}
