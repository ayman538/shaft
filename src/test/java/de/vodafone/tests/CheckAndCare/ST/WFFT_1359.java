/*package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CheckAndCare.DashboardPage;
import de.vodafone.pages.CheckAndCare.RecallConfirmationPage;
import de.vodafone.pages.CheckAndCare.RecallPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Check And Care")
@Feature("ST")
@Test(enabled = false) // the class not needed for daily pipeline execution
public class WFFT_1359 extends CheckAndCareSTSetup {

    @Test(description ="GC01 - Verify Recall number Flow in case (TAM 6004)")
    @TmsLink("WFFT-1444")
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

    @Test(description ="GC05 - Verify Recall number Flow in case (TAM 6008)")
    @TmsLink("WFFT-1616")
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

    @Test(description ="GC06 - Verify Recall number Flow in case (TAM 6010)")
    @TmsLink("WFFT-1617")
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

    @Test(description ="GC07 - Verify Recall number Flow in case (TAM 6013)")
    @TmsLink("WFFT-1618")
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
}
*/