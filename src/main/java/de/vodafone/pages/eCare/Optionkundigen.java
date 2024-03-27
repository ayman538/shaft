package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.awaitility.Awaitility.await;

public class Optionkundigen {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private By hyperLink_link = By.xpath("//strong[@automation-id='download_Link']");
    private By cancelLegalText_txt = By.xpath("//div[@automation-id='download_et']");
    private By loader_img = By.xpath("//div[@class='loader']");

    public Optionkundigen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // keywords
    @Step("Click on HyperLink")
    public Optionkundigen clickOnHyperLink()  {
        driver.element().click(hyperLink_link);
        return this;
    }

    @Step("Check downloaded PDF and delete it afterwards")
    public Optionkundigen downloadPDF() {
        String pattern = "ddMMyyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        String filePath = System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath")+"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf";
        File f= new File(filePath);
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").exists().perform();
        f.delete();
        SHAFT.Validations.assertThat().file(System.getProperty("testDataFolderPath") + System.getProperty("downloadsFolderPath"),"EECC Vertragszusammenfassung_Mobilfunk_Optionsbuchung_"+dateInString+".pdf").doesNotExist().perform();
        return this;
    }

    @Step("Check downloaded PDF and delete it afterwards")
    public Optionkundigen downloadSITPDF() {
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

    @Step("Validate Cancel LegalText message Exist")
    public Optionkundigen validateCancelLegalTextExist(String expectedCancelLegalText) {
        driver.verifyThat()
                .element(cancelLegalText_txt)
                .text()
                .contains(expectedCancelLegalText)
                .perform();
        return this;
    }
    @Step("Validate Cancel LegalText message does not Exist")
    public Optionkundigen validateCancelLegalTextNotExist(String expectedCancelLegalText) {
        driver.verifyThat()
                .element(cancelLegalText_txt)
                .doesNotExist()
                .perform();
        return this;
    }
}
