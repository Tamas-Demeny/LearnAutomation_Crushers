package epamcomautomation.contactus;

import org.example.HelperMethods.SupportMethods;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.testng.annotations.BeforeMethod;

public class ContactUsBaseTest {
    ContactUsPage contactUsPage;

    @BeforeMethod
    public void navigateToContactUsPage() {
        this.contactUsPage = new HomePage().openContactUsPage();

        SupportMethods.dismissCookiesPopUp();
    }
}
