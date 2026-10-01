package ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ui.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAssert {
    private final LoginPage loginPage;
    public LoginPageAssert(LoginPage loginPage) { this.loginPage = loginPage; }

    @Step("Проверить, что показана ошибка: {expectedText}")
    public LoginPageAssert errorMessageIs(String expectedText) {
        $(".alert.alert-danger")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
        return this;
    }
}