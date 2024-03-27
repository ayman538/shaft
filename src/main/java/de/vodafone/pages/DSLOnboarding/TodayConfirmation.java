package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TodayConfirmation {
    private SHAFT.GUI.WebDriver driver;
    private By Header_Text = By.xpath("//div//h2[@class='page-headline']");
    private By SubHeader_Text = By.xpath("//div//p[@class='mb-20 page-subHeadline']");
    private By Whitebutton_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-alt pull-down gray-btn-on-focus']");
    private By Redbutton_Btn = By.xpath("//div//button[@class='btn btn-rectangle btn-red']");

    //CLs
    private static String Header = "Heute ist es soweit";
    private static String SubHeader = "Sobald der Techniker bei Dir war, funktioniert das Internet.";
    private static String Whitebutton = "Es gab ein Problem";
    private static String Redbutton = "Router einrichten";

    public TodayConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clink on the Red Button")
    public TodayPage ClickOnRedBtn() {
        driver.element().click(Redbutton_Btn);
        return new TodayPage(driver);
    }
    @Step("Validate texts in Today confirmation page")
    public void validatePageTexts() {
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
                .element(Whitebutton_Btn)
                .text()
                .isEqualTo(Whitebutton)
                .perform();
        driver.verifyThat()
                .element(Redbutton_Btn)
                .text()
                .isEqualTo(Redbutton)
                .perform();
    }


}
