package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeOtherAdmins;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_13019")
public class WFAT_13019 extends SolsticeSetup {

    @Test(groups = {"WFAT_13019", "regression"})
    @Description(" Given that I'm a logged in as a Solstice/ Legacy user  ,When I don't have any contracts and products " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC01() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.msgHeader)
                .text()
                .contains(SolsticeOtherAdmins.msgHeader_text)
                .withCustomReportMessage("Check that message header is exist")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.msgBody)
                .text()
                .contains(SolsticeOtherAdmins.msgBody_text)
                .withCustomReportMessage("Check that message body is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.mergeAccount)
                .text()
                .contains(SolsticeOtherAdmins.mergeAccount_text)
                .withCustomReportMessage("Check that merge account link is exist")
                .perform();

    }

}