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
public class WFFT_2033 extends CheckAndCareSTSetup {

    @Test(description ="GC01- Verify the option to request another visit flow.")
    @TmsLink("WFFT-2050")
    private void GC01(Method method) throws InterruptedException {

        //Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName()+".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Refused Product Page
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductheader"))
                .withCustomReportMessage("Check Refused Product Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.subHeadlineText_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.text_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProductSubHeadline2"))
                .withCustomReportMessage("Check Refused Product Page SubHeadline2")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.ja_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-JAButton"))
                .withCustomReportMessage("Check Refused Product Page JA Button")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), RefusedProductPage.nein_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RefusedProduct-NeinButton"))
                .withCustomReportMessage("Check Refused Product Page Nein Button")
                .perform();

        new RefusedProductPage(driver).clickOn_JaButton();


        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();
        new CalendarPage(driver).selectAvailableDate();

        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.evening_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".EveningCheckBoxText"))
                .withCustomReportMessage("Check Evening CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.weiter_Button)
                .attribute("disabled")
                .isNotNull()
                .withCustomReportMessage("Check button is disabled")
                .perform();


        new CalendarPage(driver).selectMorningCheck();
        Thread.sleep(200);
        new CalendarPage(driver).clickOn_Weiter();

        // Verify Review Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }



    @Test(description ="GC03- Verify the option to request another visit flow.")
    @TmsLink("WFFT-2052")
    private void GC03(Method method) throws InterruptedException {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Missed Technician Page
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".MissedTechnicianheader"))
                .withCustomReportMessage("Check Missed Technician Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.text_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".MissedTechnicianText"))
                .withCustomReportMessage("Check Missed Technician Page Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MissedTechnicianPage.technikerTerminAussuchen_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TechnikerTerminauswählen"))
                .withCustomReportMessage("Check Missed Technician Button Text")
                .perform();

        new MissedTechnicianPage(driver).clickOn_TechnikerTerminAussuchen();

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
                .element(driver.getDriver(), ReviewDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataheader"))
                .withCustomReportMessage("Check Review Data Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.subHeader_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataFirstText"))
                .withCustomReportMessage("Check Review Data Page First Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.subHeader2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataSecondText"))
                .withCustomReportMessage("Check Review Data Page Second Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.ja_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".JaCheckBox"))
                .withCustomReportMessage("Check Ja CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.nein_CheckBox)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".NeinCheckBox"))
                .withCustomReportMessage("Check Nein CheckBox Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateDateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();


        new ReviewDatePage(driver).clickOn_jaCheckBox();

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.jaCheckBoxAlert_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".JaCheckBoxAlert"))
                .withCustomReportMessage("Check Ja CheckBox Alert Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button2)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate2();

        // Verify Confirmed Date Page
        Thread.sleep(400);
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    @Test(description ="GC04 - Verify first accordion in (Technician cannot reach the house) flow")
    @TmsLink("WFFT-2053")
    private void GC04(Method method) {
        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify APL page
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".APLInfoheader"))
                .withCustomReportMessage("Check APL Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.subHeader_Cl)
                .text()
                .contains(testData.getTestData(method.getName() + ".APLInfoSubheader"))
                .withCustomReportMessage("Check APL Page Sub Header Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.firstAcc_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".FirstAccTitle"))
                .withCustomReportMessage("Check First Accordion Title Text")
                .perform();
        new APLInfoPage(driver)
                .clickOn_firstAcc();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.firstAccInfo_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".FirstAccinfo"))
                .withCustomReportMessage("Check First Accordion Info Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.neuenTerminAussuchen_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminAussuchenButtonTxt"))
                .withCustomReportMessage("Check TerminAussuchen Button Text CL")
                .perform();

        new APLInfoPage(driver).clickOn_NeuenTerminAussuchen();

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
                .element(driver.getDriver(), ReviewDatePage.date_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDateDateCL"))
                .withCustomReportMessage("Check Review Data Page Date Cl")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.confirmDate_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".TerminwahlbestätigenButtonTxt"))
                .withCustomReportMessage("Check Terminwahl bestätigen Button Txt")
                .perform();

        new ReviewDatePage(driver).clickOn_ConfirmDate();

        // Verify Confirmed Date Page
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmedDatePage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmedDateheader"))
                .withCustomReportMessage("Check Confirmed Date Page Header Title")
                .perform();

    }

    @Test(description ="GC05- Verify (Customer not found) flow when address is right")
    @TmsLink("WFFT-2054")
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

        Validations.assertThat()
                .element(driver.getDriver(), ReviewDatePage.klingelschildDrucken_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDataklingelschildDruckenButton"))
                .withCustomReportMessage("Check Review Data Page klingelschild Drucken Btn Text")
                .perform();


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
   @Test(description ="GC06- Verify (Customer not found) flow when address is wrong (Recall)",enabled = false)
    @TmsLink("WFFT-2055")
    private void GC06(Method method) {

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

    /* // the TC not needed for daily pipeline execution
    @Test(description ="GC07 - Verify Recall number Flow in case (TAM 6004)",enabled = false)
    @TmsLink("WFFT-2056")
    private void GC07(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify Recall page
        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Recallheader"))
                .withCustomReportMessage("Check Recall Page Header Title")
                .perform();



        new RecallPage(driver).enterPhoneNumberText(testData.getTestData(method.getName() + ".RecallPhoneNo"));

        Validations.assertThat()
                .element(driver.getDriver(), RecallPage.AbschickenButton2_btn)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallAbschickenBtn"))
                .withCustomReportMessage("Check Recall Abschicken  Button Text")
                .perform();
        new RecallPage(driver).clickOnTerminAuswählenButtonupdated();

        // Verify Recall Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), RecallConfirmationPage.header2_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RecallConfirmationheader"))
                .withCustomReportMessage("Check Recall Confirmation Page Header Title")
                .perform();

    }
     */

    @Test(description ="GC08 || Verify Internet works fine in case Customer has refused production")
    @TmsLink("WFFT-2057")
    private void GC08() {

        // validate Dashboard Headlines
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .contains(DashboardPage.headlineText)
                .withCustomReportMessage("Check That The headline is displayed probably")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.firstSubHeadline_text)
                .text()
                .contains(DashboardPage.firstSubHeadlineText)
                .withCustomReportMessage("Check That The first subheadline is displayed probably")
                .perform();

          /*  Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();*/

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.thirdSubHeadline_text)
                .text()
                .contains(DashboardPage.thirdSubHeadlineText)
                .withCustomReportMessage("Check That The third SubHeadline is displayed probably")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.neinButton_btn)
                .text()
                .contains(DashboardPage.neinButton)
                .withCustomReportMessage("Check That The neinButton is displayed probably")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.jeButton_btn)
                .text()
                .contains(DashboardPage.jeButton)
                .withCustomReportMessage("Check That The jeButton is displayed probably")
                .perform();

        new DashboardPage(driver).clickOnJeButton();

        // validate success page headlines
        Validations.assertThat()
                .element(driver.getDriver(), SuccessPage.headline_text)
                .text()
                .contains(SuccessPage.headlineText)
                .withCustomReportMessage("Check That The headline is displayed probably")
                .perform();
    }

    @Test(description ="GC09 - Verify Second accordion in (Technician cannot reach the house) flow")
    @TmsLink("WFFT-2146")
    private void GC09(Method method) {

        // Verify DashBoard page opened successfully
        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.headline_text)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Dashboardheader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();

        new DashboardPage(driver)
                .clickOnNeinButton();

        // Verify APL page
        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".APLInfoheader"))
                .withCustomReportMessage("Check APL Page Header Title")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.secondAcc_Button)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SecondAccTitle"))
                .withCustomReportMessage("Check Second Accordion Title Text")
                .perform();
        new APLInfoPage(driver)
                .clickOn_secondAcc();

        Validations.assertThat()
                .element(driver.getDriver(), APLInfoPage.secondAccInfo_Cl)
                .text()
                .contains(testData.getTestData(method.getName() + ".SecondAccinfo"))
                .withCustomReportMessage("Check Second Accordion Info Text")
                .perform();


        new APLInfoPage(driver).clickOn_NeuenTerminAussuchen();

        // Verify Calendar page
        Validations.assertThat()
                .element(driver.getDriver(), CalendarPage.header_Cl)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Calendarheader"))
                .withCustomReportMessage("Check Calendar page Header Title")
                .perform();

    }


    }
