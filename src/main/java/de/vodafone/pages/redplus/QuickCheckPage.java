package de.vodafone.pages.redplus;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class QuickCheckPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    //CL
    //Owner CLs
    private String redPlusOwner_CardTitle_CL = "Mobilfunk-Vertrag";
    private String redPlus_alert_CL = "Die Red+ Hauptkarte hat unbegrenzten Zugriff auf Dein gebuchtes Datenvolumen.";

    //Member Card CLs in QuickCheck Card
    private String redPlusMember_Banner_CL = "Red+ Mitglied";
    private String redPlusQuickCheck_Header_CL = "Daten";
    private String highSpeed_Title_CL = "Highspeed";
    private String datatype_Title_CL = "Datenvolumen Ihrer Red+ Gruppe Inland & EU";
    private String endDate_Subtitle_CL = "verfügbar bis";
    private String bookDataVolume_Button_CL = "Datenvolumen buchen";
    private String speedGo_HyperLink_CL = "SpeedGo ist aktiv";

    //Element Locators
    //Page Elements
    private By QuickCheck_Accordion = By.xpath("//*[@id=\"kostendetails-post\"]/li/a");
    private By redPlus_Accordion = By.xpath("//*[@automation-id=\"redplus-volumen-aendern_acc\"]");

    //QuickCheck Cards
    //Member red plus
    private By redPlusQuickCheck_Banner = By.xpath("//*[@id=\"quickCheckAccordionContent\"]/quick-check-accordion/div/div[1]/div/div/large-card[1]/div/h5/div");
    private By redPlusQuickCheck_Header = By.xpath("//*[@id=\"quickCheckAccordionContent\"]/quick-check-accordion/div/div[1]/div/div/large-card[1]/div/div[1]/div");
    private By redPlusQuickCheck_CircleUsage = By.xpath("//*[@automation-id='QuickCheck_0']//canvas");
    private By highSpeed_Title = By.xpath("(//div[@class='header-wrapper'])[8]");
    private By totalData_Title = By.xpath("(//div[@class='usage-wrapper'])[10]");
    private By datatype_Title = By.xpath("(//p[@class='bold'])[9]");
    private By endDate_Subtitle = By.xpath("//*[@id=\"quickCheckAccordionContent\"]/quick-check-accordion//large-card[1]//div/p[2]");
    private By bookDataVolume_Button = By.xpath("//*[@id=\"quickCheckAccordionContent\"]//quick-check-accordion//div[3]//a");
    private By speedGo_HyperLink = By.xpath("//speedgo-status/section/a");

    //Limited Red+ Owner&Member in RED+ Accordion
    private By redPlusOwner_Card = By.xpath("(//*[@automation-id=\"RedPlusCards_container\"]//general-card)[1]");
    private By redPlusOwner_CardTitle = By.xpath("(//*[@class=\"h2\"])[2]");
    private By redPlus_alert = By.xpath("(//*[@automation-id=\"RedPlusCards_container\"]//h4)");


    //Flat Red+ Owner Cards
    private By ChangeLimit2_Button = By.xpath("//*[@id=\"redplusContent\"]/red-plus/div/general-card[3]/div[3]/div[2]/div/div/a");


    //Constructors
    public QuickCheckPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public QuickCheckPage clickOnQuickCheckAcc() {
        driver.element().click( QuickCheck_Accordion);
        return this;
    }

    public QuickCheckPage clickOnRedPlusAcc() {
        driver.element().click( redPlus_Accordion);
        return this;
    }

    public ChangeDataLimit clickOnChangeLimitButtonForFlatData() {
        driver.element().click( ChangeLimit2_Button);
        return new ChangeDataLimit(driver);
    }

    @Step("Red+ Member Card Validations in QuickCheck Accordion")
    public void validateRedPlusMemberCard(){
        Validations.verifyThat().element(driver.getDriver(), redPlusQuickCheck_Banner).text().contains(redPlusMember_Banner_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), redPlusQuickCheck_Header).text().contains(redPlusQuickCheck_Header_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), redPlusQuickCheck_CircleUsage).exists().perform();
        Validations.verifyThat().element(driver.getDriver(), highSpeed_Title).text().isEqualTo(highSpeed_Title_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), totalData_Title).exists().perform();
        Validations.verifyThat().element(driver.getDriver(), datatype_Title).text().isEqualTo(datatype_Title_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), endDate_Subtitle).text().contains(endDate_Subtitle_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), bookDataVolume_Button).text().isEqualTo(bookDataVolume_Button_CL).perform();
        Validations.verifyThat().element(driver.getDriver(), speedGo_HyperLink).text().isEqualTo(speedGo_HyperLink_CL).perform();
    }

    @Step("Red+ Owner Card Validation in Red+ Accordion")
    public void validateRedPluOwnerCard(){
        Validations.verifyThat().element(driver.getDriver(),redPlusOwner_Card).exists().perform();
        Validations.verifyThat().element(driver.getDriver(), redPlusOwner_CardTitle).text().isEqualTo(redPlusOwner_CardTitle_CL).perform();
        Validations.verifyThat().element(driver.getDriver(),redPlus_alert).text().isEqualTo(redPlus_alert_CL).perform();
    }
}