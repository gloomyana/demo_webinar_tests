package ru.gloomyana.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:web-data.properties"})

public interface GetDataConfig extends Config {
    @Key("tariffs")
    String getTariffs();

    @Key("participantButtonTitle")
    String getParticipantButtonTitle();

    @Key("mainPageTitle")
    String getMainPageTitle();

    @Key("signUpPageTitle")
    String getSignUpPageTitle();

    @Key("sidebarTitle")
    String getSidebarTitle();

    @Key("blogPageDesc")
    String getBlogPageDesc();

    @Key("menuItems")
    String getMenuItems();

    @Key("forMeetings")
    String forMeetings();

    @Key("forMarketing")
    String forMarketing();

    @Key("forLearning")
    String forLearning();

    @Key("meetingTariffOptions")
    String meetingTariffOptions();

    @Key("marketingTariffOptions")
    String marketingTariffOptions();

    @Key("learningTariffOptions")
    String learningTariffOptions();
}
