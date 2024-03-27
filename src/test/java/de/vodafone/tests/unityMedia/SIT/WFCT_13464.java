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
@Story("WFCT-13464")
public class WFCT_13464 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    de.vodafone.pages.unityMedia.Dashboard dashboard;
    Bankverbindung_bearbeiten bankverbindungBearbeiten;
    Dashboard dashboardCable;

    MeineDaten meineDaten;
    String IBAN;
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

        bankverbindungBearbeiten = new Bankverbindung_bearbeiten(driver);
        meineDaten = new MeineDaten(driver);
        dashboardCable = new Dashboard(driver);
        IBAN = testData.getTestData(method.getName() + ".IBAN");
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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_WFCT_13464_CookieSwitcher.json").getTestDataAsMap("$");

        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/WFCT_13464.json");
    }


    @Test(description = "GC01-Ute user adds new bank details to the already added one and checks bank details accordion")
    @TmsLink("WFCT-7560")
    public void GC01_UteUserAddsNewBankDetailsToTheAlreadyAddedOne() {
        dashboardCable.expandContracts(contractOrder);
        dashboardCable.clickOnMeineDatenTile(contractOrder);
        meineDaten.clickOnBankAccountSO();
        meineDaten.assertOnEditBankDetailsCl();
        meineDaten.clickOnEditBankDetails_Btn();
        bankverbindungBearbeiten.assertThatContinueBtnIsDimmed();
        bankverbindungBearbeiten.enterIBAN(IBAN);
        bankverbindungBearbeiten.clickOnContinueBtn();
        bankverbindungBearbeiten.assertOnCheckBoxCl();
        bankverbindungBearbeiten.assertThatSaveBtnIsDimmed();
        bankverbindungBearbeiten.clickOnBankDetailsCheckBox();
        bankverbindungBearbeiten.clickOnSaveBtn();
        bankverbindungBearbeiten.assertOnBankDetailsSuccessConfirmationMsg();
        bankverbindungBearbeiten.clickOnBackButton();
        meineDaten.waitTillTheChangedBankDetailsNotificationAppears();
        meineDaten.assertOnChangedBankDetailsNotification();
        meineDaten.assertThatEditBankDetailsButtonIsDisabled();
    }
    @Test(description = "GC01-Validate that ute dunning user is not eligible to add bank details")
    @TmsLink("WFCT-7598")
    public void GC01_UteDunningUserNotEligibleToAddBankDetails() {
        dashboardCable.expandContracts(contractOrder);
        dashboardCable.clickOnMeineDatenTile(contractOrder);
        meineDaten.clickOnBankAccountSO();
        meineDaten.waitTillTheDunningNotificationAppears();
        meineDaten.assertOnDunningUserNotification();
    }
}
