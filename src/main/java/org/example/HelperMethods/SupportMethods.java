package org.example.HelperMethods;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SupportMethods {

    public static SelenideElement getPage(String name){
        return $(By.xpath("//a[contains(text(),\""+name+"\") and @class=\"top-navigation__item-link\"]"));

    }
}
