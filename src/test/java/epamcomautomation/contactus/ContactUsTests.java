package epamcomautomation.contactus;

import basetests.BaseTest;
import basetests.EpamBaseTest;
import org.example.pages.ContactUsPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

public class ContactUsTests extends ContactUsBaseTest {

    @Test
    public void contactUsPageOpens() {
        contactUsPage.contactUsPageValidation();
    }

    @Test (dataProvider = "data-provider")
    public void inquiryDropDownListElementsPresence(String data) {
//        contactUsPage.openInquiryList();
        List<String> lista = contactUsPage.inquiryListElements();
//
//        System.out.println(contactUsPage.inquiryListElements());
//
//        System.out.println(contactUsPage.inquiryListElements());
//
        System.out.println(contactUsPage.inquiryListElements());
//        System.out.println(lista);
        Assert.assertTrue(lista.stream().anyMatch(s -> Objects.equals(data, s)));
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"general information request"},
                                {"talk to sales in north america"},
                                {"talk to sales in continental europe"},
                                {"talk to sales in the uk"},
                                {"talk to sales in northern europe"},
                                {"talk to sales in apac"},
                                {"talk to the consulting team"},
                                {"press inquiry"},
                                {"careers"},
                                {"employment verification"},
                                {"partner relations"},
                                {"investor relations"},
                                {"analyst relations"},
                                {"website feedback"}};
    }

    @Test
    public void errorForNotCompletedField() {

    }
}
