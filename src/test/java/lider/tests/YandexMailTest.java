package lider.tests;

import com.codeborne.selenide.WebDriverRunner;
import lider.pages.yandex.LoginPage;
import lider.pages.yandex.PassportYandexPage;
import org.testng.annotations.Test;
import utils.DriverUtils;
import utils.EnvConfig;

import static org.testng.Assert.assertEquals;

public class YandexMailTest extends BaseWebTest {

    LoginPage loginPage = new LoginPage();
    PassportYandexPage passportYandexPage = new PassportYandexPage();

    @Test
    public void loginYandexMailTest() {
        loginPage.navigateToPage()
                .clickYandexMailButton();
        DriverUtils.switchToNextWindow();
        passportYandexPage.login(EnvConfig.login, EnvConfig.pass, EnvConfig.code);
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://mail.yandex.by", "Yandex mail is not login");
    }

}
