package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DidEveryThingWorkPage {
    private SHAFT.GUI.WebDriver driver;
    private By Header_Text = By.xpath("//div//h2[@class='page-headline']");
    private By FirstSubHeader_Text = By.xpath("//div//p[@class='mb-20 page-subHeadline']");
    private By SecondSubHeader_Text = By.xpath("//div//p[@class='mt-15 mb-20 page-subHeadline']");
    private By FirstButton_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-red']");
    private By SecondButton_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-alt pull-down gray-btn-on-focus']");


    //CLs
    public static String Header = "Hat alles geklappt?";
    public static String FirstSubHeader = "Wir haben Deinen Anschluss aktiviert. Zeit, den Router einzurichten!";
    public static String SecondSubHeader = "Der Technik-Service war nicht wie vereinbart da? Oder etwas anderes hat nicht geklappt? Dann klick bitte auf 'Es gibt ein Problem'. Wir helfen Dir!";
    public static String FirstButton = "Router einrichten";
    public static String SecondButton = "Es gab ein Problem";

    public DidEveryThingWorkPage(SHAFT.GUI.WebDriver driver) {
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
                .element(FirstSubHeader_Text)
                .text()
                .isEqualTo(FirstSubHeader)
                .perform();
        driver.verifyThat()
                .element(SecondSubHeader_Text)
                .text()
                .isEqualTo(SecondSubHeader)
                .perform();
        driver.verifyThat()
                .element(FirstButton_Btn)
                .text()
                .isEqualTo(FirstButton)
                .perform();
        driver.verifyThat()
                .element(SecondButton_Btn)
                .text()
                .isEqualTo(SecondButton)
                .perform();
    }
}
