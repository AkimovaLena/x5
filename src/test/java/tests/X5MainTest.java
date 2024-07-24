package tests;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import tests.data.Language;

@DisplayName("Главная страница")
public class X5MainTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @ParameterizedTest(name = "Переключение языка {0}")
    @EnumSource(Language.class)
    @Tag("MainPage")
    void switchLanguageTest(Language language) {
        mainPage.openPage("/" + language.another().nameLower() + "/");
        mainPage.clickLogo()
                .checkLangName(language.name())
                .switcherLang()
                .checkLangName(language.another().name())
                .checklangLogo(language.description);
    }

    @Tag("MainPage")
    @ValueSource(strings = {
            "Компания", "Партнёрам", "Акционерам и инвесторам", "Пресс-центр"
    })
    @ParameterizedTest(name = "Наведение на вкладку {0}")
    void hoverTabsTest(String nameTab) {

        mainPage.openPage("/ru/");
        mainPage.hoverTab(nameTab)
                .checkActiveTab(nameTab);
    }

    @Test
    @Tag("MainPage")
    @DisplayName("Проверка наличия всех элементов в футере")
    void checkFooterTest() {

        mainPage.openPage("/ru/");
        mainPage.checkFooterExist()
                .checkFooterLogo("https://www.x5.ru/wp-content/themes/x5/assets/img/colorLogo.svg")
                .checkFooterPhone(Lists.newArrayList("+7 495 662 88 88", "+7 495 789 95 95"))
                .checkFooterAddress("119049, Россия, г. Москва, улица Коровий Вал, 5, стр. 1")
                .checkFooterDate("© 2015-2024 ПАО «Корпоративный центр ИКС 5»");

    }

}

