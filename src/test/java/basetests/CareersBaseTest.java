package basetests;

import org.example.HelperMethods.SupportMethods;
import org.example.pages.CareersPage;
import org.example.pages.HomePage;
import org.testng.annotations.BeforeMethod;

public class CareersBaseTest {
    CareersPage careersPage;
    @BeforeMethod
    public void navigateToCareersPage(){
        this.careersPage = new HomePage().openCareersPage();
        SupportMethods.dismissCookiesPopUp();
    }
}
