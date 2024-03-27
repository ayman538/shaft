package de.vodafone.pages.Solstice;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class SolsticePrivacySettings {
    private SHAFT.GUI.WebDriver driver;

    public SolsticePrivacySettings (SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    //locators
    private static By gerneralErrorMsg_Title = By.xpath("");
    private static By gerneralErrorMsg_Text = By.xpath("");
    private static By change_btn = By.xpath("");
    private static By informationFromVF_StepperTitle = By.xpath("");
    private static By emailCard = By.xpath("");
    private static By emailCard_Title = By.xpath("");
    private static By emailCard_LastUpdateText = By.xpath("");
    private static By emailCard_LastUpdateDate = By.xpath("");
    private static By emailCard_Text = By.xpath("");
    private static By smsCard = By.xpath("");
    private static By smsCard_Title = By.xpath("");
    private static By smsCard_LastUpdateText = By.xpath("");
    private static By smsCard_LastUpdateDate = By.xpath("");
    private static By smsCard_Text = By.xpath("");
    private static By postCard = By.xpath("");
    private static By postCard_Title = By.xpath("");
    private static By postCard_LastUpdateText = By.xpath("");
    private static By postCard_LastUpdateDate = By.xpath("");
    private static By postCard_Text = By.xpath("");
    private static By anrufCard = By.xpath("");
    private static By anrufCard_Title = By.xpath("");
    private static By anrufCard_LastUpdateText = By.xpath("");
    private static By anrufCard_LastUpdateDate = By.xpath("");
    private static By anrufCard_Text = By.xpath("");
    private static By emailToggleON = By.xpath("");
    private static By confirmationMsg2_Title_EmailCard = By.xpath("");

    private static By confirmationMsg2_Text_EmailCard = By.xpath("");
    private static By confirmationMsg2_Question_EmailCard = By.xpath("");
    private static By confirmationMsg2_NOOption_EmailCard = By.xpath("");
    private static By confirmationMsg2_YesOption_EmailCard = By.xpath("");
    private static By successMessage = By.xpath("");

    //PersonalDataLocators
    private static By sectionTitle = By.xpath("");
    private static By permissionTitle = By.xpath("");
    private static By permission_LastUpdateLabel = By.xpath("");
    private static By Permission_LastUpdateDate = By.xpath("");
    private static By permission_Body = By.xpath("");
    private static By permissionToggleOn = By.xpath("");
    private static By personalData_ChangeBtn = By.xpath("");
    private static By confirmationMsg2_YesOption_PesrsonalData = By.xpath("");
    private static By confirmationMsg2_Title_PersonalData = By.xpath("");
    private static By confirmationMsg2_Text_PersonalData = By.xpath("");
    private static By confirmationMsg2_Question_PersonalData = By.xpath("");
    private static By confirmationMsg2_YesOption_PersonalData = By.xpath("");
    private static By confirmationMsg2_NOOption_PersonalData = By.xpath("");
    private static By permissionToggleOn_PersonalData = By.xpath("");
    private static By  permissionToggleOFF_PersonalData = By.xpath("");
    private static By failureMessage = By.xpath("");

    //internetUsageLocators
    private static By internetUsage_permission_Body = By.xpath("");
    private static By internetUsage_sectionTitle = By.xpath("");
    private static By internetUsage_permissionTitle = By.xpath("");
    private static By internetUsage_permission_LastUpdateLabel = By.xpath("");
    private static By internetUsage_permission_LastUpdateDate = By.xpath("");
    private static By permissionToggleOFF_InternetUsage = By.xpath("");
    private static By confirmationMsg1_TitleCL_InternetUsage = By.xpath("");
    private static By confirmationMsg1_TextCL_InternetUsage = By.xpath("");
    private static By accept_Btn_Confirmationsg1 = By.xpath("");
    private static By decline_Btn_Confirmationsg1 = By.xpath("");
    private static By internetUsage_ChangeBtn = By.xpath("");
    private static By confirmationMsg2_Title_internetUsage = By.xpath("");
    private static By confirmationMsg2_Text_internetUsage = By.xpath("");
    private static By confirmationMsg2_Question_internetUsage = By.xpath("");
    private static By confirmationMsg2_YesOption_internetUsage = By.xpath("");
    private static By confirmationMsg2_NOOption_internetUsage = By.xpath("");
    private static By permissionToggleON_InternetUsage = By.xpath("");



    //Cls
    //InformationFromVFCLs
    private static String gerneralErrorMsg_TitleCL = "Entschuldige, das ist was schiefgelaufun.";
    private static String gerneralErrorMsg_TextCL = "Bitte versuchen Sie es später nochmal.";

    private static String informationFromVF_StepperTitleCL = "Informationen von Vodafone";
    private static String emailCard_TitleCL = "E-Mail";
    private static String emailCard_LastUpdateTextCL = "Letzte Änderung:";
    private static String emailCard_LastUpdateDateCL = "31.03.2022";
    private static String emailCard_TextCL = "Vodafone darf Dich per E-Mail kontaktieren, um Dir Informationen über Produkte und Services, aktuelle Angebote und Empfehlungen, die spezifisch auf Deine Bedürfnisse zugeschnitten sind, zukommen zu lassen.";
    private static String smsCard_TitleCL = "SMS/MMS";
    private static String smsCard_LastUpdateTextCL = "Letzte Änderung:";
    private static String smsCard_TextCL = "Vodafone darf Dich per SMS/MMS kontaktieren, um Dich über Produkte und Services zu informieren und Dir aktuelle Angebote und Empfehlungen zu geben, die auf Deine Bedürfnisse zugeschnitten sind.";
    private static String postCard_TitleCL = "Post";
    private static String postCard_LastUpdateTextCL = "Letzte Änderung:";
    private static String postCard_LastUpdateDateCL = "31.03.2022";
    private static String smsCard_LastUpdateDateCL = "31.03.2022";
    private static String postCard_TextCL = "Vodafone darf Dich per Brief kontaktieren, um Dir Informationen über Produkte und Services, aktuelle Angebote und Empfehlungen, die spezifisch auf Deine Bedürfnisse zugeschnitten sind, zukommen zu lassen.";
    private static String anrufCard_TitleCL = "Anruf";
    private static String anrufCard_LastUpdateTextCL = "Letzte Änderung:";
    private static String anrufCard_LastUpdateDateCL = "31.03.2022";
    private static String anrufCard_TextCL = "Vodafone darf Dich per Anruf kontaktieren, um Dir Informationen über Produkte und Services, aktuelle Angebote und Empfehlungen, die spezifisch auf Deine Bedürfnisse zugeschnitten sind, zukommen zu lassen.";
    private static String confirmationMsg2_QuestionCL = "Änderungen speichern?";
    private static String confirmationMsg2_TextCL = "Du hast Deine Datenschutz- & Werbeeinstellungen geändert.";
    private static String confirmationMsg2_TitleCL = "Achtung!";
    private static String confirmationMsg1_TextCL_InternetUsageCL = "Wenn Du diese Einstellung ausschaltest, verzichtest Du auf Vorteile. Du bekommst dann z.B. keine persönlich zugeschnittenen Angebote mehr.";
    private static String accept_Btn_Confirmationsg1CL = "Fortfahren";
    private static String decline_Btn_Confirmationsg1CL = " Rückgängig";

    private static String confirmationMsg2_YesOptionCL = "Ja, Änderungen speichern";
    private static String confirmationMsg2_NOOptionCL = " Nein, Änderungen nicht speichern";
    private static String successMessageCL = "Deine Änderungen wurden gespeichert.";
    private static String failureMessageCL ="Das hat leider nicht geklappt";

//PersonalDataCls
    private static String personalData_sectionTitleCL = "Persönliche Daten";
    private static String personalData_permissionTitleCL = "Austausch Bestands-/Vertragsdaten zu Werbezwecken";
    private static String personalData_permission_BodyCL = "Vodafone darf Deine Bestands-/Vertragsdaten zur Optimierung seines Netzes und seiner Produkte und Services nutzen sowie für gezielte Angebote und Beratung. Unsere inländischen Vodafone Unternehmen tauschen diese Daten zu diesem Zwecke auch untereinander aus.  Deine Bestands-/Vertragsdaten sind Angaben rund um Dein Vertragsverhältnis, Deine Tarife, Optionen und Services sowie Informationen, die Dich als Person identifizieren, wie z.B. Name, Post- und E-Mail-Adresse, Telefonnummer, Geburtsdatum und IBAN.Wenn wir besser verstehen, wie Du unsere Produkte und Services nutzt, können wir Dir Angebote schicken, die besser zu Dir passen.";
    private static String personalData_permission_LastUpdateLabelCL = "Letzte Änderung:";
    //InternetUsageCLs
    private static String internetUsage_sectionTitleCL = "Verbindungs- und Nutzungsdaten";
    private static String internetUsage_permissionTitleCL = "Verwendung von Nutzungs-, Standort- und Verkehrsdaten";
    private static String internetUsage_permission_BodyCL = "Ja, ich willige ein, dass die Vodafone-Unternehmen meine Nutzungsdaten, Standortdaten und sonstigen Verkehrsdaten verwenden und untereinander austauschen, um ihre Telemedien- und Telekommunikationsdienste für mich bedarfsgerecht und individuell zu gestalten, zu vermarkten sowie Dienste mit Zusatznutzen für mich bereitzustellen.";
    private static String internetUsage_permission_LastUpdateLabelCL = "Letzte Änderung:";

    //Methods
    @Step("validate general error message")
    public void validateGeneralErrorMsg() {
        driver.assertThat().element(gerneralErrorMsg_Title)
                .text().contains(gerneralErrorMsg_TitleCL)
                .withCustomReportMessage("Verify error msg's title")
                .perform();
        driver.assertThat().element(gerneralErrorMsg_Text)
                .text().contains(gerneralErrorMsg_TextCL)
                .withCustomReportMessage("Verify error msg's text")
                .perform();
    }
    @Step("Validate Information From Vodafone Container Box")
    public void validateInformationFromVFPrivacyPage() {
        driver.assertThat().element(informationFromVF_StepperTitle)
                .text().contains(informationFromVF_StepperTitleCL)
                .withCustomReportMessage("Verify stepper title")
                .perform();
        //EmailCard
        driver.assertThat().element(emailCard).exists().withCustomReportMessage("Email card Exists").perform();
        driver.assertThat().element(emailCard_Title)
                .text().contains(emailCard_TitleCL)
                .withCustomReportMessage("Verify Email card title")
                .perform();
        driver.assertThat().element(emailCard_LastUpdateText)
                .text().contains(emailCard_LastUpdateTextCL)
                .withCustomReportMessage("Verify last update text")
                .perform();
        driver.assertThat().element(emailCard_LastUpdateDate)
                .text().contains(emailCard_LastUpdateDateCL)
                .withCustomReportMessage("Verify last update date")
                .perform();
        driver.assertThat().element(emailCard_Text)
                .text().contains(emailCard_TextCL)
                .withCustomReportMessage("Verify Email card text")
                .perform();
        //SMS/MMS Card
        driver.assertThat().element(smsCard).exists().withCustomReportMessage("SMS/MMS card Exists").perform();
        driver.assertThat().element(smsCard_Title)
                .text().contains(smsCard_TitleCL)
                .withCustomReportMessage("Verify SMS card title")
                .perform();
        driver.assertThat().element(smsCard_LastUpdateText)
                .text().contains(smsCard_LastUpdateTextCL)
                .withCustomReportMessage("Verify SMS last update text")
                .perform();
        driver.assertThat().element(smsCard_LastUpdateDate)
                .text().contains(smsCard_LastUpdateDateCL)
                .withCustomReportMessage("Verify SMS last update date")
                .perform();
        driver.assertThat().element(smsCard_Text)
                .text().contains(smsCard_TextCL)
                .withCustomReportMessage("Verify SMS card text")
                .perform();

        //Post Card
        driver.assertThat().element(postCard).exists().withCustomReportMessage("Post card Exists").perform();
        driver.assertThat().element(postCard_Title)
                .text().contains(postCard_TitleCL)
                .withCustomReportMessage("Verify Post card title")
                .perform();
        driver.assertThat().element(postCard_LastUpdateText)
                .text().contains(postCard_LastUpdateTextCL)
                .withCustomReportMessage("Verify Post last update text")
                .perform();
        driver.assertThat().element(postCard_LastUpdateDate)
                .text().contains(postCard_LastUpdateDateCL)
                .withCustomReportMessage("Verify Post last update date")
                .perform();
        driver.assertThat().element(postCard_Text)
                .text().contains(postCard_TextCL)
                .withCustomReportMessage("Verify Post card text")
                .perform();
        //Anruf Card
        driver.assertThat().element(anrufCard).exists().withCustomReportMessage("anruf card Exists").perform();
        driver.assertThat().element(anrufCard_Title)
                .text().contains(anrufCard_TitleCL)
                .withCustomReportMessage("Verify anruf card title")
                .perform();
        driver.assertThat().element(anrufCard_LastUpdateText)
                .text().contains(anrufCard_LastUpdateTextCL)
                .withCustomReportMessage("Verify anruf last update text")
                .perform();
        driver.assertThat().element(anrufCard_LastUpdateDate)
                .text().contains(anrufCard_LastUpdateDateCL)
                .withCustomReportMessage("Verify anruf last update date")
                .perform();
        driver.assertThat().element(anrufCard_Text)
                .text().contains(anrufCard_TextCL)
                .withCustomReportMessage("Verify anruf card text")
                .perform();
        driver.assertThat().element(change_btn).text().isEqualTo("Bestätigen").perform();
        driver.assertThat().element(change_btn).isDisabled().perform();
    }
    @Step("Switch Email Toggle to on ")
    public void switchEmailToggleToON() {
        driver.element().click(emailToggleON);
    }
    @Step("Click on Change Button")
    public void clickOnChangeBtn() {
        driver.element().click(change_btn);
    }
    @Step("Validate Confirmation Message")
    public void validateConfirmationMessage() {
        driver.assertThat().element(confirmationMsg2_Title_EmailCard)
                .text().contains(confirmationMsg2_TitleCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Text_EmailCard)
                .text().contains(confirmationMsg2_TextCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Question_EmailCard)
                .text().contains(confirmationMsg2_QuestionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_YesOption_EmailCard)
                .text().contains(confirmationMsg2_YesOptionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_NOOption_EmailCard)
                .text().contains(confirmationMsg2_NOOptionCL)
                .perform();
    }

    @Step("Click on Ja, Änderungen speichern Option")
    public void clickOnJaBtn() {
        driver.element().click(confirmationMsg2_YesOption_EmailCard);
    }
    @Step("validate success message")
    public void validateSuccessMessage() {
        driver.assertThat().element(successMessage)
                .text().contains(successMessageCL).withCustomReportMessage("Validate success message")
                .perform();
    }
    @Step("validate that edited action is done")
    public void validateEditedActionDone() {
        driver.assertThat().element(emailToggleON);
    }
    @Step("validate that change button is disabled")
    public void validateChangeBtnDisabled() {
        driver.assertThat().element(change_btn).isDisabled();
    }


    public void validatePersonalDataPrivacyPage() {
        driver.assertThat().element(sectionTitle)
                .text().isEqualTo(personalData_sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();
        driver.assertThat().element(permissionTitle)
                .text().isEqualTo(personalData_permissionTitleCL)
                .withCustomReportMessage("Verify permission title")
                .perform();
        driver.assertThat().element(permission_LastUpdateLabel)
                .text().contains(personalData_permission_LastUpdateLabelCL)
                .withCustomReportMessage("Verify PermissionLast Update Label")
                .perform();
        driver.assertThat().element(Permission_LastUpdateDate)
                .exists().perform();
        driver.assertThat().element(permission_Body)
                .text().contains(personalData_permission_BodyCL)
                .withCustomReportMessage("Verify Permission text")
                .perform();
    }
    public void switchPersonalDataToggleToON() {
        driver.element().click(permissionToggleOn);
    }
    public void clickOnPersonalDataChangeBtn() {
        driver.element().click(personalData_ChangeBtn);
    }
    public void validatePersonalDataConfirmationMessage() {
        driver.assertThat().element(confirmationMsg2_Title_PersonalData)
                .text().contains(confirmationMsg2_TitleCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Text_PersonalData)
                .text().contains(confirmationMsg2_TextCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Question_PersonalData)
                .text().contains(confirmationMsg2_QuestionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_YesOption_PersonalData)
                .text().contains(confirmationMsg2_YesOptionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_NOOption_PersonalData)
                .text().contains(confirmationMsg2_NOOptionCL)
                .perform();
    }

    public void clickOnPersonalDataJaBtn() {
        driver.element().click(confirmationMsg2_YesOption_PesrsonalData);
    }
    public void validatePersonalDataEditedActionDone() {
        driver.assertThat().element(permissionToggleOn_PersonalData).exists().perform();
    }

    public void validatePersonalDataChangeBtnDisabled() {
        driver.assertThat().element(personalData_ChangeBtn).isDisabled().perform();
    }
    public void validatePersonalDataFailureMessage() {
        driver.assertThat().element(failureMessage).text()
                .isEqualTo(failureMessageCL).perform();
    }
    public void validatePersonalDataEditedActionNotDone() {
        driver.assertThat().element(permissionToggleOFF_PersonalData).exists().perform();
    }
    public void validateInternetUsagePrivacyPage() {
        driver.assertThat().element(internetUsage_sectionTitle)
                .text().isEqualTo(internetUsage_sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();
        driver.assertThat().element(internetUsage_permissionTitle)
                .text().isEqualTo(internetUsage_permissionTitleCL)
                .withCustomReportMessage("Verify permission title")
                .perform();
        driver.assertThat().element(internetUsage_permission_LastUpdateLabel)
                .text().contains(internetUsage_permission_LastUpdateLabelCL)
                .withCustomReportMessage("Verify PermissionLast Update Label")
                .perform();
        driver.assertThat().element(internetUsage_permission_LastUpdateDate)
                .exists().perform();
        driver.assertThat().element(internetUsage_permission_Body)
                .text().contains(internetUsage_permission_BodyCL)
                .withCustomReportMessage("Verify Permission text")
                .perform();
    }
    public void switchInternetUsageToggleToOFF() {
        driver.element().click(permissionToggleOFF_InternetUsage);
    }
    public void validateInternetUsageFirstConfirmationMessage() {
        driver.assertThat().element(confirmationMsg1_TitleCL_InternetUsage)
                .text().contains(confirmationMsg2_TitleCL)
                .withCustomReportMessage("Verify first confirmation msg title")
                .perform();
        driver.assertThat().element(confirmationMsg1_TextCL_InternetUsage)
                .text().contains(confirmationMsg1_TextCL_InternetUsageCL)
                .withCustomReportMessage("Verify first confirmation msg text")
                .perform();
        driver.assertThat().element(accept_Btn_Confirmationsg1)
                .text().contains(accept_Btn_Confirmationsg1CL)
                .perform();
        driver.assertThat().element(decline_Btn_Confirmationsg1)
                .text().contains(decline_Btn_Confirmationsg1CL)
                .perform();
    }
    public void clickOnAcceptBtnOfFirstConfirmationMsg() {
        driver.element().click(accept_Btn_Confirmationsg1);
    }
    public void clickOnInternetUsageChangeBtn() {
        driver.element().click(internetUsage_ChangeBtn);
    }
    public void validateInternetUsageSecondConfirmationMessage() {
        driver.assertThat().element(confirmationMsg2_Title_internetUsage)
                .text().contains(confirmationMsg2_TitleCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Text_internetUsage)
                .text().contains(confirmationMsg2_TextCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_Question_internetUsage)
                .text().contains(confirmationMsg2_QuestionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_YesOption_internetUsage)
                .text().contains(confirmationMsg2_YesOptionCL)
                .perform();
        driver.assertThat().element(confirmationMsg2_NOOption_internetUsage)
                .text().contains(confirmationMsg2_NOOptionCL)
                .perform();
    }
    public void clickOnInternetUsageJaBtn() {
        driver.element().click(confirmationMsg2_YesOption_internetUsage);
    }
    public void validateInternetUsageEditedActionNotDone() {
        driver.assertThat().element(permissionToggleON_InternetUsage).exists().perform();
    }
    public void validateInternetUsageChangeBtnDisabled() {
        driver.assertThat().element(internetUsage_ChangeBtn).isDisabled().perform();
    }

}
