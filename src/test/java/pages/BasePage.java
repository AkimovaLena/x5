package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    @Step("Открываем открываем {0}")
    public BasePage openPage(String path) {
        open(path);
        return this;
    }

}