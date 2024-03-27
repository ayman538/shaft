package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Rechnungseinstellungen {

    private SHAFT.GUI.WebDriver driver;

    public Rechnungseinstellungen(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }


    private By pageTitleLocator = By.xpath("(//div[@automation-id='pageHeader_tv']/h1)[1]");
    private By transactionHeadLineLocator = By.xpath("//div[@class='tg-head tg-active']/span");
    private By tableTitle_MultiNumbers = By.xpath("//div[@class='header-title']");
    private By blackBoxLocator = By.xpath("//*[@automation-id='itemNotSelected_tv']");
    private By checkBoxHeadline = By.xpath("//*[@automation-id='checkboxText_chk']");
    private By checkBoxBody = By.xpath("//*[@automation-id='checkboxBody_chk']");
    private By checkBoxLocator = By.xpath("//*[@class='fm-check1']/input");
    private By saveChangesBtn = By.xpath("//*[@automation-id='singleButton_btn']");

    private By itemizedBillFailureMessageLocator_Headline = By.xpath("//div[@class='item-2 w-100']/h4");
    private By itemizedBillFailureMessageLocator_Body = By.xpath("//p[@class='notification-text mb-10 mt-10']");

    private By newBillingTypeLocator_GC01 = By.xpath("//*[@automation-id='confirmationCategoryThree_tv']");
    private By newBillingTypeLocator_GC02 = By.xpath("//*[@automation-id='confirmationCategoryOne_tv']");
    private By newBillingTypeLocator_GC03 = By.xpath("//*[@automation-id='confirmationCategoryTwo_tv']");
    private By submitBtn = By.xpath("//button[@automation-id='stepOneButton_btn']");
    private By transactionHeadLineLocator_MutipleNumbers = By.xpath("//*[@automation-id='step2_containertv']//div[@class='header-title']");
    private By disabledCardLocator = By.xpath("//input[@disabled='']/..//p");
    private By locator = By.xpath("//span[@span='']");
    private By notificationMsgHlLocator = By.xpath("//div[@class='item-2 w-100']/h4");
    private By notificationMsgBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']/p");
    private By editBtnLocator = By.xpath("//button[@automation-id='itemizedBillNavigateButton_btn']");


    private String pageTitleText = "Einzelverbindungsnachweise";
    private String transactionHeadLineText = "Art des Verbindungsnachweises";
    private String tableTitleText_MultiNumbers = "Rufnummer auswählen";
    private String blackBoxText = "Auf dem Einzelverbindungsnachweis sollen meine Verbindungen so angezeigt werden:";
    private String checkBoxHeadlineText = "Mitbenutzer-Erklärung";
    private String checkBoxBodyText = "Ich habe alle derzeitigen Mitbenutzer des Anschlusses informiert und werde künftige Mitbenutzer unverzüglich informieren, dass ich einen Einzelverbindungsnachweis bekomme.";
    String itemizedBillFailureMessageText_Headline = "Das hat leider nicht geklappt";
    String itemizedBillFailureMessageText_Body = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";



    public By getItemizedCardLocatorByOrder(String itemizedBillOrder){
        return By.xpath("(//div[@automation-id='undefined_rb'])["+itemizedBillOrder+"]/input");
    }

    public By getRadioBtn(String radioBtnOrder){
        return By.xpath("(//div[@class='fm-data'])["+radioBtnOrder+"]//div[@class='bgdiv']");
    }

    @Step("Click On Radio Button By Its Order in Queue")
    public void selectRadioBtn(String radioBtnOrder){
        driver.element().click(getRadioBtn(radioBtnOrder));
    }

    @Step("Click On Continue")
    public void clickOnContinueBtn_Weiter(){
        driver.element().click(submitBtn);
    }

    @Step("Click On Itemized Bill Category By Selecting The Order Of Itemized Bill Card")
    public void clickOnItemizedBillCategory(String itemizedBillOrder){
        driver.element().click(getItemizedCardLocatorByOrder(itemizedBillOrder));
    }

    @Step("Click On Save Changes Button")
    public void clickOnSaveChangesBtn_ÄnderungenSpeichern(){
        driver.element().click(saveChangesBtn);
    }

    @Step("Click Check-Box")
    public void clickOnCheckBox(){
        driver.getDriver().findElement(checkBoxLocator).click();
    }

    public void assertOnPageTitle(){
        driver.verifyThat().element(pageTitleLocator).textTrimmed()
                .isEqualTo(pageTitleText)
                .withCustomReportMessage("Assert On Page Title Text")
                .perform();
    }

    public void assertOnTransactionHeadLineText(){
        driver.verifyThat().element(transactionHeadLineLocator).textTrimmed()
                .isEqualTo(transactionHeadLineText)
                .withCustomReportMessage("Assert On Transaction Headline Text")
                .perform();
    }

    public void assertOnTransactionHeadLineText_multipleNumbers(){
        driver.verifyThat().element(tableTitle_MultiNumbers).textTrimmed()
                .isEqualTo(tableTitleText_MultiNumbers)
                .withCustomReportMessage("Assert On Transaction Headline Text")
                .perform();
    }

    public void assertOnBlackBoxText(){
        driver.verifyThat().element(blackBoxLocator).textTrimmed()
                .isEqualTo(blackBoxText)
                .withCustomReportMessage("Assert On Black Box Text")
                .perform();
    }

    public void assertOnCheckBoxHeadLineText(){
        driver.verifyThat().element(checkBoxHeadline).textTrimmed()
                .isEqualTo(checkBoxHeadlineText)
                .withCustomReportMessage("Assert On Check-Box Headline Text")
                .perform();
    }

    public void assertOnCheckBoxBody(){
        driver.verifyThat().element(checkBoxBody).textTrimmed()
                .isEqualTo(checkBoxBodyText)
                .withCustomReportMessage("Assert On Check-Box Body ")
                .perform();
    }







    public void assertOnNewBillingTypeInUbersichtAccordion_CompleteItemizedBill(String newBillingTypeText){
        driver.verifyThat().element(newBillingTypeLocator_GC01).textTrimmed().isEqualTo(newBillingTypeText)
                .withCustomReportMessage("Assert On New Billing Type In Ubersicht Accordion")
                .perform();
    }

    public void assertOnNewBillingTypeInUbersichtAccordion_LimitedItemizedBill(String newBillingTypeText){
        driver.verifyThat().element(newBillingTypeLocator_GC02).textTrimmed().isEqualTo(newBillingTypeText)
                .withCustomReportMessage("Assert On New Billing Type In Ubersicht Accordion")
                .perform();
    }

    public void assertOnNewBillingTypeInUbersichtAccordion_NoItemizedBill(String newBillingTypeText){
        driver.verifyThat().element(newBillingTypeLocator_GC03).textTrimmed().isEqualTo(newBillingTypeText)
                .withCustomReportMessage("Assert On New Billing Type In Ubersicht Accordion")
                .perform();
    }



    public void assertOnTransactionHeadLineText_MultipleNumbers(){
        driver.verifyThat().element(transactionHeadLineLocator_MutipleNumbers)
                .textTrimmed().isEqualTo(transactionHeadLineText)
                .withCustomReportMessage("Assert On Transaction Headline Text For Multiple Numbers").perform();
    }

    public void assertOnItemizedBillFailureMessage_Headline(){
        driver.verifyThat().element(itemizedBillFailureMessageLocator_Headline)
                .textTrimmed().isEqualTo(itemizedBillFailureMessageText_Headline)
                .withCustomReportMessage("Assert On Itemized Bill Failure Message Headline").perform();
    }

    public void assertOnItemizedBillFailureMessage_Body(){
        driver.verifyThat().element(itemizedBillFailureMessageLocator_Body)
                .textTrimmed().isEqualTo(itemizedBillFailureMessageText_Body)
                .withCustomReportMessage("Assert On Itemized Bill Failure Message Body").perform();
    }

    public void assertOnCurrentBillTypeThatCanNotBeChosen(String dimmedCardText){
        driver.verifyThat().element(disabledCardLocator)
                .textTrimmed()
                .isEqualTo(dimmedCardText)
                .withCustomReportMessage("Assert On Current Bill Type That Can Not Be Chosen")
                .perform();
    }

    public void assertThatPageRedirectedSuccessfully(){
        driver.verifyThat().element(locator)
                .doesNotExist()
                .withCustomReportMessage("Make Sure That Page Navigated and Loaded Successfully ")
                .perform();
    }

    /* *************************WFCT-13469 ************** */


    public void assertOnNotificationMessageHeadLine(String notificationHeadLine){
        driver.verifyThat().element(notificationMsgHlLocator).textTrimmed().isEqualTo(notificationHeadLine)
                .withCustomReportMessage("Assert On Notification Message Headline").perform();
    }

    public void assertOnNotificationMessageBody(String notificationBody){
        driver.verifyThat().element(notificationMsgBodyLocator).textTrimmed().isEqualTo(notificationBody)
                .withCustomReportMessage("Assert On Notification Message Headline").perform();
    }

    public void assertThatEditButtonIsDimmed(){
        driver.verifyThat().element(editBtnLocator).isDisabled()
                .withCustomReportMessage("Assert That Edit Button Is Dimmed").perform();
    }


}
