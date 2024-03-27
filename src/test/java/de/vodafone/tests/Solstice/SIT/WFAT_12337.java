package de.vodafone.tests.Solstice.SIT;

/*import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeOtherAdmins;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static de.vodafone.pages.Solstice.SolsticeOtherAdmins.moreDetails;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12337")*/
public class WFAT_12337 extends SolsticeSetup {

   /* @Test(groups = {"WFAT_12337", "regression"})
    @Description(" Given that I'm a logged in as a Solstice user  ,When I have less than 5 delegations for contract - " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC01() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();

        (new ElementActions(driver)).click(moreDetails);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.manageContractsProducts)
                .text()
                .contains(SolsticeOtherAdmins.manageContractsProducts_text)
                .withCustomReportMessage("Check that manage contract and products is exist")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.invitationDescription)
                .text()
                .contains(SolsticeOtherAdmins.invitationDescription_text)
                .withCustomReportMessage("Check solstice invitation tetx is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.contractDelegateBtn)
                .text()
                .contains(SolsticeOtherAdmins.contractDelegateBtn_text)
                .withCustomReportMessage("Check second delegate btn for contract is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.unload)
                .text()
                .contains(SolsticeOtherAdmins.unload_text)
                .withCustomReportMessage("Check that unload btn is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.closeDetails)
                .text()
                .contains(SolsticeOtherAdmins.closeDetails_text)
                .withCustomReportMessage("Check that less details is exist")
                .perform();

    }

    @Test(groups = {"WFAT_12337", "regression"})
    @Description(" Given that I'm a logged in as a Solstice user  ,When I have 5 delegations for contract - " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC02() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();

        (new ElementActions(driver)).click(moreDetails);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.errorMsgHeader)
                .text()
                .contains(SolsticeOtherAdmins.errorMsgHeader_text)
                .withCustomReportMessage("Check that error msg header is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.errorMsgBody)
                .text()
                .contains(SolsticeOtherAdmins.errorMsgBody_text)
                .withCustomReportMessage("Check that error msg body is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.manageContractsProducts)
                .text()
                .contains(SolsticeOtherAdmins.manageContractsProducts_text)
                .withCustomReportMessage("Check that manage contract and products is exist")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.invitationDescription)
                .text()
                .contains(SolsticeOtherAdmins.invitationDescription_text)
                .withCustomReportMessage("Check solstice invitation tetx is exist")
                .perform();

        Validations.assertThat()
               .element(driver.getDriver(), SolsticeOtherAdmins.contractDelegateBtn)
                       .attribute("disabled")
                               .equals("true");

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.unload)
                .text()
                .contains(SolsticeOtherAdmins.unload_text)
                .withCustomReportMessage("Check that unload btn is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.closeDetails)
                .text()
                .contains(SolsticeOtherAdmins.closeDetails_text)
                .withCustomReportMessage("Check that less details is exist")
                .perform();

    }

    @Test(groups = {"WFAT_12337", "regression"})
    @Description(" Given that I'm a logged in as a Solstice user  ,When I have less than 5 delegations for product - " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC03() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();

        (new ElementActions(driver)).click(moreDetails);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.productDelegateBtn)
                .text()
                .contains(SolsticeOtherAdmins.contractDelegateBtn_text)
                .withCustomReportMessage("Check second delegate btn for product is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.unload)
                .text()
                .contains(SolsticeOtherAdmins.unload_text)
                .withCustomReportMessage("Check that unload btn is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.dontShowDetails)
                .text()
                .contains(SolsticeOtherAdmins.dontShowDetails_text)
                .withCustomReportMessage("Check that don't show details is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.closeDetails)
                .text()
                .contains(SolsticeOtherAdmins.closeDetails_text)
                .withCustomReportMessage("Check that less details is exist")
                .perform();
    }

    @Test(groups = {"WFAT_12337", "regression"})
    @Description(" Given that I'm a logged in as a Solstice user  ,When I have 5 delegations for product - " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC04() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();

        (new ElementActions(driver)).click(moreDetails);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.errorMsgHeader)
                .text()
                .contains(SolsticeOtherAdmins.errorMsgHeader_text)
                .withCustomReportMessage("Check that error msg header is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.errorMsgBody)
                .text()
                .contains(SolsticeOtherAdmins.errorMsgBody_text)
                .withCustomReportMessage("Check that error msg body is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.contractDelegateBtn)
                .attribute("disabled")
                .equals("true");


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.unload)
                .text()
                .contains(SolsticeOtherAdmins.unload_text)
                .withCustomReportMessage("Check that unload btn is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.dontShowDetails)
                .text()
                .contains(SolsticeOtherAdmins.dontShowDetails_text)
                .withCustomReportMessage("Check that don't show details is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.closeDetails)
                .text()
                .contains(SolsticeOtherAdmins.closeDetails_text)
                .withCustomReportMessage("Check that less details is exist")
                .perform();

    }

    @Test(groups = {"WFAT_12337", "regression"})
    @Description(" Given that I'm a logged in as a Solstice user  ,When I have 0 delegations for Contracts & product - " +
            "Then  i want to Verify my verify other admin accordion ")
    private void GC05() {

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion();

        (new ElementActions(driver)).click(moreDetails);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.manageContractsProducts)
                .text()
                .contains(SolsticeOtherAdmins.manageContractsProducts_text)
                .withCustomReportMessage("Check that manage contract and products is exist")
                .perform();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.invitationDescription)
                .text()
                .contains(SolsticeOtherAdmins.invitationDescription_text)
                .withCustomReportMessage("Check solstice invitation tetx is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.contractDelegateBtn)
                .text()
                .contains(SolsticeOtherAdmins.contractDelegateBtn_text)
                .withCustomReportMessage("Check second delegate btn for contract is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.productDelegateBtn)
                .text()
                .contains(SolsticeOtherAdmins.contractDelegateBtn_text)
                .withCustomReportMessage("Check second delegate btn for product is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeOtherAdmins.closeDetails)
                .text()
                .contains(SolsticeOtherAdmins.closeDetails_text)
                .withCustomReportMessage("Check that less details is exist")
                .perform();
    }*/
}