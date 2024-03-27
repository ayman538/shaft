package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class EditBillingAddress {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    //Entry point
    public static final By EditFirstDebitBilling_btn = By.xpath("(//*[@automation-id=\"changeAddress_btn\"])[1]");
    public static final By EditSecondDebitBilling_btn = By.xpath("(//*[@automation-id=\"changeAddress_btn\"])[2");
    public static final By changeAllAddressBtn = By.xpath("(//button[@automation-id='changeAllAddress_btn'])[1]");

    //InvoiceChooserPAge
    public static final By ChooseInvAcc_Title = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By ChooseInvAcc_Icon = By.xpath("//*[@class=\"icon-pin-sim-i-xsml i-xsml ac-icon\"]");
    public static final By ChooseInvAcc_Header = By.xpath("//*[@automation-id=\"description_tv\"]");
    public static final By FInv_OwnerSal = By.xpath("(//*[@automation-id=\"salutation_tv\"])[1]");
    public static final By FInv_OwnerFName = By.xpath("(//*[@automation-id=\"firstname_tv\"])[1]");
    public static final By FInv_OwnerLName = By.xpath("(//*[@automation-id=\"lastname_tv\"])[1]");
    public static final By FInv_OwnerStreet = By.xpath("(//*[@automation-id=\"street_tv\"])[1]");
    public static final By FInv_OwnerHouseNum = By.xpath("(//*[@automation-id=\"houseNumber_tv\"])[1]");
    public static final By FInv_OwnerPostCode = By.xpath("(//*[@automation-id=\"zipCode_tv\"])[1]");
    public static final By FInv_OwnerCity = By.xpath("(//*[@automation-id=\"city_tv\"])[1]");

    public static final By FirstInvoiceProdSection_Title = By.xpath("(//*[@automation-id=\"referenceKonto-header_tv\"])[1]");
    public static final By FirstInvoice_Number = By.xpath("(//*[@automation-id=\"referenceKonto_tv\"])[1]/strong[1]");
    public static final By FirstInvoiceProduct_Name = By.xpath("(//*[@automation-id=\"service_tv\"]/span)[1]");
    public static final By FirstInvoiceProduct_Icon = By.xpath("(//*[@automation-id=\"service_tv\"]//*[@class=\"i-sml\"])[1]");
    public static final By EditAddFirstInvoice_btn = By.xpath("(//*[@class=\"btn btn-em mt-20\"])[1]");

    public static final By LInv_OwnerSal = By.xpath("(//*[@automation-id=\"salutation_tv\"])[2]");
    public static final By LInv_OwnerFName = By.xpath("(//*[@automation-id=\"firstname_tv\"])[2]");
    public static final By LInv_OwnerLName = By.xpath("(//*[@automation-id=\"lastname_tv\"])[2]");
    public static final By LInv_OwnerStreet = By.xpath("(//*[@automation-id=\"street_tv\"])[2]");
    public static final By LInv_OwnerHouseNum = By.xpath("(//*[@automation-id=\"houseNumber_tv\"])[2]");
    public static final By LInv_OwnerPostCode = By.xpath("(//*[@automation-id=\"zipCode_tv\"])[2]");
    public static final By LInv_OwnerCity = By.xpath("(//*[@automation-id=\"city_tv\"])[2]");

    public static final By SecondInvoiceProdSection_Title = By.xpath("(//*[@automation-id=\"referenceKonto-header_tv\"])[2]");
    public static final By SecondInvoice_Number = By.xpath("(//*[@automation-id=\"referenceKonto_tv\"])[2]/strong[1]");
    public static final By SecondInvoiceProduct_Name = By.xpath("(//*[@automation-id=\"service_tv\"]/span)[2]");
    public static final By SecondInvoiceProduct_Icon = By.xpath("(//*[@automation-id=\"service_tv\"]//*[@class=\"i-sml\"])[3]");
    public static final By EditAddSecondInvoice_btn = By.xpath("(//*[@class=\"btn btn-em mt-20\"])[2]");

    //No Billing address
    public static final By NoBillingAddress_Title = By.xpath("//*[@automation-id=\"noBillingAddress_nt\"]//h4");
    public static final By NoBillingAddress_content = By.xpath("//*[@automation-id=\"noBillingAddress_nt\"]//p");
    public static final By NoBillingAddress_Icon = By.xpath("//*[@automation-id=\"noBillingAddress_nt\"]//*[@class=\"i-sml i-blue\"]");
    public static final By NoBillingAddress_Num = By.xpath("//*[@automation-id=\"noBillingAddress_nt\"]//a");

    //Edit Billing Address page First step
    public static final By EditBillingPage_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By EditBillingAcc_Title = By.xpath("//*[@id=\"step0\"]//*[@class=\"header-title\"]");
    public static final By EditBillingWarningMsg_Title = By.xpath("//*[@automation-id=\"hint_nt\"]//h4");
    public static final By EditBillingWarningMsg_Body = By.xpath("//*[@automation-id=\"hint_nt\"]//p");
    public static final By EditBillingHeader_Text = By.xpath("//*[@automation-id=\"description_tv\"]");

    public static final By CustomerTitle_Title = By.xpath("//*[@formcontrolname=\"title\"]//*[@class=\"fm-data\"]//label");
    public static final By CustomerTitle_Entry = By.xpath("//*[@automation-id=\"title_lv\"]");
    public static final By herrSalutation = By.xpath("//div[@automation-id=\"Herr_salutation_rb\"]");
    public static final By CustomerTitle_FirstOpt = By.xpath("//*[@automation-id=\"title_lv\"]/option[2]");
    public static final By FName_Title = By.xpath("//*[@formcontrolname=\"firstname\"]//*[@class=\"fm-data\"]//label");
    public static final By FName_Entry = By.xpath("//*[@automation-id=\"firstName_et\"]");
    public static final By LName_Title = By.xpath("//*[@formcontrolname=\"lastname\"]//*[@class=\"fm-data\"]//label");
    public static final By LName_Entry = By.xpath("//*[@automation-id=\"lastName_et\"]");
    public static final By StreetName_Title = By.xpath("(//*[@formgroupname=\"address\"]//*[@class=\"fm-data\"]//label)[1]");
    public static final By StreetName_Entry = By.xpath("//*[@automation-id=\"street_et\"]");
    public static final By HouseNum_Title = By.xpath("(//*[@formgroupname=\"address\"]//*[@class=\"fm-data\"]//label)[2]");
    public static final By HouseNum_Entry = By.xpath("//*[@automation-id=\"houseNumber_et\"]");
    public static final By HouseSup_Title = By.xpath("(//*[@formgroupname=\"address\"]//*[@class=\"fm-data\"]//label)[3]");
    public static final By HouseSup_Entry = By.xpath("//*[@automation-id=\"houseNumberExtension_et\"]");
    public static final By PostCode_Title = By.xpath("(//*[@formgroupname=\"address\"]//*[@class=\"fm-data\"]//label)[4]");
    public static final By PostCode_Entry = By.xpath("//*[@automation-id=\"zipCode_et\"]");
    public static final By City_Title = By.xpath("(//*[@formgroupname=\"address\"]//*[@class=\"fm-data\"]//label)[5]");
    public static final By City_Entry = By.xpath("//*[@automation-id=\"city_et\"]");
    public static final By Required_Text = By.xpath("//*[@automation-id=\"requiredLabel_tv\"]");
    public static final By ConfirmFStp_Btn = By.xpath("//*[@automation-id=\"change_address_btn\"]");
    public static final By ConfirmSStp_Btn = By.xpath("//button[@automation-id=\"Submit_Address_btn\"]");
    public static final By houseNoTxtBox = By.xpath("//input[@automation-id='houseNumber_et']");
    //Fuzzy logic
    public static final By FuzzyLogicMSG_Title = By.xpath("//*[@automation-id=\"Fuzzy_logic_nt\"]//h4");
    public static final By FuzzyLogicMSG_HeaderP1 = By.xpath("//*[@automation-id=\"address_NotFound_tv\"]/span[1]");
    public static final By FuzzyLogicMSG_HeaderP2 = By.xpath("//*[@automation-id=\"Wrong_address_tv\"]");
    public static final By FuzzyLogicMSG_HeaderP3 = By.xpath("//*[@automation-id=\"address_NotFound_tv\"]/span[2]");
    public static final By FuzzyLogicMSG_Text1 = By.xpath("//*/p[@automation-id=\"changeOrSelectAddress_tv\"]");
    public static final By FuzzyLogicMSG_Icon = By.xpath("(//*[@class='i-sml i-blue'])[1]");
    public static final By FuzzyLogicMSG_Btn = By.xpath("//*/button[@automation-id=\"changeOrSelectAddress_tv\"]");
    public static final By SuggestedAdd_Header = By.xpath("//*[@class='stepper-body show']//h3");
    public static final By SuggestedAdd_Tile = By.xpath("(//*[@automation-id=\"address_rb\"])[1]");
    public static final By firstSuggestedAddress = By.xpath("(//div[@automation-id='address_rb'])[1]");

    //Second Step
    public static final By SCndStep_Title = By.xpath("(//*[@class=\"header-title\"])[2]");
    public static final By SCndStep_Number = By.xpath("(//*[@class=\"header-icon\"])[2]");
    public static final By SCndStep_Header_Text = By.xpath("//*[@automation-id=\"description_tv\"]");
    public static final By Salutation_Title = By.xpath("//*[@automation-id=\"salutation_tv\"]/strong");
    public static final By Salutation_Content = By.xpath("//*[@automation-id=\"salutation_tv\"]/span");
    public static final By OrgName_Title = By.xpath("//*[@automation-id=\"organizationName_tv\"]/strong");
    public static final By OrgName_Content = By.xpath("//*[@automation-id=\"organizationName_tv\"]/span");
    public static final By NM_Title = By.xpath("//div[@automation-id='salutation_tv']/strong");
    public static final By NM_Content = By.xpath("//div[@automation-id='salutation_tv']/span");
    public static final By FN_Title = By.xpath("//*[@automation-id=\"firstName_tv\"]/strong");
    public static final By FN_Content = By.xpath("//*[@automation-id=\"firstName_tv\"]/span");
    public static final By LN_Title = By.xpath("//*[@automation-id=\"lastName_tv\"]/strong");
    public static final By LN_Content = By.xpath("//*[@automation-id=\"lastName_tv\"]/span");
    public static final By STr_Title = By.xpath("//*[@automation-id=\"Street_tv\"]/strong");
    public static final By STr_Content = By.xpath("//*[@automation-id=\"Street_tv\"]/span");
    public static final By HNum_Title = By.xpath("//*[@automation-id=\"houseNumber_tv\"]/strong");
    public static final By HNum_Content = By.xpath("//*[@automation-id=\"houseNumber_tv\"]/span");
    public static final By HSup_Title = By.xpath("//*[@automation-id=\"city_tv\"]/strong");
    public static final By HSup_Content = By.xpath("//*[@automation-id=\"city_tv\"]/span");
    public static final By PLZ_Title = By.xpath("//*[@automation-id=\"zipCode_tv\"]/strong");
    public static final By PLZ_Content = By.xpath("//*[@automation-id=\"zipCode_tv\"]/span");
    public static final By Town_Title = By.xpath("");
    public static final By Town_Content = By.xpath("");
    public static final By ConfirmSTP2_Btn = By.xpath("//*[@automation-id=\"Submit_Address_btn\"]");

    //Confirmation
    public static final By Success_Msg = By.xpath("//*[@automation-id=\"Success_single_nt\"]//h4");
    public static final By Success_Icon = By.xpath("//*[@automation-id=\"Success_single_nt\"]//*[@class=\"item-1\"]");
    public static final By InfoMsg_Title = By.xpath("//*[@automation-id=\"changeOthers_nt\"]//h4");
    public static final By InfoMsg_Text = By.xpath("//*[@automation-id=\"changeOthers_nt\"]//p");
    public static final By InfoMsg_Icon = By.xpath("//*[@automation-id=\"changeOthers_nt\"]//*[@class=\"item-1\"]");
    public static final By ReviewAcc_Title = By.xpath("(//*[@automation-id=\"preview_acc\"]//span)[1]");
    public static final By ReviewAccHeader_Text = By.xpath("");

    public static final By MultiSuccessMsg_Title = By.xpath("");
    public static final By MultiSuccessMsg_Icon = By.xpath("");
    public static final By MultiSuccessMsg_Text = By.xpath("");

    //CLs
    public static String NoBillingAddress_Title_CL = "Gut zu wissen";
    public static String NoBillingAddress_content_CL = "Wir nutzen für Deine Rechnung Deine Anschlussadresse. Du willst das ändern? Ruf uns einfach an: 0800 172 1212";
    public static String NoBillingAddress_Num_CL = "0800 172 1212";
    public static String ChooseInvAcc_Title_CL = "Adresse wählen";
    public static String ChooseInvAcc_Header_CL = "Gib bitte Deine Daten ein.";
    public static String InvoiceProdSection_Title_CL = "Verwendet für:";
    public static String Invoice_Number_CL = "Referenzkonto";
    public static String EditBillingInvoice_btn_CL = "Adresse bearbeiten";
    public static String EditBillingPage_Title_CL = "Rechnungsadresse ändern";
    public static String EditBillingAcc_Title_CL = "Adresse bearbeiten";
    public static String EditBillingWarningMsg_Title_CL = "Wichtig zu wissen";
    public static String EditBillingWarningMsg_Body_CL = "Die Rechnung schicken wir erst für den nächsten Abrechnungszeitraum an die geänderte Adresse.";
    public static String EditBillingHeader_Text_CL = "Gib bitte Deine Daten ein.";
    public static String CustomerTitle_Title_CL = "Titel";
    public static String CustomerTitle_Review_CL = "Anrede";
    public static String FName_Title_CL = "Vorname *";
    public static String FName_Title_ReviewCL = "Vorname";
    public static String LName_Title_CL = "Nachname *";
    public static String LName_Title_ReviewCL = "Nachname";
    public static String StreetName_Title_CL = "Straße *";
    public static String StreetName_Title_ReviewCL = "Straße";
    public static String HouseNum_Title_CL = "Hausnummer *";
    public static String HouseNum_Title_ReviewCL = "Hausnummer";
    public static String HouseSup_Title_CL = "Hausnr.-Zusatz";
    public static String PostCode_Title_CL = "PLZ *";
    public static String PostCode_Title_ReviewCL = "PLZ";
    public static String City_Title_CL = "Ort *";
    public static String City_Title_ReviewCL = "Ort";
    public static String Required_Text_CL = "Pflichtfeld";
    public static String ConfirmFStp_Btn_CL = "Weiter";
    public static String FuzzyLogicMSG_Title_CL = "Fast geschafft";
    public static String FuzzyLogicMSG_HeaderP1_CL = "Ist";
    public static String FuzzyLogicMSG_HeaderP3_CL = "die richtige Adresse?";
    public static String FuzzyLogicMSG_Text1_CL = "Korrigier bitte Deine Adresse. Oder wähl eine Adresse aus den Vorschlägen unten.";
    public static String FuzzyLogicMSG_Text2_CL = "";
    public static String FuzzyLogicMSG_Btn_CL = "Adresse korrigieren";
    public static String SuggestedAdd_Header_CL = "Ist eine von diesen Adressen richtig? Dann klick einfach drauf.";
    public static String SCndStep_Title_CL = "Daten überprüfen";
    public static String SCndStep_Header_Text_CL = "Überprüf bitte nochmal alles, bevor Du die neue Adresse speicherst.";
    public static String Salutation_Title_CL = "Anrede";
    public static String ConfirmSTP2_Btn_CL = "Speichern";
    public static String Success_Msg_CL = "Wir haben Deine Adresse geändert.";
    public static String InfoMsg_Title_CL = "Gut zu wissen";
    public static String InfoMsg_Text_CL = "Hast Du noch einen Mobil- oder DSL-Vertrag? Dann ändere Deine Adressdaten bitte auch für diesen Vertrag.";
    public static String ReviewAcc_Title_CL = "Übersicht";
    public static String ReviewAccHeader_Text_CL = "Deine neue Adresse:";
    public static String MultiSuccessMsg_Title_CL = "Addresse gespeichert";
    public static String MultiSuccessMsg_Text_CL1 = "Von dieser Bankverbindung buchen wir in Zukunft den Rechnungsbetrag für die ausgewählten Produkte ab.";
    public static String MultiSuccessMsg_Text_CL2 = "Wichtig: Wenn Du auch einen DSL-, Festnetz- oder Mobilfunk-Vertrag bei uns hast, ändere Deine Bankverbindung bitte auch dort. Das geschieht nicht automatisch.";

    //constructor
    public EditBillingAddress(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public EditBillingAddress EditFirstBillingDetails(){
        driver.element().click( EditFirstDebitBilling_btn);
        return this;
    }

    public EditBillingAddress EditSecondBillingDetails(){
        driver.element().click(  EditSecondDebitBilling_btn);
        return this;
    }

    public EditBillingAddress clickChangeAllAddressBtn(){
        driver.element().click(  changeAllAddressBtn);
        return this;
    }

    public EditBillingAddress ValidateInvoiceChooserPage() {
        driver.verifyThat().element(EditBillingAcc_Title).exists().perform();
        driver.verifyThat()
                .element(  EditBillingPage_Title)
                .textTrimmed()
                .isEqualTo( EditBillingPage_Title_CL)
                .withCustomReportMessage("Check that Page Title is correct")
                .perform();

         driver.verifyThat()
                .element(  ChooseInvAcc_Header)
                .textTrimmed()
                .isEqualTo( ChooseInvAcc_Header_CL)
                .withCustomReportMessage("Check that ChooseInvAcc_Header Text is correct")
                .perform();

         driver.verifyThat()
                .element(  ChooseInvAcc_Title)
                .textTrimmed()
                .isEqualTo( ChooseInvAcc_Title_CL)
                .withCustomReportMessage("Check that ChooseInvAcc_Title Title is correct")
                .perform();

         driver.verifyThat().element(  FInv_OwnerSal)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerSal is exist")
                .perform();

         driver.verifyThat().element(  FInv_OwnerFName)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerFName is exist")
                .perform();

         driver.verifyThat().element(  FInv_OwnerLName)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerLName is exist")
                .perform();
         driver.verifyThat().element(  FInv_OwnerStreet)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerStreet is exist")
                .perform();
         driver.verifyThat().element(  FInv_OwnerHouseNum)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerHouseNum is exist")
                .perform();
         driver.verifyThat().element(  FInv_OwnerPostCode)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerPostCode is exist")
                .perform();

         driver.verifyThat().element(  FInv_OwnerCity)
                .exists()
                .withCustomReportMessage("Check that FInv_OwnerCity is exist")
                .perform();

         driver.assertThat()
                .element(  FirstInvoiceProdSection_Title)
                .textTrimmed()
                .isEqualTo( InvoiceProdSection_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();

         driver.verifyThat().element(  FirstInvoice_Number)
                .exists()
                .withCustomReportMessage("Check that FirstInvoice_Number is exist")
                .perform();

         driver.verifyThat().element(  FirstInvoiceProduct_Name)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceProduct_Name is exist")
                .perform();

         driver.assertThat()
                .element(  EditAddFirstInvoice_btn)
                .textTrimmed()
                .isEqualTo( EditBillingInvoice_btn_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();

         driver.verifyThat().element(  LInv_OwnerSal)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerSal is exist")
                .perform();

         driver.verifyThat().element(  LInv_OwnerFName)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerFName is exist")
                .perform();

         driver.verifyThat().element(  LInv_OwnerLName)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerLName is exist")
                .perform();
         driver.verifyThat().element(  LInv_OwnerStreet)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerStreet is exist")
                .perform();
         driver.verifyThat().element(  LInv_OwnerHouseNum)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerHouseNum is exist")
                .perform();
         driver.verifyThat().element(  LInv_OwnerPostCode)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerPostCode is exist")
                .perform();

         driver.verifyThat().element(  LInv_OwnerCity)
                .exists()
                .withCustomReportMessage("Check that LInv_OwnerCity is exist")
                .perform();

         driver.verifyThat()
                .element(  SecondInvoiceProdSection_Title)
                .textTrimmed()
                .isEqualTo( InvoiceProdSection_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();

         driver.verifyThat().element(  SecondInvoice_Number)
                .exists()
                .withCustomReportMessage("Check that SecondInvoice_Number is exist")
                .perform();

         driver.verifyThat().element(  SecondInvoiceProduct_Name)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceProduct_Name is exist")
                .perform();

         driver.verifyThat()
                .element(  EditAddSecondInvoice_btn)
                .textTrimmed()
                .isEqualTo( EditBillingInvoice_btn_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        return this;
    }
    public EditBillingAddress ValidateFirstStepEditBillingAddress() {
        driver.verifyThat().element(EditBillingAcc_Title).exists().perform();
        driver.verifyThat()
                .element(  EditBillingPage_Title)
                .textTrimmed()
                .isEqualTo( EditBillingPage_Title_CL)
                .withCustomReportMessage("Check that Page Title is correct")
                .perform();

        driver.verifyThat()
                .element(  EditBillingAcc_Title)
                .textTrimmed()
                .isEqualTo( EditBillingAcc_Title_CL)
                .withCustomReportMessage("Check that EditBillingAcc_Title Text is correct")
                .perform();

        driver.verifyThat()
                .element(  EditBillingWarningMsg_Title)
                .textTrimmed()
                .isEqualTo( EditBillingWarningMsg_Title_CL)
                .withCustomReportMessage("Check that EditBillingWarningMsg_Title is correct")
                .perform();

        driver.verifyThat()
                .element(  EditBillingWarningMsg_Body)
                .textTrimmed()
                .isEqualTo( EditBillingWarningMsg_Body_CL)
                .withCustomReportMessage("Check that EditBillingWarningMsg_Body is correct")
                .perform();

        driver.verifyThat()
                .element(  EditBillingHeader_Text)
                .textTrimmed()
                .isEqualTo( EditBillingHeader_Text_CL)
                .withCustomReportMessage("Check that EditBillingHeader_Text is correct")
                .perform();

        driver.verifyThat()
                .element(  CustomerTitle_Title)
                .textTrimmed()
                .isEqualTo( CustomerTitle_Title_CL)
                .withCustomReportMessage("Check that CustomerTitle_Title is correct")
                .perform();
        driver.verifyThat().element(  CustomerTitle_Entry)
                .exists()
                .withCustomReportMessage("Check that CustomerTitle_Entry is exist")
                .perform();
        driver.verifyThat().element(  CustomerTitle_FirstOpt)
                .exists()
                .withCustomReportMessage("Check that CustomerTitle_FirstOpt is exist")
                .perform();
        driver.verifyThat()
                .element(  FName_Title)
                .textTrimmed()
                .isEqualTo( FName_Title_CL)
                .withCustomReportMessage("Check that FName_Title CL is correct")
                .perform();
        driver.verifyThat().element(  FName_Entry)
                .exists()
                .withCustomReportMessage("Check that FName_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  LName_Title)
                .textTrimmed()
                .isEqualTo( LName_Title_CL)
                .withCustomReportMessage("Check that LName_Title_CL CL is correct")
                .perform();
        driver.verifyThat().element(  LName_Entry)
                .exists()
                .withCustomReportMessage("Check that LName_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  StreetName_Title)
                .textTrimmed()
                .isEqualTo( StreetName_Title_CL)
                .withCustomReportMessage("Check that StreetName_Title_CL CL is correct")
                .perform();
        driver.verifyThat().element(  StreetName_Entry)
                .exists()
                .withCustomReportMessage("Check that StreetName_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  HouseNum_Title)
                .textTrimmed()
                .isEqualTo( HouseNum_Title_CL)
                .withCustomReportMessage("Check that HouseNum_Title_CL CL is correct")
                .perform();
        driver.verifyThat().element(  HouseNum_Entry)
                .exists()
                .withCustomReportMessage("Check that HouseNum_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  HouseSup_Title)
                .textTrimmed()
                .isEqualTo( HouseSup_Title_CL)
                .withCustomReportMessage("Check that HouseSup_Title CL is correct")
                .perform();
        driver.verifyThat().element(  HouseSup_Entry)
                .exists()
                .withCustomReportMessage("Check that HouseSup_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  PostCode_Title)
                .textTrimmed()
                .isEqualTo( PostCode_Title_CL)
                .withCustomReportMessage("Check that PostCode_Title CL is correct")
                .perform();
        driver.verifyThat().element(  PostCode_Entry)
                .exists()
                .withCustomReportMessage("Check that PostCode_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  City_Title)
                .textTrimmed()
                .isEqualTo( City_Title_CL)
                .withCustomReportMessage("Check that City_Title CL is correct")
                .perform();
        driver.verifyThat().element(  City_Entry)
                .exists()
                .withCustomReportMessage("Check that City_Entry is exist")
                .perform();
        driver.verifyThat()
                .element(  Required_Text)
                .textTrimmed()
                .isEqualTo( Required_Text_CL)
                .withCustomReportMessage("Check that Required_Text CL is correct")
                .perform();
        driver.verifyThat()
                .element(  ConfirmFStp_Btn)
                .textTrimmed()
                .isEqualTo( ConfirmFStp_Btn_CL)
                .withCustomReportMessage("Check that ConfirmFStp_Btn CL is correct")
                .perform();
        return this;
    }

    public EditBillingAddress changeBillingAddressInfo(){
        driver.getDriver().findElement(houseNoTxtBox).clear();
        driver.element().type( houseNoTxtBox,"1");
        return this;
    }

    public EditBillingAddress fillBillingAddressInfo(){
        driver.element().click(  herrSalutation);
        driver.element().type( FName_Entry,"Abdelrahman");
        driver.element().type( LName_Entry,"Wael");
        driver.element().type( StreetName_Entry,"Kirchstraße");
        driver.element().type( HouseNum_Entry,"1");
        driver.element().type( PostCode_Entry,"65689");
        driver.element().type( City_Entry,"Hadamar");
        return this;
    }

    public EditBillingAddress ValidateFuzzyLogicWithoutSuggestedAddress() {
        driver.verifyThat()
                .element(  FuzzyLogicMSG_Title)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_Title_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_Title is correct")
                .perform();

        driver.verifyThat()
                .element(  FuzzyLogicMSG_HeaderP1)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_HeaderP1_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP1 Text is correct")
                .perform();
        driver.verifyThat().element(  FuzzyLogicMSG_HeaderP2)
                .exists()
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP2 is exist")
                .perform();
        driver.verifyThat()
                .element(  FuzzyLogicMSG_HeaderP3)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_HeaderP3_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP3 CL is correct")
                .perform();

        driver.verifyThat()
                .element(  FuzzyLogicMSG_Text1)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_Text1_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_Text1 CL is correct")
                .perform();

        driver.verifyThat().element(  FuzzyLogicMSG_Icon)
                .exists()
                .withCustomReportMessage("Check that FuzzyLogicMSG_Icon is exist")
                .perform();

        driver.verifyThat()
                .element(  FuzzyLogicMSG_Btn)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_Btn_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_Btn CL is correct")
                .perform();

        driver.verifyThat().element(  SuggestedAdd_Tile)
                .doesNotExist()
                .withCustomReportMessage("Check that SuggestedAdd_Title is not exist")
                .perform();
        return this;
    }

    public EditBillingAddress ValidateFuzzyLogicWithSuggestedAddress() {
        driver.verifyThat()
                .element(  FuzzyLogicMSG_Title)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_Title_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_Title is correct")
                .perform();

        driver.verifyThat()
                .element(  FuzzyLogicMSG_HeaderP1)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_HeaderP1_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP1 Text is correct")
                .perform();
        driver.verifyThat().element(  FuzzyLogicMSG_HeaderP2)
                .exists()
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP2 is exist")
                .perform();
        driver.verifyThat()
                .element(  FuzzyLogicMSG_HeaderP3)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_HeaderP3_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_HeaderP3 CL is correct")
                .perform();

        driver.verifyThat().element(  FuzzyLogicMSG_Icon)
                .exists()
                .withCustomReportMessage("Check that FuzzyLogicMSG_Icon is exist")
                .perform();

        driver.verifyThat()
                .element(  FuzzyLogicMSG_Btn)
                .textTrimmed()
                .isEqualTo( FuzzyLogicMSG_Btn_CL)
                .withCustomReportMessage("Check that FuzzyLogicMSG_Btn CL is correct")
                .perform();

        driver.verifyThat()
                .element(  SuggestedAdd_Header)
                .textTrimmed()
                .isEqualTo( SuggestedAdd_Header_CL)
                .withCustomReportMessage("Check that SuggestedAdd_Header is correct")
                .perform();
        driver.verifyThat().element(  SuggestedAdd_Tile)
                .exists()
                .withCustomReportMessage("Check that SuggestedAdd_Title is exist")
                .perform();
        return this;
    }

    public EditBillingAddress chooseSuggestedAddress(){
         driver.element().click(  firstSuggestedAddress);
        return this;
    }

    public EditBillingAddress ValidateDetailsReview() {
        driver.verifyThat()
                .element(  Salutation_Title)
                .textTrimmed()
                .isEqualTo( Salutation_Title_CL)
                .withCustomReportMessage("Check that Salutation_Title CL is correct")
                .perform();
        driver.verifyThat().element(  Salutation_Content)
                .exists()
                .withCustomReportMessage("Check that Salutation_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  NM_Title)
                .textTrimmed()
                .isEqualTo( CustomerTitle_Review_CL)
                .withCustomReportMessage("Check that CustomerTitle_Title_CL CL is correct")
                .perform();
        driver.verifyThat().element(  NM_Content)
                .exists()
                .withCustomReportMessage("Check that NM_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  FN_Title)
                .textTrimmed()
                .isEqualTo( FName_Title_ReviewCL)
                .withCustomReportMessage("Check that First Name CL is correct")
                .perform();
        driver.verifyThat().element(  FN_Content)
                .exists()
                .withCustomReportMessage("Check that FN_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  LN_Title)
                .textTrimmed()
                .isEqualTo( LName_Title_ReviewCL)
                .withCustomReportMessage("Check that LName_Title CL is correct")
                .perform();
        driver.verifyThat().element(  LN_Content)
                .exists()
                .withCustomReportMessage("Check that LN_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  STr_Title)
                .textTrimmed()
                .isEqualTo( StreetName_Title_ReviewCL)
                .withCustomReportMessage("Check that StreetName_Title CL is correct")
                .perform();
        driver.verifyThat().element(  STr_Content)
                .exists()
                .withCustomReportMessage("Check that STr_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  HNum_Title)
                .textTrimmed()
                .isEqualTo( HouseNum_Title_ReviewCL)
                .withCustomReportMessage("Check that HNum_Title CL is correct")
                .perform();
        driver.verifyThat().element(  HNum_Content)
                .exists()
                .withCustomReportMessage("Check that HNum_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  HSup_Title)
                .textTrimmed()
                .isEqualTo( City_Title_ReviewCL)
                .withCustomReportMessage("Check that HSup_Title CL is correct")
                .perform();
        driver.verifyThat().element(  HSup_Content)
                .exists()
                .withCustomReportMessage("Check that HSup_Content is exist")
                .perform();

        driver.verifyThat()
                .element(  PLZ_Title)
                .textTrimmed()
                .isEqualTo( PostCode_Title_ReviewCL)
                .withCustomReportMessage("Check that PLZ_Title CL is correct")
                .perform();
        driver.verifyThat().element(  PLZ_Content)
                .exists()
                .withCustomReportMessage("Check that PLZ_Content is exist")
                .perform();
        return this;
    }

    public EditBillingAddress clickProceedBtnFirstStep(){
         driver.element().click(  ConfirmFStp_Btn);
        return this;
    }

    public EditBillingAddress ValidateSecondStepEditBillingAddress() {
        driver.verifyThat()
                .element(  SCndStep_Title)
                .textTrimmed()
                .isEqualTo( SCndStep_Title_CL)
                .withCustomReportMessage("Check that SCndStep_Title CL is correct")
                .perform();

        driver.verifyThat().element(  SCndStep_Number)
                .exists()
                .withCustomReportMessage("Check that SCndStep_Number is exist")
                .perform();

        driver.verifyThat()
                .element(  SCndStep_Header_Text)
                .textTrimmed()
                .isEqualTo( SCndStep_Header_Text_CL)
                .withCustomReportMessage("Check that SCndStep_Header_Text CL is correct")
                .perform();

        ValidateDetailsReview();

        driver.verifyThat()
                .element(  ConfirmSTP2_Btn)
                .textTrimmed()
                .isEqualTo( ConfirmSTP2_Btn_CL)
                .withCustomReportMessage("Check that ConfirmSTP2_Btn CL is correct")
                .perform();
        return this;
    }

    public EditBillingAddress clickProceedBtnSecondStep(){
         driver.element().click(ConfirmSStp_Btn);
        return this;
    }

    public EditBillingAddress ValidateLastStepEditBillingAddressSingle() {
        driver.verifyThat()
                .element(  Success_Msg)
                .textTrimmed()
                .isEqualTo( Success_Msg_CL)
                .withCustomReportMessage("Check that Success_Msg CL is correct")
                .perform();

        driver.verifyThat().element(  Success_Icon)
                .exists()
                .withCustomReportMessage("Check that Success_Icon is exist")
                .perform();

        driver.verifyThat()
                .element(  InfoMsg_Title)
                .textTrimmed()
                .isEqualTo( InfoMsg_Title_CL)
                .withCustomReportMessage("Check that InfoMsg_Title CL is correct")
                .perform();

        driver.verifyThat()
                .element(  InfoMsg_Text)
                .textTrimmed()
                .isEqualTo( InfoMsg_Text_CL)
                .withCustomReportMessage("Check that InfoMsg_Text CL is correct")
                .perform();

        driver.verifyThat()
                .element(ReviewAcc_Title)
                .textTrimmed()
                .isEqualTo( ReviewAcc_Title_CL)
                .withCustomReportMessage("Check that ReviewAcc_Title CL is correct")
                .perform();
        return this;
    }

    public EditBillingAddress ValidateLastStepEditBillingAddressMulti() {
        driver.verifyThat()
                .element(MultiSuccessMsg_Title)
                .textTrimmed()
                .isEqualTo( MultiSuccessMsg_Title_CL)
                .withCustomReportMessage("Check that MultiSuccessMsg_Title CL is correct")
                .perform();

        driver.verifyThat()
                .element(MultiSuccessMsg_Text)
                .textTrimmed()
                .contains(MultiSuccessMsg_Text_CL1)
                .withCustomReportMessage("Check that MultiSuccessMsg_Text CL1 is correct")
                .perform();
        driver.verifyThat()
                .element(MultiSuccessMsg_Text)
                .textTrimmed()
                .contains(MultiSuccessMsg_Text_CL2)
                .withCustomReportMessage("Check that MultiSuccessMsg_Text CL2 is correct")
                .perform();

        driver.verifyThat().element(MultiSuccessMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that MultiSuccessMsg_Icon is exist")
                .perform();

        driver.verifyThat()
                .element(  ReviewAcc_Title)
                .textTrimmed()
                .isEqualTo( ReviewAcc_Title_CL)
                .withCustomReportMessage("Check that ReviewAcc_Title CL is correct")
                .perform();

        driver.verifyThat()
                .element(  ReviewAccHeader_Text)
                .textTrimmed()
                .isEqualTo( ReviewAccHeader_Text_CL)
                .withCustomReportMessage("Check that ReviewAccHeader_Text CL is correct")
                .perform();
        return this;
    }

    public EditBillingAddress ValidateNoBillingAddressCase(){
        driver.verifyThat()
                .element(  NoBillingAddress_Title)
                .textTrimmed()
                .isEqualTo( NoBillingAddress_Title_CL)
                .withCustomReportMessage("Check that NoBillingAddress_Title_CL CL is correct")
                .perform();

        driver.verifyThat()
                .element(  NoBillingAddress_content)
                .textTrimmed()
                .isEqualTo( NoBillingAddress_content_CL)
                .withCustomReportMessage("Check that NoBillingAddress_content_CL CL is correct")
                .perform();

        driver.verifyThat()
                .element(  NoBillingAddress_Num)
                .textTrimmed()
                .isEqualTo( NoBillingAddress_Num_CL)
                .withCustomReportMessage("Check that NoBillingAddress_Num CL is correct")
                .perform();

        driver.verifyThat().element(  NoBillingAddress_Icon)
                .exists()
                .withCustomReportMessage("Check that NoBillingAddress_Icon is exist")
                .perform();

        driver.verifyThat().element(  NoBillingAddress_Icon)
                .exists()
                .withCustomReportMessage("Check that NoBillingAddress_Icon is exist")
                .perform();
        return this;
    }

}
