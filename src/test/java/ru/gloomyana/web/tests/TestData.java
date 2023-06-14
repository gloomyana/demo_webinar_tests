package ru.gloomyana.web.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.params.provider.*;
import ru.gloomyana.web.config.GetDataConfig;

import java.util.List;
import java.util.stream.Stream;

public class TestData {
    static GetDataConfig config = ConfigFactory.create(GetDataConfig.class, System.getProperties());

    String tariffs = config.getTariffs();
    String participantButtonTitle = config.getParticipantButtonTitle();
    String mainPageTitle = config.getMainPageTitle();
    String sidebarTitle = config.getSidebarTitle();
    String blogPageDesc = config.getBlogPageDesc();
    String signUpPageTitle = config.getSignUpPageTitle();

    static Stream<Arguments> getTariffsOptionsForChosenType() {
        return Stream.of(
                Arguments.of(config.forMeetings(),
                        List.of(config.meetingTariffOptions().split(","))),
                Arguments.of(config.forMarketing(),
                        List.of(config.marketingTariffOptions().split(","))),
                Arguments.of(config.forLearning(),
                        List.of(config.learningTariffOptions().split(",")))
        );
    }

    static Stream<String> getBlogMenuItems() {
        return Stream.of(config.getMenuItems().split(","));
    }
}
