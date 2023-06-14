package ru.gloomyana.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile-data.properties"
})

public interface GetDataConfig extends Config {
    @Key("passwordRecoveryPageTitle")
    String passwordRecoveryPageTitle();

    @Key("emailSentPageTitle")
    String emailSentPageTitle();

    @Key("eventPageTitle")
    String eventPageTitle();

    @Key("loginPageTitle")
    String loginPageTitle();

    @Key("editUserPageTitle")
    String editUserPageTitle();
}