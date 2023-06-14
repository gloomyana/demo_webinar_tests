package ru.gloomyana.mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface RemoteMobileConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("projectName")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("baseUrl")
    String baseUrl();
}
