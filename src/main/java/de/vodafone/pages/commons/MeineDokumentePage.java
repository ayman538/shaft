package de.vodafone.pages.commons;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineDokumentePage {
    private SHAFT.GUI.WebDriver driver;

    public MeineDokumentePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By dummyLocator = By.xpath("");
    private By exitIcon = By.xpath("//button[@class='nsm-dialog-btn-close']");
    public By getPreviewBillLocator(String billRow){
        return By.xpath("(//div[@class='tooltip-hover'])["+billRow+"]");
    }

    public By getDownloadBillLocator(String billRow){
        return By.xpath("(//button[@automation-id='documentsInboxes_download_btn'])["+billRow+"]");
    }

    //CLs


    //Methods
    /* *************** WFCT_14089 **************** */
    @Step("Click On Preview Bill By Its Order")
    public void clickOnPreviewBillByOrder(String billRowOrder){
        driver.element().click(getPreviewBillLocator(billRowOrder));
    }

    @Step("Click On Download Customer Bill By Its Order")
    public void clickOnDownloadBillByOrder(String billRowOrder){
        driver.element().click(getDownloadBillLocator(billRowOrder));
    }

    @Step("Click On Exit Button")
    public void clickOnExitPreviewingBill(){
        driver.element().click(exitIcon);
    }

    public void assertThatPreviewingTagsIsReturned(){
        driver.verifyThat().element(dummyLocator).doesNotExist()
                .withCustomReportMessage("Assert That Previewed Tracking is returned Successfullty").perform();
    }

}
