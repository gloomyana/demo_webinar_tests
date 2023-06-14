package ru.gloomyana.mobile.tests;

import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.gloomyana.mobile.config.AuthConfig;

import static io.qameta.allure.Allure.step;

@Epic("Mobile app tests webinar.ru")
@Feature("User profile page")
@Tag("mobile")
@Owner("gloomyana")

public class EditUserTests extends TestBase {
    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful user data update")
    void editUserData() {
        step("Successful user login", () -> {
            loginScreenPage.userLogin(config.login(), config.password());
        });
        step("Enter user profile", () -> {
            userProfilePage.clickOnUserAvatar();
        });
        step("Enter edit profile page", () -> {
            userProfilePage.successfulOpenEditProfilePage(testData.config.editUserPageTitle());
        });
        step("Generate and update user data", () -> {
            testData.GenerateUserData();
            userProfilePage.setFirstName(testData.firstName);
            userProfilePage.setLastName(testData.lastName);
            userProfilePage.setCompanyName(testData.companyName);
            userProfilePage.setPosition(testData.position);
            userProfilePage.setPhoneNumber(testData.phoneNumber);
            userProfilePage.clickApproveChangeButton();
        });
        step("Verify successful user data update", () -> {
            userProfilePage.successfulOpenEditProfilePage(testData.config.editUserPageTitle());
            userProfilePage.verifyFirstName(testData.firstName);
            userProfilePage.verifyLastName(testData.lastName);
            userProfilePage.verifyCompanyName(testData.companyName);
            userProfilePage.verifyPosition(testData.position);
            userProfilePage.verifyPhoneNumber(testData.phoneNumber);
        });
    }
}
