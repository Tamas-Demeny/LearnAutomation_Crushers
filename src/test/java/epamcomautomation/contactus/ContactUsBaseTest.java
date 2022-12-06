package epamcomautomation.contactus;

import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.testng.annotations.BeforeTest;

public class ContactUsBaseTest {
    ContactUsPage contactUsPage;

    @BeforeTest
    public void navigateToContactUsPage() {
        this.contactUsPage = new HomePage().openContactUsPage();
    }
}
