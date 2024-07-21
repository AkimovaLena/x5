package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage extends BasePage {
    private final SelenideElement titleBlockCompany = $(".hero-company__title"),
            headerBlockKeyNumbers = $("section.key-numbers h2"),
            headerBlockStrategy = $("div.block.strategy").$("header").$("h2"),
            headerBlockForInvestors = $("section.for-investors").$("header").$("h2"),
            headerBlockNews = $("div.news-block").$("h2");

    @Step("Проверка странице содержит заголовок {0}")
    public AboutPage titleBlockCompany(String value) {
        titleBlockCompany.shouldHave(text(value));
        return this;
    }

    @Step("Проверка блок Ключевые цифры содержит заголовок {0}")
    public AboutPage headerBlockKeyNumbers(String value) {
        headerBlockKeyNumbers.shouldHave(text(value));
        return this;
    }

    @Step("Проверка блок Стратегия содержит заголовок {0}")
    public AboutPage headerBlockStrategy(String value) {
        headerBlockStrategy.scrollTo().shouldHave(text(value));
        return this;
    }

    @Step("Проверка блок Инвесторам содержит заголовок {0}")
    public AboutPage headerBlockForInvestors(String value) {
        headerBlockForInvestors.scrollTo().shouldHave(text(value));
        return this;
    }

    @Step("Проверка блок Стратегия содержит заголовок {0}")
    public AboutPage headerBlockNews(String value) {
        headerBlockNews.scrollTo().shouldHave(text(value));
        return this;
    }
}
