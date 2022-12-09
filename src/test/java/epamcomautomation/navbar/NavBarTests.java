package epamcomautomation.navbar;

import basetests.EpamBaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NavBarTests extends EpamBaseTest {


    @Test
    public void homePageTest() throws InterruptedException {
        HomePage hp = new HomePage();

        String welcomeLabel = hp.getWelcomLabel();
        String technologiesLabel = hp.getleadingTechnologiesLabel();

        Assert.assertEquals(welcomeLabel,"Engineering the Future", "Welcome label is not equal");
        Assert.assertTrue(technologiesLabel.contains("leading technology companies"),"Technologies label is not found");

    }

    @Test
    public void servicesPageTest(){
        ServicesPage sp = new HomePage().openServicesPage();

        Assert.assertEquals(sp.getWelcomeLabel(),"Services","Welcome label is not equal");
        Assert.assertTrue(sp.contactUsButtonVisible(),"Contact Us Button is not displayed");

    }

    @Test
    void howWeDoItPageTest(){

        HowWeDoItPage hw = new HomePage().openHowWeDoItPage();

        Assert.assertEquals(hw.getWelcomeLabel(),"How We Do It", "Welcome label is not equal");
        Assert.assertTrue(hw.contactUsButtonVisible(),"Contact Us Button is not displayed");
    }

    @Test
    void ourWorkPageTest(){

        OurWorkPage ow = new HomePage().openOurWorkPage();

        Assert.assertEquals(ow.getWelcomeLabel(),"Our Work","Welcome label is not equal");
        Assert.assertTrue(ow.contactUsButtonVisible(),"Contact Us Button is not displayed");
    }

    @Test
    void aboutUsPageTest(){
        AboutPage ap = new HomePage().openAboutPage();

        Assert.assertEquals(ap.getWelcomeLabel(),"About","Welcome label is not equal");
        Assert.assertTrue(ap.contactUsButtonVisible(),"Contact Us Button is not displayed");
    }

    @Test
    void carrersPageTest(){
        CareersPage cp = new HomePage().openCareersPage();

        Assert.assertEquals(cp.getWelcomeLabel(),"Work with Us", "Welcome label is not equal");

    }

    @Test
    void contactUsPageTest(){
        ContactUsPage cu = new HomePage().openContactUsPage();

        Assert.assertEquals(cu.getWelcomeLabel(),"Contact Us", "Welcome label is not equal");
        Assert.assertTrue(cu.contactUsFormVisible(),"Contact us form is not visible");
    }

    @Test
    void insightsPageTest(){
        InsightsPage ip = new HomePage().openInsightsPage();

        Assert.assertEquals(ip.getFilterByLabel(),"FILTER BY", "Filter by label is not equal");
        Assert.assertTrue(ip.contactUsButtonVisible(),"Contact Us Button should be visible");
    }

    @Test
    void changeLanguagePageTest(){
        ChangeLanguagePage cl = new HomePage().openChangeLanguagePage();

        Assert.assertEquals(cl.getWelcomeLabel(),"SELECT A LANGUAGE", "Select a language is not equal");
        Assert.assertEquals(cl.languageListSize(),11,"Language List size is not equal");
    }

    @Test
    void searchPageTest(){
        SearchPage sp = new HomePage().openSearchPage();

        Assert.assertTrue(sp.searchBoxFormVisible(), "Search box is not visible");
        Assert.assertEquals(sp.findButtonText(),"FIND","Find button text not equal");
    }
}
