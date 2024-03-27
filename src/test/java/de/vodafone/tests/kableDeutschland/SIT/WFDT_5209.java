package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5209")
public class WFDT_5209 extends SIT_KableDeutschlandSetup{
    @TmsLinks({@TmsLink("WFDT-5279"),@TmsLink("WFDT-5280"),@TmsLink("WFDT-5281"),@TmsLink("WFDT-5282")})
    @Test(description = "GC01 || Given I am a KD contract owner I want to be notified when my contract is terminated so that I would be aware about the reason why I am having a limited functionality.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).validateWarningMessageForTerminatedKDUser();
        new Dashboard(driver).validateMeineRechnungenSO();
        new Dashboard(driver).clickCTAbutton();
        new Dashboard(driver).validateRemoveContractPageTitle();
        new Dashboard(driver).deeplinkToAddressTransaction();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
        new Dashboard(driver).deeplinkToContactDataTransaction();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
        new Dashboard(driver).deeplinkToBankDetailsTransaction();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
        new Dashboard(driver).openMeineRechnungenSO();
        new Dashboard(driver).validateMeineRechnungenPageTitle();
        new Dashboard(driver).deeplinkToMeineKundendaten();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
        new Dashboard(driver).deeplinkToInternet_PhoneProdukte();
        new Dashboard(driver).validateWarningMsgForKIPAndTVTerminatedUser();
        new Dashboard(driver).deeplinkToTVProdukte();
        new Dashboard(driver).validateWarningMsgForKIPAndTVTerminatedUser();
    }

    @TmsLink("WFDT-5284")
    @Test(description = "GC06 || Given I am a multicontract KD contract owner I want to be notified when my contract is terminated so that I would be aware about the reason why I am having a limited functionality.",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).expandTerminatedSubscriberAccordion();
        new Dashboard(driver).validateWarningMsgForTerminatedUserInMultiContracts();
        new Dashboard(driver).validateCTAButtonInWarningMessageForTerminatedKDUser();
        new Dashboard(driver).validateMeineRechnungenSO();
        new Dashboard(driver).deeplinkToMeineKundendaten();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
        new Dashboard(driver).deeplinkToContactDataTransaction();
        new Dashboard(driver).validateWarningMessageForDeeplinkTerminatedUser();
    }
}
