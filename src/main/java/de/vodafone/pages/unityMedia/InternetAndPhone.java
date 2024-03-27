package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InternetAndPhone {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String TelefonbuchEintragTitleCL = "Telefonbuch-Eintrag";
    public static String TelefonbuchEintragTextCL = "So stehst Du im Telefonbuch.";
    //  public static String TelefonbuchEintragAccTexttCL = "Du möchtest ändern, ob oder wie Deine Nummer im Telefonbuch angezeigt wird? Dann kontaktier uns bitte.";
    public static String TelefonbuchEintragAccCol1CL= "Telefonummer";
    public static String TelefonbuchEintragAccCol2CL= "Eintrag";
    public static String TelefonbuchEintragAccSubTextCL="Du möchtest ändern, ob oder wie Deine Nummer im Telefonbuch angezeigt wird? Dann kontaktier uns bitte.";
    private  By bookedOptionPriceFree = By.xpath("//*[@class='extras-card-price' and contains (.,' Kostenlos ')]");
    private  By internetAndPhone_ACC = By.xpath("//*[@class='subscription-heading'  and contains (., 'Internet & Phone-Produkte')]");

    //Locators
    private By bookedOptionsAcc = By.xpath("//*[@class='ac-icon i-booked-option-sml i-sml']");
    private By bookedOptionPrice = By.xpath("//*[@class='extras-card-price'and contains(.,'€')]");
    private By meinTariffSO = By.xpath("//*[@automation-id='ipTariffSO_so']");


    //Locators
    private By telefonbuchEintrag_card = By.xpath("//li[@automation-id='telefonbucheintrag_acc']//h4[contains(text(),'Telefonbuch-Eintrag')]");
    public static final By telephoneNumber_label = By.xpath("(//div[@automation-id='phonenumbers-listing']//tr[@automation-id='row_tv'])[1]");
    public static final By TelefonbuchEintragSO = By.xpath("//*[@automation-id='telefon_so']");
    public static final By TelefonbuchEintragAccTitle = By.xpath("//*[@automation-id='telefonbucheintrag_acc']/a/h4");
    public static final By TelefonbuchEintragSOTitle = By.xpath("//*[@automation-id='telefon_so']/smart-object-header/div/h3");
    public static final By TelefonbuchEintragAccText = By.xpath("//*[@automation-id='telefonbucheintrag_acc']/a/h5");
    public static final By TelefonbuchEintragSOText = By.xpath("//*[@automation-id='telefon_so']/smart-object-footer/div");
    //  public static final By TelefonbuchEintragAccContent = By.xpath("//*[@automation-id='phonenumbers-listing_desc_tv']");
    public static final By TelefonbuchEintragAccCol1 = By.xpath("//*[@id='telefonAccordionId']/div/telefon-accordion/div/div/div/vf-table/div/div/table/thead/tr/th[1]/div/span");
    public static final By TelefonbuchEintragAccCol2 = By.xpath("//*[@id='telefonAccordionId']/div/telefon-accordion/div/div/div/vf-table/div/div/table/thead/tr/th[2]/div/span");
    public static final By TelefonbuchEintragAccSubText = By.xpath("//*[@automation-id='phonenumbers-listing']//p");
    public static final By KontaktierUnsBitteLink = By.xpath("//*[@automation-id='phonenumbers-listing_desc_tv']/a");

    //Constructor

    public InternetAndPhone(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Keywords

    public InternetAndPhone openCard(InternetAndPhoneCards card) {
        switch (card) {
            case TELEPHONBUCHEINTRAG -> {
                driver.element().click( telefonbuchEintrag_card);
            }
        }
        return this;
    }

    public void clickOnTelefonbuchEintragAcc()
    { driver.element().click( TelefonbuchEintragSO);}

    public void clickOnTelefonbuchEintragBodyLink()
    { //driver.element().click( KontaktierUnsBitteLink);}
        driver.element().click(KontaktierUnsBitteLink ); }
    //Enums
    public enum InternetAndPhoneCards {
        TELEPHONBUCHEINTRAG
    }

    @Step ("Expand Internet & phone Accordion")
    public InternetAndPhone expandInternetAndPhoneAccordion() {
        (new ElementActions(driver.getDriver())).click(internetAndPhone_ACC);
        return new InternetAndPhone(driver);
    }
    @Step("Click on Mientariff SO")
    public InternetAndPhone openMeinInternetAndPhoneTariffPage() {
        (new ElementActions(driver.getDriver())).click(meinTariffSO);
        return new InternetAndPhone(driver);
    }
    @Step("Expand booked options accordion")
    public void  expandBookedOptionsAcc() {
        driver.element().click( bookedOptionsAcc);
    }
    @Step("Validation for priced booked options prices ")
    public void bookedOptionsPriceValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), bookedOptionPrice)
                .exists()
                .perform();
    }
    @Step("Validation for free booked options prices ")
    public void freeBookedOptionsPriceValidation(){
        Validations.assertThat()
                .element(driver.getDriver(),bookedOptionPriceFree)
                .exists()
                .perform();
    }

}
