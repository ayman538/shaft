package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class AddContractNumber {
    private SHAFT.GUI.WebDriver driver;

    private static By MobileNumber_inputField = By.xpath("//*[@automation-id='identifier_et']");
    private static By MobileNumberPassword_inputField = By.xpath("//*[@automation-id='password_et']");
    private static By next_button = By.xpath("//button[@class='btn btn-em btn-sml']");
    private static By save_button = By.xpath("//button[@class='btn btn-sml']");



    public AddContractNumber(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SubscriberConfirmation addSubscriberInfo(String number , String password) {
        (new ElementActions(driver.getDriver())).type(MobileNumber_inputField, number)
                .type(MobileNumberPassword_inputField,password)
                .click(next_button).click(save_button);
        return new SubscriberConfirmation(driver);
    }


}
