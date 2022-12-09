package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InsightsPage extends BasePage {
    private SelenideElement filterByLabel = $(By.xpath("//button[contains(@class,'detail-pages')]"));
    private SelenideElement contactUsButton = $(By.xpath("(//span[contains(text(),'Contact Us')])[1]"));


    public String getFilterByLabel(){
        return filterByLabel.getText();
    }

    public boolean contactUsButtonVisible(){
        return contactUsButton.shouldBe(Condition.visible).isDisplayed();
    }
}
