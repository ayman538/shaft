package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Dashboard{

    // Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String suspendedMsgTitleCL = "Dein Kundenkonto ist gesperrt wegen Zahlungsrückstand";
    public static String suspendedMsgTextCL = "Du kannst Dein MeinVodafone-Konto zurzeit nur eingeschränkt nutzen und keine Änderungen vornehmen.";
    public static String meineRechnungenTile_TitleCL = "Meine Rechnungen";
    public static String aktuelleRechnungTile_TitleCL = "Aktuelle Rechnung";
    public static String meineProdukteCL = "Meine Produkte";
    private static String smartcardAktivierenTitle_CL = "Smartcard aktivieren";
    private static String smartcardAktivierenSOFooter_CL = "Smartcard selbst aktivieren und Sender freischalten";

    //Locators
    public static By loginIndicator = By.xpath("//*[@class='dashHeader']//h1");
    private By internetAndPhone_accordion = By.xpath("//span[@class='mbo-name' and contains(text(),'Internet & Phone')]");
    private By TV_Accordion = By.xpath("//span[@class='mbo-name' and contains(text(),'TV-Produkte')]");
    private By meinRechnungenPageBtn = By.xpath("//div[@class='tiles tiles-lrg cf']//a[contains(.,'Meine Rechnungen')]");
    private By kostenkontrollePageBtn = By.xpath("//div[@automation-id='video_so']");
    public static By einstellungen_SmartObject = By.xpath("//*[@id='content']//section//div[2]//ul/li[1]/div[2]/ute-sushibar//div[5]");
    public static By menu_item_bubble = By.xpath("//*[@class='menu-md notifications-alert']");
    public static By meine_Dokumente_option = By.xpath("(//*[@class='dashboard-menu-link bold'])[5]");
    public static By download_item_button = By.xpath("(//*[@automation-id='documentsInboxes_download_btn'])[1]");
    public static By internet_Phone_Burger_Menu = By.xpath("(//*[@class='expert-mode'])[1]");
    public static By gerate_option = By.xpath("(//*[@class='option-name'])[2]");
    public static By gerate_SO = By.xpath("(//*[@class='sb-block-inner'])[1]");
    public static By html_Btn = By.xpath("(//*[@class='btn btn-alt'])[2]");

    public static By meineDaten_Tile =By.xpath("//a[@automation-id='Meine Daten_btn']");
    public static By meineKundendaten_Tile =By.xpath("//a[@automation-id='Meine Kundendaten_btn']");

    public static By meineRechnungenTile_Title =By.xpath("//*[@automation-id='Meine Rechnungen_btn']//div[2]");
    public static By aktuelleRechnungTile_Title =By.xpath("//*[@automation-id='invoiceTileHeadline_tv']");
    public static By suspendedMsgTitle =By.xpath("//*[@automation-id='suspended_nt']/div/div/h4");
    public static By suspendedMsgText =By.xpath("//*[@automation-id='suspended_nt']/div/div/p");
    public static By meineProdukte =By.xpath("//*[@class='title' and contains(text(),'Meine Produkte')]");
    public static By kabelTVAcc =By.xpath("//*[@class='mbo-name' and contains(text(),'Kabel-TV')]");
    public static By kabelTV_SmartcardaktivierenSO =By.xpath("//*[@automation-id='smartCard_so']");
    public static By internetandPhoneBurgerMenu =By.xpath("//*[@class='i-sml-reports dots']");
    private static By internetandPhone_GeräteandEinstellungen =By.xpath("//*[@automation-id='sushi-bar-menu_lv']/li[2]");
    private static final By smartcardAktivierenSOTitle = By.xpath("//*[@automation-id='smartCard_so']//h3");
    private static final By smartcardAktivierenSOFooter = By.xpath("//*[@id='smartCard']//div[2]/div[2]");


    /*KAY_USER_109919273_Contract*/
    public static final By kay_USER_109919273 = By.xpath("(//*[@class='contract-info'])[3]");
    public static final By brgrMenu_01622137497_KAY =By.xpath("(//*[@class='expert-mode dots-menu'])[10]");
    public static final By sim_KarteAndEinstellungen =By.xpath("(//*[@class='menu-item'])[39]");


    /*PAUL_USER_337452562_Contract*/
    public static final By paul_USER_337452562 = By.xpath("(//*[@class='contract-info'])[24]");
    public static final By brgrMenu_015201587421_PAUL =By.xpath("(//*[@class='expert-mode dots-menu'])[35]");
    public static final By sim_KarteAndEinstellungen_015201587421 =By.xpath("(//*[@class='menu-item'])[139]");

    /*Kay_User_109919277_Contract*/
    public static final By kay_USER_109919277 = By.xpath("(//*[@class='contract-info'])[2]");
    public static final By meineDaten_109919277 =By.xpath("(//*[@class='btn btn-alt eqHeight'])[4]");

   /*Basis_Vertrag_108307218_contract*/
    public static final By basis_Vertrag_108307218 = By.xpath("(//*[@id='dashboard:mobile'])[2]");
    public static final By burgerMenu_015200488850 = By.xpath("(//*[@class='i-sml-reports dots'])[6]");
    public static final By sim_Karte_015200488850 = By.xpath("(//*[@class='option-name'])[23]");
    /*Ute_contract_341449201*/
    public static final By ute_contract_341449201 = By.xpath("(//*[@automation_id='dashboard:unitymedia_acc'])[1]");
    public static final By meineDaten_341449201 = By.xpath("//*[@automation-id='Meine Daten_btn']");
    /*Paul_contract_337452559*/
    public static final By paul_337452559 = By.xpath("(//*[@id='dashboard:mobile'])[18]");
    public static final By burgerMenu_01721486504 = By.xpath("(//*[@class='i-sml-reports dots'])[32]");
    private static final By tarif_015201639667 = By.xpath("(//a[@class='menu-item'])[134]");
    private static final By meineTarifAcc = By.xpath("//*[@automation-id='mein-tarif_acc']");
    private static final By changeTariff = By.xpath("//div[@automation-id='option_2_rb']");


    /*Paul_contract_336471968*/
    private static final By paul_336471968 = By.xpath("(//*[@id='dashboard:mobile'])[21]");
    private static final By burgerMenu_015201639667 = By.xpath("(//*[@class='i-sml-reports dots'])[34]");
    public static final By sim_KarteAndEinstellungen_015201639667 = By.xpath("(//*[@class='option-name'])[135]");

    public static final By burgerMenu_015201536244 =  By.xpath("(//*[@class='i-sml-reports dots'])[1]");
    public static final By sim_KarteAndEinstellungen_015201536244 = By.xpath("(//*[@class='option-name'])[3]");

    /*Dashboard email notification messages ignoring*/

    //public static final By bewOverlayAcceptDashboard = By.xpath("//div[@class='overlay-content']//a[@class='btn' and contains(text(),'Ja')]");
    public static final By bewOverlayIgnoreDashboard = By.xpath("//div[@class='overlay-content']//a[@class='btn btn-alt' and contains(text(),'Weiter')]");
    public static final By email_MSG_Container = By.xpath("(//*[@class='notification-message-container'])[1]");
    public static final By bank_MSG_Container = By.xpath("(//*[@class='notification-message-container bottom-bar'])");
    public static final By bank_Msg_Close_BTN = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])[1]");

    public static final By email_Msg_Close_BTN = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])[1]");
    public static final By redPlus_Msg_Container = By.xpath("(//*[@class='notification-message-container'])[1]");
    public static final By redPlus_Msg_Close_BTN = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])[1]");

    private By meinTariffSO = By.xpath("//div[@automation-id='ipTariffSO_so']");
    private By STContactEmailNotification = By.xpath("//div[@class='noselect notification-message-item warning clickable-notification']");
    private By STContactEmailCloseNotification = By.xpath("(//div[@class='notification-title']//div[@class='notification-message-right']//*[name()='svg'])[2]");
    private By CertainKayUser = By.xpath("//*[@accordion-id='dashboard:mobile' and contains(.,'Mobilfunk-Vertrag')]");
    private By MeintarifSO = By.xpath("//*[@automation-id='_so' and contains(.,'Mein Tarif')]");

    /*WFCT-13741*/
    private static By meineRechnungTileLocator = By.xpath("//div[@class=\"subTitle\"][contains(.,\"Vergleichen und herunterladen\")]");


    //constructor
    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    public void downloadFilePDF (){
        driver.element().click(menu_item_bubble);
        driver.element().click( meine_Dokumente_option);
        driver.element().click(download_item_button);
    }

    public void downloadFileHTML (){
        driver.element().click( internet_Phone_Burger_Menu);
        driver.element().click( gerate_option);
        driver.element().click( gerate_SO);
        driver.element().click( html_Btn);
    }

    public void isBEWOverlayfound(){
        driver.element().getElementsCount(bewOverlayIgnoreDashboard);
        if (driver.element().getElementsCount(bewOverlayIgnoreDashboard)!=0)
        {
            driver.element().click( bewOverlayIgnoreDashboard);
        }
        else
        {
            Assert.assertTrue(true,"Element not clicked as it didn't appear");
        }
    }

    public void IsEmailMsgFound(){
        if (driver.element().getElementsCount(email_MSG_Container)!=0)
        {
            driver.element().click( email_Msg_Close_BTN);
        }

    }

    public void IsRedPlusMsgFound(){
        if (driver.element().getElementsCount(redPlus_Msg_Container)!=0)
        {
            driver.element().click( redPlus_Msg_Close_BTN);
        }

    }

    public void ReloadCurrentPage() {
        driver.browser().refreshCurrentPage(); JavaScriptWaitManager.waitForLazyLoading();}

    public void GoToPreviousPage() {driver.browser().navigateBack();}

    public void GoToForwardPage() {driver.browser().navigateForward();}

    public void ignoreDashboardNotifications() {
       // new Dashboard(driver.getDriver()).isBEWOverlayfound();
        new Dashboard(driver).IsEmailMsgFound();
        new Dashboard(driver).IsRedPlusMsgFound();
        new Dashboard(driver).clickOnignoreNotfMsg();
    }

    public void clickOnignoreNotfMsg(){
        //driver.element().waitToBeReady(email_MSG_Container);
        if (driver.element().getElementsCount(bank_MSG_Container)!=0)
        {
            driver.element().click( bank_Msg_Close_BTN);
        }
    }

    public Dashboard openAccordion(DashboardInternetandPhoneAccordion accordion) {
        switch (accordion) {
            case INTERNETANDPHONE -> driver.element().click( internetAndPhone_accordion);
        }
        return this;
    }

    public Dashboard openAccordion (DashboardKabelTVAccordion accordion) {
        switch (accordion) {
            case DASHBOARD_KABEL_TV_ACCORDION -> driver.element().click( kabelTVAcc);
        }
        return this;
    }

    public InternetAndPhone openSmartObject(DashboardInternetAndPhoneSmartObject card) {
        switch (card) {
            case EINSTELLUNGEN -> {
                driver.element().click( einstellungen_SmartObject);
            }
        }
        return new InternetAndPhone(driver);
    }

    public KabelTV openSmartObject (DashboardKabelTVSmartObject card) {
        switch (card) {
            case CardAktivieren -> {
                driver.element().click( kabelTV_SmartcardaktivierenSO);
            }
        }
        return new KabelTV(driver);
    }

    @Step("Open TV Accordion")
    public Dashboard openTVAcc(){
        driver.element().click(TV_Accordion);
        return this;
    }

    @Step("Open KIP Accordion")
    public Dashboard openKIPAcc() {
        driver.element().click(internetAndPhone_accordion);
        return this;
    }

    public void validateSmartCardActivationSO(){
        Validations.assertThat().element(driver.getDriver(),Dashboard.smartcardAktivierenSOTitle)
                .text().isEqualTo(Dashboard.smartcardAktivierenTitle_CL)
                .withCustomReportMessage("Validate SmartCard Activation's title ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Dashboard.smartcardAktivierenSOFooter)
                .text().isEqualTo(Dashboard.smartcardAktivierenSOFooter_CL)
                .withCustomReportMessage("Validate SmartCard Activation's Footer ")
                .perform();
    }

    @Step("Click on SO in Dashboard to Open It")
    public Dashboard clickMienTariffSO(){
        driver.element().click(meinTariffSO);
        return this;
    }

    public MeineDaten openMeineKundenDatenTile(
            de.vodafone.pages.Kabledeutschland.Dashboard.DashboardSmartObject card) {

        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().click(meineDaten_Tile);
            }
        }
        return new MeineDaten(driver);
    }

    public void openMeineKundenDatenTile(DashboardInternetAndPhoneSmartObject meineDaten_Tile) {
    }

