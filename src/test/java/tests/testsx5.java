package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testsx5 extends BaseTest {

    @Test

    void switchLanguageTest() {

        open("/ru");
        $(".header__lang-switcher").click();
        $(".header__lang-switcher").shouldHave(text("RU"));
        $(".hero-main__logo").$("[alt='For the future']").shouldBe(visible);


    }
}

