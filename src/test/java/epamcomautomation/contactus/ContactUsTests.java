package epamcomautomation.contactus;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactUsTests extends ContactUsBaseTest {

    @Test
    public void contactUsPageOpens() {
        contactUsPage.contactUsPageValidation();
    }

    @Test
    public void inquiryDropDownListElementsPresence() {
        contactUsPage.clickButton(contactUsPage.inquiryDropDownList);

        List<String> elementList = contactUsPage.inquiryListElements();

        Assert.assertEquals(elementList.size(), 14);
    }

    @Test
    public void errorForNotCompletedField() {
        contactUsPage.clickButton(contactUsPage.inquiryDropDownList);
        contactUsPage.clickButton(contactUsPage.careersInquiryOption);

        contactUsPage.sendKeys(contactUsPage.lastNameField, "John");
        contactUsPage.sendKeys(contactUsPage.emailField, "john.johnson@yahoo.com");
        contactUsPage.sendKeys(contactUsPage.phoneField, "40757675768");
        contactUsPage.sendKeys(contactUsPage.companyField, "Luxoft");

        contactUsPage.clickButton(contactUsPage.positionDropDownButton);
        contactUsPage.clickButton(contactUsPage.otherPositionOption);

        contactUsPage.clickButton(contactUsPage.locationDropDownButton);
        contactUsPage.clickButton(contactUsPage.romaniaLocationOption);

        contactUsPage.clickButton(contactUsPage.cityDropDownButton);
        contactUsPage.clickButton(contactUsPage.bucharestCityOption);

        contactUsPage.clickButton(contactUsPage.hearAboutEpamDropDownButton);
        contactUsPage.clickButton(contactUsPage.partnerHearAboutOption);

        contactUsPage.clickButton(contactUsPage.submitButton);

        Assert.assertEquals(contactUsPage.missingFieldErrorMessage.getText().toLowerCase(), "this is a required field",
                "The message was: " + contactUsPage.missingFieldErrorMessage.getText());
    }

    @Test
    public void errorMessageAllNotCompletedEssentialFields() {
        contactUsPage.clickButton(contactUsPage.locationDropDownButton);
        contactUsPage.clickButton(contactUsPage.romaniaLocationOption);

        contactUsPage.clickButton(contactUsPage.submitButton);

        Assert.assertEquals(contactUsPage.allErrorMessages.size(), 5);
    }

    @Test
    public void cookieExternalLink() {
        contactUsPage.clickButton(contactUsPage.cookiesPoliciesLink);

        String cookiesUrl = "https://www.epam.com/cookie-policy";
        String currentUrl = WebDriverRunner.url();

        Assert.assertEquals(currentUrl, cookiesUrl);
    }

    @Test
    public void completeFieldsWithError() {
        contactUsPage.clickButton(contactUsPage.submitButton);

        contactUsPage.sendKeys(contactUsPage.firstNameField, "Thomas");
        contactUsPage.sendKeys(contactUsPage.lastNameField, "McCloud");
        contactUsPage.sendKeys(contactUsPage.emailField, "qwerty@yahoo.com");
        contactUsPage.sendKeys(contactUsPage.phoneField, "8787987567");

        contactUsPage.clickButton(contactUsPage.locationDropDownButton);
        contactUsPage.clickButton(contactUsPage.romaniaLocationOption);

        contactUsPage.clickButton(contactUsPage.hearAboutEpamDropDownButton);
        contactUsPage.clickButton(contactUsPage.eventHearAboutOption);

        Assert.assertEquals(contactUsPage.allErrorMessages.size(), 0);
    }

    @Test
    public void invalidEmailInput() {
        contactUsPage.sendKeys(contactUsPage.emailField, "qwer234");
        contactUsPage.clickButton(contactUsPage.phoneField);
        contactUsPage.emailField.hover();

        Assert.assertEquals(contactUsPage.incorrectEmail.getText().toLowerCase(), "incorrect email format");
    }

    @Test
    public void invalidPhoneNumberInput() {
        contactUsPage.sendKeys(contactUsPage.phoneField, "qwerty");
        contactUsPage.clickButton(contactUsPage.emailField);
        contactUsPage.phoneField.hover();

        Assert.assertEquals(contactUsPage.incorrectPhoneNUmber.getText().toLowerCase(),
                "only digits, space, plus, and semicolon are allowed. maximum number of characters is 50.");
    }
}
