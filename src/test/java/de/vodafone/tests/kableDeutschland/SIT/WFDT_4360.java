package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4360")
public class WFDT_4360 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-6401")
    @Test(description = "GC01 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .VerifyPrivacyManagmentAccordionContent();
    }

    @TmsLink("WFDT-6057")
    @Test(description = "GC02 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
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

    @TmsLink("WFDT-WFDT-6402")
    @Test(description = "GC03 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .clickOnPersonalDataEditBtn()
                .validatePersonalDataPermissions()
                .changePersonalDataPermissions();

        new ConnectionDataSection(driver).validateSuccessMSG();
    }

    @TmsLink("WFDT-6403")
    @Test(description = "GC04 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
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

    @TmsLink("WFDT-6404")
    @Test(description = "GC05 || Given I am a KD customer I want to be able to easily view the status of my permissions in MeinVodafone at any time and, if necessary, to be able to submit or change them.",groups = {"eCare"})
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

