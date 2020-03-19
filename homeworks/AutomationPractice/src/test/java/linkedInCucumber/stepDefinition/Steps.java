package linkedInCucumber.stepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Steps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^Open the Google Chrome and launch LinkedIn$")
    public void open_the_Google_Chrome_and_launch_LinkedIn()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 4);
        driver.get("https://www.linkedin.com/login");
    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header__content__heading")));

        driver.findElement(By.id("username")).sendKeys("nikitiussss@gmail.com");
        driver.findElement(By.id("password")).sendKeys("sekretnost");
    }

    @Then("^Login to LinkedIn$")
    public void login_to_LinkedIn()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.id("ember42")).isDisplayed(), "Redirection after logining to LinckedIn page didn't load");
    }
}
