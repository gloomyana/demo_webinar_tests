package ru.gloomyana.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class TariffsPageTests extends TestBase {

    @Test
    @DisplayName("Successful opening of \"Tariffs\" page")
    void openTariffsPage() {
        step("Open main page", () -> {
            mainPage.openMainPage();
        });
        step("Going to \"Tariffs\" page using header menu", () -> {
            mainPage.clickOnHeaderMenu(testData.tariffs);
        });
        step("Verify successful opening of \"Tariffs\" page", () -> {
            tariffsPage.verifyTariffsPageOpen(testData.tariffs);
        });
    }

    @MethodSource("ru.gloomyana.tests.TestData#TariffsOptionsForChosenType")
    @ParameterizedTest(name = "Webinar \"{0}\" contains the following tariff options {1}")
    void checkWebinarTariffs(String type, List<String> expectedTariffs) {
        step("Open \"Tariffs\" page", () -> {
            tariffsPage.openTariffsPage();
        });
        step("Choose Webinar tariff type", () -> {
            tariffsPage.chooseWebinarTariffType(type);
        });
        step("Verify that tariff type contains expected options", () -> {
            tariffsPage.verifyTariffsByType(expectedTariffs);
        });
    }
}
