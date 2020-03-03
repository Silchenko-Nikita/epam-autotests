package linkedInCucumber.stepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    WebDriver driver;

    @Given("^Open the Google Chrome and launch LinkedIn$")
    public void open_the_Google_Chrome_and_launch_LinkedIn() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable
    {
        driver.findElement(By.className("nav__button-secondary")).click();
        driver.findElement(By.id("username")).sendKeys("nikitiussss@gmail.com");
        driver.findElement(By.id("password")).sendKeys("sekretnost");
    }

    @Then("^Login to LinkedIn$")
    public void login_to_LinkedIn() throws Throwable
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
