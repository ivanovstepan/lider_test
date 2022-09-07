package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DriverUtils {

    private DriverUtils() {
    }

    public static void setChromeBrowser() {
        Configuration.pageLoadTimeout = 30 * 1000;
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver(configureChrome()));
    }

    private static ChromeOptions configureChrome() {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.INFO);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", loggingPreferences);
        options.addArguments("--verbose");
        options.addArguments("-bb-no-sandbox");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito");
        options.addArguments("--log-level=OFF");
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("prefs", Map.ofEntries(
                new AbstractMap.SimpleEntry<>("credentials_enable_service", false),
                new AbstractMap.SimpleEntry<>("download.default_directory", System.getProperty("user.dir") + File.separator + "target"),
                new AbstractMap.SimpleEntry<>("profile.password_manager_enabled", "budapest")
        ));
        return options;
    }

    public static void tearDownBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    public static void switchToNextWindow() {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        switchTo().window(tabs.get(1));
    }

}
