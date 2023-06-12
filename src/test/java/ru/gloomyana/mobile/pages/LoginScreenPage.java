package ru.gloomyana.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class LoginScreenPage {
    private final SelenideElement loginButton = $(id("ru.webinar.mobile:id/sign_in")),
            forgotPassword = $(id("ru.webinar.mobile:id/forgotPassword")),
            restoreTitle = $(id("ru.webinar.mobile:id/restore_title")),
            emailInput = $(id("ru.webinar.mobile:id/email"))
                    .$(className("android.widget.EditText")),
            sendButton = $(id("ru.webinar.mobile:id/send")),
            emailSentTitle = $(id("ru.webinar.mobile:id/email_sent_title")),
            passwordInput = $(id("ru.webinar.mobile:id/password"))
                    .$(className("android.widget.EditText")),
            loginPageTitle = $(id("ru.webinar.mobile:id/title"));

    public LoginScreenPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginScreenPage clickSendButton() {
        sendButton.click();
        return this;
    }

    public LoginScreenPage clickForgotPasswordButton() {
        forgotPassword.click();
        return this;
    }

    public LoginScreenPage setUserEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginScreenPage setUserPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginScreenPage userLogin(String userEmail, String userPassword) {
        loginButton.click();
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        loginButton.click();
        return this;
    }

    public LoginScreenPage verifyLoginScreenPageTitle(String expectedTitle) {
        loginPageTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public LoginScreenPage verifyPasswordRecoveryPageTitle(String expectedTitle) {
        restoreTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public LoginScreenPage verifyEmailSentPageTitle(String expectedTitle) {
        emailSentTitle.shouldHave(text(expectedTitle));
        return this;
    }
}
