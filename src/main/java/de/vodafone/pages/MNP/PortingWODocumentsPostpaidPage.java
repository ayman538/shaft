package de.vodafone.pages.MNP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PortingWODocumentsPostpaidPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By asSoonAsPossibleRadioButton = By.xpath("//*[@data-automation-id='timeOfPortability_rb']//input[@id='asap']");
    private static By endOfContractRadioButton = By.xpath("//*[@data-automation-id='timeOfPortability_rb']//input[@id='eoc']");
    private static By yesCancelled = By.xpath("//*[@data-automation-id='contractCancelled_rb']//input[@id='terminated']");
    private static By noCancelled = By.xpath("//*[@data-automation-id='contractCancelled_rb']//input[@id='notTerminated']");
    private static By yesInformed = By.xpath("//*[@data-automation-id='providerInformed_rb']//input[@label='Ja']");
    private static By notInformed = By.xpath("//*[@data-automation-id='providerInformed_rb']//input[@label='Nein']");
    private static By yesInformedNotificationMsgHeader = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt']//h5)");
    private static By yesInformedNotificationMsgBody = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt']//p)");
    private static By notInformedErrorMsgHeader = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt']//h5)");
    private static By notInformedErrorMsgBody = By.xpath("(//*[@data-automation-id='timeOfPortabilityStep_nt']//p)");
    private static By endOfContractMsgHeader = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//h5");
    private static By endOfContractMsgBody = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//p");
    private static By weiterCTA = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[2]");
    private static By weiterCTA2 = By.xpath("(//*[@data-automation-id='contractCancelledFurther_btn'])");
    private static By weiterCTA3 = By.xpath("(//*[@data-automation-id='timeOfPortabilityStepNext_btn'])");
    private static By weiterCTA4 = By.xpath("(//*[@data-automation-id='previousContractEndFurther_btn'])");
    private static By cancelCTA = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[1]");
    private static By cancelCTA2 = By.xpath("(//*[@data-automation-id='timeOfPortabilityStepCancel_btn'])");
    private static By cancelCTA3 = By.xpath("(//*[@data-automation-id='cancel_btn'])[2]");
    private static By cancelCTA4 = By.xpath("//*[@data-automation-id='portingOverviewCancel_btn']");
    private static By serviceFailureMsgHeader = By.xpath("//*[@data-automation-id='error_nt']//h5");
    private static By serviceFailureMsgBody = By.xpath("//*[@data-automation-id='error_nt']//p");
    private static By postPaidAccordion = By.xpath("//*[@id='timeOfPortability_acc']");
    private static By laufzeitVertragRadioButton = By.xpath("//*[@data-automation-id='contractTypesRadio_rb']//input[@id='contract-type-term-contract']");
    private static By vertragsende = By.xpath("//input[@id='endOfContract']");
    private static By vertagsEndeErrorMsg = By.xpath("//*[@data-automation-id='previousContractEndStep_tv']//span");
    private static By failureMessageHeaderWithoutDocs = By.xpath("//*[@data-automation-id='previousContractEndStep_nt']//h5");
    private static By failureMessageDetailsWithoutDocs = By.xpath("//*[@data-automation-id='previousContractEndStep_nt']//p");
    private static By failureMessageHeaderWithoutDocs2 = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//h5");
    private static By failureMessageDetailsWithoutDocs2 = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//p");
    private static By successMessageHeaderWithoutDocs = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//h5");
    private static By successMessageDetailsWithoutDocs = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//p");
    private static By failureMessageDetailsGeneral1 = By.xpath("(//div[@data-automation-id='error_nt']//p)[1]");
    private static By nextStepButton5 = By.xpath("//button[@data-automation-id='timeOfPortabilityStepNext_btn']");
    private static By privatkundeCheckBox = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[1]");
    private static By geschäftskundeCheckBox = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[2]");
    private static By vorname = By.xpath("//input[@data-automation-id='firstName_et']");
    private static By nachname = By.xpath("//input[@data-automation-id='lastName_et']");
    private static By geburtsdatum = By.xpath("//input[@data-automation-id='birthDate_et']");
    private static By phoneNumber = By.xpath("//input[@data-automation-id='phoneNumber_et']");
    private static By phoneNumber2 = By.xpath("//input[@data-automation-id='repeatPhoneNumber_et']");
    private static By provider2 = By.xpath("//*[@data-automation-id='provider_ddl']");
    private static By nextStepButton6 = By.xpath("(//button[@data-automation-id='next_btn'])[1]");
    private static By nextStepButton7 = By.xpath("(//button[@data-automation-id='next_btn'])[2]");
    private static By emailFieldStep3WithoutDocs = By.xpath("//input[@data-automation-id='email_et']");
    private static By repeatEmailFieldStep3WithoutDocs = By.xpath("//input[@data-automation-id='confirmEmail_et']");
    private static By step3HeaderWithoutDocs = By.xpath("(//div[@id='emailAddress_acc'])//h2");
    private static By step3SubHeaderWithoutDocs = By.xpath("//h5[@data-automation-id='headline_tv']");
    private static By emptySpaceWithoutDocs = By.xpath("//*[@data-automation-id='headline_tv']");
    private static By textBelowEmailAddressWithoutDocs = By.xpath("(//*[@id='emailAddress_acc']//span[1])[1]");
    private static By textBelowRepeatEmailAddressWithoutDocs = By.xpath("(//*[@id='emailAddress_acc']//span[1])[2]");
    private static By repeatEmailErrorMsgWithoutDocs = By.xpath("(//*[@id='emailAddress_acc']//span[1])[2]");
    private static By emailAddressErrorMsgWithoutDocs = By.xpath("(//*[@id='emailAddress_acc']//span[1])[1]");
    private static By firstCheckBoxStep4 = By.xpath("((//*[@data-automation-id='checkToOrder_tv'])//label)[1]");
    private static By secondCheckBoxStep4 = By.xpath("((//*[@data-automation-id='checkToOrder_tv'])//label)[2]");
    private static By orderNowButton = By.xpath("//*[@data-automation-id='portingOverviewOrder_btn']");
    private static By orderNowButtonWithoutDocs = By.xpath("//*[@data-automation-id='portingOverviewOrder_btn']");
    private static By failureMessageDetailsGeneral2 = By.xpath("(//div[@data-automation-id='error_nt']//p)[2]");
    private static By informationMessageStep4Title = By.xpath("(//*[@data-automation-id='previousContract_nt'])//h5");
    private static By informationMessageStep4Details = By.xpath("(//*[@data-automation-id='previousContract_nt'])//p");
    private static By firmenname = By.xpath("//input[@data-automation-id='companyName_et']");
    private static By kundnennummer = By.xpath("//input[@data-automation-id='customerNumber_et']");
    private static By emailFieldStep4 = By.xpath("((//*[@data-automation-id='comfirmationEmail_tv'])//strong)");
    private static By companyNameStep4 = By.xpath("((//*[@data-automation-id='businessDetails_tv'])//strong)[2]");
    private static By customerNumberStep4 = By.xpath("((//*[@data-automation-id='businessDetails_tv'])//strong)[3]");
    private static By firstNameStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[2]");
    private static By lastNameStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[3]");
    private static By dateOfBirthStep4 = By.xpath("(//*[@data-automation-id='privateDetails_tv']//strong)[4]");
    private static By timeOfNumberPortabilityStep4WithoutDocs = By.xpath("(//*[@data-automation-id='previousContract_tv']//strong)[3]");
    private static By contractType=By.xpath("//*[@data-automation-id='previousContractType_tv']");

    // CLs
    private static String yesInformedMsgHeader_CL = "Gut zu wissen";
    private static String yesInformedMsgBody_CL = "Schnellstmöglich bedeutet in ca. 8 Kalendertagen.";
    private static String endOfContractMsgHeader_CL = "Du willst Deine bisherige Rufnummer erst dann bei uns nutzen, wenn Dein Vertrag bei Deinem bisherigen Anbieter endet?";
    private static String endOfContractMsgBody_CL = "Dann kündige bitte Deinen bisherigen Vertrag. Das ist mit unserem ";
    private static String notInformedMsgHeader_CL = "Bevor Du Deine Rufnummern-Mitnahme bei uns beauftragst";
    private static String notInformedMsgBody_CL = "Sag Deinem bisherigen Anbieter, dass Du Deine Rufnummer zu uns mitnehmen willst, und lass das sogenannte \"Opt-in\" setzen. Ruf dazu einfach die Kundenbetreuung Deines bisherigen Anbieters an.";
    private static String serviceFailureMsgHeader_CL = "Rufnummern-Mitnahme nicht möglich";
    private static String serviceFailureBody_CL = "Ups! Die Technik hakt grad. Sorry, unser Fehler. Deine Rufnummern-Mitnahme können wir im Moment nicht bearbeiten. Bitte versuch's später nochmal. Danke für Dein Verständnis!";
    private static String mandatoryErrorMsg_CL = "Bitte füll noch das Feld aus.";
    private static String failureMessageMoreThan90DaysTitleCL = "Rufnummern-Mitnahme nicht mehr möglich";
    private static String failureMessageMoreThan90DaysDetailsCLPart1 = "Leider kannst Du Deine Rufnummer nicht mehr zu uns mitnehmen. Dein Kündigungstermin liegt mehr als 90 Tage zurück.";
    private static String failureMessageMoreThan90DaysDetailsCLPart2 ="Stimmt der Kündigungstermin, den Du eingegeben hast?";
    private static String failureMessageMoreThan90DaysDetailsCLPart3 = "Falls Dein bisheriger Vertrag wirklich schon mehr als 90 Tage beendet ist, können wir nichts mehr machen. Das tut uns sehr leid. Du kannst unsere Services mit Deiner neuen Vodafone-Rufnummer nutzen.";
    private static String failureMessageProviderNotInfromedTitleCL = "Bevor Du Deine Rufnummern-Mitnahme bei uns beauftragst";
    private static String failureMessageProviderNotInfromedDetailsCL = "Sag Deinem bisherigen Anbieter, dass Du Deine Rufnummer zu uns mitnehmen willst, und lass das sogenannte \"Opt-in\" setzen. Ruf dazu einfach die Kundenbetreuung Deines bisherigen Anbieters an.\n" +
            "\n" +
            "Das Opt-in ist nötig, damit Dein bisheriger Anbieter der Rufnummern-Mitnahme zustimmt und wir Deine Rufnummer zu uns holen können.";
    private static String failureMessageProviderNotInfromedDetailsCL2 = "Sag Deinem bisherigen Anbieter, dass Du Deine Rufnummer zu uns mitnehmen willst, und lass das sogenannte \"Opt-in\" setzen. Ruf dazu einfach die Kundenbetreuung Deines bisherigen Anbieters an.\n" +
            "Das Opt-in ist nötig, damit Dein bisheriger Anbieter der Rufnummern-Mitnahme zustimmt und wir Deine Rufnummer zu uns holen können.";
    private static String successMessageProviderInfromedTitleCL ="Gut zu wissen";
    private static String successMessageProviderInfromedDetailsCL2 ="Schnellstmöglich bedeutet in ca. 8 Kalendertagen.\n" +
            "Dein Vertrag bei Deinem bisherigen Anbieter bleibt trotz der Rufnummern-Mitnahme bestehen. Du zahlst bis zu Deinem Kündigungstermin bei Deinem bisherigen Anbieter und bei uns. Denk bitte daran, Deinen bisherigen Vertrag zu kündigen. Das ist mit unserem Kündigungshelfer ganz einfach.";
    private static String failureMessageFourMonthsInFutureTitleCL = "Du willst Deine bisherige Rufnummer erst dann bei uns nutzen, wenn Dein Vertrag bei Deinem bisherigen Anbieter endet?";
    private static String failureMessageFourMonthsInFutureDetailsCLPart1 = "Das kannst Du frühestens 4 Monate vor Vertragsende beauftragen, also erst ab ";
    private static String failureMessageFourMonthsInFutureDetailsCLPart2 =  "\"Schnellstmöglich\" kannst Du aber jederzeit wählen.";
    private static String successMessage3TitleCL = "Du kannst Deine Rufnummer zu uns mitbringen. Das dauert ca. 8 Kalendertage.";
    private static String successMessage3DetailsCL = "Klick bitte auf \"Weiter\".";
    private static String successMessageAtEndOfContractTitleCL ="Super!";
    private static String successMessageAtEndOfContractDetailsCL ="Du nimmst Deine Rufnummer zum Vertragsende mit.";
    private static String generalFailureMessageCL = "Ups! Die Technik hakt grad. Sorry, unser Fehler. Deine Rufnummern-Mitnahme können wir im Moment nicht bearbeiten. Bitte versuch's später nochmal. Danke für Dein Verständnis!";
    private static String step3Header_CL = "Deine E-Mail-Adresse";
    private static String step3SubHeader_CL = "Gib bitte deine E-Mail-Adresse für die Auftragsbestätigung und den Status der Rufnummer-Mitnahme ein";
    private static String mandatoryText_CL = "Pflichtfeld";
    private static String invalidEmailError_CL = "Bitte gib eine gültige E-Mail-Adresse ein.";
    private static String mismatchingError_CL = "Deine E-Mail-Adresse stimmt nicht überein. Probier's bitte nochmal.";
    private static String informationMessage4TitleCL = "Wichtig";
    private static String informationMessage4DetailsCL = "Prüf Deine Daten genau. Deine Rufnummern-Mitnahme klappt nur, wenn die Daten exakt mit den Daten in Deinem bisherigen Vertrag übereinstimmen.";
    private static String timeOfNumberPortabilityAsSoonAsPossibleCL = "Schnellstmöglich";
    private static String failureMessageWithoutContractEndDateTitleCL = "Du willst Deine bisherige Rufnummer erst dann bei uns nutzen, wenn Dein Vertrag bei Deinem bisherigen Anbieter endet?";
    private static String failureMessageWithoutContractEndDateDetailsCLPart1 = "Dann kündige bitte Deinen bisherigen Vertrag. Das ist mit unserem Kündigungshelfer ganz einfach. Sobald Du die Kündigungsbestätigung mit Kündigungstermin hast, kannst Du hier Deine Rufnummern-Mitnahme beauftragen.";
    private static String failureMessageWithoutContractEndDateDetailsCLPart2 = "\"Schnellstmöglich\" kannst Du aber jederzeit wählen.";

    // DeepLinks
    private static String startPageURL = "hilfe/rufnummernmitnahme/start";
    private static String weiterButtonURL = "hilfe/rufnummernmitnahme/fragebogen";

    public PortingWODocumentsPostpaidPage(SHAFT.GUI.WebDriver driver) { this.driver = driver;}

    @Step("click on AS soon as possible radio button")
    public PortingWODocumentsPostpaidPage clickOnASARadioButton(){
        driver.element().click(asSoonAsPossibleRadioButton);
        driver.verifyThat().element(yesInformed).exists().perform();
        return this;
    }

    @Step("click on yes informed radio button")
    public PortingWODocumentsPostpaidPage clickOnYesInformedRadioButton(){
        driver.element().click(yesInformed);
        return this;
    }

    @Step("click on end of contract radio button")
    public PortingWODocumentsPostpaidPage clickOnEOCRadioButton(){
        driver.element().click(endOfContractRadioButton);
        return this;
    }

    @Step("click on NOT informed radio button")
    public PortingWODocumentsPostpaidPage clickOnNotInformedRadioButton(){
        driver.element().click(notInformed);
        return this;
    }

    @Step("validate that Weiter is dimmed in case not informed")
    public PortingWODocumentsPostpaidPage validateWeiterCTAIsDimmed(){
        driver.verifyThat().element(weiterCTA).isDisabled().perform();
        return this;
    }

    @Step("validate that Weiter is dimmed in case not informed")
    public PortingWODocumentsPostpaidPage validateWeiterCTAIsDimmed2(){
        driver.verifyThat().element(weiterCTA3).isDisabled().perform();
        return this;
    }

    @Step("validate that Weiter is dimmed in case not informed")
    public PortingWODocumentsPostpaidPage validateWeiterCTAIsDimmed3(){
        driver.verifyThat().element(weiterCTA4).isDisabled().perform();
        return this;
    }

    @Step("validate not informed message")
    public PortingWODocumentsPostpaidPage validateNotInformedMsg(){
        driver.verifyThat().element(notInformedErrorMsgHeader).textTrimmed().isEqualTo(notInformedMsgHeader_CL).perform();
        driver.verifyThat().element(notInformedErrorMsgBody).textTrimmed().contains(notInformedMsgBody_CL).perform();

        return this;
    }

    @Step("validate end of contract message")
    public PortingWODocumentsPostpaidPage validateEndOfContractMsg(){
        driver.verifyThat().element(endOfContractMsgHeader).textTrimmed().isEqualTo(endOfContractMsgHeader_CL).perform();
        driver.verifyThat().element(endOfContractMsgBody).textTrimmed().contains(endOfContractMsgBody_CL).perform();

        return this;
    }

    @Step("validate informed message")
    public PortingWODocumentsPostpaidPage validateInformedMsg(){
        driver.verifyThat().element(yesInformedNotificationMsgHeader).textTrimmed().isEqualTo(yesInformedMsgHeader_CL).perform();
        driver.verifyThat().element(yesInformedNotificationMsgBody).textTrimmed().contains(yesInformedMsgBody_CL).perform();

        return this;
    }

    @Step("click on Wieter button to proceed to next step")
    public PortingWODocumentsPostpaidPage clickOnWeiterButton(){
        driver.element().click(weiterCTA);
        //driver.verifyThat().element(postPaidAccordion).exists().perform();
        return this;
    }

    @Step("click on Wieter button to proceed to next step")
    public PortingWODocumentsPostpaidPage clickOnWeiterButton2(){
        driver.element().click(weiterCTA2);
        //driver.verifyThat().element(postPaidAccordion).exists().perform();
        return this;
    }

    @Step("click on Yes Cancelled radio button")
    public PortingWODocumentsPostpaidPage clickOnYesCancelledRadioButton(){
        driver.element().click(yesCancelled);
        return this;
    }

    @Step("Click Accordion One")
    public PortingWODocumentsPostpaidPage enterVertagsendeDate(String vertragsende) {
        driver.element().type(PortingWODocumentsPostpaidPage.vertragsende,vertragsende);
        return this;
    }

    @Step("Validate mandatory error msg for Contract End Date")
    public PortingWODocumentsPostpaidPage validateMandatoryErrorVertagsEnde(){
        driver.verifyThat().element(vertagsEndeErrorMsg).textTrimmed().contains(mandatoryErrorMsg_CL).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public PortingWODocumentsPostpaidPage verifyStep2FailureMoreThan90DaysWithoutDocs() {
        driver.verifyThat().element(failureMessageHeaderWithoutDocs).textTrimmed().contains(failureMessageMoreThan90DaysTitleCL).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart2).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs).textTrimmed().contains(failureMessageMoreThan90DaysDetailsCLPart3).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public PortingWODocumentsPostpaidPage verifyStep2FailureProviderNotInformedWithoutDocs() {
        driver.verifyThat().element(failureMessageHeaderWithoutDocs2).textTrimmed().contains(failureMessageProviderNotInfromedTitleCL).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs2).textTrimmed().contains(failureMessageProviderNotInfromedDetailsCL2).perform();
        return this;
    }

    @Step("Validate Success Message")
    public PortingWODocumentsPostpaidPage verifyStep2SuccessProviderInformedWithoutDocs() {
        driver.verifyThat().element(successMessageHeaderWithoutDocs).textTrimmed().contains(successMessageProviderInfromedTitleCL).perform();
        driver.verifyThat().element(successMessageDetailsWithoutDocs).textTrimmed().contains(successMessageProviderInfromedDetailsCL2).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public PortingWODocumentsPostpaidPage verifyStep2FailureFourMonthsInFutureWithoutDocs() {
        driver.verifyThat().element(failureMessageHeaderWithoutDocs2).textTrimmed().contains(failureMessageFourMonthsInFutureTitleCL).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs2).textTrimmed().contains(failureMessageFourMonthsInFutureDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs2).textTrimmed().contains(failureMessageFourMonthsInFutureDetailsCLPart2).perform();
        return this;
    }

    @Step("Validate Success Message")
    public PortingWODocumentsPostpaidPage verifyStep2SuccessMessage3WithoutDocs() {
        driver.verifyThat().element(successMessageHeaderWithoutDocs).textTrimmed().contains(successMessage3TitleCL).perform();
        driver.verifyThat().element(successMessageDetailsWithoutDocs).textTrimmed().contains(successMessage3DetailsCL).perform();
        return this;
    }

    @Step("Validate Success Message")
    public PortingWODocumentsPostpaidPage verifyStep2SuccessMessageAtEndOfContractWithoutDocs() {
        driver.verifyThat().element(successMessageHeaderWithoutDocs).textTrimmed().contains(successMessageAtEndOfContractTitleCL).perform();
        driver.verifyThat().element(successMessageDetailsWithoutDocs).textTrimmed().contains(successMessageAtEndOfContractDetailsCL).perform();
        return this;
    }

    @Step("Verify Cancel Button Behaviour")
    public PortingWODocumentsPostpaidPage verifyCancelButtonBehaviour(){
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("verify Service Failure Message")
    public PortingWODocumentsPostpaidPage verifyServiceFailureMessage1() {
        driver.verifyThat().element(failureMessageDetailsGeneral1).textTrimmed().contains(generalFailureMessageCL).perform();
        return this;
    }

    @Step("Click Next Step Button on Porting Without Documents ")
    public PortingWODocumentsPostpaidPage clickNextStepButton5(){
        driver.verifyThat().element(nextStepButton5).isVisible().perform();
        driver.element().click(nextStepButton5);
        return this;
    }

    @Step("Click Private Check Box")
    public PortingWODocumentsPostpaidPage fillStep3PrivatkundeCheckBox() {
        driver.element().click(privatkundeCheckBox);
        return this;
    }

    @Step("Fill Private Details Fields")
    public PortingWODocumentsPostpaidPage fillStep3Privatkunde(String vorname, String nachname, String geburtsdatum, String phoneNumber, String phoneNumber2, String provider2) {

        driver.element().type(PortingWODocumentsPostpaidPage.vorname,vorname);
        driver.element().type(PortingWODocumentsPostpaidPage.nachname,nachname);
        driver.element().type(PortingWODocumentsPostpaidPage.geburtsdatum,geburtsdatum);
        driver.element().type(PortingWODocumentsPostpaidPage.phoneNumber, phoneNumber);
        driver.element().type(PortingWODocumentsPostpaidPage.phoneNumber2, phoneNumber2);
        driver.element().select(PortingWODocumentsPostpaidPage.provider2,provider2);
        return this;
    }

    @Step("Click Next Step Button on Porting Without Documents ")
    public PortingWODocumentsPostpaidPage clickNextStepButton6(){
        driver.verifyThat().element(nextStepButton6).isVisible().perform();
        driver.element().click(nextStepButton6);
        return this;
    }

    @Step("Enter valid email format in email address field")
    public PortingWODocumentsPostpaidPage fillStep3ValidEmailAddressWithoutDocs(String validEmailAddress){
        driver.element().type(emailFieldStep3WithoutDocs, validEmailAddress);
        return this;
    }

    @Step("Enter valid email format in repeat email address field")
    public PortingWODocumentsPostpaidPage fillStep3ValidRepeatEmailAddressWithoutDocs(String validRepeatEmailAddress){
        driver.element().type(repeatEmailFieldStep3WithoutDocs, validRepeatEmailAddress);
        return this;
    }

    @Step("Click Next Step Button on Porting Without Documents ")
    public  PortingWODocumentsPostpaidPage clickNextStepButton7(){
        driver.verifyThat().element(nextStepButton7).isVisible().perform();
        driver.element().click(nextStepButton7);
        return this;
    }

    @Step("Validate Step 3 Header CL")
    public PortingWODocumentsPostpaidPage validateStep3HeaderCLWithoutDocs(){
        driver.verifyThat().element(step3HeaderWithoutDocs).textTrimmed().isNotNull().perform();
        driver.verifyThat().element(step3HeaderWithoutDocs).textTrimmed().contains(step3Header_CL).perform();
        return this;
    }

    @Step("Validate Step 3 Header and sub header CL")
    public PortingWODocumentsPostpaidPage validateStep3SubHeaderCLWithoutDocs(){
        driver.verifyThat().element(step3SubHeaderWithoutDocs).textTrimmed().isNotNull().perform();
        driver.verifyThat().element(step3SubHeaderWithoutDocs).textTrimmed().contains(step3SubHeader_CL).perform();
        return this;
    }

    @Step("Validate mandatory CL below email address and repeat email address fields")
    public PortingWODocumentsPostpaidPage validateMandatoryTextInStep3WithoutDocs(){
        driver.element().click(emptySpaceWithoutDocs);
        driver.element().waitToBeReady(textBelowEmailAddressWithoutDocs);
        driver.verifyThat().element(textBelowEmailAddressWithoutDocs).textTrimmed().contains(mandatoryText_CL).perform();
        driver.element().waitToBeReady(textBelowRepeatEmailAddressWithoutDocs);
        driver.verifyThat().element(textBelowRepeatEmailAddressWithoutDocs).textTrimmed().contains(mandatoryText_CL).perform();
        return this;
    }

    @Step("Validate mandatory error msg for email address")
    public PortingWODocumentsPostpaidPage validateMandatoryErrorEmailAddressWithoutDocs(){
        driver.verifyThat().element(emailAddressErrorMsgWithoutDocs).textTrimmed().contains(mandatoryErrorMsg_CL).perform();
        return this;
    }

    @Step("Validate mandatory error msg for repeat email address")
    public PortingWODocumentsPostpaidPage validateMandatoryErrorRepeatEmailAddressWithoutDocs(){
        driver.verifyThat().element(repeatEmailErrorMsgWithoutDocs).textTrimmed().contains(mandatoryErrorMsg_CL).perform();
        return this;
    }

    @Step("Clear Repeat email address field")
    public PortingWODocumentsPostpaidPage clearRepeatEmailAddressWithoutDocs() {
        WebElement repeatEmail = driver.getDriver().findElement(repeatEmailFieldStep3WithoutDocs);
        String text=repeatEmail.getAttribute("value");
        while(!text.isEmpty()) {
            repeatEmail.sendKeys(Keys.BACK_SPACE);
            text=repeatEmail.getAttribute("value");
        }
        return this;
    }

    @Step("Enter invalid email format in email address field")
    public PortingWODocumentsPostpaidPage fillStep3InvalidEmailAddressWithoutDocs(String invalidEmailAddress){
        driver.element().type(emailFieldStep3WithoutDocs, invalidEmailAddress);
        return this;
    }

    @Step("Validate invalid email error msg for email address")
    public PortingWODocumentsPostpaidPage validateInvalidEmailErrorEmailAddressWithoutDocs(){
        driver.verifyThat().element(emailAddressErrorMsgWithoutDocs).text().isEqualTo(invalidEmailError_CL).perform();
        return this;
    }

    @Step("Validate invalid email error msg for repeat email address")
    public PortingWODocumentsPostpaidPage validateInvalidEmailErrorRepeatEmailAddressWithoutDocs(){
        driver.verifyThat().element(repeatEmailErrorMsgWithoutDocs).text().isEqualTo(invalidEmailError_CL).perform();
        return this;
    }

    @Step("Enter invalid email format in repeat email address field")
    public PortingWODocumentsPostpaidPage fillStep3InvalidRepeatEmailAddressWithoutDocs(String invalidRepeatEmailAddress){
        driver.element().type(repeatEmailFieldStep3WithoutDocs, invalidRepeatEmailAddress);
        return this;
    }

    @Step("Validate mismatching email in repeat email address field")
    public PortingWODocumentsPostpaidPage validateMismatchingErrorWithoutDocs(){
        driver.verifyThat().element(repeatEmailErrorMsgWithoutDocs).text().isEqualTo(mismatchingError_CL).perform();
        return this;
    }

    @Step("Validate Checkboxes are Checked")
    public PortingWODocumentsPostpaidPage validateCheckBoxesChecked() {
        driver.element().click(firstCheckBoxStep4);
        driver.element().click(secondCheckBoxStep4);
        driver.verifyThat().element(firstCheckBoxStep4).isEnabled().perform();
        driver.verifyThat().element(secondCheckBoxStep4).isEnabled().perform();
        return this;
    }

    @Step("Enable First Checkbox only")
    public PortingWODocumentsPostpaidPage enableFirstCheckBoxOnly() {
        driver.element().click(firstCheckBoxStep4);
        driver.verifyThat().element(orderNowButton).isDisabled().perform();
        return this;
    }

    @Step("Disable First Checkbox only")
    public PortingWODocumentsPostpaidPage disableFirstCheckBoxOnly() {
        driver.element().click(firstCheckBoxStep4);
        driver.verifyThat().element(firstCheckBoxStep4).isDisabled().perform();
        return this;
    }

    @Step("Enable Second Checkbox only")
    public PortingWODocumentsPostpaidPage enableSecondCheckBoxOnly() {
        driver.element().click(secondCheckBoxStep4);
        driver.verifyThat().element(orderNowButton).isDisabled().perform();
        return this;
    }

    @Step("Click Order Now Button ")
    public PortingWODocumentsPostpaidPage clickOrderNowButtonWithoutDocs(){
        driver.element().click(orderNowButtonWithoutDocs);
        return this;
    }

    @Step("verify Service Failure Message")
    public PortingWODocumentsPostpaidPage verifyServiceFailureMessage2() {
        driver.verifyThat().element(failureMessageDetailsGeneral2).textTrimmed().contains(generalFailureMessageCL).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public PortingWODocumentsPostpaidPage validateInformationMessage4CL(){
        driver.verifyThat().element(informationMessageStep4Title).textTrimmed().contains(informationMessage4TitleCL).perform();
        driver.verifyThat().element(informationMessageStep4Details).textTrimmed().contains(informationMessage4DetailsCL).perform();
        return this;
    }

    @Step("Click Business Check Box")
    public PortingWODocumentsPostpaidPage fillStep3geschäftskundeCheckBox() {
        driver.element().click(geschäftskundeCheckBox);
        return this;
    }

    @Step("Fill Business Details Fields")
    public PortingWODocumentsPostpaidPage fillStep3Geschäftskunde(String firmenname, String kundnennummer,String phoneNumber, String phoneNumber2, String provider2) {

        driver.element().type(PortingWODocumentsPostpaidPage.firmenname,firmenname);
        driver.element().type(PortingWODocumentsPostpaidPage.kundnennummer,kundnennummer);
        driver.element().type(PortingWODocumentsPostpaidPage.phoneNumber,phoneNumber);
        driver.element().type(PortingWODocumentsPostpaidPage.phoneNumber2, phoneNumber2);
        driver.element().select(PortingWODocumentsPostpaidPage.provider2,provider2);
        return this;
    }

    @Step("Validate Email Address - Step 3")
    public PortingWODocumentsPostpaidPage validateEmailAddress(String email) {
        driver.verifyThat().element(emailFieldStep4).textTrimmed().contains(email).perform();
        return this;
    }

    @Step("Validate Company Name")
    public PortingWODocumentsPostpaidPage validateCompanyName(String data) {
        driver.verifyThat().element(companyNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Customer Number")
    public PortingWODocumentsPostpaidPage validateCustomerNumber(String data) {
        driver.verifyThat().element(customerNumberStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate First Name")
    public PortingWODocumentsPostpaidPage validateFirstName(String data) {
        driver.verifyThat().element(firstNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Last Name")
    public PortingWODocumentsPostpaidPage validateLastName(String data) {
        driver.verifyThat().element(lastNameStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Date of Birth")
    public PortingWODocumentsPostpaidPage validateDateOfBirth(String data) {
        driver.verifyThat().element(dateOfBirthStep4).textTrimmed().contains(data).perform();
        return this;
    }

    @Step("Validate Time of number portability - As Soon As Possible")
    public PortingWODocumentsPostpaidPage validateTimeOfNumberPortabilityAsSoonAsPossibleWithoutDocs() {
        driver.verifyThat().element(timeOfNumberPortabilityStep4WithoutDocs).textTrimmed().contains(timeOfNumberPortabilityAsSoonAsPossibleCL).perform();
        return this;
    }

    @Step("Validate Contract Type")
    public PortingWODocumentsPostpaidPage validateContractType(String contractType) {
        driver.verifyThat().element(PortingWODocumentsPostpaidPage.contractType).textTrimmed().contains(contractType).perform();
        return this;
    }

    @Step("Validate Failure Message")
    public PortingWODocumentsPostpaidPage verifyStep2Failure2WithoutContractEndDateWithoutDocs() {
        driver.verifyThat().element(failureMessageHeaderWithoutDocs2).textTrimmed().contains(failureMessageWithoutContractEndDateTitleCL).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs2).textTrimmed().contains(failureMessageWithoutContractEndDateDetailsCLPart1).perform();
        driver.verifyThat().element(failureMessageDetailsWithoutDocs2).textTrimmed().contains(failureMessageWithoutContractEndDateDetailsCLPart2).perform();
        return this;
    }

    @Step("click on NO Cancelled radio button")
    public PortingWODocumentsPostpaidPage clickOnNoCancelledRadioButton(){
        driver.element().click(noCancelled);
        return this;
    }

    @Step("click on Wieter button to proceed to next step")
    public PortingWODocumentsPostpaidPage clickOnWeiterButton3(){
        driver.element().click(weiterCTA3);
        return this;
    }

    @Step("click on Wieter button to proceed to next step")
    public PortingWODocumentsPostpaidPage clickOnWeiterButton4(){
        driver.element().click(weiterCTA4);
        return this;
    }

    @Step("click on Cancel button")
    public PortingWODocumentsPostpaidPage clickOnCancelButton(){
        driver.element().click(cancelCTA);
        return this;
    }

    @Step("click on Cancel button")
    public PortingWODocumentsPostpaidPage clickOnCancelButton2(){
        driver.element().click(cancelCTA2);
        return this;
    }

    @Step("Click Cancel Button")
    public PortingWODocumentsPostpaidPage clickOnCancelButton3(){
        driver.element().click(cancelCTA3);
        return this;
    }

    @Step("Click Cancel Button")
    public PortingWODocumentsPostpaidPage clickOnCancelButton4(){
        driver.element().click(cancelCTA4);
        return this;
    }

    @Step("validate error msg")
    public PortingWODocumentsPostpaidPage validateErrorMsgForServiceFailure(){
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(serviceFailureBody_CL).perform();
        return this;
    }

    @Step("click on Cancel button to navigate to start page")
    public PortingWODocumentsPostpaidPage expandAndCollapsePostpaidAccordion(){
        driver.element().click(postPaidAccordion);
        driver.verifyThat().element(yesInformed).exists().perform();
        driver.element().click(postPaidAccordion);
        driver.verifyThat().element(yesInformed).doesNotExist().perform();
        return this;
    }

    @Step("click on Postpaid Radio button")
    public PortingWODocumentsPostpaidPage fillLaufzeitVertragRadioButton() {
        driver.element().click(laufzeitVertragRadioButton);
        return this;
    }

    @Step("Verify Porting With Out Documents Redirection")
    public  PortingWODocumentsPostpaidPage verifyPortingWithOutDocsRedirection(){
        driver.verifyThat().browser().url().contains(weiterButtonURL).perform();
        return this;
    }
}