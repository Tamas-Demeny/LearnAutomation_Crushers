package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PolandHomePage extends BasePage {
    SelenideElement polandPageElement = $(By.xpath("//div[@class=\"tabs__title\"][1]"));

    public PolandHomePage checkIfElementIsPolish(){
        polandPageElement.shouldBe(Condition.partialText("ZAJMUJ"));
        return new PolandHomePage();
    }
}
