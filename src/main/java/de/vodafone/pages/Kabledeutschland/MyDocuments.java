package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MyDocuments {
    //variables
    private SHAFT.GUI.WebDriver driver;
    public static String fileName ="2020-08-07_Verbindungsuebersicht_fuer_01737237423.pdf";


    //CLs
    private static String myContractsTitleCL   = "Meine Verträge";
    private static String titleTextCL   = "Hier findest Du alle Dokumente für diesen Vertrag.";
    private static String lastPageNotificationMessageCL1 = "Wichtig für Dich: Aus Datenschutzgründen werden";
    private static String lastPageNotificationMessageCL2 = "Dokumente nach 24 Monaten gelöscht.";
    private static String noDocumentsMessageCL1 = "Wichtig für Dich: Aus Datenschutzgründen werden";
    private static String noDocumentsMessageCL2   = "Dokumente nach 24 Monaten gelöscht.";
    private static String DokumentstabCL     = "Meine Dokumente";
    public static String MitteilungenTitleCL   = "Mitteilungen";

    //Locators
    private static By myContractsTitle = By.xpath("//label[contains(text(),' Meine Verträge')]");//div[@automation-id='document-inbox']//label
    private static By myContractTitle = By.xpath("//h3[@automation-id='contractPanelText_tv']");
    private static By contractNameMultiUser = By.xpath("//div[@class='dropdown-btn']");
    private static By titleText = By.xpath("//span[@automation-id='documentsInboxes_desc_tv']");
    private static By documentsCount = By.xpath("//div[@automation-id=\"documentList_tv\"]//span");
    private static By documentName = By.xpath("(//h4[@automation-id='documentsInboxes_type_tv'])[1]");//h4[@automation-id='documentsInboxes_type_tv' and contains(text(),'Ihre Verbindußgsübersicht')]

    public static By documentDate = By.xpath("(//span[@automation-id='documentsInboxes_date_tv'])[1]");//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'24.06.2020')]
    private static By documentPreviewButton = By.xpath("(//div[@class='tooltip-hover'])[1]");//(//div[@automation-id='documentsInboxes_preview_btn' ])[1]
    private static By documentDownloadButton = By.xpath("(//button[@automation-id='documentsInboxes_download_btn' ])[1]");
    private static By firstDocumentDateST = By.xpath("(//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'9.03.2022')])[6]");
    private static By secondDocumentDateST = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'9.02.2022')]");
    private static By thirdDocumentDateST = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'18.01.2022')]");
    private static By firstDocumentDateSIT = By.xpath("//span[@automation-id='documentsInboxes_date_tv'");
    private static By secondDocumentDateSIT = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'27.04.2021')]");
    private static By thirdDocumentDateSIT = By.xpath("//span[@automation-id='documentsInboxes_date_tv' and contains(text(),'07.04.2021')]");
    private static By pageCounter = By.xpath("//li[@class='pagecounter']//p");
    private static By backButton = By.xpath("//a[@automation-id='back_Link']//span[2]");
    private static By firstPageButtonInactive = By.xpath("//a[@class='btn btn-alt fm-inactive'][1]");//a[@class='btn btn-alt fm-inactive'][2]
    private static By lastPageButton = By.xpath("//a[@class='btn btn-alt'][2]");
    private static By lastPageNotificationMessage = By.xpath("(//p[@class='notification-text'])[1]");
    private static By contractChooserDropdownArrow = By.xpath("//span[@id='closeSvg']");
    private static By sohoContractDropdown = By.xpath("//button[@id='anchor_child'and contains(text(),'Automated Martin2')]");//li[@id='option_child'][2]
    private static By consumerContractDropdown = By.xpath("(//button[contains(text(),'Automated Martin')])[1]"); // //li[@id='option_child'][1]
    private static By noDocumentsMessage = By.xpath("//div[@automation-id='no-documents_nt']//p");
    private static By documentContentOverlay = By.id("fram");
    private static By documentContentCloseButton = By.xpath("//button[@class='nsm-dialog-btn-close']");

    public static By MitteilungenTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static By Dokumentstab = By.xpath("//a[@automation-id='documentsInboxes_lv']/span");

    //Constructor
    public MyDocuments(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Functions
    public void returnToDashboard(){
        driver.element().isElementClickable(backButton);
        driver.element().click(backButton);
    }

    public void clickOnBackButton(){
        driver.element().isElementClickable(backButton);
        driver.element().click(backButton);
    }

    public MyDocuments clicklastPagebutton(){
        driver.element().click(lastPageButton);
        return this;
    }

    public MyDocuments clickDropdowncontractsChooser(){
        driver.element().click(contractNameMultiUser);
        return this;
    }

    public MyDocuments clickSohoContractFromDropdown(){
        driver.element().isElementClickable(sohoContractDropdown);
        driver.element().click(sohoContractDropdown);
        return this;
    }

    public MyDocuments clickConsumerContractFromDropdown(){
        driver.element().isElementClickable(consumerContractDropdown);
        driver.element().click(consumerContractDropdown);
        return this;
    }

    public MyDocuments clickDocumentPreviewButton(){
        driver.element().isElementClickable(documentPreviewButton);
        driver.element().click(documentPreviewButton);
        return this;
    }

    public MyDocuments clickDocumentContentCloseButton(){
        driver.element().isElementClickable(documentContentCloseButton);
        driver.element().click(documentContentCloseButton);
        return this;
    }

    public MyDocuments clickDocumentDownloadButton(){
        driver.element().click(documentDownloadButton);
        return this;
    }

    public MyDocuments validateMeineDokumenteLinkoutRedirection(){
        driver.verifyThat().element(Dokumentstab)
                .textTrimmed().isEqualTo(DokumentstabCL)
                .withCustomReportMessage("Validate Documents title")
                .perform();
        return this;
    }

    public MyDocuments validateMeineDokumenteSOredirection(){
        driver.verifyThat().element(Dokumentstab)
                .textTrimmed().isEqualTo(DokumentstabCL)
                .withCustomReportMessage("Validate Documents title")
                .perform();
        return this;
    }

    public MyDocuments validateMyDocumentsPage(){
        driver.verifyThat().element(myContractsTitle)
                .textTrimmed()
                .contains(myContractsTitleCL)
                .withCustomReportMessage("Check that my contracts 'Meine Verträge' title exists")
                .perform();
        driver.verifyThat().element(titleText)
                .textTrimmed()
                .contains(titleTextCL)
                .withCustomReportMessage("Check that title text exists")
                .perform();
        driver.verifyThat().element(documentsCount)
                .exists()
                .perform();
        return this;
    }

    public MyDocuments validateDocumentsInformationforMorethan10Docs(){
        driver.verifyThat().element(documentsCount)
                .exists()
                .perform();
        driver.verifyThat().element(documentName)
                .exists()
                .perform();
        driver.verifyThat().element(documentDate)
                .exists()
                .perform();
        driver.verifyThat().element(documentPreviewButton)
                .exists()
                .withCustomReportMessage("Check that first document preview button exists")
                .perform();
        driver.verifyThat().element(documentDownloadButton)
                .exists()
                .withCustomReportMessage("Check that first document download button exists")
                .perform();
        return this;
    }

    public MyDocuments validatePaginationFirstPage(){
        driver.verifyThat().element(pageCounter)
                .exists()
                .withCustomReportMessage("Check that first page counter '1 von 4' exists")
                .perform();
        return this;
    }

    public MyDocuments validatePaginationLastPage(){
        driver.verifyThat().element(pageCounter)
                .exists()
                .withCustomReportMessage("Check that last counter page '4 von 4' exists")
                .perform();
        return this;
    }

    public MyDocuments validateLastPageNotificationMessage(){
        driver.verifyThat().element(lastPageNotificationMessage)
                .textTrimmed()
                .contains(lastPageNotificationMessageCL1)
                .withCustomReportMessage("Check that last page notification message exists")
                .perform();
        driver.verifyThat().element(lastPageNotificationMessage)
                .textTrimmed()
                .contains(lastPageNotificationMessageCL2)
                .withCustomReportMessage("Check that last page notification message exists")
                .perform();
        return this;
    }

    public MyDocuments validateDocumentsInformationforLessthan10Docs(){
        driver.verifyThat().element(myContractTitle)
                .exists()
                .withCustomReportMessage("Check that my contracts 'Meine Vertrag' title exists")
                .perform();
        driver.verifyThat().element(titleText)
                .textTrimmed()
                .contains(titleTextCL)
                .withCustomReportMessage("Check that title text exists")
                .perform();
        driver.verifyThat().element(documentsCount)
                .exists()
                .withCustomReportMessage("Check that documents count exists")
                .perform();
        driver.verifyThat().element(contractChooserDropdownArrow)
                .doesNotExist()
                .withCustomReportMessage("Check that contract chooser dropdown arrow not exists")
                .perform();
        return this;
    }

    public MyDocuments validatePaginationNotExists(){
        driver.verifyThat().element(pageCounter)
                .doesNotExist()
                .withCustomReportMessage("Check that pagination does not exists")
                .perform();
        return this;
    }

    public MyDocuments validateMyDocumentsPageInCaseSwitchingWithoutSelectingContract(){
        driver.verifyThat().element(myContractsTitle)
                .exists()
                .withCustomReportMessage("Check that my contracts 'Meine Verträge' title exists")
                .perform();
        driver.verifyThat().element(titleText)
                .textTrimmed().contains(titleTextCL)
                .withCustomReportMessage("Check that title text exists")
                .perform();
        driver.verifyThat().element(documentsCount)
                .exists()
                .withCustomReportMessage("Check that documents count exists")
                .perform();
        driver.verifyThat().element(documentName)
                .textTrimmed().isNotNull()
                .withCustomReportMessage("Check that first document name  exists")
                .perform();
        driver.verifyThat().element(documentDate)
                .textTrimmed().isNotNull()
                .withCustomReportMessage("Check that first document date  exists")
                .perform();
        driver.verifyThat().element(documentPreviewButton)
                .exists()
                .withCustomReportMessage("Check that first document preview button exists")
                .perform();
        driver.verifyThat().element(documentDownloadButton)
                .exists()
                .withCustomReportMessage("Check that first document download button exists")
                .perform();
        return this;
    }

    public MyDocuments validateMyDocumentsPageInCaseSelectingSOHOContract(){
        driver.element().isElementDisplayed(noDocumentsMessage);
        driver.verifyThat().element(noDocumentsMessage)
                .textTrimmed()
                .contains(noDocumentsMessageCL1)
                .withCustomReportMessage("Check that no documents message for SOHO contract exists")
                .perform();
        driver.verifyThat().element(noDocumentsMessage)
                .textTrimmed()
                .contains(noDocumentsMessageCL2)
                .withCustomReportMessage("Check that no documents message for SOHO contract exists")
                .perform();
        return this;
    }

    public MyDocuments validateMyDocumentsPageInCaseSelectingConsumerContract(){
        driver.verifyThat().element(documentName).isVisible()
                .withCustomReportMessage("Check that document name for consumer contract exists")
                .perform();
        return this;
    }

    public MyDocuments verifyPreviewButton(){
        driver.verifyThat().element(documentContentOverlay)
                .exists()
                .withCustomReportMessage("Check that document content overlay frame exists")
                .perform();
        return this;
    }

    public MyDocuments verifyMyDocumentsPageTitle(){
        driver.verifyThat().element(myContractsTitle)
                .textTrimmed()
                .contains(myContractsTitleCL)
                .withCustomReportMessage("Check that my contracts 'Meine Verträge' title exists")
                .perform();
        return this;
    }
}
