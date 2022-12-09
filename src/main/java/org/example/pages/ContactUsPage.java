package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage extends BasePage {

    private SelenideElement contactUsLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsForm = $(By.xpath("//div[@class='form']"));


    public String getWelcomeLabel(){
        return contactUsLabel.getText();
    }

   public boolean contactUsFormVisible(){
        return contactUsForm.isDisplayed();
    }
}
