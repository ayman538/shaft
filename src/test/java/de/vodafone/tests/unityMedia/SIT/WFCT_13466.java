package de.vodafone.tests.unityMedia.SIT;


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
@Feature("SIT")
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
    String contractOrder;

    @BeforeMethod()
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);

        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new Bankverbindung_bearbeiten(driver);
        foreignIban = testData.getTestData(method.getName() + ".foreignIban");
        wrongIban = testData.getTestData(method.getName() + ".wrongIban");
        validIban = testData.getTestData(method.getName() + ".validIban");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_WFCT_13466_CookieSwitcher.json").getTestDataAsMap("$");

        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/WFCT_13466.json");
    }

    @Test(description = "GC01- Ute user without any bank details entered successfully adds his bank details")
    @TmsLink("WFCT-7109")
    public void GC01_UteUserWithoutAnyBankDetailsSuccessfullyAddsHisBankDetails() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meineDaten.clickOnBankAccountSO();
        meineDaten.assertOnBankDetailsAccHeader();
        meineDaten.assertOnBankDetailsAccTextBelowHeader();
        meineDaten.assertOnBankDetailsAccText();
        meineDaten.assertOnNoBankDetailsNotificationTitle();
        meineDaten.assertOnNoBankDetailsNotificationDescription();
        meineDaten.assertOnAddBankDetailsButtonCl();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.assertOnBankDetailsFirstStepTitle();
        bankDetails.assertThatAddBankDetailsPageTitleIsCorrect();
        bankDetails.assertOnIbanInputFieldTitle();
        bankDetails.assertOnBankDetailsFirstStepSubmitButtonText();
        bankDetails.assertThatBankDetailsFirstStepSubmitButtonIsDimmed();
        bankDetails.enterIBAN(validIban);
        bankDetails.assertThatBankDetailsFirstStepSubmitButtonIsClickable();
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.assertThatBankDetailsSecondStepHeaderIsCorrect();
        bankDetails.assertThatBankDetailsSecondStepTitleIsCorrect();
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
        bankDetails.assertThatBankDetailsSuccessConfirmationCardIsNotExpanded();
        bankDetails.expandSuccessConfirmationCard();
        bankDetails.assertOntBankDetailsSuccessConfirmationCardDescription();
        bankDetails.assertThatBankDetailsConfirmationCardOIbanTitleIsCorrect();
        bankDetails.assertThatBankDetailsConfirmationCardOBankTitleIsCorrect();
        bankDetails.assertThatBankDetailsConfirmationCardOBicTitleIsCorrect();
        bankDetails.assertThatBankDetailsConfirmationCardOwnerTitleIsCorrect();


    }

    @Test(description = "GC03- Ute user tries to add his bank details with a foreign iBan")
    @TmsLink("WFCT-7110")
    public void GC03_UteUserTriesToAddHisBankDetailsWithAForeignIban() {

        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickAddBankDetailsButton();
        bankDetails.enterIBAN(foreignIban);
        bankDetails.clickOnEditBankDetailsFirstSubmitButton();
        bankDetails.assertOnIbanFailureNotificationCl();
    }

    @Test(description = "GC01-Validate that ute dunning user is not eligible to add bank details", enabled=false) // test data corrupted
    @TmsLink("WFCT-7598")
    public void GC01_ValidateThatDunningUserIsNotEligibleToAddHisBankDetails() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickOnMeineDatenTile(contractOrder);
        meineDaten.clickOnBankAccountSO();
        meineDaten.assertOnDunningUserNotification();
        meineDaten.assertThatAddBankDetailsButtonDoesNotExist();
    }
}
