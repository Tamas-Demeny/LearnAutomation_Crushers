package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
public class HowWeDoItPage extends BasePage {


    SelenideElement servicesDescriptionLabel = $("//span[contains(text(),\"By fusing consulting talent with\")]");
    private SelenideElement howWeDoItLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsButton = $(By.xpath("//span[contains(text(),'Contact us')]"));


    public String getWelcomeLabel(){
        return howWeDoItLabel.getText();
    }

    public String getLink(){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentUrl;
    }
    public boolean contactUsButtonVisible(){
        return contactUsButton.isDisplayed();
    }
}
