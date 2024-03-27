package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DevicesPage {

    private SHAFT.GUI.WebDriver driver;
    public DevicesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public static By DevicesTabTextLocator = By.xpath("(//*[@automation-id='undefined_lv']//span)[3]");

    public static By PageHeaderLocator = By.xpath("(//*[text()='Geräte'])[1]");
    public static By RentEquipSO_Locator = By.xpath("(//*[@automation-id='rentDevices_so'])");
    public static By RentEquipSO_HeaderLocator = By.xpath("(//*[@automation-id='rentDevices_so']//h3)");
    public static By RentEquipSO_TextLocator = By.xpath("(//*[@automation-id='rentDevices_so']//div)[5]");
    public static By RentEquipAcc_HeaderLocator = By.xpath("(//*[@automation-id='rentDevices_acc']//h4)");
    public static By RentEquipAcc_TextLocator = By.xpath("(//*[@automation-id='rentDevices_acc']//h5)");
    public static By RentEquipAcc_SectionLabelLocator = By.xpath("((//*[@automation-id='rentDevices_acc']//h4))[2]");
    public static By RentEquipAcc_SectionTitleLocator = By.xpath("((//*[@automation-id='rentDevices_acc']//b))");
    public static By RentEquipAcc_SectionSubTitleLocator = By.xpath("((//*[@automation-id='rentDevices_acc']//p))[2]");
    public static By RentEquipAcc_SectionCTA_Locator = By.xpath("((//*[@automation-id='rentDevices_acc']//a))[2]");

    public static By BuyDevicesAndAccessoriesSO_Locator = By.xpath("(//*[@automation-id='terminalsAndAccessories_so'])");
    public static By BuyDevicesAndAccessoriesSO_HeaderLocator = By.xpath("(//*[@automation-id='terminalsAndAccessories_so']//h3)");
    public static By BuyDevicesAndAccessoriesSO_TextLocator = By.xpath("(//*[@automation-id='terminalsAndAccessories_so']//div)[5]");
    public static By BuyDevicesAndAccessoriesAcc_HeaderLocator = By.xpath("(//*[@automation-id='terminalsAndAccessories_acc']//h4)[1]");
    public static By BuyDevicesAndAccessoriesAcc_TextLocator = By.xpath("(//*[@automation-id='terminalsAndAccessories_acc']//h5)");
    public static By BuyDevicesAndAccessoriesAcc_SectionTitleLocator = By.xpath("((//*[@automation-id='terminalsAndAccessories_acc']//h4))[2]");
    public static By BuyDevicesAndAccessoriesAcc_SectionSubTitleLocator = By.xpath("((//*[@automation-id='terminalsAndAccessories_acc']//p))");
    public static By BuyDevicesAndAccessoriesAcc_SectionCTA_Locator = By.xpath("((//*[@automation-id='terminalsAndAccessories_acc']//a))[2]");


    public static String PageHeaderCl = "Geräte";
    public static String DevicesTabTextCL = PageHeaderCl;
    public static String RentEquipSO_HeaderCL = "Geräte mieten";
    public static String RentEquipSO_TextCL = "Übersicht der mietbaren Geräte";
    public static String RentEquipAcc_HeaderCL = RentEquipSO_HeaderCL;
    public static String RentEquipAcc_TextCL = RentEquipSO_TextCL;
    public static String RentEquipAcc_SectionLabelCL = "Mietgeräte";
    public static String RentEquipAcc_SectionTitleCL = "Du hast zur Zeit kein Gerät gemietet oder geliehen. Brauchst Du eins?";
    public static String RentEquipAcc_SectionSubTitleCL = "Hier kannst Du Geräte bestellen.";
    public static String RentEquipAcc_SectionCTA_CL = "Bestellen";

    public static String BuyDevicesAndAccessoriesSO_HeaderCL = "Geräte & Zubehör kaufen";
    public static String BuyDevicesAndAccessoriesSO_TextCL = "Zum Online-Shop";
    public static String BuyDevicesAndAccessoriesAcc_HeaderCL = BuyDevicesAndAccessoriesSO_HeaderCL;
    public static String BuyDevicesAndAccessoriesAcc_TextCL = BuyDevicesAndAccessoriesSO_TextCL;
    public static String BuyDevicesAndAccessoriesAcc_SectionTitleCL = BuyDevicesAndAccessoriesSO_HeaderCL;
    public static String BuyDevicesAndAccessoriesAcc_SectionSubTitleCL = BuyDevicesAndAccessoriesSO_TextCL;
    public static String BuyDevicesAndAccessoriesAcc_SectionCTA_CL = "Weiter";


    public DevicesPage click(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }






}
