package ru.gloomyana.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface LocalMobileConfig extends Config {

    @Key("appiumServerUrl")
    String appiumServerUrl();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("appPath")
    String appPath();
}
