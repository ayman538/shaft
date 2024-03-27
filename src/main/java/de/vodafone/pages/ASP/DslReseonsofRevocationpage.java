package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DslReseonsofRevocationpage {
    private static SHAFT.GUI.WebDriver driver;
    public DslReseonsofRevocationpage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    public static final By sendBack_BTN = By.xpath("(//button[@class='btn'])[2]");
    private By revocationTitle = By.xpath("//div[@automation-id='pageHeader_tv']");
    private By revocationSubTitle1 = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private By revocationSubTitle2 = By.xpath("//h3[@automation-id='revocationReasonsHeader_tv']");
    private By revocationOption1 = By.xpath("//h4[@automation-id='technical-problems_title_tv']");
    private By revocationOption2 = By.xpath("//h4[@automation-id='tariff-problems_title_tv']");
    private By revocationOption3 = By.xpath("//h4[@automation-id='have-questions_title_tv']");
    private By revocationOption4 = By.xpath("//h4[@automation-id='marketing-one_title_tv']");
    private By revocationOption5 = By.xpath("//h4[@automation-id='marketing-Two_title_tv']");
    private By revocationOption6 = By.xpath("//h4[@automation-id='marketing-three_title_tv']");
    private By revocationOption7 = By.xpath("//h4[@automation-id='other-reason_title_tv']");
    private By popupMsg1 = By.xpath("//h1[@automation-id='modalHeader_tv'][1]");
    private By popupMsg2 = By.xpath("//h3[@automation-id='modalDescriptioHeader_tv']");
    //CL
    private String revocationTitleCL = "Vertrag widerrufen";
    private String revocationSubTitle1CL = "Grund auswählen";
    private String revocationSubTitle2CL = "Warum möchtest Du Deinen Vertrag widerrufen?";
    private String revocationOption1CL = "Du hast technische Probleme?";
    private String revocationOption2CL = "Du bist unzufrieden mit Deinem Tarif?";
    private String revocationOption3CL = "Du hast Fragen?";
    private String revocationOption4CL = "Deine Bestellung ist nicht so, wie Du es wolltest?";
    private String revocationOption5CL = "Inhalt wird noch festgelegt.";
    private String revocationOption6CL = "Inhalt muss noch festgelegt werden.";
    private String revocationOption7CL = "Du möchtest Deinen Vertrag aus anderen Gründen widerrufen?";
    private String PopupMsg1CL = "Das hat leider nicht geklappt";
    private String PopupMsg2CL = "Wähl bitte einen anderen Grund aus.";
    // Methods
    public ASPConfirmationPage navigateToConfirmationPage()
    {
        new ElementActions(driver.getDriver()).click(sendBack_BTN);
        return  new ASPConfirmationPage(driver);
    }

    public DslReseonsofRevocationpage clickoption6() {
        driver.element().click(revocationOption6);
        return this;
    }
    //Validations

    @Step("Navigate to sales Agent page")
    public DslReseonsofRevocationpage navigatetosalesAgent()
    {
        driver.element().click(revocationOption1);
        return this ;
    }
    @Step("Validate Revocation Page CL")
    public DslReseonsofRevocationpage revocatioOptionsValidations() {
        driver.verifyThat().element(revocationTitle).textTrimmed().isEqualTo(revocationTitleCL).perform();
        driver.verifyThat().element(revocationSubTitle1).textTrimmed().isEqualTo(revocationSubTitle1CL).perform();
        driver.verifyThat().element(revocationSubTitle2).textTrimmed().isEqualTo(revocationSubTitle2CL).perform();
        driver.verifyThat().element(revocationOption1).textTrimmed().isEqualTo(revocationOption1CL).perform();
        driver.verifyThat().element(revocationOption2).textTrimmed().isEqualTo(revocationOption2CL).perform();
        driver.verifyThat().element(revocationOption3).textTrimmed().isEqualTo(revocationOption3CL).perform();
        driver.verifyThat().element(revocationOption4).textTrimmed().isEqualTo(revocationOption4CL).perform();
        driver.verifyThat().element(revocationOption5).textTrimmed().isEqualTo(revocationOption5CL).perform();
        driver.verifyThat().element(revocationOption6).textTrimmed().isEqualTo(revocationOption6CL).perform();
        driver.verifyThat().element(revocationOption7).textTrimmed().isEqualTo(revocationOption7CL).perform();
        return this;
    }


    @Step("Validate popup message")
    public DslReseonsofRevocationpage popupValidation(){
        driver.verifyThat().element(popupMsg1).textTrimmed().isEqualTo(PopupMsg1CL).perform();
        driver.verifyThat().element(popupMsg2).textTrimmed().isEqualTo(PopupMsg2CL).perform();
        return this;
    }
    @Step("verify url for um user")
    public void revocationURLValidation(){
        driver.verifyThat().browser().url().contains("/retoure/widerruf/dsl-gruende").perform();
    }


}
