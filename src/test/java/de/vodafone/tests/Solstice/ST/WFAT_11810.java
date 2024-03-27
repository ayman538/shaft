package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_11810")
public class WFAT_11810 extends SolsticeSTSetup {

    @TmsLink("WFAT-12274")
    @Test(description="WFAT-12274-Given  I'm a logged in Solstice user,\nWhen I open My contracts and subscriptions accordion," + "\n then   I want to be able to find all my owned Customers and products.")
    private void GC01_VerifySolsticeMbo() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu();

        assertionForContractAndSubscriptionTileAndDescription();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.renameContractOption_Link)
                .text()
                .contains(SolsticeMyContractsAndParticipants.renameContractOption)
                .withCustomReportMessage("check that title equal this value  :  Vertrag umbenennen ")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.privacy_Link)
                .text()
                .contains(SolsticeMyContractsAndParticipants.privacy)
                .withCustomReportMessage("check that title equal this value  :   Datenschutz- und Werbeeinstellungen ")
                .perform();
    }

    @TmsLink("WFAT-12275")
    @Test(description=" WFAT-12274-Given  I'm a logged in legacy user,\nWhen I open My contracts and subscriptions accordion," + "\n then   I want to be able to find all my owned contracts and subscribers.")
    private void GC02_VerifyLegacyMbo() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu();
        assertionForContractAndSubscriptionTileAndDescription();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.changePassword_link)
                .text()
                .contains(SolsticeMyContractsAndParticipants.changePassword)
                .withCustomReportMessage("check that title equal this value  :   Kunden-Kennwort ändern ")
                .perform();

    }
    @TmsLink("WFAT-12276")
    @Test(description=" WFAT-12276-Given  I'm a logged in solstice user,\nWhen I open My contracts and subscriptions accordion," + "\n then   service failure occur and notification message appear ")
    private void BC01_VerifyServiceErrorNotification() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.notificationTitle_text)
                .text()
                .contains(SolsticeMyContractsAndParticipants.notificationTitle)
                .withCustomReportMessage("check that title equal this value  :    Das hat nicht geklappt")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.notificationDescription_text)
                .text()
                .contains(SolsticeMyContractsAndParticipants.notificationDescription)
                .withCustomReportMessage("check that title equal this value  :    Das hat nicht geklappt")
                .perform();


    }


    private void assertionForContractAndSubscriptionTileAndDescription(){
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.ContractAndParticipantTitle_text)
                .text()
                .contains(SolsticeMyContractsAndParticipants.ContractAndParticipant)
                .withCustomReportMessage("check that title equal this value  : Deine Verträge und Teilnehmer")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.ContractAndParticipantDescription_text)
                .text()
                .contains(SolsticeMyContractsAndParticipants.ContractAndParticipantDescription)
                .withCustomReportMessage("check that title equal this value  : Verwalte Deine Verträge und Teilnehmer. Oder füge neue hinzu.")
                .perform();

    }

}
