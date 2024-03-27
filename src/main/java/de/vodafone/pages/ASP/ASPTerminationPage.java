package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class ASPTerminationPage {
    private SHAFT.GUI.WebDriver driver;

    public ASPTerminationPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    private By TerminationTitle    =By.xpath("//*[@automation-id='pageHeader_tv']");
    private By TerminationSubTitle1=By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private By TerminationSubTitle2=By.xpath("//*[@automation-id='terminationReasonsHeader_tv']");
    //private By TerminationOption1=By.xpath("//*[@automation-id='moved_title_tv']");
    private By TerminationOption2=By.xpath("//*[@automation-id='there-a-death_title_tv']");
    private By TerminationOption3=By.xpath("//*[@automation-id='have-questions_title_tv']");
    private By TerminationOption4=By.xpath("//*[@automation-id='tariff-satisfaction_title_tv']");
    private By TerminationOption5=By.xpath("//*[@automation-id='marketing-one_title_tv']");
    private By TerminationOption6=By.xpath("//*[@automation-id='marketing-two_title_tv']");
    private By TerminationOption7=By.xpath("//*[@automation-id='other-reason_title_tv']");
    private By PopupMsg1=By.xpath("//*[@automation-id='modalHeader_tv'][1]");
    private By PopupMsg2=By.xpath("//*[@automation-id='modalDescriptioHeader_tv']");
    private By PopupMsg3=By.xpath("//*[@automation-id='modalDescriptioHeader_tv']");
    private String TerminationTitleCL="Vertrag kündigen";
    private String TerminationSubTitle1CL="Grund auswählen";
    private String TerminationSubTitle2CL="Warum möchtest Du Deinen Vertrag kündigen?";
    //private String TerminationOption1CL="Du bist umgezogen oder planst umzuziehen?";
    private String TerminationOption2CL="Es gibt einen Sterbefall?";
    private String TerminationOption3CL="Du hast Fragen? Sprich uns an, wir helfen Dir gerne weiter.";
    private String TerminationOption4CL="Du bist unzufrieden mit dem Tarif?";
    private String TerminationOption5CL="Inhalt wird noch festgelegt.";
    private String TerminationOption6CL="Inhalt muss noch festgelegt werden.";
    private String TerminationOption7CL="Du möchtest Deinen Vertrag aus anderen Gründen kündigen?";
    private String PopupMsg1CL="Das hat leider nicht geklappt";
    private String PopupMsg2CL="Wir arbeiten dran.";
    private String PopupMsg3CL="Bitte geh einen Schritt zurück und wähl einen anderen Grund aus. ";

    //click terminations options methods
    public ASPTerminationPage clickoption6()
    {
        driver.element().click(TerminationOption6);
        return this;
    }
    @Step("Navigate to sales agent page")
    public ASPSalesAgentPage Navigattosalesagnet_tremination()
    {
        driver.element().click(TerminationOption3);
        return new ASPSalesAgentPage(driver);
    }
    @Step("Navigate to contract owner has died page")
    public ASPDiedPage NavigatetoDiedPage()
    {
        driver.element().click(TerminationOption2);
        return new ASPDiedPage (driver);
    }
    // Validation Methods
    @Step("Validate Revocation Page CL")
    public void TerminationOptionsValidations(){
        driver.verifyThat().element(TerminationTitle).text().isEqualTo(TerminationTitleCL).perform();
        driver.verifyThat().element(TerminationSubTitle1).text().isEqualTo(TerminationSubTitle1CL).perform();
        driver.verifyThat().element(TerminationSubTitle2).text().isEqualTo(TerminationSubTitle2CL).perform();
        //driver.verifyThat().element(TerminationOption1).text().isEqualTo(TerminationOption1CL).perform();
        driver.verifyThat().element(TerminationOption2).text().isEqualTo(TerminationOption2CL).perform();
        driver.verifyThat().element(TerminationOption3).text().isEqualTo(TerminationOption3CL).perform();
        driver.verifyThat().element(TerminationOption4).text().isEqualTo(TerminationOption4CL).perform();
        driver.verifyThat().element(TerminationOption5).text().isEqualTo(TerminationOption5CL).perform();
       // driver.verifyThat().element(TerminationOption6).text().isEqualTo(TerminationOption6CL).perform();
        driver.verifyThat().element(TerminationOption7).text().isEqualTo(TerminationOption7CL).perform();
    }
    @Step("verify url for um user")
    public void UMURLValidation(){
        driver.verifyThat().element(TerminationSubTitle1).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/kuendigung/um-gruende").perform();
    }
    @Step("verify url for kd user")
    public void KDURLValidation(){
        driver.verifyThat().element(TerminationSubTitle1).exists().perform();
        driver.verifyThat().browser().url().contains("/retoure/kuendigung/kd-gruende").perform();
    }
   /* @Step("Validate popup message")
    public void PopupValidation(){
        driver.verifyThat().element(PopupMsg1).text().isEqualTo(PopupMsg1CL).perform();
        driver.verifyThat().element(PopupMsg2).text().isEqualTo(PopupMsg2CL).perform();
    }
    @Step("Check redirection from skip login page ")
    public void checkSkipLoginRedirection() {
        driver.verifyThat().element(TerminationSubTitle2).isVisible().perform();
    }*/
}