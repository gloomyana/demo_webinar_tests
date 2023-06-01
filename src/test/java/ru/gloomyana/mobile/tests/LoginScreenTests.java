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
    @DisplayName("Check recover password button functionality")
    void checkForgotPasswordButton() {
        step("Open login page", () -> {
            loginScreenPage.clickLoginButton();
        });
        step("Open password recovery page", () -> {
            loginScreenPage.clickForgotPasswordButton();
            loginScreenPage.verifyPasswordRecoveryPageTitle(testData.passwordRecoveryPageTitle);
        });
        step("Enter user email address", () -> {
            loginScreenPage.setUserEmail(testData.email);
            loginScreenPage.clickSendButton();
        });
        step("Verify that page title has information about sending instructions", () -> {
            loginScreenPage.verifyEmailSentPageTitle(testData.emailSentPageTitle);
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Successful login with correct user's data")
    void successfulUserLogin() {
        step("Open log in page", () -> {
            loginScreenPage.clickLoginButton();
        });
        step("Enter user email address and password", () -> {
            loginScreenPage.setUserEmail(testData.userEmail);
            loginScreenPage.setUserPassword(testData.userPassword);
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
            loginScreenPage.userLogin(testData.userEmail, testData.userPassword);
        });
        step("Enter user profile", () -> {
            userProfilePage.clickOnUserAvatar();
        });
        step("Click sign out button", () -> {
            userProfilePage.clickSignOutButton();
        });
        step("Verify successful logout", () -> {
            loginScreenPage.verifyLoginScreenPageTitle(testData.loginPageTitle);
        });
    }
}
