package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MergeAccounts2FABUC {
    private static SHAFT.GUI.WebDriver driver;

    public MergeAccounts2FABUC(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By sectionHeader = By.xpath("//h3[@automation-id='2FAsubheadertv']");
    private By text = By.xpath("//p[@automation-id='2FAheadertv']");
    private By method = By.xpath("//div[@class='cta-item']/span");
    private By twoFaButton = By.xpath("(//p[@automation-id='radioDescription_tv'])[1]");
    private By bucButton = By.xpath("(//p[@automation-id='radioDescription_tv'])[2]");

    private String pageHeaderCL = "Leg Deine Kundenkonten zusammen";
    private String sectionHeaderCL = "2-Faktor-Authentifizierung";
    private String textCL = "Bitte wähl eine Methode um Deine Kundenkonten zusammen zulegen.";
    private String methodCL = "Authentifizierungs-Methoden";
    private String twoFaButtonCL = "Authentifizierungs-App";
    private String bucButtonCL = "Backup-Code";

    public MergeAccounts2FABUC select2fa() {
        driver.element().click(twoFaButton);
        return this;
    }

    public MergeAccounts2FABUC selectBuc() {
        driver.element().click(bucButton);
        return this;
    }


    @Step("Verify page CL")
    public void verifyPageCL() {
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeaderCL).perform();
        driver.verifyThat().element(sectionHeader).text().isEqualTo(sectionHeaderCL).perform();
        driver.verifyThat().element(text).text().isEqualTo(textCL).perform();
        driver.verifyThat().element(method).text().isEqualTo(methodCL).perform();
        driver.verifyThat().element(twoFaButton).text().isEqualTo(twoFaButtonCL).perform();
        driver.verifyThat().element(bucButton).text().isEqualTo(bucButtonCL).perform();
    }

}
