package de.vodafone.tests.Equotation.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Equotation.AllTriesUpErrorPage;
import de.vodafone.pages.Equotation.AuthenticationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Equotation")
@Feature("ST")
public class WFFT_1632 extends EquotationSTSetup {

    //Test
    @Test(description ="GC01-Verify Authentication page in case of incorrect postal code")
    @TmsLink("WFFT-1748")
    private void GC01(Method method) {

        // validate Authentication page Elements

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();

        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".PostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.invalidFormat_ErrorMessage_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".InvalidFormatErrorMsg"))
                .withCustomReportMessage("Check Error Message for invalid format postal Code ").perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();

    }

    @Test(description ="GC02-Verify button & Error Notification behavior in case of user deletes his wrong postal code")
    @TmsLink("WFFT-1749")
    private void GC02(Method method) {

        // validate Authentication page Elements

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();

        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".PostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.invalidFormat_ErrorMessage_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".InvalidFormatErrorMsg"))
                .withCustomReportMessage("Check Error Message for invalid format postal Code ").perform();

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();

        new AuthenticationPage(driver).deletepostalcode();

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.invalidFormat_ErrorMessage_Text)
                .doesNotExist();

    }

    @Test(description ="GC04 - Verify Error page (All tries used up) When enter the wrong zip code 5 times")
    @TmsLink("WFFT-1751")

    private void GC04(Method method) {

        // validate Authentication page Elements

        Validations.assertThat().element(driver.getDriver(), AuthenticationPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();

        new AuthenticationPage(driver).enterpostalcode(testData.getTestData(method.getName() + ".PostalCode"));

        Validations.assertThat()
                .element(driver.getDriver(), AuthenticationPage.submit_Button)
                .attribute("disabled")
                .isNull()
                .withCustomReportMessage("Check button is enabled")
                .perform();

        new AuthenticationPage(driver).navigateToEquotationPortalPage();

        Validations.assertThat().element(driver.getDriver(), AllTriesUpErrorPage.header_Text)
                .textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check All Tries Up Error Page header").perform();

        Validations.assertThat().element(driver.getDriver(), AllTriesUpErrorPage.ErrorTitle_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".AllTriesUpErrorMsg"))
                .withCustomReportMessage("Check All Tries Up Error Messsage Title").perform();

        Validations.assertThat().element(driver.getDriver(), AllTriesUpErrorPage.ErrorContent_Text)
                .text().contains(testData.getTestData(method.getName() + ".AllTriesUpErrorMsgContent"))
                .withCustomReportMessage("Check All Tries Up Error Messsage Content").perform();

    }

}
