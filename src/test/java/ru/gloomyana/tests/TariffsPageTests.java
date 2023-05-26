package ru.gloomyana.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TariffsPageTests extends TestBase {
    @Test
    void openTariffsPage() {
        mainPage.openMainPage();
        mainPage.clickOnHeaderMenu(testData.tariffs);
        tariffsPage.verifyTariffsPageOpen(testData.tariffs);
    }

    @MethodSource("ru.gloomyana.tests.TestData#TariffsOptionsForChosenType")
    @ParameterizedTest(name = "Webinar \"{0}\" содержит следующие варианты тарифов {1}")
    void checkWebinarTariffs(String type, List<String> expectedTariffs) {
        tariffsPage.openTariffsPage();
        tariffsPage.chooseWebinarTariffType(type);
        tariffsPage.verifyTariffsByType(expectedTariffs);
    }
}
