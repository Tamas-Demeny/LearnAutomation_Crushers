package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class GoogleLoginPage {

    private final SelenideElement emailField = $("[type='email']");
    private final SelenideElement nextButton = $("#identifierNext");
    private final SelenideElement passwordField = $("[type='password']");
    private final SelenideElement passwordNextButton = $("#passwordNext");


    public void loginEmailPassword(String email, String password){
        emailField.sendKeys(email);
        nextButton.click();
        passwordField.sendKeys(password);
        passwordNextButton.click();
    }
}
