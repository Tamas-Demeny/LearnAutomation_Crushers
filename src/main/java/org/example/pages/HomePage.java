package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    SelenideElement dropDownMenu = $(By.xpath("//div[@class=\"location-selector-ui header__control\"]/button"));
    SelenideElement locationSelectorTitle = $(By.xpath("//strong[@class=\"location-selector__title\"]"));
    SelenideElement globalEnglishLink = $(By.xpath("//a[@class=\"location-selector__link active\"]"));
    SelenideElement hungaryLink = $(By.xpath("//li[@class=\"location-selector__item\"][2]/a"));
    SelenideElement germanLink = $(By.xpath("//li[@class=\"location-selector__item\"][10]/a"));
    public HomePage clickLanguageDropDown() {
        dropDownMenu.click();
        return this;
    }

    public HomePage checkLanguageDropDownVisible() {
        locationSelectorTitle.shouldBe(Condition.visible);
        return this;
    }

    public HomePage checkLanguageDropDownNotVisible() {
        locationSelectorTitle.shouldBe(Condition.hidden);
        return this;
    }

    public HomePage clickGlobalEnglish() {
        globalEnglishLink.click();
        return this;
    }

    public HungaryHomePage clickHungary() {
        hungaryLink.click();
        return new HungaryHomePage();
    }

    public GermanHomePage clickDach(){
        germanLink.click();
        return new GermanHomePage();
    }

}
