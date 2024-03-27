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
@Story("WFCT-13100")
public class WFCT_13100 {
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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_13100_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_13100.json");
    }


    @Test(description = "GC05- Martin user (SOHO) changes his itemized bill setting from \"No individual connections\" to \"Complete\" successfully",enabled = false)
    @TmsLink("WFCT-13168")
    public void GC05_MartinUserSohoChangesItemizedBillSettingFromNoIndividualConnectionsToCompleteSuccessfully() {
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
        confirmationPage.assertOnSohoSuccessNotificationTitle();
        confirmationPage.assertOnSohoSuccessNotificationText();
        confirmationPage.assertOnAccordionTitle();
        confirmationPage.expandConfirmationAcc();
        confirmationPage.assertOnRufnummerHeaderSectionText();
        confirmationPage.assertOnSohoRufnummerDescriptionSectionText();
        confirmationPage.assertOnEvnLabel();
        confirmationPage.assertOnEvnDescription(newOption);
        confirmationPage.assertOnMitbenutzerSectionHeaderText();
        confirmationPage.assertOnMitbenutzerSectionDezcriptionText();
    }


    @Test(description = "GC06- Martin user (SOHO) changes his itemized bill setting from \"No individual connections\" to \" Shortened by the last 3 digits\" successfully",enabled = false)
    @TmsLink("WFCT-13169")
    public void GC06_MartinUserSohoChangesItemizedBillSettingFromNoIndividualConnectionsToShortenedSuccessfully() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.clickOnBearbeitenBtn();
        einstellungen.assertOnOptionSectionTitle();
        einstellungen.assertOnBlackMessageText();
        einstellungen.assertThat3OptionsDisplayed();
        einstellungen.assertThatSelectedOptionIsDimmed(optionOrder);
        einstellungen.assertThatCheckboxNotExists();
        einstellungen.clickOnShortenedOption();
        einstellungen.assertOnCheckboxMessageHeader();
        einstellungen.assertOnCheckboxMessageBody();
        einstellungen.assertThatanderungenSpeichernBtnDisabled();
        einstellungen.clickCheckbox();
        einstellungen.cliclOnAnderungenSpeichernBtn();
        confirmationPage.assertOnSohoSuccessNotificationTitle();
        confirmationPage.assertOnSohoSuccessNotificationText();
        confirmationPage.assertOnAccordionTitle();
        confirmationPage.expandConfirmationAcc();
        confirmationPage.assertOnRufnummerHeaderSectionText();
        confirmationPage.assertOnSohoRufnummerDescriptionSectionText();
        confirmationPage.assertOnEvnLabel();
        confirmationPage.assertOnEvnDescription(newOption);
        confirmationPage.assertOnMitbenutzerSectionHeaderText();
        confirmationPage.assertOnMitbenutzerSectionDezcriptionText();
    }

    @Test(description = "GC07- Martin user (SOHO) changes his itemized bill setting from \"complete\" to \" No individual connections\" successfully",enabled = false)
    @TmsLink("WFCT-13169")
    public void GC07_MartinUserSohoChangesItemizedBillSettingFromCompleteToNoIndividualConnectionsSuccessfully() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnCurrentItemizedBillType(selectedOption);
        einstellungen.clickOnBearbeitenBtn();
        einstellungen.assertOnOptionSectionTitle();
        einstellungen.assertOnBlackMessageText();
        einstellungen.assertThat3OptionsDisplayed();
        einstellungen.assertThatSelectedOptionIsDimmed(optionOrder);
        einstellungen.assertThatCheckboxNotExists();
        einstellungen.clickOnnoIndividualOption();
        einstellungen.assertOnCheckboxMessageHeader();
        einstellungen.assertOnCheckboxMessageBody();
        einstellungen.assertThatanderungenSpeichernBtnDisabled();
        einstellungen.clickCheckbox();
        einstellungen.cliclOnAnderungenSpeichernBtn();
        confirmationPage.assertOnSohoSuccessNotificationTitle();
        confirmationPage.assertOnSohoSuccessNotificationText();
        confirmationPage.assertOnAccordionTitle();
        confirmationPage.expandConfirmationAcc();
        confirmationPage.assertOnRufnummerHeaderSectionText();
        confirmationPage.assertOnSohoRufnummerDescriptionSectionText();
        confirmationPage.assertOnEvnLabel();
        confirmationPage.assertOnEvnDescription(newOption);
        confirmationPage.assertOnMitbenutzerSectionHeaderText();
        confirmationPage.assertOnMitbenutzerSectionDezcriptionText();
    }
}