package formyPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends PageObject {
    @FindBy(id = "btnGroupDrop1")
    private WebElement dropdownButton;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void openDropdown() {
        dropdownButton.click();
    }

    public boolean isInitialized() {
        return dropdownButton.isDisplayed();
    }
}
