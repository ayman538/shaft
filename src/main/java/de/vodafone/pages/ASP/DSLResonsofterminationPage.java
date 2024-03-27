package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DSLResonsofterminationPage {
    private SHAFT.GUI.WebDriver driver;

    public DSLResonsofterminationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By terminationTitle    =By.xpath("//div[@automation-id='pageHeader_tv']");
    private By terminationSubTitle1=By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private By terminationSubTitle2=By.xpath("//h3[@automation-id='terminationReasonsHeader_tv']");
    private By terminationOption1=By.xpath("//h4[@automation-id='moved_title_tv']");
    private By terminationOption2=By.xpath("//h4[@automation-id='there-a-death_title_tv']");
    private By terminationOption3=By.xpath("//h4[@automation-id='have-questions_title_tv']");
    private By terminationOption4=By.xpath("//h4[@automation-id='marketing-one_title_tv']");
    private By terminationOption5=By.xpath("//h4[@automation-id='marketing-two_title_tv']");
    private By terminationOption6=By.xpath("//h4[@automation-id='marketing-three_title_tv']");
    private By terminationOption7=By.xpath("//h4[@automation-id='other-reason_title_tv']");
    private By popupMsg1=By.xpath("//h1[@automation-id='modalHeader_tv']");
    private By popupMsg2=By.xpath("//h3[@automation-id='modalDescriptioHeader_tv']");
    //private //By PopupMsg3=By.xpath("//*[@automation-id='modalDescriptioHeader_tv']");
    private String terminationTitleCL="Vertrag kündigen";
    private String terminationSubTitle1CL="Grund auswählen";
    private String terminationSubTitle2CL="Warum möchtest Du Deinen Vertrag kündigen?";
    private String terminationOption1CL="Du bist umgezogen oder planst umzuziehen?";
    private String terminationOption2CL="Es gibt einen Sterbefall?";
    private String terminationOption3CL="Du hast Fragen?";
    private String terminationOption4CL="Du bist unzufrieden mit Deinem Tarif?";
    private String terminationOption5CL="Du hast technische Probleme?";
    private String terminationOption6CL="Inhalt muss noch festgelegt werden.";
    private String terminationOption7CL="Du möchtest Deinen Vertrag aus anderen Gründen kündigen?";
    private String popupMsg1CL="Das hat leider nicht geklappt";
    private String popupMsg2CL="Wähl bitte einen anderen Grund aus.";
    private String popupMsg3CL="Bitte geh einen Schritt zurück und wähl einen anderen Grund aus. ";

    //click terminations options methods
    public DSLResonsofterminationPage clickoption6()
    {
        driver.element().click(terminationOption6);
        return this;
    }
    @Step("Navigate to sales agent page")
    public DSLResonsofterminationPage navigattosalesagnet_tremination()
    {
        driver.element().click(terminationOption3);
        return this ;
    }
    @Step("Navigate to contract owner has died page")
    public DSLResonsofterminationPage navigatetoDiedPage()
    {
        driver.element().click(terminationOption2);
        return this;
    }
    // Validation Methods
    @Step("Validate Termination Page CL")
    public DSLResonsofterminationPage terminationOptionsValidations(){
        driver.verifyThat().element(terminationTitle).textTrimmed().isEqualTo(terminationTitleCL).perform();
        driver.verifyThat().element(terminationSubTitle1).textTrimmed().isEqualTo(terminationSubTitle1CL).perform();
        driver.verifyThat().element(terminationSubTitle2).textTrimmed().isEqualTo(terminationSubTitle2CL).perform();
        driver.verifyThat().element(terminationOption1).textTrimmed().isEqualTo(terminationOption1CL).perform();
        driver.verifyThat().element(terminationOption2).textTrimmed().isEqualTo(terminationOption2CL).perform();
        driver.verifyThat().element(terminationOption3).textTrimmed().isEqualTo(terminationOption3CL).perform();
        driver.verifyThat().element(terminationOption4).textTrimmed().isEqualTo(terminationOption4CL).perform();
        driver.verifyThat().element(terminationOption5).textTrimmed().isEqualTo(terminationOption5CL).perform();
         driver.verifyThat().element(terminationOption6).textTrimmed().isEqualTo(terminationOption6CL).perform();
        driver.verifyThat().element(terminationOption7).textTrimmed().isEqualTo(terminationOption7CL).perform();
        return this;
    }
    @Step("verify url for um user")
    public void terminationURLValidation(){
        driver.verifyThat().browser().url().contains("/retoure/kuendigung/dsl-gruende").perform();
    }

    @Step("Validate popup message")
    public void popupValidation(){
        driver.verifyThat().element(popupMsg1).textTrimmed().isEqualTo(popupMsg1CL).perform();
        driver.verifyThat().element(popupMsg2).textTrimmed().isEqualTo(popupMsg2CL).perform();
    }

}

