package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BookingTransactionPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    private By BookingTransactionPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By AccordionHeaderTitle = By.xpath("//h3[@automation-id='transactionTileTitle_tv']");
    private By bookingDate = By.xpath("//h5[@automation-id='startBookingDate_tv']");
    private By InternetFirstOptionCard = By.xpath("(//div[@class='tariff-card-wrapper'])[1]");
    private By InternetFirstOptionName = By.xpath("(//span[@class='h2'])[1]");
    private By InternetFirstOptionPrice = By.xpath("(//div[@class='tariffPrice'])[1]");
    private By InternetSecondOptionCard = By.xpath("(//div[@class='tariff-card-wrapper'])[1]");
    private By InternetSecondOptionName = By.xpath("(//span[@class='h2'])[1]");
    private By InternetSecondOptionPrice = By.xpath("(//div[@class='tariffPrice'])[1]");
    private By StartDateInternetFirstOptionCard = By.xpath("(//div[@class='white-box date-card mt-20'])");
    private By StartDateInternetFirstOptionHeadline = By.xpath("(//h5[@automation-id='startBookingDate_tv'])");
    private By PhoneFirstOptionCard = By.xpath("//div[@class='tariff-card-wrapper']");
    private By PhoneFirstOptionName = By.xpath("//span[@class='h2']");
    private By PhoneFirstOptionPrice = By.xpath("//div[@class='tariffPrice']");
    private By StartDatePhoneFirstOptionCard = By.xpath("//div[@class='white-box date-card mt-20']");
    private By StartDatePhoneFirstOptionHeadline = By.xpath("//h5[@automation-id='startBookingDate_tv']");
    private By LegalTextCard = By.xpath("//div[@class='white-box white-box-underline-tags mb-20']");
    private By LegalText = By.xpath("//div[@automation-id='legalText_tv']");
    private By ContractSummaryPreText = By.xpath("//span[@automation-id='contractSummaryPreWording_tv']");
    private By ContractSummaryPostText = By.xpath("//span[@automation-id='contractSummaryPostWording_tv']");
    private By ContractSummaryPDFDownloadHyperLink = By.xpath("//a[@automation-id='contractSummaryDoc_Link']");
    private By TryAgainNotification = By.xpath("//div[@automation-id='tryAgain_nt']");
    private By TryAgainNotificationHeader = By.xpath("//div[@automation-id='tryAgain_nt']//h4");
    private By TryAgainNotificationSubLine = By.xpath("//div[@automation-id='tryAgain_nt']//p");
    private By TryAgainNotificationCTA = By.xpath("//button[@automation-id='tryAgain_btn']");
    private By ErrorMessageScreenHeader = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private By ErrorMessageScreenBody = By.xpath("//div[@automation-id='undefined_nt']//p");
    private By ExistingOneOptionNotification = By.xpath("//div[@automation-id='droppedOptions_nt']");
    private By ExistingMultipleOptionNotification = By.xpath("");
    private By ExistingOptionNotificationHeader = By.xpath("//div[@automation-id='droppedOptions_nt']//h4");
    private By ExistingOptionNotificationSubLineOneOption = By.xpath("//div[@automation-id='droppedOptions_nt']//p");
    private By BookWithCostCTA = By.xpath("//button[@automation-id='productOrder_btn' and contains (.,'Kostenpflichtig buchen')]");
    private By transactionTileTitle = By.xpath("//div[@class='tariff-card-wrapper']");
    private By AbbrechenCTA = By.xpath("//a[@automation-id='back_Link']");
    private By contarctID = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By DroppedOptionTVNotificationMessageHeader = By.xpath("//div[@automation-id='droppedOptions_nt']//h4/strong");
    private By DroppedOptionTVNotificationMessageBody = By.xpath("//div[@automation-id='droppedOptions_nt']//p");
    private By SecondDroppedOptionTV = By.xpath("(//div[@automation-id='droppedOptions_nt']//p//li)[1]");
    private By ThirdDroppedOptionTV = By.xpath("(//div[@automation-id='droppedOptions_nt']//p//li)[2]");

    //CL

    private String ErrorMessageScreenHeaderCL = "Das hat leider nicht geklappt";
    private String ErrorMessageScreenBodyCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal oder kündige direkt über die Hotline: 0800 172 1212.";


    //Constructor
    public BookingTransactionPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    @Step("Click On Contract Summary PDF hyper link Download")
    public BookingTransactionPage clickContractSummaryPDFHyperLink(){
        driver.verifyThat().element(ContractSummaryPreText).exists().perform();
        driver.element().click(ContractSummaryPDFDownloadHyperLink);
        return this;
    }

    @Step("Click On Book with Cost CTA in Legal Text Card")
    public BookingTransactionPage clickBookWithCostCTA(){
        driver.element().click(BookWithCostCTA);
        return this;
    }

    @Step("Click Back CTA in Legal Text Card")
    public BookingTransactionPage clickBackCTA(){
        driver.verifyThat().element(contarctID).exists().perform();
        driver.element().click(AbbrechenCTA);
        return this;
    }

    @Step("Validate Book With Cost CTA CL")
    public BookingTransactionPage validateBookWithCostCTACL(String BookWithCostCTACL){
        driver.assertThat().element(BookWithCostCTA).textTrimmed().isEqualTo(BookWithCostCTACL).perform();
        return this;
    }

    @Step("Validate Booking Transaction Page header")
    public BookingTransactionPage validateBookingTransactionPageHeader(String BookingTransactionPageHeaderCL){
        driver.assertThat().element(BookingTransactionPageHeader).textTrimmed().isEqualTo(BookingTransactionPageHeaderCL).perform();
        return this;
    }

    @Step("Validate Accordion Header Title Internet")
    public BookingTransactionPage validateAccordionHeaderTitleInternet(String AccordionHeaderTitleInternetCL){
        driver.assertThat().element(bookingDate).exists().perform();
        driver.assertThat().element(AccordionHeaderTitle).textTrimmed().isEqualTo(AccordionHeaderTitleInternetCL).perform();
        return this;
    }

    @Step("Validate Accordion Header Title Telefon")
    public BookingTransactionPage validateAccordionHeaderTitleTelefon(String AccordionHeaderTitleTelefonCL){
        driver.assertThat().element(AccordionHeaderTitle).textTrimmed().isEqualTo(AccordionHeaderTitleTelefonCL).perform();
        return this;
    }

    @Step("Validate on Internet First Option Card")
    public BookingTransactionPage validateInternetFirstOptionCard(String InternetFirstOptionNameCL, String InternetFirstOptionPriceCL){
        driver.verifyThat().element(InternetFirstOptionCard).exists().perform();
        driver.assertThat().element(InternetFirstOptionName).textTrimmed().isEqualTo(InternetFirstOptionNameCL).perform();
        driver.assertThat().element(InternetFirstOptionPrice).textTrimmed().isEqualTo(InternetFirstOptionPriceCL).perform();
        return this;
    }

    @Step("Validate on Internet Second Option Card")
    public BookingTransactionPage validateInternetSecondOptionCard(String InternetSecondOptionNameCL, String InternetSecondOptionPriceCL){
        driver.verifyThat().element(InternetSecondOptionCard).exists().perform();
        driver.assertThat().element(InternetSecondOptionName).textTrimmed().isEqualTo(InternetSecondOptionNameCL).perform();
        driver.assertThat().element(InternetSecondOptionPrice).textTrimmed().isEqualTo(InternetSecondOptionPriceCL).perform();
        return this;
    }

    @Step("Validate Internet First Option Start Date Card")
    public BookingTransactionPage validateInternetFirstOptionStartDateCard(String StartDateInternetFirstOptionHeadlineCL){
        driver.verifyThat().element(StartDateInternetFirstOptionCard).exists().perform();
        driver.assertThat().element(StartDateInternetFirstOptionHeadline).textTrimmed().isEqualTo(StartDateInternetFirstOptionHeadlineCL).perform();
        return this;
    }

    @Step("Validate on Internet First Option Card")
    public BookingTransactionPage validatePhoneFirstOptionCard(String PhoneFirstOptionNameCL,String PhoneFirstOptionPriceCL){
        driver.verifyThat().element(PhoneFirstOptionCard).exists().perform();
        driver.assertThat().element(PhoneFirstOptionName).textTrimmed().isEqualTo(PhoneFirstOptionNameCL).perform();
        driver.assertThat().element(PhoneFirstOptionPrice).textTrimmed().isEqualTo(PhoneFirstOptionPriceCL).perform();
        return this;
    }

    @Step("Validate Phone First Option Start Date Card")
    public BookingTransactionPage validatePhoneFirstOptionStartDateCard(String StartDatePhoneFirstOptionHeadlineCL){
        driver.verifyThat().element(StartDatePhoneFirstOptionCard).exists().perform();
        driver.assertThat().element(StartDatePhoneFirstOptionHeadline).textTrimmed().isEqualTo(StartDatePhoneFirstOptionHeadlineCL).perform();
        return this;
    }

    @Step("Validate Legal Text Card")
    public BookingTransactionPage validateLegalTextCard(String ContractSummaryPreTextCL, String ContractSummaryPostTextCL, String ContractSummaryTextCL){
        driver.verifyThat().element(LegalTextCard).exists().perform();
        driver.verifyThat().element(LegalText).exists().perform();
        driver.assertThat().element(ContractSummaryPreText).textTrimmed().isEqualTo(ContractSummaryPreTextCL).perform();
        driver.assertThat().element(ContractSummaryPDFDownloadHyperLink).textTrimmed().isEqualTo(ContractSummaryTextCL).perform();
        driver.assertThat().element(ContractSummaryPostText).textTrimmed().isEqualTo(ContractSummaryPostTextCL).perform();
        return this;
    }

    @Step("Validate Try Again Notification")
    public BookingTransactionPage validateTryAgainNotification(String TryAgainNotificationHeaderCL, String TryAgainNotificationSubLineCL, String TryAgainNotificationCTACL){
        driver.verifyThat().element(TryAgainNotification).exists().perform();
        driver.assertThat().element(TryAgainNotificationHeader).textTrimmed().isEqualTo(TryAgainNotificationHeaderCL).perform();
        driver.assertThat().element(TryAgainNotificationSubLine).textTrimmed().isEqualTo(TryAgainNotificationSubLineCL).perform();
        driver.assertThat().element(TryAgainNotificationCTA).textTrimmed().isEqualTo(TryAgainNotificationCTACL).perform();
        return this;
    }

    @Step("Validate Existing One Option Notification")
    public BookingTransactionPage validateConflictOptionNotification(String ExistingOptionNotificationHeaderCL, String ExistingOptionNotificationSubLineOneOptionCL){
        driver.verifyThat().element(ExistingOneOptionNotification).exists().perform();
        driver.assertThat().element(ExistingOptionNotificationHeader).textTrimmed().isEqualTo(ExistingOptionNotificationHeaderCL).perform();
        driver.assertThat().element(ExistingOptionNotificationSubLineOneOption).textTrimmed().contains(ExistingOptionNotificationSubLineOneOptionCL).perform();
        return this;
    }

    @Step("Validate not Existing one Option Notification")
    public BookingTransactionPage validateNotExistOneOptionNotification(){
        driver.verifyThat().element(ExistingOneOptionNotification).doesNotExist().perform();
        return this;
    }

    @Step("validate Not Existing Multiple Options Notification")
    public BookingTransactionPage validateNotExistingMultipleOptionsNotification(){
        driver.verifyThat().element(ExistingMultipleOptionNotification).doesNotExist().perform();
        return this;
    }

    @Step("Validate Error Message Screen")
    public BookingTransactionPage validateErrorMessageScreen(){
        driver.assertThat().element(ErrorMessageScreenHeader).textTrimmed().isEqualTo(ErrorMessageScreenHeaderCL).perform();
        driver.assertThat().element(ErrorMessageScreenBody).textTrimmed().isEqualTo(ErrorMessageScreenBodyCL).perform();
        return this;
    }

    @Step("Validate Dropped Options TV Notification Message")
    public BookingTransactionPage validateOneDroppedOptionTVNotificationMessage(String DroppedOptionTVNotificationMessageHeaderCL, String DropOneOptionTVNotificationMessageBodyCL){
        driver.assertThat().element(DroppedOptionTVNotificationMessageHeader).textTrimmed().isEqualTo(DroppedOptionTVNotificationMessageHeaderCL).perform();
        driver.assertThat().element(DroppedOptionTVNotificationMessageBody).textTrimmed().isEqualTo(DropOneOptionTVNotificationMessageBodyCL).perform();
        return this;
    }

    @Step("Validate Multiple Dropped Options TV Notification Message")
    public BookingTransactionPage validateMultipleDroppedOptionsTVNotificationMessage(String DroppedOptionTVNotificationMessageHeaderCL, String SecondDroppedOptionTVCL , String ThirdDroppedOptionTVCL){
        driver.assertThat().element(DroppedOptionTVNotificationMessageHeader).textTrimmed().isEqualTo(DroppedOptionTVNotificationMessageHeaderCL).perform();
        driver.assertThat().element(SecondDroppedOptionTV).textTrimmed().isEqualTo(SecondDroppedOptionTVCL).perform();
        driver.assertThat().element(ThirdDroppedOptionTV).textTrimmed().isEqualTo(ThirdDroppedOptionTVCL).perform();
        return this;
    }
}