package ru.gloomyana.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TariffsPage {
    private final SelenideElement
            tariffsPageTitle = $(".block-title.tariffs__title"),
            webinarTariffTypes = $(".tab-common__list");

    public TariffsPage openTariffsPage() {
        open("https://webinar.ru/tariffs/");
        return this;
    }

    public TariffsPage verifyTariffsPageOpen(String pageTitle) {
        tariffsPageTitle.shouldHave(text(pageTitle));
        return this;
    }

    public TariffsPage chooseWebinarTariffType(String type) {
        webinarTariffTypes.$(byText(type)).click();
        return this;
    }

    public void verifyTariffsByType(List<String> expectedTariffsOptions) {
        ElementsCollection foundCollection = $$(".title__main")
                .shouldHave(sizeGreaterThanOrEqual(4));
        ElementsCollection filteredCollection = foundCollection.filter(visible);
        filteredCollection.shouldHave(texts(expectedTariffsOptions));
    }

}
