package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopUp {
    SHAFT.GUI.WebDriver driver;

    public TopUp(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By direktAufladen_Card = By.xpath("(//div[@automation-id='undefined_rb'])[1]");
    private By callNowAufladung_Card = By.xpath("(//div[@automation-id='undefined_rb'])[2]");

    private By automatischeAufladung_Card = By.xpath("(//div[@automation-id='undefined_rb'])[3]");
    private By automatischeAufladung_Tile = By.xpath("//input[@value='Automatische Aufladung']");
    private static By einmaligeDirektaufladungTile = By.xpath("//input[@id='Einmalige Direktaufladung']");
    public TopUp waitForSpecifiedTime(int Duration) {
        try{
            Thread.sleep(Duration);
        }catch (Exception e){

        }
        return this;
    }
    @Step("Click on einmalige Direktaufladung Tile")
    public TopUp clickOnEinmaligeDirektaufladungTile() {
        waitForSpecifiedTime(5000);
        driver.element().click(einmaligeDirektaufladungTile);
        return this;
    }

    @Step("Click on Direkt Aufladen Tile")
    public TopupGPP clickDirektAufladen() {
        driver.element().click(direktAufladen_Card);
        return new TopupGPP(driver);
    }

    @Step("Click on Automatische Aufladung Tile")
    public TopupGPP clickAutomatischeAufladung() {
        driver.element().click(automatischeAufladung_Card);
        return new TopupGPP(driver);
    }

    @Step("Assert That Einmalige Direktaufladung Tile Exists")
    public void assertOnEinmaligeDirektaufladungTileExists() {
      driver.verifyThat().element(direktAufladen_Card)
                .exists()
                .perform();
    }
    @Step("Assert That CallNow Aufladung Tile Exists")
    public void assertOnCallNowAufladungExists() {
        driver.verifyThat().element(callNowAufladung_Card)
                .exists()
                .perform();
    }
    @Step("Assert That Automatische Aufladung Tile does not Exist")
    public void assertThatAutomatischeAufladungDoesNotExist() {
        driver.verifyThat().element(automatischeAufladung_Tile).doesNotExist()
                .perform();

    }





}
