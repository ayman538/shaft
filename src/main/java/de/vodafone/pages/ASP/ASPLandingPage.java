package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ASPLandingPage {
    private SHAFT.GUI.WebDriver driver;

    //constructor
    public ASPLandingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //variables
    private String youtubeLink = "https://www.youtube.com/embed/bRo3oSy0DJs?start=54";


    //locators

    //Kabel
    private By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private By LPTitle = By.xpath("//*[@class='brix-promo-teaser__headline brix-h1style']");
    private By UserQuestion = By.xpath("//*[@automation-id='WhichProductTitle_tv']");
    private By LPFooter = By.xpath("//*[@automation-id='link_video_tv']");
    private By LPFooter1 = By.xpath("//*[@automation-id='FooterBoxHeadline_tv']");
    private By LPFooter2 = By.xpath("//*[@automation-id='FooterBoxSubheadline_tv']");
    private By LPFooter3 = By.xpath("//*[@automation-id='FooterBoxBody_tv']");
    private By MobilfunkTile = By.xpath("//input[@value='mobile']//parent::div");
    private By AccessoriesTile = By.xpath("//*[@automation-id='LandingPageWhichProductOptionsPicker_container']/div/div[2]");
    private By DSLTile = By.xpath("//input[@value='dsl']//parent::div");
    private By KabelTile = By.xpath("//input[@value='kabel']//parent::div");
    private By Question1Answer1Tile = By.xpath("(//*[@automation-id='Identify_User_container'])[1]/div/div[1]");
    private By Question1Answer2Tile = By.xpath("(//*[@automation-id='Identify_User_container'])[1]/div/div[2]");
    private By Question2Answer1Tile = By.xpath("(//*[@automation-id='undefined_container'])[2]/div/div[1]");
    private By Question2Answer2Tile = By.xpath("(//*[@automation-id='undefined_container'])[2]/div/div[2]");
    private By Question2Answer3Tile = By.xpath("(//*[@automation-id='undefined_container'])[2]/div/div[3]");

    private By MobilfunkTileTitle = By.xpath("//*[@automation-id='LandingPageWhichProductOptionsPicker_container']/div/div[1]/label/span");
    private By AccessoriesTileTitle = By.xpath("//*[@automation-id='LandingPageWhichProductOptionsPicker_container']/div/div[2]/label/span");
    private By DSLTileTitle = By.xpath("//*[@automation-id='LandingPageWhichProductOptionsPicker_container']/div/div[3]/label/span");
    private By KabelTileTitle = By.xpath("//*[@automation-id='LandingPageWhichProductOptionsPicker_container']/div/div[4]/label/span");
    private By Question1 = By.xpath("//*[@automation-id='main-headline-whichState-customer-exist_tv']");
    private By Question2 = By.xpath("//*[@automation-id='sub-headline-customer-process_tv']");
    private By Question1Answer1 = By.xpath("//*[@automation-id='Identify_User_container']/div/div[1]/label/span");
    private By videoLinkKabel = By.xpath("//*[@automation-id='link_video_tv']/p/a");
    private By videoLinkDSL = By.xpath("//*[@id='dynamicQuestionContainerDSL']/div/p/a");
    private By Question1Answer2 = By.xpath("//*[@automation-id='Identify_User_container']/div/div[2]/label/span");
    private By Question2AAnswer1 = By.xpath("//*[@automation-id='Process_UM_container']/div/div[1]/label/span");
    private By Question2AAnswer2 = By.xpath("//*[@automation-id='Process_UM_container']/div/div[2]/label/span");
    private By Question2AAnswer3 = By.xpath("//*[@automation-id='Process_UM_container']/div/div[3]/label/span");
    private By Question2BAnswer1 = By.xpath("//*[@automation-id='Process_KB_container']/div/div[1]/label/span");
    private By Question2BAnswer2 = By.xpath("//*[@automation-id='Process_KB_container']/div/div[2]/label/span");
    private By Question2BAnswer3 = By.xpath("//*[@automation-id='Process_KB_container']/div/div[3]/label/span");
    private By LoginHeader = By.xpath("//*[@automation-id='header_tv']");
    private By LoginSubHeader = By.xpath("//*[@automation-id='subHeader_tv']");
    private By DeliveryNumberTitle = By.xpath("(//*[@class='mt-60'])[1]/text/div/div[1]/label");
    private By DeliveryNumberTextBox = By.xpath("//*[@automation-id='deliveryNumber_et']");
    private By ZipcodeTitle = By.xpath("(//*[@class='mt-60'])[2]/text/div/div[1]/label");
    private By ZipcodeTextBox = By.xpath("//*[@automation-id='zipCode_et']");
    private By LoginButton = By.xpath("//*[@automation-id='loginBtn_btn']");
    private By OverviewPageHeader = By.xpath("//*[text()='Vodafone Retouren-Portal']");

    //DSL

    private By question1Answer1DSL = By.xpath("(//span[@class='brix-option-picker__text-value'])[1]");
    private By question1Answer2DSL = By.xpath("(//span[@class='brix-option-picker__text-value'])[2]");
    private By question1Answer3DSL = By.xpath("(//span[@class='brix-option-picker__text-value'])[3]");
    private By question2Answer1DSL = By.xpath("(//span[@class='brix-option-picker__text-value'])[4]");
    private By question2Answer2DSL = By.xpath("(//span[@class='brix-option-picker__text-value'])[5]");

    private By question1DSL = By.xpath("//*[@automation-id='main-headline-whichState-customer-exist_tv']");
    private By question2DSL = By.xpath("//*[@automation-id='sub-headline-customer-process_tv']");
    private By question1DSLDesc = By.xpath("(//p[@class='noBold'])[1]");
    private By question2DSLDesc = By.xpath("//p[@class='text-center']");
    private By securitylink = By.xpath("//a[@automation-id='requestId_Input_Link']");
    private By mVLoginTitle = By.xpath("//div[@class='content-wrap']/h1");
    private By logindatenHeader = By.xpath("//h2[@class='header']");

    //CLs
    private String LPTitleCL = "Retouren-Portal";
    private String UserQuestionCL = "Um welches Produkt geht's?";
    private String LPSubTitleCL2 = "Die erste Lieferung für Mobilfunk, DSL oder ein Gerät ohne Vertrag hat nicht geklappt? Auch dafür bist Du hier richtig: Wir senden's nochmal.";
    private String MobilfunkTileTitleCL = "Mobilfunk & GigaCube";
    private String AccessoriesTileTitleCL = "Gerät ohne Vertrag";
    private String DSLTileTitleCL = "DSL: Internet & Festnetz";
    private String KabelTileTitleCL = "Kabel: Internet, Festnetz & TV";
    private String Question1CL = "Wo wohnst Du?";
    private String Question2CL = "Was möchtest Du machen?";
    private String Question1Answer1CL = "NRW, Baden-Württemberg oder Hessen";
    private String Question1Answer2CL = "Andere Bundesländer";
    private String Question2Answer1CL = "Ich möchte meinen Vertrag widerrufen und mein Gerät zurückschicken.";
    private String Question2Answer2CL = "Ich möchte meinen bestehenden Vertrag kündigen.";
    private String Question2Answer3CL = "Ich habe bereits gekündigt und möchte mein Gerät zurückschicken.";
    private String LoginHeaderCL = "Einloggen und Rücksende-Unterlagen erhalten";
    private String LoginSubHeaderCL = "Du hast Deine Bestellung erhalten? Dann logg Dich hier ein, um den Retourenschein oder den QR-Code für Deine Rücksendung zu bekommen.";
    private String DeliveryNumberTitleCL = "Rufnummer oder Lieferscheinnummer *";
    private String ZipcodeTitleCL = "Postleitzahl *";
    private String OverviewPageHeaderCL = "Vodafone Retouren-Portal";
    private String LPFooterCL = "Kündigung oder widerruf?\n" +
            "Woran Du das ekennst, siehst Du in unserem Video. Das Video findest Du hier.\n" +
            "\n" +
            "So geht’s auch : Verträge hier kündigen";
    private String LPFooter1CL = "Du bist Dir nicht sicher, welches Produkt Du hast?";
    private String LPFooter2CL = "Kabel oder DSL?";
    private String LPFooter3CL = "Woran Du das erkennst, siehst Du in unserem Video. Das Video findest Du hier.\n" +
            "Du hast mehrere Produkte von uns? Nutz das Retouren-Portal bitte für jedes separat.";

    private String mVLoginTitle_CL = "Willkommen bei MeinVodafone";
    //DSL

    private String question1CL = "Was willst Du machen?";
    private String question2CL = "Wie willst Du fortfahren?";
    private String revocationVsTermination = "Kündigung oder widerruf?\n" +
            "Woran Du das ekennst, siehst Du in unserem Video. Das Video findest Du hier.";
    private String question2description = "Kein Gerät von uns? Dann fahre bitte mit “ohne Portal-Loggin” fort.";
    private String question1Answer1CL = "Vertrag widerrufen: Meinen neuen Vertrag innerhalb der 14-tägigen Frist widerrufen";
    private String question1Answer2CL = "Vertrag kündigen: Meinen Vertrag zum Vertragsende kündigen";
    private String question1Answer3CL = "Gerät zurücksenden: Ich wurde darüber Informiert, mein Gerät zurückzusenden";
    private String question2Answer1CL = "mit Portal-Login";
    private String question2Answer2CL = "ohne Portal-Login";
    private String securitylinkCL = "Hier findest Du Deine Login-Daten.";
    private String LoginDatenCL = "Hier findest Du Deine Login-Daten";

    public ASPLandingPage acceptCookies() {
        driver.element().click(acceptCookies_button);
        return this;
    }

    public ASPLandingPage navigate(String environment) {
        String pagePath = "retoure/landing-page";
        String url = "";
        String urlAfterRedirection = "";
        switch (environment) {
            case "ST" -> {
                url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
                urlAfterRedirection = url;
            }
            case "SIT" -> {
                url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
                urlAfterRedirection = url;
            }
        }
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public ASPLandingPage setCookie(HashMap<String, String> cookieMap) {
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Cookie cookie = new Cookie(key, value);
            driver.getDriver().manage().addCookie(cookie);
        }
        driver.browser().refreshCurrentPage();
        JavaScriptWaitManager.waitForLazyLoading();
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                SHAFT.Validations.assertThat().forceFail().withCustomReportMessage("Cookie Switcher Branch is not found, please validate with the dev team").perform();
            } catch (AssertionError e) {
                Assert.fail("Cookie Switcher Branch is not found, please validate with the dev team");
            }
        }
        return this;
    }

    //Clicks
    public ASPLandingPage ClickMobileTile() {
        driver.element().click(MobilfunkTile);
        return this;
    }

    public ASPLandingPage CLickAccessoriesTile() {
        driver.element().click(AccessoriesTile);
        return this;
    }

    public ASPLandingPage ClickDSLTile() {
        driver.element().click(DSLTile);
        return this;
    }

    public ASPLandingPage ClickKableTile() {
        driver.element().click(KabelTile);
        return this;
    }

    public ASPLandingPage ClickQuestion1Answer1() {
        driver.element().click(Question1Answer1);
        return this;
    }

    public ASPLandingPage ClickOnKabelVideoLink() {
        driver.element().click(videoLinkKabel);
        return this;
    }

    public ASPLandingPage ClickOnDSLVideoLink() {
        driver.element().click(videoLinkDSL);
        return this;
    }

    public ASPLandingPage ClickQuestion1Answer2() {
        driver.element().click(Question1Answer2);
        return this;
    }

    public ASPLandingPage clickDSLrevoke() {
        driver.element().click(DSLTile).click(question1Answer1DSL);
        return this;
    }

    public ASPLandingPage clickDSLTerminate() {
        driver.element().click(question1Answer2DSL);
        return this;
    }

    public ASPLandingPage clickDSLReturnDevice() {
        driver.element().click(question1Answer3DSL);
        return this;
    }

    public ASPLandingPage clickDSLlogin() {
        driver.element().click(question2Answer1DSL);
        return this;
    }


    //Kabel Personas
    @Step("Select User type Giraffe")
    public ASPResonsofRevocationPage GiraffeUser() {
        driver.element().click(KabelTile).click(Question1Answer1).click(Question2AAnswer1);
        return new ASPResonsofRevocationPage(driver);
    }

    @Step("Select User type Camel")
    public ASPResonsofRevocationPage CamelUser() {
        driver.element().click(KabelTile).click(Question1Answer2).click(Question2BAnswer1);
        return new ASPResonsofRevocationPage(driver);
    }

    @Step("Select User type Deer")
    public ASPTerminationPage DeerUser() {
        driver.element().click(KabelTile).click(Question1Answer1).click(Question2AAnswer2);
        return new ASPTerminationPage(driver);
    }

    @Step("Select User type Fox")
    public ASPTerminationPage FoxUser() {
        driver.element().click(KabelTile).click(Question1Answer2).click(Question2BAnswer2);
        return new ASPTerminationPage(driver);
    }

    @Step("Select User type Cheetah")
    public ASPReturnForm CheetahUser() {
        driver.element().click(KabelTile).click(Question1Answer1).click(Question2AAnswer3);
        return new ASPReturnForm(driver);
    }


    // DSL personas

    @Step("Select User type Buffalo")
    public ASPLandingPage buffaloUser() {
        driver.element().click(DSLTile).click(question1Answer1DSL).click(question2Answer2DSL);
        return this;
    }

    @Step("Select User type Moose")
    public ASPLandingPage mooseUser() {
        driver.element().click(DSLTile).click(question1Answer2DSL).click(question2Answer2DSL);
        return this;
    }

    @Step("Select User type Dolphin")
    public ASPLandingPage dolphinUser() {
        driver.element().click(DSLTile).click(question1Answer3DSL);
        return this;
    }

    //login
    public void loginAction(String deliveryNumber, String Zipcode) {
        driver.element().type(DeliveryNumberTextBox, deliveryNumber);
        driver.element().typeSecure(ZipcodeTextBox, Zipcode);
        driver.element().click(LoginButton);
    }

    //Validations
    @Step("Validate question 1 answers")
    public void Question1Validations() {
        driver.verifyThat().element(Question1).text().isEqualTo(Question1CL).perform();
        driver.verifyThat().element(Question1Answer1).text().isEqualTo(Question1Answer1CL).perform();
        driver.verifyThat().element(Question1Answer2).text().isEqualTo(Question1Answer2CL).perform();
    }

    @Step("Validate question 2A answers")
    public void Question2AValidations() {
        driver.verifyThat().element(Question2).text().isEqualTo(Question2CL).perform();
        driver.verifyThat().element(Question2AAnswer1).textTrimmed().isEqualTo(Question2Answer1CL).perform();
        driver.verifyThat().element(Question2AAnswer2).text().isEqualTo(Question2Answer2CL).perform();
        driver.verifyThat().element(Question2AAnswer3).text().isEqualTo(Question2Answer3CL).perform();
    }

    @Step("Validate question 2B answers")
    public void Question2BValidations() {
        driver.verifyThat().element(Question2).text().isEqualTo(Question2CL).perform();
        driver.verifyThat().element(Question2BAnswer1).text().isEqualTo(Question2Answer1CL).perform();
        driver.verifyThat().element(Question2BAnswer2).text().isEqualTo(Question2Answer2CL).perform();
        driver.verifyThat().element(Question2BAnswer3).text().isEqualTo(Question2Answer3CL).perform();
    }

    @Step("Validate login section")
    public void LoginSectionValidations() {
        driver.verifyThat().element(LoginHeader).textTrimmed().isEqualTo(LoginHeaderCL).perform();
        driver.verifyThat().element(LoginSubHeader).textTrimmed().isEqualTo(LoginSubHeaderCL).perform();
        driver.verifyThat().element(DeliveryNumberTitle).textTrimmed().isEqualTo(DeliveryNumberTitleCL).perform();
        driver.verifyThat().element(ZipcodeTitle).textTrimmed().isEqualTo(ZipcodeTitleCL).perform();
    }

    @Step("Verify navigation to overview page after login")
    public void LoginActionVerification() {
        driver.verifyThat().element(OverviewPageHeader).isVisible();
    }

    @Step("Validate Landingpage CL")
    public void LandingpageCLValidations() {
        driver.verifyThat().element(LPTitle).text().isEqualTo(LPTitleCL).perform();
        driver.verifyThat().element(UserQuestion).text().isEqualTo(UserQuestionCL).perform();
        driver.verifyThat().element(LPFooter1).text().isEqualTo(LPFooter1CL).perform();
        driver.verifyThat().element(LPFooter2).text().isEqualTo(LPFooter2CL).perform();
        driver.verifyThat().element(LPFooter3).text().isEqualTo(LPFooter3CL).perform();
    }

    @Step("Validate Landingpage CL")
    public void LandingpageNewCLValidations() {
        driver.verifyThat().element(LPTitle).textTrimmed().isEqualTo(LPTitleCL).perform();
        driver.verifyThat().element(UserQuestion).textTrimmed().isEqualTo(UserQuestionCL).perform();
        driver.verifyThat().element(LPFooter).textTrimmed().isEqualTo(LPFooterCL).perform();
    }

    @Step("Validate Tiles CL")
    public void TilesValidations() {
        driver.verifyThat().element(MobilfunkTileTitle).text().isEqualTo(MobilfunkTileTitleCL).perform();
        driver.verifyThat().element(DSLTileTitle).text().isEqualTo(DSLTileTitleCL).perform();
        driver.verifyThat().element(KabelTileTitle).text().isEqualTo(KabelTileTitleCL).perform();
        driver.verifyThat().element(AccessoriesTileTitle).text().isEqualTo(AccessoriesTileTitleCL).perform();
    }

    @Step("Validate deeplink for UM user")
    public void UMDeeplinkValidation() {
        driver.verifyThat().element(Question1Answer1Tile).attribute("class").isEqualTo("brix-option-picker__item brix-option-picker__item--checked").perform();
    }

    @Step("Validate deeplink for KD user")
    public void KDDeeplinkValidation() {
        driver.verifyThat().element(Question1Answer2Tile).attribute("class").isEqualTo("brix-option-picker__item brix-option-picker__item--checked").perform();
    }

    //DSL Validation
    @Step("Validate question 1 answers for DSL Users")
    public void question1ValidationsDSL() {
        driver.verifyThat().element(question1DSL).textTrimmed().isEqualTo(question1CL).perform();
        driver.verifyThat().element(question1Answer1DSL).textTrimmed().isEqualTo(question1Answer1CL).perform();
        driver.verifyThat().element(question1Answer2DSL).textTrimmed().isEqualTo(question1Answer2CL).perform();
        driver.verifyThat().element(question1Answer3DSL).textTrimmed().isEqualTo(question1Answer3CL).perform();
    }

    @Step("Validate question 1 answers for DSL Users")
    public void question2ValidationsDSL() {
        driver.verifyThat().element(question2DSL).textTrimmed().isEqualTo(question2CL).perform();
        driver.verifyThat().element(question2DSLDesc).textTrimmed().isEqualTo(question2description).perform();
        driver.verifyThat().element(question2Answer1DSL).textTrimmed().isEqualTo(question2Answer1CL).perform();
        driver.verifyThat().element(question2Answer2DSL).textTrimmed().isEqualTo(question2Answer2CL).perform();
    }

    @Step("Validate Mienvodafone login page header")
    public void mvValidation() {
        driver.verifyThat().element(mVLoginTitle).textTrimmed().isEqualTo(mVLoginTitle_CL).perform();
    }

    @Step("Validate Youtube URL")
    public void youtubeValidation() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().browser().url().contains(youtubeLink).perform();
    }

    @Step("Validate Youtube URL not exist")
    public void youtubeNotExistValidation() {
        driver.assertThat().element(videoLinkKabel).doesNotExist().perform();
    }
}