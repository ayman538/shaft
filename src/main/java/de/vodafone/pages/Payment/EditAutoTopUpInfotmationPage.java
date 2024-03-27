package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditAutoTopUpInfotmationPage {
    SHAFT.GUI.WebDriver driver;
    public EditAutoTopUpInfotmationPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
    private static By amountDropDownLocator = By.xpath("(//div[@class='fm-select multi-tag-select'])/button");
    private static By chooseAmountFromDropDownLocator = By.xpath("(//div/ul//li[@id='option_child'])[3]");
    private static By saveButtonLocator = By.xpath("//button[@class='btn btn-sml skiphash']");
    private static By confirmationMessageHeadlineLocator = By.xpath("//div[@class='alert noselect success']/div/div/div[2]/h4");
    private static By confirmationBodyMessageSublineLocator = By.xpath("//div[@class='alert noselect success']/div/p");
    private static By autoTopUpChangeAmountLocator = By.xpath("(//div[@class='mb-10'])[2]//span");
    private static By autoTopUpChangeStatusLocator = By.xpath("(//div[@class='mb-10 secodary-orange'])//span");
    //CL
    private String confirmationMessageHeadline_CL = "Erledigt!";
    private String confirmationBodyMessageSubline_CL = "Wir haben die automatische Aufladung bearbeitet.";
    private String autoTopUpChangeAmountCL = "15 €";
    private String autoTopUpChangeStatusCL = "pausiert";

    public EditAutoTopUpInfotmationPage clickDropDown()
    {
        driver.element().click(amountDropDownLocator);
        return this;
    }
    public EditAutoTopUpInfotmationPage chooseAmountFromDropDown()
    {
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseAmountFromDropDownLocator)).click();
        return this;
    }
    public EditAutoTopUpInfotmationPage clickSaveButton()
    {
        driver.element().click(saveButtonLocator);
        return this;
    }
    public void assertOnConfirmationMessageHeadline()
    {
        Validations.assertThat().element(driver.getDriver(),confirmationMessageHeadlineLocator)
                .text().isEqualTo(confirmationMessageHeadline_CL).perform();
    }
    public void assertOnConfirmationBodyMessageSubline()
    {
        Validations.assertThat().element(driver.getDriver(),confirmationBodyMessageSublineLocator)
                .text().isEqualTo(confirmationBodyMessageSubline_CL).perform();
    }
    public void checkAutoTopUpChangeAmountCL()
    {
        Validations.assertThat().element(driver.getDriver(),autoTopUpChangeAmountLocator)
                .text().isEqualTo(autoTopUpChangeAmountCL).perform();
    }
    public void checkAutoTopUpChangeStatusCL()
    {
        Validations.assertThat().element(driver.getDriver(),autoTopUpChangeStatusLocator)
                .text().isEqualTo(autoTopUpChangeStatusCL).perform();
    }
}