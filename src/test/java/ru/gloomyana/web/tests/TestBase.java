package ru.gloomyana.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.gloomyana.web.config.GetDataConfig;
import ru.gloomyana.web.config.WebDriverConfig;

import ru.gloomyana.web.helpers.Attach;
import ru.gloomyana.web.pages.BlogPage;
import ru.gloomyana.web.pages.MainPage;
import ru.gloomyana.web.pages.TariffsPage;

import java.util.Map;

public class TestBase {
    MainPage mainPage = new MainPage();
    BlogPage blogPage = new BlogPage();
    TariffsPage tariffsPage = new TariffsPage();
    TestData testData = new TestData();

    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    GetDataConfig config = ConfigFactory.create(GetDataConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();

        if (webDriverConfig.isRemote()) {
            Configuration.remote = webDriverConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
