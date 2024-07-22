package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AboutPage;

@DisplayName("Страница Компания")
public class xFiveAboutTest extends BaseTest {

    AboutPage aboutPage = new AboutPage();


    @Test
    @Tag("AboutPage")
    @DisplayName("Проверка наличия элементов на странице")
    void aboutTest() {
        aboutPage.openPage("/ru/about/");
        aboutPage.titleBlockCompany("Компания")
                .headerBlockKeyNumbers("Ключевые цифры")
                .headerBlockStrategy("Стратегия")
                .headerBlockForInvestors("Инвесторам")
                .headerBlockNews("Новости");

    }


}

