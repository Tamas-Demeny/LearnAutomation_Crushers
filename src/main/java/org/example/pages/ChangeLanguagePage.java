package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChangeLanguagePage extends BasePage {

    private SelenideElement selectLanguageLabel = $(By.xpath("(//strong[contains(@class,'location-selector')])[1]"));
    private ElementsCollection languageList = $$(By.xpath("//li[@class = 'location-selector__item']"));

    public String getWelcomeLabel(){
        return selectLanguageLabel.getText();
    }

    public int languageListSize(){
        return languageList.size();
    }
    
    }




}
