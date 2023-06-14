package ru.gloomyana.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile-data.properties"
})

public interface GetDataConfig extends Config {
    @Key("passwordRecoveryPageTitle")
    String getPasswordRecoveryPageTitle();

    @Key("emailSentPageTitle")
    String getEmailSentPageTitle();

    @Key("eventPageTitle")
    String getEventPageTitle();

    @Key("loginPageTitle")
    String getLoginPageTitle();

    @Key("editUserPageTitle")
    String getEditUserPageTitle();
}