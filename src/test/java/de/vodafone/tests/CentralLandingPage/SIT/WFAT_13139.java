package de.vodafone.tests.CentralLandingPage.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.CentralLandingPage.MainCentralLandingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Central Landing Page")
@Feature("SIT")
@Story("WFAT_13139")
public class WFAT_13139 extends CentralLandingPageSetup {
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC01() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline1CL, MainCentralLandingPage.CLPTeaserSubHeadline1CL );
    }
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC02() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline2CL, MainCentralLandingPage.CLPTeaserSubHeadline2CL );
    }
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC03() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline3CL, MainCentralLandingPage.CLPTeaserSubHeadline3CL );
    }
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC04() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline4CL, MainCentralLandingPage.CLPTeaserSubHeadline4CL );
    }
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC05() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline5CL, MainCentralLandingPage.CLPTeaserSubHeadline5CL );
    }
    @Test(groups = {"WFAT_13139", "regression"})
    @Description("GC01-Nonlogged in user deeplinks to central landing page using Young-Underage URL")
    public void GC06() {
        centralLandingPageChecks(MainCentralLandingPage.CLPTeaserHeadline6CL, MainCentralLandingPage.CLPTeaserSubHeadline6CL );
    }


    private void centralLandingPageChecks(String HeaderCL ,String SubHeaderCL){
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPTeaserHeadline)
                .text().isEqualTo(HeaderCL)
                .withCustomReportMessage("Check Teaser Headline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPTeaserSubHeadline)
                .text().isEqualTo(SubHeaderCL)
                .withCustomReportMessage("Check Teaser subheadline")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPMainText1)
                .text().contains(MainCentralLandingPage.CLPMainText1CL)
                .withCustomReportMessage("Check Main Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPMainText2)
                .text().contains(MainCentralLandingPage.CLPMainText2CL)
                .withCustomReportMessage("Check Main Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPLoginHeader)
                .text().isEqualTo(MainCentralLandingPage.CLPLoginHeaderCL)
                .withCustomReportMessage("Check Login Header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPLoginText)
                .text().isEqualTo(MainCentralLandingPage.CLPLoginTextCL)
                .withCustomReportMessage("Check Login Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPLoginCTA)
                .text().isEqualTo(MainCentralLandingPage.CLPLoginCTACL)
                .withCustomReportMessage("Check Login CTA")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPRegisterHeader)
                .text().isEqualTo(MainCentralLandingPage.CLPRegisterHeaderCL)
                .withCustomReportMessage("Check Register Header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPRegisterText)
                .text().isEqualTo(MainCentralLandingPage.CLPRegisterTextCL)
                .withCustomReportMessage("Check Register Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MainCentralLandingPage.CLPRegisterCTA)
                .text().isEqualTo(MainCentralLandingPage.CLPRegisterCTACL)
                .withCustomReportMessage("Check Register CTA")
                .perform();
    }
}


