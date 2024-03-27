package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Kontostand {
    private SHAFT.GUI.WebDriver driver;

    private By noPaymentTypeNotificationHeader_Locator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By noPaymentTypeNotificationBody_Locator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By noPaymentTypeNotification = By.xpath("//div[@class='alert noselect inProgress']");

    public Kontostand(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }
    private String noPaymentTypeNotificationHeader_Cl = "Das hat leider nicht geklappt";
    private String noPaymentTypeNotificationBody_Cl = "Leider können wir Dir gerade keinen Kontostand zeigen. Entschuldige bitte. Alle Infos zu Deinen offenen Beträgen findest Du im Bereich Rechnungen.";

    public void assertOnPillCl(String order , String pillCL){
        driver.verifyThat().element(getPillOrder(order)).textTrimmed().isEqualTo(pillCL).withCustomReportMessage("assert on first pill 'collective products' CL").perform();
    }
    public void assertOnNoPaymentTypeNotification(){
        driver.verifyThat().element(noPaymentTypeNotificationHeader_Locator).textTrimmed().isEqualTo(noPaymentTypeNotificationHeader_Cl)
                .withCustomReportMessage("Assert on no payment type header Cl")
                .perform();
        driver.verifyThat().element(noPaymentTypeNotificationBody_Locator).textTrimmed().isEqualTo(noPaymentTypeNotificationBody_Cl)
                .withCustomReportMessage("Assert on no payment type body Cl")
                .perform();
    }
    private By getPillOrder(String order){
        return By.xpath("(//span[@class=\"ws10-filter-pill__item__text ws10-text ws10-spacing-0\"])["+order+"]");
    }
    public void assertThatFilterPillDoesNotExist(String order){
        driver.verifyThat().element(getPillOrder(order)).doesNotExist().withCustomReportMessage("assert that filter pill doesn't exist").perform();
    }
    public void assertThatFilterPillExists(String order){
        driver.verifyThat().element(getPillOrder(order)).exists().withCustomReportMessage("assert that  filter pill exists").perform();

    }

    public void assertOnNoPaymentTypeNotificationColor(){
        driver.verifyThat().element(noPaymentTypeNotification).cssProperty("background").contains("240, 247, 249")
                .withCustomReportMessage("Assert on no payment type notification color").perform();
    }
}
