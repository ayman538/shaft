package de.vodafone.tests.Solstice.SIT;

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
@Feature("SIT")
@Story("WFAT_12254")
public class WFAT_12254 extends SolsticeSITSetup
{

    @TmsLink("WFAT-12556")
    @Test(description = "WFAT-12556 Given that I'm a logged in as a Solstice user  ,When I don't have delegated contracts & products"+  "Then  i want to Verify my contracts and subscriptions accordion ")
    private void TC01() {
        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer().VerifyDelgatedAcordion();
        driver.element().click(BurgerMenu_button);
        VerifyBurgermenue_contract();
        driver.element().click(burgerMenueProduct);
        VerifyBurgermenue_product();

    }



   public void VerifyBurgermenue_contract(){
       driver.assertThat().element(SolsticeMyContractsAndParticipants.firstOption)
               .text().contains(SolsticeMyContractsAndParticipants.firstOption_text)
               .withCustomReportMessage("Check first option in burger menue").perform();
       driver.assertThat().element(SolsticeMyContractsAndParticipants.secondOption)
               .text().contains(SolsticeMyContractsAndParticipants.secondOption_text)
               .withCustomReportMessage("Check second option in burger menue").perform();
       driver.assertThat().element(SolsticeMyContractsAndParticipants.thirdOption)
               .text().contains(SolsticeMyContractsAndParticipants.thirdOption_text)
               .withCustomReportMessage("Check third option in burger menue").perform();
    }
    public void VerifyBurgermenue_product()
    {
        driver.assertThat().element(SolsticeMyContractsAndParticipants.firstOptionProduct)
                .text().contains(SolsticeMyContractsAndParticipants.firstOptionProduct_text)
                .withCustomReportMessage("Check first option product in burger menue").perform();
        driver.assertThat().element(SolsticeMyContractsAndParticipants.secondOptionProduct)
                .text().contains(SolsticeMyContractsAndParticipants.secondOptionProduct_text)
                .withCustomReportMessage("Check second option product in burger menue").perform();
    }
}