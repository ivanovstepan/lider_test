package lider.pages.yandex;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lider.pages.AbstractPage;
import utils.WaitUtils;

public class PassportYandexPage implements AbstractPage {

    private final static SelenideElement mail = Selenide.$x("//input[@data-t='field:input-login']");
    private final static SelenideElement password = Selenide.$x("//input[@data-t='field:input-passwd']");
    private final static SelenideElement confirm = Selenide.$x("//button[@data-t='button:action']");
    private final static SelenideElement codeElement = Selenide.$x("//input[@data-t='field:input-login']");
    private final static SelenideElement next = Selenide.$x("//button[@data-t='button:action']");

    @Override
    @Step("Check if 'login' page is loaded")
    public boolean isPageLoaded() {
        return mail.isDisplayed();
    }

    public static PassportYandexPage getPage() {
        WaitUtils.waitElementToBeVisible(mail);
        return new PassportYandexPage();
    }

    @Step("Navigate to 'login' Page")
    public void login(String login, String pass, String code) {
        mail.sendKeys(login);
        password.sendKeys(pass);
        confirm.click();
        codeElement.sendKeys(code);
        next.click();
    }

}
