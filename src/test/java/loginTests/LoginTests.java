package loginTests;

import basetests.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.example.pages.LearnMainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.testng.Assert.*;



public class LoginTests extends BaseTest {

    @Test(dataProvider = "Log In credentials")
    public void loginViaEmailTest(String email, String password) {
        LearnMainPage page = new LearnMainPage()
                .goToLoginPage()
                .loginViaEmail(email, password);
        assertTrue(page.checkIsLoggedIn(), "Sign out element is not present");
        page.signOut();
    }

    @Test(dataProvider = "Wrong pass credentials")
    public void invalidPassLoginTest(String email, String password) {
        String errorMessage = new LearnMainPage()
                .goToLoginPage()
                .logInWithWrongPassword(email, password);
        assertEquals(errorMessage, "Check your credentials.",
                "Check your credentials message did not appear as expected");
    }

    @Test
    public void nonexistentEmailLoginTest(){
        String accountDetailsHeader = new LearnMainPage()
                .goToLoginPage()
                .logInWithNonexistentEmail("sometandrgkj@something.com");
        assertEquals(accountDetailsHeader, "Account details",
                "Account details section did not load");
    }

    @Test
    public void cannotContinueWithoutEnteringEmailTest(){
        SelenideElement continueIsDisabled = new LearnMainPage()
                .goToLoginPage()
                .checkContinueButtonIsDisabled();
        assertFalse(continueIsDisabled.isEnabled(),"Continue button is enabled when it should not be");
    }


    @Test
    public void logInFromCoursePageTest(){
        assertTrue(new LearnMainPage()
                .dealWithCookies()
                .clickSearchField()
                .goToWebdriverCourse()
                .checkIsOnLoginPage(),
                "User is not redirected to log in page from course page");
    }
    @DataProvider(name = "Log In credentials")
    public Object[][] getData() {
        String email = "deadlinecrushertestemail@gmail.com";
        String password = "SuperSecretPassword1!";
        return new Object[][]{{email, password}};
    }

    @DataProvider(name = "Wrong pass credentials")
    public Object[][] getWrongPassData() {
        String email = "somesortofstandup@gmail.com";
        String password = "qwertznotqwerty";
        return new Object[][]{{email, password}};
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }
}
