package de.vodafone.pages.MNP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class StartPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By pageHeader = By.xpath("//*[@data-automation-id='pageHeader_tv']");
    private static By errorPageHeader = By.xpath("//*[@data-automation-id='pageHeader_tv']");
    private static By vodafoneNumberText = By.xpath("//p[@data-automation-id='msisdn_tv']");
    private static By vodafoneNumber = By.xpath("//p[@data-automation-id='msisdn_tv']");
    private static By informationMessage3Title = By.xpath("//*[@data-automation-id='warning_nt']//h5");
    private static By informationMessage3Details = By.xpath("//*[@data-automation-id='warning_nt']//p");
    private static By abbrechenButton = By.xpath("//*[@data-automation-id='cancel_btn']");
    private static By jetztRufNummernMitnahmeStartenButton = By.xpath("//*[@data-automation-id='start_btn']");
    private static By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By pageFailedErrorMsg1Header = By.xpath("//*[@data-automation-id='error_nt']//h5");
    private static By pageFailedErrorMsg1Body = By.xpath("//*[@data-automation-id='error_nt']//p");
    private static By schnellstmöglichRadioButton = By.xpath("//div[@data-automation-id='timeOfPortability_rb']//input[@Label='Schnellstmöglich']");
    private static By zumVertragsendeRadioButton = By.xpath("//div[@data-automation-id='timeOfPortability_rb']//input[@Label='Zum Vertragsende']");
    private static By phoneNumber = By.xpath("//input[@data-automation-id='phoneNumber_et']");
    private static By provider = By.xpath("//*[@data-automation-id='provider_ddl']");
    private static By privatkundeCheckBox = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[1]");
    private static By geschäftskundeCheckBox = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[2]");
    private static By vorname = By.xpath("//input[@data-automation-id='firstName_et']");
    private static By nachname = By.xpath("//input[@data-automation-id='lastName_et']");
    private static By geburtsdatum = By.xpath("//input[@data-automation-id='birthDate_et']");
    private static By vertragsende = By.xpath("//input[@data-automation-id='endOfContract_et']");
    private static By optInDatum = By.xpath("//input[@data-automation-id='optInDate_et']");
    private static By firmenname = By.xpath("//input[@data-automation-id='companyName_et']");
    private static By kundnennummer = By.xpath("//input[@data-automation-id='customerNumber_et']");
    private static By cancelButton1 = By.xpath("(//*[@data-automation-id='cancel_btn'])[1]");
    private static By nextStepButton = By.xpath("(//button[@data-automation-id='next_btn'])[1]");
    private static By nextStepButton2 = By.xpath("//button[@data-automation-id='timeOfPortabilityStepNext_btn']");
    private static By nextStepButton3 = By.xpath("(//button[@data-automation-id='next_btn'])[2]");
    private static By successMessageHeader = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt'])//h5");
    private static By successMessageDetails = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt'])//p");
    private static By failureMessageHeader = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt'])//h5");
    private static By failureMessageDetails = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt'])//p");
    private static By failureMessageDetailsGeneral1 = By.xpath("(//div[@data-automation-id='error_nt']//p)[1]");
    private static By failureMessageDetailsGeneral2 = By.xpath("(//div[@data-automation-id='error_nt']//p)[2]");
    private static By informationMessageStep4Title = By.xpath("(//*[@data-automation-id='previousContract_nt'])//h5");
    private static By informationMessageStep4Details = By.xpath("(//*[@data-automation-id='previousContract_nt'])//p");
    private static By contractEndDateStep4 = By.xpath("(//*[@data-automation-id='previousContract_tv']//strong)[1]");
    private static By optInValidityDateStep4 = By.xpath("(//*[@data-automation-id='previousContract_tv']//strong)[2]");
    private static By timeOfNumberPortabilityStep4 = By.xpath("(//*[@data-automation-id='previousContract_tv']//strong)[3]");
    private static By repeatEmailFieldStep3 = By.xpath("//input[@data-automation-id='confirmEmail_et']");
    private static By emailFieldStep3 = By.xpath("//input[@data-automation-id='email_et']");
    private static By emptySpace = By.xpath("//*[@data-automation-id='headline_tv']");
    private static By firstNameStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[2]");
    private static By lastNameStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[3]");
    private static By dateOfBirthStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[4]");
    private static By companyNameStep4 = By.xpath("((//*[@data-automation-id='businessDetails_tv'])//strong)[2]");
    private static By customerNumberStep4 = By.xpath("((//*[@data-automation-id='businessDetails_tv'])//strong)[3]");
    private static By emailFieldStep4 = By.xpath("((//*[@data-automation-id='comfirmationEmail_tv'])//strong)");
    private static By orderNowButton = By.xpath("//*[@data-automation-id='portingOverviewOrder_btn']");
    private static By warningMessageTitle = By.xpath("//*[@data-automation-id='checkToOrder_nt']//h5");
    private static By warningMessageDetails = By.xpath("//*[@data-automation-id='checkToOrder_nt']//p");
    private static By step3Header = By.xpath("//*[@id='emailAddress_acc']//h2");
    private static By step3SubHeader = By.xpath("//*[@id='emailAddress_acc']//h5");
    private static By step4Header = By.xpath("((//div[@id='overview_acc'])//h2)[1]");
    private static By step4SubHeader = By.xpath("((//div[@id='overview_acc'])//h5)");
    private static By textBelowEmailAddress = By.xpath("(//*[@id='emailAddress_acc']//span[1])[1]");
    private static By textBelowRepeatEmailAddress = By.xpath("(//*[@id='emailAddress_acc']//span[1])[2]");
    private static By repeatEmailErrorMsg = By.xpath("(//*[@id='emailAddress_acc']//span[1])[2]");
    private static By emailAddressErrorMsg = By.xpath("(//*[@id='emailAddress_acc']//span[1])[1]");
    private static By firstCheckBoxStep4 = By.xpath("((//*[@data-automation-id='checkToOrder_tv'])//label)[1]");
    private static By secondCheckBoxStep4 = By.xpath("((//*[@data-automation-id='checkToOrder_tv'])//label)[2]");

    // CLs
    private static String pageHeaderCL = "Rufnummer online mitbringen";
    private static String vodafoneNumberTextCL = "Deine Vodafone-Rufnummer:";
    private static String pageFailedErrorMsgHeader_CL = "Tut uns leid!";
    private static String pageFailedErrorMsgBody_CL = "Bei der Datenübertragung ist uns ein Fehler passiert. Bitte lad die Seite neu.";
    private static String successMessageAsSoonAsPossibleTitleCL = "Rufnummer so schnell wie möglich mitnehmen";
    private static String successMessageAsSoonAsPossibleDetailsCL1 = "Das heißt, in ca. 8 Kalendertagen\n" +
            "Dein Vertrag bei Deinem bisherigen Anbieter bleibt trotz der Rufnummern- Mitnahme bestehen.Du zahlst bis zu Deinem Kündigungstermin bei Deinem bisherigen Anbieter und bei uns.Denk bitte daran, Deinen bisherigen Vertrag zu kündigen.Das ist mit unserem Kündigungshelfer ganz einfach.";
    private static String successMessageAtEndOfContractTitleCL ="Super!";
    private static String successMessageAtEndOfContractDetailsCL ="Du nimmst Deine Rufnummer zum Vertragsende mit.";
    private static String successMessage3TitleCL = "Du kannst Deine Rufnummer zu uns mitbringen. Das dauert ca. 8 Kalendertage.";
    private static String successMessage3DetailsCL = "Klick bitte auf \"Weiter\".";
    private static String failureMessageWithoutContractEndDateTitleCL = "Du willst Deine bisherige Rufnummer erst dann bei uns nutzen, wenn Dein Vertrag bei Deinem bisherigen Anbieter endet?";
    private static String failureMessageWithoutContractEndDateDetailsCLPart1 = "Dann kündige bitte Deinen bisherigen Vertrag. Das ist mit unserem Kündigungshelfer ganz einfach. Sobald Du die Kündigungsbestätigung mit Kündigungstermin hast, kannst Du hier Deine Rufnummern-Mitnahme beauftragen.";
    private static String failureMessageWithoutContractEndDateDetailsCLPart2 = "\"Schnellstmöglich\" kannst Du aber jederzeit wählen.";
    private static String failureMessageMoreThan90DaysTitleCL = "Rufnummern-Mitnahme nicht mehr möglich";
    private static String failureMessageMoreThan90DaysDetailsCLPart1 = "Leider kannst Du Deine Rufnummer nicht mehr zu uns mitnehmen. Dein Kündigungstermin liegt mehr als 90 Tage zurück.";
    private static String failureMessageMoreThan90DaysDetailsCLPart2 ="Stimmt der Kündigungstermin, den Du eingegeben hast?";
    private static String failureMessageMoreThan90DaysDetailsCLPart3 = "Falls Dein bisheriger Vertrag wirklich schon mehr als 90 Tage beendet ist, können wir nichts mehr machen. Das tut uns sehr leid. Du kannst unsere Services mit Deiner neuen Vodafone-Rufnummer nutzen.";
    private static String failureMessageInvalidOptInDateTitleCL = "Aktuell sind die Voraussetzungen zur Mitnahme Deiner Rufnummer bei Deinem bisherigen Anbieter nicht erfüllt.";
    private static String failureMessageInvalidOptInDateDetailsCLPart1 = "Eine Rufnummern-Mitnahme zu Deinem Vertragsende kannst Du frühestens 4 Monate vor Deinem Vertragsende beauftragen, also ab dem ";
    private static String failureMessageInvalidOptInDateDetailsCLPart2 = "Möchtest du alternativ \"schnellstmöglich\" (vor Deinem Vertragsende) Deine Rufnummer zu uns mitnehmen, lass zunächst bei Deinem bisherigen Anbieter das so genannte \"Opt-in\" setzen. Ruf dazu einfach die Kundenbetreuung Deines bisherigen Anbieters an.";
    private static String failureMessageInvalidOptInDateDetailsCLPart3 = "Weitere Informationen zur Rufnummernmitnahme findest Du hier: FAQ";
    private static String failureMessageFourMonthsInFutureTitleCL = "Du willst Deine bisherige Rufnummer erst dann bei uns nutzen, wenn Dein Vertrag bei Deinem bisherigen Anbieter endet?";
    private static String failureMessageFourMonthsInFutureDetailsCLPart1 = "Das kannst Du frühestens 4 Monate vor Vertragsende beauftragen, also erst ab ";
    private static String failureMessageFourMonthsInFutureDetailsCLPart2 =  "\"Schnellstmöglich\" kannst Du aber jederzeit wählen.";
    private static String failureMessageAllEmptyTitleCL = "Bevor Du Deine Rufnummern-Mitnahme bei uns beauftragen kannst:";
    private static String failureMessageAllEmptyDetailsCLPart1 = "Aktuell sind die Voraussetzungen zur Mitnahme Deiner Rufnummer bei Deinem bisherigen Anbieter nicht erfüllt.Was Du tun musst, erfährst Du hier: FAQ";
    private static String failureMessageAllEmptyDetailsCLPart2 = "Bereite bitte zuerst Deine Rufnummern - Mitnahme bei Deinem bisherigen Anbieter vor.Hol dann bei ihm Dein aktuelles Portierungsdaten - Dokument ein.Wenn Du es hast, kannst Du die Mitnahme Deiner Rufnummer bei Vodafone beauftragen.";
    private static String generalFailureMessageCL = "Ups! Die Technik hakt grad. Sorry, unser Fehler. Deine Rufnummern-Mitnahme können wir im Moment nicht bearbeiten. Bitte versuch's später nochmal. Danke für Dein Verständnis!";
    private static String informationMessage3TitleCL = "Wichtig";
    private static String informationMessage3DetailsCLPart1 = "Du bist jetzt mit der Vodafone-Rufnummer ";
    private static String informationMessage3DetailsCLPart2 = " angemeldet. Sie wird durch Deine bisherige Rufnummer ersetzt. Willst Du das? Dann gib bitte auf den nächsten Seiten Deine Daten ein. Achte dabei auf die Hinweise zu den einzelnen Schritten.";
    private static String informationMessage4TitleCL = "Wichtig";
    private static String informationMessage4DetailsCL = "Prüf Deine Daten genau. Deine Rufnummern-Mitnahme klappt nur, wenn die Daten exakt mit den Daten in Deinem bisherigen Vertrag übereinstimmen.";
    private static String warningMessageTitleCL = "Wichtig";
    private static String warningMessageDetailsCL = "Stelle sicher, dass die Rufnummern-Mitnahme mit Deinem Unternehmen abgestimmt ist.";
    private static String contractEndDateCL = "Gekündigt zum ";
    private static String timeOfNumberPortabilityAtEndOfContractCL = "Zum Vertragsende";
    private static String mandatoryText_CL = "Pflichtfeld";
    private static String step3Header_CL = "Deine E-Mail-Adresse";
    private static String step3SubHeader_CL = "Gib bitte deine E-Mail-Adresse für die Auftragsbestätigung und den Status der Rufnummer-Mitnahme ein";
    private static String step4Header_CL = "Übersicht";
    private static String step4SubHeader_CL = "Wichtig";
    private static String mismatchingError_CL = "Deine E-Mail-Adresse stimmt nicht überein. Probier's bitte nochmal.";
    private static String invalidEmailError_CL = "Bitte gib eine gültige E-Mail-Adresse ein.";
    private static String mandatoryErrorMsg_CL = "Bitte füll noch das Feld aus.";

    // DeepLinks
    private static String startPageURL = "hilfe/rufnummernmitnahme/start";
    private static String prePaidWeiterButtonURL = "hilfe/rufnummernmitnahme/fragebogen";
    private static String loginPageURL = "hilfe/rufnummernmitnahme-login.html";
    private static String portingWithDocsPageURL = "hilfe/rufnummernmitnahme/portierungsdatendokument";
    private static String statusPageURL = "hilfe/rufnummernmitnahme-status";
    private static String previousProviderURL = "hilfe/rufnummernmitnahme/bisheriger-anbieter";

    public StartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Start page Header CL")
    public StartPage validatePageHeaderCL() {
        driver.verifyThat().element(pageHeader).textTrimmed().contains(pageHeaderCL).perform();
        return this;
    }

    @Step("Validate Vodafone Number CL Displayed")
    public StartPage validateVodafoneNumberCLDisplayed() {
        driver.verifyThat().element(vodafoneNumberText).textTrimmed().contains(vodafoneNumberTextCL).perform();
        return this;
    }

    @Step("validate Vodafone Number exists")
    public StartPage validateVodafoneNumberExists(String number){
       driver.verifyThat().element(vodafoneNumber).textTrimmed().contains(number).perform();
        return this;
    }

    @Step("Validate Page Title/Header Displayed")
    public StartPage validatePageTitleDisplayed() {
        driver.verifyThat().element(pageHeader).textTrimmed().contains(pageHeaderCL).perform();
        return this;
    }

    @Step("Validate Error Page Header Displayed")
    public StartPage validateErrorPageTitleDisplayed() {
        driver.verifyThat().element(errorPageHeader).textTrimmed().contains(pageHeaderCL).perform();
        return this;
    }

    @Step("Click Abbrechen Button")
    public StartPage clickAbbrechenButton(){
        driver.element().click(abbrechenButton);
        return this;
    }

    @Step("Click Jetzt Rufnummern-Mitnahme starten Button")
    public StartPage clickJetztRufNummernMitnahmeStartenButton(){
        driver.element().click(jetztRufNummernMitnahmeStartenButton);
        return this;
    }

    @Step("Verify JetztRufNummernMitnahmeStarten Button Redirection")
    public StartPage verifyJetztRufNummernMitnahmeStartenButtonRedirection(){
        driver.verifyThat().browser().url().contains(portingWithDocsPageURL).perform();
        return this;
    }

    @Step("Verify Status Redirection")
    public StartPage verifyStatusRedirection(){
        driver.verifyThat().browser().url().contains(statusPageURL).perform();
        return this;
    }

    @Step("Verify PreviousProvider Redirection")
    public StartPage verifyPreviousProviderRedirection(){
        driver.verifyThat().browser().url().contains(previousProviderURL).perform();
        return this;
    }

    @Step("Verify Start Page Redirection")
    public StartPage verifyStartPageRedirection(){
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("Verify Porting With Documents Redirection")
    public StartPage verifyPortingWithDocsRedirection(){
        driver.verifyThat().browser().url().contains(portingWithDocsPageURL).perform();
        return this;
    }

    @Step("Verify Jetzt Rufnummern-Mitnahme starten Button is dimmed")
    public StartPage verifyJetztRufNummernMitnahmeStartenButtonIsDimmed(){
        driver.verifyThat().element(jetztRufNummernMitnahmeStartenButton).isDisabled().perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public StartPage validateInformationMessage3CL(String number){
        driver.verifyThat().element(informationMessage3Title).textTrimmed().contains(informationMessage3TitleCL).perform();
        driver.verifyThat().element(informationMessage3Details).textTrimmed().contains(informationMessage3DetailsCLPart1+number+informationMessage3DetailsCLPart2).perform();
        return this;
    }

    @Step("Verify Error Page Redirection")
    public StartPage verifyErrorPageRedirection(){
        driver.verifyThat().browser().url().contains(prePaidWeiterButtonURL).perform();
        return this;
    }

    @Step("Verify Abbrechen Button Redirection")
    public StartPage verifyAbbrechenButtonRedirection(){
        driver.verifyThat().browser().url().contains(loginPageURL).perform();
        return this;
    }

    @Step("Accept Cookies Button Click")
    public StartPage acceptCookies() {
        driver.element().click(acceptCookiesButtonLocator);
        return this;
    }

    @Step("validateErrorMsgIfPageFailed ")
    public StartPage validateErrorMessage1IfPageFailed(){
        driver.verifyThat().element(pageFailedErrorMsg1Header).textTrimmed().contains(pageFailedErrorMsgHeader_CL).perform();
        driver.verifyThat().element(pageFailedErrorMsg1Body).textTrimmed().contains(pageFailedErrorMsgBody_CL).perform();
        return this;
    }

    @Step("Fill Private Details Fields")
    public StartPage fillStep1Privatkunde(String phoneNumber, String provider, String vorname, String nachname, String geburtsdatum, String vertragsende, String optInDatum) {
        driver.element().type(StartPage.phoneNumber, phoneNumber);
        driver.element().select(StartPage.provider,provider);
        driver.element().click(privatkundeCheckBox);
        driver.element().type(StartPage.vorname,vorname);
        driver.element().type(StartPage.nachname,nachname);
        driver.element().type(StartPage.geburtsdatum,geburtsdatum);
        driver.element().type(StartPage.vertragsende,vertragsende);
        driver.element().type(StartPage.optInDatum,optInDatum);
        return this;
    }

    @Step("Fill Business Details Fields")
    public StartPage fillStep1Geschäftskunde(String phoneNumber , String provider, String firmenname, String kundnennummer, String vertragsende, String optInDatum) {
        driver.element().type(StartPage.phoneNumber,phoneNumber);
        driver.element().select(StartPage.provider,provider);
        driver.element().click(geschäftskundeCheckBox);
        driver.element().type(StartPage.firmenname,firmenname);
        driver.element().type(StartPage.kundnennummer,kundnennummer);
        driver.element().type(StartPage.vertragsende,vertragsende);
        driver.element().type(StartPage.optInDatum,optInDatum);
        return this;
    }

    @Step("Click As Soon As Possible Radio Button")
    public StartPage fillStep2AsSoonAsPossible() {
        driver.element().click(schnellstmöglichRadioButton);
        return this;
    }

    @Step("Click At End Of Contract Radio Button")
    public StartPage fillStep2AtEndOfContract() {
        driver.element().click(zumVertragsendeRadioButton);
        return this;
    }

    @Step("Click Cancel Button")
    public StartPage clickCancelButton1(){
        driver.element().click(cancelButton1);
        return this;
    }

    @Step("Click Next Step Button ")
    public StartPage clickNextStepButton(){
        driver.element().click(nextStepButton);
        return this;
    }

    @Step("Click Next Step Button ")
    public StartPage clickNextStepButton2(){
        driver.verifyThat().element(nextStepButton2).isVisible().perform();
        driver.element().click(nextStepButton2);
        return this;
    }

    @Step("Click Next Step Button ")
    public StartPage clickNextStepButton3(){
        driver.verifyThat().element(nextStepButton3).isVisible().perform();
        driver.element().click(nextStepButton3);
        return this;
    }

    @Step("Verify Weiter Button Disabled")
    public StartPage verifyWeiterButtonDisabled(){
        driver.verifyThat().element(nextStepButton2).isDisabled().perform();
        return this;
    }

    @Step("Verify Cancel Button Behaviour")
    public StartPage verifyCancelButtonBehaviour(){
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("verify Service Failure Message")
    public StartPage verifyServiceFailureMessage1() {
        driver.verifyThat().element(failureMessageDetailsGeneral1).textTrimmed().contains(generalFailureMessageCL).perform();
        return this;
    }

    @Step("verify Service Failure Message")
    public StartPage verifyServiceFailureMessage2() {
        driver.verifyThat().element(failureMessageDetailsGeneral2).textTrimmed().contains(generalFailureMessageCL).perform();
        return this;
    }

    @Step("Validate Time of number portability - At End of Contract")
    public StartPage validateTimeOfNumberPortabilityAtEndOfContract() {
        driver.verifyThat().element(timeOfNumberPortabilityStep4).textTrimmed().contains(timeOfNumberPortabilityAtEndOfContractCL).perform();
        return this;
    }

    @Step("Validate First Name")
    public StartPage validateFirstName(String data) {
        driver.verifyThat().element(firstNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Last Name")
    public StartPage validateLastName(String data) {
        driver.verifyThat().element(lastNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Date of Birth")
    public StartPage validateDateOfBirth(String data) {
        driver.verifyThat().element(dateOfBirthStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Company Name")
    public StartPage validateCompanyName(String data) {
        driver.verifyThat().element(companyNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public StartPage validateInformationMessage4CL(){
        driver.verifyThat().element(informationMessageStep4Title).textTrimmed().contains(informationMessage4TitleCL).perform();
        driver.verifyThat().element(informationMessageStep4Details).textTrimmed().contains(informationMessage4DetailsCL).perform();
        return this;
    }

    @Step("verify Warning Message CL")
    public StartPage validateWarningMessageCL() {
        driver.verifyThat().element(warningMessageTitle).textTrimmed().contains(warningMessageTitleCL).perform();
        driver.verifyThat().element(warningMessageDetails).textTrimmed().contains(warningMessageDetailsCL).perform();
        return this;
    }

    @Step("Fill Valid Email and Repeat Email Details Fields")
    public StartPage fillStep3Valid(String email, String emailConfirmation) {
        driver.element().type(emailFieldStep3,email);
        driver.element().type(repeatEmailFieldStep3,emailConfirmation);
        return this;
    }

    @Step("Enter valid email format in email address field")
    public StartPage fillStep3ValidEmailAddress(String validEmailAddress){
        driver.element().type(emailFieldStep3, validEmailAddress);
        return this;
    }

    @Step("Enter invalid email format in email address field")
    public StartPage fillStep3InvalidEmailAddress(String invalidEmailAddress){
        driver.element().type(emailFieldStep3, invalidEmailAddress);
        return this;
    }

    @Step("Enter valid email format in repeat email address field")
    public StartPage fillStep3ValidRepeatEmailAddress(String validRepeatEmailAddress){
        driver.element().type(repeatEmailFieldStep3, validRepeatEmailAddress);
        return this;
    }

    @Step("Enter invalid email format in repeat email address field")
    public StartPage fillStep3InvalidRepeatEmailAddress(String invalidRepeatEmailAddress){
        driver.element().type(repeatEmailFieldStep3, invalidRepeatEmailAddress);
        return this;
    }

    @Step("Validate mismatching email in repeat email address field")
    public StartPage validateMismatchingError(){
        driver.verifyThat().element(repeatEmailErrorMsg).text().isEqualTo(mismatchingError_CL).perform();
        return this;
    }

    @Step("Validate invalid email error msg for email address")
    public StartPage validateInvalidEmailErrorEmailAddress(){
        driver.verifyThat().element(emailAddressErrorMsg).text().isEqualTo(invalidEmailError_CL).perform();
        return this;
    }

    @Step("Validate invalid email error msg for repeat email address")
    public StartPage validateInvalidEmailErrorRepeatEmailAddress(){
        driver.verifyThat().element(repeatEmailErrorMsg).text().isEqualTo(invalidEmailError_CL).perform();
        return this;
    }

    @Step("Validate Step 3 Header CL")
    public StartPage validateStep3HeaderCL(){
        driver.verifyThat().element(step3Header).textTrimmed().isNotNull().perform();
        driver.verifyThat().element(step3Header).textTrimmed().contains(step3Header_CL).perform();
        return this;
    }

    @Step("Validate Step 3 Header and sub header CL")
    public StartPage validateStep3SubHeaderCL(){
        driver.verifyThat().element(step3SubHeader).textTrimmed().isNotNull().perform();
        driver.verifyThat().element(step3SubHeader).textTrimmed().contains(step3SubHeader_CL).perform();
        return this;
    }

    @Step("Validate Step 4 Header and sub header CL")
    public StartPage validateStep4HeaderCL(){
        driver.verifyThat().element(step4Header).textTrimmed().contains(step4Header_CL).perform();
        driver.verifyThat().element(step4SubHeader).textTrimmed().contains(step4SubHeader_CL).perform();
        return this;
    }

    @Step("Validate mandatory error msg for email address")
    public StartPage validateMandatoryErrorEmailAddress(){
        driver.verifyThat().element(emailAddressErrorMsg).textTrimmed().contains(mandatoryErrorMsg_CL).perform();
        return this;
    }

    @Step("Validate mandatory error msg for repeat email address")
    public StartPage validateMandatoryErrorRepeatEmailAddress(){
        driver.verifyThat().element(repeatEmailErrorMsg).textTrimmed().contains(mandatoryErrorMsg_CL).perform();
        return this;
    }

    @Step("Clear Repeat email address field")
    public StartPage clearRepeatEmailAddress(){
        WebElement repeatEmail = driver.getDriver().findElement(repeatEmailFieldStep3);
        String text=repeatEmail.getAttribute("value");
        while(!text.isEmpty()) {
            repeatEmail.sendKeys(Keys.BACK_SPACE);
            text=repeatEmail.getAttribute("value");
        }
        return this;
    }

    @Step("Validate mandatory CL below email address and repeat email address fields")
    public StartPage validateMandatoryTextInStep3(){
        driver.element().click(emptySpace);
        driver.element().waitToBeReady(textBelowEmailAddress);
        driver.verifyThat().element(textBelowEmailAddress).textTrimmed().contains(mandatoryText_CL).perform();
        driver.element().waitToBeReady(textBelowRepeatEmailAddress);
        driver.verifyThat().element(textBelowRepeatEmailAddress).textTrimmed().contains(mandatoryText_CL).perform();
        return this;
    }

    @Step("Validate Contract Cancellation Date")
    public StartPage validateContractEndDate() {
        driver.verifyThat().element(contractEndDateStep4).textTrimmed().contains(contractEndDateCL).perform();
        return this;
    }

    @Step("Validate Contract Opt In Validity Date")
    public StartPage validateOptInValidityDate(String date) {
        driver.verifyThat().element(optInValidityDateStep4).textTrimmed().contains(date).perform();
        return this;
    }

    @Step("Validate Customer Number")
    public StartPage validateCustomerNumber(String data) {
        driver.verifyThat().element(customerNumberStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Email Address - Step 3")
    public StartPage validateEmailAddress(String email) {
        driver.verifyThat().element(emailFieldStep4).textTrimmed().contains(email).perform();
        return this;
    }

    @Step("Validate Checkboxes are Checked")
    public StartPage validateCheckBoxesChecked() {
        driver.element().click(firstCheckBoxStep4);
        driver.element().click(secondCheckBoxStep4);
        driver.verifyThat().element(firstCheckBoxStep4).isEnabled().perform();
        driver.verifyThat().element(secondCheckBoxStep4).isEnabled().perform();
        return this;
    }

    @Step("Click Order Now Button ")
    public StartPage clickOrderNowButton(){
        driver.element().click(orderNowButton);
        return this;
    }

    @Step("Enable First Checkbox only")
    public StartPage enableFirstCheckBoxOnly() {
        driver.element().click(firstCheckBoxStep4);
        driver.verifyThat().element(orderNowButton).isDisabled().perform();
        return this;
    }

    @Step("Disable First Checkbox only")
    public StartPage disableFirstCheckBoxOnly() {
        driver.element().click(firstCheckBoxStep4);
        driver.verifyThat().element(firstCheckBoxStep4).isDisabled().perform();
        return this;
    }

    @Step("Enable Second Checkbox only")
    public StartPage enableSecondCheckBoxOnly() {
        driver.element().click(secondCheckBoxStep4);
        driver.verifyThat().element(orderNowButton).isDisabled().perform();
        return this;
    }

    @Step("Validate Failure Message")
    public StartPage verifyStep2FailureAllEmpty() {
        driver.verifyThat().element(failureMessageHeader).textTrimmed().contains(failureMessageAllEmptyTitleCL).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageAllEmptyDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageAllEmptyDetailsCLPart2).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public StartPage verifyStep2Failure2WithoutContractEndDate() {
        driver.verifyThat().element(failureMessageHeader).textTrimmed().contains(failureMessageWithoutContractEndDateTitleCL).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageWithoutContractEndDateDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageWithoutContractEndDateDetailsCLPart2).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public StartPage verifyStep2FailureMoreThan90Days() {
        driver.verifyThat().element(failureMessageHeader).textTrimmed().contains(failureMessageMoreThan90DaysTitleCL).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart2).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart3).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public StartPage verifyStep2Failure4OptInDate() {
        driver.verifyThat().element(failureMessageHeader).textTrimmed().contains(failureMessageInvalidOptInDateTitleCL).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageInvalidOptInDateDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageInvalidOptInDateDetailsCLPart2).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageInvalidOptInDateDetailsCLPart3).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public StartPage verifyStep2FailureFourMonthsInFuture() {
        driver.verifyThat().element(failureMessageHeader).textTrimmed().contains(failureMessageFourMonthsInFutureTitleCL).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageFourMonthsInFutureDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetails).textTrimmed().contains(failureMessageFourMonthsInFutureDetailsCLPart2).perform();
        return this;
    }

    @Step("Validate Success Message")
    public StartPage verifyStep2SuccessMessageAsSoonAsPossiblePart1() {
        driver.verifyThat().element(successMessageHeader).textTrimmed().contains(successMessageAsSoonAsPossibleTitleCL).perform();
        driver.verifyThat().element(successMessageDetails).textTrimmed().contains(successMessageAsSoonAsPossibleDetailsCL1).perform();
        return this;
    }

    @Step("Validate Success Message")
    public StartPage verifyStep2SuccessMessageAtEndOfContract() {
        driver.verifyThat().element(successMessageHeader).textTrimmed().contains(successMessageAtEndOfContractTitleCL).perform();
        driver.verifyThat().element(successMessageDetails).textTrimmed().contains(successMessageAtEndOfContractDetailsCL).perform();
        return this;
    }

    @Step("Validate Success Message")
    public StartPage verifyStep2SuccessMessage3() {
        driver.verifyThat().element(successMessageHeader).textTrimmed().contains(successMessage3TitleCL).perform();
        driver.verifyThat().element(successMessageDetails).textTrimmed().contains(successMessage3DetailsCL).perform();
        return this;
    }
}