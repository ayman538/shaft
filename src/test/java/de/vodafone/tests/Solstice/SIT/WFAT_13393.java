package de.vodafone.tests.Solstice.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.UnAuthorizedErrors;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("SIT")
@Story("WFAT_13393")
public class WFAT_13393 extends SolsticeSetup {
   private String peterUrl= "https://simplicity.wf-de.vodafone.com/meinvodafone/services/dsl-produkte/meine-produkte";
   private String generalUrl ="https://simplicity.wf-de.vodafone.com/meinvodafone/services/upgrade/landingPageRedirect?documentUrl=/zuhause-legi&titleKey=Nachweis%20zur%20Zuhause-Adresse%20hochladen";
    @Test(groups = {"WFAT_13393", "regression"})
    @Description(" Given  I'm a logged in user having no eligible MBO assigned to my account that allows me to access the requested page or service  " +
            "\nWhen    I get redirected to unauthorized page " +
            "\n then   I want to find\n" +
            "\n" + "Dynamic title based on the previous page\n" +
            "an error message with updated CL for general unauthorized page and peter case  and\n" +
            "an \"add contract/subscriber\" CTA ")
    public void GC01() {
        driver.browser().navigateToURL( peterUrl, peterUrl);
        notificationValidation();
        Validations.assertThat()
                .element(driver.getDriver(), UnAuthorizedErrors.peterDescription_text)
                .text()
                .contains(UnAuthorizedErrors.peterDescription)
                .withCustomReportMessage("Check that  peter user Description text is correct ")
                .perform();
}
    @Test(groups = {"WFAT_13393", "regression"})
    @Description(" Given  I'm a logged in user having no eligible MBO assigned to my account that allows me to access the requested page or service  " +
            "\nWhen    I get redirected to unauthorized page " +
            "\n then   I want to find\n" +
            "\n" + "Dynamic title based on the previous page\n" +
            "an error message with updated CL for general unauthorized page and General  case  and\n" +
            "an \"add contract/subscriber\" CTA ")
    public void GC02() {
        driver.browser().navigateToURL( generalUrl, generalUrl);
        notificationValidation();
            Validations.assertThat()
                .element(driver.getDriver(), UnAuthorizedErrors.peterDescription_text)
                .text()
                .contains(UnAuthorizedErrors.generalDescription)
                .withCustomReportMessage("Check that  peter user Description text is correct ")
                .perform();
    }
    private void notificationValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), UnAuthorizedErrors.peterHeader_text)
                .text()
                .contains(UnAuthorizedErrors.peterHeader)
                .withCustomReportMessage("Check that  peter user header text is correct ")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), UnAuthorizedErrors.addContract_button)
                .text()
                .contains(UnAuthorizedErrors.addContract)
                .withCustomReportMessage("Check that  peter user button name  text is correct ")
                .perform();
    }

}
