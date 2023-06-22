package ru.gloomyana.web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.qameta.allure.Allure.step;

@Epic("UI tests webinar.ru")
@Feature("Blog page")
@Tag("web")
@Owner("gloomyana")
public class BlogPageTests extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful opening of \"Blog\" page")
    void openBlogPage() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
        step("Going to \"Blog\" page using header", () -> {
            mainPage.openBlogPage();
        });
        step("Verify successful opening of \"Blog\" page", () -> {
            blogPage.verifyBlogPageOpen(config.getBlogPageDesc());
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click \"Try\" button opens \"Sign Up\" page")
    void clickTryButtonOpensSignUpPage() {
        step("Open \"Blog\" page", () -> {
            blogPage.openBlogPage();
        });
        step("Click on \"Try\" button in header", () -> {
            blogPage.clickHeaderTryButton();
        });
        step("Verify successful opening of \"Sign Up\" page", () -> {
            blogPage.verifySignUpPageTitle(config.getSignUpPageTitle());
        });
    }

    @MethodSource("ru.gloomyana.web.tests.TestData#getBlogMenuItems")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "Menu item \"{0}\" is enabled, visible and clickable")
    void checkBlogMenuItemsClickable(String menuItem) {
        step("Open \"Blog\" page", () -> {
            blogPage.openBlogPage();
        });
        step("Verify menu item is enabled, visible and clickable", () -> {
            blogPage.verifyMenuItemClickable(menuItem);
        });
    }
}
