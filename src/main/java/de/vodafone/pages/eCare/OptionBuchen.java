package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OptionBuchen {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private By hyperLink_link = By.xpath("//strong[@automation-id='download_Link']");
    private By eligibleContractSummary_txt = By.xpath("//div[@automation-id='download_et']");
    private By firstNotEligibleLegalText_txt = By.xpath("(//span[@automation-id='termsAndConditionsText_et']/p)[1]");
    private By secondNotEligibleLegalText_txt = By.xpath("(//span[@automation-id='termsAndConditionsText_et']/p)[2]");
    private By buchbareOptionenNotificationHeader = By.xpath("//p[contains(text(),'Wartungsarbeiten')]");
    private By buchbareOptionenNotificationBody = By.xpath("//p[contains(text(),'Du kannst diese Option aktuell nicht buchen. Versuch es bitte später nochmal.')]");
    private By loader_img = By.xpath("//div[@class='loader']");

    public OptionBuchen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // keywords
    @Step("Click on HyperLink")
    public OptionBuchen clickOnHyperLink() {
        driver.element().click(hyperLink_link);
        return this;
    }

    @Step("Check downloaded PDF and delete it afterwards")
    public OptionBuchen downloadPDF() {
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
    public OptionBuchen downloadSITPDF() {
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

    @Step("Validate buchbare optionen notification text")
    public OptionBuchen validateBuchbareOptionenNotificationText(String expectedNotificationHeader, String expectedNotificationBody) {
        driver.verifyThat()
                .element(buchbareOptionenNotificationHeader)
                .text()
                .contains(expectedNotificationHeader)
                .perform();
        driver.verifyThat()
                .element(buchbareOptionenNotificationBody)
                .text()
                .contains(expectedNotificationBody)
                .perform();
        return this;
    }
    @Step("Validate buchbare optionen notification text does not exist")
    public OptionBuchen validateBuchbareOptionenNotificationTextNotExist(String expectedNotificationHeader, String expectedNotificationBody) {
        driver.verifyThat()
                .element(buchbareOptionenNotificationHeader)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(buchbareOptionenNotificationBody)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Eligible LegalText message Exist")
    public OptionBuchen validateEligibleLegalTextExist(String expectedFirstNotEligibleLegalText,String expectedSecondNotEligibleLegalText, String expectedEligibleContractSummary) {
        driver.verifyThat()
                .element(firstNotEligibleLegalText_txt)
                .text()
                .contains(expectedFirstNotEligibleLegalText)
                .perform();
        driver.verifyThat()
                .element(secondNotEligibleLegalText_txt)
                .text()
                .contains(expectedSecondNotEligibleLegalText)
                .perform();
        driver.verifyThat()
                .element(eligibleContractSummary_txt)
                .text()
                .contains(expectedEligibleContractSummary)
                .perform();
        return this;
    }

    @Step("Validate Not Eligible LegalText message Exist")
    public OptionBuchen validateNotEligibleLegalTextExist(String expectedFirstNotEligibleLegalText,String expectedSecondNotEligibleLegalText) {
        driver.verifyThat()
                .element(firstNotEligibleLegalText_txt)
                .text()
                .contains(expectedFirstNotEligibleLegalText)
                .perform();
        driver.verifyThat()
                .element(secondNotEligibleLegalText_txt)
                .text()
                .contains(expectedSecondNotEligibleLegalText)
                .perform();
        return this;
    }
}
