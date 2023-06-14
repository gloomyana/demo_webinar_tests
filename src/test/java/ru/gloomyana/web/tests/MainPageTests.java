package ru.gloomyana.web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("UI tests webinar.ru")
@Feature("Main page")
@Tag("web")
@Owner("gloomyana")
public class MainPageTests extends TestBase {

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Click on Webinar logo opens main page")
    void clickLogoOpensMainPage() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
        step("Click on Webinar logo in header", () -> {
            mainPage.clickOnLogo();
        });
        step("Verify that click on logo opens main page", () -> {
            mainPage.verifyPageUrl();
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click on participant button opens registration sidebar")
    void clickParticipantButtonOpensRegistrationSidebar() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
        step("Click on participant button", () -> {
            mainPage.clickPromoButton(testData.participantButtonTitle);
        });
        step("Verify that registration sidebar is opened", () -> {
            mainPage.verifyRegistrationSidebarIsOpen(testData.sidebarTitle);
        });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Check promo title of main page")
    void checkPromoTitleText() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
        step("Verify promo title contains the expected text", () -> {
            mainPage.verifyPromoTitleText(testData.mainPageTitle);
        });
    }
}
