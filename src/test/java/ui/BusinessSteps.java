package ui;

import io.qameta.allure.Step;
import ui.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class BusinessSteps {

    @Step("Авторизоваться как администратор")
    public void loginAsAdmin(String login, String password) {
        new LoginPage().openPage().login(login, password);
    }

    @Step("Добавить товар '{cardId}' в корзину {times} раз")
    public void addProductToCart(String cardId, int times) {
        for (int i = 0; i < times; i++) $x("//*[@id='" + cardId + "']/button").click();
    }

    @Step("Открыть корзину")
    public void openCart() { $x("//*[@id='open-cart-btn']").click(); }

    @Step("Оформить заказ")
    public void makeOrder() { $x("//*[@id='makeOrder']").click(); }
}