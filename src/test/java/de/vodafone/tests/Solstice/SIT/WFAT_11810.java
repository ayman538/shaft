package de.vodafone.tests.Solstice.SIT;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_11810")
public class WFAT_11810 extends SolsticeSITSetup {

    @TmsLink("WFAT-12289")
    @Test(description = "WFAT-12289 Given  I'm a logged in Solstice user,\nWhen I open My contracts and subscriptions accordion," + "\n then   I want to be able to find all my owned Customers and products.")
    private void TC01() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu()
                .assertionForContractAndSubscriptionTileAndDescription();

    }
}