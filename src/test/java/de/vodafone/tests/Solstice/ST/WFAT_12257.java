package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12257")
public class WFAT_12257 extends SolsticeSTSetup {
    @TmsLink("WFAT-13081")
    @Test(description = "WFAT-13081 User with delegated contract checks dashboard")
    public void GC01() throws InterruptedException {
        new SolsticeDashboard(driver);//.closeEmailNotification();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.SolsticeDelegatedMbo_Label)
                .text()
                .isEqualTo(SolsticeDashboard.SolsticeDelegatedMboLabel_CL)
                .withCustomReportMessage("Check Delegation Label CL")
                .perform();

        new SolsticeDashboard(driver).expandSolsticeDelegatedMbo();

        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.CustomerProductSectionHeadline)
                .text()
                .isEqualTo(SolsticeDashboard.CustomerProductSectionHeadline_CL)
                .withCustomReportMessage("Check Customer-Product Section Headline CL")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SolsticeDashboard.CustomerProductSectionText)
                .text()
                .isEqualTo(SolsticeDashboard.CustomerProductSectionText_CL)
                .withCustomReportMessage("Check Customer-Product Section Text CL")
                .perform();
        Validations.assertThat().element(driver.getDriver(), SolsticeDashboard.ProductNumber1).exists().withCustomReportMessage("Check Product is Displayed").perform();

    }

    @TmsLink("WFAT-13083")
    @Test(description = "WFAT-13083 User with only one contract checks delegated contract in dashboard")
    public void GC03(){
        new SolsticeDashboard(driver);//.closeEmailNotification();
        Validations.assertThat().element(driver.getDriver(), SolsticeDashboard.SolsticeDelegatedContract).attribute("class")
                .isEqualTo(SolsticeDashboard.ExpandedByDefaultClassValue).withCustomReportMessage("expantion").perform();   }
}

