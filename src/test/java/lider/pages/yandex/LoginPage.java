package lider.pages.yandex;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lider.pages.AbstractPage;
import utils.EnvConfig;
import utils.WaitUtils;

public class LoginPage implements AbstractPage {

    private final static String URL = EnvConfig.yandexUrl;
    private final static SelenideElement mailButton = Selenide.$x("//a[contains(@href,'passport')][contains(@href,'mail')]");

    @Override
    @Step("Check if 'login' page is loaded")
    public boolean isPageLoaded() {
        return WebDriverRunner.getWebDriver().getCurrentUrl().contains(URL);
    }

    @Step("Wait for page loaded")
    public static LoginPage getPage() {
        WaitUtils.waitElementToBeVisible(mailButton);
        return new LoginPage();
    }

    @Step("Navigate to 'login' Page")
    public LoginPage navigateToPage() {
        Selenide.open(URL);
        return getPage();
    }

    @Step("Click 'Yandex mail' button")
    public void clickYandexMailButton() {
        mailButton.click();
    }

}
