package org.example.HelperMethods;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SupportMethod {

    static SelenideElement openPage(String name){
        return $(By.xpath("//a[contains(text(),\"Our Work\") and @class=\"top-navigation__item-link\"]"));
    }
}
