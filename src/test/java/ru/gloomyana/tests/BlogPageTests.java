package ru.gloomyana.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BlogPageTests extends TestBase {

    @Test
    void openBlogPage() {
        mainPage.openMainPage();
        mainPage.openBlogPage();
        blogPage.verifyBlogPageOpen(testData.blogPageDesc);
    }

    @Test
    void clickTryButtonOpensSignUpPage() {
        blogPage.openBlogPage();
        blogPage.clickHeaderTryButton();
        blogPage.verifySignUpPageTitle(testData.signUpPageTitle);
    }

    @MethodSource("ru.gloomyana.tests.TestData#blogMenuItems")
    @ParameterizedTest(name = "Пункт меню \"{0}\" отображается и кликабельный")
    void checkBlogMenuItemsClickable(String menuItem) {
        blogPage.openBlogPage();
        blogPage.verifyMenuItemClickable(menuItem);
    }
}
