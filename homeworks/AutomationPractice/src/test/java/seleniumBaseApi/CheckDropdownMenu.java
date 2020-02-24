package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckDropdownMenu {

    @Test
    public void verifyRedirectionLinksMatchOnesSpecified() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Consts.FORMY_URL + "/dropdown");

        int linksNum = driver.findElements(
                By.cssSelector("#dropdownMenuButton + .dropdown-menu > a.dropdown-item")).size();
        for (int i = 0; i < linksNum; i++) {
            WebElement dropdownMenuButton = driver.findElement(By.id("dropdownMenuButton"));
            WebElement link = driver.findElement(
                    By.cssSelector("#dropdownMenuButton + .dropdown-menu > a.dropdown-item:nth-of-type(" + (i + 1) + ")"));

            String href = link.getAttribute("href");

            dropdownMenuButton.click();
            link.click();
            Thread.sleep(1200);

            String url = driver.getCurrentUrl();
            Assert.assertEquals(href, url,
                    "redirection url doesn't equals reference (href=\"" + href + "\", url=\"" + url + "\")");

            if (!href.endsWith("/dropdown")) {
                driver.navigate().back();
            }
        }
    }
}
