package ru.gloomyana.web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static io.qameta.allure.Allure.step;

@Epic("UI tests webinar.ru")
@Feature("Tariffs page")
@Tag("web")
@Owner("gloomyana")

public class TariffsPageTests extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
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

    @MethodSource("ru.gloomyana.web.tests.TestData#TariffsOptionsForChosenType")
    @Severity(SeverityLevel.NORMAL)
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
