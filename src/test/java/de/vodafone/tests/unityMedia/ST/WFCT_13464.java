package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("UnityMedia")
@Feature("ST")
@Story("WFCT-13464")

public class WFCT_13464 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    de.vodafone.pages.unityMedia.Dashboard dashboard;
    Bankverbindung_bearbeiten bankverbindungBearbeiten;
    MeineDaten meineDaten;
    String IBAN;

    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_WFCT_13464_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/WFCT_13464.json");
    }

    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard =new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankverbindungBearbeiten = new Bankverbindung_bearbeiten(driver);
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        IBAN = testData.getTestData(method.getName() + ".IBAN");

        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @Test(description = "GC01- Ute user with bank details entered successfully changes his bank details")
    @TmsLink("WFCT-7082")
    public void GC01_UteChangesBankDetailsSuccessfully() {
        dashboard.clickOnMenieKundendaten();
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
    }
    @Test(description = "GC01-Validate that ute dunning user is not eligible to add bank details")
    @TmsLink("WFCT-7596")
    public void GC01_UteDunningUserNotEligibleToAddBankDetails() {
        dashboard.clickOnMenieKundendaten();
        meineDaten.clickOnBankAccountSO();
        meineDaten.waitTillTheDunningNotificationAppears();
        meineDaten.assertThatEditBankDetailsButtonDoesntExist();
        meineDaten.assertOnDunningUserNotification();
    }
    @Test(description = "GC03- Ute user tries to change his bank details with a foreign iban")
    @TmsLink("WFCT-7084")
    public void GC03_UteChangeBankDetailsWithForeignIBAN() {
        dashboard.clickOnMenieKundendaten();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickOnEditBankDetails_Btn();
        bankverbindungBearbeiten.enterIBAN(IBAN);
        bankverbindungBearbeiten.clickOnContinueBtn();
        bankverbindungBearbeiten.assertOnIbanFailureNotificationCl();
    }
    @Test(description = "GC02- Ute user fails to change his bank details")
    @TmsLink("WFCT-7083")
    public void GC02_UteFailsToChangeBankDetails() {
        dashboard.clickOnMenieKundendaten();
        meineDaten.clickOnBankAccountSO();
        meineDaten.clickOnEditBankDetails_Btn();
        bankverbindungBearbeiten.enterIBAN(IBAN);
        bankverbindungBearbeiten.clickOnContinueBtn();
        bankverbindungBearbeiten.clickOnBankDetailsCheckBox();
        bankverbindungBearbeiten.clickOnSaveBtn();
        bankverbindungBearbeiten.assertOnBankDetailsFailureMsg();
    }



}
