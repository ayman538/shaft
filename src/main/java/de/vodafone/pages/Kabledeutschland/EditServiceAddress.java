package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EditServiceAddress {
    private SHAFT.GUI.WebDriver driver;
    //CLs
    private static String page_TitleCL= "Umzugsservice";
    private static String firstAcc_Title_CL = "Umzugsdaten";
    private static String firstAcc_Header_CL = "Gib bitte Dein Umzugsdatum ein.";
    private static String insideGermany_checkbox_Text1_CL = "Der Umzug Deines";
    private static String insideGermany_checkbox_Text2_CL = "kann Kosten verursachen. Den genauen Preis findest Du in unserer";
    private static String insideGermany_checkbox_Text3_CL = "Falls Du nur mit Deinem";
    private static String insideGermany_checkbox_Text4_CL = "umziehst, fallen keine Kosten an.";
    private static String insideGermany_checkbox_Text5_CL = "Internet- und Telefonprodukts";
    private static String insideGermany_checkbox_Text6_CL = "TV-Produkt";




    private static String secondStep_Acc_SupHeader_CL="Die Ummeldung gilt, vorbehaltlich einer endgültigen Prüfung, grundsätzlich ab dem Tag des Umzugs.";
    private static String secondStep_Acc_Header_CL ="Dein Umzugstermin und Deine neue Adresse";
    private static String secondStep_Acc_Header_OutsidGermany_CL ="Dein Umzugstermin ins Ausland";
    private static String OutsideGermany_checkbox_Text_CL ="Ich ziehe um ins Ausland";
    private static String date_Title_CL = "Datum *";
    private static String street_field_Title_CL = "Straße *";
    private static String houseNum_Title_CL = "Hausnummer *";
    private static String houseSup_Title_CL = "Hausnr.-Zusatz";
    private static String postCode_Title_CL = "PLZ *";
    private static String city_Title_CL = "Ort *";
    private static String infoNotficationmMsg_CL="Der Umzug Deines Internet- und Telefonprodukts kostet Dich einmalig 39,99€.\n" +
            "\n" +
            "Falls Du nur mit Deinem TV-Produkt umziehst, fallen keine Kosten an.";
    private static String scndStep_Title_CL = "Daten überprüfen";
    private static String required_Text_CL = "Pflichtfeld";
    //non-existing-address-notification
    private static String notficationMsgText_NonExistAddress_CL = "Überprüf bitte Deine Angaben. Wenn Deine Adresse erneut nicht gefunden werden kann, ruf uns einfach kostenlos unter der 0800 172 1212 an.";
    private static String notficationMsgHeader_CL = "Da stimmt was nicht";
    private static String notficationMsgHeader2_CL = "Fast geschafft";
    private static String notficationMsgText_CL = "Wenn ja, bestätige sie bitte unten. Die Adresse stimmt nicht? Korrigier sie einfach nochmal.";

    private static String suggestedAddress_Header_CL = "Ist eine von diesen Adressen richtig? Dann klick einfach drauf.";
    private static String fuzzyLogicMSG_Text_CL = "Wenn ja, bestätige sie bitte unten. Die Adresse stimmt nicht? Korrigier sie einfach nochmal.";
    private static String dslView_SubTitle_CL = "Die geprüfte Adresse:";
    private static String dslView_Text_CL = "Adresse ändern";

    private static String dslView_Text2_CL = "Wähl jetzt Deinen Wunsch-Tarif in Deinem neuen Zuhause aus. Wir kümmern uns um den Rest.";
    private static String dslLinkOffer_Btn_CL = "Zum DSL-Angebot";
    private static String dsl_booking_ZuHause_PageTitleCL = " ";
    private static String dslView_Title_CL = "Prüfung erfolgreich!";

    // CLS updated as a new US WFDT-8746
    //private static String noVFconnection_View_MSgText_CL = "Wir helfen Dir gerne beim Umzug ins neue Zuhause. Für Deine neue Adresse bekommst Du ein persönliches Angebot. Ruf uns kostenlos unter der 0800 72 39 653 an.";
    private static String noVFconnection_View_MSgText_CL = "Wähl jetzt Deinen Wunsch-Tarif in Deinem neuen Zuhause aus. Wir kümmern uns um den Rest.";

    private static String noVFconnection_View_MsgTitle_CL = "Prüfung erfolgreich!";
    private static String noVFconnection_MsgSubTitle_CL = "Die geprüfte Adresse:";

    private static String um_View_MsgTitle_CL = "Prüfung erfolgreich!";
    private static String um_View_MsgSubTitle_CL = "Die geprüfte Adresse:";

    // CLS updated as a new US WFDT-8746
    //private static String um_View_MSgText_CL = "Wir helfen Dir gerne beim Umzug ins neue Zuhause. Für Deine neue Adresse bekommst Du ein persönliches Angebot. Ruf uns kostenlos unter der 0800 723 81 89 an.";
    private static String um_View_MSgText_CL = "Wähl jetzt Deinen Wunsch-Tarif in Deinem neuen Zuhause aus. Wir kümmern uns um den Rest.";

    private static String fuzzyLogicMSG_Header_CL = "Fast geschafft";
    private static String streetRegex_CL ="Ferdinand-Ereun-Plarzhghghghrghghghghhgnghrerte";
    private static String hausNumberRegex_CL ="1234678#$ A112";
    private static String supHouseNumRegex_CL ="1b";
    private static String cityRegex_CL ="Düsseldorfinngh1$hnghgllfr snggcccchghgi";
    private static String postalCodeRegex_CL ="345434";
    private static String street_InlineMsgRegex_CL ="Der Straßenname darf max. 40 Zeichen lang sein. Nur Buchstaben, Zahlen, Leerzeichen, Punkt und Bindestrich.";
    private static String postalCode_InlineMsgRegex_CL ="Gib bitte nur deutsche Postleitzahlen mit max. 5 Zeichen ein.";
    private static String houseNum_InlineMsgRegex_CL ="Gib bitte max. 12 Zahlen ein. Keine Buchstaben, Leer- oder Sonderzeichen.";
    private static String houseSup_InlineMsgRegex_CL ="Gib bitte max. einen Buchstaben ein. Keine Zahlen, Leer- oder Sonderzeichen.";
    private static String city_InlnieMsgRegex_CL ="Der Wohnort darf max. 30 Zeichen lang sein. Nur Buchstaben, Leerzeichen, Punkt und Bindestrich.";
    private static String confirmationMsg_Header_CL = "Geschafft";
    private static String confirmationMsg_Text_CL = "Wir haben Deine neue Adresse gespeichert. Du musst jetzt nichts weiter tun. Wir prüfen Deinen Umzugstermin und melden uns zeitnah bei Dir.";
    private static String editedStreetName_CL ="Musterstr";
    private static String editedHouseNum3 ="3";
    private static String editedHouseNum4 ="4";
    private static String editedHouseNum5 ="5";
    private static String editedHouseNum6 ="1";
    private static String editedHouseNum7 ="7";
    private static String editedHouseNum8 ="8";


    private static String editeddDate_CL= "19.04.2024";
    private static String editedHouseNumNotInDB_CL ="9";
    private static String editedHouseNum_CL="1";
    private static String editedCity_CL="Düsseldorf";
    private static String editsupHouseNum_CL="a";
    private static String editedPostalCode_CL="40549";
    private static String error_MSG_TitleCL = "Das hat leider nicht geklappt";
    private static String error_MSG_TextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    //Locators
    private static final By page_Title = By.xpath("//div[@class='content-wrap']//h1");
    private static final By firstStep_Acc_Title = By.xpath("//div[@class='header-title']");
    private static final By secondStep_Acc_Title = By.xpath("//div[@class='header-title disable-header']");
    private static final By firstStep_Acc_Header = By.xpath("//h3[@automation-id='description_tv']");
    //EditStepLocators
    private static final By outsideGermany_checkbox = By.xpath("//div[@automation-id='checkboxItemModel.id_label_tv']");
    private static final By outsideGermany_checkbox_Text = By.xpath("//div[@automation-id='checkboxItemModel.id_label_tv']");
    private static final By houseNumber_field_Title = By.xpath("//label[@for='text' and contains(text(),'Hausnummer ')]");
    private static final By postalCode_Entry = By.id("zipCode");
    private static final By postalCode_field_Title = By.xpath("//label[@for='text' and contains(text(),'PLZ ')]");
    private static final By houseSup_field_Title = By.xpath("//label[@for='text' and contains(text(),'Hausnr.-Zusatz ')]");
    private static final By required_Text = By.xpath("//span[@automation-id='requiredLabel_tv']");
    private static final By city_field_Entry = By.id("city");
    private static final By city_field_Title = By.xpath("//label[@for='text' and contains(text(),'Ort ')]");
    private static final By infoNotficationmMsg = By.xpath("//*[@id='stepper-component-step-1']//div[2]/p");
    private static final By date_field_Entry = By.id("db2");
    private static final By date_field_Title = By.xpath("//label[@for='picker']");
    private static final By streetName_Title = By.xpath("//label[@for='text' and contains(text(),'Straße ')]");
    private static final By streetName_Entry = By.id("street");
    // private static final By dateAfter6months = By.xpath("//div[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'25')]");
    private static final By dateAfter6months = By.xpath("//button[@aria-label='Mon Sep 25 2023']");
    private static final By datePicker = By.xpath("//*[@class='icon field-icon i-sml i-grey-20']");
    private static final By newServiceAddressDate =By.xpath("//button[@aria-label='Sun Apr 30 2023']");
    private static final By newServiceAddressSepDate =By.xpath("//button[@aria-label='Sun Oct 01 2023']");
    private static final By nextButton = By.xpath("(//button[@type='button'])[3]");
    private static final By houseNum_Entry = By.id("houseNumber");
    private static final By houseSup_Entry = By.id("houseNumberExtension");
    public static final By error_MSG_Title = By.xpath("//div[@automation-id='undefined_nt']//div[@class=\"item-2 w-100\"]");
    public static final By error_MSG_text = By.xpath("//div[@automation-id='undefined_nt']//p");

    //ReviewStepLocators
    private static final By secondStep_Acc_SupHeader = By.xpath("//p[@automation-id='paragraph_tv']");
    private static final By secondStep_Acc_Header = By.xpath("//h3[@automation-id='title_tv']");
    private static final By postalCode_ReviewStep  = By.xpath("//div[@automation-id='zipCode_tv']");
    private static final By city_ReviewStep = By.xpath("//div[@automation-id='city_tv']");
    private static final By street_ReviewStep= By.xpath("//div[@automation-id='street_tv']");
    private static final By  houseNum_ReviewStep = By.xpath("//div[@automation-id='houseNumber_tv']");
    private static final By  houseSup_ReviewStep= By.xpath("//div[@automation-id='houseNumberExtension_tv']");
    private static final By date_ReviewStep = By.xpath("//div[@automation-id='movingDate_tv']//span");
    //FieldRegexInlineMsgsLocators
    private static final By housSup_InlnieMsgRegex = By.xpath("//p[@automation-id='houseNumberExtension_patternErrorMessage_et']");
    private static final By city_InlnieMsgRegex = By.xpath("//p[@automation-id='city_patternErrorMessage_et']");
    private static final By street_InlineMsgRegex = By.xpath("//p[@automation-id='street_patternErrorMessage_et']");
    private static final By houseNum_InlineMsgRegex = By.xpath("//p[@automation-id='houseNumber_patternErrorMessage_et']");
    private static final By postalCode_InlineMsgRegex = By.xpath("//p[@automation-id='zipCode_patternErrorMessage_et']");
    private static final By agreeCheckBox_Btn = By.xpath("//div[@automation-id='checkboxItemModel.id_label_tv']");
    private static final By confirmationMsg_Title = By.xpath("//div[@class='item-2 w-100']/h4");
    private static final By confirmationMsg_Text = By.xpath("//div[@automation-id='successConfirmation_nt']//p");

    private static final By suggestedAddress_Header = By.xpath("//*[@id='stepper-component-step-0']//h3");
    private static final By fuzzyLogicMSG_Header =  By.xpath("//div[@class='item-2 w-100']");
    private static final By fuzzyLogicMSG_Text =  By.xpath("//p[@automation-id='changeOrSelectAddress_tv']");
    private static final By fuzzyLogic_AddressCorrection_Btn =  By.xpath("//button[@automation-id='changeOrSelectAddress_tv']");
    private static final By suggestedAddressBox1_Btn =  By.xpath("//*[@id='address1']");
    private static final By suggestedAddressBox2_Btn =  By.xpath("(//div[@automation-id='address_rb'])[2]");
    private static final By fuzzyLogicMSG_title =By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By dslLinkOffer_Btn = By.xpath("//button[@automation-id='confirm_dsl_btn']");
    private static final By reChangeAddressLink = By.xpath("");
    private static final By dsl_booking_ZuHause_PageTitle = By.xpath("");
    private static final By dslView_Title = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By dslView_SubTitle = By.xpath("//div[@automation-id=\"successMsg_tv\"]//span/strong");
    private static final By dslView_link = By.xpath("(//div[@automation-id='successMsg_tv']//span)[2]");
    private static final By dslView_Text2= By.xpath("//div[@automation-id='successMsg_tv']//p");

    private static final By um_View_MsgTitle = By.xpath("//div[@automation-id='availabilityNoification_nt']//h4");
    private static final By um_View_MsgSubTitle = By.xpath("//div[@automation-id='successMsg_tv']//strong");
    private static final By um_View_MsgText = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static final By noVFconnection_View_MsgTitle = By.xpath("//div[@automation-id='availabilityNoification_nt']//h4");
    private static final By noVFconnection_View_MsgSubTitle = By.xpath("//div[@automation-id='successMsg_tv']//strong");
    private static final By noVFconnection_View_MsgText = By.xpath("//div[@automation-id='successMsg_tv']//p");

    private static final By reviewStepTitle = By.xpath("//h3[@automation-id='title_tv']");
    private static final By insideGermany_checkbox_Text1 = By.xpath("(//div[@class='ng-star-inserted']//span)[2]");
    private static final By insideGermany_checkbox_Text1_GC6 = By.xpath("(//div/p/span)[1]");
    private static final By insideGermany_checkbox_Text2 = By.xpath("(//div[@class='ng-star-inserted']//span)[3]");
    private static final By insideGermany_checkbox_Text2_GC6=By.xpath("(//div/p/span)[2]");
    private static final By insideGermany_checkbox_Text3 = By.xpath("(//div[@class='ng-star-inserted']//span)[4]");
    private static final By insideGermany_checkbox_Text3_GC6 = By.xpath("(//div/p/span)[3]");
    private static final By insideGermany_checkbox_Text4 = By.xpath("(//div[@class='ng-star-inserted']//span)[5]");
    private static final By insideGermany_checkbox_Text4_GC6 = By.xpath("(//div/p/span)[4]");
    private static final By insideGermany_checkbox_Text5 = By.xpath("(//div[@class='ng-star-inserted']//strong)[2]");
    private static final By insideGermany_checkbox_Text5_GC6 = By.xpath("(//div/p/strong)[1]");
    private static final By insideGermany_checkbox_Text6 = By.xpath("(//div[@class='ng-star-inserted']//strong)[3]");
    private static final By insideGermany_checkbox_Text6_GC6 = By.xpath("(//div/p/strong)[2]");

    private static final By back_Btn = By.xpath("//a[@automation-id='back_Link']");
    private static final By changedDate_ReviewPage = By.xpath("//div[@automation-id='movingDate_tv']");
    private static final By continue_Btn = By.xpath("//button[@automation-id='change_address_btn']");
    private static final By requestEdit_Btn = By.xpath("//button[@automation-id='Report_A_Move_btn']");
    private static final By  correctAddress_Btn = By.xpath("//button[@automation-id='changeOrSelectAddress_tv']");
    private static final By  notficationMsgText = By.xpath("//p[@automation-id='changeOrSelectAddress_tv']");
    private static final By  notficationMsgHeader = By.xpath("//*[@automation-id='Fuzzy_logic_nt']//h4");

    // In-case not-existing Address in DB
    private static final By  correctAddress_NonExistAddress_Btn = By.xpath("//button[@automation-id=\"changeOrSelectAddress_tv\"]");
    private static final By  notificationMsgText_NonExistAddress = By.xpath("//p[@automation-id='changeOrSelectAddress_tv']");


    //Methods
    public EditServiceAddress(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    public EditServiceAddress clickOnContinueBtn () {
        driver.element().click( continue_Btn);
        return this;
    }

    @Step ("Validate that all fields are dimmed in case outside germany")
    public EditServiceAddress validateDimmedFields () {
        driver.verifyThat().element(streetName_Entry).isDisabled().perform();
        driver.verifyThat().element(houseSup_Entry).isDisabled().perform();
        driver.verifyThat().element(houseNum_Entry).isDisabled().perform();
        driver.verifyThat().element(postalCode_Entry).isDisabled().perform();
        driver.verifyThat().element(city_field_Entry).isDisabled().perform();
        return this;
    }

    @Step("Validate Review step of Service address Customer outside Germany")
    public EditServiceAddress validateReviewStepOutsideGermany() {
        driver.element().isElementDisplayed(secondStep_Acc_Header);
        driver.verifyThat().element(secondStep_Acc_Header)
                .textTrimmed().isEqualTo(secondStep_Acc_Header_OutsidGermany_CL)
                .withCustomReportMessage("Check that the header is correct")
                .perform();
        driver.verifyThat().element(secondStep_Acc_SupHeader)
                .textTrimmed().isEqualTo(secondStep_Acc_SupHeader_CL)
                .withCustomReportMessage("Check that the sup-header's text is correct")
                .perform();
        driver.verifyThat().element(changedDate_ReviewPage).exists().perform();
        driver.verifyThat().element(requestEdit_Btn).isEnabled().perform();
        return this;

    }

    @Step("click on Change address Button")
    public EditServiceAddress clickOnChangeAddressBtn_OutsideGermany()
    {
        driver.element().isElementClickable(requestEdit_Btn);
        driver.element().click(requestEdit_Btn);
        return this;
    }

    @Step("Click On Out-Side Germany CheckBox")
    public EditServiceAddress clickOnOutSideGermanyCheckBox()
    {
        driver.element().isElementClickable(outsideGermany_checkbox);
        driver.element().click(outsideGermany_checkbox);
        return this;
    }

    @Step("Validate Notification msg in case the edited Address is none existing address in the data base")
    public EditServiceAddress validateNotificationMsgOfNonExistedAddress(){
        driver.verifyThat().element(notficationMsgHeader)
                .textTrimmed().isEqualTo(notficationMsgHeader_CL)
                .withCustomReportMessage("Check that the header is correct")
                .perform();
        driver.verifyThat().element(notificationMsgText_NonExistAddress)
                .textTrimmed().isEqualTo(notficationMsgText_NonExistAddress_CL)
                .withCustomReportMessage("Check that the text is correct")
                .perform();
        driver.verifyThat().element(correctAddress_NonExistAddress_Btn).isEnabled().perform();
        return this;
    }

    @Step("Validate Notification msg in case the edited Address is the same as the existed service address")
    public EditServiceAddress validateNotificationMsgSameAddress(){
        driver.verifyThat().element(notficationMsgHeader)
                .textTrimmed().isEqualTo(notficationMsgHeader2_CL)
                .withCustomReportMessage("Check that the header is correct")
                .perform();
        driver.verifyThat().element(notficationMsgText)
                .textTrimmed().isEqualTo(notficationMsgText_CL)
                .withCustomReportMessage("Check that the text is correct")
                .perform();
        driver.verifyThat().element(correctAddress_Btn).isEnabled().perform();
        driver.verifyThat().element(suggestedAddressBox1_Btn).isEnabled().perform();
        return this;
    }

    @Step("Validate Suggested Address's fuzzy logic Step's content")
    public EditServiceAddress validateAddressSuggestionView(){
        driver.verifyThat().element(fuzzyLogicMSG_Header)
                .textTrimmed().isEqualTo(fuzzyLogicMSG_Header_CL)
                .withCustomReportMessage("Check that header is correct ")
                .perform();
        driver.verifyThat().element(fuzzyLogicMSG_Text)
                .textTrimmed().isEqualTo(fuzzyLogicMSG_Text_CL)
                .withCustomReportMessage("Check that header is correct ")
                .perform();
        driver.verifyThat().element(fuzzyLogic_AddressCorrection_Btn).exists().perform();
        driver.verifyThat().element(suggestedAddress_Header).exists().perform();
        driver.verifyThat().element(suggestedAddressBox1_Btn).exists().perform();
        return this;
    }

    @Step ("Select Suggested address from Fuzzy Logic")
    public EditServiceAddress selectSuggestedAddress(){
        driver.element().doubleClick(suggestedAddressBox1_Btn);
        return this;
    }

    @Step ("Select Suggested address2 from Fuzzy Logic")
    public EditServiceAddress selectSuggestedAddress2(){
        driver.verifyThat().element(fuzzyLogicMSG_title).exists().perform();
        driver.element().click(suggestedAddressBox2_Btn);
        return this;
    }

    @Step("Validate the UML Connection msg view")
    public EditServiceAddress validateUMLConnectionView(){
        driver.verifyThat().element(um_View_MsgTitle)
                .textTrimmed().isEqualTo(um_View_MsgTitle_CL)
                .withCustomReportMessage("validate the UM View msg's title")
                .perform();
        driver.verifyThat().element(um_View_MsgSubTitle)
                .textTrimmed().isEqualTo(um_View_MsgSubTitle_CL)
                .withCustomReportMessage("validate the UM View msg's sub-title")
                .perform();
        driver.verifyThat().element(um_View_MsgText)
                .textTrimmed().isEqualTo(um_View_MSgText_CL)
                .withCustomReportMessage("validate the UM View msg's text")
                .perform();
        return this;
    }

    @Step("Validate the view when there's no VF Connection")
    public EditServiceAddress validateNoVFConnectionAvailableView()
    {
        driver.verifyThat().element(noVFconnection_View_MsgTitle)
                .textTrimmed().isEqualTo(noVFconnection_View_MsgTitle_CL)
                .withCustomReportMessage("validate the NO VF Connection View msg's title")
                .perform();
        driver.verifyThat().element(noVFconnection_View_MsgSubTitle)
                .textTrimmed().isEqualTo(noVFconnection_MsgSubTitle_CL)
                .withCustomReportMessage("validate the  NO VF Connection View msg's sub-title")
                .perform();
        driver.verifyThat().element(noVFconnection_View_MsgText)
                .textTrimmed().isEqualTo(noVFconnection_View_MSgText_CL)
                .withCustomReportMessage("validate the NO VF Connection View msg's text")
                .perform();
        return this;
    }

    @Step("Validate the DSL Connection msg view")
    public EditServiceAddress validateDSLConnectionView(){
        driver.verifyThat().element(back_Btn).exists();
        driver.verifyThat().element(dslView_SubTitle)
                .textTrimmed().isEqualTo(dslView_SubTitle_CL)
                .withCustomReportMessage("validate the DSL View msg's sub-title")
                .perform();
        driver.verifyThat().element(dslView_Title)
                .textTrimmed().isEqualTo(dslView_Title_CL)
                .withCustomReportMessage("validate the DSL View msg's title")
                .perform();
        driver.verifyThat().element(dslView_link)
                .textTrimmed().contains(dslView_Text_CL)
                .withCustomReportMessage("validate the DSL View msg's text")
                .perform();
        driver.verifyThat().element(dslView_Text2)
                .textTrimmed().contains(dslView_Text2_CL)
                .withCustomReportMessage("validate the DSL View msg's text2")
                .perform();
        driver.verifyThat().element(dslLinkOffer_Btn).isEnabled();
        driver.verifyThat().element(reChangeAddressLink).isEnabled();
        return this;
    }

    @Step ("validate the text of the agreement checkbox")
    public EditServiceAddress validateTextOfCheckBox(){
        driver.verifyThat().element(reviewStepTitle).exists();
        driver.verifyThat().element(insideGermany_checkbox_Text1)
                .textTrimmed().contains(insideGermany_checkbox_Text1_CL)
                .withCustomReportMessage("Check the text1 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text2)
                .textTrimmed().contains(insideGermany_checkbox_Text2_CL)
                .withCustomReportMessage("Check the text2 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text3)
                .textTrimmed().contains(insideGermany_checkbox_Text3_CL)
                .withCustomReportMessage("Check the text3 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text4)
                .textTrimmed().contains(insideGermany_checkbox_Text4_CL)
                .withCustomReportMessage("Check the text4 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text5)
                .textTrimmed().contains(insideGermany_checkbox_Text5_CL)
                .withCustomReportMessage("Check the text5 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text6)
                .textTrimmed().contains(insideGermany_checkbox_Text6_CL)
                .withCustomReportMessage("Check the text6 of the agreement checkbox inside germany")
                .perform();
        return this;
    }

    @Step ("validate the text of the agreement checkbox")
    public EditServiceAddress validateTextOfCheckBoxGC6(){
        driver.verifyThat().element(reviewStepTitle).exists();
        driver.verifyThat().element(insideGermany_checkbox_Text1_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text1_CL)
                .withCustomReportMessage("Check the text1 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text2_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text2_CL)
                .withCustomReportMessage("Check the text2 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text3_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text3_CL)
                .withCustomReportMessage("Check the text3 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text4_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text4_CL)
                .withCustomReportMessage("Check the text4 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text5_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text5_CL)
                .withCustomReportMessage("Check the text5 of the agreement checkbox inside germany")
                .perform();
        driver.verifyThat().element(insideGermany_checkbox_Text6_GC6)
                .textTrimmed().contains(insideGermany_checkbox_Text6_CL)
                .withCustomReportMessage("Check the text6 of the agreement checkbox inside germany")
                .perform();
        return this;
    }

    @Step("click on Agreed checkbox")
    public  EditServiceAddress validateAgreedCheckbox() {
        driver.element().isElementClickable(agreeCheckBox_Btn);
        driver.element().click(agreeCheckBox_Btn);
        driver.element().isElementDisplayed(requestEdit_Btn);
        driver.verifyThat().element(requestEdit_Btn).isEnabled().perform();
        return this;
    }

    @Step("Click on confirm Edit Address Button")
    public  EditServiceAddress clickOnChangeAddressBtn() {
        driver.element().isElementClickable(requestEdit_Btn);
        driver.element().click(requestEdit_Btn);
        return this;
    }

    @Step ("Validate Review Step Accordion")
    public  EditServiceAddress validateReviewStep_InsideGermany(){
        driver.verifyThat().element(secondStep_Acc_SupHeader)
                .textTrimmed().isEqualTo(secondStep_Acc_SupHeader_CL)
                .withCustomReportMessage("Check that second step acc header is correct")
                .perform();
        driver.element().isElementDisplayed(secondStep_Acc_Header);
        driver.verifyThat().element(secondStep_Acc_Header)
                .textTrimmed().isEqualTo(secondStep_Acc_Header_CL)
                .withCustomReportMessage("Check that second step acc supheader is correct")
                .perform();
        driver.verifyThat().element(date_ReviewStep).exists().perform();
        driver.verifyThat().element(street_ReviewStep).exists().perform();
        driver.verifyThat().element(houseNum_ReviewStep).exists().perform();
        driver.verifyThat().element(postalCode_ReviewStep).exists().perform();
        driver.verifyThat().element(city_ReviewStep).exists().perform();
        driver.verifyThat().element(infoNotficationmMsg).exists().perform();
        driver.verifyThat().element(back_Btn).exists().perform();
        return this;
    }

    @Step("validate confirmation page of edit service address outside germany")
    public EditServiceAddress validateConfirmationStep_OutsideGermany () {
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Header_CL)
                .withCustomReportMessage("Check that confirmation msg's header  is displayed correct")
                .perform();
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Check that confirmation msg's text is displayed correct")
                .perform();
        driver.verifyThat().element(back_Btn).exists().perform();
        return this;
    }

    public  EditServiceAddress validateConfirmationStep_InsideGermany() {
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Header_CL)
                .withCustomReportMessage("Check that confirmation msg's header  is displayed correct")
                .perform();
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Check that confirmation msg's text is displayed correct")
                .perform();
        driver.verifyThat().element(back_Btn).exists().perform();
        return this;
    }

    @Step("Validate Edit Service Address fields Regex")
    public EditServiceAddress validateFieldsRegex()
    {
        driver.element().type(streetName_Entry,streetRegex_CL);
        driver.verifyThat().element(street_InlineMsgRegex)
                .textTrimmed().isEqualTo(street_InlineMsgRegex_CL)
                .withCustomReportMessage("Check that street regex msg is correct")
                .perform();
        driver.element().type(houseNum_Entry,hausNumberRegex_CL);
        driver.verifyThat().element(houseNum_InlineMsgRegex)
                .textTrimmed().isEqualTo(houseNum_InlineMsgRegex_CL)
                .withCustomReportMessage("Check house number regex msg is correct")
                .perform();
        driver.element().type(houseSup_Entry,supHouseNumRegex_CL);
        driver.verifyThat().element(housSup_InlnieMsgRegex)
                .textTrimmed().isEqualTo(houseSup_InlineMsgRegex_CL)
                .withCustomReportMessage("Check that houseSup  regex msg is correct")
                .perform();
        driver.element().type(postalCode_Entry,postalCodeRegex_CL);
        driver.verifyThat().element(postalCode_InlineMsgRegex)
                .textTrimmed().isEqualTo(postalCode_InlineMsgRegex_CL)
                .withCustomReportMessage("Check that postal code regex msg is correct")
                .perform();
        driver.element().type(city_field_Entry,cityRegex_CL);
        driver.verifyThat().element(city_InlnieMsgRegex)
                .textTrimmed().isEqualTo(city_InlnieMsgRegex_CL)
                .withCustomReportMessage("Check that city regex msg is correct")
                .perform();
        return this;
    }

    @Step("Validate Edit Service Addresses Page's content ")
    public EditServiceAddress validateEditServiceAddressPage()
    {
        driver.verifyThat().element(back_Btn).exists().perform();
        driver.verifyThat().element(firstStep_Acc_Title)
                .textTrimmed().isEqualTo(firstAcc_Title_CL)
                .withCustomReportMessage("Validate first acc title")
                .perform();
        driver.verifyThat().element(page_Title)
                .textTrimmed().isEqualTo(page_TitleCL)
                .withCustomReportMessage("Validate page title ")
                .perform();
        driver.verifyThat().element(firstStep_Acc_Header)
                .textTrimmed().isEqualTo(firstAcc_Header_CL)
                .withCustomReportMessage("Validate first acc header")
                .perform();
        driver.verifyThat().element(date_field_Title)
                .textTrimmed().isEqualTo(date_Title_CL)
                .withCustomReportMessage("Validate date field title description")
                .perform();
        driver.verifyThat().element(date_field_Entry).exists().perform();
        driver.element().isElementDisplayed(outsideGermany_checkbox_Text);
        driver.verifyThat().element(outsideGermany_checkbox).exists().perform();
        driver.verifyThat().element(outsideGermany_checkbox_Text)
                .textTrimmed().isEqualTo(OutsideGermany_checkbox_Text_CL)
                .withCustomReportMessage("Validate inside germany checkbox description")
                .perform();
        driver.verifyThat().element(streetName_Entry).exists().perform();
        driver.verifyThat().element(streetName_Title)
                .textTrimmed().isEqualTo(street_field_Title_CL)
                .withCustomReportMessage("Validate street name field title")
                .perform();
        driver.verifyThat().element(houseNumber_field_Title)
                .textTrimmed().isEqualTo(houseNum_Title_CL)
                .withCustomReportMessage("Validate house number name field title")
                .perform();
        driver.verifyThat().element(houseNum_Entry).exists().perform();
        driver.verifyThat().element(houseSup_field_Title)
                .textTrimmed().isEqualTo(houseSup_Title_CL)
                .withCustomReportMessage("Validate house supnum name field title")
                .perform();
        driver.verifyThat().element(houseSup_Entry).exists().perform();
        driver.verifyThat().element(postalCode_field_Title)
                .textTrimmed().isEqualTo(postCode_Title_CL)
                .withCustomReportMessage("Validate postal code field title")
                .perform();
        driver.verifyThat().element(postalCode_Entry).exists().perform();
        driver.verifyThat().element(city_field_Title)
                .textTrimmed().isEqualTo(city_Title_CL)
                .withCustomReportMessage("Validate city field title")
                .perform();
        driver.verifyThat().element(city_field_Entry).exists().perform();
        driver.verifyThat().element(required_Text)
                .textTrimmed().isEqualTo(required_Text_CL)
                .withCustomReportMessage("Validate required text")
                .perform();
        driver.verifyThat().element(secondStep_Acc_Title)
                .textTrimmed().isEqualTo(scndStep_Title_CL)
                .withCustomReportMessage("Validate second accordion title")
                .perform();
        return this;
    }

    @Step("validate that no date Available after 6Ms from the current date")
    public EditServiceAddress validateNoAvailableDateAfter6Ms ()
    {
        driver.element().click(datePicker);
        driver.element().click(nextButton);
        driver.element().click(nextButton);
        driver.element().click(nextButton);
        driver.element().click(nextButton);
        driver.element().click(nextButton);
        driver.element().click(nextButton);
        return this;
    }

    @Step("Validate Outside Germany Checkbox is not checked")
    public EditServiceAddress validateNonCheckedOutSideGermany()
    {
        driver.verifyThat().element(outsideGermany_checkbox).isNotChecked().perform();
        return this;
    }

    @Step("Clear all fields")
    public EditServiceAddress clearFields()
    {
        driver.getDriver().findElement(streetName_Entry).clear();
        driver.getDriver().findElement(city_field_Entry).clear();
        driver.getDriver().findElement(postalCode_Entry).clear();
        driver.getDriver().findElement(houseNum_Entry).clear();
        driver.getDriver().findElement(houseSup_Entry).clear();
        return this;
    }

    @Step("Clear HouseNumber Field")
    public EditServiceAddress clearHouseNumber(){
        driver.getDriver().findElement(houseNum_Entry).clear();
        return this;
    }

    @Step("Change Service Address With an address that is not in the Database")
    public EditServiceAddress changeAddressWithNonExistingAddressInDB(){
        driver.element().type(date_field_Entry,editeddDate_CL);
        driver.getDriver().findElement(houseNum_Entry).clear();
        driver.element().type(houseNum_Entry,editedHouseNumNotInDB_CL);
        return this;
    }

    @Step ("Enter Edited date of Service Address")
    public EditServiceAddress  enterServiceAddressdate()
    {
        driver.element().type(date_field_Entry,editeddDate_CL);
        return this;
    }

    @Step ("Change Service Address Date")
    public EditServiceAddress SelectNewServiceAddressdate()
    {
        driver.element().type(date_field_Entry,editeddDate_CL);
        return this;
    }

    @Step ("Change Service Address Date on Sep")
    public EditServiceAddress SelectNewServiceAddressdateOnSep()
    {
        driver.element().type(date_field_Entry,editeddDate_CL);
        return this;
    }

    @Step ("Change Address inside Germany")
    public EditServiceAddress changeAddress()
    {
        driver.element().type(streetName_Entry,editedStreetName_CL);
        driver.element().type(houseNum_Entry,editedHouseNum_CL);
        driver.element().type(city_field_Entry,editedCity_CL);
        driver.element().type(houseSup_Entry,editsupHouseNum_CL);
        driver.element().type(postalCode_Entry,editedPostalCode_CL);
        return this;
    }

    @Step ("Change House Number Case3")
    public EditServiceAddress changeHouseNumberCaseThree()
    {
        driver.element().type(houseNum_Entry,editedHouseNum3);
        return this;
    }

    @Step ("Change House Number Case4")
    public EditServiceAddress changeHouseNumberCaseFour()
    {
        driver.element().type(houseNum_Entry,editedHouseNum4);
        return this;
    }

    @Step ("Change House Number Case5")
    public EditServiceAddress changeHouseNumberCaseFive()
    {
        driver.element().type(houseNum_Entry,editedHouseNum5);
        return this;
    }

    @Step ("Change House Number Case6")
    public EditServiceAddress changeHouseNumberCaseSix()
    {
        driver.element().type(houseNum_Entry,editedHouseNum6);
        return this;
    }

    @Step ("Change House Number Case7")
    public EditServiceAddress changeHouseNumberCaseSeven()
    {
        driver.element().type(houseNum_Entry,editedHouseNum7);
        return this;
    }

    @Step ("Change House Number Case8")
    public EditServiceAddress changeHouseNumberCaseEight()
    {
        driver.element().type(houseNum_Entry,editedHouseNum8);
        return this;
    }

    @Step("Validate general error message in case of service Failure")
    public EditServiceAddress validateGeneralErrorMessage() {
        driver.verifyThat().element(error_MSG_Title)
                .textTrimmed().isEqualTo(error_MSG_TitleCL)
                .withCustomReportMessage("Check Error Message Title")
                .perform();

        driver.verifyThat().element(error_MSG_text)
                .textTrimmed().isEqualTo(error_MSG_TextCL)
                .withCustomReportMessage("Check Error Message Description")
                .perform();
        return this;
    }

}