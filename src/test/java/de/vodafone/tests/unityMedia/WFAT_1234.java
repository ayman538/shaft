package de.vodafone.tests.unityMedia;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.InternetAndPhone;
import de.vodafone.tests.unityMedia.ST.ST_UnityMediaSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("Unity Media")
public class WFAT_1234 extends ST_UnityMediaSetup {
    //Variables

    //Test
    @Test(groups={"WFAT_1234","regression"})
    @Description("Given login with valid user then redirect to Dashboard then user longed in successfully ")
    private void testLoginScenarioUM() {
            new Dashboard(driver)

                .openAccordion(Dashboard.DashboardInternetandPhoneAccordion.INTERNETANDPHONE)
                .openSmartObject(Dashboard.DashboardInternetAndPhoneSmartObject.EINSTELLUNGEN)
                .openCard(InternetAndPhone
                        .InternetAndPhoneCards.TELEPHONBUCHEINTRAG);
        Validations.assertThat()
                .element(driver.getDriver(), InternetAndPhone.telephoneNumber_label)
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Check that phone number exists for the selected address")
                .perform();
    }

    @Test
    @Description("for the second one Given login with valid user then redirect to Dashboard then user longed in successfully ")
    private void testLoginScenarioUM2() {


        new Dashboard(driver)
                .openAccordion(Dashboard.DashboardInternetandPhoneAccordion.INTERNETANDPHONE)
                .openSmartObject(Dashboard.DashboardInternetAndPhoneSmartObject.EINSTELLUNGEN)
                .openCard(InternetAndPhone
                        .InternetAndPhoneCards.TELEPHONBUCHEINTRAG);
        Validations.assertThat()
                .element(driver.getDriver(), InternetAndPhone.telephoneNumber_label)
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Check that phone number exists for the selected address")
                .perform();
    }


}
