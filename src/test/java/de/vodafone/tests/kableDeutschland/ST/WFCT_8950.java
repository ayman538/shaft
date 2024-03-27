package de.vodafone.tests.kableDeutschland.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.ConfirmationPage;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.Einstellungen;
import de.vodafone.pages.Kabledeutschland.MeineRechnungen;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KabelDeutschland")
@Feature("ST")
@Story("WFCT-8950")
public class WFCT_8950 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    ConfirmationPage confirmationPage;
    String selectedOption;
    String newOption;
    String optionOrder;

    @BeforeMethod()
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        selectedOption = testData.getTestData(method.getName() + ".selectedOption");
        newOption = testData.getTestData(method.getName() + ".newOption");
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        optionOrder = testData.getTestData(method.getName() + ".optionOrder");

        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        confirmationPage = new ConfirmationPage(driver);


        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_8950_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_8950.json");
    }

    @Test(description = "WFCT_8950 | GC01 - Martin user with 'No individual connections' option selected checks einstellungen tab")
    @TmsLink("WFCT-12669")
    public void GC01_MartinUserWithNoIndividualConnectionsOptionChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnPageHeader();
        einstellungen.assertOnPageSubTitle();
        einstellungen.assertOnEditSectionHeader();
        einstellungen.assertOnEditSectionUpperDescription();
        einstellungen.assertOnEditSectionMiddleDescription();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.assertOnBearbeitenBtn();

    }

    @Test(description = "WFCT_8950 | GC02 - Martin user with 'Shortened by the last 3 digits' option selected checks einstellungen tab")
    @TmsLink("WFCT-12670")
    public void GC02_MartinUserWithShortenedByLast3DigitsOptionChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnPageHeader();
        einstellungen.assertOnPageSubTitle();
        einstellungen.assertOnEditSectionHeader();
        einstellungen.assertOnEditSectionUpperDescription();
        einstellungen.assertOnEditSectionMiddleDescription();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.assertOnBearbeitenBtn();
    }

    @Test(description = "WFCT_8950 | GC03 - Martin user with 'Complete' option selected checks einstellungen tab")
    @TmsLink("WFCT-12671")
    public void GC03_MartinUserWithCompleteOptionChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnPageHeader();
        einstellungen.assertOnPageSubTitle();
        einstellungen.assertOnEditSectionHeader();
        einstellungen.assertOnEditSectionUpperDescription();
        einstellungen.assertOnEditSectionMiddleDescription();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.assertOnBearbeitenBtn();
    }

    @Test(description = "WFCT_8950 | GC04 - Martin user changes his itemized bill setting from 'No individual connections' to 'Complete' successfully")
    @TmsLink("WFCT-12672")
    public void GC04_MartinUserChangesItemizedBillSettingFromNoIndividualConnectionsToCompleteSuccessfully() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.clickOnBearbeitenBtn();
        einstellungen.assertOnOptionSectionTitle();
        einstellungen.assertOnBlackMessageText();
        einstellungen.assertThat3OptionsDisplayed();
        einstellungen.assertThatSelectedOptionIsDimmed(optionOrder);
        einstellungen.assertThatCheckboxNotExists();
        einstellungen.clickOnCompleteOption();
        einstellungen.assertOnCheckboxMessageHeader();
        einstellungen.assertOnCheckboxMessageBody();
        einstellungen.assertThatanderungenSpeichernBtnDisabled();
        einstellungen.clickCheckbox();
        einstellungen.cliclOnAnderungenSpeichernBtn();
        confirmationPage.assertOnConsumerSuccessNotification();
        confirmationPage.assertOnAccordionTitle();
        confirmationPage.expandConfirmationAcc();
        confirmationPage.assertOnRufnummerHeaderSectionText();
        confirmationPage.assertOnConsumerRufnummerDescriptionSectionText();
        confirmationPage.assertOnEvnLabel();
        confirmationPage.assertOnEvnDescription(newOption);
        confirmationPage.assertOnMitbenutzerSectionHeaderText();
        confirmationPage.assertOnMitbenutzerSectionDezcriptionText();
    }

    @Test(description = "WFCT_8950 | BC01 - Martin user with a BE error checks einstellungen tab")
    @TmsLink("WFCT-12673")
    public void BC01_MartinUserWithBeErrorChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnPageHeader();
        einstellungen.assertOnPageSubTitle();
        einstellungen.assertOnProductAndItemizedErrorNotificationTitle();
        einstellungen.assertOnProductAndItemizedErrorNotificationBody();
    }

    @Test(description = "WFCT_8950 | BC02 - Martin user fails to change his itemized bill settings")
    @TmsLink("WFCT-12674")
    public void BC02_MartinUserFailsToChangeItemizedBillSettings() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.clickOnBearbeitenBtn();
        einstellungen.assertOnOptionSectionTitle();
        einstellungen.assertOnBlackMessageText();
        einstellungen.assertThat3OptionsDisplayed();
        einstellungen.assertThatCheckboxNotExists();
        einstellungen.clickOnCompleteOption();
        einstellungen.assertOnCheckboxMessageHeader();
        einstellungen.assertOnCheckboxMessageBody();
        einstellungen.assertThatanderungenSpeichernBtnDisabled();
        einstellungen.clickCheckbox();
        einstellungen.cliclOnAnderungenSpeichernBtn();
        confirmationPage.assertOnErrorNotificationDescription();
        confirmationPage.assertOnErrorNotificationTitle();

    }

}
