package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TariffAndern {
    private SHAFT.GUI.WebDriver driver;
    private By legalText = By.xpath("//span[@automation-id='termsAndConditionsText_et']");
    private By downloadSummaryContract_btn = By.xpath("//span[@class='text-underline pointer']");
    private By callyaClassicTariff = By.xpath("(//span[@class='tariff-text'])[3]");
    private By weiter_btn = By.xpath("//button[contains(text(),'weiter')]");
    private By loader_img = By.xpath("//div[@class='loader']");
   // private By DownloadHyperlink = By.xpath("//*[@id=\"prepaid-legal-text\"]/contract-summary/div/div");
    private By DownloadHyperlink = By.xpath("//div[@automation-id='download_et']");

    public TariffAndern(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate tariff andern legal text text")
    public TariffAndern validateTLegalText(String expectedlegalText) {
        driver.verifyThat()
                .element(legalText)
                .text()
                .contains(expectedlegalText)
                .perform();
        return this;
    }

    @Step("click on Widerrufsbelehrung button (download contract summary)")
    public TariffAndern clickOnVertragszusammenfassungBtn () {
        driver.element().click(downloadSummaryContract_btn);
        return this;
    }

    @Step("Validate General Error page")
    public TariffAndern validateGeneralErrorMessage (String expectedErrorMessageTitle, String expectedErrorMessageBody) {
        driver.verifyThat()
                .element(DownloadHyperlink)
                .text()
                .contains(expectedErrorMessageTitle)
                .perform();
        driver.verifyThat()
                .element(DownloadHyperlink)
                .text()
                .contains(expectedErrorMessageBody)
                .perform();
        return this;
    }
    @Step("Check downloaded PDF and delete it afterwards")
    public TariffAndern validateAndDeletePDF() {
        String pattern = "ddMMyyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        String filePath = System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath")+"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf";
        File f= new File(filePath);
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").exists().perform();
        f.delete();
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").doesNotExist().perform();
        return this;
    }

    @Step("click on callyaClassicTariff card")
    public TariffAndern clickOnCallyaClassicCard() {
        driver.element().click(callyaClassicTariff);
        return this;
    }

    @Step("click on weiter button")
    public TariffAndern clickOnWeiter(){
        driver.element().click(weiter_btn);
        return this;
    }

    @Step("Check downloaded PDF and delete it afterwards")
    public TariffAndern downloadSITPDF() {
        driver.element().waitToBeInvisible(loader_img);
        String pattern = "ddMMyyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        String filePath = System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath")+"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf";
        File f= new File(filePath);
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").exists().perform();
        f.delete();
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").doesNotExist().perform();
        return this;
    }

    @Step("Validate tariff andern legal text text")
    public TariffAndern checkdownloadHyperlinkText(String expectedHyperlinkText) {
        driver.verifyThat()
                .element(DownloadHyperlink)
                .text()
                .contains(expectedHyperlinkText)
                .perform();
        return this;
    }
}
