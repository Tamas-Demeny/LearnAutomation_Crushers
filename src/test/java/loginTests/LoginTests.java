package loginTests;

import basetests.BaseTest;
import org.example.pages.LearnMainPage;
import org.example.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "Log In credentials")
    public void loginViaEmail(String email, String password){
        LearnMainPage mainPage = new LearnMainPage()
                .goToLoginPage()
                .loginViaEmail(email,password);
        assertTrue(mainPage.checkIsLoggedIn(),"Sign out element is not present");
        mainPage.signOut();
    }

    @Test (dataProvider = "Log In credentials")
    public void loginViaFacebook(){

    }

    @DataProvider (name = "Log In credentials")
    public Object[][] getData(){
        String email ="somesortofstandup@gmail.com";
        String email2 = "deadlinecrushertestemail@gmail.com";
        String password = "SuperSecretPassword1!";
        return new Object[][] {{email, password}};
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        clearBrowserCookies();
        closeWebDriver();
    }
}
