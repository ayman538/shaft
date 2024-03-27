package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TodayPage {
        private SHAFT.GUI.WebDriver driver;
        private By Header_Text = By.xpath("//div//h2[@class='h1']");
        private By TeaserHeader_Text = By.xpath("//div//h3[@automation-id='headline_id_tv']");
        private By TeaserSubHeader_Text = By.xpath("//div//p[@automation-id='just_text_id_tv']");
        private By TeaserAndroid_Btn = By.xpath("//a[@automation-id='btn_id_Link']");
        private By TeaserApple_Btn = By.xpath("//a[@automation-id='btn_id_1_Link']");


        //CLs
        private static String Header = "Richte Deinen Router ein";
        private static String TeaserHeader = "Alles im Griff mit der SuperConnect-App";
        private static String TeaserSubHeader = "App runterladen, MIC eingeben und Router verbinden. Schon bist Du online!\n" +
                "\n" +
                "Mit der App kannst Du: Dein WLAN mit Tipps optimieren, Geräte in Deinem Heimnetzwerk von überall aus im Blick behalten und vieles mehr.";
        private static String TeaserAndroid = "Zum Google Play Store";
        private static String TeaserApple = "Zum Apple App Store";

        public TodayPage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }

        @Step("Validate texts in Today comes the Technican case")
        public void validatePageTexts() {
            driver.verifyThat()
                    .element(Header_Text)
                    .text()
                    .isEqualTo(Header)
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


