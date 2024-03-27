//package de.vodafone.tests.Solstice.ST;
//import de.vodafone.pages.Solstice.SolsticeDashboard;
//import de.vodafone.pages.Solstice.SolsticeMeineDaten;
//import de.vodafone.pages.Solstice.SolsticePrivacySettings;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.TmsLink;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//@Epic("Solstice")
//@Feature("ST")
//public class WFDT_7997  extends SolsticeSTSetup {
//    SolsticeDashboard dashboard;
//    SolsticeMeineDaten meineDaten;
//    SolsticePrivacySettings privacySettings;
//
//    @TmsLink("WFDT-8108")
//    @Test(description = "GC01 || Sophie - Validate Privacy Management accordion's content")
//    public void GC01 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.clickOnDatenschutzAccordion();
//        meineDaten.validateDatenschutzAccordionContent();
//    }
//
//    @TmsLink("WFDT-8109")
//    @Test(description = "GC02 || Sophie - Validate 'Information von Vodafone' Privacy display and editing settings")
//    public void GC02 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.clickOnInformationFromVodafoneEditBtn();
//        privacySettings.validateInformationFromVFPrivacyPage();
//        privacySettings.switchEmailToggleToON();
//        privacySettings.clickOnChangeBtn();
//        privacySettings.validateConfirmationMessage();
//        privacySettings.clickOnJaBtn();
//        privacySettings.validateSuccessMessage();
//        privacySettings.validateEditedActionDone();
//        privacySettings.validateChangeBtnDisabled();
//    }
//
//    @TmsLink("WFDT-8110")
//    @Test(description = "GC03 || Sophie - Validate 'Persönliche Daten' privacy display and editing settings")
//    public void GC03 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.clickOnPersonalDataEditBtn();
//        privacySettings.validatePersonalDataPrivacyPage();
//        privacySettings.switchPersonalDataToggleToON();
//        privacySettings.clickOnPersonalDataChangeBtn();
//        privacySettings.validatePersonalDataConfirmationMessage();
//        privacySettings.clickOnPersonalDataJaBtn();
//        privacySettings.validateSuccessMessage();
//        privacySettings.validatePersonalDataEditedActionDone();
//        privacySettings.validatePersonalDataChangeBtnDisabled();
//
//    }
//
//    @TmsLink("WFDT-8111")
//    @Test(description = "GC04 || Sophie - Validate 'Verbindungs- und Nutzungsdaten' privacy display and editing settings")
//    public void GC04 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.clickOnInternetUsageEditBtn();
//        privacySettings.validateInternetUsagePrivacyPage();
//        privacySettings.switchInternetUsageToggleToOFF();
//        privacySettings.validateInternetUsageFirstConfirmationMessage();
//        privacySettings.clickOnAcceptBtnOfFirstConfirmationMsg();
//        privacySettings.clickOnInternetUsageChangeBtn();
//        privacySettings.validateInternetUsageSecondConfirmationMessage();
//        privacySettings.clickOnInternetUsageJaBtn();
//        privacySettings.validateSuccessMessage();
//        privacySettings.validateInternetUsageEditedActionNotDone();
//        privacySettings.validateInternetUsageChangeBtnDisabled();
//    }
//
//    @TmsLink("WFDT-8112")
//    @Test(description = "BC01 || Sophie - Validate Service Failure Case of editing in 'Persönliche Daten' Privacy Settings")
//    public void BC01() {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.clickOnPersonalDataEditBtn();
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        meineDaten.clickOnPersonalDataEditBtn();
//        privacySettings.validatePersonalDataPrivacyPage();
//        privacySettings.switchPersonalDataToggleToON();
//        privacySettings.clickOnPersonalDataChangeBtn();
//        privacySettings.validatePersonalDataConfirmationMessage();
//        privacySettings.clickOnPersonalDataJaBtn();
//        privacySettings.validatePersonalDataFailureMessage();
//        privacySettings.validatePersonalDataEditedActionNotDone();
//    }
//
//    @TmsLink("WFDT-8113")
//    @Test(description = "BC02 || Sophie - Validate Privacy Management accordion's content in case of Service Failure")
//    public void BC02 () {
//        dashboard.openMeineKundenDatenTile(SolsticeDashboard.DashboardSmartObject.MEINEKUNDENDATEN);
//        meineDaten.pressOnSmartObject(SolsticeMeineDaten.MeineDatenSmartObjects.DatenschutzAndWerbeeinstellungen);
//        privacySettings.validateGeneralErrorMsg();
//    }
//
//    @BeforeMethod
//    public void setUp(Method method){
//        dashboard =  new SolsticeDashboard(driver);
//        meineDaten = new SolsticeMeineDaten(driver);
//        privacySettings = new SolsticePrivacySettings(driver);
//    }
//    }
