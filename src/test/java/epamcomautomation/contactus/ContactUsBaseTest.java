package epamcomautomation.contactus;

import com.codeborne.selenide.SelenideElement;
import org.example.HelperMethods.SupportMethods;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsBaseTest {
    HomePage homePage;
    ContactUsPage contactUsPage;

    @BeforeMethod
    public void navigateToContactUsPage() {
        this.homePage = new HomePage();

        SupportMethods.dismissCookiesPopUp();

        this.contactUsPage = homePage.openContactUsPage();

        /* Site loads randomly in the middle of the page and the header blocks the elements above/behind it,
        So we need to scroll to the top of the page
         */
        SelenideElement pageTitle = $(By.xpath("//div[@class='title']"));
        pageTitle.scrollIntoView(true);
    }
}
