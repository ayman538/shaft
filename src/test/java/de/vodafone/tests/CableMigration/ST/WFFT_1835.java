package de.vodafone.tests.CableMigration.ST;

import com.shaft.validation.Validations;
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
public class WFFT_1835 extends CableMigrationSTSetup {

    //Test
    @Test(description="GC02 || Verify MeinRechnungen Page in case of multiple invoices ")
    @TmsLink("WFFT-1861")
    private void GC02(Method method) throws InterruptedException {

        // Expand first contract and navigate to Mein Rechnungen page

        new MeinVodafoneDashboard(driver).expandFirstAccordion();
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
               .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.firstIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.secondIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.thirdIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.fourthIcon).exists().perform();


        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.backlink_link)
                .text().isEqualTo(testData.getTestData(method.getName() + ".backLinkText"))
                .withCustomReportMessage("Check That backlink is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.billChartHeadline_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".billChartHeaderText"))
                .withCustomReportMessage("Check That bill chart header is displayed probabaly ").perform();



    }

    @Test(description="GC04 || Verify MeinRechnungen Page in case of single invoice ")
    @TmsLink("WFFT-1924")
    private void GC04(Method method) throws InterruptedException {

        // Expand first contract and navigate to Mein Rechnungen page

        new MeinVodafoneDashboard(driver).expandFirstAccordion();
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.firstIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.secondIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.thirdIcon).exists().perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.fourthIcon).exists().perform();


        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.backlink_link)
                .text().isEqualTo(testData.getTestData(method.getName() + ".backLinkText"))
                .withCustomReportMessage("Check That backlink is displayed probabaly ").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.billChartHeadline_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".billChartHeaderText"))
                .withCustomReportMessage("Check That bill chart header is displayed probabaly ").perform();



    }



}
