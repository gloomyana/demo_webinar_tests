package ru.gloomyana.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Mobile tests webinar.ru")
@Feature("User profile page")
@Tag("mobile")
@Owner("gloomyana")

public class EditUserTests extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful update user data")
    void editUserData() {
        step("Successful user login", () -> {
            loginScreenPage.userLogin(testData.userEmail, testData.userPassword);
        });
        step("Enter user profile", () -> {
            userProfilePage.clickOnUserAvatar();
        });
        step("Enter edit profile page", () -> {
            userProfilePage.successfulOpenEditProfilePage(testData.editUserPageTitle);
        });
        step("Update user data", () -> {
            userProfilePage.setFirstName(testData.firstName);
            userProfilePage.setLastName(testData.lastName);
            userProfilePage.setCompanyName(testData.companyName);
            userProfilePage.setPosition(testData.position);
            userProfilePage.setPhoneNumber(testData.phoneNumber);
            userProfilePage.clickApproveChangeButton();
        });
        step("Verify successful update user data", () -> {
            userProfilePage.successfulOpenEditProfilePage(testData.editUserPageTitle);
            userProfilePage.verifyFirstName(testData.firstName);
            userProfilePage.verifyLastName(testData.lastName);
            userProfilePage.verifyCompanyName(testData.companyName);
            userProfilePage.verifyPosition(testData.position);
            userProfilePage.verifyPhoneNumber(testData.phoneNumber);
        });
    }
}
