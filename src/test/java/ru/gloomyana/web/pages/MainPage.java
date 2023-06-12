package ru.gloomyana.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement
            headerBottom = $(".header-bottom"),
            logoLink = $(".logo__link"),
            headerBlogLink = $(".header-top__links-link", 0),
            promoButtons = $(".promo__controls-btn"),
            promoTitle = $(".promo__title.block-title"),
            messageBox = $(".message-box"),
            blockTitle = $(".block-title.right-panel__title");

    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    public MainPage openBlogPage() {
        headerBlogLink.click();
        switchTo().window(1);
        return this;
    }

    public MainPage clickOnHeaderMenu(String buttonName) {
        headerBottom.$(byText(buttonName)).click();
        return this;
    }

    public MainPage clickOnLogo() {
        logoLink.click();
        return this;
    }

    public MainPage clickPromoButton(String buttonName) {
        promoButtons.$(byText(buttonName)).click();
        return this;
    }

    public MainPage verifyPageUrl() {
        webdriver().shouldHave(url(baseUrl));
        return this;
    }

    public MainPage verifyPromoTitleText(String expectedTitle) {
        promoTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public MainPage verifyRegistrationSidebarIsOpen(String titleName) {
        messageBox.shouldBe(visible);
        blockTitle.shouldHave(text(titleName));
        return this;
    }
}
