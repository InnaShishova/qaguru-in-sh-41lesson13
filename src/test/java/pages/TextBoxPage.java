package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            checkName = $("#output #name"),
            checkEmail = $("#output #email"),
            checkCurrentAddress = $("#output #currentAddress"),
            checkPermanentAddress = $("#output #permanentAddress");

    @Step("Открываем страницу Text Box")
    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    @Step("Удаляем баннеры")
    public TextBoxPage removeBanners() {
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
        return this;
    }

    @Step("Вводим имя: {value}")
    public TextBoxPage setFullName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    @Step("Вводим email: {value}")
    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Вводим текущий адрес: {value}")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Вводим постоянный адрес: {value}")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем введенные данные")
    public TextBoxPage checkResult(String name,
                                   String email,
                                   String currentAddress,
                                   String permanentAddress) {

        checkName.shouldHave(text(name));
        checkEmail.shouldHave(text(email));
        checkCurrentAddress.shouldHave(text(currentAddress));
        checkPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }
}