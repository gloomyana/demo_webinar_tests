package ru.gloomyana.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("browser")
    String getBrowser();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("isRemote")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}
