package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OurWorkPage extends BasePage {

    private SelenideElement ourWorkLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsButton = $(By.xpath("//span[contains(@class,'button__content--desktop')]"));

    public String getWelcomeLabel(){
        return ourWorkLabel.getText();
    }

    public boolean contactUsButtonVisible(){
        return contactUsButton.shouldBe(Condition.visible).isDisplayed();
    }
}
