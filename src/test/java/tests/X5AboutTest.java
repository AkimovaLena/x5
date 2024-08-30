package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AboutPage;

@DisplayName("Страница Компания")
public class X5AboutTest extends BaseTest {

    AboutPage aboutPage = new AboutPage();


    @Test
    @Owner("Akimova")
    @Tags({@Tag("ui"), @Tag("AboutPage")})
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

