package de.vodafone.tests.kableDeutschland.ST;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFCT-13781")

public class WFCT_13781 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineDaten meineDaten;
    BankDetails bankDetails;
    String toolTipCl,iban,sepaMandateCL, errorTitle, errorBody,firstContract;

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineDaten = new MeineDaten(driver);
        bankDetails = new BankDetails(driver);
        toolTipCl = testData.getTestData(method.getName()+".toolTipCl");
        iban = testData.getTestData(method.getName()+".iban");
        sepaMandateCL = testData.getTestData(method.getName()+".sepaMandateCL");
        errorTitle = testData.getTestData(method.getName()+".errorTitle");
        errorBody = testData.getTestData(method.getName()+".errorBody");
        firstContract = testData.getTestData(method.getName()+".firstContract");
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");

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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_13781_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_13781.json");
    }


    @Test(description = "GC01 - Consumer KD user with two referenzKonto updates bank account from button.")
    @TmsLink("WFCT-14940")
    public void GC01_ConsumerKdDUserWithTwoReferenzKontoUpdatesBankAccountFromButton() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.assertOnFirtStepCardNameAndTitle()
                .assertOnOwnerFieldTitleAndDimmed()
                .assertOnIbanFieldTitleAndExistance()
                .assertOnFirstStepSubmitTitle()
                .assertThatFirstStepSubmitIsDimmed();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnPageTitleAndConfirmationMessage();
    }

    @Test(description = "GC02 - Soho KD user with two referenzKonto updates certain bank account for certain referenzkonto from hyperlink.")
    @TmsLink("WFCT-14941")
    public void GC02_SohoKdUserWithTwoContractsAndTwoReferenzKontoUpdatesCertainBankAccountForCertainReferenzkontoFromHyperlink() {
        dashboard.expandContracts(firstContract);
        dashboard.clickMeineDatenTile(firstContract);
        meineDaten.ExpandBankDetailsAccordion();
        bankDetails.clickEditOneByOneInvoicesBtn1()
                .EditFirstInvoiceBankDetails();
        bankDetails.assertOnFirtStepCardNameAndTitle()
                .assertOnOwnerFieldTitleAndDimmed()
                .assertOnIbanFieldTitleAndExistance()
                .assertOnFirstStepSubmitTitle()
                .assertThatFirstStepSubmitIsDimmed();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnMultipleConfirmationMessage();
        bankDetails.expandConfirmationDetailsSection()
                .assertOnRefernzKontoPartExistanceAtMiddleOfConfirmationCard();
    }

    @Test(description = "GC03 - Consumer KD user with one referenzKonto updates bank account from button.")
    @TmsLink("WFCT-14942")
    public void GC03_ConsumerKdUserWithOneReferenzKontoUpdatesBankAccountFromButton() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.assertThatHyperlinkDoesNotExist();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.assertOnFirtStepCardNameAndTitle()
                .assertOnOwnerFieldTitleAndDimmed()
                .assertOnIbanFieldTitleAndExistance()
                .assertOnFirstStepSubmitTitle()
                .assertThatFirstStepSubmitIsDimmed();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnPageTitleAndConfirmationMessage();
        bankDetails.expandConfirmationDetailsSection()
                .assertOnBankDetailsAtConfirmationCard()
                .assertOnConfirmationWarningMessageAtEndOfTheCard();
    }

    @Test(description = "GC04 - Debit KD user with two referenzKonto updates bank account from button.")
    @TmsLink("WFCT-14943")
    public void GC04_DebitKdUserWithTwoReferenzKontoUpdatesBankAccountFromButton() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.assertOnFirtStepCardNameAndTitle()
                .assertOnOwnerFieldTitleAndDimmed()
                .assertOnIbanFieldTitleAndExistance()
                .assertOnFirstStepSubmitTitle()
                .assertThatFirstStepSubmitIsDimmed();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnPageTitleAndConfirmationMessage();
        bankDetails.expandConfirmationDetailsSection()
                .assertOnBankDetailsAtConfirmationCard()
                .assertOnConfirmationWarningMessageAtEndOfTheCard();
    }

    @Test(description = "GC05 - KD user checks BE  failures at updating bank details page")
    @TmsLink("WFCT-14944")
    public void GC05_KdUserChecksBackEndFailuresAtUpdatingBankDetailsPage() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.TypeIbanRegex(iban)
                .SubmitFirstStepOfEditBank()
                .assertOnBackEndErrorMessage(errorTitle, errorBody);
    }

    @Test(description = "GC06 - KD user with one referenzKonto failed to update bank details at confirmation step")
    @TmsLink("WFCT-14945")
    public void GC06_KdUserWithOneReferenzKontoFailedToUpdateBankDetailsAtConfirmationStep() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnServiceFailureMessage(errorTitle, errorBody);
    }

    @Test(description = "GC07 - KD user tries to update bank account for 2 referenzkonto with 2 bank accounts and partially successful change")
    @TmsLink("WFCT-14945")
    public void GC07_KdUserTriesToUpdateBankAccountForTwoReferenzkontoWithTwoBankAccountsAndPartiallySuccessfulChange() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnPartiallySuccessMessage(errorTitle, errorBody);
    }


    @Test(description = "GC08 - KD user enters valid IBAN but not the IBAN in the contract")
    @TmsLink("WFCT-14951")
    public void GC08_KdUserEntersValidIbanButNotTheIbanInTheContract() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.assertOnSepaMandateCheckBoxCL(sepaMandateCL)
                .assertOnSepaMandateToolTip(toolTipCl)
                .checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnIbanDoesNotMatchContractedIban(errorTitle, errorBody);
    }

    @Test(description = "GC09 - KD user with false flag at isModificationOfBankDetailsAllowed checks bankverbindung accordion")
    @TmsLink("WFCT-14954")
    public void GC09_KdUserWithFalseFlagAtIsModificationOfBankDetailsAllowedChecksBankverbindungAccordion() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        bankDetails.assertThatSecondChangeBankDetailsButtonIsDimmed();
    }

    @Test(description = "GC10 - KD user with not returned name at bank details accordion changes his bank details by using name from address")
    @TmsLink("WFCT-15309")
    public void GC10_KdUserWithNotReturnedNameAtBankDetailsAccordionChangesHisBankDetailsByUsingNameFromAddress() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        meineDaten.clickOnChangeBankDetailsButton();
        bankDetails.assertOnOwnerFieldTitle();
        bankDetails.TypeIbanRegex(iban);
        bankDetails.SubmitFirstStepOfEditBank();
        bankDetails.checkSepaMandateCheckBox()
                .SubmitSecondStepOfEditBank();
        bankDetails.assertOnPageTitleAndConfirmationMessage();
    }

    @Test(description = "GC11 - KD user with not returned name at bank details accordion changes his bank details and no name at address to use")
    @TmsLink("WFCT-15310")
    public void GC11_KdUserWithNotReturnedNameAtBankDetailsAccordionChangesHisBankDetailsAndNoNameAtAddressToUse() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        bankDetails.assertThatFirstChangeBankDetailsButtonIsDimmed();
    }

    @Test(description = "GC12 - KD user in dunning tries to change bank details")
    @TmsLink("WFCT-15321")
    public void GC12_KdUserInDunningTriesToChangeBankDetails() {
        dashboard.clickMeineDatenTile();
        meineDaten.ExpandBankDetailsAccordion();
        bankDetails.assertThatFirstChangeBankDetailsButtonIsDimmed();
    }


}
