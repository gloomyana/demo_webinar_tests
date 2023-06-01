package ru.gloomyana.mobile.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface LocalMobileConfig extends Config {

    @Key("appiumServerUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String appiumServerUrl();

    @Key("deviceName")
    @DefaultValue("Pixel 4 API 30")
    String deviceName();

    @Key("platformVersion")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("appPackage")
    @DefaultValue("ru.webinar.mobile")
    String appPackage();

    @Key("appActivity")
    @DefaultValue("ru.webinar.core.presentation.MainActivity")
    String appActivity();

    @Key("appPath")
    @DefaultValue("src/test/resources/apps/ru.webinar.mobile_3.0.0.apk")
    String appPath();
}
