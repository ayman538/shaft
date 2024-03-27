package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.UnauthorizedPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_13287")
public class WFAT_13287 extends SolsticeSetup {

    @Test(groups = {"13287", "regression"})
    @Description(" Given that I'm a logged in as a Bart user  ,When I get redirected to unauthorized page " +
            "Then I want to find an error message with updated* CL and an add contract/subscriber CTA")
    private void GC01() {

        driver.browser().navigateToURL( "https://simplicity.wf-de.vodafone.com/meinvodafone/services/teilnehmer/mein-tarif?accordion=mein-tarif");

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.backBTN)
                .text()
                .contains(UnauthorizedPage.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.pageHeader)
                .text()
                .contains(UnauthorizedPage.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.errorMsgHeader)
                .text()
                .contains(UnauthorizedPage.errorMsgHeader_text)
                .withCustomReportMessage("Check error msg header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.errorMsgBodybart)
                .text()
                .contains(UnauthorizedPage.errorMsgBodybart_text)
                .withCustomReportMessage("Check error msg body")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.ctaBTN)
                .text()
                .contains(UnauthorizedPage.ctaBTN_text)
                .withCustomReportMessage("Check error msg body")
                .perform();
    }


    @Test(groups = {"WFAT_12255", "regression"})
    @Description(" Given that I'm a logged in as a Emma user  ,When I get redirected to unauthorized page +\n" +
            "Then I want to find an error message with updated* CL and an add contract/subscriber CTA ")
    private void GC02() {

        driver.browser().navigateToURL( "https://simplicity.wf-de.vodafone.com/meinvodafone/services/teilnehmer/mein-tarif?accordion=mein-tarif");

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.backBTN)
                .text()
                .contains(UnauthorizedPage.backBTN_text)
                .withCustomReportMessage("Check back button")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.pageHeader)
                .text()
                .contains(UnauthorizedPage.pageHeader_text)
                .withCustomReportMessage("Check page header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.errorMsgHeader)
                .text()
                .contains(UnauthorizedPage.errorMsgHeader_text)
                .withCustomReportMessage("Check error msg header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.errorMsgBodyEmma)
                .text()
                .contains(UnauthorizedPage.errorMsgBodyEmma_text)
                .withCustomReportMessage("Check error msg body")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), UnauthorizedPage.ctaBTN)
                .text()
                .contains(UnauthorizedPage.ctaBTN_text)
                .withCustomReportMessage("Check error msg body")
                .perform();
    }
}