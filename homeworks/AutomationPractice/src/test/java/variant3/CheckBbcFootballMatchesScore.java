package variant3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBbcFootballMatchesScore {
    final WebDriver driver = new ChromeDriver();

//    @DataProvider(name="FootballMatchesResults")
//    public static Object[] happyPathEmails() {
//        Map<String, Integer> matchResults1 = new HashMap<String, Integer>();
//        matchResults1.put("St Johnstone", 2);
//        matchResults1.put("Rangers", 2);
//
//        Map<String, Integer> matchResults2 = new HashMap<String, Integer>();
//        matchResults1.put("Celtic", 3);
//        matchResults1.put("Kilmarnock", 1);
//
//        return new Object[]{ matchResults1, matchResults2 };
//    }

    @Test
    public void checkMainArticleHeadlineText() throws InterruptedException {
        driver.navigate().to(Consts.BBC_URL);

        WebElement newsLink = driver.findElement(
                By.cssSelector(".orb-nav-sport > a"));
        newsLink.click();

        Thread.sleep(1000);

        WebElement championshipsDropdown = Utils.getLastWebElementOfMatched(driver,
                By.cssSelector(".sp-c-filter-nav__button.sp-c-filter-nav__link"));

        championshipsDropdown.click();

        WebElement scottishPremButton = Utils.getLastWebElementOfMatched(driver,
                By.xpath("//div[@id='sp-c-filter-nav__expanded-block']" +
                        "//button[text()=\"Scottish Prem\" and contains(@class, 'sp-c-filter__list-link')]"));

        scottishPremButton.click();

        Thread.sleep(1000);

        WebElement linkToScottishPrem = Utils.getLastWebElementOfMatched(driver,
                By.cssSelector(".component__footer-link.gel-pica-bold.sp-o-link.qa-tournament-link"));
        linkToScottishPrem.click();

        Thread.sleep(1000);
        WebElement resultsLink =
                driver.findElement(By.xpath("//a[span[contains(text(),'RESULTS')]]"));
        resultsLink.click();

        List<WebElement> scores =
                driver.findElements(By.xpath("//div[contains(@class, 'sp-c-fixture__wrapper')" +
                        " and .//span[contains(text(),'St Johnstone')]" +
                        " and .//span[contains(text(),'Rangers')]]" +
                        "//span[contains(@class, 'sp-c-fixture__number')]"));

        String[] expectedResult1 = new String[]{"2", "2"};
        String[] actualResult1 = new String[]{scores.get(0).getText(), scores.get(1).getText()};

        Assert.assertEquals(expectedResult1, actualResult1,
                "St Johnstone : Rangers played with score " + expectedResult1[0] + ":" + expectedResult1[1] + "," +
                        " but it was shown score: " + actualResult1[0] + ":" + actualResult1[1]);

        scores =
                driver.findElements(By.xpath("//div[contains(@class, 'sp-c-fixture__wrapper')" +
                        " and .//span[contains(text(),'Celtic')]" +
                        " and .//span[contains(text(),'Kilmarnock')]]" +
                        "//span[contains(@class, 'sp-c-fixture__number')]"));
        String[] expectedResult2 = new String[]{"3", "1"};
        String[] actualResult2 = new String[]{scores.get(0).getText(), scores.get(1).getText()};

        Assert.assertEquals(expectedResult2, actualResult2,
                "Celtic : Kilmarnock played with score " + expectedResult2[0] + ":" + expectedResult2[1] + "," +
                        " but it was shown score: " + actualResult2[0] + ":" + actualResult2[1]);

        WebElement matchLink =
                driver.findElement(By.xpath("//a[contains(@class, 'sp-c-fixture__block-link')" +
                        " and .//span[contains(text(),'St Johnstone')]" +
                        " and .//span[contains(text(),'Rangers')]]"));
        matchLink.click();

        Thread.sleep(1000);
        List<WebElement> scoresOnDetailedViewPage = driver.findElements(By.cssSelector(".fixture__wrapper .fixture__number"));
        System.out.println(scoresOnDetailedViewPage.get(0).getText());
        System.out.println(scoresOnDetailedViewPage.get(1).getText());

        String[] result1OnDetailedViewPage = new String[] {
                scoresOnDetailedViewPage.get(0).getText(),
                scoresOnDetailedViewPage.get(1).getText()};

        Assert.assertEquals(actualResult1, result1OnDetailedViewPage,
                "St Johnstone : Rangers played with score " + actualResult1[0] + ":" + actualResult1[1] + "," +
                        " but on detailed view page it was shown score: "
                        + result1OnDetailedViewPage[0] + ":" + result1OnDetailedViewPage[1]);
    }

}
