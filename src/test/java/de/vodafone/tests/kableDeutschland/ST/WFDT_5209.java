package de.vodafone.tests.kableDeutschland.ST;


import de.vodafone.pages.Kabledeutschland.Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5209")
public class WFDT_5209 extends ST_KableDeutschlandSetup {
    @TmsLinks({@TmsLink("WFDT-5279"),@TmsLink("WFDT-5280"),@TmsLink("WFDT-5281"),@TmsLink("WFDT-5282")})
    @Test(description = "GC01 || Given I am a KD contract owner I want to be notified when my contract is terminated so that I would be aware about the reason why I am having a limited functionality.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver)
                .validateWarningMessageForTerminatedKDUser()
                .validateMeineRechnungenSO()
                .clickCTAbutton()
                .validateRemoveContractPageTitle()
                .deeplinkToAddressTransaction()
                .validateWarningMessageForDeeplinkTerminatedUser()
                .deeplinkToContactDataTransaction()
                .validateWarningMessageForDeeplinkTerminatedUser()
                .deeplinkToBankDetailsTransaction()
                .validateWarningMessageForDeeplinkTerminatedUser()
                .openMeineRechnungenSO()
                .validateMeineRechnungenPageTitle()
                .deeplinkToMeineKundendaten()
                .validateWarningMessageForDeeplinkTerminatedUser()
                .deeplinkToInternet_PhoneProdukte()
                .validateWarningMsgForKIPAndTVTerminatedUser()
                .deeplinkToTVProdukte()
                .validateWarningMsgForKIPAndTVTerminatedUser();
    }

    @TmsLink("WFDT-5284")
    @Test(description = "GC06 || Given I am a multicontract KD contract owner I want to be notified when my contract is terminated so that I would be aware about the reason why I am having a limited functionality.",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver)
                .expandTerminatedSubscriberAccordion()
                .validateWarningMsgForTerminatedUserInMultiContracts()
                .validateCTAButtonInWarningMessageForTerminatedKDUser()
                .validateMeineRechnungenSO()
                .deeplinkToMeineKundendaten()
                .validateWarningMessageForDeeplinkTerminatedUser()
                .deeplinkToContactDataTransaction()
                .validateWarningMessageForDeeplinkTerminatedUser();
    }

}
