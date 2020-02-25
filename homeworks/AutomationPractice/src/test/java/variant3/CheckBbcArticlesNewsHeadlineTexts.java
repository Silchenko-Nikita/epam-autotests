package variant3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class CheckBbcArticlesNewsHeadlineTexts {
    final String EXPECTED_MAIN_ARTICLE_HEADLINE_TEXT = "Coronavirus spread raises fears of pandemic";
    final String[] EXPECTED_ARTICLES_HEADLINE_TEXT = {
            "Trumps visit India's 'monument of love'",
            "'How Kobe Bryant inspired me'",
            "Inside Syria's final rebel stronghold",
            "'Fake jobs' trial begins for French ex-PM",
            "Assange data breach 'put lives at risk'",
    };
    final String EXPECTED_FIRST_FOUND_BY_TAG_ARTICLE_HEADLINE_TEXT = "World";

    final WebDriver driver = new ChromeDriver();

    public void navigateToBbcNewsPage() throws InterruptedException {
        driver.navigate().to(Consts.BBC_URL);

        WebElement newsLink = driver.findElement(
                By.cssSelector(".orb-nav-newsdotcom > a"));
        newsLink.click();

        Thread.sleep(1000);
    }

    @Test
    public void checkMainArticleHeadlineText() throws InterruptedException {
        navigateToBbcNewsPage();

        WebElement headline = driver.findElement(
                By.cssSelector(".gs-c-promo-heading__title.gel-paragon-bold.nw-o-link-split__text"));

        String headlineText = headline.getText();


        Assert.assertEquals(headlineText, EXPECTED_MAIN_ARTICLE_HEADLINE_TEXT,
                "News headline is expected to be: \"" + EXPECTED_MAIN_ARTICLE_HEADLINE_TEXT + "\"." +
                        " Actual headline: \"" + headlineText + "\"");
    }

    @Test
    public void checkSecondaryArticlesHeadlinesText() throws InterruptedException {
        navigateToBbcNewsPage();

        List<WebElement> headlines = driver.findElements(
                By.cssSelector(".gs-c-promo-heading__title.gel-pica-bold.nw-o-link-split__text"));

        for (int i = 0; i < 5; i++) {
            String headlineText = headlines.get(i).getText();
            String expectedHeadlineText = EXPECTED_ARTICLES_HEADLINE_TEXT[i];

            Assert.assertEquals(headlineText, expectedHeadlineText,
                    "News headline of " + (i + 1) + "'th article is expected to be: \"" + expectedHeadlineText + "\"." +
                            " Actual headline: \"" + headlineText + "\"");
        }
    }

    @Test
    public void checkFirstArticleHeadlineTextFoundByMainArticleCategoryLinkText() throws InterruptedException {
        navigateToBbcNewsPage();

        WebElement mainArticleCategoryEl = driver.findElement(
                By.cssSelector(".gs-c-section-link.gs-c-section-link--truncate.nw-c-section-link.nw-o-link.nw-o-link--no-visited-state > span"));

        String mainArticleCategoryText = mainArticleCategoryEl.getText();
        WebElement searchInput = driver.findElement(By.id("orb-search-q"));
        searchInput.sendKeys(mainArticleCategoryText);
        searchInput.submit();

        WebElement firstArticleHeadline = driver.findElement(By.cssSelector("li[data-result-number=\"1\"] div a"));
        String firstArticleHeadlineText = firstArticleHeadline.getText();

        Assert.assertEquals(firstArticleHeadlineText, EXPECTED_FIRST_FOUND_BY_TAG_ARTICLE_HEADLINE_TEXT,
                "First article's found by category link headline " +
                        "text is expected to be: \"" + EXPECTED_FIRST_FOUND_BY_TAG_ARTICLE_HEADLINE_TEXT + "\"." +
                        " Actual headline: \"" + firstArticleHeadlineText + "\"");
    }
}
