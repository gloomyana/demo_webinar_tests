package ru.gloomyana.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class LoginScreenPage {
    private final SelenideElement LOGIN_BUTTON = $(id("ru.webinar.mobile:id/sign_in")),
            FORGOT_PASSWORD = $(id("ru.webinar.mobile:id/forgotPassword")),
            RESTORE_TITLE = $(id("ru.webinar.mobile:id/restore_title")),
            EMAIL_INPUT = $(id("ru.webinar.mobile:id/email"))
                    .$(className("android.widget.EditText")),
            SEND_BUTTON = $(id("ru.webinar.mobile:id/send")),
            EMAIL_SENT_TITLE = $(id("ru.webinar.mobile:id/email_sent_title")),
            PASSWORD_INPUT = $(id("ru.webinar.mobile:id/password"))
                    .$(className("android.widget.EditText")),
            LOGIN_PAGE_TITLE = $(id("ru.webinar.mobile:id/title"));

    public LoginScreenPage clickLoginButton() {
        LOGIN_BUTTON.click();
        return this;
    }

    public LoginScreenPage clickSendButton() {
        SEND_BUTTON.click();
        return this;
    }

    public LoginScreenPage clickForgotPasswordButton() {
        FORGOT_PASSWORD.click();
        return this;
    }

    public LoginScreenPage setUserEmail(String email) {
        EMAIL_INPUT.sendKeys(email);
        return this;
    }

    public LoginScreenPage setUserPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
        return this;
    }

    public LoginScreenPage userLogin(String userEmail, String userPassword) {
        LOGIN_BUTTON.click();
        EMAIL_INPUT.sendKeys(userEmail);
        PASSWORD_INPUT.sendKeys(userPassword);
        LOGIN_BUTTON.click();
        return this;
    }

    public LoginScreenPage verifyLoginScreenPageTitle(String expectedTitle) {
        LOGIN_PAGE_TITLE.shouldHave(text(expectedTitle));
        return this;
    }

    public LoginScreenPage verifyPasswordRecoveryPageTitle(String expectedTitle) {
        RESTORE_TITLE.shouldHave(text(expectedTitle));
        return this;
    }

    public LoginScreenPage verifyEmailSentPageTitle(String expectedTitle) {
        EMAIL_SENT_TITLE.shouldHave(text(expectedTitle));
        return this;
    }
}
