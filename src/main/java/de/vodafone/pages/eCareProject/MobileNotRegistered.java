package de.vodafone.pages.eCareProject;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MobileNotRegistered {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By Unregistered_Subscribers_Section = By.xpath("//*[@ng-if=\"vm.unregisteredList.length\"]");
    public static final By Unregistered_Section_Subscribers_Title = By.xpath("(//*[@class=\"dashInfoText\"])[2]/div[1]");
    public static final By Unregistered_Section_Subscribers_SubTitle = By.xpath("(//*[@class=\"dashInfoText\"])[2]/div[2]");

    public static final By First_Unregistered_Subscriber = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[1]");
    public static final By First_Unregistered_Subscriber_Title = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[1]//*[@class=\"mbo-name\"]");
    public static final By First_Unregistered_Subscriber_Num = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[1]//*[@class=\"mbo-msisdn\"]");
    public static final By First_Unregistered_Subscriber_Link = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[1]//*[@class=\"onclick-menu\"]");
    public static final By First_Unregistered_Subscriber_Icon = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[1]//*[@class=\"expert-mode\"]");

    public static final By Second_Unregistered_Subscriber = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[2]");
    public static final By Second_Unregistered_Subscriber_Title = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[2]//*[@class=\"mbo-name\"]");
    public static final By Second_Unregistered_Subscriber_Num = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[2]//*[@class=\"mbo-msisdn\"]");
    public static final By Second_Unregistered_Subscriber_Link = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[2]//*[@class=\"onclick-menu\"]");
    public static final By Second_Unregistered_Subscriber_Icon = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[2]//*[@class=\"expert-mode\"]");

    public static final By Third_Unregistered_Subscriber = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[3]");
    public static final By Third_Unregistered_Subscriber_Title = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[3]//*[@class=\"mbo-name\"]");
    public static final By Third_Unregistered_Subscriber_Num = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[3]//*[@class=\"mbo-msisdn\"]");
    public static final By Third_Unregistered_Subscriber_Link = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[3]//*[@class=\"onclick-menu\"]");
    public static final By Third_Unregistered_Subscriber_Icon = By.xpath("(//*[@class=\"subscriber-bar\"])[2]/li[3]//*[@class=\"expert-mode\"]");

    public static final By ShowMore_Unregistered_BTN = By.xpath("//*[@class=\"showMore\"]/a/span");
    public static final By ShowMore_Unregistered_Icon = By.xpath("//*[@class=\"showMore\"]/a/*[@class=\"icon-plus-i-xsml i-xsml\"][1]");

    public static final By Add_Subscriber_Page_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");

    public static final By Accordion_Has_Unregistered = By.xpath("");
    public static final By Accordion_HasNo_Unregistered = By.xpath("");

    //CLs
    public static String Unregistered_Section_Subscribers_Title_CL = "Teilnehmer gefunden";
    public static String Unregistered_Section_Subscribers_SubTitle_CL = "Es gibt weitere Teilnehmer Deines Vertrages. Du kannst ihre Rufnummer jetzt in MeinVodafone hinzufügen.";
    public static String Unregistered_Subscriber_Title_CL = "Rufnummer hinzufügen";

    //constructor
    public MobileNotRegistered(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void clickOnShowMoreButton(){
        driver.element().click( ShowMore_Unregistered_BTN);
    }

    public void NavigateToAddSubscriberPage(){
        driver.element().click( First_Unregistered_Subscriber_Title);
    }

    public void ExpandContractAccordionHasUnregistered(){driver.element().click( Accordion_Has_Unregistered);}

    public void ExpandContractAccordionHasNOUnregistered(){driver.element().click( Accordion_Has_Unregistered);}
}
