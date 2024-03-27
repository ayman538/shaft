package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPResonsofRevocationPage {
    private SHAFT.GUI.WebDriver driver;

    public ASPResonsofRevocationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By RevocationTitle = By.xpath("//*[@automation-id='pageHeader_tv']");
    private By RevocationSubTitle1 = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private By RevocationSubTitle2 = By.xpath("//*[@automation-id='revocationReasonsHeader_tv']");
    private By RevocationOption1 = By.xpath("//*[@automation-id='technical-problems_title_tv']");
    private By RevocationOption2 = By.xpath("//*[@automation-id='tariff-problems_title_tv']");
    private By RevocationOption3 = By.xpath("//*[@automation-id='have-questions_title_tv']");
    private By RevocationOption4 = By.xpath("//*[@automation-id='marketing-one_title_tv']");
    private By RevocationOption5 = By.xpath("//*[@automation-id='marketing-two_title_tv']");
    private By RevocationOption6 = By.xpath("//*[@automation-id='marketing-three_title_tv']");
    private By RevocationOption7 = By.xpath("//*[@automation-id='other-reason_title_tv']");
    private By PopupMsg1 = By.xpath("//*[@automation-id='modalHeader_tv'][1]");
    private By PopupMsg2 = By.xpath("//*[@automation-id='modalHeader_tv'][2]");

    private String RevocationTitleCL = "Vertrag widerrufen";
    private String RevocationSubTitle1CL = "Grund auswählen";
    private String RevocationSubTitle2CL = "Warum möchtest Du Deinen Vertrag widerrufen?";
    private String RevocationOption1CL = "Du hast technische Probleme?";
    private String RevocationOption2CL = "Du bist unzufrieden mit Deinem Tarif?";
    private String RevocationOption3CL = "Du hast Fragen? Sprich uns an, wir helfen Dir gerne weiter.";
    private String RevocationOption4CL = "Inhalt wird noch festgelegt.";
    private String RevocationOption5CL = "Inhalt wird noch festgelegt.";
    private String RevocationOption6CL = "Inhalt muss noch festgelegt werden.";
    private String RevocationOption7CL = "Du möchtest Deinen Vertrag aus anderen Gründen widerrufen?";
    private String PopupMsg1CL = "Das hat leider nicht geklappt";
    private String PopupMsg2CL = "Wir arbeiten dran. Geh bitte einen Schritt zurück und wähl einen anderen Grund aus.";


    public ASPResonsofRevocationPage clickoption6() {
        driver.element().click(RevocationOption6);
        return this;
    }
    public ASPSalesAgentPage clickoption3() {
        driver.element().click(RevocationOption3);
        return new ASPSalesAgentPage(driver);
    }


    @Step("Validate Revocation Page CL")
    public void RevocatioOptionsValidations() {
        driver.verifyThat().element(RevocationTitle).text().isEqualTo(RevocationTitleCL).perform();
        driver.verifyThat().element(RevocationSubTitle1).text().isEqualTo(RevocationSubTitle1CL).perform();
        driver.verifyThat().element(RevocationSubTitle2).text().isEqualTo(RevocationSubTitle2CL).perform();
        driver.verifyThat().element(RevocationOption1).text().isEqualTo(RevocationOption1CL).perform();
        driver.verifyThat().element(RevocationOption2).text().isEqualTo(RevocationOption2CL).perform();
        driver.verifyThat().element(RevocationOption3).text().isEqualTo(RevocationOption3CL).perform();
       /* driver.verifyThat().element(RevocationOption4).text().isEqualTo(RevocationOption4CL).perform();
        driver.verifyThat().element(RevocationOption5).text().isEqualTo(RevocationOption5CL).perform();
        driver.verifyThat().element(RevocationOption6).text().isEqualTo(RevocationOption6CL).perform();*/
        driver.verifyThat().element(RevocationOption7).text().isEqualTo(RevocationOption7CL).perform();
    }
    @Step("Navigate to sales Agent page")
    public ASPSalesAgentPage NavigatetosalesAgent()
    {
        driver.element().click(RevocationOption1);
        return new ASPSalesAgentPage (driver);
    }
    @Step("Validate popup message")
    public void PopupValidation(){
        driver.verifyThat().element(PopupMsg1).text().isEqualTo(PopupMsg1CL).perform();
        driver.verifyThat().element(PopupMsg2).text().isEqualTo(PopupMsg2CL).perform();
    }
    @Step("verify url for um user")
    public void UMURLValidation(){
        driver.verifyThat().element(RevocationSubTitle1).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/widerruf/um-gruende").perform();
    }
    @Step("verify url for kd user")
    public void KDURLValidation(){
        driver.verifyThat().element(RevocationSubTitle1).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/widerruf/kd-gruende").perform();
    }
}

