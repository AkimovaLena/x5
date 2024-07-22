package tests;

import com.google.common.collect.Lists;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AboutPage;
import pages.CareerPage;
import pages.MainPage;
import tests.data.Language;


public class xFiveTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();
    CareerPage careerPage = new CareerPage();


    @ParameterizedTest(name = "Переключение языка {0}")
    @EnumSource(Language.class)
    @Tag("MainPage")
    @Feature("Главная страница")
    void switchLanguageTest(Language language) {
        mainPage.openPage("/" + language.another().nameLower() + "/");
        mainPage.logoClick()
                .langName(language.name())
                .langSwitcher()
                .langName(language.another().name())
                .tagline(language.description);
    }

    @Feature("Главная страница")
    @Tag("MainPage")
    @ValueSource(strings = {
            "Компания", "Партнёрам", "Акционерам и инвесторам", "Пресс-центр"
    })
    @ParameterizedTest(name = "Наведение на вкладку {0}")
    void howerTabsTest(String nameTab) {

        mainPage.openPage("/ru/");
        mainPage.hoverTab(nameTab)
                .activeTab(nameTab);
    }

    @Feature("Главная страница")
    @Test
    @Tag("MainPage")
    @DisplayName("Проверка наличия всех элементов в футере")
    void footerTest() {

        mainPage.openPage("/ru/");
        mainPage.footerExist()
                .footerLogo("https://www.x5.ru/wp-content/themes/x5/assets/img/colorLogo.svg")
                .footerPhone(Lists.newArrayList("+7 495 662 88 88", "+7 495 789 95 95"))
                .footerAddress("119049, Россия, г. Москва, улица Коровий Вал, 5, стр. 1")
                .footerDate("© 2015-2024 ПАО «Корпоративный центр ИКС 5»");

    }

    @Test
    @Tag("AboutPage")
    @Feature("Страница Компания")
    @DisplayName("Проверка наличия элементов на странице")
    void aboutTest() {
        aboutPage.openPage("/ru/about/");
        aboutPage.titleBlockCompany("Компания")
                .headerBlockKeyNumbers("Ключевые цифры")
                .headerBlockStrategy("Стратегия")
                .headerBlockForInvestors("Инвесторам")
                .headerBlockNews("Новости");

    }

    @Test
    @Tag("CareerPage")
    @Feature("Страница Карьера")
    @DisplayName("Проверка наличия элементов на странице")
    void careerTest() {
        careerPage.openPage("/ru/career/");
        careerPage.titlePage("карьера")
                .headerBanner("Х5 Group — ваш выбор в пользу будущего")
                .contentBanner("Динамичная компания, где вы сами определяете свое будущее и профессиональное развитие. Х5 дает возможности расти как в зрелых бизнесах, так и в стартапах. Решайте амбициозные задачи, достигайте вдохновляющих результатов. Успешны вы – успешна компания.")
                .benefitsTitle(Lists.newArrayList("Стабильность и динамика одновременно", "Условия для достижений", "Возможности для карьеры", "Забота в масштабе страны", "Инновации и дух предпринимательства"));
    }


}

