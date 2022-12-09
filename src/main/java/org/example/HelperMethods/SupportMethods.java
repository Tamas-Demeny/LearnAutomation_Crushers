package org.example.HelperMethods;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SupportMethods {

    public static SelenideElement getPage(String name){
        return $(By.xpath("//a[contains(text(),\""+name+"\") and @class=\"top-navigation__item-link\"]"));

    }
    public static void dismissCookiesPopUp() {
        SelenideElement popup = $(By.xpath("//div[@id='onetrust-banner-sdk']"));
        if (popup.isDisplayed()) {
            SelenideElement acceptButton = $(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            acceptButton.click();
        }
        //popup.scrollTo();
    }
}
