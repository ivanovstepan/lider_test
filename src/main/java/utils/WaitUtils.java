package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final WebDriverWait WAIT = new WebDriverWait(WebDriverRunner.getWebDriver(), DEFAULT_TIMEOUT);

    private WaitUtils() {
        WAIT.pollingEvery(Duration.ofMillis(100));
    }

    public static WebElement waitElementToBeVisible(WebElement element) {
        waitElementToBeVisible(element, DEFAULT_TIMEOUT);
        return element;
    }

    public static WebElement waitElementToBeVisible(WebElement element, Duration timeout) {
        new WebDriverWait(WebDriverRunner.getWebDriver(), timeout)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
