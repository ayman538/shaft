package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.Bankverbindung_bearbeiten;
import de.vodafone.pages.unityMedia.MeineDaten;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("UnityMedia")
@Feature("ST")
@Story("WFCT-13466")
public class WFCT_13466 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineDaten meineDaten;
    Bankverbindung_bearbeiten bankDetails;
    String foreignIban;
    String wrongIban;
    String validIban;


    @BeforeMethod()
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);

        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new Bankverbindung_bearbeiten(driver);
        foreignIban = testData.getTestData(method.getName() + ".foreignIban");
        wrongIban = testData.getTestData(method.getName() + ".wrongIban");
        validIban = testData.getTestData(method.getName() + ".validIban");
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_WFCT_13466_CookieSwitcher.json").getTestDataAsMap("$");

        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/WFCT_13466.json");
    }



    @Test(description = "GC01- Ute user without any bank details entered successfully adds his bank details")
    @TmsLink("WFCT-7103")
    public void GC01_UteUserWithoutAnyBankDetailsSuccessfullyAddsHisBankDetails() {
        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.assertOnBankDetailsAccHeader();
        meineDaten.assertOnBankDetailsAccTextBelowHeader();
        meineDaten.assertOnBankDetailsAccText();
        meineDaten.assertOnNoBankDetailsNotificationTitle();
        meineDaten.assertOnNoBankDetailsNotificationDescription();
        meineDaten.assertOnAddBankDetailsButtonCl();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.waits();
        bankDetails.assertThatAddBankDetailsPageTitleIsCorrect();
        bankDetails.assertOnBankDetailsFirstStepTitle();
        bankDetails.assertOnOwnerFieldTitle();
        bankDetails.assertOnIbanInputFieldTitle();
        bankDetails.assertOnBankDetailsFirstStepSubmitButtonText();
        bankDetails.assertThatBankDetailsFirstStepSubmitButtonIsDimmed();
        bankDetails.enterIBAN(validIban);
        bankDetails.assertThatBankDetailsFirstStepSubmitButtonIsClickable();
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.waits();
        bankDetails.assertThatBankDetailsSecondStepTitleIsCorrect();
        bankDetails.assertThatBankDetailsSecondStepHeaderIsCorrect();
        bankDetails.assertThatBankDetailsIbanTitleIsCorrect();
        bankDetails.assertThatBankDetailsBicTitleIsCorrect();
        bankDetails.assertThatBankDetailsBankTitleIsCorrect();
        bankDetails.assertThatBankDetailsOwnerTitleIsCorrect();
        bankDetails.assertThatBankDetailsSecondStepSubmitButtonClIsCorrect();
        bankDetails.assertThatBankDetailsSecondStepSubmitButtonIsDisabled();
        bankDetails.clickOnBankDetailsInfoIcon();
        bankDetails.assertOnInfoIconCL();
        bankDetails.clickOnBankDetailsCheckBox();
        bankDetails.assertThatBankDetailsSecondStepSubmitButtonIsEnabled();
        bankDetails.clickOnEditBankDetailsSecondSubmitButton();
        bankDetails.assertOnBankDetailsSuccessConfirmationMsg();


    }

    @Test(description = "GC02- Ute user fails to add his bank details", enabled=false)
    @TmsLink("WFCT-7104")
    public void GC02_UteUserFailsToAddHisBankDetails() {

        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.enterIBAN(validIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.clickOnBankDetailsCheckBox();
        bankDetails.clickOnEditBankDetailsSecondSubmitButton();
        bankDetails.assertOnBankDetailsFailureMsg();

    }

    @Test(description = "GC03- Ute user tries to add his bank details with a foreign iBan")
    @TmsLink("WFCT-7105")
    public void GC03_UteUserTriesToAddHisBankDetailsWithAForeignIban() {

        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.enterIBAN(foreignIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.assertOnIbanFailureNotificationCl();
        bankDetails.assertOnForeignIbanInlineErrorCl();
    }

    @Test(description = "GC04- Ute user tries to add his bank details with a wrong iban")
    @TmsLink("WFCT-7106")
    public void GC04_UteUserTriesToAddHisBankDetailsWithAWrongIban() {
        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.enterIBAN(wrongIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.assertOnIbanFailureNotificationCl();
        bankDetails.assertOnWrongIbanInlineErrorCl();
    }

    @Test(description = "GC01-Validate that ute dunning user is not eligible to add bank details")
    @TmsLink("WFCT-7596")
    public void GC01_ValidateThatDunningUserIsNotEligibleToAddHisBankDetails() {

        dashboard.clickOnMeineKundenDatenButton();
        meineDaten.clickOnBankAccountSO();
        meineDaten.assertOnDunningUserNotification();
        meineDaten.assertThatAddBankDetailsButtonDoesNotExist();
    }


}
