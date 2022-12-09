package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ServicesPage extends BasePage {

    private SelenideElement servicesLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsButton = $(By.xpath("//span[contains(text(),'Contact us')]"));


    public String getWelcomeLabel(){
        return servicesLabel.getText();
    }

    public boolean contactUsButtonVisible(){
        return contactUsButton.isDisplayed();
    }


}
