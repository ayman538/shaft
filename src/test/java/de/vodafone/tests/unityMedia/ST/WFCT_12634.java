package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.Login;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.ConfirmationPage;
import de.vodafone.pages.unityMedia.Rechnungseinstellungen;
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
@Story("WFCT-12634")

public class WFCT_12634 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    Rechnungen rechnungen;
    Rechnungseinstellungen rechnungseinstellungen;
    String cardOrder;
    String newBillingType;
    String radioBtnOrder;
    String creationSuccessfulMessage;
    ConfirmationPage confirmationPage;
    String currentBillingType;
    String dimmedCard;
    String firstBillOption;
    String secondBillOption;
    String firstBillOptionMessage;
    String secondBillOptionMessage;



    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_WFCT_12634_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/WFCT_12634.json");
    }
    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        rechnungseinstellungen = new Rechnungseinstellungen(driver);
        confirmationPage = new ConfirmationPage(driver);
        cardOrder = testData.getTestData(method.getName() + ".cardOrder");
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        newBillingType = testData.getTestData(method.getName() + ".newBillingType");
        radioBtnOrder = testData.getTestData(method.getName() + ".radioBtnOrder");
        creationSuccessfulMessage = testData.getTestData(method.getName() + ".itemizedBillChangedSuccesssfullyMessage");
        currentBillingType = testData.getTestData(method.getName() + ".currentBillingType");
        dimmedCard = testData.getTestData(method.getName() + ".dimmedCard");
        firstBillOption = testData.getTestData(method.getName() + ".firstBillOption");
        secondBillOption = testData.getTestData(method.getName() + ".secondBillOption");
        firstBillOptionMessage = testData.getTestData(method.getName() + ".firstBillOptionMessage");
        secondBillOptionMessage = testData.getTestData(method.getName() + ".secondBillOptionMessage");
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @Test(description = "WFCT-12634 | ST | GC01_Ute User Change The Itemized Bill Option For Phone Number From No Itemized Bill Category To Complete Itemized Bill Category" +
            "(Single Case)")
    @TmsLink("WFCT-6919")
    public void uteUserChangeTheItemizedBillOptionForPhoneNumberFromNoItemizedBillCategoryToCompleteItemizedBillCategory() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten();
        rechnungseinstellungen.assertOnTransactionHeadLineText();
        rechnungseinstellungen.assertOnBlackBoxText();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnCheckBoxHeadLineText();
        rechnungseinstellungen.assertOnCheckBoxBody();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertThatPageRedirectedSuccessfully();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | GC02- Ute user succeeds to change the Itemized bill option for phone number from Complete itemized bill category to limited itemized bill category" +
            "(Single Case)")
    @TmsLink("WFCT-6920")
    public void uteUserSucceedsToChangeTheItemizedBillOptionForPhoneNumberFromCompleteItemizedBillCategoryToLimitedItemizedBillCategory() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten();
        rechnungseinstellungen.assertOnTransactionHeadLineText();
        rechnungseinstellungen.assertOnBlackBoxText();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnCheckBoxHeadLineText();
        rechnungseinstellungen.assertOnCheckBoxBody();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | GC03- Ute user succeeds to change the Itemized bill option for phone number from Limited itemized bill category to no itemized bill category" +
            "(Single Case)")
    @TmsLink("WFCT-6921")
    public void uteUserSucceedsToChangeTheItemizedBillOptionForPhoneNumberFromLimitedItemizedBillCategoryToNoItemizedBillCategory() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten();
        rechnungseinstellungen.assertOnTransactionHeadLineText();
        rechnungseinstellungen.assertOnBlackBoxText();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnCheckBoxHeadLineText();
        rechnungseinstellungen.assertOnCheckBoxBody();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertThatPageRedirectedSuccessfully();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | BC04- Ute user fails to change the itemized bill option for phone number" + "(Single Case)")
    @TmsLink("WFCT-6922")
    public void uteUserFailsToChangeTheItemizedBillOptionForPhoneNumber() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten();
        rechnungseinstellungen.assertOnTransactionHeadLineText();
        rechnungseinstellungen.assertOnBlackBoxText();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnCheckBoxHeadLineText();
        rechnungseinstellungen.assertOnCheckBoxBody();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        rechnungseinstellungen.assertThatPageRedirectedSuccessfully();
        rechnungseinstellungen.assertOnItemizedBillFailureMessage_Body();
        rechnungseinstellungen.assertOnItemizedBillFailureMessage_Headline();
    }

    @Test(description = "WFCT-12634 | ST | GC01- Ute user successes to change the Itemized bill option for phone number from No itemized bill category to complete itemized bill category" +
            "(Multiple Case)")
    @TmsLink("WFCT-6930")
    public void uteUserSuccessesToChangeTheItemizedBillOptionForPhoneNumberFromNoItemizedBillCategoryToCompleteItemizedBillCategory_6465() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten_MultipleCase();
        rechnungseinstellungen.assertOnTransactionHeadLineText_multipleNumbers();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.selectRadioBtn(radioBtnOrder);
        rechnungseinstellungen.clickOnContinueBtn_Weiter();
        rechnungseinstellungen.assertOnTransactionHeadLineText_MultipleNumbers();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | GC02- Ute user successes to change the Itemized bill option for phone number from Complete itemized bill category to limited itemized bill category" +
            "(Multiple Case)&(View Case)")
    @TmsLink("WFCT-6931")
    public void uteUserSuccessesToChangeTheItemizedBillOptionForPhoneNumberFromCompleteItemizedBillCategoryToLimitedItemizedBillCategory_6465() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle_MultipleCase();
        rechnungen.assertOnEinstellungenDescription_MultipleCase();
        rechnungen.assertOnNoItemizedBillFieldExistance();
        rechnungen.assertOnLimitedItemizedBillFieldExistance();
        rechnungen.assertOnCompleteItemizedBillFieldExistance();
        rechnungen.clickOnEditBtn_Bearbeiten_MultipleCase();
        rechnungseinstellungen.assertOnTransactionHeadLineText_multipleNumbers();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.selectRadioBtn(radioBtnOrder);
        rechnungseinstellungen.clickOnContinueBtn_Weiter();
        rechnungseinstellungen.assertOnTransactionHeadLineText_MultipleNumbers();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertThatPageRedirectedSuccessfully();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | GC03- Ute user successes to change the Itemized bill option for phone number from Limited itemized bill category to no itemized bill category" +
            "(Multiple Case)&(View Case)")
    @TmsLink("WFCT-6932")
    public void uteUserSuccessesToChangeTheItemizedBillOptionForPhoneNumberFromLimitedItemizedBillCategoryToNoItemizedBillCategory_6465() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle_MultipleCase();
        rechnungen.assertOnEinstellungenDescription_MultipleCase();
        rechnungen.assertOnNoItemizedBillFieldExistance();
        rechnungen.assertOnLimitedItemizedBillFieldExistance();
        rechnungen.assertOnCompleteItemizedBillFieldExistance();
        rechnungen.clickOnEditBtn_Bearbeiten_MultipleCase();
        rechnungseinstellungen.assertOnTransactionHeadLineText_multipleNumbers();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.selectRadioBtn(radioBtnOrder);
        rechnungseinstellungen.clickOnContinueBtn_Weiter();
        rechnungseinstellungen.assertOnTransactionHeadLineText_MultipleNumbers();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | BC04- Ute user fails to change the itemized bill option for phone number" + "(Multiple Case)")
    @TmsLink("WFCT-6933")
    public void uteUserFailsToChangeTheItemizedBillOptionForPhoneNumber_MultipleCase_6465() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.clickOnEditBtn_Bearbeiten();
        rechnungseinstellungen.assertOnTransactionHeadLineText();
        rechnungseinstellungen.assertOnBlackBoxText();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnCheckBoxHeadLineText();
        rechnungseinstellungen.assertOnCheckBoxBody();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        rechnungseinstellungen.assertThatPageRedirectedSuccessfully();
        rechnungseinstellungen.assertOnItemizedBillFailureMessage_Body();
        rechnungseinstellungen.assertOnItemizedBillFailureMessage_Headline();
    }

    @Test(description = "WFCT-12634 | ST | GC01-Ute user checks Itemized bill Accordion when having one number in no itemized bill category"+
            "(Single View Case)")
    @TmsLink("WFCT-6949")
    public void UteUserChecksItemizedBillAccordionWhenHavingOneNumberInNoItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle();
        rechnungen.assertOnEinstellungenDescription();
        rechnungen.assertOnEinstellungenNumberSettings();
        rechnungen.assertOnBillingType(currentBillingType);
        rechnungen.assertOnEditButtonText();
    }

    @Test(description = "WFCT-12634 | ST | GC02-Ute user checks Itemized bill Accordion when having one number in Limited itemized bill category"+
            "(Single View Case)")
    @TmsLink("WFCT-6950")
    public void UteUserChecksItemizedBillAccordionWhenHavingOneNumberInLimitedItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle();
        rechnungen.assertOnEinstellungenDescription();
        rechnungen.assertOnEinstellungenNumberSettings();
        rechnungen.assertOnBillingType(currentBillingType);
        rechnungen.assertOnEditButtonText();
    }

    @Test(description = "WFCT-12634 | ST | GC03-Ute user checks Itemized bill Accordion when having one number in Complete itemized bill category"+
            "(Single View Case)")
    @TmsLink("WFCT-6951")
    public void UteUserChecksItemizedBillAccordionWhenHavingOneNumberInCompleteItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle();
        rechnungen.assertOnEinstellungenDescription();
        rechnungen.assertOnEinstellungenNumberSettings();
        rechnungen.assertOnBillingType(currentBillingType);
        rechnungen.assertOnEditButtonText();
    }

    @Test(description = "WFCT-12634 | ST | GC05-Ute user checks itemized bill Accordion when having Multiple numbers in Limited itemized bill category"+
            "(Multiple Case)&(View Case)")
    @TmsLink("WFCT-6953")
    public void uteUserChecksItemizedBillAccordionWhenHavingMultipleNumbersInLimitedItemizedBillCategoryToNoItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle_MultipleCase();
        rechnungen.assertOnEinstellungenDescription_MultipleCase();
        rechnungen.assertOnNoItemizedBillFieldExistance();
        rechnungen.assertOnLimitedItemizedBillFieldExistance();
        rechnungen.assertOnCompleteItemizedBillFieldExistance();
        rechnungen.clickOnEditBtn_Bearbeiten_MultipleCase();
        rechnungseinstellungen.assertOnTransactionHeadLineText_multipleNumbers();
        rechnungseinstellungen.selectRadioBtn(radioBtnOrder);
        rechnungseinstellungen.clickOnContinueBtn_Weiter();
        rechnungseinstellungen.assertOnTransactionHeadLineText_MultipleNumbers();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | GC06-Ute user checks itemized bill Accordion when having Multiple numbers in Complete itemized bill category"+
            "(Multiple Case)&(View Case)&(No Numbers at Field Message)")
    @TmsLink("WFCT-6954")
    public void uteUserChecksItemizedBillAccordionWhenHavingMultipleNumbersInCompleteItemizedBillCategoryToLimitedItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnEinstellungenTitle_MultipleCase();
        rechnungen.assertOnEinstellungenDescription_MultipleCase();
        rechnungen.assertOnNoItemizedBillFieldExistance();
        rechnungen.assertOnNoNumbersIncludedInBillOptionFieldMessage(firstBillOption,firstBillOptionMessage);
        rechnungen.assertOnLimitedItemizedBillFieldExistance();
        rechnungen.assertOnNoNumbersIncludedInBillOptionFieldMessage(secondBillOption,secondBillOptionMessage);
        rechnungen.assertOnCompleteItemizedBillFieldExistance();
        rechnungen.clickOnEditBtn_Bearbeiten_MultipleCase();
        rechnungseinstellungen.assertOnTransactionHeadLineText_multipleNumbers();
        rechnungseinstellungen.assertOnPageTitle();
        rechnungseinstellungen.selectRadioBtn(radioBtnOrder);
        rechnungseinstellungen.clickOnContinueBtn_Weiter();
        rechnungseinstellungen.assertOnTransactionHeadLineText_MultipleNumbers();
        rechnungseinstellungen.assertOnCurrentBillTypeThatCanNotBeChosen(dimmedCard);
        rechnungseinstellungen.clickOnItemizedBillCategory(cardOrder);
        rechnungseinstellungen.clickOnCheckBox();
        rechnungseinstellungen.clickOnSaveChangesBtn_ÄnderungenSpeichern();
        confirmationPage.assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase();
        confirmationPage.assertOnAccordionIsCollapsed();
        confirmationPage.expandConfirmationAccordion();
        confirmationPage.assertOnRufnummer();
        confirmationPage.assertOnconfirmationBillingType();
        confirmationPage.assertOnLegalConfirmation();
    }

    @Test(description = "WFCT-12634 | ST | BC09-Ute user checks itemized bill accordion when have no numbers in itemized bill category" + "(Multiple Case)")
    @TmsLink("WFCT-6957")
    public void uteUserChecksItemizedBillAccordionWhenHaveNoNumbersInItemizedBillCategory_5471() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungen.assertOnItemizedBillFailureMessage_Headline();
        rechnungen.assertOnItemizedBillFailureMessage_Body();
    }

}
