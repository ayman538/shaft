package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopupGPP {
    SHAFT.GUI.WebDriver driver;

    //Locators Delete Flow
    private By topUpNotification = By.xpath("//div[@automation-id='topup-notification_nt']");
    private By deleteIconLocator = By.xpath("(//span[@class='payment-delete'])[1]//a");
    private By deletePopUpHeadine = By.xpath("(//div[@class='overlay-content'])//h2");
    private By deleteButtonLocator = By.xpath("(//div[@class='fm-buttons'])//button[@class='btn btn-sml']");
    private By deleteConfirmationNotificationSublineLocator = By.xpath("//p[contains(.,'Wir haben die Bezahlmethode entfernt.')]");
    //Locators auto top up flow
    private By callYaRufnummerDropDownListLoactor = By.xpath("(//button[@automation-id='Subscription-list_btn'])");
    private By chosenCallYaRufnummerSTLocator = By.xpath("(//ul[@automation-id='Subscription-list_lv'])//li[2]");
    private static By header = By.xpath("//div[@automation-id='pageHeader_tv']");
    private static By guthabenTitle_txt = By.xpath("//*[@id='mainSpinner']/div[2]//div/h3");
    private static By paypalMethod = By.xpath("//label[@for='paymentMethod3']");
    private static By amazonPayMethod = By.xpath("//label[@for='paymentMethod0']");
    private static By kreditkarteMethod = By.xpath("//label[@for='paymentMethod1']");
    private static By sofortMethod = By.xpath("//label[@for='paymentMethod2']");
    private static By googlePayMethod = By.xpath("//label[@for='paymentMethod4']");
    private static By restricted_txt = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static By restricted2_txt = By.xpath("(//div[@automation-id='successMsg_tv'])[2]//p");
    private static By generalErrorHeader_txt = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static By generalErrorBody_txt = By.xpath("//div[@automation-id='successMsg_tv']//p");




    public static By chosenCallYaRufnummerLocator(String numberIndex) {
        return By.xpath("(//ul[@automation-id='Subscription-list_lv'])//li[" + numberIndex + "]/button");
    }

    private By chosenCallYaRufnummerSITLocator = By.xpath("(//ul[@automation-id='Subscription-list_lv'])//li[1]");
    private By autoTopUpSectionSublineLocator = By.xpath("//p[contains(.,'Nie')]");
    private By topUpNotificationBodyLoactor = By.xpath("(//div[@automation-id='topup-notification_nt']//p)[1]");
    private By topUpNotificationHyperlinkLocator = By.xpath("//div[@automation-id='topup-notification_nt']//a");
    private By autoTopUpNotificationColorLocator = By.xpath("//div[@automation-id='topup-notification_nt']/div");
    private By savedPaymentMethodSectionLocator = By.xpath("(//div[@class = 'white-box-padding-responsive'])[1]");
    private By savedPaymentMethodSectionHeadlineLocator = By.xpath("//div[@class = 'white-box-padding-responsive']//h5");
    private By switchOffToggleLocator = By.xpath("//*[@for='auto-topup']");
    private By lowerBalanceAutoTopUpLocator = By.xpath("(//label[@class = 'checked'])[2]");
    private By lowerBalanceAutoTopUpHeadlineLocator = By.xpath("//label[@class = 'checked']//p//strong");
    private By rechargeDateAutoTopUpLocator = By.xpath("(//div[@class = 'fm-data'])[2]//label");
    private By rechargeDateAutoTopUpHeadlineLocator = By.xpath("(//div[@class = 'fm-data'])[2]//label//p//strong");
    private By rechargeRadioButtonLocator = By.xpath("//label[@for='paymentMethod0']//p");
    private By payNowButtonLocator = By.xpath("//button[@class = 'btn btn-em btn-sml']");
    private static By confirmationNotificationHeadlineLocator = By.xpath("(//h4[@class= 'flexDiv'])[1]");
    private static By confirmationNotificationSublineLocator = By.xpath("(//p[@class= 'notification-text mb-10 mt-10'])[1]");
    //Locators payment
    private By sofortPayLocator = By.xpath("//button[@type='button'][contains(.,'Jetzt bezahlen')]");
    private By payPalPayLocator = By.xpath("//div[@id='paypalButton']");
    private By amazonPayLocator = By.xpath("//div[@id='amazonpay']");
    private By creditCardPayLocator = By.xpath("//button[@type='button'][contains(.,'Jetzt bezahlen')]");
    private By googlePayLocator = By.id("googlepay");
    private By externalPhoneNumberFieldLocator = By.xpath("//input[@automation-id='reference_et']");
    private By autoTopupSavedPaymentMethod_label = By.xpath("//div[@automation-id='autoTopupPayment_tv']/p");
    private By payExternalNumToggleBtnLocator = By.xpath("//*[@for='radio']");
    private By spinnerLocator = By.xpath("//div[@class='spinnerDim']");
    private By autoTopUpSectionTitleLocator = By.xpath("//div[@class='radio-tiles-holder']/following-sibling::div/p[1]");
    private By autoTopUpSectionDescriptionLocator = By.xpath("//div[@class='radio-tiles-holder']/following-sibling::div/p[2]");
    private By autoTopUpToggleBtnLocator = By.xpath("//input[@automation-id='auto-topup_swt']/..");
    private By autoTopUpToggleBtnTextLocator = By.xpath("//input[@automation-id='auto-topup_swt']/../following-sibling::div/../following-sibling::p");
    private By lowerBalanceRadioBtnLocator = By.xpath("//input[@id='balance']/../input");
    private By lowerBalanceRadioBtnTextLocator = By.xpath("//input[@id='balance']/../label/p");
    private By daysAutoTopUpRadioBtnLocator = By.xpath("//input[@id='time']/../label");
    private By daysAutoTopUpRadioBtnTextLocator = By.xpath("//input[@id='time']/../label/p");
    private By jetztBezahlenPaymentBtnLocator = By.xpath("//button[contains(.,'Jetzt bezahlen')]");
    private By paymentErrorMsgTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By paymentErrorMsgDescriptionLocator = By.xpath("//div[@automation-id='successMsg_tv']//p[@class='notification-text mb-10 mt-10']");
    private By autoTopUpNotificationTextLocator = By.xpath("//div[@class='alert-content no-head']/p[1]");
    private By autoTopUpNotificationLinkLocator = By.xpath("//div[@class='alert-content no-head']/p[2]/a");
    private By sofortAutoTopUpTooltipLocator = By.xpath("//div[@automation-id='undefinedInfoIcon_tv']/a[@class='tg-icon']/*[local-name()='svg' and @class='i-xsml']");
    private By sofortAutoTopUpTooltipMsgLocator = By.xpath("//p[@automation-id='undefined_tv']");
    private By sofortAndAmazonPayErrorNotificationTitleLocator = By.xpath("//h4[@class='flexDiv']");
    private By sofortAndAmazonPayErrorNotificationTextLocator = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By paypalFailurePaymentMsgLocator = By.xpath("//div[@id='paypalButton']/following-sibling::div/span");
    private By creditCardFailureMsgLocator = By.xpath("//div[@class='alert noselect error']//p");
    private By phoneNumberField = By.xpath("//input[@automation-id='reference_et']");
    private By deletionOverlay_Header = By.xpath("//div[@class=\"overlay-content\"]/h2");
    private By deletionOverlay_Body = By.xpath("//div[@class=\"overlay-content\"]//p");
    private By deletionOverlayCancel_Btn = By.xpath("(//div[@class=\"overlay-content\"]//div[@class=\"fm-buttons\"]//button)[2]");
    private By deletionOverlayDelete_Btn = By.xpath("(//div[@class=\"overlay-content\"]//div[@class=\"fm-buttons\"]//button)[1]");
    private By deletionNT_Header = By.xpath("(//div[@class=\"alert-content\"]//h4)[1]");
    private By deletionNT_Body = By.xpath("(//div[@class=\"alert-content\"]//p)[1]");
    private By paypalError_message = By.xpath("//span[@class='requiredinvalid']");
    private By activatedAutoTopUpToggle_Button = By.xpath("(//label[@class='checked'])[1]");
    private By toggleBtnActivationDiv = By.xpath("//ol-radio[@id='radio-balance']/..");
    private By deinZahlungTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By enableAutoTopUpBtnText = By.xpath("//label[@class='checked']/p");
    private By disabledAutoTopUp = By.xpath("//label[@class='']");
    private By autoTopUpToggleBtn_Locator = By.xpath("//input[@automation-id='auto-topup_swt']");
    private By saveSofortCheckBox_Locator = By.xpath("//*[@automation-id='checkboxItemModel.id_tv']");
    private By saveSofortStatementText_Locator = By.xpath("//*[@automation-id='checkboxItemModel.id_label_tv']");
    private By saveSofortToolTip_Locator = By.xpath("//*[@automation-id='checkboxItemModel.id_label_tv']");
    private By saveSofortToolTipText_Locator = By.xpath("//p[@automation-id='undefined_tv']");

    private By sofortErrorNotificationMsgLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By autoTopUpSavedPaymentMethodDeleteBtnLocator = By.xpath("//span[contains(.,'Aufladebetrag & Status ändern')]/ancestor::div[@class='fm-radio fm-radio-style-image']/../span");
    private By topUpConfirmationCLHeader = By.xpath("//div[@class='alert-content no-head']//p[@class='notification-text']");
    private By topUpHistoryLink = By.xpath("//a[@class='link1a']");
    private By ibanSavedPaymentMethod_Locator = By.xpath("//p[contains(.,'SEPA')]");
    private static By invalidNumberErrorMessage = By.xpath("//p[@automation-id='reference_patternErrorMessage_et']");
    private static By invalidNumberErrorMessageBackend = By.xpath("//p[@automation-id='referenceadditionalErrorMessage_et']");



    public By getSavedPaymentMethodLocator(String savedPaymentMethodName) {
        return By.xpath("(//p[contains(.,'Gespeichert: " + savedPaymentMethodName + "')])[1]");

    }

    public By getAutoTopupSavedPaymentMethod_label() {
        return autoTopupSavedPaymentMethod_label;
    }

    //CL
    private String autoTopupSavedPaymentMethod28Days_CL = "Nächste Abbuchung von ";
    private String autoTopupSavedPaymentMethod5Euros_CL = "Nächste Abbuchung bei Guthaben unter 5 €";
    private String confirmationNotificationHeadlineCL = "Zahlung beauftragt";
    private String confirmationNotificationSublineCL = "Wir haben Deinen Auftrag angenommen und prüfen die Zahlung.";
    private String deleteConfirmationNotificationSublineCL = "Wir haben die Bezahlmethode entfernt.";
    private String autoTopupDeletionOverlayHeader_CL = "Bezahlmethode löschen?";
    private String autoTopupDeletionOverlayBody_CL = "Wenn Du diese Bezahlmethode jetzt löschst, wird gleichzeitig auch Deine automatische Aufladung entfernt. Es wird dann kein Geld mehr automatisch aufgeladen.";
    private String autoTopupDeletionOverlayCancelBtn_CL = "Zurück";
    private String autoTopupDeletionOverlayDeleteBtn_CL = "Bezahlmethode löschen";
    private String deletionSuccessNTHeader_CL = "Erledigt!";
    private String deletionSuccessNTBody_CL = "Wir haben die Bezahlmethode entfernt.";
    private String deletionFailureNTHeader_CL = "Das hat leider nicht geklappt";
    private String deletionFailureNTBody_CL = "Es gab ein technisches Problem. Darum wurden Deine Änderungen nicht gespeichert. Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String savedPaymentMethodDeletionOverlayHeader_CL = "Bist Du sicher?";
    private String savedPaymentMethodDeletionOverlayBody_CL = "Möchtest Du die gespeicherten Zahlungsdaten wirklich löschen?";
    private String savedPaymentMethodDeletionOverlayCancelBtn_CL = "Abbrechen";
    private String savedPaymentMethodDeletionOverlayDeleteBtn_CL = "Diese Zahlungsdaten Löschen";
    private String autoTopupSavedPaymentMethod5Euros_verse1_CL = "Nächste Abbuchung von ";
    private String autoTopupSavedPaymentMethod5Euros_verse2_CL = " € bei Guthaben unter 5 €";
    private String autoTopupSavedPaymentMethod_CL = "Für Deine automatische Aufladung";
    private String topUpActiveNotificationBodyCL = "Du hast für diese Rufnummer bereits die automatische Aufladung aktiviert. Daher kannst Du momentan nur eine Direktaufladung auswählen.";
    private String topUpPausedNotificationBodyCL = "Du hast für diese Rufnummer die automatische Aufladung pausiert.";
    private String topUpBlockedNotificationBodyCL = "Die automatische Aufladung ist für diese Rufnummer gesperrt.";
    private String topUpInProgressNotificationBodyCL = "Du hast die automatische Aufladung eingerichtet. Es dauert nur noch etwas bis sie Dir angezeigt wird.";
    private String topUpActiveNotificationHyperlinkCL = "Automatische Aufladung ansehen";
    private String topUpPausedNotificationHyperlinkCL = "Automatische Aufladung reaktivieren";
    private String topUpBlockedNotificationHyperlinkCL = "Automatische Aufladung ansehen";
    private String topUpInProgressNotificationHyperlinkCL = "Automatische Aufladung ansehen";
    private String savedPaymentMethodSectionHeadlineCL = "Deine gespeicherten Bezahlmethoden";
    private String autoTopUpSectionSublineCL = "Nie wieder zu wenig Guthaben: Wir übernehmen das Aufladen für Dich. Du bezahlst mit PayPal, Sofort oder Kreditkarte.";
    private String lowerBalanceAutoTopUpHeadlineCL = "Bei Guthaben unter 5€ aufladen";
    private String rechargeDateAutoTopUpHeadlineCL = "Regelmäßig aufladen";
    private String autoTopUpSectionTitleCl = "Automatisches Aufladen";
    private String autoTopUpSectionDescriptionCl = "Nie wieder zu wenig Guthaben: Wir übernehmen das Aufladen für Dich. Du bezahlst mit PayPal, Sofort oder Kreditkarte. ";
    private String autoTopUpToggleBtnCl = "Guthaben automatisch aufladen";
    private String lowerBalanceRadioBtnCl = "Bei geringem Guthaben aufladen\n" +
            "Bei Guthaben unter 5 €";
    private String daysAutoTopUpRadioBtnCl = "Regelmäßig aufladen\n" +
            "Alle 28 Tage";
    private String cancelSofortMsgCl= "Du hast den Vorgang abgebrochen.";
    private String paymentErrorMsgTitleCl = "Entschuldigung, da ist was schiefgelaufen.";
    private String paymentErrorMsgDescriptionCl = "Bitte versuchen Sie es später noch einmal.";
    private String autoTopUpNotificationTextCl = "Du hast für diese Rufnummer bereits die automatische Aufladung aktiviert. Daher kannst Du momentan nur eine Direktaufladung auswählen.";
    private String autoTopUpNotificationLinkCl = "Automatische Aufladung bearbeiten";
    private String sofortAutoTopUpPaymentBtn_Cl = "Jetzt bezahlen und Aufladung aktivieren";
    private String sofortAutoTopUpTooltip_Cl = "Du ermächtigst hiermit die Vodafone GmbH einmalig den von Dir gewählten Betrag per Sofortüberweisung von Klarna von dem Konto abzubuchen, das Du im nächsten Schritt angibst. Der gewählte Betrag steht Dir dann als Guthaben zur Verfügung. Ebenso ermächtigst Du die Vodafone GmbH, Deinen gewünschten Aufladebetrag bei Erreichen der Guthabengrenze vom gleichen Bankkonto per Lastschrift einzuziehen. Das SEPA-Lastschriftmandat wird nur für die angegebene Rufnummer erteilt. Der Betrag wird der angegebenen Rufnummer gutgeschrieben. Deine Bankverbindung wird in Deinem Kundenkonto gespeichert. Sie steht Dir dann auch für individuelle Guthaben-Aufladungen bis zu einer Grenze von 200 Euro pro Monat bis auf Widerruf zur Verfügung.";
    private String iBanPaymentMethod_Cl = "SEPA-Lastschrift: (**** **** ****";
    private String paypalFailurePaymentMsg_Cl = "Du hast die Bezahlung mit PayPal abgebrochen.\n" +
            "Starte nochmal oder wähl eine andere Bezahlmethode.";
    private String creditCardFailureMsg_Cl = "Leider gab es mit Deiner Zahlung ein Problem. Wähl bitte eine andere Bezahlmethode oder wende Dich an Deine Bank.";
    private String pausedAutoTopup_CL = "Deine automatische Aufladung ist pausiert.";
    private String blockedAutoTopup_CL = "Deine automatische Aufladung ist gesperrt.";
    private String topUpConfirmationHeader = "Wir haben Deinen Auftrag angenommen. Alle Aufträge findest Du im Bereich Guthaben & Aufladehistorie. Wichtig für Dich: Es kann etwas dauern, bis der Auftrag dort sichtbar ist.";
    private String topUpHistoryCL = "Aufladehistorie ansehen";
    private String saveSofortStatementText_CL ="Bezahlmethode wird gespeichert. Hiermit erteilst Du der Vodafone GmbH die Einzugsermächtigung.";

    private String dimmedToolTipText_CL = "Du kannst keine neue Sofort IBAN, zu den gespeicherten Methoden, hinzugefügen. Du hast schon eine IBAN gespeichert. Bitte lösch die schon gespeicherte IBAN, um eine neue IBAN zu speichern.";


    //Methods
    public TopupGPP(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public TopupGPP waitForSpecifiedTime(int Duration) {
        try{
            Thread.sleep(Duration);
        }catch (Exception e){

        }
        return this;
    }
    @Step("click on the callya rufnummer dropdown list from top up GPP page")
    public TopupGPP clickCallYaRufnummerDropDownList() {
        driver.element().click(callYaRufnummerDropDownListLoactor);
        return this;
    }

    @Step("click on the chosen number from drop down list that has no auto top up")
    public TopupGPP clickChosenCallYaRufnummer(String numberIndex) {
        WebDriverWait wait = new WebDriverWait(driver.getDriver() , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(chosenCallYaRufnummerLocator(numberIndex)));
        driver.element().click(chosenCallYaRufnummerLocator(numberIndex));
        return this;
    }

    @Step("click on the hyperlink to redirect the user to auto top up accordion")
    public TopupGPP clickTopUpNotificationHyperlink() {
        driver.element().click(topUpNotificationHyperlinkLocator);
        return this;
    }

    @Step("click on the delete icon on top up GPP to delete the saved payment method")
    public TopupGPP clickDeleteIcon() {
        driver.element().click(deleteIconLocator);
        return this;
    }

    @Step("click on the delete button to confirm the deletion action")
    public TopupGPP clickDeleteButton() {
        driver.element().click(deleteButtonLocator);
        return this;
    }

    @Step("click on auto top up toggle")
    public void clickSwitchOffToggle() {
        WebDriverWait wait = new WebDriverWait( driver.getDriver() , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(switchOffToggleLocator));
        driver.element().click(switchOffToggleLocator);
//        return this;
    }

    @Step("click on the recharge radio button using days")
    public TopupGPP clickRechargeRadioButton() {
        driver.element().click(rechargeRadioButtonLocator);
        return this;
    }

    @Step("click on pay now button to confirm the auto top up")
    public TopupGPP clickPayNowButton() {
        driver.element().click(payNowButtonLocator);
        return this;
    }

    @Step("accept alert")
    public  TopupGPP acceptAlert(){
        if(driver.alert().isAlertPresent()){
            driver.alert().acceptAlert();
        }
        return this;
    }

    public By getPaymentMethodLocator(String paymentMethod) {
        return By.xpath("//p[text() = '" + paymentMethod + "']");
    }

    public By getPhoneNumberField() {
        return phoneNumberField;
    }

    public TopupGPP enterExternalPhoneNumber(String phoneNumber) {
        driver.element().click(externalPhoneNumberFieldLocator);
        driver.element().click(guthabenTitle_txt);
        driver.element().type(externalPhoneNumberFieldLocator, phoneNumber);
        return new TopupGPP(driver);
    }

    @Step("Choose Payment Method")
    public TopupGPP choosePaymentMethod(String paymentMethod) {
        driver.element().waitUntil(ExpectedConditions.visibilityOfElementLocated(getPaymentMethodLocator(paymentMethod)));
        driver.element().click(getPaymentMethodLocator(paymentMethod));
        return new TopupGPP(driver);
    }

    @Step(" Pay with Sofort")
    public SofortPage payWithSofort() {
        driver.element().waitUntil(ExpectedConditions.visibilityOfElementLocated(sofortPayLocator));
        waitForSpecifiedTime(5000);
        driver.element().click(sofortPayLocator);
        return new SofortPage(driver);
    }

    @Step(" Pay with Credit card")
    public CreditCardPage payWithCreditCard() {
        driver.element().waitUntil(ExpectedConditions.visibilityOfElementLocated(creditCardPayLocator));
        driver.element().click(creditCardPayLocator);
        return new CreditCardPage(driver);
    }

    @Step("Pay with paypal")
    public PayPalPage payWithPayPal() {

        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(20));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class , 'paypal')]")));
        executor.executeScript("arguments[0].click();",driver.getDriver().findElement(payPalPayLocator));


        return new PayPalPage(driver);
    }

    @Step("Pay with Amazon Pay")
    public AmazonPayPage payWithAmazonPay() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonPayLocator)).click();

        return new AmazonPayPage(driver);
    }

    @Step("Pay with GooglePay")
    public TopupGPP payWithGooglePay() {
        driver.element().click(googlePayLocator);
        return new TopupGPP(driver);
    }

    @Step("Switch to payment popup")
    public void switchToPaymentPopUp() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
    }

    @Step("Click on iban saved payment method")
    public void clickIbanMethod(){
        driver.element().click(ibanSavedPaymentMethod_Locator);
    }

    @Step("Switch to GPP")
    public void switchToGPP() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[0].toString());
    }

    @Step("Switch pay to external number toggle button")
    public TopupGPP switchPayExternalNumToggleBtn() {
        driver.waitUntil(ExpectedConditions.visibilityOfElementLocated(payExternalNumToggleBtnLocator));
        driver.element().click(payExternalNumToggleBtnLocator);
        return this;
    }

    @Step("Spinner Invisibility")
    public TopupGPP waitForSpinnerInvisibility() {
        if (driver.element().getElementsCount(spinnerLocator) == 1) {
            WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(driver.getDriver().findElement(spinnerLocator)));
        }
        return this;
    }

    @Step("Select Saved Payment Method")
    public void selectSavedPaymentMethod(String savedPaymentMethodName) {
        driver.element().click(getSavedPaymentMethodLocator(savedPaymentMethodName));
    }

    //WFCT-10085
    public By getDeletionButtonForSavedPaymentMethodLocator(String savedPaymentMethodNumber) {
        return By.xpath("(//span[@class=\"payment-delete\"])[" + savedPaymentMethodNumber + "]");
    }

    public void clickOnDeleteSavedPaymentMethod(String savedPaymentMethodNumber) {
        driver.element().click(getDeletionButtonForSavedPaymentMethodLocator(savedPaymentMethodNumber));
    }

    @Step("confirm on payment method deletion")
    public void clickOnDeletionConfirmationOverlay() {
        driver.element().click(deletionOverlayDelete_Btn);
    }

    public TopupGPP clickOnAutoTopUpToggleBtn() {
        driver.element().click(autoTopUpToggleBtnLocator);
        return new TopupGPP(driver);
    }

    @Step("Click on Toggle Button")
    public void clickOnToggleButton(){
        driver.element().click(autoTopUpToggleBtn_Locator);
    }

    @Step("select days auto top-up radio button")
    public void clickOnDaysAutoTopUpRadioBtn() {
        driver.element().click(daysAutoTopUpRadioBtnLocator);
    }

    @Step("click on sofort tooltip icon")
    public void clickOnSofortTooltipIcon() {
        driver.element().click(sofortAutoTopUpTooltipLocator);
    }


    @Step("click delete auto top-up saved payment method button")
    public void clickDeleteAutoTopUpSavedPaymentMethodBtn() {
        driver.element().click(autoTopUpSavedPaymentMethodDeleteBtnLocator);
    }

    public void checkAutoTopupSavedPaymentMethod28DaysCL(String amount, String date) {
        driver.verifyThat().element(autoTopupSavedPaymentMethod_label).text().isEqualTo(autoTopupSavedPaymentMethod28Days_CL + amount + " € am " + date).withCustomReportMessage("CL is correct").perform();
    }

    public By getAutoTopUpNotificationColorLocator() {
        return autoTopUpNotificationColorLocator;
    }


    @Step("Assert That Auto Topup Saved Payment Method less than 5 Euros CL")
    public void assertThatAutoTopupSavedPaymentMethodlessthan5EurosCL(String amount) {
        driver.verifyThat().element(autoTopupSavedPaymentMethod_label)
                .text()
                .isEqualTo(autoTopupSavedPaymentMethod5Euros_verse1_CL + amount + autoTopupSavedPaymentMethod5Euros_verse2_CL)
                .withCustomReportMessage("Saved Payment method CL for lower balance autotopup is correct")
                .perform();
    }

    @Step("Click on Save sofort checkbox")
    public void clickOnSaveSofortCheckBox(){
        driver.element().click(saveSofortCheckBox_Locator);
    }


    public void checkAutoTopupSavedPaymentMethodCL() {
        driver.assertThat().element(autoTopupSavedPaymentMethod_label).text().isEqualTo(autoTopupSavedPaymentMethod_CL).perform();
    }

    public void assertOnAutoTopupDeletionConfirmationOverlay() {
        driver.verifyThat().element(deletionOverlay_Header).text().isEqualTo(autoTopupDeletionOverlayHeader_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlay_Body).text().isEqualTo(autoTopupDeletionOverlayBody_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlayCancel_Btn).text().isEqualTo(autoTopupDeletionOverlayCancelBtn_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlayDelete_Btn).text().isEqualTo(autoTopupDeletionOverlayDeleteBtn_CL).withCustomReportMessage("CL is correct").perform();
    }

    public void assertOnDeletionSuccessNotification() {
        driver.verifyThat().element(deletionNT_Header).text().isEqualTo(deletionSuccessNTHeader_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionNT_Body).text().isEqualTo(deletionSuccessNTBody_CL).withCustomReportMessage("CL is correct").perform();
    }

    public void assertOnSavedPaymentMethodDeletionConfirmationOverlay() {
        driver.verifyThat().element(deletionOverlay_Header).text().isEqualTo(savedPaymentMethodDeletionOverlayHeader_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlay_Body).text().isEqualTo(savedPaymentMethodDeletionOverlayBody_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlayCancel_Btn).text().isEqualTo(savedPaymentMethodDeletionOverlayCancelBtn_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionOverlayDelete_Btn).text().isEqualTo(savedPaymentMethodDeletionOverlayDeleteBtn_CL).withCustomReportMessage("CL is correct").perform();
    }

    public void assertOnDeletionFailureNotification() {
        driver.verifyThat().element(deletionNT_Header).text().isEqualTo(deletionFailureNTHeader_CL).withCustomReportMessage("CL is correct").perform();
        driver.verifyThat().element(deletionNT_Body).text().isEqualTo(deletionFailureNTBody_CL).withCustomReportMessage("CL is correct").perform();
    }

    @Step("assert on the headline CL of confirmation notification")
    public void assertOnconfirmationNotificationHeadlineCL() {
        driver.verifyThat().element(confirmationNotificationHeadlineLocator)
                .text().isEqualTo(confirmationNotificationHeadlineCL).perform();
    }

    @Step("assert on the subline CL of confirmation notification")
    public void assertOnconfirmationNotificationSublineCL() {
        driver.verifyThat().element(confirmationNotificationSublineLocator)
                .text().isEqualTo(confirmationNotificationSublineCL)
                .withCustomReportMessage("Assert on the subline CL of confirmation notification")
                .perform();
    }

    @Step("assert on the subline CL on the delete confirmation notification")
    public void checkDeleteConfirmationNotificationSublineCL() {
        driver.assertThat().element(deleteConfirmationNotificationSublineLocator)
                .text().isEqualTo(deleteConfirmationNotificationSublineCL)
                .withCustomReportMessage("Assert on the subline CL on the delete confirmation notification")
                .perform();
    }

    public void assertOnAutoTopUPNotificationText() {

        driver.verifyThat()
                .element(autoTopUpNotificationTextLocator)
                .text().isEqualTo(autoTopUpNotificationTextCl)
                .withCustomReportMessage("check that notification CL is correct").perform();
    }

    public void assertOnNotificationLink() {
        driver.verifyThat()
                .element(autoTopUpNotificationLinkLocator).text().isEqualTo(autoTopUpNotificationLinkCl)
                .withCustomReportMessage("check that notification link CL is correct").perform();
    }

    public void assertOnAutoTopUpToggleBtnIsNotExist() {
        driver.verifyThat()
                .element(autoTopUpToggleBtnLocator)
                .doesNotExist().withCustomReportMessage("assert that toggle button is not exist")
                .perform();
    }

    public void assertOnAutoTopUpToggleBtnExists() {
        driver.verifyThat()
                .element(autoTopUpToggleBtnLocator)
                .exists().withCustomReportMessage("assert that toggle button exists")
                .perform();
    }

    public void assertOnPaymentErrorMsgTitle() {
        driver.verifyThat()
                .element(paymentErrorMsgTitleLocator).textTrimmed()
                .isEqualTo(paymentErrorMsgTitleCl)
                .withCustomReportMessage("check error msg title is correct").perform();
    }

    public void assertOnPaymentErrorMsgDescription() {
        driver.verifyThat()
                .element(paymentErrorMsgDescriptionLocator).textTrimmed()
                .isEqualTo(paymentErrorMsgDescriptionCl)
                .withCustomReportMessage("check error msg description is correct").perform();
    }

    public void assertIfLowerBalanceRadioBtnIsCheckedByDefault() {
        driver.verifyThat()
                .element(lowerBalanceRadioBtnLocator).isChecked()
                .withCustomReportMessage("assertIfLowerBalanceRadioBtnIsCheckedByDefault").perform();
    }

    public void assertOnLowerBalanceRadioBtnText() {
        driver.verifyThat()
                .element(lowerBalanceRadioBtnTextLocator).text()
                .isEqualTo(lowerBalanceRadioBtnCl)
                .withCustomReportMessage("check lower balace radio btn text").perform();

    }

    public void assertOnDaysAutoTopUpRadioBtnText() {
        driver.verifyThat()
                .element(daysAutoTopUpRadioBtnTextLocator).text()
                .isEqualTo(daysAutoTopUpRadioBtnCl)
                .withCustomReportMessage("check days auto top up radio btn text").perform();
    }

    public void assertOnAutoTopUpSofortPaymentBtnCl() {
        driver.verifyThat()
                .element(sofortPayLocator).text()
                .isEqualTo(sofortAutoTopUpPaymentBtn_Cl)
                .withCustomReportMessage("assert on auto topUp sofort paymen btn Cl").perform();
    }

    public void assertIfSofortTooltipTextIsCorrect() {
        driver.verifyThat()
                .element(sofortAutoTopUpTooltipMsgLocator).text()
                .isEqualTo(sofortAutoTopUpTooltip_Cl)
                .withCustomReportMessage("assert on sofort tooltip text").perform();
    }

    public void assertOnSavedPaymentMethodExistence(String paymentMethod) {
        driver.verifyThat()
                .element(getSavedPaymentMethodLocator(paymentMethod))
                .exists().withCustomReportMessage("assert that specific payment method exist as a saved payment method").perform();

    }

    public void assertOnSavedPaymentMethodCL() {
        driver.verifyThat()
                .element(ibanSavedPaymentMethod_Locator)
                .text().contains(iBanPaymentMethod_Cl)
                .withCustomReportMessage("assert that sofort saved payment method CL is correct").perform();
    }

    public void assertThatIbanMethodNotExist() {
        driver.verifyThat()
                .element(ibanSavedPaymentMethod_Locator)
                .doesNotExist()
                .withCustomReportMessage("assert that sofort saved payment method doesn not exist").perform();
    }

    public void assertThatIbanMethodExists() {
        driver.verifyThat()
                .element(ibanSavedPaymentMethod_Locator)
                .exists()
                .withCustomReportMessage("assert that sofort saved payment method exists").perform();
    }

    public void assertOnSofortAndAmazonPayErrorTitle() {
        driver.verifyThat().element(sofortAndAmazonPayErrorNotificationTitleLocator).text().isEqualTo("Entschuldigung, da ist was schiefgelaufen.").withCustomReportMessage("Error Notification title Assertion ").perform();
    }

    public void assertOnSofortAndAmazonPayErrorText() {
        driver.verifyThat().element(sofortAndAmazonPayErrorNotificationTextLocator).text().isEqualTo("Bitte versuchen Sie es später noch einmal.").withCustomReportMessage("Error Notification Text Assertion ").perform();
    }

    public void assertOnPayPalErrorText() {
        driver.verifyThat().element(paypalFailurePaymentMsgLocator).text().isEqualTo(paypalFailurePaymentMsg_Cl).withCustomReportMessage(" PayPal Error Notification Text Assertion ").perform();
    }

    public void assertOnCreditCardErrorText() {
        driver.verifyThat().element(creditCardFailureMsgLocator).text().isEqualTo(creditCardFailureMsg_Cl).withCustomReportMessage(" Credit card Error Notification Text Assertion ").perform();
    }

    @Step("check that top up notification does not exist on top up GPP")
    public void checkTopUpNotificationNotExist() {
        driver.assertThat().element(topUpNotification).doesNotExist().perform();
    }

    @Step("check that auto top up toggle exist on top up GPP")
    public void checkSwitchOffToggleExist() {
        WebDriverWait wait = new WebDriverWait(driver.getDriver() , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(switchOffToggleLocator));
        driver.assertThat().element(switchOffToggleLocator).exists().perform();
    }

    @Step("assert on the headline CL on the delete pop up notification")
    public void checkDeletePopUpHeadline() {
        driver.assertThat().element(deletePopUpHeadine).exists().perform();
    }

    @Step("check on the existence of top up notification")
    public void checkTopUpNotificationExist() {
        driver.assertThat().element(topUpNotification).exists().perform();
    }

    @Step("check that auto top up does not exist on the top up GPP")
    public void checkSwitchOffToggleNotExist() {
        driver.assertThat().element(switchOffToggleLocator).doesNotExist().perform();
    }

    @Step("assert on the headline of saved payment method section")
    public void checkSavedPaymentMethodSectionHeadlineCL() {
        driver.assertThat().element(savedPaymentMethodSectionHeadlineLocator)
                .text().isEqualTo(savedPaymentMethodSectionHeadlineCL).perform();
    }

    @Step("check on the exist of the saved payment method section")
    public void checkSavedPaymentMethodExist() {
        driver.assertThat().element(savedPaymentMethodSectionLocator).exists().perform();
    }

    @Step("assert on the body CL of the active auto top up notification")
    public void checkTopUpActiveNotificationBodyCL() {
        driver.assertThat().element(topUpNotificationBodyLoactor)
                .text().isEqualTo(topUpActiveNotificationBodyCL).perform();
    }

    @Step("assert on the body CL of the paused auto top up notification")
    public void checkTopUpPausedNotificationBodyCL() {
        driver.assertThat().element(topUpNotificationBodyLoactor)
                .text().isEqualTo(topUpPausedNotificationBodyCL).perform();
    }

    @Step("assert on the body CL of the blocked auto top up notification")
    public void checkTopUpBlockedNotificationBodyCL() {
        driver.assertThat().element(topUpNotificationBodyLoactor)
                .text().isEqualTo(topUpBlockedNotificationBodyCL).perform();
    }

    @Step("assert on the body CL of the in progress auto top up notification")
    public void checkTopUpInProgressNotificationBodyCL() {

        driver.assertThat().element(topUpNotificationBodyLoactor)
                .text().isEqualTo(topUpInProgressNotificationBodyCL).perform();
    }

    @Step("assert on the hyperlink CL on active auto top up notification")
    public void checkTopUpActiveNotificationHyperlinkCL() {
        driver.assertThat().element(topUpNotificationHyperlinkLocator)
                .text().isEqualTo(topUpActiveNotificationHyperlinkCL).perform();
    }

    @Step("assert on the hyperlink CL on paused auto top up notification")
    public void checkTopUpPausedNotificationHyperlinkCL() {
        driver.assertThat().element(topUpNotificationHyperlinkLocator)
                .text().isEqualTo(topUpPausedNotificationHyperlinkCL).perform();
    }

    @Step("assert on the hyperlink CL on blocked auto top up notification")
    public void checkTopUpBlockedNotificationHyperlinkCL() {
        driver.assertThat().element(topUpNotificationHyperlinkLocator)
                .text().isEqualTo(topUpBlockedNotificationHyperlinkCL).perform();
    }

    @Step("assert on the hyperlink CL on in progress auto top up notification")
    public void checkTopUpInProgressNotificationHyperlinkCL() {
        driver.assertThat().element(topUpNotificationHyperlinkLocator)
                .text().isEqualTo(topUpInProgressNotificationHyperlinkCL).perform();
    }

    @Step("assert on the headline of the lower balance auto top up section")
    public void checkLowerBalanceAutoTopUpHeadlineCL() {
        driver.verifyThat().element(lowerBalanceAutoTopUpHeadlineLocator)
                .text().isEqualTo(lowerBalanceAutoTopUpHeadlineCL).perform();
    }

    @Step("assert on the headline of the recharge date auto top up section")
    public void checkRechargeDateAutoTopUpHeadlineCL() {
        driver.verifyThat().element(rechargeDateAutoTopUpHeadlineLocator)
                .text().isEqualTo(rechargeDateAutoTopUpHeadlineCL).perform();
    }

    @Step("assert on the existance of lower balance auto top up section")
    public void checkLowerBalanceAutoTopUpExist() {
        driver.verifyThat().element(lowerBalanceAutoTopUpLocator).exists().perform();
    }

    @Step("assert on the existance of recharge date auto top up section")
    public void checkRechargeDateAutoTopUpExist() {
        driver.verifyThat().element(rechargeDateAutoTopUpLocator).exists().perform();
    }

    @Step("assert on the subline line of auto top up section")
    public void checkAutoTopUpSectionSublineCL() {
        driver.verifyThat().element(autoTopUpSectionSublineLocator)
                .text().isEqualTo(autoTopUpSectionSublineCL).perform();
    }

    @Step("Assert that no special text is displayed for in progress user")
    public void assertThatNoSpecialTextIsDisplayedForSavedPaymentMethod() {
        driver.assertThat().element(autoTopupSavedPaymentMethod_label)
                .doesNotExist()
                .withCustomReportMessage("Assert that no special text is displayed for in progress user")
                .perform();
    }

    @Step("Assert on Saved Payment Method CL for paused user")
    public void assertOnSavedPaymentMethodCLForPausedAutoTopup() {
        driver.verifyThat()
                .element(autoTopupSavedPaymentMethod_label)
                .text().isEqualTo(pausedAutoTopup_CL)
                .withCustomReportMessage("Saved Payment Method CL for Paused Status is correct ")
                .perform();

    }

    @Step("Assert on Saved Payment Method CL for blocked used")
    public void assertOnSavedPaymentMethodCLForBlockedAutoTopup() {
        driver.verifyThat()
                .element(autoTopupSavedPaymentMethod_label)
                .text().isEqualTo(blockedAutoTopup_CL)
                .withCustomReportMessage("Saved Payment Method CL for Blocked Status is correct ")
                .perform();

    }

    public void assertThatElementIsRed(By element) {
        driver.verifyThat()
                .element(element).cssProperty("color")
                .contains("230, 0, 0")
                .withCustomReportMessage("assert that element text in Red color")
                .perform();
    }


    public void assertThatElementIsOrange(By element) {
        driver.verifyThat()
                .element(element).cssProperty("color")
                .contains("235, 151, 0")
                .withCustomReportMessage("assert that element text in orange color")
                .perform();
    }

    public void assertThatElementBackgroundIsBlue(By element) {
        driver.verifyThat()
                .element(element).cssProperty("background")
                .contains("240, 247, 249")
                .withCustomReportMessage("assert that element background in blue color")
                .perform();
    }

    public void assertThatElementBackgroundIsRed(By element) {
        driver.verifyThat()
                .element(element).cssProperty("background")
                .contains("254, 240, 240")
                .withCustomReportMessage("assert that element background in Red color")
                .perform();
    }

    @Step("Assert That Auto Top Up Toggle Button is Activated")
    public void assertThatToggleBtnActivated() {
        driver.verifyThat().element(toggleBtnActivationDiv).exists()
                .withCustomReportMessage("Assert That Auto Top Up Toggle Button is Activated")
                .perform();

    }

    @Step("Assert That Auto Top Up Toggle Button is not Activated")
    public void assertThatToggleBtnNotActivated() {
        driver.verifyThat().element(toggleBtnActivationDiv).doesNotExist().perform();
    }

    @Step("Assert on Redirection To Auto Top Up GPP And Toggle Button is Activated")
    public void assertOnRedirectionToAutoTopUpGPPAndToggleBtnActivated() {
        driver.verifyThat().browser().url().contains("meinvodafone/account/payment/uebersicht").perform();
    }

    public void assertThatUserNavigatedTOAutoGPP() {
        driver.verifyThat().element(deinZahlungTitle).exists()
                .withCustomReportMessage("Assert That User navigated to AutoTopGPP").perform();
    }

    public void assertThatAutoTopUpEnabled_MeineDaten() {
        driver.assertThat().element(enableAutoTopUpBtnText).exists()
                .withCustomReportMessage("Assert That Auto Top Up Enabled").perform();
    }

    public void assertOnSofortErrorMsg() {
        driver.verifyThat().element(sofortErrorNotificationMsgLocator).text().isEqualTo(cancelSofortMsgCl).withCustomReportMessage("assert on sofort cancel msg ").perform();
    }


    public void assertThatAutoTopUpIsDisabled_MeineDaten(){
        driver.verifyThat().element(disabledAutoTopUp).exists()
                .withCustomReportMessage("Assert That Auto Top Up Is Disabled").perform();
    }

    public void assertThatTopUpConfirmationCLHeader(){
        driver.verifyThat().element(topUpConfirmationCLHeader)
                .textTrimmed().isEqualTo(topUpConfirmationHeader)
                .withCustomReportMessage("Assert That Top Up Confirmation CL Header")
                .perform();
    }

    public void assertOnTopUpHistoryCL(){
        driver.verifyThat().element(topUpHistoryLink)
                .textTrimmed().isEqualTo(topUpHistoryCL)
                .withCustomReportMessage("Assert On Top Up History")
                .perform();
    }



    public void assertThatSaveSofortCheckboxNotExists(){
        driver.verifyThat().element(saveSofortCheckBox_Locator).doesNotExist().withCustomReportMessage("assert that save sofort checkbox not exists").perform();
    }

    public void assertThatSaveSofortStatementNotExists(){
        driver.verifyThat().element(saveSofortStatementText_Locator).doesNotExist().withCustomReportMessage("assert that save sofort statement not exists").perform();
    }

    public void assertThatSaveSofortToolTipNotExists(){
        driver.verifyThat().element(saveSofortToolTip_Locator).doesNotExist().withCustomReportMessage("assert that save sofort tooltip not exists").perform();
    }

    public void assertThatSaveSofortCheckBoxEnabled(){
        driver.verifyThat().element(saveSofortCheckBox_Locator).isEnabled().withCustomReportMessage("assert that saved sofort checkbox is enabled").perform();
    }

    public void assertThatSaveSofortCheckBoxDisabled(){
        driver.verifyThat().element(saveSofortCheckBox_Locator).isDisabled().withCustomReportMessage("assert that saved sofort checkbox is disabled").perform();
    }

    public void assertOnSaveSofortStatementText(){
        driver.verifyThat().element(saveSofortStatementText_Locator).textTrimmed().isEqualTo(saveSofortStatementText_CL).withCustomReportMessage("assert on save sofort statement text while there is no iban saved").perform();
    }

    public void assertOnSaveSofortToolTipText_NoIbanSaved(){
        driver.verifyThat().element(saveSofortToolTipText_Locator).textTrimmed().isEqualTo(sofortAutoTopUpTooltip_Cl).withCustomReportMessage("assert on save sofort tool tip text").perform();
    }

    public void assertOnSaveSofortToolTipText_IbanSaved(){
        driver.verifyThat().element(saveSofortToolTipText_Locator).textTrimmed().isEqualTo(dimmedToolTipText_CL).withCustomReportMessage("assert on save sofort tool tip text while there is iban saved").perform();
    }

    @Step("Click on Header")
    public TopupGPP clickOnGuthabenTitle(){
        driver.waitUntil(ExpectedConditions.visibilityOfElementLocated(header));
        driver.element().click(guthabenTitle_txt);
        return this;
    }

    @Step("Click on Sofort Checkbox")
    public TopupGPP clickOnSofortCheckBox(){
        driver.element().click(sofortMethod);
        return this;
    }
    @Step("Validate Topup GPP header")
    public TopupGPP validateTopupGppHeader(String expectedHeader) {
        driver.verifyThat()
                .element(header)
                .text()
                .contains(expectedHeader)
                .perform();
        return this;
    }
    public TopupGPP assertOnPaypalMethodNotExist() {
        driver.verifyThat()
                .element(paypalMethod)
                .doesNotExist().withCustomReportMessage("paypal method is not exist")
                .perform();
        return this;
    }

    public TopupGPP assertOnAmazonPayMethodNotExist() {
        driver.verifyThat()
                .element(amazonPayMethod)
                .doesNotExist().withCustomReportMessage("AmazonPay method is not exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnKreditkarteMethodNotExist() {
        driver.verifyThat()
                .element(kreditkarteMethod)
                .doesNotExist().withCustomReportMessage("kreditkarte method is not exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnSofortMethodNotExist() {
        driver.verifyThat()
                .element(sofortMethod)
                .doesNotExist().withCustomReportMessage("sofort method is not exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnPaypalMethodExist() {
        driver.verifyThat()
                .element(paypalMethod)
                .exists().withCustomReportMessage("paypal method is exist")
                .perform();
        return this;
    }

    public TopupGPP assertOnAmazonPayMethodExist() {
        driver.verifyThat()
                .element(amazonPayMethod)
                .exists().withCustomReportMessage("AmazonPay method is exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnKreditkarteMethodExist() {
        driver.verifyThat()
                .element(kreditkarteMethod)
                .exists().withCustomReportMessage("kreditkarte method is exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnSofortMethodExist() {
        driver.verifyThat()
                .element(sofortMethod)
                .exists().withCustomReportMessage("sofort method is exist")
                .perform();
        return this;
    }
    public TopupGPP assertOnGooglePayMethodExist() {
        driver.verifyThat()
                .element(googlePayMethod)
                .exists().withCustomReportMessage("google Pay method is exist")
                .perform();
        return this;
    }
    @Step("Validate Error msg for RESTRICTED single payment method paypal")
    public TopupGPP validateErrorMessageForRestrictedMultiplePaymentMethod(String expectedRestrictedPaypalPaymentMethod) {
        driver.verifyThat()
                .element(restricted_txt)
                .textTrimmed()
                .contains(expectedRestrictedPaypalPaymentMethod)
                .perform();
        return this;
    }
    @Step("Validate Error msg for RESTRICTED single payment method paypal")
    public TopupGPP validateErrorMessageForRestrictedPaymentMethod(String expectedRestrictedPaymentMethod) {
        driver.verifyThat()
                .element(restricted_txt)
                .text()
                .contains(expectedRestrictedPaymentMethod)
                .perform();
        return this;
    }
    @Step("Validate Error msg for RESTRICTED single payment method sofort")
    public TopupGPP validateErrorMessageForRestrictedSofortPaymentMethod(String expectedRestrictedSofortPaymentMethod) {
        driver.verifyThat()
                .element(restricted_txt)
                .text()
                .contains(expectedRestrictedSofortPaymentMethod)
                .perform();
        return this;
    }
    @Step("Validate Error msg for RESTRICTED single payment method sofort")
    public TopupGPP validateNotifiationMessageForIncorrectPhoneNumber(String expectedInvalidNumberNotificationMsg) {
        driver.verifyThat()
                .element(restricted_txt)
                .text()
                .contains(expectedInvalidNumberNotificationMsg)
                .perform();
        return this;
    }
    @Step("Validate Error msg for RESTRICTED single payment method paypal")
    public TopupGPP validateErrorMessageForRestrictedMaxBalanceReached(String expectedRestrictedMaxBalanceReached) {
        driver.verifyThat()
                .element(restricted_txt)
                .text()
                .contains(expectedRestrictedMaxBalanceReached)
                .perform();
        return this;
    }
    @Step("Validate Error msg for Invalid Mob number")
    public TopupGPP validateErrorMessageForInvalidNumber(String expectedInvalidNumberErrorMsg) {
        driver.verifyThat()
                .element(invalidNumberErrorMessage)
                .text()
                .contains(expectedInvalidNumberErrorMsg)
                .perform();
        return this;
    }
    @Step("Validate backend Error msg for Invalid Mob number")
    public TopupGPP validateErrorMessageForInvalidNumberBackend(String expectedInvalidNumberErrorMsg) {
        driver.verifyThat()
                .element(invalidNumberErrorMessageBackend)
                .text()
                .contains(expectedInvalidNumberErrorMsg)
                .perform();
        return this;
    }
    @Step("Validate Barred For Any Barring Reason Error Message")
    public TopupGPP validateBarredForAnyBarringReason(String expectedBarredForAnyBarringReason) {
        driver.verifyThat()
                .element(restricted_txt)
                .text()
                .contains(expectedBarredForAnyBarringReason)
                .perform();
        return this;
    }
    @Step("Validate General Error page")
    public TopupGPP validateGeneralErrorPage(String expectedGeneralErrorHeader,String expectedGeneralErrorBody) {
        driver.verifyThat()
                .element(generalErrorHeader_txt)
                .text()
                .contains(expectedGeneralErrorHeader)
                .perform();
        driver.verifyThat()
                .element(generalErrorBody_txt)
                .text()
                .contains(expectedGeneralErrorBody)
                .perform();

        return this;
    }
}