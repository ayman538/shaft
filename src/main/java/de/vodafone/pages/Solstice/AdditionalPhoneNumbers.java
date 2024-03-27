package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;

public class AdditionalPhoneNumbers {
    private SHAFT.GUI.WebDriver driver;

    private By PageHeader = By.xpath(" //div[@automation-id='pageHeader_tv']/h1");
    private By Stepper = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private By SectionTitle = By.xpath("//*[@automation-id='solsticeAdditionalNumberstv']");
    private By MobilePhone = By.xpath("//*[@automation-id='mobilePhonetv']");
    private By MobilePhoneNumber = By.xpath("//*[@automation-id='mobilePhoneNumbertv']");
    private By PrivatePhone = By.xpath("//*[@automation-id='privatePhonetv']");
    private By PrivatePhoneNumber = By.xpath("//*[@automation-id='privatePhoneNumbertv']");
    private By WorkPhone = By.xpath("//*[@automation-id='workPhonetv']");
    private By WorkPhoneNumber = By.xpath("//*[@automation-id='workPhoneNumbertv']");
    private By NoNumbersNot = By.xpath("//*[@class='alert-content no-head']/p");
    private By BackButton = By.xpath("//*[@automation-id='backtoAccountAccordionbtn']");

    private String PageHeaderCL="Gespeicherte Rufnummern";
    private String StepperCL ="Weitere Rufnummern";
    private String SectionTitleCL="Diese Rufnummern haben wir von Dir gespeichert:";
    private String MobilePhoneCL="Handy-Nummer:";
    private String PrivatePhoneCL="Private Rufnummer:";
    private String WorkPhoneCL="Andere Rufnummer:";
    private String NoNumbersNotCL="Wir haben momentan keine weiteren Rufnummern von Dir gespeichert.";
    private String BackButtonCL="Abbrechen";

    public AdditionalPhoneNumbers(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate CL for additional numbers page")
    public void ValidateCLForAdditionalNumbersPage(){
        driver.verifyThat().element(MobilePhone).text().isEqualTo(MobilePhoneCL).perform();
        driver.verifyThat().element(PrivatePhone).text().isEqualTo(PrivatePhoneCL).perform();
        driver.verifyThat().element(WorkPhone).text().isEqualTo(WorkPhoneCL).perform();
        driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeaderCL).perform();
        driver.verifyThat().element(Stepper).text().isEqualTo(StepperCL).perform();
        driver.verifyThat().element(SectionTitle).text().isEqualTo(SectionTitleCL).perform();
        driver.verifyThat().element(BackButton).text().isEqualTo(BackButtonCL).perform();
        driver.verifyThat().element(MobilePhoneNumber).isVisible().perform();
        driver.verifyThat().element(PrivatePhoneNumber).isVisible().perform();
        driver.verifyThat().element(WorkPhoneNumber).isVisible().perform();
    }
    @Step("Validate that only 2 additional numbers are displayed")
    public void Validate2AdditionalNumbers(){
        driver.verifyThat().element(MobilePhone).text().isEqualTo(MobilePhoneCL).perform();
        driver.verifyThat().element(PrivatePhone).text().isEqualTo(PrivatePhoneCL).perform();
        driver.verifyThat().element(MobilePhoneNumber).isVisible().perform();
        driver.verifyThat().element(PrivatePhoneNumber).isVisible().perform();
        driver.verifyThat().element(WorkPhone).doesNotExist().perform();
        driver.verifyThat().element(WorkPhoneNumber).doesNotExist().perform();
    }
    @Step("Validate Notification for no additional numbers available")
    public void ValidateNoAdditionalNumbersNotification(){
        driver.verifyThat().element(NoNumbersNot).text().isEqualTo(NoNumbersNotCL).perform();
        driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeaderCL).perform();
        driver.verifyThat().element(Stepper).text().isEqualTo(StepperCL).perform();
    }
    @Step("Click on back button and validate redirection")
    public void clickBackButton(){
        driver.element().click(BackButton);
        driver.verifyThat().element(By.xpath("//*[@id='manageAccountData']/li/a")).attribute("class").isEqualTo("ac-head ac-active");
    }
}