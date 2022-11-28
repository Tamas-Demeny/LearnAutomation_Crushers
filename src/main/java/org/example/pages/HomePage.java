package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    SelenideElement welcomeLabel = $(By.xpath("//span[contains(text(),\"Engineering the Future\")]"));
    SelenideElement howWeDoItPageButton = $(By.xpath("//a[contains(text(),\"How We Do It\") and @class=\"top-navigation__item-link\"]"));

    public HomePage(){
    }
    public HomePage open(){
        welcomeLabel.shouldBe(visible);
        return this;
    }

    public String getWelcomLabel(){
        return welcomeLabel.getText();
    }

    public HowWeDoItPage openHowWeDoItPage(){
        howWeDoItPageButton.click();
        return new HowWeDoItPage();
    }

}
