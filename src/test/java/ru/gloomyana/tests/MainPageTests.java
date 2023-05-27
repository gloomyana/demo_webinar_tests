package ru.gloomyana.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {
    @BeforeEach
    void openBaseUrl() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
    }

    @Test
    @DisplayName("Click on Webinar logo opens the main page")
    void clickLogoOpensMainPage() {
        step("Click on Webinar logo in header", () -> {
            mainPage.clickOnLogo();
        });
        step("Verify that click on logo opens main page", () -> {
            mainPage.verifyPageUrl();
        });
    }

    @Test
    @DisplayName("Click on participant button opens registration sidebar")
    void clickParticipantButtonOpensRegistrationSidebar() {
        step("Click on participant button", () -> {
            mainPage.clickPromoButton(testData.participantButton);
        });
        step("Verify that registration sidebar is opened", () -> {
            mainPage.verifyRegistrationSidebarIsOpen(testData.sidebarTitle);
        });
    }

    @Test
    @DisplayName("Check promo title of main page")
    void checkPromoTitleText() {
        step("Verify promo title contains the expected text", () -> {
            mainPage.verifyPromoTitleText(testData.mainPageTitle);
        });
    }
}
