package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class StartSoon {
    private SHAFT.GUI.WebDriver driver;
    private By Header_Text = By.xpath("//div//h2[@class='page-headline']");
    private By SubHeader_Text = By.xpath("//time-linecomponent/div/p[@class='mb-20 page-subHeadline']");
    private By Button_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-em mb-20']");

    //CLs
    public static String Header = "Bald geht's los!";
    public static String SubHeader = "Speicher Dir jetzt Deinen Termin im Kalender.";
    public static String Button = "Termin im Kalender speichern";


    public StartSoon(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate texts in the page")
    public void validateTexts() {
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .text()
                .isEqualTo(SubHeader)
                .perform();
       driver.verifyThat()
                .element(Button_Btn)
                .text()
                .isEqualTo(Button)
                .perform();
    }
}
