package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CheckAndCare.DashboardPage;
import de.vodafone.pages.CheckAndCare.SuccessPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Check And Care")
@Feature("ST")
public class WFFT_1360 extends CheckAndCareSTSetup {

    @Test(description ="GC01 || Verify Internet works fine in case Customer has refused production")
    @TmsLink("WFFT-1448")
    private void GC01_verifyInternetWorksFineInCaseCustomerHasRefusedProduction() {

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

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();

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

    @Test(description ="GC02 || Verify Internet works fine in case Customer not at home")
    @TmsLink("WFFT-1449")
    private void GC02_verifyInternetWorksFineInCaseCustomerNotAtHome() {

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

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();

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
    @Test(description ="GC03 || Verify Internet works fine in case Technician cannot reach the house connection")
    @TmsLink("WFFT-1450")
    private void GC03_verifyInternetWorksFineInCaseTechnicianCannotReachTheHouseConnection() {

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

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();

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

    @Test(description ="GC04 || Verify Internet works fine in case Customer not found")
    @TmsLink("WFFT-1451")
    private void GC04_verifyInternetWorksFineInCaseCustomerNotFound() {

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

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();

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

    @Test(description ="GC08 || Verify Internet works fine in case Other reasons")
    @TmsLink("WFFT-1554")
    private void GC08_verifyInternetWorksFineInCaseOtherReasons() {

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

        Validations.assertThat()
                .element(driver.getDriver(), DashboardPage.secondSubHeadline_text)
                .text()
                .contains(DashboardPage.secondSubHeadlineText)
                .withCustomReportMessage("Check That The second SubHeadline  is displayed probably")
                .perform();

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

}
