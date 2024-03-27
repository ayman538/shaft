package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeChangePersonalData;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyAccount;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12036")
public class WFAT_12036 extends SolsticeSTSetup {

    public String deeplink = "https://simplicity.wf-de.vodafone.com/meinvodafone/account/verwaltung/nutzerdaten_aendern";
    public String deeplinkAfterRedirection = "https://simplicity.wf-de.vodafone.com/meinvodafone/account/verwaltung/nutzerdaten_aendern";
    @TmsLink("WFAT-12266")
    @Test(description="WFAT-12266-Given I'm a logged in as a Legacy user ,When I I visit the MyVF Account Mgmt area for Login Data " +
            "then the user can edit his/her personal data ")
    private void GC01() {
        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.PersonalDataTitle)
                .text()
                .contains(SolsticeMyAccount.PersonalDataTitle_text)
                .withCustomReportMessage("Check that Personal data title don't exist in confirmation")
                .perform();

        new SolsticeMyAccount(driver)
                .changePersonalData();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeChangePersonalData.PersonalDataHeader)
                .text()
                .contains(SolsticeChangePersonalData.PersonalDataHeader_text)
                .withCustomReportMessage("Check that Personal data Header don't exist in confirmation")
                .perform();

    }
    @TmsLink("WFAT-12267")
    @Test(description="WFAT-12266-Given I'm a logged in as a Solstice user ,When  I visit the MyVF Account Mgmt area for Login Data " +
            "then  I want to find my salutation/firstname/lastname in the personal data area, combined with a short information text box and a deactivated Edit Button.")

    private void GC02() {
        new SolsticeDashboard(driver)
                .chooseLoginDatenFromMeinKonto();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.PersonalDataTitle)
                .text()
                .contains(SolsticeMyAccount.PersonalDataTitle_text)
                .withCustomReportMessage("Check that Personal data title don't exist in confirmation")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.ErrorMsgTitle)
                .text()
                .contains(SolsticeMyAccount.ErrorMsgTitle_text)
                .withCustomReportMessage("Check that Personal data error title is exist ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.ErrorMsgBody)
                .text()
                .contains(SolsticeMyAccount.ErrorMsgBody_text)
                .withCustomReportMessage("Check that Personal data error body is exist ")
                .perform();
    }

    @TmsLink("WFAT-12268")
    @Test(description="WFAT-12268-Given I'm a logged in as a Solstice user ,When I request the deeplink for editing personal data   " +
            "then will be redirected to the Account Mgmt page  ")
    private void GC03() {
        new SolsticeDashboard(driver);

        driver.browser().navigateToURL( deeplink, deeplinkAfterRedirection);

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyAccount.MyAccountHeader)
                .text()
                .contains(SolsticeMyAccount.MyAccountHeader_text)
                .withCustomReportMessage("Check that Account Mgmt Hader is exist")
                .perform();

    }
}