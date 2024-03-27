package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Zusatzliche_SIM_Karte {
    
    public SHAFT.GUI.WebDriver driver;


    /*CLs*/

    public static String pageTitleCL = "Zusätzliche SIM-Karte";
    public static String pageSubTitleCL   = "Red+ member -5 (01520 048 88 50)";

    //"Vodafone-OneNumber" card
    private static String cardOneTitleCL = "Vodafone OneNumber";
    private static String cardOneBodyCL = "Bestell Dir hier Deine Vodafone OneNumber. Damit kannst Du Deine Rufnummer auch auf smarten Geräten, wie Deiner Smart Watch oder in Deinem Auto nutzen.";


    //"Red+ Partnerkarte" card
    private static String cardtwoTitleCL = "Red+ Partnerkarte";
    private static String cardTwoBodyCL = "Red+ Partner- und Zusatzkarten sind zusätzliche Handy-Verträge mit eigener Rufnummer. Du buchst sie zu Deinem Red-Tarif dazu.";

    //"Vodafone OneNumber Car" card
    private static String cardThreeTitleCL = "Vodafone OneNumber Car";
    private static String cardThreeBodyCL = "Bestell hier Deine Vodafone OneNumber Car. Damit kannst Du Deine Rufnummer und Dein Datenvolumen in Deinem Auto nutzen.";
    private static String cardThreeBodyCL1 = "Achtung: Überprüfe vorher, ob das in Deinem Auto funktioniert. Frag am besten Deinen Fahrzeughersteller.";
    //"Neuen Vertrag" card
    private static String cardFourTitleCL = "Neuer Vertrag";
    private static String cardFourBodyCL = "Schließe hier einen neuen Vertrag ab. So bekommst Du einen komplett neuen Vertrag mit neuer Rufnummer und neuen eSIMS zur Deiner freien Verfügung.";
    private static String notificationMsgTextCL = "Eine zusätzliche, kostenlose SIM-Karte bekommst Du hier: www.vodafone.de/freikarte/";
    private static String notificationMsgTitleCL = "Vodafone Freikarte";

    /*Locators*/

    private static final By pageTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private static final By pageSubTitle = By.xpath("//*[@automation-id='pageHeader_tv']//h2");
    private static final By cardFourBody = By.xpath("//*[@class='white-box mb-0']//p");
    private static final By cardFourTitle = By.xpath("//*[@class='white-box mb-0']//h4");
    private static final By cardThreeBody = By.xpath("(//*[@class='white-box']/p)[3]");
    private static final By cardThreeTitle = By.xpath("(//*[@class='white-box']/h4)[3]");
    private static final By cardTwoBody = By.xpath("(//*[@class='white-box']/p)[2]");
    private static final By cardTwoTitle = By.xpath("(//*[@class='white-box']/h4)[2]");
    private static final By cardOneTitle = By.xpath("(//*[@class='white-box']/h4)[1]");
    private static final By cardOneBody = By.xpath("(//*[@class='white-box']/p)[1]");
    private static final By firstCard_Btn = By.xpath("(//*[@class='white-box']/a)[1]");
    private static final By secondCard_Btn = By.xpath("(//*[@class='white-box']/a)[2]");
    private static final By thirdCard_Btn = By.xpath("(//*[@class='white-box']/a)[3]");
    private static final By fourthCard_Btn = By.xpath("//*[@class='white-box mb-0']//a");
    private static final By notificationMsg = By.xpath("//*[@automation-id='undefined_nt']");
    private static final By notificationMsgTitle = By.xpath("//*[@automation-id='undefined_nt']//h4");
    private static final By notificationMsgText = By.xpath("//*[@automation-id='undefined_nt']//p");

    //Constractor
    public Zusatzliche_SIM_Karte(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    /*Methods*/
   @Step("validate page title & Sup-title")
   public void validatePagetitle(){
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.pageSubTitle).exists();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.pageTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.pageTitleCL)
                .withCustomReportMessage("Verify Page Title")
                .perform();
    }
    @Step("validate Vodafone-OneNumber Card's content")
    public void validateVodafoneOneNumberCard(){
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardOneTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardOneTitleCL)
                .withCustomReportMessage("Verify First Tile Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardOneBody)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardOneBodyCL)
                .withCustomReportMessage("Verify First Tile Body")
                .perform();
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.firstCard_Btn).isEnabled();
    }
    @Step("validate Red+ Partner karte Card's content")
    public void validateRedPartnerkarteCard(){
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardTwoTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardtwoTitleCL)
                .withCustomReportMessage("Verify Second Tile Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardTwoBody)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardTwoBodyCL)
                .withCustomReportMessage("Verify Second Tile Body")
                .perform();
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.secondCard_Btn).isEnabled();
    }
    @Step("validate Vodafone One-Number Car Card's content")
    public void validateVodafoneOneNumberCarCard(){
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardThreeTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardThreeTitleCL)
                .withCustomReportMessage("Verify Third Tile Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardThreeBody)
                .text()
                .contains(Zusatzliche_SIM_Karte.cardThreeBodyCL)
                .withCustomReportMessage("Verify Third Tile Body")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardThreeBody)
                .text()
                .contains(Zusatzliche_SIM_Karte.cardThreeBodyCL1)
                .withCustomReportMessage("Verify Third Tile Body")
                .perform();
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.thirdCard_Btn).isEnabled();
    }
    @Step("validate Neuen Vertrag Card's content")
    public void validateNeuenVertragCard(){
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardFourTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardFourTitleCL)
                .withCustomReportMessage("Verify Fourth Tile Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.cardFourBody)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.cardFourBodyCL)
                .withCustomReportMessage("Verify Fourth Tile Body")
                .perform();
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.fourthCard_Btn).isEnabled();
    }

    @Step("validate Pre-paid users' notfication error Msg ")
    public void validatePreparidErrorMsg(){
        Validations.assertThat().element(driver.getDriver(), Zusatzliche_SIM_Karte.notificationMsg).exists();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.notificationMsgTitle)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.notificationMsgTitleCL)
                .withCustomReportMessage("Verify notification msg Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Zusatzliche_SIM_Karte.notificationMsgText)
                .text()
                .isEqualTo(Zusatzliche_SIM_Karte.notificationMsgTextCL)
                .withCustomReportMessage("Verify notification msg Title")
                .perform();
    }
    public void clickOnFirstCardButton(){
        driver.element().click( firstCard_Btn);
    }
    public void clickOnSecondCardButton(){driver.element().click( secondCard_Btn);}
        public void clickOnThirdCardButton(){driver.element().click( thirdCard_Btn);}
            public void clickOnFourthCardButton(){driver.element().click( fourthCard_Btn);}

}



