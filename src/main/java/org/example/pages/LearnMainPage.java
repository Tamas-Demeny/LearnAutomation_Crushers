package org.example.pages;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LearnMainPage {
    private WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));

    public HelpAndSupportModule goHelpAndSupportModule(){
        hsButton.click();
        return new HelpAndSupportModule();
    }

}
