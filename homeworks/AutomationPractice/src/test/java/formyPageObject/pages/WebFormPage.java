package formyPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage extends PageObject {
    @FindBy(xpath = "//h1[text()='Complete Web Form']")
    private WebElement headline;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "job-title")
    private WebElement jobTitle;

    @FindBy(id = "select-menu")
    private WebElement yearsOfExperience;

    @FindBy(id = "datepicker")
    private WebElement datepicker;

    @FindBy(xpath = "//a[text()='Submit']")
    private WebElement submit;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String firstName, String lastName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void enterJobData(String jobTitle, String yearsOfExperience){
        this.jobTitle.clear();
        this.jobTitle.sendKeys(jobTitle);

        new Select(this.yearsOfExperience).selectByVisibleText(yearsOfExperience);
    }

    public void enterDate(String date){
        this.datepicker.clear();
        this.datepicker.sendKeys(date);
    }

    public ThanksForSubmitPage submit(){
        submit.click();
        return new ThanksForSubmitPage(driver);
    }

    public boolean isInitialized() {
        return headline.isDisplayed();
    }
}
