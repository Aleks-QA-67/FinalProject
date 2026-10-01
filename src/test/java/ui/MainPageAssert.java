package ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.MainPage;

public class MainPageAssert {
    private final MainPage mainPage;
    public MainPageAssert(MainPage mainPage) { this.mainPage = mainPage; }

    @Step("Проверить заголовок: {expected}")
    public MainPageAssert titleIs(String expected) {
        mainPage.getTitle().shouldHave(Condition.text(expected));
        return this;
    }

    @Step("Проверить, что карточка 1 видна")
    public MainPageAssert card1IsVisible() {
        mainPage.getCard1().shouldBe(Condition.visible);
        return this;
    }
}