package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeOtherAdmins {

    private SHAFT.GUI.WebDriver driver;

    public static By moreDetails = By.xpath("(//*[@automation-id='otherAdminsCollapsiblePanelcollapseButtonTxt_tv'])[1]");
    public static By ProdHeader = By.xpath("//*[text()='Verträge und Produkte verwalten']");
    public static By ProdDes = By.xpath("//*[text()='Du kannst hier bis zu 5 Personen Zugriff auf Deine Verträge und Produkte gewähren.']");
    public static By lessDetails = By.xpath("//*[text()=' Weniger Details ']");
    public static By personDetails = By.xpath("(//*[@automation-id='productCollapsiblePanelControlsContainer_tv'])[1]");
    public static By noDetails = By.xpath("(//*[text()=' Keine Details zeigen '])[1]");
    public static By personDetails2 = By.xpath("(//*[@automation-id='productCollapsiblePanelControlsContainer_tv'])[2]");
    public static By noDetails2 = By.xpath("(//*[text()=' Keine Details zeigen '])[2]");



    public static String ProdHeader_text = "Verträge und Produkte verwalten";
    public static String ProdDes_text = "Du kannst hier bis zu 5 Personen Zugriff auf Deine Verträge und Produkte gewähren.";
    public static String lessDetails_text = "Weniger Details";
    public static String personDetails_text = "Details der Person anzeigen";
    public static String noDetails_text = "Keine Details zeigen";

//WFAT-12337 locators and Strings

    public static By manageContractsProducts = By.xpath("//*[text()='Verträge und Produkte verwalten']");
    public static By invitationDescription = By.xpath("(//*[@automation-id='solsticeText_tv']/p)[2]");
    public static By contractDelegateBtn = By.xpath("(//*[@automation-id='addDelegate_btn'])[1]");
    public static By unload = By.xpath("(//*[text()='Ausladen'])[1]");
    public static By errorMsgHeader = By.xpath("//*[text()='Du kannst keine weitere Person einladen']");
    public static By errorMsgBody = By.xpath("//*[text()='5 Personen haben Deine Einladung schon angenommen. Erst, wenn Du eine davon auslädst, kannst Du eine neue Person einladen.']");
    public static By productDelegateBtn = By.xpath("(//*[@automation-id='addDelegate_btn'])[2]");
    public static By dontShowDetails = By.xpath("//*[@automation-id='productCollapsiblePanelcollapseButtonTxt_tv']");
    public static By closeDetails = By.xpath("(//*[@automation-id='otherAdminsCollapsiblePanelcollapseButtonTxt_tv'])[1]");




    public static String manageContractsProducts_text = "Verträge und Produkte verwalten";
    public static String invitationDescription_text = "Du kannst hier bis zu 5 Personen einladen, Deine Verträge und Produkte mit zu verwalten.";
    public static String contractDelegateBtn_text = "Person einladen";
    public static String unload_text = "Ausladen";
    public static String errorMsgHeader_text = "Du kannst keine weitere Person einladen";
    public static String errorMsgBody_text = "5 Personen haben Deine Einladung schon angenommen. Erst, wenn Du eine davon auslädst, kannst Du eine neue Person einladen.";
    public static String dontShowDetails_text = "Keine Details zeigen";
    public static String closeDetails_text = "Weniger Details";


//WFAT-13019 locators and Strings

    public static By msgHeader = By.xpath("(//*[@automation-id='undefined_nt'])[4]/div/div/div/div/h4");
    public static By msgBody = By.xpath("(//*[@automation-id='undefined_nt'])[4]/div/div/p");
    public static By mergeAccount = By.xpath("//*[@automation-id='startMergeUser_btn']");




    public static String msgHeader_text = "Dieser Bereich ist leer";
    public static String msgBody_text = "Aktuell hat niemand außer Dir Zugriff auf Deine Verträge und Produkte, oder verwaltet sie.";
    public static String mergeAccount_text = "Dieses Konto mit einem anderen MeinVodafone- oder MeinKabel-Konto zusammenlegen";





    public SolsticeOtherAdmins(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
