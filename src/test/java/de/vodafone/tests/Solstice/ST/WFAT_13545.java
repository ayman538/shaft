package de.vodafone.tests.Solstice.ST;

import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_13545")
public class WFAT_13545 extends SolsticeSTSetup{


    @Test(description = "WFAT-13663 Given that I'm a logged in as a Solstice user  ,When I have delegated contracts Then  I should NOT find the notification message about potentially loosing an Alias")
    @TmsLink("WFAT-13663")
    private void GC01() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu()
                .chooseSecondOption()
                .validationNotifictionMessage_Contract();
    }


    @Test(description = "WFAT-13664 Given that I'm a logged in as a Solstice user  ,When I have delegated products Then  I should NOT find the notification message about potentially loosing an Alias")
    @TmsLink("WFAT-13664")
    private void GC02() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu_Product()
                .chooseSecondOption_Product()
                .VerifyNotifictions_message_product();
    }
}
