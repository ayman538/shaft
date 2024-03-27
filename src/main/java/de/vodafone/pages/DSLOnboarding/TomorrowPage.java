package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TomorrowPage {
    private SHAFT.GUI.WebDriver driver;
    private By SelfHeader_Text = By.xpath("//div//h2[@class='page-headline']");
    private By SubHeader_Text = By.xpath("//div//p[@class='mb-20 page-subHeadline']");
    private By TechHeader_Text = By.xpath("//div//h2[@class='page-headline']");
    private By Termin_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-em mb-40']");
    private By TeaserHeader_Text = By.xpath("//div//h3[@automation-id='headline_id_tv']");
    private By TeaserSubHeader_Text = By.xpath("//div//p[@automation-id='just_text_id_tv']");
    private By TeaserAndroid_Btn = By.xpath("//a[@automation-id='btn_id_Link']");
    private By TeaserApple_Btn = By.xpath("//a[@automation-id='btn_id_1_Link']");


    //CLs
    private static String SelfHeader = "Morgen ist es soweit";
    private static String SubHeader = "Du kannst Deinen Termin jetzt nicht mehr ändern. Denn die Telekom braucht 3 Werktage, um die Routen der Techniker zu planen.";
    private static String TechHeader = "Morgen ist es soweit";
    private static String TerminBtn = "Termin im Kalender speichern";
    private static String TeaserHeader = "Alles im Griff mit der SuperConnect-App";
    private static String TeaserSubHeader = "App runterladen, MIC eingeben und Router verbinden. Schon bist Du online!\n" +
            "\n" +
            "Mit der App kannst Du: Dein WLAN mit Tipps optimieren, Geräte in Deinem Heimnetzwerk von überall aus im Blick behalten und vieles mehr.";
    private static String TeaserAndroid = "Zum Google Play Store";
    private static String TeaserApple = "Zum Apple App Store";



    public TomorrowPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate texts in Tomorrow comes the Technican selfinstall case")
    public void validateSelfinstallTexts() {
        driver.verifyThat()
                .element(SelfHeader_Text)
                .text()
                .isEqualTo(SelfHeader)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .text()
                .isEqualTo(SubHeader)
                .perform();
        driver.verifyThat()
                .element(Termin_Btn)
                .text()
                .isEqualTo(TerminBtn)
                .perform();
    }
    @Step("Validate texts in Tomorrow comes the Technican Techinstall case")
    public void validateTechinstallTexts() {
        driver.verifyThat()
                .element(TechHeader_Text)
                .text()
                .isEqualTo(TechHeader)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .text()
                .isEqualTo(SubHeader)
                .perform();
        driver.verifyThat()
                .element(Termin_Btn)
                .text()
                .isEqualTo(TerminBtn)
                .perform();
    }
    @Step("Validate texts in SuperConnected Teaser")
    public void validateSuperConnectedTeaserTexts() {
        driver.verifyThat()
                .element(TeaserHeader_Text)
                .text()
                .isEqualTo(TeaserHeader)
                .perform();
        driver.verifyThat()
                .element(TeaserSubHeader_Text)
                .text()
                .isEqualTo(TeaserSubHeader)
                .perform();
        driver.verifyThat()
                .element(TeaserAndroid_Btn)
                .text()
                .isEqualTo(TeaserAndroid)
                .perform();
        driver.verifyThat()
                .element(TeaserApple_Btn)
                .text()
                .isEqualTo(TeaserApple)
                .perform();

    }
}
