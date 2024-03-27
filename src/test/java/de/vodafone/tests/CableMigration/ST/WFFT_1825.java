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
public class WFFT_1825 extends CableMigrationSTSetup {

    @Test(description="GC01 - Martin user Verify third party in case of only 18 normal bills ")
    @TmsLink("WFFT-1880")
    private void GC01(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();
        //click on show more untill reach max
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();

        /*Verify Third party count
        Validations.assertThat().number(MeinRechnungPage.getNumOfThirdPartyRows())
                .isEqualTo(19)
                .withCustomReportMessage("Check That MeinRechnung third party is 19").perform();*/

        //collapse all extra rows
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).downloadRechungFile();

    }

    @Test (description="GC02 - Martin user Verify third party in case of 7 normal & itemizied bills ")
    @TmsLink("WFFT-1881")
    private void GC02(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();
        //click on show more untill reach max
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        //new MeinRechnungPage(driver).clickOnShowMoreLessLink();

        /*Verify Third party count
        Validations.assertThat().number(MeinRechnungPage.getNumOfThirdPartyRows())
                .isEqualTo(7)
                .withCustomReportMessage("Check That MeinRechnung third party is 18").perform();*/
      
        //collapse all extra rows
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).downloadRechungFile();
        new MeinRechnungPage(driver).downloadDetailedFile();

    }
    @Test (description="GC04 - Martin user Verify third party in case of Normal document not retrived ")
    @TmsLink("WFFT-1883")
    private void GC04(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();


        new MeinRechnungPage(driver).downloadRechungFile();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subheadlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorsubheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error subheadline is displayed").perform();


    }

    @Test (description="GC05 - Martin user Verify third party in case of Itemizied document not retrived ")
    @TmsLink("WFFT-1885")
    private void GC05(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();


        new MeinRechnungPage(driver).downloadDetailedFile();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subheadlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorsubheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error subheadline is displayed").perform();


    }

    @Test (description="GC06 - Martin user Verify disappearance of third party section")
    @TmsLink("WFFT-1886")
    private void GC06(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();


        //Verify Third party headline disappearance
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty).doesNotExist()
                .withCustomReportMessage("Check disappearance of MeinRechnung third party headline").perform();

        //Verify Third party subheadline disappearce
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subHeadlineThirdParty).doesNotExist()
                .withCustomReportMessage("Check disappearance of MeinRechnung third party subheadline ").perform();

    }

    //ute

    @Test (description="GC10 - ute user Verify third party in case of only 18 normal bills ")
    @TmsLink("WFFT-1895")
    private void GC10(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).ute_NavigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();
        //click on show more untill reach max
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();

        /*Verify Third party count
        Validations.assertThat().number(MeinRechnungPage.getNumOfThirdPartyRows())
                .isEqualTo(17)
                .withCustomReportMessage("Check That MeinRechnung third party is 17").perform();*/
      
        //collapse all extra rows
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).downloadRechungFile();

    }

    @Test (description="GC11 - ute user Verify third party in case of 7 normal & itemizied bills ")
    @TmsLink("WFFT-1896")
    private void GC11(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).ute_NavigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();
        //click on show more untill reach max
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();

        /*Verify Third party count
        Validations.assertThat().number(MeinRechnungPage.getNumOfThirdPartyRows())
                .isEqualTo(8)
                .withCustomReportMessage("Check That MeinRechnung third party is 8").perform();*/
      
        //collapse all extra rows
        new MeinRechnungPage(driver).clickOnShowMoreLessLink();
        new MeinRechnungPage(driver).downloadRechungFile();
        new MeinRechnungPage(driver).downloadDetailedFile();

    }

    @Test (description="GC13- ute user Verify third party in case of Normal document not retrived ")
    @TmsLink("WFFT-1899")
    private void GC13(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).ute_NavigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();


        new MeinRechnungPage(driver).downloadRechungFile();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subheadlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorsubheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error subheadline is displayed").perform();


    }
    @Test(description="GC14- ute user Verify third party in case of Itemizied document not retrived ")
    @TmsLink("WFFT-1900")
    private void GC14(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).ute_NavigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Third party headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_headlineThirdParty)
                .text().isEqualTo(testData.getTestData(method.getName() + ".thirdPartyHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party headline is displayed").perform();
        //Verify Third party subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_subHeadlineThirdParty)
                .text().contains(testData.getTestData(method.getName() + ".thirdPartySubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung third party subheadline is displayed").perform();


        new MeinRechnungPage(driver).downloadDetailedThirdFile();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.headlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error headline is displayed").perform();

        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.subheadlineThirdParty_error)
                .text().contains(testData.getTestData(method.getName() + ".errorsubheadline"))
                .withCustomReportMessage("Check That MeinRechnung third party error subheadline is displayed").perform();


    }

    @Test(description="GC15 - ute user Verify disappearance of third party section")
    @TmsLink("WFFT-1901")
    private void GC15(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).ute_NavigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();


        //Verify Third party headline disappearance
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_headlineThirdParty).doesNotExist()
                .withCustomReportMessage("Check disappearance of MeinRechnung third party headline").perform();

        //Verify Third party subheadline disappearce
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.ute_subHeadlineThirdParty).doesNotExist()
                .withCustomReportMessage("Check disappearance of MeinRechnung third party subheadline ").perform();

    }


}
