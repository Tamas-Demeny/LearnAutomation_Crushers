package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AboutPage extends BasePage {

    private SelenideElement howWeDoItLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsButton = $(By.xpath("(//span[contains(text(),'Contact Us')])[1]"));


    public String getWelcomeLabel(){
        return howWeDoItLabel.getText();
    }

    public boolean contactUsButtonVisible(){
        return contactUsButton.shouldBe(Condition.visible).isDisplayed();
    }
}
