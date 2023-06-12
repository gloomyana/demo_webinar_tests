package ru.gloomyana.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BlogPage {

    private final SelenideElement headerDesc = $(".header-desc"),
            headerButton = $(".header-cta"),
            signUpTitle = $(".signup-title"),
            blogMenu = $(".wb-menu");

    public BlogPage openBlogPage() {
        open("blog/");
        return this;
    }

    public BlogPage verifyBlogPageOpen(String expectedTitle) {
        headerDesc.shouldHave(text(expectedTitle));
        return this;
    }

    public BlogPage clickHeaderTryButton() {
        headerButton.click();
        return this;
    }

    public BlogPage verifySignUpPageTitle(String expectedTitle) {
        signUpTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public BlogPage verifyMenuItemClickable(String menuItem) {
        blogMenu.$(byText(menuItem)).shouldBe(and("Clickable", visible, enabled));
        return this;
    }
}
