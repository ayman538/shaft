package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Edit_HomezoneAddress {
    private SHAFT.GUI.WebDriver driver;
    /*Constractor*/public Edit_HomezoneAddress (SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }





    //CLs
    public static String Edit_HomeZoneAddress_page_titleCL = "Zuhause-Adresse bearbeiten";
    public static String Edit_HomeZoneAddress_page_HeaderCL = "KAY (Kundennummer: 109919277)";
    public static String FirstAccordion_TitleCL = "Adresse bearbeiten";
    public static String SecondAccordion_TitleCL = "Daten überprüfen";
    public static String Infomsg_TitleCL = "Bitte beachte ...";
    public static String EditedStreet = "FerdinandPlatz";
    public static String EditedStreet2 = "FerdinandPl";
    public static String EditedCountry ="Duseldor";
    public static String EditedCountry2 ="Duseldr";

    public static String ErrorMsg_TitleCL = "Da stimmt was nicht";
    public static String ErrorMsg_ButtonCL="Adresse korrigieren";
    public static String SuggestedAddressTitleCL="Ist eine von diesen Adressen richtig? Dann klick einfach drauf.";

    public static String ConfirmationHeaderCL ="Überprüf bitte nochmal alles, bevor Du die neue Adresse speicherst:";
    public static String ConfirmationAcc_TitleCL ="Daten überprüfen";
    public static String ConfirmationAcc_ButtonCL = "Speichern";

    //ConfirmationPageCls
    public static String ConfirmationMsgTextCL ="Deine Zuhause-Adresse wurde erfolgreich geändert.";
    public static String PageTitlCL ="Zuhause-Adresse bearbeiten";
    public static String PagesubTitlCL ="KAY (Kundennummer: 109919277)";

    public static String Back_buttonCL  = "Abbrechen";


    //Locators
    public static final By Edit_HomeZoneAddress_page_Header= By.xpath("//*[@automation-id='pageHeader_tv']//h2");
    public static final By Edit_HomeZoneAddress_page_title= By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By Infomsg_Title= By.xpath("//*[@id='stepper-component-step-0']//div[2]//div[2]/h4");
    public static final By FirstAccordion_Title= By.xpath("//*[@id='step0']/a/div[2]");
    public static final By SecondAccordion_Title= By.xpath("//*[@id='step1']/a/div[2]");

    public static final By FirstBox_Straße_Street= By.xpath("//*[@automation-id='input6_et']");
    public static final By SecondBox_Hausnummer_HouseNumber= By.xpath("//*[@automation-id='input7_et']");
    public static final By ThirddBox_PLZ_PostalCode= By.xpath("//*[@automation-id='input8_et']");
    public static final By FourthdBox_Ort_Location= By.xpath("//*[@automation-id='input9_et']");
    public static final By Fifth_Land_Country = By.xpath("//*[@automation-id='input10_et']");
    public static final By Continue_Weiter_Button = By.xpath("//*[@automation-id='submit_form_btn']");
    public static final By Back_Button = By.xpath("//*[@automation-id='back_Link']");
    public static final By EditButton= By.xpath("//*[@class='btn btn-sml btn-em']");

    public static final By SuggestedAddressBtn  = By.xpath("//*[@automation-id='address_rb']");
    public static final By SuggestedAddressTitle  = By.xpath("(//*[@id='stepper-component-step-0']//div[2]//h4)[3]");
    public static final By ErrorMsg_Button = By.xpath("(//*[@class='btn btn-alt'])[2]");
    public static final By ErrorMsg_Text  = By.xpath("(//*[@class='notification-body notification-body-margin'])");
    public static final By ErrorMsg_Title = By.xpath("(//*[@class='flexDiv'])[2]");
    public static final By ConfirmationHeader=By.xpath("//*[@class='relative']/h4)[1]");
    public static final By ConfirmationAcc_Title=By.xpath(" (//*[@id='step1']/a/div[2])");
    public static final By ConfirmationAcc_Button=By.xpath("//*[@class='btn btn-sml mb-0']");


    //ConfirmationPage Locators

    public static final By PageTitle =By.xpath("//*[@automation-id='pageHeader_tv']");
    public static final By PagesubTitle =By.xpath("//*[@class='sub-title']");

    public static final By ConfirmationMsgText=By.xpath("(//*[@class='item-2 w-100'])[1]");
    public static final By Back_button=By.xpath("//*[@automation-id='back_Link']");




    //Methods

    public void deleteStreetBox(By FirstBox_Straße_Street)
    {
        driver.getDriver().findElement(FirstBox_Straße_Street).clear();
    }
    public void EditStreetBox (String EditedAddress){
        (driver.getDriver().findElement(FirstBox_Straße_Street)).sendKeys(EditedAddress);
    }


    public void deleteCountryBox(By FourthdBox_Ort_Location)
    {
        driver.getDriver().findElement(FourthdBox_Ort_Location).clear();
    }
    public void EditCountrytBox (String EditedCountry){
        (driver.getDriver().findElement(FourthdBox_Ort_Location)).sendKeys(EditedCountry);
    }
    public void clickOnContinueButton()
    {driver.element().click( Continue_Weiter_Button);}

    public void clickOnEditAddressButton()
    {driver.element().click(ErrorMsg_Button);}

    public void clickOnSuggestedAddressButton() {driver.element().click(SuggestedAddressBtn);}

    public void clickOnEditAddressButton2() {
        driver.element().click(EditButton);
    }

    public void clickOnConfirmationAccButton() {
        driver.element().click(ConfirmationAcc_Button);
    }
}
