package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RequestActivationCodePageSuccessPage {
    private SHAFT.GUI.WebDriver driver;

    public RequestActivationCodePageSuccessPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By successMsgTitle = By.xpath("//h4[@class=\"flexDiv\"]");
    private By successMsgDescription = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private By successMsgLocator = By.xpath("//div[@class=\"alert noselect success\"]");

    private String successMsgTitleCL = "Vielen Dank!";
    private String successMsgDescriptionCL = "Du bekommst Deinen Aktivierungscode innerhalb von \n" +
            "5 Tagen mit der Post.";

    @Step("Verify Success Message page CLs")
    public void verifySuccessPageCLs() {
        driver.assertThat().element(successMsgTitle).text().isEqualTo(successMsgTitleCL);
        driver.assertThat().element(successMsgDescription).text().isEqualTo(successMsgDescriptionCL);
    }

    @Step("Validate Green Border is displayed")
    public RequestActivationCodePageSuccessPage validateGreenBorderIsDisplayed() {
        driver.assertThat()
                .element(successMsgLocator)
                .cssProperty("border-top-color")
                .contains("66, 125, 0")
                .perform();
        return this;
    }
}
