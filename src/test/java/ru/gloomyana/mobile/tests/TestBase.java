package ru.gloomyana.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.gloomyana.mobile.drivers.BrowserstackMobileDriver;
import ru.gloomyana.mobile.drivers.LocalMobileDriver;
import ru.gloomyana.mobile.helpers.Attach;
import ru.gloomyana.mobile.pages.LoginScreenPage;
import ru.gloomyana.mobile.pages.UserProfilePage;


import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String envMobile = System.getProperty("envMobile");
    TestData testData = new TestData();
    LoginScreenPage loginScreenPage = new LoginScreenPage();
    UserProfilePage userProfilePage = new UserProfilePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.browserSize = null;

        if (envMobile.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        if ("browserstack".equals(envMobile)) {
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
