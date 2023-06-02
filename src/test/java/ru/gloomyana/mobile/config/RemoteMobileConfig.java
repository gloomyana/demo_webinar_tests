package ru.gloomyana.mobile.config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})

public interface RemoteMobileConfig extends Config {
    @Key("user")
    @DefaultValue("jana_DqB98H")
    String user();

    @Key("key")
    @DefaultValue("CzxWxcxyinxsWrFRkqrP")
    String key();

    @Key("app")
    @DefaultValue("bs://c672300942b555f5a58de62256eacff3a58a0da1")
    String app();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();

    @Key("projectName")
    @DefaultValue("Webinar Mobile App Test")
    String projectName();

    @Key("build")
    @DefaultValue("browserstack-build-test")
    String buildName();

    @Key("name")
    @DefaultValue("android test")
    String testName();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String baseUrl();
}
