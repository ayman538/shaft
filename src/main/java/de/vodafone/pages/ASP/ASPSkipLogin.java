package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPSkipLogin {
    private SHAFT.GUI.WebDriver driver;

    public ASPSkipLogin(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By PageHeader = By.xpath("//*[@automation-id='pageHeader_tv']");
    private By SectionTitle = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private By LoginHeader = By.xpath("//*[@automation-id='withLoginRevoketv']");
    private By LoginText = By.xpath("//*[@class='white-box']/p[1]");
    private By LoginButton = By.xpath("//*[@class='white-box']/button[1]");
    private By SkipLoginHeader = By.xpath("//*[@automation-id='withoutLoginRevoketv']");
    private By SkipLoginText = By.xpath("//*[@class='white-box']/p[2]");
    private By SkipLoginButton = By.xpath("//*[@class='white-box']/button[2]");
    private By TerminationPageHeader = By.xpath("//*[@automation-id='terminationReasonsContainer_tv']");


    private String PageHeaderCL = "Vertrag kündigen";
    private String SectionTitleCL = "Du möchtest Deinen Vertrag kündigen.";
    private String LoginHeaderCL = "Mit Login";
    private String LoginTextCL = "Logg Dich in MeinVodafone ein.";
    private String LoginButtonCL = "Auswählen";
    private String SkipLoginHeaderCL = "Ohne Login";
    private String SkipLoginTextCL = "Du kannst auch ohne Login fortfahren.";
    private String SkipLoginButtonCL = "Auswählen";


    public ASPTerminationPage clickSkipLogin() {
        driver.element().click(SkipLoginButton);
        return new ASPTerminationPage(driver);
    }

    //Validations
    @Step("Validate CL for page header, login, and skip login sections")
    public void CLValidations() {
        driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeaderCL).perform();
        driver.verifyThat().element(SectionTitle).text().isEqualTo(SectionTitleCL).perform();
        driver.verifyThat().element(LoginHeader).text().isEqualTo(LoginHeaderCL).perform();
        driver.verifyThat().element(LoginText).text().isEqualTo(LoginTextCL).perform();
        driver.verifyThat().element(LoginButton).text().isEqualTo(LoginButtonCL).perform();
        driver.verifyThat().element(SkipLoginHeader).text().isEqualTo(SkipLoginHeaderCL).perform();
        driver.verifyThat().element(SkipLoginText).text().isEqualTo(SkipLoginTextCL).perform();
        driver.verifyThat().element(SkipLoginButton).text().isEqualTo(SkipLoginButtonCL).perform();
    }
    @Step("Check skip login button redirection")
    public void SkipLoginRedirection() {
        driver.verifyThat().element(TerminationPageHeader).isVisible().perform();
    }
}
