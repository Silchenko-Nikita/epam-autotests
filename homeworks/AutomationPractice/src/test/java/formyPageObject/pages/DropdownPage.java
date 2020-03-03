package formyPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends PageObject {
    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void openDropdown() {
        dropdown.click();
    }

    public boolean isInitialized() {
        return dropdown.isDisplayed();
    }
}
