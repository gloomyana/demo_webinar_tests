package ru.gloomyana.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class UserProfilePage {
    private final SelenideElement editProfile = $(id("ru.webinar.mobile:id/edit_profile")),
            eventPageTitle = $(id("ru.webinar.mobile:id/calendar_event_page_empty")),
            editPageTitle = $(id("ru.webinar.mobile:id/title")),
            userInitials = $(id("ru.webinar.mobile:id/user_initials")),
            signOutButton = $(id("ru.webinar.mobile:id/sign_out")),
            firstNameEditInput = $(id("ru.webinar.mobile:id/firstName"))
                    .$(className("android.widget.EditText")),
            secondNameEditInput = $(id("ru.webinar.mobile:id/secondName"))
                    .$(className("android.widget.EditText")),
            companyEditInput = $(id("ru.webinar.mobile:id/company"))
                    .$(className("android.widget.EditText")),
            positionEditInput = $(id("ru.webinar.mobile:id/position"))
                    .$(className("android.widget.EditText")),
            phoneEditInput = $(id("ru.webinar.mobile:id/phone"))
                    .$(className("android.widget.EditText")),
            approveChangeButton = $(id("ru.webinar.mobile:id/approveChange"));


    public UserProfilePage verifyEmptyEventPageTitle(String expectedTitle) {
        eventPageTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public UserProfilePage clickOnUserAvatar() {
        userInitials.click();
        return this;
    }

    public UserProfilePage clickSignOutButton() {
        signOutButton.click();
        return this;
    }

    public UserProfilePage clickApproveChangeButton() {
        approveChangeButton.click();
        return this;
    }

    public UserProfilePage successfulOpenEditProfilePage(String expectedTitle) {
        editProfile.click();
        editPageTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public UserProfilePage setFirstName(String firstName) {
        firstNameEditInput.sendKeys(firstName);
        return this;
    }

    public UserProfilePage setLastName(String lastName) {
        secondNameEditInput.sendKeys(lastName);
        return this;
    }

    public UserProfilePage setCompanyName(String companyName) {
        companyEditInput.sendKeys(companyName);
        return this;
    }

    public UserProfilePage setPosition(String position) {
        positionEditInput.sendKeys(position);
        return this;
    }

    public UserProfilePage setPhoneNumber(String phoneNumber) {
        phoneEditInput.sendKeys(phoneNumber);
        return this;
    }

    public UserProfilePage verifyFirstName(String expectedFirstName) {
        firstNameEditInput.shouldHave(text(expectedFirstName));
        return this;
    }

    public UserProfilePage verifyLastName(String expectedLastName) {
        secondNameEditInput.shouldHave(text(expectedLastName));
        return this;
    }

    public UserProfilePage verifyCompanyName(String expectedCompanyName) {
        companyEditInput.shouldHave(text(expectedCompanyName));
        return this;
    }

    public UserProfilePage verifyPosition(String expectedPosition) {
        positionEditInput.shouldHave(text(expectedPosition));
        return this;
    }

    public UserProfilePage verifyPhoneNumber(String expectedPhoneNumber) {
        phoneEditInput.shouldHave(text(expectedPhoneNumber));
        return this;
    }
}
