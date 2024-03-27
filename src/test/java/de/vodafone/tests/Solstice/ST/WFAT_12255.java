package de.vodafone.tests.Solstice.ST;

import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12255")
public class WFAT_12255 extends SolsticeSTSetup {
    @Test(description = "WFAT-12601 Given that I'm a logged in as a Solstice user  ,When I have delegated contracts & products"+ "Then i want to Remove delegated contract")
    @TmsLink("WFAT-12601")
    private void GC01() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu()
                .chooseSecondOption()
                .verifyRemove_delgatedContract();
    }

    @Test(description = "WFAT-12602 Given that I'm a logged in as a Solstice user  ,When I have delegated contracts & products"+ "Then i want to Remove delegated product")
    @TmsLink("WFAT-12602")
    private void GC02() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu_Product()
                .chooseSecondOption_Product()
                .VerifyRemovedelgated_Product();
    }
}
