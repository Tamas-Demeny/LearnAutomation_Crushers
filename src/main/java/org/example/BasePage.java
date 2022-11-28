package org.example;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {


    public BasePage(){
        String startPage = "https://www.epam.com";
        open(startPage);
    }
}
