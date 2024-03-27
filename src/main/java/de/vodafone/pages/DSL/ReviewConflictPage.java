package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ReviewConflictPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;
    //CL
    private String page_Title_CL = "Option buchen";
    private String warningMsg_Header_CL = "Das hat leider nicht geklappt";
    private String warningMessageBody_CL = "Du hast aktuell eine Option gebucht, die mit der Option, die Du gerade neu hinzufügen möchtest, nicht kompatibel ist. Bitte kündige erst die alte und buche dann die neue nochmal.";
    private String warningMessageNote_CL = "Wichtig: Die Kündigung muss erst vollständig abgeschlossen sein. Das dauert in der Regel 24 Stunden.";
    private String panel_Header_CL = "Die neue Option ersetzt die alte.";
    private String newOption_Title_CL = "Neue Option";
    private String newOption_Name_CL = "Euro-Flat";
    private String newOption_Price_CL = "4,99 €";
    private String newOption_Description_CL = "Endlos telefonieren in das Festnetz von 27 europäischen Ländern.";
    private String replacedOption_Title_CL = "Diese Option wird ersetzt:";
    private String replacedOption_Name_CL = "Mobile & Euro-Flat";
    private String replacedOption_Price_CL = "9,99 €";
    private String orderNow_Button_CL = "Jetzt kostenpflichtig bestellen";

    //Element Locators
    private By page_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]//h1");
    private By userEmail_Header = By.xpath("//*[@automation-id=\"pageHeader_tv\"]//h2");
    private By warningMessage_Header = By.xpath("//*[@class='flexDiv']");
    private By warningMessage_Body = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By panel_Header = By.xpath("//*[@automation-id='transactionReviewConflictDetails_headline_tv']");
    private By newOption_Title = By.xpath("//*[@automation-id='transactionReviewDetails_subheadline_tv']");
    private By newOption_Name = By.xpath("//*[@id=\"content\"]//app-dsl-tariff-extras-booking/navigation/app-review-conflict//app-transaction-review//bookable-tariff-card[1]/div/div[1]/span");
    private By newOption_Price = By.xpath("//*[@id=\"content\"]//app-dsl-tariff-extras-booking/navigation/app-review-conflict//app-transaction-review//bookable-tariff-card[1]/div/div[2]/div[1]/div");
    private By newOption_Description = By.xpath("//*[@class='short-description']");
    private By details_HyperLink = By.xpath("//*[@class='tariff-card-details']");
    private By replacedOption_Title = By.xpath("//*[@automation-id=\"transactionReviewConflictDetails_subheadline_tv\"]");
    private By replacedOption_Name = By.xpath("//*[@id=\"content\"]//app-dsl-tariff-extras-booking/navigation/app-review-conflict//app-transaction-review//bookable-tariff-card[2]/div/div[1]/span");
    private By replacedOption_Price = By.xpath("//*[@id=\"content\"]//app-dsl-tariff-extras-booking/navigation/app-review-conflict//app-transaction-review//bookable-tariff-card[2]/div/div[2]/div/div");
    private By policyTerms_Block = By.xpath("//*[@class='white-box contract-summary-card mt-15']");
    private By orderNow_Button = By.xpath("//*[@automation-id=\"transactionReviewDetails_btn\"]");

    //Constructor
    public ReviewConflictPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Main Page Element Validation")
    public ReviewConflictPage validateMainPageElement() {
        driver.verifyThat().element(page_Title).text().isEqualTo(page_Title_CL).perform();
        driver.verifyThat().element(userEmail_Header).exists().perform();
        driver.verifyThat().element(panel_Header).text().isEqualTo(panel_Header_CL).perform();
        driver.verifyThat().element(orderNow_Button).text().isEqualTo(orderNow_Button_CL).perform();
        return this;
    }

    @Step("Warning Message Validations")
    public ReviewConflictPage validateWarningMessage() {
        driver.verifyThat().element(warningMessage_Header).text().isEqualTo(warningMsg_Header_CL).perform();
        driver.verifyThat().element(warningMessage_Body).text().contains(warningMessageBody_CL).perform();
        driver.verifyThat().element(warningMessage_Body).text().contains(warningMessageNote_CL).perform();
        return this;
    }

    @Step("Policy Terms Validations")
    public ReviewConflictPage validatePolicyTerms() {
        driver.verifyThat().element(policyTerms_Block).exists().perform();
        return this;
    }

    @Step("Replaced option Validations")
    public ReviewConflictPage validateReplacedOption() {
        driver.verifyThat().element(replacedOption_Title).text().isEqualTo(replacedOption_Title_CL).perform();
        driver.verifyThat().element(replacedOption_Name).text().isEqualTo(replacedOption_Name_CL).perform();
        driver.verifyThat().element(replacedOption_Price).text().isEqualTo(replacedOption_Price_CL).perform();
        return this;
    }

    @Step("New option Validations")
    public ReviewConflictPage validateNewOption() {
        driver.verifyThat().element(newOption_Title).text().isEqualTo(newOption_Title_CL).perform();
        driver.verifyThat().element(newOption_Name).text().isEqualTo(newOption_Name_CL).perform();
        driver.verifyThat().element(newOption_Price).text().isEqualTo(newOption_Price_CL).perform();
        driver.verifyThat().element(newOption_Description).text().isEqualTo(newOption_Description_CL).perform();
        driver.verifyThat().element(details_HyperLink).exists().perform();
        return this;
    }

}

