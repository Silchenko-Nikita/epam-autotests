package formyPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends PageObject {
    @FindBy(xpath = "//h1[text()='Checkboxes']")
    private WebElement headline;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }


    public boolean isInitialized() {
        return headline.isDisplayed();
    }
}
