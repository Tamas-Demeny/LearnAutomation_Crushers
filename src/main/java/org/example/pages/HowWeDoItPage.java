package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.example.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HowWeDoItPage extends BasePage {


    SelenideElement servicesDescriptionLabel = $("//span[contains(text(),\"By fusing consulting talent with\")]");

    public HowWeDoItPage(){
    }

    public String getLink(){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentUrl;
    }
}
