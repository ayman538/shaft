package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4360")
public class WFDT_4360 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6050")
    @Test(description = "GC1 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .VerifyPrivacyManagmentAccordionContent();
    }

    @TmsLink("WFDT-6051")
    @Test(description = "GC2 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .clickOnDatenschutzAccordion()
                .clickOnInformationFromVodafoneEditBtn();

        new InformationFromVodafoneSection(driver)
                .validateInformationFromVodafonePermissions()
                .changeInformationFromvodafoneToggels()
                .clickConfirmBtn();

        new ConnectionDataSection(driver).validateSaveChangesMSG();
        new InformationFromVodafoneSection(driver).clickSaveChangesBtn();
        new ConnectionDataSection(driver).validateSuccessMSG();
    }

    @TmsLink("WFDT-6052")
    @Test(description = "GC3 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .clickOnPersonalDataEditBtn()
                .validatePersonalDataPermissions()
                .changePersonalDataPermissions();

        new ConnectionDataSection(driver).validateSuccessMSG();
    }

    @TmsLink("WFDT-6053")
    @Test(description = "GC4 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .clickOnConnectionDataEditBtn();

        new ConnectionDataSection(driver)
                .verifyConnectionDataPermissions()
                .changeConnectionDataPermissions()
                .clickConfrimBtn()
                .validateSaveChangesMSG()
                .clickSaveChangesBtn()
                .validateSuccessMSG();
    }

    @TmsLink("WFDT-6054")
    @Test(description = "GC5 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .clickOnInternetUsageEditBtn();

        new InternetUsageSection(driver)
                .changeInternetUsagePermissions()
                .clickConfrimBtn();

        new ConnectionDataSection(driver).validateSaveChangesMSG();
        new InternetUsageSection(driver).clickSaveChangesBtn();
        new ConnectionDataSection(driver).validateSuccessMSG();

    }

}

