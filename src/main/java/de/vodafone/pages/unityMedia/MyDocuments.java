package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MyDocuments {
    //variables
    private SHAFT.GUI.WebDriver driver;
    public static String fileName ="2020-08-07_Verbindungsuebersicht_fuer_01737237423.pdf";


    //CLs
    public static String DokumentstabCL     = "Meine Dokumente";
    public static String myContractsTitleCL   = "Meine Verträge";
    public static String myContractTitleCL   = "Meine Vertrag";
    public static String contractsNameAutomatedKayCL = "Automated Kay";
    public static String contractsNameAutomatedMartinCL = "Automated Martin";
    public static String titleTextCL   = "Hier findest Du alle Dokumente für diesen Vertrag.";
    public static String documentsCount18CL = "18 Dokumente";
    public static String documentsCount20CL = "20 Dokumente";
    public static String documentsCount8CL = "8 Dokumente";
    public static String firstPageCounterCL   = "1 von 2";
    public static String firstDocumentNameCL   = "Ihre Verbindußgsübersicht";
    public static String firstDocumentDateCL   = "24.06.2020";
    public static String secondDocumentDateCL   = "";
    public static String lastPageCounterCL   = "2 von 2";
    public static String lastPageNotificationMessageCL = "Wichtig für Dich: Aus Datenschutzgründen werden Dokumente nach 13 Monaten gelöscht.";
    public static String noDocumentsMessageCL   = "Wichtig für Dich: Aus Datenschutzgründen werden Dokumente nach 24 Monaten gelöscht.";
    public static String MitteilungenTitleCL   = "Mitteilungen";


    //Locators
    public static By MitteilungenTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    public static By Dokumentstab = By.xpath("//a[@automation-id='documentsInboxes_lv']/span");
    public static By myContractsTitle = By.xpath("//label[contains(text(),' Meine Verträge')]");//div[@automation-id='document-inbox']//label
    public static By myContractTitle = By.xpath("//h3[@automation-id='contractPanelText_tv']");
    public static By contractNameMultiUser = By.xpath("//div[@class='dropdown-btn']");
    public static By contractNameSingleUser = By.xpath("//div[@automation-id='contractPanel_tv']//b");
    public static By contractNameIcon = By.xpath("//*[@class='i-sml dropdown-icon'][1]");
    public static By titleText = By.xpath("//span[@automation-id='documentsInboxes_desc_tv']");
    public static By documentsCount = By.xpath("//div[@automation-id=\"documentList_tv\"]//span");
    public static By documentName = By.xpath("(//h4[@automation-id='documentsInboxes_type_tv'])[1]");//h4[@automation-id='documentsInboxes_type_tv' and contains(text(),'Ihre Verbindußgsübersicht')]

    public static By documentDate = By.xpath("(//span[@automation-id='documentsInboxes_date_tv'])[1]");//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'24.06.2020')]
    public static By documentPreviewButton = By.xpath("(//div[@class='tooltip-hover'])[1]");//(//div[@automation-id='documentsInboxes_preview_btn' ])[1]
    public static By documentDownloadButton = By.xpath("(//button[@automation-id='documentsInboxes_download_btn' ])[1]");
    public static By firstDocumentDate = By.xpath("(//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'9.03.2022')])[6]");
    public static By secondDocumentDate = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'9.02.2022')]");
    public static By thirdDocumentDate = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'18.01.2022')]");
    public static By pageCounter = By.xpath("//li[@class='pagecounter']//p");
    public static By backButton = By.xpath("//a[@automation-id='back_Link']");
    public static By firstPageButtonInactive = By.xpath("//a[@class='btn btn-alt fm-inactive'][1]");//a[@class='btn btn-alt fm-inactive'][2]
    public static By lastPageButton = By.xpath("//a[@class='btn btn-alt'][2]");
    public static By lastPageNotificationMessage = By.xpath("//p[@class='notification-text']");
    public static By contractChooserDropdownArrow = By.xpath("//span[@id='closeSvg']");
    public static By sohoContractDropdown = By.xpath("//button[@id='anchor_child'and contains(text(),'Automated Martin2')]");//li[@id='option_child'][2]
    public static By consumerContractDropdown = By.xpath("//li[@id='option_child'][1]");
    public static By noDocumentsMessage = By.xpath("//div[@automation-id='no-documents_nt']//p");
    public static By documentContentOverlay = By.id("fram");
    public static By documentContentCloseButton = By.xpath("//button[@class='nsm-dialog-btn-close']");


    //Constructor
    public MyDocuments(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Functions
    public void clickOnBackButton(){
//        driver.element().click( backButton);
        driver.element().clickAndHold(backButton);

    }

    public void clicklastPagebutton(){

    driver.element().click(lastPageButton);
    }



    public void clickDropdowncontractsChooser(){
        driver.element().click(contractNameMultiUser);
    }

    public void clickSohoContractFromDropdown(){
        driver.element().click(sohoContractDropdown);
    }

    public void clickConsumerContractFromDropdown(){
        driver.element().click(consumerContractDropdown);
    }

    public void clickDocumentPreviewButton(){
        driver.element().click(documentPreviewButton);
    }

    public void clickDocumentContentCloseButton(){
        driver.element().click(documentContentCloseButton);
    }
    public void clickDocumentDownloadButton(){

        driver.element().click(documentDownloadButton);
    }






}
