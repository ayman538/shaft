package de.vodafone.tests.eCare.SIT;

import de.vodafone.pages.eCare.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Epic("eCare")
@Feature("SIT")
@Story("WFCT-12050")

public class WFCT_12050 extends SIT_eCareSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    MeinDaten meinDaten;
    EditBankDetails editBankDetails;
    QuickCheck quickCheck;
    ChangeInternetPassword changeInternetPassword;
    String smartObjectNum;
    String contractOrder;
    String actuelleGuthabenSO;
    String actuelleGuthabenAcc;
    String datenSO;
    String datenAcc;
    String mobilBezahlenSO;
    String mobileBezahlenAcc;
    String oldPassword;
    String newPassword;
    String kontoinhaberValue;
    String iBanValue;
    String bicValue;
    String bankValue;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        meinDaten = new MeinDaten(driver);
        editBankDetails = new EditBankDetails(driver);
        quickCheck = new QuickCheck(driver);
        changeInternetPassword = new ChangeInternetPassword(driver);
        smartObjectNum = testData.getTestData(method.getName() + ".smartObjectNum");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        actuelleGuthabenSO = testData.getTestData("actuelleGuthabenSO");
        actuelleGuthabenAcc = testData.getTestData("actuelleGuthabenAcc");
        datenSO = testData.getTestData("datenSO");
        datenAcc = testData.getTestData("datenAcc");
        mobilBezahlenSO = testData.getTestData("mobilBezahlenSO");
        mobileBezahlenAcc = testData.getTestData("mobileBezahlenAcc");
        oldPassword = testData.getTestData("oldPassword");
        newPassword = testData.getTestData("newPassword");
        kontoinhaberValue = testData.getTestData(method.getName() + ".kontoinhaberValue");
        iBanValue = testData.getTestData(method.getName() + ".iBanValue");
        bicValue = testData.getTestData(method.getName() + ".bicValue");
        bankValue = testData.getTestData(method.getName() + ".bankValue");




    }

    @Test(description = "GC01-Meine Rechnungen DSL - Marc User checks Meine Rechnungen Page")
    @TmsLink("WFCT-11647")
    public void GC01_MeineRechnungenDSLMarcUserChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.assertOnSmartObjectsNumber(smartObjectNum);
        meineRechnungen.clickOnBankVerbindungLink();
        meineRechnungen.assertThatUserNavigatedToBankVerbindungPage();
        meineRechnungen.navigateToMeineRechnungenPage();
        meineRechnungen.clickOnDokumenteLink();
        meineRechnungen.assertThatUserNavigatedToDokumentePage();
        meineRechnungen.navigateToMeineRechnungenPage();
        meineRechnungen.clickOnRechnungsAdresseLink();
        meineRechnungen.assertThatUserNavigatedToAdressenAccordion();
    }

    @Test(description = "GC02-Meine Rechnungen DSL - Marc User checks Rechnungsübersicht Accordion in Meine Rechnungen Page")
    @TmsLink("WFCT-11648")
    public void GC02_MeineRechnungenDSLMarcUserChecksRechnungsübersichtAccordionInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.expandRechnungeSubersichtAccordion();
        meineRechnungen.assertThatKontostandSectionExists();
        meineRechnungen.assertThatAktuelleRechnungenSectionExists();
        meineRechnungen.assertThatQuickCheckSectionExists();
        meineRechnungen.assertOnActuelleRechnungenBtnNavigation();
        meineRechnungen.assertOnQuickCheckBtnNavigation();
        meineRechnungen.clickOnEmailAnderenBtn();
        meineRechnungen.assertOnEmailAnderenBtnNavigation();
    }

    @Test(description = "GC03-Meine Rechnungen DSL - Marc User checks Jahresübersicht Accordion in Meine Rechnungen Page")
    @TmsLink("WFCT-11649")
    public void GC03_MeineRechnungenDSLMarcUserChecksJahresübersichtAccordionInMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.expandJahreSubersichtAccordion();
        meineRechnungen.assertOnRechnungDiagramTitle();
        meineRechnungen.assertOnDiagramDescription();
        meineRechnungen.collapseDiagram();
        meineRechnungen.assertOnDiagramCollapseFunction();
        meineRechnungen.assertOnRechnungTableTitle();
        meineRechnungen.assertOnAlleDokumenteNotificationTitle();
        meineRechnungen.assertOnAlleDokumenteNotificationDescription();
        meineRechnungen.assertOnWeitereAnalyseTitle();
        meineRechnungen.assertOnRechnungDruckenBtnNavigation();
        meineRechnungen.assertOnWeiterBtnNavigation();
        meineRechnungen.clickOnAlleDokumenteBtn();
        meineRechnungen.assertOnAlleDokumenteBtnNavigation();
    }

    @Test(description = "GC04-Meine Daten DSL - Marc User checks Meine Daten Page")
    @TmsLink("WFCT-11650")
    public void GC04_MeineDatenDSLMarcUserChecksMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.assertOnSmartObjectsNumber(smartObjectNum);
        meinDaten.assertOnDokumenteLinkNavigation();
        meinDaten.clickRufnummernLink();
        meinDaten.assertOnRufnummernLinkNavigation();
        meinDaten.navigateToMeinDatenPage();
        meinDaten.clickTelefonbucheintragLink();
        meinDaten.assertOnTelefonBucheintragLinkNavigation();
        meinDaten.navigateToMeinDatenPage();
        meinDaten.assertOnTeilnehmerLinkNavigation();
        meinDaten.assertOnEinzugsermaechtigungLinkNavigation();
        meinDaten.assertOnBankverbindungLinkNavigation();

    }

    @Test(description = "GC05-Meine Daten DSL - Marc User checks Kontaktdaten Accordion in Meine Daten Page")
    @TmsLink("WFCT-11651")
    public void GC05_MeineDatenDSLMarcUserChecksKontaktdatenAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandKontaktDatedAcc();
        meinDaten.assertThatKundenKntaktDatenSectionExist();
        meinDaten.assertThatLoginDatenSectionExist();
        meinDaten.assertOnLoginDatenBtnNavigation();
        meinDaten.clickOnKontaktDatenBtn();
        meinDaten.assertOnKontaktDatenBtnNavigation();
    }

    @Test(description = "GC06-Meine Daten DSL - Marc User checks Adressen Accordion in Meine Daten Page")
    @TmsLink("WFCT-11652")
    public void GC06_MeineDatenDSLMarcUserChecksAdressenAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandAdressenAcc();
        meinDaten.assertThatRechnungsAdresseSectionExists();
        meinDaten.assertThatAnschlussAdresseSectionExists();
        meinDaten.assertOnUmzugBtnNavigation();
        meinDaten.clickOnAnderenBtn();
        meinDaten.assertOnAnderenBtnNavigation();
    }

    @Test(description = "GC07-Meine Daten DSL - Marc User checks Vertragsdaten Accordion in Meine Daten Page")
    @TmsLink("WFCT-11653")
    public void GC07_MeineDatenDSLMarcUserChecksVertragsdatenAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandVertragsDatenAccordion();
        meinDaten.assertThatGigaZuhausSectionExists();
        meinDaten.assertThatVodafoneSpracheSectionExists();
        meinDaten.assertThatVodafoneInternetSectionExists();
        meinDaten.clickOnInfoIcon();
        meinDaten.assertOnInfoIconText();
    }

    @Test(description = "GC08-Meine Daten DSL - Marc User checks Bankverbindung Accordion in Meine Daten Page")
    @TmsLink("WFCT-11654")
    public void GC08_MeineDatenDSLMarcUserChecksBankverbindungAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankVerbindungDescriptionText();
        meinDaten.assertOnBankVerbindungTitleText();
        meinDaten.assertThatEinzugsermächtigungSectionExists();
        meinDaten.assertThatBankVerbindungLinkSectionExists();
        meinDaten.clickBankVerbindungLink();
        meinDaten.assertOnBankVerbindungLinkNavigation();

    }

    @Test(description = "GC09-Meine Daten DSL - Marc User checks Kennwort und Zugangsdaten Accordion in Meine Daten Page")
    @TmsLink("WFCT-11655")
    public void GC09_MeineDatenDSLMarcUserChecksKennwortUndZugangsdatenAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandKenwortAccordion();
        meinDaten.assertThatInternetPasswortSectionExists();
        meinDaten.assertThatInstallationCodesSectionExists();
        meinDaten.assertThatInternetZugansDatenSectionExists();
        meinDaten.assertThatKundenKenwortSectionExists();
        meinDaten.assertOnInternetPasswortBtnNavigation();
        meinDaten.assertOnInstallationsCodesBtnNavigation();
        meinDaten.clickOnKundenKenwortBtn();
        meinDaten.assertOnKundenKenwortBtnNavigation();
        meinDaten.clickAbbrechenBtn();
        meinDaten.clickOnInternetZugangsBtn();
        meinDaten.assertOnInternetZugangsBtnNavigation();
    }

    @Test(description = "GC10-Meine Daten DSL - Marc User checks Datenschutz- und Werbeeinstellungen Accordion in Meine Daten Page")
    @TmsLink("WFCT-11656")
    public void GGC10_MeineDatenDSLMarcUserChecksDatenschutzUndWerbeeinstellungenAccordionInMeineDatenPage() {
        dashboard.clickMeineDatenTile();
        meinDaten.expandDatenSchutzAccordion();
        meinDaten.assertThatInformationenVonVodafoneSectionExists();
        meinDaten.assertThatPersonalicheDatenSectionExists();
        meinDaten.assertThatVerbindungsDatenSectionExists();
        meinDaten.assertThatInternetNutzungSectionExists();
        meinDaten.assertThatPersonalicheAngeboteSectionExists();
        meinDaten.clickInformationenVonVodafoneBtn();
        meinDaten.assertOnInformationenVonVodafoneBtnNavigation();
        meinDaten.navigateToDatenSchutzAccordion();
        meinDaten.clickPersonalicheDatenBtn();
        meinDaten.assertOnPersonalicheDatenBtnNavigation();
        meinDaten.navigateToDatenSchutzAccordion();
        meinDaten.clickVerbindungsDatenBtn();
        meinDaten.assertOnVerbindungsDatenBtnNavigation();
        meinDaten.navigateToDatenSchutzAccordion();
        meinDaten.clickInernetNutzungBtn();
        meinDaten.assertOnInternetNutzungBtnNavigation();

    }

    @Test(description = "GC15- MobileBankDetails | Kay Dunning user with saved bank details checks the bank details accordion")
    @TmsLink("WFCT-11661")
    public void GC15_MobileBankDetailsKayDunningUserWithSavedBankDetailsChecksBankDetailsAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.closeNotification();
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankDetailsDescriptionText();
        meinDaten.assertOnBankDetailsHeadLineText();
        meinDaten.assertOnAccOwnerNameLabelText();
        meinDaten.assertOnIbanLabelText();
        meinDaten.assertOnBicLabelText();
        meinDaten.assertOnBankNameLabelText();
        meinDaten.assertOnDirectDebitLabelText();
        meinDaten.assertThatBankDetailsBtnExists();
        meinDaten.assertOnBankDetailsLinkOutNavigation();

    }

    @Test(description = "GC16 - MobileBankDetails | Kay user with saved bank details edits his bank details")
    @TmsLink("WFCT-11662")
    public void GC16_MobileBankDetailsKayUserWithSavedBankDetailsEditsBankDetails() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.clickOnEditBankDetailsBtn();
        editBankDetails.assertOnEditAccTitle();
        editBankDetails.assertOnKontoinhaberLabel();
        editBankDetails.assertOnIbanLabel();
        editBankDetails.clickOnWeiterBtn();
        editBankDetails.assertOnConfirmationTitle();
        editBankDetails.assertOnConfirmationKontoinhaberLabel();
        editBankDetails.assertOnConfirmationIbanLabel();
        editBankDetails.assertOnConfirmationBicLabel();
        editBankDetails.assertOnConfirmationBankLabel();
        editBankDetails.clickCheckBox();
        editBankDetails.clickOnBankVerbindungSpeichernBtn();
        editBankDetails.assertOnGreenNotificationTitleText();
        editBankDetails.assertOnRedNotificationTitleText();
        editBankDetails.assertOnRedNotificationDescriptionText();
        editBankDetails.expandUbersichtAcc();
        editBankDetails.assertOnConfirmationKontoinhaberLabel();
        editBankDetails.assertOnConfirmationIbanLabel();
        editBankDetails.assertOnConfirmationBicLabel();
        editBankDetails.assertOnConfirmationBankLabel();
        editBankDetails.assertOnUbersichtAccDescription();
        editBankDetails.assertOnUbersichtAccNotification();
    }

    @Test(description = "GC17- MobileBankDetails | Marie user with saved bank details checks the bank details accordion")
    @TmsLink("WFCT-11663")
    public void GC17_MobileBankDetailMarieUserWithSavedBankDetailsChecksBankDetailsAccordion() {
        dashboard.clickMeineDatenTile();
        meinDaten.closeNotification();
        meinDaten.expandBankVerveindungAccordion();
        meinDaten.assertOnBankDetailsDescriptionText();
        meinDaten.assertOnBankDetailsHeadLineText();
        meinDaten.assertOnAccOwnerNameLabelText();
        meinDaten.assertOnIbanLabelText();
        meinDaten.assertOnBicLabelText();
        meinDaten.assertOnBankNameLabelText();
        meinDaten.assertOnDirectDebitLabelText();
        meinDaten.assertOnKontoinhaberValue(kontoinhaberValue);
        meinDaten.assertOnIbanValue(iBanValue);
        meinDaten.assertOnBicValue(bicValue);
        meinDaten.assertOnBankValue(bankValue);
        meinDaten.assertThatBankDetailsBtnExists();
        meinDaten.assertOnBankDetailsLinkOutNavigation();
    }


    @Test(description = "GC19- MobileAddresses | Marie user with multiple addresses checks Adressen accordion")
    @TmsLink("WFCT-11665")
    public void GC19_MobileAddressesMarieUserWithMultipleAddressesChecksAdressenAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.closeNotification();
        meinDaten.expandAdressenAcc();
        meinDaten.assertThatSavedAddressesSectionExists();
        meinDaten.assertThatHomeZoneAddressesSectionExists();
        meinDaten.clickOnEditAddressBtn();
        meinDaten.assertOnEditAddressBtnNavigation();

    }

    @Test(description = "GC24-Quick Check - Paul User checks Quick Check page")
    @TmsLink("WFCT-11670")
    public void GC24_QuickCheckPaulUserChecksQuickCheckPage() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.navigateToQuickCheckPage();
        quickCheck.assertOnSmartObjectsNumbre(smartObjectNum);
        quickCheck.clickOnSmartObject(actuelleGuthabenSO);
        quickCheck.clickOnSmartObject(actuelleGuthabenSO);
        quickCheck.assertThatAccordionExpanded(actuelleGuthabenAcc);
        quickCheck.clickOnSmartObject(datenSO);
        quickCheck.clickOnSmartObject(datenSO);
        quickCheck.assertThatAccordionExpanded(datenAcc);
        quickCheck.clickOnSmartObject(mobilBezahlenSO);
        quickCheck.clickOnSmartObject(mobilBezahlenSO);
        quickCheck.assertThatAccordionExpanded(mobileBezahlenAcc);
    }

    @Test(description = "GC25-Quick Check - Paul User checks Guthaben & Aufladehistorie accordion")
    @TmsLink("WFCT-11671")
    public void GC25_QuickCheckPaulUserChecksGuthabenAufladehistorieAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.navigateToQuickCheckPage();
        quickCheck.expandGuthabenAcc();
        quickCheck.assertThatGuthabenSectionExists();
        quickCheck.assertThatAufladungenSectionExists();
        quickCheck.clickOnGuthabenAufladenBtn();
        quickCheck.assertOnGutabenAufladenBtnNavigation();

    }

    @Test(description = "GC26-Quick Check - Paul User checks Daten & Verbrauch accordion")
    @TmsLink("WFCT-11672")
    public void GC26_QuickCheckPaulUserChecksDatenVerbrauchAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.navigateToQuickCheckPage();
        quickCheck.expandDatenAcc();
        quickCheck.assertOnDatenVolumenTitle();
        quickCheck.assertThatDatenCardExists();
    }

    @Test(description = "GC27-Quick Check - Paul User checks Mobiles Bezahlen accordion")
    @TmsLink("WFCT-11673")
    public void GC27_QuickCheckPaulUserChecksMobilesBezahlenAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.navigateToQuickCheckPage();
        quickCheck.expandMobilesBezahlenAcc();
        quickCheck.assertThatTeilnehmerLabelExists();
        quickCheck.assertThatTeilnehmerSectionExists();
        quickCheck.assertThatMobilesBezhalenDropdownExists();
        quickCheck.assertThatEinzelKaufeSectionExists();
        quickCheck.assertThatAbosSectionExists();
        quickCheck.assertOnEinzelKaufeDescriptionText();
        quickCheck.assertOnAbosDescriptionText();
        quickCheck.clickEinstellungenAndernBtn();
        quickCheck.assertOnEinstellungenAnernBtnNavigation();

    }

    @Test(description = "GC28 - MobilePassword | Kay user checks password accordion in Meine Daten page and changes the internet password")
    @TmsLink("WFCT-11655")
    public void GC28_MobilePasswordKayUserChecksPasswordAccordionInMeineDatenPageAndChangesInternetPassword() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.assertThatInternetPasswortSectionExists();
        meinDaten.assertThatKundenKenwortSectionExists();
        meinDaten.assertThatTeilnehmerSectionExists();
        meinDaten.closeNotification();
        meinDaten.expandKenwortAccordion();
        meinDaten.clickInternetPasswortWeiterBtn();
        changeInternetPassword.insertOldPassword(oldPassword);
        changeInternetPassword.insertNewPassword(newPassword);
        changeInternetPassword.repeatNewPassword(newPassword);
        changeInternetPassword.clickSubmitPasswordBtn();
        changeInternetPassword.assertOnNotificationTitle();
        changeInternetPassword.assertOnNotificationDescription();
        changeInternetPassword.clickZuruckBtn();
        changeInternetPassword.assertOnZuruckBtnNavigation();

    }

    @Test(description = "GC29 - MobilePassword | Kay user checks Kunden-Kennwort and Teilnehmer-Kennwort in password accordion")
    @TmsLink("WFCT-11655")
    public void GC29_MobilePasswordKayUserChecksKundenKennwortAndTeilnehmerKennwortInPasswordAccordion() {
        dashboard.expandContract(contractOrder);
        dashboard.clickMeineDatenTile(contractOrder);
        meinDaten.assertThatInternetPasswortSectionExists();
        meinDaten.assertThatKundenKenwortSectionExists();
        meinDaten.assertThatTeilnehmerSectionExists();
        meinDaten.closeNotification();
        meinDaten.expandKenwortAccordion();
        meinDaten.clickOnKundenKenwortBtn();
        meinDaten.assertOnKundenKenwortBtnNavigation();
        meinDaten.navigateToMeinDatenPage();
        meinDaten.expandKenwortAccordion();
        meinDaten.clickTeilnehmerBtn();
        meinDaten.assertOnTeilnehmerBtnNavigation();
    }
}
