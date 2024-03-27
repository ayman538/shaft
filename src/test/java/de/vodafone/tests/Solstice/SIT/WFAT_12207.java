package de.vodafone.tests.Solstice.SIT;

/*import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeEinladenConfirmation;
import de.vodafone.pages.Solstice.SolsticePersonEinladen;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_12207")*/
public class WFAT_12207 extends SolsticeSetup {
   /* private String firstName;
    private String lastName;
    private String email;
    @Test(groups = {"WFAT_12207", "regression"})
    @Description(" Given   I'm a logged in Solstice user, owner of the product/contract and have not reached the limit of delegations (5 per contract or 5 per product)," +
            "\nWhen  I click on Delegate access CTA in my contracts accordion," +
            "\n then    I want to be able to fill some information about the delegated user like: Salutation, first name, last name and E-Mail Address and find a send CTA button.")
    public void GCO1(Method method){
        firstName = testData.getTestData(method.getName() + ".firstName");
        lastName = testData.getTestData(method.getName() + ".lastName");
        email = testData.getTestData(method.getName() + ".email");

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion()
                .clickOnMoreDetails()
                .clickOnPersonEinladenForContract().chooseAnrede().enterVorname(firstName)
                .enterNachname(lastName).enterEmail(email).clickOnEinladen();
        EinladenValidation();

    }
    @Test(groups = {"WFAT_12207", "regression"})
    @Description(" Given   I'm a logged in Solstice user, owner of the product/contract and have not reached the limit of delegations (5 per contract or 5 per product)," +
            "\nWhen  I click on Delegate access CTA in my contracts accordion," +
            "\n then    I want to be able to fill some information about the delegated user like: Salutation, first name, last name and E-Mail Address and find a send CTA button.")
    public void GCO2(Method method) {
        firstName = testData.getTestData(method.getName() + ".firstName");
        lastName = testData.getTestData(method.getName() + ".lastName");
        email = testData.getTestData(method.getName() + ".email");

        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion()
                .clickOnMoreDetails()
                .clickOnPersonEinladenForProduct().chooseAnrede().enterVorname(firstName)
                .enterNachname(lastName).enterEmail(email).clickOnEinladen();
        EinladenValidation();

    }
    @Test(groups = {"WFAT_12207", "regression"})
    @Description(" Given   I'm a logged in Solstice user, owner of the product/contract and have not reached the limit of delegations (5 per contract or 5 per product)," +
            "\nWhen  I click on Delegate access CTA in my contracts accordion," +
            "\n then    I want to be able to Check front validations for required fields")
    public void GCO3() {
        new SolsticeDashboard(driver)
                .chooseÜbersichtFromMeinKonto()
                .chooseOtherAdminAccordion()
                .clickOnMoreDetails().clickOnPersonEinladenForContract()
                .removeFirstNameField().removeLastNameField().removeEmailField()
                .removeFirstNameField();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticePersonEinladen.VornameError_text)
                .text()
                .contains(SolsticePersonEinladen.VornameError)
                .withCustomReportMessage("Check that Header text exist in confirmation page")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticePersonEinladen.NachError_text)
                .text()
                .contains(SolsticePersonEinladen.NachError)
                .withCustomReportMessage("Check that Header text exist in confirmation page")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticePersonEinladen.EmailError_text)
                .text()
                .contains(SolsticePersonEinladen.EmailError)
                .withCustomReportMessage("Check that Header text exist in confirmation page")
                .perform();

    }
    private void EinladenValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEinladenConfirmation.ConfirmationHeader_Text)
                .text()
                .contains(SolsticeEinladenConfirmation.ConfirmationHeader)
                .withCustomReportMessage("Check that Header text exist in confirmation page")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeEinladenConfirmation.ConfirmationTitle_Text)
                .text()
                .contains(SolsticeEinladenConfirmation.ConfirmationTitle)
                .withCustomReportMessage("Check that title  exist in confirmation page")
                .perform();
    }

*/
}