package de.vodafone.tests.Equotation.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Equotation.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Equotation")
@Feature("ST")
public class WFFT_EquotationRegression extends EquotationSTSetup {
    //Test
    @Test(description ="GC01 - Verify the e-quotation portal when repair order is possible")
    @TmsLink("WFFT-2184")
    private void GC01(Method method) throws InterruptedException {

        // validate Authentication page

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That Authentication header is displayed").perform();

        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".PostalCode"));
        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        // validate Equotation Dashboard page
        Thread.sleep(5000);

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check That Equotation Dashboard header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.orderDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".OrderDetailsSectionHeader"))
                .withCustomReportMessage("Check That Order Details Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.deviceDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceDetailsSectionHeader"))
                .withCustomReportMessage("Check That Device Details Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.deviceName_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceNameCL"))
                .withCustomReportMessage("Check That Device Name CL is displayed").perform();

        new EquotationDashboard(driver).clickOn_ShowMore();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.articleNumber_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ArticleNumberCL"))
                .withCustomReportMessage("Check That Article Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.serialNumber_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SerialNumberCL"))
                .withCustomReportMessage("Check That Serial Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.firstOption_CL)
                .text().contains(testData.getTestData(method.getName() + ".FirstOptionCL"))
                .withCustomReportMessage("Check That First Option CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.secondOption_CL)
                .text().contains(testData.getTestData(method.getName() + ".SecondOptionCL"))
                .withCustomReportMessage("Check That Second Option CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.thirdOption_CL)
                .text().contains(testData.getTestData(method.getName() + ".ThirdOptionCL"))
                .withCustomReportMessage("Check That Third Option CL is displayed").perform();

        new EquotationDashboard(driver).clickOn_FirstOption();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.acceptTerms_CL)
                .text().contains(testData.getTestData(method.getName() + ".AcceptTermsCL"))
                .withCustomReportMessage("Check That Accept Terms CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.submit_BTN)
                .isDisabled().perform();

        new EquotationDashboard(driver).clickOn_AcceptTerms();
        new EquotationDashboard(driver).clickOn_Submit();

        // validate Equotation Confirmation page

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.header_Text)
                .textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check That Confirmation Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.headline_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeadline"))
                .withCustomReportMessage("Check That Confirmation Headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.title_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationMessageTitle"))
                .withCustomReportMessage("Check That Confirmation Message Title is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.content_Text)
                .text().contains(testData.getTestData(method.getName() + ".ConfirmationMessageText"))
                .withCustomReportMessage("Check That Confirmation Message Text is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.custSectionHeader_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".CustSectionHeader"))
                .withCustomReportMessage("Check That Cust Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.deviceName_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceNameCL"))
                .withCustomReportMessage("Check That Device Name CL is displayed").perform();

        new ConfirmationPage(driver).clickOnShowMoreLink();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.imeiNum_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ArticleNumberCL"))
                .withCustomReportMessage("Check That Article Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.serialNum_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SerialNumberCL"))
                .withCustomReportMessage("Check That Serial Number CL is displayed").perform();
    }

    @Test(description ="GC02 - Verify the e-quotation portal when repair order is Not possible")
    @TmsLink("WFFT-2185")
    private void GC02(Method method) throws InterruptedException {

        // validate Authentication page

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That Authentication header is displayed").perform();

        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".PostalCode"));
        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        // validate Equotation Dashboard page
        Thread.sleep(5000);

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check That Equotation Dashboard header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.orderDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".OrderDetailsSectionHeader"))
                .withCustomReportMessage("Check That Order Details Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.deviceDetailsSectionheader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceDetailsSectionHeader"))
                .withCustomReportMessage("Check That Device Details Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.deviceName_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceNameCL"))
                .withCustomReportMessage("Check That Device Name CL is displayed").perform();

        new EquotationDashboard(driver).clickOn_ShowMore();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.articleNumber_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ArticleNumberCL"))
                .withCustomReportMessage("Check That Article Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.serialNumber_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SerialNumberCL"))
                .withCustomReportMessage("Check That Serial Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.notRepairable_FirstOption_CL)
                .text().contains(testData.getTestData(method.getName() + ".NotRepairableFirstOptionCL"))
                .withCustomReportMessage("Check That Not Repairable First Option CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.notRepairable_SecondOption_CL)
                .text().contains(testData.getTestData(method.getName() + ".NotRepairableSecondOptionCL"))
                .withCustomReportMessage("Check That NotRepairable Second Option CL is displayed").perform();


        new EquotationDashboard(driver).clickOn_NotRepairableFirstOption();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.acceptTerms_CL)
                .text().contains(testData.getTestData(method.getName() + ".AcceptTermsCL"))
                .withCustomReportMessage("Check That Accept Terms CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), EquotationDashboard.submit_BTN)
                .isDisabled().perform();

        new EquotationDashboard(driver).clickOn_AcceptTerms();
        new EquotationDashboard(driver).clickOn_Submit();

        // validate Equotation Confirmation page

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.header_Text)
                .textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check That Confirmation Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.headline_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeadline"))
                .withCustomReportMessage("Check That Confirmation Headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.title_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationMessageTitle"))
                .withCustomReportMessage("Check That Confirmation Message Title is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.content_Text)
                .text().contains(testData.getTestData(method.getName() + ".ConfirmationMessageText"))
                .withCustomReportMessage("Check That Confirmation Message Text is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.custSectionHeader_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".CustSectionHeader"))
                .withCustomReportMessage("Check That Cust Section Header is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.deviceName_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DeviceNameCL"))
                .withCustomReportMessage("Check That Device Name CL is displayed").perform();

        new ConfirmationPage(driver).clickOnShowMoreLink();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.imeiNum_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ArticleNumberCL"))
                .withCustomReportMessage("Check That Article Number CL is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), ConfirmationPage.serialNum_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SerialNumberCL"))
                .withCustomReportMessage("Check That Serial Number CL is displayed").perform();
    }

    @Test(description ="GC03 || Verify postal code validations and incorrect postal code")
    @TmsLink("WFFT-2186")
    private void GC03(Method method) throws InterruptedException {


        // first type letters and numbers
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

        // second type letters and special characters
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


        // Third type numbers and specials characters
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

        // fourth type less than 5 digits
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).deletepostalcode();
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

        // fifth type letters only
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).deletepostalcode();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".lettersPostalCode"));

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

        //sixth type incorrect postal code
        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).deletepostalcode();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".IncorrectPostalCode"));



        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.invalidFormat_ErrorMessage_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".InvalidFormatErrorMsg"))
                .withCustomReportMessage("Check error message Text")
                .perform();

    }

    @Test(description ="GC05 || Verify Authentication Page")
    @TmsLink("WFFT-2188")
    private void GC05(Method method) {

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
    @Test(description ="GC07 || Verify AllTriesUpError Page")
    @TmsLink("WFFT-2190")
    private void GC07(Method method) {


        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".blockepostalcode"));


        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        Validations.assertThat()
                .element(driver.getDriver(), AllTriesUpErrorPage.header_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".AllTriesheaderText"))
                .withCustomReportMessage("Check AllTries header error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AllTriesUpErrorPage.ErrorTitle_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".AllTriestitleText"))
                .withCustomReportMessage("Check AllTries title error message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), AllTriesUpErrorPage.ErrorContent_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".AllTriescontentText"))
                .withCustomReportMessage("Check AllTries content error message Text")
                .perform();

    }

    @Test(description ="GC08 || Verify Deadline Expired Error Page")
    @TmsLink("WFFT-2222")
    private void GC08(Method method) {

        new AuthenticationPage(driver).clickOnPostalCodeTextBox();
        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".Expiredpostalcode"));


        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();
        Validations.assertThat()
                .element(driver.getDriver(), DeadlineExpiredErrorPage.header_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ExpiredheaderText"))
                .withCustomReportMessage("Check Expired header Text message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), DeadlineExpiredErrorPage.ErrorTitle_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ExpiredtitleText"))
                .withCustomReportMessage("Check Expired title message Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), DeadlineExpiredErrorPage.ErrorContent_Text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ExpiredcontentText"))
                .withCustomReportMessage("Check Expired content Text message Text")
                .perform();

    }
}
