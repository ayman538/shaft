package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.Solstice.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountManagementPage {
    private SHAFT.GUI.WebDriver driver;

    private By manageAccountSO = By.xpath("//div[@automation-id='manageAccountData_so']");
    private By manageContractSubscriptionsSO = By.xpath("//div[@automation-id='manageContractsSubscriptions_so']");
    private By addContractSO = By.xpath("//div[@automation-id='addContract_so']");
    private By otherAdminSO = By.xpath("//div[@automation-id='similarAccounts_so']");
    private By mergeAccountsSO = By.xpath("//div[@automation-id='mergeAccounts_so']");
    private By nextSOButton = By.xpath("//a[@class='bx-next']");

    private By loginDataHeader = By.xpath("//h4[@automation-id='loginDataHeader_tv']");
    private By recoveryDataHeader = By.xpath("//h4[@automation-id='recoveryHeadline_tv']");
    private By personalDataHeader = By.xpath("//h4[@automation-id='personalData_tv']");
    private By accountHandlingHeader = By.xpath("//h4[@automation-id='deleteAccountHeadline_tv']");
    private By username = By.xpath("//p[@automation-id='userName_tv']");
    private By password = By.xpath("//p[@automation-id='changePasswordHeader_tv']");
    private By number = By.xpath("//div[@automation-id='phoneNumberLabel_tv']");
    private By email = By.xpath("//strong[@automation-id='availableEmailHeader_tv']");
    private By nameAndTitle = By.xpath("//p[@automation-id='nameAndTitle_tv']");

    private By changeUsernameButton = By.xpath("//a[@automation-id='navigateToChangeUserName_Link']");
    private By changePasswordButton = By.xpath("//a[@automation-id='navigateToChangePassword_Link']");
    private By changePersonalDataButton = By.xpath("//button[@automation-id='goChangePersonalData_btn']");
    private By deleteAccountButton = By.xpath("//button[@automation-id='goDeleteVodafoneAccount_btn']");


    public AccountManagementPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    @Step("Validate that all smart objects are displayed")
    public void smartObjectsValidation(){
        driver.verifyThat().element(manageAccountSO).exists().perform();
        driver.verifyThat().element(manageContractSubscriptionsSO).exists().perform();
        driver.verifyThat().element(addContractSO).exists().perform();
        driver.verifyThat().element(otherAdminSO).exists().perform();
        driver.verifyThat().element(mergeAccountsSO).exists().perform();
    }

    @Step("Verify that all sections are displayed in new sections")
    public void LoginDataAccordionValidations(){
        driver.verifyThat().element(loginDataHeader).exists().perform();
        driver.verifyThat().element(recoveryDataHeader).exists().perform();
        driver.verifyThat().element(personalDataHeader).exists().perform();
        driver.verifyThat().element(accountHandlingHeader).exists().perform();
        driver.verifyThat().element(username).exists().perform();
        driver.verifyThat().element(password).exists().perform();
        driver.verifyThat().element(number).exists().perform();
        driver.verifyThat().element(email).exists().perform();
    }

    public void clickOnAddContractSO(){
        driver.element().click(addContractSO);
    }

    public void clickOnMergeAccountsSO(){
        driver.element().click(mergeAccountsSO);
    }

    public void clickOnChangeUsernameButton(){
        driver.element().click(changeUsernameButton);
    }

    public void clickOnChangePasswordButton(){
        driver.element().click(changePasswordButton);
    }

    public void clickOnchangePersonalDataButton(){
        driver.element().click(changePersonalDataButton);
    }

    public void clickOnDeleteButton(){
        driver.element().click(deleteAccountButton);
    }

    public AccountManagementPage clickOnNextSOButton(){
        driver.element().click(nextSOButton);
        return this;
    }

}
