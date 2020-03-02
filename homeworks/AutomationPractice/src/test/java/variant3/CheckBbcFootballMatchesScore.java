package variant3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CheckBbcFootballMatchesScore {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 4);
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.navigate().to(Consts.BBC_BASE_URL);

        WebElement newsLink = driver.findElement(
                By.cssSelector(".orb-nav-sport > a"));
        newsLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp-c-global-header__logo")));


        WebElement championshipsDropdown = Utils.getLastWebElementOfMatched(driver,
                By.cssSelector(".sp-c-filter-nav__button.sp-c-filter-nav__link"));

        championshipsDropdown.click();


        WebElement scottishPremButton = Utils.getLastWebElementOfMatched(driver,
                By.xpath("//div[@id='sp-c-filter-nav__expanded-block']" +
                        "//button[text()=\"Scottish Prem\" and contains(@class, 'sp-c-filter__list-link')]"));

        wait.until(ExpectedConditions.elementToBeClickable(scottishPremButton));
        scottishPremButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[8]/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div/div[2]/div[2]/a/span[2]")));

        WebElement linkToScottishPremierLigueMatches = Utils.getLastWebElementOfMatched(driver,
                By.cssSelector(".component__footer-link.gel-pica-bold.sp-o-link.qa-tournament-link"));

        linkToScottishPremierLigueMatches.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[contains(text(),'FEB')]]")));
        WebElement resultsLink =
                driver.findElement(By.xpath("//a[span[contains(text(),'FEB')]]"));

        resultsLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class=\"gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc\"]")));
    }


    @DataProvider(name="FootballMatchesResults")
    public static Object[] footballMatchesResults() {
        Map<String, String> matchResults1 = new HashMap<String, String>();
        matchResults1.put("St Johnstone", "2");
        matchResults1.put("Rangers", "2");

        Map<String, String> matchResults2 = new HashMap<String, String>();
        matchResults2.put("Celtic", "3");
        matchResults2.put("Kilmarnock", "1");

        return new Object[]{ matchResults1, matchResults2 };
    }

    @Test(dataProvider="FootballMatchesResults")
    public void checkFootballMatchesScoreListView(Map<String, String> matchResult) {
        Iterator<Map.Entry<String, String>> matchResultIterator = matchResult.entrySet().iterator();
        Map.Entry<String, String> team1Result = matchResultIterator.next();
        Map.Entry<String, String> team2Result = matchResultIterator.next();

        List<WebElement> scores =
                driver.findElements(By.xpath("//div[contains(@class, 'sp-c-fixture__wrapper')" +
                        " and .//span[contains(text(),'" + team1Result.getKey() + "')]" +
                        " and .//span[contains(text(),'" + team2Result.getKey() + "')]]" +
                        "//span[contains(@class, 'sp-c-fixture__number')]"));

        String[] expectedResult = new String[]{ team1Result.getValue() ,team2Result.getValue() };
        String[] actualResult = new String[]{ scores.get(0).getText(), scores.get(1).getText() };

        Assert.assertEquals(expectedResult, actualResult,
                team1Result.getKey() + " : " + team2Result.getKey() + " played with score "
                        + expectedResult[0] + ":" + expectedResult[1] + "," +
                        " but it was shown score: " + actualResult[0] + ":" + actualResult[1]);
    }

    @Test(dataProvider="FootballMatchesResults")
    public void checkFootballMatchesScoreDetailView(Map<String, String> matchResult) {
        Iterator<Map.Entry<String, String>> matchResultIterator = matchResult.entrySet().iterator();
        Map.Entry<String, String> team1Result = matchResultIterator.next();
        Map.Entry<String, String> team2Result = matchResultIterator.next();

        WebElement matchLink =
                driver.findElement(By.xpath("//a[contains(@class, 'sp-c-fixture__block-link')" +
                        " and .//span[contains(text(),'" + team1Result.getKey() + "')]" +
                        " and .//span[contains(text(),'" + team2Result.getKey() + "')]]"));
        matchLink.click();

        List<WebElement> scores = driver.findElements(By.cssSelector(".fixture__wrapper .fixture__number"));

        String[] expectedResult = new String[]{ team1Result.getValue() ,team2Result.getValue() };
        String[] actualResult = new String[] { scores.get(0).getText(), scores.get(1).getText()};

        Assert.assertEquals(expectedResult, actualResult,
                team1Result.getKey() + " : " + team2Result.getKey() +
                        " played with score " + expectedResult[0] + ":" + expectedResult[1] + "," +
                        " but on detailed view page it was shown score: "
                        + actualResult[0] + ":" + actualResult[1]);
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }
}
