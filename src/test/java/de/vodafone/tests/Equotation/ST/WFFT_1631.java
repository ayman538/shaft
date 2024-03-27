package de.vodafone.tests.Equotation.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Equotation.AuthenticationPage;
import de.vodafone.pages.Equotation.EquotationDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Equotation")
@Feature("ST")
public class WFFT_1631 extends EquotationSTSetup {


    //Test
    @Test(description ="GC01 || Verify Authentication Page")
    @TmsLink("WFFT-1736")
    private void GC01(Method method) {

        // validate Authentication page Elements

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();


        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.title_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".titleText"))
                .withCustomReportMessage("Check That title is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.content_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".contentText"))
                .withCustomReportMessage("Check That content is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.postalcode_Text)
                .text().contains(testData.getTestData(method.getName() + ".postalcodeText"))
                .withCustomReportMessage("Check That postal code is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.required_Text)
                .text().contains(testData.getTestData(method.getName() + ".RequiredText"))
                .withCustomReportMessage("Check That submit Text is displayed probabaly i").perform();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.submit_Button)
                .text().isEqualTo(testData.getTestData(method.getName() + ".submitButton"))
                .withCustomReportMessage("Check That submit Text is displayed probabaly ").perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();


    }

    @Test(description ="GC05 || Verify repeated correct format of postal code ")
    @TmsLink("WFFT-1739")
    private void GC05(Method method) throws InterruptedException {

        String authenticationPage = driver.browser().getCurrentURL();
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".RepeatedPostalCode"));
        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();
        Thread.sleep(400);
        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.orderDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".EquotationHeader")).withCustomReportMessage("Check That submit button redirects to Equotation portal ").perform();

        driver.browser().navigateToURL( authenticationPage);

        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".NonRepeatedPostalCode"));
        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();
        Thread.sleep(400);
        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.orderDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".EquotationHeader"))
                .withCustomReportMessage("Check That submit button redirects to Equotation portal ").perform();


    }


    @Test(description ="GC08 || Verify postal code validations ")
    @TmsLink("WFFT-1744")
    private void GC08(Method method) {

        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".WrongPostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.errorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();

    }

    @Test(description ="GC09 || Verify postal code validations ")
    @TmsLink("WFFT-1745")
    private void GC09(Method method) {

        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".WrongPostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.errorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();




    }

    @Test(description ="GC10 || Verify postal code validations ")
    @TmsLink("WFFT-1746")
    private void GC10(Method method) throws InterruptedException {

        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".LettersAndNumbersPostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.errorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();

        // second type
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).deletepostalcode();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".LettersAndSpecialCharactersPostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.errorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();


        Thread.sleep(400);

        // Third type
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).deletepostalcode();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".NumbersAndSpecialCharactersPostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.errorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();






    }


}
