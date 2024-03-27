package de.vodafone.tests.Solstice.ST;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants.BurgerMenu_button;
import static de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants.burgerMenueProduct;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12254")
public class WFAT_12254 extends SolsticeSTSetup{
    @Test(description = " WFAT-12552 Given that I'm a logged in as a Solstice user  ,When I don't have delegated contracts & products"+  "Then  i want to Verify my contracts and subscriptions accordion ")
    @TmsLink("WFAT-12552")
    private void GC01() {

        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer().VerifyDelgatedIcon();

    }

    @Test(description ="WFAT-12554  Given that I'm a logged in as a Solstice user  ,When I have delegated contracts & products"+"Then  i want to Verify my contracts and subscriptions accordion ")
    @TmsLink("WFAT-12554")
    private void GC03()
    {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer().VerifyDelgatedAcordion();
        (new ElementActions(driver.getDriver())).click(BurgerMenu_button);
        VerifyBurgermenue_contract();

        (new ElementActions(driver.getDriver())).click(burgerMenueProduct);
        VerifyBurgermenue_product();
    }



    public void VerifyBurgermenue_contract(){
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.firstOption)
                .text()
                .contains(SolsticeMyContractsAndParticipants.firstOption_text)
                .withCustomReportMessage("Check first option in burger menue")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.secondOption)
                .text()
                .contains(SolsticeMyContractsAndParticipants.secondOption_text)
                .withCustomReportMessage("Check second option in burger menue")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.thirdOption)
                .text()
                .contains(SolsticeMyContractsAndParticipants.thirdOption_text)
                .withCustomReportMessage("Check second option in burger menue")
                .perform();

    }
    public void VerifyBurgermenue_product()
    {
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.firstOptionProduct)
                .text()
                .contains(SolsticeMyContractsAndParticipants.firstOptionProduct_text)
                .withCustomReportMessage("Check first option product in burger menue")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.secondOptionProduct)
                .text()
                .contains(SolsticeMyContractsAndParticipants.secondOptionProduct_text)
                .withCustomReportMessage("Check second option product in burger menue")
                .perform();

    }
}

