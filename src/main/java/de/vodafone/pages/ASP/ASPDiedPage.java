package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class ASPDiedPage {
    // Locators
    private static SHAFT.GUI.WebDriver driver;
    private By PageHeader = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    private By PageHeadline = By.xpath("//*[@automation-id='contractOwnerDiedChooserHeadline_tv']");
    private By ChooseQuestion = By.xpath("//*[@automation-id='contractOwnerDiedChooserDescription_tv']");
    private By KeepContract = By.xpath("//*[@id='Vertrag übernehmen']");
    private By TerminateContract = By.xpath("//*[@id='Vertrag kündigen']");
    private String PageHeader_CL = "Sterbefall";
    private String PageHeadline_CL = "Jemand ist verstorben? Wähl bitte aus, was Du mit dem Vertrag machen möchtest.";
    private String ChooseQuestion_CL = "Was möchtest Du machen?";
    private String KeepContract_CL = "Vertrag übernehmen";
    private String TerminateContract_CL = "Vertrag kündigen";
    // Constructor
    public ASPDiedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //methods
    @Step("Validate Died Page")
    public void DiedPageValidation() {
        driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeader_CL).perform();
        driver.verifyThat().element(PageHeadline).text().isEqualTo(PageHeadline_CL).perform();
        driver.verifyThat().element(ChooseQuestion).text().isEqualTo(ChooseQuestion_CL).perform();
        driver.verifyThat().element(KeepContract).text().isEqualTo(KeepContract_CL).perform();
        driver.verifyThat().element(TerminateContract).text().isEqualTo(TerminateContract_CL).perform();
    }
}