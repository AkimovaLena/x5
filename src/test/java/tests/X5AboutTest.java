package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AboutPage;

@DisplayName("Страница Компания")
public class X5AboutTest extends BaseTest {

    AboutPage aboutPage = new AboutPage();


    @Test
    @Tag("AboutPage")
    @DisplayName("Проверка наличия элементов на странице")
    void checkAboutTest() {
        aboutPage.openPage("/ru/about/");
        aboutPage.checkTitleBlockCompany("Компания")
                .checkHeaderBlockKeyNumbers("Ключевые цифры")
                .checkHeaderBlockStrategy("Стратегия")
                .checkHeaderBlockForInvestors("Инвесторам")
                .checkHeaderBlockNews("Новости");

    }


}