//Kay_User_Contract
    public void clickOnKAY_User_109919273() {driver.element().click( kay_USER_109919273);}
    public void clickOnBrgrMenuMobilfunk_01622137497() {driver.element().click( brgrMenu_01622137497_KAY);}
    public void clickOnSIM_KarteAndEinstellungen() {driver.element().click( sim_KarteAndEinstellungen);}

    //Paul_User_Contract
    public void clickOnPaul_User_109919273() {driver.element().click( paul_USER_337452562);}
    public void clickOnBrgrMenuMobilfunk_015201587421() {driver.element().click( brgrMenu_015201587421_PAUL);}
    public void clickOnSIM_KarteAndEinstellungen_015201587421() {driver.element().click( sim_KarteAndEinstellungen_015201587421);}
    public void clickOn_KayBurgerMenu() {
        driver.element().click( burgerMenu_015201536244);
    }
    public void clickOnKAY_User_109919277() {
        driver.element().click( kay_USER_109919277);}
    public void clickOnMeineDaten_109919277() {
        driver.element().click( meineDaten_109919277);}
    public void expandKaywithAvaliableSlots() {
        driver.element().click( basis_Vertrag_108307218);
    }
    public void clickOnPaul_337452559(){
        driver.element().click( paul_337452559);
    }
    public void clickOnBurgerMenu_01721486504()
    {
        driver.element().click( burgerMenu_01721486504);
    }
    public void clickOnTarif_option()
    {
        driver.element().click( tarif_015201639667);
    }
    public void clickOnMeineTarifAcc()
    {
        driver.element().click( meineTarifAcc
        );
    }
    public void clickOnChangeTariff()
    {
        driver.element().click( changeTariff
        );
    }

    public void expandPaulContract() {
        driver.element().click( paul_336471968);
    }
    public void clickOnPaulBurgerMenu() {
        driver.element().click( burgerMenu_015201639667);
    }

    public void clickOnBurgerMenu_AvailableSlots() {
        driver.element().click( burgerMenu_015200488850);
    }
    public void clickOnSIMKarte_AvailableSlots() {
        driver.element().click( sim_Karte_015200488850);
    }
    public void clickOnSIMKarte_Option() {
        driver.element().click( sim_KarteAndEinstellungen_015201639667);

    }
    public void clickOnSIMKarte_KayUser() {
        driver.element().click( sim_KarteAndEinstellungen_015201536244);

    }

    public void clickOnUte_contract_341449201() {
        driver.element().click( ute_contract_341449201);
    }
    public void clickOnMeineDaten_341449201() {
        driver.element().click( meineDaten_341449201);
    }

    //enums
    public enum DashboardInternetandPhoneAccordion {
        INTERNETANDPHONE;
        }

        public enum DashboardKabelTVAccordion {
            DASHBOARD_KABEL_TV_ACCORDION
    }


    public enum DashboardInternetAndPhoneSmartObject {
        EINSTELLUNGEN,
        meineDaten_Tile
    }

   public enum DashboardKabelTVSmartObject {
        CardAktivieren
    }

    public void clickOnMeineDaten(){
        driver.element().click( meineDaten_Tile);
    }
    @Step("click on meine Kundendaten tile")
    public void clickOnMenieKundendaten(){
        driver.element().click(meineKundendaten_Tile);
    }


    public void ClickOnInternetandPhoneBurgerMenu() {
        driver.element().click( internetandPhoneBurgerMenu);
    }
    public void ClickOnInternetandPhone_GeräteandEinstellungen() {
        driver.element().click( internetandPhone_GeräteandEinstellungen);
    }

    @Step("Click on meine Rechnungen tile")
    public void clickMeineRechnungenTile() {
        driver.element().click(meineRechnungTileLocator);
    }

    @Step("Validate Card Activation SO and Accordion")
    public void validateCardActivationSOandACC(){
        Validations.assertThat().element(driver.getDriver(), KabelTV.SmartcardAktivierenSOTitle)
                .text().isEqualTo(KabelTV.SmartcardAktivierenTitle_CL)
                .withCustomReportMessage("Validate SmartObject Title ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),KabelTV.SmartcardAktivierenSOFooter)
                .text().isEqualTo(KabelTV.SmartcardAktivierenSOFooter_CL)
                .withCustomReportMessage("Validate SmartObject footer ")
                .perform();

        Validations.assertThat().element(driver.getDriver(),KabelTV.SmartcardAktivierenAccText)
                .text().isEqualTo(KabelTV.SmartcardAktivierenAccText_CL)
                .withCustomReportMessage("Validate Accordion Text")
                .perform();

        Validations.assertThat().element(driver.getDriver(),KabelTV.SmartcardAktivierenHeader)
                .text().isEqualTo(KabelTV.SmartcardAktivierenHeader_CL)
                .withCustomReportMessage("Validate Accordion Header")
                .perform();

        Validations.assertThat().element(driver.getDriver(),KabelTV.SmartcardAktivierenBody)
                .text().isEqualTo(KabelTV.SmartcardAktivierenBody_CL)
                .withCustomReportMessage("Validate Accordion Body ")
                .perform();

    }
    @Step("Close contact email confirmation pop-up at the dashboard page")
    public Dashboard handleContactEmailNotification() {
        driver.element().waitToBeReady(STContactEmailNotification);
        driver.element().click( STContactEmailCloseNotification);
        return this;
    }

    //@Step("Choose certain kay user")
    public void clickCertainKaySubscription(){
        driver.element().click(CertainKayUser);
    }

    @Step("Click on Mein tariff smart object")
    public void clickMeinTariffSO(){
        driver.element().click(MeintarifSO);
    }

    @Step("Click on Mein Rechnungen page button")
    public Dashboard clickOnMeinRechnungenPageBtn(){
        driver.element().click(meinRechnungenPageBtn);
        //driver.element().click(kostenkontrolleTab);
        //driver.element().click(tvAndVideoBtn);
        return this;
    }

    @Step("Click on Kostenkontrolle page from TV Accordion")
    public Dashboard clickOnKostenkontrolleFromDashboard(){
        driver.element().click(TV_Accordion);
        driver.element().click(kostenkontrollePageBtn);
        return this;
    }
}
