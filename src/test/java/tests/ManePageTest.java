package tests;

import helpers.Attach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tests.data.Language;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ManePageTest extends BaseTest {


    @ParameterizedTest(name = "Переключение языка {0}")
    @EnumSource(Language.class)
    void switchLanguageTest(Language language) {

        open("/"+language.another().nameLower()+"/");
        Attach.screenshotAs("openPege");
        $(".footer__logo-link").click();
        $(".header__lang-switcher").shouldHave(text(language.name()));
        $(".header__lang-switcher").click();
        $(".header__lang-switcher").shouldHave(text(language.another().name()));
        $(".hero-main__logo").$("img").shouldHave(attribute("alt",language.description));

    }
}

