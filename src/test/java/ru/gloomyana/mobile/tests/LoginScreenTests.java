package ru.gloomyana.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Mobile app tests webinar.ru")
@Feature("Authorization in mobile app")
@Tag("mobile")
@Owner("gloomyana")

public class LoginScreenTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check \"Forgot password\" button functionality")
    void checkForgotPasswordButton() {
        step("Open login page", () -> {
            loginScreenPage.clickLoginButton();
        });
        step("Open password recovery page", () -> {
            loginScreenPage.clickForgotPasswordButton();
            loginScreenPage.verifyPasswordRecoveryPageTitle(testData.passwordRecoveryPageTitle);
        });
        step("Generate and enter user email address", () -> {
            testData.GenerateUserEmail();
            loginScreenPage.setUserEmail(testData.email);
            loginScreenPage.clickSendButton();
        });
        step("Verify that page title has information about sending instructions", () -> {
            loginScreenPage.verifyEmailSentPageTitle(testData.emailSentPageTitle);
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Successful user login")
    void successfulUserLogin() {
        step("Open log in page", () -> {
            loginScreenPage.clickLoginButton();
        });
        step("Enter user email address and password", () -> {
            loginScreenPage.setUserEmail(config.login());
            loginScreenPage.setUserPassword(config.password());
            loginScreenPage.clickLoginButton();
        });
        step("Verify successful login", () -> {
            userProfilePage.verifyEmptyEventPageTitle(testData.eventPageTitle);
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Successful user logout")
    void successfulSignOut() {
        step("Successful user login", () -> {
            loginScreenPage.userLogin(config.login(), config.password());
        });
        step("Enter user profile", () -> {
            userProfilePage.clickOnUserAvatar();
        });
        step("Click \"Sign out\" button", () -> {
            userProfilePage.clickSignOutButton();
        });
        step("Verify successful logout", () -> {
            loginScreenPage.verifyLoginScreenPageTitle(testData.loginPageTitle);
        });
    }
}
