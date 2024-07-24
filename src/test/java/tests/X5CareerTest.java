package tests;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CareerPage;

@DisplayName("Страница Карьера")
public class X5CareerTest extends BaseTest {

    CareerPage careerPage = new CareerPage();


    @Test
    @Tag("CareerPage")
    @DisplayName("Проверка наличия элементов на странице")
    void checkCareerTest() {
        careerPage.openPage("/ru/career/");
        careerPage.checkCareerHeader("карьера")
                .checkHeaderBanner("Х5 Group — ваш выбор в пользу будущего")
                .checkContentBanner("Динамичная компания, где вы сами определяете свое будущее и профессиональное развитие. Х5 дает возможности расти как в зрелых бизнесах, так и в стартапах. Решайте амбициозные задачи, достигайте вдохновляющих результатов. Успешны вы – успешна компания.")
                .checkBenefitsTitle(Lists.newArrayList("Стабильность и динамика одновременно", "Условия для достижений", "Возможности для карьеры", "Забота в масштабе страны", "Инновации и дух предпринимательства"));
    }


}

