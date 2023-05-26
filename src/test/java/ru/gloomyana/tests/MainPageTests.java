package ru.gloomyana.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {
    @BeforeEach
    void openBaseUrl() {
        mainPage.openMainPage();
    }

    @Test
    void clickLogoOpensMainPage() {
        mainPage.clickOnLogo();
        mainPage.verifyPageUrl();
    }

    @Test
    void clickPromoButtonOpensRegistrationSidebar() {
        mainPage.clickPromoButton(testData.buttonName);
        mainPage.verifyRegistrationSidebarIsOpen(testData.sidebarTitle);
    }

    @Test
    void checkPromoTitleText() {
        mainPage.verifyPromoTitleText(testData.mainPageTitle);
    }
}
