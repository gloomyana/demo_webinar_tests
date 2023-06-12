package ru.gloomyana.mobile.helpers;

import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import ru.gloomyana.mobile.config.RemoteMobileConfig;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Attach {

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }


    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        RemoteMobileConfig remoteMobileConfig = ConfigFactory.create(RemoteMobileConfig.class);

        return given()
                .log().all()
                .auth().basic(remoteMobileConfig.user(), remoteMobileConfig.key())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
