package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareerPage extends BasePage{

    private final SelenideElement title = $(".hero-company__title"),
    headerBanner =  $(".large-image-block").$("h2"),
    contentBanner = $(".large-image-block").$(".large-image-block__content");
    private final  ElementsCollection benefitsTitle =  $$(".benefits__title");

    @Step("Проверка, что страница имеет заголовок {0}")
    public CareerPage checkCareerHeader(String value) {
        title.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что баннер имеет заголовок {0}")
    public CareerPage checkHeaderBanner(String value) {
        headerBanner.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что баннер имеет слоган {0}")
    public CareerPage checkContentBanner(String value) {
        contentBanner.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что содержится список преимуществ")
    public CareerPage checkBenefitsTitle(List<String> value) {
        benefitsTitle.shouldHave(texts(value));
        return this;
    }

}
