package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DSL_MeineRechnungen {

    private SHAFT.GUI.WebDriver driver;

    public DSL_MeineRechnungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By accountBalanceCardTitle = By.xpath("(//div[@class='white-box']//h2[@class='sub-title'])[1]");
    public static By accountBalanceCardSubtitle = By.xpath("(//div[@class='invoice-history']//div[@class='date'])[1]");
    public static By accountBalanceCardNotificationTitle = By.xpath("(//div[@automation-id='successMsg_tv']//h4[@class='flexDiv'])[1]");
    public static By accountBalanceCardNotificationSubtitle = By.xpath("(//div[@automation-id='undefined_nt']//p[@class='notification-text mb-10 mt-10'])[1]");
    public static By accountBalanceCardPrice = By.xpath("(//h2[@class='amount sub-title'])[1]");
    public static By accountBalanceCardButton = By.xpath("//a[@automation-id='redirectBtn_Link']");
    public static By rechnungsubersichtAccordion = By.xpath("(//a[@class='ac-head'])[1]");


    //START_WFFT_4574
    @Step("Click on Rechnungsübersicht accordion")
    public DSL_MeineRechnungen clickOnRechnungsübersichtAccordion(){
        driver.element().click(rechnungsubersichtAccordion);
        return this;
    }
    @Step("Verify the account balance card in case of not eligible")
    public DSL_MeineRechnungen verifyAccountBalanceCardNotEligible(String title, String subtitle, String price){
        driver.verifyThat().element(accountBalanceCardTitle).textTrimmed().isEqualTo(title).perform();
        driver.verifyThat().element(accountBalanceCardSubtitle).textTrimmed().contains(subtitle).perform();
        driver.verifyThat().element(accountBalanceCardPrice).textTrimmed().contains(price).perform();
        return this;
    }

    @Step("Verify the account balance card in case of open account/due account")
    public DSL_MeineRechnungen verifyAccountBalanceCardOpenOrDue(String title, String subtitle, String notificationTitle, String notificationSubtitle, String price, String button){
        driver.verifyThat().element(accountBalanceCardTitle).textTrimmed().isEqualTo(title).perform();
        driver.verifyThat().element(accountBalanceCardSubtitle).textTrimmed().contains(subtitle).perform();
        driver.verifyThat().element(accountBalanceCardPrice).textTrimmed().contains(price).perform();
        driver.verifyThat().element(accountBalanceCardNotificationTitle).textTrimmed().contains(notificationTitle).perform();
        driver.verifyThat().element(accountBalanceCardNotificationSubtitle).textTrimmed().contains(notificationSubtitle).perform();
        driver.verifyThat().element(accountBalanceCardButton).textTrimmed().contains(button).perform();
        return this;
    }
    @Step("Click on account balance button")
    public KontostandPage clickOnAccountBalanceBtn(){
        driver.element().click(accountBalanceCardButton);
        return new KontostandPage(driver);
    }

}
