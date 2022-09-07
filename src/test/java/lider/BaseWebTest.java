package lider;

import lider.pages.yandex.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverUtils;

public class BaseWebTest {

    @BeforeClass(alwaysRun = true, description = "Configure browser and start it")
    public void setUpBrowser() {
        DriverUtils.setChromeBrowser();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void closeBrowser() {
        DriverUtils.tearDownBrowser();
    }

}
