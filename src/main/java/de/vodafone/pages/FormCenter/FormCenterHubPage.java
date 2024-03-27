package de.vodafone.pages.FormCenter;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FormCenterHubPage {
    private static SHAFT.GUI.WebDriver driver;
    public FormCenterHubPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By formCenterHubPageHeaderLocator = By.xpath("//*[@automation-id='form_center_headline_id_headline_tv']");
    private By formCenterHubPageSubHeaderLocator = By.xpath("//*[@automation-id='form_center_headline_id_subline_tv']");
    private By formCenterFinderHeadlineLocator = By.xpath("//*[@class='search-label']");
    private By formCenterFinderInputFieldLocator = By.xpath("//*[@automation-id='searchBar_ID_et']");
    private By formCenterSearchButtonLocator = By.xpath("//*[@automation-id='true_svg']");
    private By formCenterSorterLocator = By.xpath("//ws10-grid-container/div/span");
    private By formCenterFooterContainerLocator = By.xpath("//*[@class='list-foo-main']");
    private By nonExistingFormMsgLocator = By.xpath("//*[@class='text-center']");
    private By NextButton = By.xpath("(//a[@class='ws10-button-link ws10-button-link--color-primary-200'])[2]//span");
    private By PageNumberForm = By.xpath("(//span[@class='ws10-text'])");
    private By PageNumber = By.xpath("(//span[@class='ws10-text'])//span");
    private By BackButton = By.xpath("(//a[@class='ws10-button-link ws10-button-link--color-primary-200'])[1]//span");
    private By HiddenButton = By.xpath("//ws10-button-link[@class='hiddenBtn']");

    private String formCenterHubPageHeaderCL = "Formularcenter";
    private String formCenterHubPageSubHeaderCL = "Sende uns dein Anliegen und wir kümmern uns um den Rest";
    private String formCenterFinderHeadlineCL = "Finde dein Formular";
    private String formCenterSorterCL = "Formulare";
    private String formCenterSorterIICL = "22 Formular";
    private String voidInput = "";
    private String nonExistingFormCL = "DummyFormName";
    private String more50CharsCL = "Aequeosalinocalcalinoceraceoaluminosocupreovitriolic";
    private String corresponding50CharsCL = "Aequeosalinocalcalinoceraceoaluminosocupreovitriol";
    private String existingFormCL = "Baratheon";
    private String nonExistingFormMsgCL = "Nichts gefunden. Nimm bitte einen anderen Suchbegriff.";
    private String formCenterHubPageURL = System.getProperty("de.vodafone.baseUrl.st")+"hilfe/formulare/hub";

    @Step("Deeplink to Form Center Hub Page")
    public FormCenterHubPage navigateToFormCenterHubPage() {
        driver.browser().navigateToURL(formCenterHubPageURL);
        return this;
    }

    @Step("Click On Next Button")
    public FormCenterHubPage clickNextButton(){
        driver.element().click(NextButton);
        return this;
    }

    @Step("Click On Back Button")
    public FormCenterHubPage clickBackButton(){
        driver.element().click(BackButton);
        return this;
    }

    @Step("Validate Next Button Is not exist")
    public FormCenterHubPage validateNextButtonNotExist(){
        driver.verifyThat().element(HiddenButton).exists().perform();
        return this;
    }

    @Step("Validate Back Button Is not exist")
    public FormCenterHubPage validateBackButtonNotExist(){
        driver.verifyThat().element(HiddenButton).exists().perform();
        return this;
    }

    @Step("Validate Next Button exist")
    public FormCenterHubPage validateNextButtonExist(){
        driver.verifyThat().element(NextButton).exists().perform();
        return this;
    }

    @Step("Validate Back Button exist")
    public FormCenterHubPage validateBackButtonExist(){
        driver.verifyThat().element(BackButton).exists().perform();
        return this;
    }

    @Step("Validate Pagination Component")
    public FormCenterHubPage validatePaginationComponent(String NextButtonCL, String PageNumberFormCL, String PageNumberCL, String BackButtonCL){
        driver.verifyThat().element(NextButton).textTrimmed().isEqualTo(NextButtonCL).perform();
        driver.verifyThat().element(PageNumberForm).textTrimmed().isEqualTo(PageNumberFormCL).perform();
        driver.verifyThat().element(PageNumber).text().isEqualTo(PageNumberCL).perform();
        driver.verifyThat().element(BackButton).textTrimmed().isEqualTo(BackButtonCL).perform();
        return this;
    }

    @Step("Validate Form Center Hub Page's Header, Sub Header and Finder Headline")
    public FormCenterHubPage validateFormCenterHeaderSubHeaderFinderHeadline() {
        Validations.assertThat()
                .element(driver.getDriver(), formCenterHubPageHeaderLocator)
                .text().contains(formCenterHubPageHeaderCL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), formCenterHubPageSubHeaderLocator)
                .text().contains(formCenterHubPageSubHeaderCL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), formCenterFinderHeadlineLocator)
                .text().contains(formCenterFinderHeadlineCL).perform();
        return this;
    }
    @Step("Validate Form Center Hub Page's Footer")
    public FormCenterHubPage validateFormCenterFooter() {
        Validations.assertThat()
                .element(driver.getDriver(), formCenterFooterContainerLocator)
                .isVisible().perform();
        return this;
    }
    @Step("Validate Form Center Hub Page's Sorting")
    public FormCenterHubPage validateFormCenterSorting() {
        Validations.assertThat()
                .element(driver.getDriver(), formCenterSorterLocator)
                .text().contains(formCenterSorterCL).perform();
        return this;
    }
    @Step("Validate Form Center Hub Page's Sorting II")
    public FormCenterHubPage validateFormCenterSortingII() {
        Validations.assertThat()
                .element(driver.getDriver(), formCenterSorterLocator)
                .text().contains(formCenterSorterIICL).perform();
        return this;
    }
    @Step("Filling in an existing form name")
    public FormCenterHubPage fillInAnExistingFormName() {
        driver.element().type(formCenterFinderInputFieldLocator,existingFormCL);
        return this;
    }
    @Step("Searching for a form")
    public FormCenterHubPage lookupForForm() {
        driver.element().click(formCenterSearchButtonLocator);
        return this;
    }
    @Step("Filling in a non-existing form name")
    public FormCenterHubPage fillInNonExistingFormName() {
        driver.element().type(formCenterFinderInputFieldLocator,nonExistingFormCL);
        return this;
    }
    @Step("Lookup using a more than 50 characters word")
    public FormCenterHubPage fillInLongString() {
        driver.element().typeAppend(formCenterFinderInputFieldLocator,more50CharsCL);
        return this;
    }
    @Step("Retrieving the used lookup word")
    public String retrievingTheUsedLookupWord() {
        String FiftyCharWord = driver.element().getText(formCenterFinderInputFieldLocator);
        return FiftyCharWord;
    }
    @Step("Validate Searching Text Limited To 50 Characters")
    public FormCenterHubPage validateSearchingTextLimitedTo50Chars() {
        Validations.assertThat()
                .object(retrievingTheUsedLookupWord())
                .contains(corresponding50CharsCL).perform();
        return this;
    }
    @Step("Validate no forms found using the entered keyword")
    public FormCenterHubPage validateFormNotFound() {
        Validations.assertThat()
                .element(driver.getDriver(), nonExistingFormMsgLocator)
                .text().contains(nonExistingFormMsgCL).perform();
        return this;
    }
    @Step("Clear search input to get all results")
    public FormCenterHubPage clearAndSearch() {
        driver.element().type(formCenterFinderInputFieldLocator,voidInput);
        driver.element().click(formCenterSearchButtonLocator);
        return this;
    }
}
