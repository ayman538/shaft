package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeMyContractsAndParticipants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_11777")
public class WFAT_11777 extends SolsticeSetup {

    @Test(groups = {"WFAT_11777", "regression"})
    @Description("Given I'm a Legacy User - with 1 mobile contract & 1 DSL contract & 2 VKD contracts & 2 UM contracts ,When I open My contracts and subscriptions accordion," +
            "\n then i want to verify My contracts and subscriptions Accordion ")
    private void TC01() {

        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderMobileDes)
                .text()
                .contains(SolsticeMyContractsAndParticipants.SliderMobileDes_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();
/*
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderMobile)
                .exists()
                .withCustomReportMessage("Check That Slider Exist")
                .perform();
*/
    }

    @Test(groups = {"WFAT_11777", "regression"})
    @Description("Given I'm a Legacy User - with 1 mobile contract & 1 DSL contract & 2 VKD contracts & 2 UM contracts ,When I open My contracts and subscriptions accordion," +
            "\n then i want to verify My contracts and subscriptions Accordion ")
    private void TC02() {

        new SolsticeDashboard(driver)
                .chooseMeineVerträgeUndTeilnehmer();


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderDSLDes)
                .text()
                .contains(SolsticeMyContractsAndParticipants.SliderDSLDes_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();
/*
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderDSL)
                .exists()
                .withCustomReportMessage("Check That Slider Exist")
                .perform();

*/


        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderVKDDes)
                .text()
                .contains(SolsticeMyContractsAndParticipants.SliderVKDDes_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();
/*
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderVKD)
                 .exists()
                .withCustomReportMessage("Check That Slider Exist")
                .perform();
*/
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.VkdInfoMsg)
                .text()
                .contains(SolsticeMyContractsAndParticipants.VkdInfoMsg_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();





        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderUMDes)
                .text()
                .contains(SolsticeMyContractsAndParticipants.SliderUMDes_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();
/*
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.SliderUM)
                .exists()
                .withCustomReportMessage("Check That Slider Exist")
                .perform();
*/
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeMyContractsAndParticipants.UmInfoMsg)
                .text()
                .contains(SolsticeMyContractsAndParticipants.UmInfoMsg_text)
                .withCustomReportMessage("Check That Solstice Slider Description Exist")
                .perform();


    }


}
