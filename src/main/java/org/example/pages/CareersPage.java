package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CareersPage extends BasePage {

    private SelenideElement workWithUsLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));


    public String getWelcomeLabel(){
        return workWithUsLabel.getText();
    }
}
