package lider.tests;

import com.codeborne.selenide.WebDriverRunner;
import lider.BaseWebTest;
import lider.pages.yandex.LoginPage;
import lider.pages.yandex.PassportYandexPage;
import org.testng.annotations.Test;
import utils.DriverUtils;
import utils.ENV;

import static org.testng.Assert.assertEquals;


public class YandexMailTest extends BaseWebTest {

    LoginPage loginPage = new LoginPage();
    PassportYandexPage passportYandexPage = new PassportYandexPage();

    @Test
    public void loginYandexMailTest() {
        loginPage.navigateToPage()
                .clickYandexMailButton();
        DriverUtils.switchToNextWindow();
        passportYandexPage.login(ENV.login, ENV.pass, ENV.code);
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://mail.yandex.by", "Yandex mail is not login");
    }

}
