package ru.gloomyana.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class UserProfilePage {
    private final SelenideElement EDIT_PROFILE = $(id("ru.webinar.mobile:id/edit_profile")),
            EVENT_PAGE_TITLE = $(id("ru.webinar.mobile:id/calendar_event_page_empty")),
            EDIT_PAGE_TITLE = $(id("ru.webinar.mobile:id/title")),
            AVATAR_INITIALS = $(id("ru.webinar.mobile:id/user_initials")),
            SIGN_OUT_BUTTON = $(id("ru.webinar.mobile:id/sign_out")),
            FIRSTNAME_EDIT_INPUT = $(id("ru.webinar.mobile:id/firstName"))
                    .$(className("android.widget.EditText")),
            LASTNAME_EDIT_INPUT = $(id("ru.webinar.mobile:id/secondName"))
                    .$(className("android.widget.EditText")),
            COMPANY_EDIT_INPUT = $(id("ru.webinar.mobile:id/company"))
                    .$(className("android.widget.EditText")),
            POSITION_EDIT_INPUT = $(id("ru.webinar.mobile:id/position"))
                    .$(className("android.widget.EditText")),
            PHONE_EDIT_INPUT = $(id("ru.webinar.mobile:id/phone"))
                    .$(className("android.widget.EditText")),
            APPROVE_CHANGE_BUTTON = $(id("ru.webinar.mobile:id/approveChange"));


    public UserProfilePage verifyEmptyEventPageTitle(String expectedTitle) {
        EVENT_PAGE_TITLE.shouldHave(text(expectedTitle));
        return this;
    }

    public UserProfilePage clickOnUserAvatar() {
        AVATAR_INITIALS.click();
        return this;
    }

    public UserProfilePage clickSignOutButton() {
        SIGN_OUT_BUTTON.click();
        return this;
    }

    public UserProfilePage clickApproveChangeButton() {
        APPROVE_CHANGE_BUTTON.click();
        return this;
    }

    public UserProfilePage successfulOpenEditProfilePage(String expectedTitle) {
        EDIT_PROFILE.click();
        EDIT_PAGE_TITLE.shouldHave(text(expectedTitle));
        return this;
    }

    public UserProfilePage setFirstName(String firstName) {
        FIRSTNAME_EDIT_INPUT.sendKeys(firstName);
        return this;
    }

    public UserProfilePage setLastName(String lastName) {
        LASTNAME_EDIT_INPUT.sendKeys(lastName);
        return this;
    }

    public UserProfilePage setCompanyName(String companyName) {
        COMPANY_EDIT_INPUT.sendKeys(companyName);
        return this;
    }

    public UserProfilePage setPosition(String position) {
        POSITION_EDIT_INPUT.sendKeys(position);
        return this;
    }

    public UserProfilePage setPhoneNumber(String phoneNumber) {
        PHONE_EDIT_INPUT.sendKeys(phoneNumber);
        return this;
    }

    public UserProfilePage verifyFirstName(String expectedFirstName) {
        FIRSTNAME_EDIT_INPUT.shouldHave(text(expectedFirstName));
        return this;
    }

    public UserProfilePage verifyLastName(String expectedLastName) {
        LASTNAME_EDIT_INPUT.shouldHave(text(expectedLastName));
        return this;
    }

    public UserProfilePage verifyCompanyName(String expectedCompanyName) {
        COMPANY_EDIT_INPUT.shouldHave(text(expectedCompanyName));
        return this;
    }

    public UserProfilePage verifyPosition(String expectedPosition) {
        POSITION_EDIT_INPUT.shouldHave(text(expectedPosition));
        return this;
    }

    public UserProfilePage verifyPhoneNumber(String expectedPhoneNumber) {
        PHONE_EDIT_INPUT.shouldHave(text(expectedPhoneNumber));
        return this;
    }
}
