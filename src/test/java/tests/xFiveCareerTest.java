package tests;

import com.google.common.collect.Lists;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CareerPage;

@DisplayName("Страница Карьера")
public class xFiveCareerTest extends BaseTest {

    CareerPage careerPage = new CareerPage();


    @Test
    @Tag("CareerPage")
    @DisplayName("Проверка наличия элементов на странице")
    void careerTest() {
        careerPage.openPage("/ru/career/");
        careerPage.titlePage("карьера")
                .headerBanner("Х5 Group — ваш выбор в пользу будущего")
                .contentBanner("Динамичная компания, где вы сами определяете свое будущее и профессиональное развитие. Х5 дает возможности расти как в зрелых бизнесах, так и в стартапах. Решайте амбициозные задачи, достигайте вдохновляющих результатов. Успешны вы – успешна компания.")
                .benefitsTitle(Lists.newArrayList("Стабильность и динамика одновременно", "Условия для достижений", "Возможности для карьеры", "Забота в масштабе страны", "Инновации и дух предпринимательства"));
    }


}

