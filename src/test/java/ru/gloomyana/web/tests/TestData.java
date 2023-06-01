package ru.gloomyana.web.tests;

import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class TestData {
    String tariffs = "Тарифы",
            participantButton = "Я участник, ищу мероприятие",
            mainPageTitle = "Webinar Group — экосистема сервисов для всех видов",
            sidebarTitle = "Регистрация участника",
            blogPageDesc = "Про онлайн-технологии для бизнеса, работы и образования от компании Webinar Group",
            signUpPageTitle = "Регистрация в платформе Webinar";

    static Stream<Arguments> TariffsOptionsForChosenType() {
        return Stream.of(
                Arguments.of("Для совещаний",
                        List.of("Meetings Free", "Meetings Basic", "Meetings Pro", "Нужно больше?")),
                Arguments.of("Для маркетинга",
                        List.of("Meetings Free", "Optimum 300", "Pro 500", "Нужно больше?")),
                Arguments.of("Для обучения",
                        List.of("Meetings Free", "Optimum 30", "Pro 150", "Нужно больше?"))
        );
    }

    static Stream<String> blogMenuItems() {
        return Stream.of("Блог", "Кейсы", "Новости", "Инструкции", "Подборки", "Свежие");
    }
}
