package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class SolsticeMyContractsAndParticipants {

    private SHAFT.GUI.WebDriver driver;

    // public static By SliderMobile = By.className("switch fm-flip-switch");
    public static By SliderMobileDes = By.xpath("//*[text()='Kundennummer nicht zum Login verwendet']");
    // public static By SliderDSL = By.className("switch fm-flip-switch");
    public static By SliderDSLDes = By.xpath("//*[text()='Kundennummer nicht zum Login verwendet']");
    // public static By SliderVKD = By.className("switch fm-flip-switch");
    public static By SliderVKDDes = By.xpath("//*[text()='Standardvertrag für den App-Zugriff']");
    //  public static By SliderUM = By.className("switch fm-flip-switch");
    public  static By SliderUMDes = By.xpath("//*[text()='Standardvertrag für den App-Zugriff']");
    public static By VkdInfoMsg = By.xpath("//*[text()='Du kannst Deine Kundennummer nicht für den Login nutzen.']");
    public static By UmInfoMsg = By.xpath("//*[text()='Du kannst Deine Kundennummer nicht für den Login nutzen.']");
    public static String SliderMobileDes_text = "Kundennummer nicht zum Login verwendet";
    public static String SliderDSLDes_text = "Kundennummer nicht zum Login verwendet";
    public static String SliderVKDDes_text = "Standardvertrag für den App-Zugriff";
    public static String SliderUMDes_text = "Standardvertrag für den App-Zugriff";
    public static String VkdInfoMsg_text = "Du kannst Deine Kundennummer nicht für den Login nutzen.";
    public static String UmInfoMsg_text = "Du kannst Deine Kundennummer nicht für den Login nutzen.";
    //Story 11810 locators and Strings
    public static By ContractAndParticipantTitle_text = By.cssSelector("strong[automation-id='manageContractAndSubscriptionAccordion_tv']");
    public static String ContractAndParticipant = "Deine Verträge und Teilnehmer";
    public static By ContractAndParticipantDescription_text = By.cssSelector("p[automation-id='manageContractAndSubscriptionAccordionBody_tv']");
    public static String ContractAndParticipantDescription = "Verwalte Deine Verträge und Teilnehmer. Oder füge neue hinzu.";
    public static By BurgerMenu_button = By.xpath("(//div[@class='expert-mode-menu'])[1]");
    public static By renameContractOption_Link = By.xpath("(//a[@automation-id='menuItemPermission_0_Link'])[1]");
    public static String renameContractOption ="Vertrag umbenennen";
    public static By privacy_Link = By.xpath("(//a[@automation-id='menuItemPermission_2_Link'])[1]");
    public static String privacy ="Datenschutz- und Werbeeinstellungen";
    public static By renameProduct_Link = By.cssSelector("a[automation-id='renameProduct_Link']");
    public static String renameProduct ="Vertrag umbenennen";
    public static By changePassword_link = By.xpath("(//a[@automation-id='menuItemPermission_1_Link'])[1]");
    public static String changePassword ="Kunden-Kennwort ändern";
    public static By notificationTitle_text = By.xpath("//*[text()='Das hat nicht geklappt']");
    public static String notificationTitle ="Das hat nicht geklappt";
    public static By notificationDescription_text = By.xpath("    //p[contains(.,'Du kannst Dein Vodafone-Konto nicht löschen, weil es von einem oder einer anderen Teilnehmer:in genutzt wird.')]\n");
    public static String notificationDescription ="Du kannst Dein Vodafone-Konto nicht löschen, weil es von einem oder einer anderen Teilnehmer:in genutzt wird.";

//Story 12254 locators and Strings

    public static By expandMyContractsAccordion = By.xpath("//*[@automation-id='manageContractsSubscriptions_acc']");
    public static By delegatedIconContract = By.xpath("(//*[@class='blue'])[1]");
    protected static String delegatedIconContract_text ="wird verwaltet";
    public static By burgerMenueContract = By.xpath("(//*[@class='i-sml dots'])[1]");
    public static By firstOption = By.xpath("(//*[@automation-id='menuItemPermission_0_Link'])[1]");
    public static String firstOption_text ="Vertrag umbenennen";
    public static By secondOption = By.xpath("(//*[@automation-id='menuItemPermission_1_Link'])[1]");
    public static String secondOption_text ="Vertrag aus dem MeinVodafone-Konto entfernen";
    public static By thirdOption = By.xpath("(//*[@automation-id='menuItemPermission_2_Link'])[1]");
    public static String thirdOption_text ="Datenschutz- und Werbeeinstellungen";

    public static By delegatedIconProduct = By.xpath("(//*[@class='blue'])[2]");
    protected static String delegatedIconProduct_text ="wird verwaltet";
    public static By burgerMenueProduct = By.xpath("(//*[@class='i-sml dots'])[2]");

    public static By firstOptionProduct = By.xpath("(//*[@automation-id='menuItemPermission_0_Link'])[2]");
    public static By renameContract_button = By.xpath("(//*[@automation-id='menuItemPermission_0_Link'])[1]");

    public static String firstOptionProduct_text ="Vertrag umbenennen";
    public static By secondOptionProduct = By.xpath("(//*[@automation-id='menuItemPermission_1_Link'])[2]");
  public static String secondOptionProduct_text ="Produkt aus MeinVodafone entfernen";



    public SolsticeMyContractsAndParticipants(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public SolsticeMyContractsAndParticipants ClickONBurgerMenu() {
        driver.element().click(BurgerMenu_button);
        return new SolsticeMyContractsAndParticipants(driver);
    }

    public SolsticeMyContractsAndParticipants ClickONBurgerMenu_Product() {
        driver.element().click(burgerMenueProduct);
        return new SolsticeMyContractsAndParticipants(driver);
    }

    public RemoveDelegated chooseSecondOption() {
        driver.element().click( secondOption);
        return new  RemoveDelegated(driver);
    }
    public RemoveDelegated chooseSecondOption_Product() {
        driver.element().click(secondOptionProduct);
        return new  RemoveDelegated(driver);
    }
    public RenameContract chooseRenameContract() {
        driver.element().click(renameContract_button);
        return new  RenameContract(driver);
    }

    public RenameProduct chooseRenameProduct() {
        driver.element().click(firstOptionProduct);
        return new RenameProduct(driver);
    }
    public void VerifyDelgatedIcon(){
        driver.assertThat().element(SolsticeMyContractsAndParticipants.delegatedIconContract)
                .doesNotExist().withCustomReportMessage("Check that delegated label for contract doesn't exist").perform();
        driver.assertThat().element(SolsticeMyContractsAndParticipants.delegatedIconProduct)
                .doesNotExist().withCustomReportMessage("Check that delegated label for contract doesn't exist").perform();
    }

    public void VerifyDelgatedAcordion(){
        driver.assertThat().element(SolsticeMyContractsAndParticipants.delegatedIconContract)
                .text().contains(SolsticeMyContractsAndParticipants.delegatedIconContract_text)
                .withCustomReportMessage("Check that delegated label for contract is exist").perform();
    }
    public void assertionForContractAndSubscriptionTileAndDescription(){
        driver.assertThat().element(SolsticeMyContractsAndParticipants.ContractAndParticipantTitle_text)
                .text().contains(SolsticeMyContractsAndParticipants.ContractAndParticipant)
                .withCustomReportMessage("check that title equal this value  : Deine Verträge und Teilnehmer").perform();
        driver.assertThat().element(SolsticeMyContractsAndParticipants.ContractAndParticipantDescription_text)
                .text().contains(SolsticeMyContractsAndParticipants.ContractAndParticipantDescription)
                .withCustomReportMessage("check that title equal this value  : Verwalte Deine Verträge und Teilnehmer. Oder füge neue hinzu.").perform();
        driver.assertThat().element(SolsticeMyContractsAndParticipants.renameContractOption_Link)
                .text().contains(SolsticeMyContractsAndParticipants.renameContractOption)
                .withCustomReportMessage("check that title equal this value  :  Vertrag umbenennen ").perform();
        driver.assertThat().element(SolsticeMyContractsAndParticipants.privacy_Link)
                .text().contains(SolsticeMyContractsAndParticipants.privacy)
                .withCustomReportMessage("check that title equal this value  :   Datenschutz- und Werbeeinstellungen ").perform();
    }
}


