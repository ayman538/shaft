package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuickCheckPage {
    SHAFT.GUI.WebDriver driver;

    public QuickCheckPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By automatischesAufladenSOLocator = By.xpath("(//div[@class = 'sb-block-inner'])[3]");
    private static By automatischesAufladenIPSOMessage = By.xpath("(//div[@class = 'sb-block-inner'])[3]//h4");
    private static By automatischesAufladentSOLocatorActive = By.xpath("(//div[@class = 'object-content'])[3]//span");
    private static By inProgressNotificationLocator = By.xpath("(//div[@automation-id = 'undefined_nt'])[2]");
    private static By lockedNotificationMessageLocator = By.xpath("(//div[@class = 'item-2 w-100'])[2]//h4");
    private static By IPDeineNotificationSublineLocator = By.xpath("(//div[@class = 'alert-content'])[3]//p");
    private static By automatischesAufladenSectionLocator = By.xpath("//div[@class = 'wm-profile-chooser']");
    private static By greenActiveStatuesLocator = By.xpath("//span[@class = 'cell cell-right secodary-green']");
    private static By orangePauseStatuesLocator = By.xpath("//span[@class = 'cell cell-right secodary-orange']");
    private static By redBlockedStatuesLocator = By.xpath("//span[@class = 'cell cell-right red']");
    private static By deleteButtonLocator = By.xpath("//div[@class = 'auto-topup']//button[@class='btn btn-sml skiphash accordion-state btn-alt']");
    private static By closeNoticicationMessage = By.xpath("(//div[@class='notification-message-right']//*[name()='svg'])[2]");
    private static By editButtonLocator = By.xpath("//div[@class = 'auto-topup']//button[@class='btn btn-sml skiphash accordion-state']");
    private static By switchOffToggleLocator = By.xpath("//Span[@class='on-text']");
    private static By deineAutomAufladungenAccordionLocator = By.xpath("//*[@automation-id='autoTopup_so']");
    private static By setupAutomationRechargeButtonLocator = By.xpath("(//button[@automation-id= 'undefined_btn'])");
    private static By deineAutomAufladungHeadlineLocator = By.xpath("//div[@class='flex-disply'][contains(.,'Automatische Aufladung')]");
    private static By deineAutomAufladungLocator_HL = By.xpath("//div[@class='flex-disply'][contains(.,'Automatische')]");
    private static By deineAutomAufladungSublineLocator = By.xpath("//p[@class= 'notification-text mb-10 mt-10'][contains(.,'Nie wieder')]");
    private static By deineAutomAufladungSL_Locator = By.xpath("//p[@class= 'notification-text mb-10 mt-10'][contains(.,'Nie wieder zu wenig Guthaben')]");
    private static By autoTopUpAmountActiveLocator = By.xpath("(//span[@class='cell cell-right'])[1]");
    private static By autoTopUpAmountPauseLocator = By.xpath("(//span[@class='cell cell-right'])[1]");
    private static By autoTopupTypeInSO_label = By.xpath("//smart-object-footer[@automation-id='autoTopupFooter_so']/div");
    private static By nextPaymentDate_label = By.xpath("//div[@automation-id='autoTopupNextCharge_tv']/span[1]");
    private static By autoTopupTypeInAccordion_value = By.xpath("//div[@automation-id='autoTopupCycle_tv']/span[2]");
    private By AutomatischesAufladenSmartObjectLocator = By.xpath("//div[@automation-id='autoTopup_so']");
    private By autoTopUpAccLocator = By.xpath("//li[@automation-id='aufladen_acc']/a");

    //CL
    private String expandedAccClassName = "ac-head ac-active";
    private String lockedNotificationMessageCL = "Automatisches Aufladen gesperrt";
    private String iPSOMessageCL = "Automatische Aufladung wird aktiviert";
    private String iPDeineNoticicationSublineCL = "Du hast die automatische Aufladung eingerichtet. Bald kannst Du sie hier sehen.";
    private String disabledSOMessageCL = "Automatische Aufladung ist nicht aktiviert";
    private String deineAutomAufladungHeadlineCL = "Automatische Aufladung";
    private String deineAutomAufladungCL_HL = "Automatisches Aufladen";
    private String deineAutomAufladungSublineCL = "Nie wieder zu wenig Guthaben: Wir übernehmen das regelmäßige Aufladen für Dich. Klick einfach auf den Button für mehr Infos.";
    private String deineAutomAufladungSL_CL = "Dein Guthaben wird regelmäßig automatisch aufgeladen. Du musst nichts weiter tun.";
    private String automatischesAufladenActiveCL = "aktiv";
    private String automatischesAufladenBlockCL = "blockiert";
    private String automatischesAufladenPauseCL = "pausiert";
    private String autoTopUpAmountActiveCL = "5 €";
    private String autoTopUpAmountPauseCL = "15 €";
    private String lowerBalanceTypeInSO_CL = "Bei Guthaben unter 5 €";


    //Methods
    @Step("Close Notification")
    public QuickCheckPage closeNotification() {
        driver.element().click(closeNoticicationMessage);
        return this;
    }

    @Step("Click on Delete Button")
    public QuickCheckPage clickDeleteButton() {
        driver.element().click(deleteButtonLocator);
        return this;
    }

    @Step("Click on Edit Button")
    public QuickCheckPage clickEditButton() {
        driver.element().click(editButtonLocator);
        return this;
    }

    @Step("Click on Switch off/on Toggle")
    public QuickCheckPage clickSwitchOffToggle() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(switchOffToggleLocator)).click();
        return this;
    }

    @Step("Expand Deine AutomAufladungen Accordion")
    public void clickDeineAutomAufladungenAccordion() {
        driver.element().click(deineAutomAufladungenAccordionLocator);
    }

    @Step("Click Automatisches Aufladen Smart Object To Expand Deine autom. Aufladungen Accordion")
    public void clickAutomAufladenSmartObject() {
        driver.element().click(AutomatischesAufladenSmartObjectLocator);
    }

    @Step("Click Setup Automation Recharge Button")
    public void clickSetupAutomationRechargeButton() {
        driver.element().click(setupAutomationRechargeButtonLocator);
    }

    @Step("wait for page to be loaded")
    public void waitForPageToBeLoaded() {
        if ( driver.element().getElementsCount(By.xpath("fakeLocator")) == 1) {
            driver.element().click(By.xpath("fakeLocator"));
        }
    }

    public void checkDeineAutomAufladungHeadlineCL() {
        driver.verifyThat().element(deineAutomAufladungLocator_HL)
                .text().isEqualTo(deineAutomAufladungHeadlineCL)
                .withCustomReportMessage("Check Deine Autom Aufladung Headline CL").perform();
    }

    @Step("Assert ON Deine Autom Aufladung Subline CL")
    public void assertOnDeineAutomAufladungSublineCL() {
        driver.verifyThat().element(deineAutomAufladungSublineLocator)
                .text().isEqualTo(deineAutomAufladungSublineCL).perform();
    }

    public void checkAutoTopUpAmountActiveCL() {
        driver.verifyThat().element(autoTopUpAmountActiveLocator)
                .text().isEqualTo(autoTopUpAmountActiveCL)
                .withCustomReportMessage("Check Auto TopUp Amount Active CL")
                .perform();
    }

    public void checkAutoTopUpAmountPauseCL() {
        driver.verifyThat().element(autoTopUpAmountPauseLocator)
                .text().isEqualTo(autoTopUpAmountPauseCL)
                .withCustomReportMessage("Assert On Auto TopUp Amount Pause CL").perform();
    }

    @Step("Assert On Automatisches Aufladen Existance")
    public void assertOnAutomatischesAufladen() {
        driver.verifyThat().element(automatischesAufladenSOLocator).exists().
                perform();
    }

    public void checkIPSOMessageCL() {
        driver.verifyThat().element(automatischesAufladenIPSOMessage)
                .text().isEqualTo(iPSOMessageCL)
                .withCustomReportMessage("Assert On Smart Object Message CL").perform();
    }

    public void checkSOAutomatischesAufladenCL(String SOStatues) {
        driver.verifyThat().element(automatischesAufladentSOLocatorActive)
                .text().contains(SOStatues)
                .withCustomReportMessage("Check Smart Object Automatisches Aufladen CL").perform();
    }

    public void assertOnIPNotificationInAutoTopupAccordion() {
        driver.verifyThat().element(inProgressNotificationLocator).exists().
                withCustomReportMessage("Assert On IP Notification in auto topup accordion").perform();
    }

    public void checkIPDeineNotificationSublineCl() {
        driver.verifyThat().element(IPDeineNotificationSublineLocator)
                .text().isEqualTo(iPDeineNoticicationSublineCL).
                withCustomReportMessage("Assert On Deine Notification Subline CL").perform();
    }

    public void checkLockedNotificationMessageCL() {
        driver.verifyThat().element(lockedNotificationMessageLocator)
                .text().isEqualTo(lockedNotificationMessageCL).
                withCustomReportMessage("Assert ON Locked Notification Message CL").perform();
    }

    public void checkAutomatischesAufladenSection() {
        driver.verifyThat().element(automatischesAufladenSectionLocator).exists()
                .withCustomReportMessage("Check Automatisches Aufladen Section").perform();
    }

    public void checkAutomatischesAufladenCLActive() {
        driver.verifyThat().element(greenActiveStatuesLocator)
                .text()
                .isEqualTo(automatischesAufladenActiveCL)
                .withCustomReportMessage("Check Automatisches Aufladen CL Active").perform();
    }

    public void checkAutomatischesAufladenCLPause() {
        driver.verifyThat().element(orangePauseStatuesLocator)
                .text().isEqualTo(automatischesAufladenPauseCL)
                .withCustomReportMessage("Check Automatisches Aufladen CL Pause").perform();
    }

    public void checkAutomatischesAufladenCLBlock() {
        driver.verifyThat().element(redBlockedStatuesLocator)
                .text().isEqualTo(automatischesAufladenBlockCL)
                .withCustomReportMessage("Assert On Automatisches Aufladen CL Block").perform();
    }

    @Step("Assert On Disabled Message CL")
    public void assertOnDisabledSOMessageCL() {
        driver.verifyThat().element(automatischesAufladenIPSOMessage)
                .text().isEqualTo(disabledSOMessageCL).perform();
    }

    public void checkDeleteButtonDisable() {
        driver.verifyThat().element(deleteButtonLocator).isDisabled()
                .withCustomReportMessage("Assert On Deletion Button Disable").perform();
    }

    @Step("Assert On Lower Balance CL In Auto Topup SO")
    public void assertOnLowerBalanceCLInAutoTopupSO() {
        driver.verifyThat().element(autoTopupTypeInSO_label)
                .text().isEqualTo(lowerBalanceTypeInSO_CL).withCustomReportMessage("Assert on Lower Balance CL").perform();
    }

    @Step("Assert That Next Payment Date Field Does Not Exist")
    public void assertThatNextPaymentDateFieldDoesNotExist() {
        driver.verifyThat().element(nextPaymentDate_label).doesNotExist()
                .withCustomReportMessage("Assert That Next Payment Date Field Does Not Exist")
                .perform();
    }

    @Step("Assert That Lower Balance Cl in Auto Topup accordion")
    public void assertOnLowerBalanceCLInAutoTopupAccordion() {
        driver.verifyThat().element(autoTopupTypeInAccordion_value)
                .text().isEqualTo(lowerBalanceTypeInSO_CL)
                .withCustomReportMessage("Assert That Lower Balance Cl in Auto Topup accordion")
                .perform();
    }

    public void assertThatAutoTopUpAccIsExpanded() {
        driver.verifyThat().element(autoTopUpAccLocator).attribute("class").isEqualTo(expandedAccClassName).withCustomReportMessage("assert that auto top-up accordion is expanded").perform();
    }

}
