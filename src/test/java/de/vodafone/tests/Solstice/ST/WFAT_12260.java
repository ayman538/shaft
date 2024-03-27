package de.vodafone.tests.Solstice.ST;

import de.vodafone.pages.Solstice.RenameContract;
import de.vodafone.pages.Solstice.RenameProduct;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12260")
public class WFAT_12260 extends SolsticeSTSetup{
    @TmsLink("WFAT-12313")
    @Test(description = "WFAT-12313 Solstice User - Verify Rename Contract Page for Contract")

    public void SolsticeUserVerifyRenameContractPageForContract() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu()
                .chooseRenameContract().PageValidation();
        new RenameContract(driver)
                .enterNewName()
                .ChangeName();
    }
    @TmsLink("WFAT-12314")
    @Test(description = "WFAT-12314 Solstice User - Verify Rename Contract Page for Product")

    public void SolsticeUserVerifyRenameContractPageForProduct(){

        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer()
                .ClickONBurgerMenu_Product()
                .chooseRenameProduct()
                .PageValidation_product();
        new RenameProduct(driver)
                .enterNewName_product()
                .ChangeName_product();

    }
}
