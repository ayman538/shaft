package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CheckAndCare.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Check And Care")
@Feature("ST")
public class WFFT_1353 extends CheckAndCareSTSetup {
    @Test(description ="GC01- Verify (Customer not found) flow when address is right")
    @TmsLink("WFFT-1438")
    private void GC01(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Check Address Page
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressheader"))
                .withCustomReportMessage("Verify Check Address Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.SubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressSubHeadline"))
                .withCustomReportMessage("Verify Check Address Page SubHeadline Text")
                .perform();
        /*Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.secondSubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressSecondSubHeadline"))
                .withCustomReportMessage("Verify Check Address Page second SubHeadline Text")
                .perform();*/


        new CheckAddressPage(driver).clickOnJaButton();

        // Verify Confirm Address page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressheader"))
                .withCustomReportMessage("Check Confirm Address Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.firstSubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressSubHeadline"))
                .withCustomReportMessage("Check Confirm Address Page SubHeadline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.secondSubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressSecondSubHeadline"))
                .withCustomReportMessage("Check Confirm Address Page Second SubHeadline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.terminAuswählen_btn)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressTerminAuswählenBtn"))
                .withCustomReportMessage("Check Confirm Address Page TerminAuswählen Button Text")
                .perform();
        new ConfirmAddressPage(driver).clickOnTerminAuswählenButton();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();

        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
       /* Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();*/

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.klingelschildDrucken_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataklingelschildDruckenButton"))
                .withCustomReportMessage("Check Review Data Page klingelschild Drucken Btn Text")
                .perform();

        /*int NoOfTabsOpened = new ReviewDatePage(driver).getNumberOfOpennedTabs();
        new ReviewDatePage(driver).clickOn_KlingelschildDrucken();
        int NoOfTabsOpenedAfterClick = new ReviewDatePage(driver).getNumberOfOpennedTabs();
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
        new ReviewDatePage(driver).SwithToParentWindow();*/

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDate-DateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button3)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate3();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    /* // the TC not needed for daily pipeline execution
    @Test(description ="GC02- Verify (Customer not found) flow when address is wrong (Recall)",enabled = false)
    @TmsLink("WFFT-1439")
    private void GC02(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Check Address Page
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressheader"))
                .withCustomReportMessage("Verify Check Address Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.SubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressSubHeadline"))
                .withCustomReportMessage("Verify Check Address Page SubHeadline Text")
                .perform();

      new CheckAddressPage(driver).clickOnNeinButton();

        // Verify Recall page
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.headline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".Recallheader"))
                .withCustomReportMessage("Check Recall Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.firstSubHeadline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".RecallSubHeadline"))
                .withCustomReportMessage("Check Recall SubHeadline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.secondSubHeadline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".RecallSecondSubHeadline"))
                .withCustomReportMessage("Check Recall Second SubHeadline Title")
                .perform();


        new RecallPage(driver).enterPhoneNumberText(testData.getTestData(method.getName() + ".RecallPhoneNo"));

        new RecallPage(driver).clickOnTerminAuswählenButton();

        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();

    }
    */

    @Test(description ="GC05- Verify (Customer not found) flow when address is right-Add Note")
    @TmsLink("WFFT-1560")
    private void GC05(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Check Address Page
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressheader"))
                .withCustomReportMessage("Verify Check Address Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.SubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressSubHeadline"))
                .withCustomReportMessage("Verify Check Address Page SubHeadline Text")
                .perform();
        /*Validations.assertThat()
                .element(driver.getDriver(), CheckAddressPage.secondSubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CheckAddressSecondSubHeadline"))
                .withCustomReportMessage("Verify Check Address Page second SubHeadline Text")
                .perform();*/


        new CheckAddressPage(driver).clickOnJaButton();

        // Verify Confirm Address page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.headline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".ConfirmAddressheader"))
                .withCustomReportMessage("Check Confirm Address Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.firstSubHeadline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressSubHeadline"))
                .withCustomReportMessage("Check Confirm Address Page SubHeadline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.secondSubHeadline_text)
                .text()
                .contains(testData.getTestData(method.getName() + ".ConfirmAddressSecondSubHeadline"))
                .withCustomReportMessage("Check Confirm Address Page Second SubHeadline Title")
                .perform();

        new ConfirmAddressPage(driver).enterAddressNotesText(testData.getTestData(method.getName() + ".ConfirmAddressNotesText"));

        Validations.assertThat()
                .element(driver.getDriver(), ConfirmAddressPage.terminAuswählen_btn)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmAddressTerminAuswählenBtn"))
                .withCustomReportMessage("Check Confirm Address Page TerminAuswählen Button Text")
                .perform();
        new ConfirmAddressPage(driver).clickOnTerminAuswählenButton();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();

        new CalendarPage(driver).selectMorningCheck();
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page


        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.klingelschildDrucken_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataklingelschildDruckenButton"))
                .withCustomReportMessage("Check Review Data Page klingelschild Drucken Btn Text")
                .perform();

        /*int NoOfTabsOpened = new ReviewDatePage(driver).getNumberOfOpennedTabs();
        new ReviewDatePage(driver).clickOn_KlingelschildDrucken();
        int NoOfTabsOpenedAfterClick = new ReviewDatePage(driver).getNumberOfOpennedTabs();
        Validations.assertThat()
                .number(NoOfTabsOpenedAfterClick)
                .isEqualTo(NoOfTabsOpened+1);
        new ReviewDatePage(driver).SwithToParentWindow();*/

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDate-DateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button3)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate3();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }
}
