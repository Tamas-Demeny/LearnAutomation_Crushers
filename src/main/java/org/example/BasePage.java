package org.example;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    public void openBasePage(){
        String startPage = "https://www.epam.com";
        open(startPage);
    }
}
