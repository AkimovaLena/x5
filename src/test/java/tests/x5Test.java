package tests;

import helpers.Attach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.data.Language;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class x5Test extends BaseTest {

    @ParameterizedTest(name = "Переключение языка {0}")
    @EnumSource(Language.class)
    @Tag("MainPage")
    void switchLanguageTest(Language language) {
        open("/" + language.another().nameLower() + "/");
        Attach.screenshotAs("openPege");
        $(".footer__logo-link").click();
        $(".header__lang-switcher")
                .shouldHave(text(language.name()));
        $(".header__lang-switcher").click();
        $(".header__lang-switcher")
                .shouldHave(text(language.another().name()));
        $(".hero-main__logo").$("img")
                .shouldHave(attribute("alt", language.description));
    }

    @Tag("MainPage")
    @ValueSource(strings = {
            "Компания", "Партнёрам", "Акционерам и инвесторам", "Пресс-центр"
    })
    @ParameterizedTest(name = "Наведение на вкладку {0}")
    void howerTabsTest(String nameTab) {
        open("/ru/");
        $(".header__nav-list").$(withText(nameTab)).hover();
        $(".header__sub-menu--1-active").shouldHave(text(nameTab));
    }

    @Test
    @Tag("MainPage")
    void footerTest() {
        open("/ru/");
        $(".footer.block").should(exist);
        $(".footer.block").$("img")
                .shouldHave(attribute("src",
                        "https://www.x5.ru/wp-content/themes/x5/assets/img/colorLogo.svg"));
        $(".footer__phone").$$(".footer__info-item")
                .shouldHave(textsInAnyOrder("+7 495 662 88 88", "+7 495 789 95 95"));
        $(".footer__address").$(".footer__info-item")
                .shouldHave(text("119049, Россия, г. Москва, улица Коровий Вал, 5, стр. 1"));
        $(".footer.block").$(".footer__date")
                .shouldHave(text("© 2015-2024 ПАО «Корпоративный центр ИКС 5»"));
    }

    @Test
    @Tag("AboutPage")
    void aboutTest() {
        open("/ru/about/");
        $(".hero-company__title").shouldHave(text("Компания"));
        $("section.key-numbers h2").shouldHave(text("Ключевые цифры"));
        $("div.block.strategy").scrollTo().$("header").$("h2")
                .shouldHave(text("Стратегия"));
        $("section.for-investors").scrollTo().$("header").$("h2")
                .shouldHave(text("Инвесторам"));
        $("div.news-block").scrollTo().$("h2")
                .shouldHave(text("Новости"));
    }

    @Test
    @Tag("CareerPage")
    void careerTest() {
        open("/ru/career/");
        $(".hero-company__title").shouldHave(text("карьера"));
        $(".large-image-block").$("h2")
                .shouldHave(text("Х5 Group — ваш выбор в пользу будущего"));
        $(".large-image-block").$(".large-image-block__content")
                .shouldHave(text("Динамичная компания, где вы сами определяете свое будущее и профессиональное развитие. Х5 дает возможности расти как в зрелых бизнесах, так и в стартапах. Решайте амбициозные задачи, достигайте вдохновляющих результатов. Успешны вы – успешна компания."));
        $$(".benefits__title").shouldHave(texts("Стабильность и динамика одновременно", "Условия для достижений", "Возможности для карьеры", "Забота в масштабе страны", "Инновации и дух предпринимательства"));

    }


}

