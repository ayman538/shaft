package de.vodafone.tests.CableMigration.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.CableMigration.DunningPage;
import de.vodafone.pages.CableMigration.MeinRechnungPage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
public class WFFT_1836 extends CableMigrationSTSetup {
    @Test(description="GC01 || Verify notification message Box in case of dunning status is Active.")
    @TmsLink("WFFT-1864")
    private void GC01(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();


        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.NotificationMessageHeadline_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".NotificationMessageHeadlineText"))
                .withCustomReportMessage("Check That headline is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.NotificationMessageSubHeadline_Text )
                .text().isEqualTo(testData.getTestData(method.getName() + ".NotificationMessageSubHeadlineText "))
                .withCustomReportMessage("Check That subheadline is displayed probabaly ").perform();


        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.Check_Button)
                .text().isEqualTo(testData.getTestData(method.getName() + ".CheckButton"))
                .withCustomReportMessage("Check That button Text is displayed probabaly ").perform();


        new MeinRechnungPage(driver).navigateToDunningPage();
        //Thread.sleep(400);
        Validations.assertThat().element(driver.getDriver(), DunningPage.header_Text)
                .text().isEqualTo(testData.getTestData(method.getName() + ".Dunningheader"))
                .withCustomReportMessage("Check That button redirects to the Dunning Page ").perform();
    }
}
