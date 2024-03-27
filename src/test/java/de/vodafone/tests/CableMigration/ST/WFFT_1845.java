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
public class WFFT_1845 extends CableMigrationSTSetup {
    @Test(description="GC01 - Verify the table in case of one bill per month & only normal bills & more than 12 Bills.")
    @TmsLink("WFFT-1874")
    private void GC01(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);

        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Table headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_Headline)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table headline is displayed").perform();
        //Verify Table subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SubHeadline)
                .text().contains(testData.getTestData(method.getName() + ".tableSubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table subheadline is displayed").perform();
        //Verify Table columns count
        Validations.assertThat().number(MeinRechnungPage.getNumOfTableColumns())
                .isEqualTo(4)
                .withCustomReportMessage("Check That MeinRechnung table columns is 5").perform();
        //Verify Table Columns Names
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FirstColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFirstColumnName"))
                .withCustomReportMessage("Check MeinRechnung table first column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SecondColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSecondColumnName"))
                .withCustomReportMessage("Check MeinRechnung table second column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ThirdColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableThirdColumnName"))
                .withCustomReportMessage("Check MeinRechnung table third column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FourthColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFourthColumnName"))
                .withCustomReportMessage("Check MeinRechnung table fourth column name").perform();
       // Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FifthColumnName)
         //       .text().isEqualTo(testData.getTestData(method.getName() + ".tableFifthColumnName"))
           //     .withCustomReportMessage("Check MeinRechnung table fifth column name").perform();
        //Verify Table rows count
        Validations.assertThat().number(MeinRechnungPage.getNumOfTableRows())
                .isEqualTo(14)
                .withCustomReportMessage("Check That MeinRechnung table rows is 13").perform();
        //Download normal file
        new MeinRechnungPage(driver).downloadRechnungFile();

    }

    @Test(description="GC02 - Verify the table in case of multiple bills per month & normal&itemized bills & only 12 Bills for user.")
    @TmsLink("WFFT-1875")
    private void GC02(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Table headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_Headline)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table headline is displayed").perform();
        //Verify Table subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SubHeadline)
                .text().contains(testData.getTestData(method.getName() + ".tableSubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table subheadline is displayed").perform();
        //Verify Table columns count
        Validations.assertThat().number(MeinRechnungPage.getNumOfTableColumns())
                .isEqualTo(4)
                .withCustomReportMessage("Check That MeinRechnung table columns is 6").perform();
        //Verify Table Columns Names
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FirstColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFirstColumnName"))
                .withCustomReportMessage("Check MeinRechnung table first column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SecondColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSecondColumnName"))
                .withCustomReportMessage("Check MeinRechnung table second column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ThirdColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableThirdColumnName"))
                .withCustomReportMessage("Check MeinRechnung table third column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FourthColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFourthColumnName"))
                .withCustomReportMessage("Check MeinRechnung table fourth column name").perform();
      //  Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FifthColumnName)
        //        .text().isEqualTo(testData.getTestData(method.getName() + ".tableFifthColumnName"))
          //      .withCustomReportMessage("Check MeinRechnung table fifth column name").perform();
       // Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SixthColumnName)
               // .text().isEqualTo(testData.getTestData(method.getName() + ".tableSixthColumnName"))
                //.withCustomReportMessage("Check MeinRechnung table sixth column name").perform();
        //Verify Table rows count
        Validations.assertThat().number(MeinRechnungPage.getNumOfTableRows())
                .isEqualTo(13)
                .withCustomReportMessage("Check That MeinRechnung table rows is 13").perform();
        //Download normal file
        new MeinRechnungPage(driver).downloadItemizedFile();

    }

    @Test(description="GC03 - Verify the table in case of one bill per month & Only normal bills & less than 12 Bills for user while first bill with amount = 0 & pdf type not defined.")
    @TmsLink("WFFT-1876")
    private void GC03(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Table headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_Headline)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table headline is displayed").perform();
        //Verify Table subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SubHeadline)
                .text().contains(testData.getTestData(method.getName() + ".tableSubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table subheadline is displayed").perform();
        //Verify Table columns count
        Validations.assertThat().number(MeinRechnungPage.getNumOfTableColumns())
                .isEqualTo(4)
                .withCustomReportMessage("Check That MeinRechnung table columns is 5").perform();
        //Verify Table Columns Names
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FirstColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFirstColumnName"))
                .withCustomReportMessage("Check MeinRechnung table first column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SecondColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSecondColumnName"))
                .withCustomReportMessage("Check MeinRechnung table second column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ThirdColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableThirdColumnName"))
                .withCustomReportMessage("Check MeinRechnung table third column name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FourthColumnName)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFourthColumnName"))
                .withCustomReportMessage("Check MeinRechnung table fourth column name").perform();
       // Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_FifthColumnName)
         //       .text().isEqualTo(testData.getTestData(method.getName() + ".tableFifthColumnName"))
           //     .withCustomReportMessage("Check MeinRechnung table fifth column name").perform();
        //Verify First Row amount = 0
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_AmountFirstRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFirstAmount"))
                .withCustomReportMessage("Verify MeinRechnung table first row amount = 0").perform();

        //Download normal file with not defined type
        new MeinRechnungPage(driver).downloadRechnungFile();

    }

    @Test(description="GC16 - Verify the displayed product name in Table.")
    @TmsLink("WFFT-1973")
    private void GC16(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Table headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_Headline)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table headline is displayed").perform();
        //Verify Table subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SubHeadline)
                .text().contains(testData.getTestData(method.getName() + ".tableSubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table subheadline is displayed").perform();
        //Verify Table Product Names
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameFirstRow)
                .textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".tableFirstProductName"))
                .withCustomReportMessage("Verify MeinRechnung table First Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameSecondRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSecondProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Second Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameThirdRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableThirdProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Third Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameFourRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFourProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Four Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameFiveRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableFiveProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Five Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameSixRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSixProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Six Product Name").perform();
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_ProductNameSevenRow)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableSevenProductName"))
                .withCustomReportMessage("Verify MeinRechnung table Seven Product Name").perform();
    }

    @Test(description="GC10 - Verify the table in case of pdf not returned for Bill")
    @TmsLink("WFFT-1909")
    private void GC10(Method method) throws InterruptedException {

        //Dashboard page
        Thread.sleep(7000);
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();

        //MeinRechnung page
        // Verify page header
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.header_txt)
                .text().isEqualTo(testData.getTestData(method.getName() + ".headerText"))
                .withCustomReportMessage("Check That header is displayed probabaly ").perform();
        //Verify Table headline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_Headline)
                .text().isEqualTo(testData.getTestData(method.getName() + ".tableHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table headline is displayed").perform();
        //Verify Table subheadline
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_SubHeadline)
                .text().contains(testData.getTestData(method.getName() + ".tableSubHeadline"))
                .withCustomReportMessage("Check That MeinRechnung table subheadline is displayed").perform();
        //Verify PDF Not returned Error Message.
        Validations.assertThat().element(driver.getDriver(), MeinRechnungPage.table_PDFErrorMsg)
                .text().contains(testData.getTestData(method.getName() + ".pdfNotReturnedErrorMsg"))
                .withCustomReportMessage("Verify PDF Not returned Error Message is displayed").perform();

    }
}