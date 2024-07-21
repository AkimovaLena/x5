package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement logo = $(".footer__logo-link"),
            langSwitcher = $(".header__lang-switcher"),
            mainLogo = $(".hero-main__logo").$("img"),
            headerList = $(".header__nav-list"),
            headerActive = $(".header__sub-menu--1-active"),
            footer = $(".footer.block"),
            footerPhone = $(".footer__phone"),
            footerAddressInfo = $(".footer__address").$(".footer__info-item"),
            footerDate = $(".footer.block").$(".footer__date");
    ;

    @Step("Клик по логотипу")
    public MainPage logoClick() {
        logo.click();
        return this;
    }

    @Step("Проверка, что кнопка переключения языка имеет название {0}")
    public MainPage langName(String value) {
        langSwitcher.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что слоган переведен на соответствующий язык")
    public MainPage langSwitcher() {
        langSwitcher.click();
        return this;
    }

    @Step("Проверка, что слоган переведен на соответствующий язык")
    public MainPage tagline(String value) {
        mainLogo.shouldHave(attribute("alt", value));
        return this;
    }

    @Step("Наведение на таб {0}")
    public MainPage hoverTab(String value) {
        headerList.$(withText(value)).hover();
        return this;
    }

    @Step("Проверка вывода меню таба {0}")
    public MainPage activeTab(String value) {
        headerActive.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что футер выводится")
    public MainPage footerExist() {
        footer.should(exist);
        return this;
    }

    @Step("Проверка, что футер сожержит логотим {0}")
    public MainPage footerLogo(String value) {
        footer.$("img").shouldHave(attribute("src", value));
        return this;
    }

    @Step("Проверка, что в футере блок  Корпоративный центр содержит телефоны {0}")
    public MainPage footerPhone(List<String> value) {
        footerPhone.$$(".footer__info-item").shouldHave(textsInAnyOrder(value));
        return this;
    }

    @Step("Проверка, что в футере блок  Адрес содержит {0}")
    public MainPage footerAddress(String value) {
        footerAddressInfo.shouldHave(text(value));
        return this;
    }

    @Step("Проверка, что в футере есть блок  копирайт с данными  {0}")
    public MainPage footerDate(String value) {
        footerDate.shouldHave(text(value));
        return this;
    }


}
