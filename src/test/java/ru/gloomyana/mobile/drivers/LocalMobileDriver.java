package ru.gloomyana.mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.gloomyana.mobile.config.LocalMobileConfig;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalMobileDriver implements WebDriverProvider {
    public static URL getAppiumServerUrl() {
        LocalMobileConfig config = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());
        try {
            return new URL(config.appiumServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        LocalMobileConfig config = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.deviceName())
                .setPlatformVersion(config.platformVersion())
                .setApp(getApp())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getApp() {
        LocalMobileConfig config = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());
        File app = new File(config.appPath());
        return app.getAbsolutePath();
    }
}
