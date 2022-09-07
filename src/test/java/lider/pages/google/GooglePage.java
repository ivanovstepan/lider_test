package lider.pages.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lider.pages.AbstractPage;
import org.openqa.selenium.Keys;
import utils.EnvConfig;
import utils.WaitUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage implements AbstractPage {

    private final static String URL = EnvConfig.googleUrl;
    private final static SelenideElement searchField = Selenide.$x("//input[@name='q']");
    private final static SelenideElement nextPage = Selenide.$x("//a[contains(@href,'search')]//span[text()='Next']");
    private final static ElementsCollection resultLinks = Selenide.$$x("//div[@id='search']//div[@data-header-feature]/div/a");

    @Override
    @Step("Check if 'login' page is loaded")
    public boolean isPageLoaded() {
        return WebDriverRunner.getWebDriver().getCurrentUrl().contains(URL);
    }

    @Step("Navigate to 'login' Page")
    public GooglePage navigateToPage() {
        Selenide.open(URL);
        return getPage();
    }

    @Step("Wait for page loaded")
    public static GooglePage getPage() {
        WaitUtils.waitElementToBeVisible(searchField);
        return new GooglePage();
    }

    @Step("Search value")
    public GooglePage search(String value) {
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
        return getPage();
    }

    @Step("Get Results of search")
    public List<String> getResultsUrl() {
        return resultLinks.parallelStream().map(it -> it.getAttribute("href")).collect(Collectors.toList());
    }

    @Step("Check if 'Next' page is displayed")
    public boolean isNextPageButtonIsDisplayed() {
        return nextPage.isDisplayed();
    }

}
