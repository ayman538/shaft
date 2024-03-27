package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.*;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-9287")
public class WFBT_9287 {
    public static SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dsl_dashboard;
    MyDSLProducts myDSLProducts;

    @Test(groups = {"WFBT-9660", "regression"} , enabled = false , description = "Back-end issue")
    @Description("GC01 || Selecting an existing title & an existing occupation")
    private void GC01(){
        dsl_dashboard = new DSL_Dashboard(driver);
        myDSLProducts = new MyDSLProducts(driver);
        dsl_dashboard.closeEmailNotification();
        dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        PhonebookEntry phonebookEntry = myDSLProducts.expandSettingsAccAndNavToPhonebookEntry();
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PhonebookEntryPageHeaderLocator)
                .text().equals( PhonebookEntry.PhonebookEntryPageHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PersonalDataSectionHeaderLocator)
                .text().equals( PhonebookEntry.PersonalDataSectionHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PersonalDataSectionTextLocator)
                .text().equals( PhonebookEntry.PersonalDataSectionTextCL);

        driver.element().click( PhonebookEntry.TitleLocator);
        driver.element().type(PhonebookEntry.TitleLocator,PhonebookEntry.TitleCL);
        driver.element().click(PhonebookEntry.TitleValueLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TitleHintLocator)
                .text().equals( PhonebookEntry.TitleHintCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.FirstnamelablelLocator)
                .text().equals( PhonebookEntry.FirstnamelablelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.LastnamelablelLocator)
                .text().equals( PhonebookEntry.LastnamelablelCL);
        phonebookEntry.fillInemptyAttribute(phonebookEntry
                .getAttributeValue(PhonebookEntry.FirstNameLocator),PhonebookEntry.FirstNameLocator,PhonebookEntry.FirstNameCL);
        phonebookEntry.fillInemptyAttribute(phonebookEntry
                .getAttributeValue(PhonebookEntry.LastNameLocator),PhonebookEntry.LastNameLocator,PhonebookEntry.LastNameCL);
        driver.element().click( PhonebookEntry.ProfessionLocator);
        driver.element().type(PhonebookEntry.ProfessionLocator,PhonebookEntry.ProfessionCL);
        driver.element().click(PhonebookEntry.ProfessionValueLocator);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.ProfessionHintLocator)
                .text().equals( PhonebookEntry.ProfessionHintCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PhoneNumberLabelLocator)
                .text().equals( PhonebookEntry.PhonenumberlabelCL);
        phonebookEntry.fillInemptyAttribute(phonebookEntry
                .getAttributeValue(PhonebookEntry.PhoneNumberLocator),PhonebookEntry.PhoneNumberLocator,PhonebookEntry.PhoneNumberCL);

//        Validations.assertThat()
//                .element(driver.getDriver(), PhonebookEntry.PhoneNumberHintLocator)
//                .text().equals( PhonebookEntry.PhoneNumberHintCL);
//        CL NEEdS TO BE VALIDATED
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.StreetNumberLabelLocator)
                .text().equals( PhonebookEntry.StreetNumberLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PostalCodeLabelLocator)
                .text().equals( PhonebookEntry.PostalCodeLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(),PhonebookEntry.MandatoryAttLabelLocator)
                .text().equals( PhonebookEntry.MandatoryAttLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.ProceedToStep2CTA_Locator)
                .text().equals( PhonebookEntry.ProceedToStep2CTA_CL);

        driver.element().click( PhonebookEntry.ProceedToStep2CTA_Locator);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PhonebookEntrySectionHeaderLocator)
                .text().equals( PhonebookEntry.PhonebookEntrySectionHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.PhonebookEntrySectionTextLocator)
                .text().equals( PhonebookEntry.PhonebookEntrySectionTextCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TelephoneNumberLabelLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TelephoneNumberLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.CreateChangeDeletePhonebookLabelLocator)
                .text().equals( PhonebookEntry.CreateChangeDeletePhonebookLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TelephoneNumberSectionAttributesContainerLocator)
                .exists();
        phonebookEntry.scrollAndClick(PhonebookEntry.CreateChangeDeletePhonebookCheckboxLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TelephoneNumberSectionAttributesContainerLocator)
                .doesNotExist();
        phonebookEntry.scrollAndClick(PhonebookEntry.CreateChangeDeletePhonebookCheckboxLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TelephoneNumberSectionAttributesContainerLocator)
                .exists();

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EnterAsaPhoneLabelLocator)
                .text().equals( PhonebookEntry.EnterAsaPhoneLabelCL);

        phonebookEntry.scrollAndClick(PhonebookEntry.EnterAsaFaxRadioButtonLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EnterAsaFaxLabelLocator)
                .text().equals( PhonebookEntry.EnterAsaFaxLabelCL);

        phonebookEntry.scrollAndClick(PhonebookEntry.EnterAsaPhoneAndFaxRadioButtonLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EnterAsaPhoneAndFaxLabelLocator)
                .text().equals( PhonebookEntry.EnterAsaPhoneAndFaxLabelCL);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.DeletePhonebookEntryLabelLocator)
                .text().equals( PhonebookEntry.DeletePhonebookEntryLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.DeletePhonebookEntryContainerLocator)
                .exists();
        phonebookEntry.scrollAndClick(PhonebookEntry.DeletePhonebookEntryRadioButtonLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.DeletePhonebookEntryContainerLocator)
                .doesNotExist();
        phonebookEntry.scrollAndClick(PhonebookEntry.EnterAsaPhoneRadioButtonLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.DeletePhonebookEntryContainerLocator)
                .exists();


        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeLabelLocator)
                .text().equals( PhonebookEntry.EntryTypeLabelCL);

        driver.element().click(PhonebookEntry.EntryTypeLocator);
        driver.element().click(PhonebookEntry.EntryTypeFirstOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeLocator)
                .text().equals( PhonebookEntry.EntryTypeFirstOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeFirstHintLocator)
                .text().equals( PhonebookEntry.EntryTypeFirstHintCL);

        driver.element().click(PhonebookEntry.EntryTypeLocator);
        driver.element().click(PhonebookEntry.EntryTypeFirstOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeLocator)
                .text().equals( PhonebookEntry.EntryTypeFirstOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeFirstHintLocator)
                .text().equals( PhonebookEntry.EntryTypeFirstHintCL);

        driver.element().click(PhonebookEntry.EntryTypeLocator);
        driver.element().click(PhonebookEntry.EntryTypeSecondOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeLocator)
                .text().equals( PhonebookEntry.EntryTypeSecondOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeSecondHintLocator)
                .text().equals( PhonebookEntry.EntryTypeSecondHintCL);

        driver.element().click(PhonebookEntry.EntryTypeLocator);
        driver.element().click(PhonebookEntry.EntryTypeThirdOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeLocator)
                .text().equals( PhonebookEntry.EntryTypeThirdOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.EntryTypeThirdHintLocator)
                .text().equals( PhonebookEntry.EntryTypeThirdHintCL);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TypeOfInfoLabelLocator)
                .text().equals( PhonebookEntry.TypeOfInfoLabelCL);

        driver.element().click(PhonebookEntry.TypeOfInfoLocator);
        driver.element().click(PhonebookEntry.TypeOfInfoFirstOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TypeOfInfoLocator)
                .text().equals( PhonebookEntry.TypeOfInfoFirstOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TypeOfInfoFirstHintLocator)
                .text().equals( PhonebookEntry.TypeOfInfoFirstHintCL);

        driver.element().click(PhonebookEntry.TypeOfInfoLocator);
        driver.element().click(PhonebookEntry.TypeOfInfoSecondOptionLocator);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TypeOfInfoLocator)
                .text().equals( PhonebookEntry.TypeOfInfoSecondOptionCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.TypeOfInfoSecondHintLocator)
                .text().equals( PhonebookEntry.TypeOfInfoSecondHintCL);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.CoUserLabelLocator)
                .text().equals( PhonebookEntry.CoUserLabelCL);
        driver.element().type(PhonebookEntry.CoUserLocator,PhonebookEntry.CoUserCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.CoUserHintLocator)
                .text().equals( PhonebookEntry.CoUserHintCL);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.AllowReverseSearchLabelLocator)
                .text().equals( PhonebookEntry.AllowReverseSearchLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.AllowReverseSearchTextLocator)
                .text().equals( PhonebookEntry.AllowReverseSearchTextCL);
        phonebookEntry.scrollAndClick(PhonebookEntry.AllowReverseSearchCheckboxLocator);
        phonebookEntry.scrollAndClick(PhonebookEntry.AllowReverseSearchCheckboxLocator);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.AllowInfoLabelLocator)
                .text().equals( PhonebookEntry.AllowInfoLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.AllowInfoTextLocator)
                .text().equals( PhonebookEntry.AllowInfoTextCL);
        phonebookEntry.scrollAndClick(PhonebookEntry.AllowInfoCheckboxLocator);
        phonebookEntry.scrollAndClick(PhonebookEntry.AllowInfoCheckboxLocator);

        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.MandatoryAttLabelIILocator)
                .text().equals( PhonebookEntry.MandatoryAttLabelIICL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.ProceedToStep3CTA_Locator)
                .text().equals( PhonebookEntry.ProceedToStep3CTA_CL);
        phonebookEntry.scrollAndClick(PhonebookEntry.ProceedToStep3CTA_Locator);


        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.CheckAndSendDataSectionHeaderLocator)
                .text().equals( PhonebookEntry.CheckAndSendDataSectionHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PersonalDataHeaderLabelLocator)
                .text().equals( phonebookEntry.PersonalDataHeaderLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.FirstNameLabelLocator)
                .text().equals( phonebookEntry.FirstNameLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.FirstNameValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.LastNameLabelLocator)
                .text().equals( phonebookEntry.LastNameLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.LastNameValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PhoneNumberLabLoctor)
                .text().equals( phonebookEntry.PhoneNumberLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PhoneNumberValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PhonebookEntryHeaderLabelLocator)
                .text().equals( phonebookEntry.PhonebookEntryHeaderLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PhoneNumberLabLocator)
                .text().equals( phonebookEntry.PhoneNumberLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.PhoneNumberValueLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.EntryTypeLabLocator)
                .text().equals( phonebookEntry.EntryTypeLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.EntryTypeValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.TypeOfInfoLabLocator)
                .text().equals( phonebookEntry.TypeOfInfoLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), phonebookEntry.TypeOfInfoValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.HintMsgLocator)
                .text().equals( PhonebookEntry.HintMsgCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.InfoBoxLocator)
                .text().equals( PhonebookEntry.InfoBoxCL);
        Validations.assertThat()
                .element(driver.getDriver(), PhonebookEntry.ProceedToConfPageCTA_Locator)
                .text().equals( PhonebookEntry.ProceedToConfPageCTA_CL);

        DSL_ConfirmationPage confirmatinPage = phonebookEntry.click(PhonebookEntry.ProceedToConfPageCTA_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.SuccessHeaderLocator)
                .text().equals( confirmatinPage.SuccessHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.SuccessTextLocator)
                .text().equals( confirmatinPage.SuccessTextCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.SuccessOverviewAccordionLocator)
                .text().equals( confirmatinPage.SuccessOverviewAccordionCL);

        driver.element().click( confirmatinPage.SuccessOverviewAccordionLocator);

        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.PersonalDataHeaderLabelLocator)
                .text().equals( confirmatinPage.PersonalDataHeaderLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.FirstNameLabelLocator)
                .text().equals( confirmatinPage.FirstNameLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.FirstNameValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.LastNameLabelLocator)
                .text().equals( confirmatinPage.LastNameLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.LastNameValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.PhoneNumberLabLoctor)
                .text().equals( confirmatinPage.PhoneNumberLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.PhoneNumberValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.PhoneNumberLabLocator)
                .text().equals( confirmatinPage.PhoneNumberLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.PhoneNumberValueLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.EntryTypeLabLocator)
                .text().equals( confirmatinPage.EntryTypeLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.EntryTypeValLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.TypeOfInfoLabLocator)
                .text().equals( confirmatinPage.TypeOfInfoLabCL);
        Validations.assertThat()
                .element(driver.getDriver(), confirmatinPage.TypeOfInfoValLocator)
                .exists();
    }

    @Test(groups = {"WFBT-8296", "regression"})
    @Description("GC07 || verify DSL user status 'Bearbeitungsstand' SM - Page - accordion ")
    private void GC07(){
        dsl_dashboard = new DSL_Dashboard(driver);
        Validations.assertThat()
                .element(driver.getDriver(), dsl_dashboard.StatusSO_HeaderLocator)
                .text().equals( dsl_dashboard.StatusSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), dsl_dashboard.StatusSO_TextLocator)
                .text().equals( dsl_dashboard.StatusSO_TextCL);

        StatusPage statusPage = dsl_dashboard.click(dsl_dashboard.StatusSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusPageHeaderLocator)
                .text().equals( statusPage.StatusPageHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusSO_HeaderLocator)
                .text().equals( statusPage.StatusSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusSO_TextLocator)
                .text().equals( statusPage.StatusSO_TextCL);
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusAccordionLocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusAccordionHeaderLocator)
                .text().equals( statusPage.StatusAccordionHeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), statusPage.StatusAccordionTextLocator)
                .text().equals( statusPage.StatusAccordionTextCL);
    }

    @Test(groups = {"WFBT-8297", "regression"})
    @Description("GC08 || verify DSL user 'Meine Produkte' SM - Page - accordion  ")
    private void GC08(){
        dsl_dashboard = new DSL_Dashboard(driver);
        myDSLProducts = new MyDSLProducts(driver);
        dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyProductsPageHeaderLocator)
                .text().equals( myDSLProducts.MyProductsPageHeaderCL);

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyProductsPageHeaderLocator)
                .text().equals( myDSLProducts.MyProductsPageHeaderCL);

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyTariffSO_Headerlocator)
                .text().equals( myDSLProducts.MyTariffSO_HeaderCL);
        myDSLProducts.click(myDSLProducts.MyTariffSO_locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyTariffAcclocator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyTariffAcc_Headerlocator)
                .text().equals( myDSLProducts.MyTariffAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyTariffAcc_Textlocator)
                .text().equals( myDSLProducts.MyTariffAcc_TextCL);


        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SuperWlanSO_HeaderLocator)
                .text().equals( myDSLProducts.SuperWlanSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SuperWlanSO_TextLocator)
                .text().equals( myDSLProducts.SuperWlanSO_TextCL);
        myDSLProducts.click(myDSLProducts.SuperWlanSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SuperWlanSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SuperWlanAcc_HeaderLocator)
                .text().equals( myDSLProducts.SuperWlanAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SuperWlanAcc_TextLocator)
                .text().equals( myDSLProducts.SuperWlanAcc_TextCL);

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookableOptionsSO_HeaderLocator)
                .text().equals( myDSLProducts.BookableOptionsSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookableOptionsSO_TextLocator)
                .text().equals( myDSLProducts.BookableOptionsSO_TextCL);
        myDSLProducts.click(myDSLProducts.BookableOptionsSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookableOptionsSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookableOptionsAcc_HeaderLocator)
                .text().equals( myDSLProducts.BookableOptionsAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookableOptionsAcc_TextLocator)
                .text().equals( myDSLProducts.BookableOptionsAcc_TextCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurityPackageSO_HeaderLocator)
                .text().equals( myDSLProducts.SecurityPackageSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurityPackageSO_TextLocator)
                .text().equals( myDSLProducts.SecurityPackageSO_TextCL);
        myDSLProducts.click(myDSLProducts.SecurityPackageSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurityPackageSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurityPackageSO_HeaderLocator)
                .text().equals( myDSLProducts.SecurityPackageAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurityPackageSO_TextLocator)
                .text().equals( myDSLProducts.SecurityPackageAcc_TextCL);

        myDSLProducts.clickViewMoreSOs();

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurenetSO_HeaderLocator)
                .text().equals( myDSLProducts.SecurenetSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurenetSO_TextLocator)
                .text().equals( myDSLProducts.SecurenetSO_TextCL);
        myDSLProducts.click(myDSLProducts.SecurenetSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurenetSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurenetAcc_HeaderLocator)
                .text().equals( myDSLProducts.SecurenetAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.SecurenetAcc_TextLocator)
                .text().equals( myDSLProducts.SecurenetAcc_TextCL);

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookedOptionsSO_HeaderLocator)
                .text().equals( myDSLProducts.BookedOptionsSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookedOptionsSO_TextLocator)
                .text().equals( myDSLProducts.BookedOptionsSO_TextCL);
        myDSLProducts.click(myDSLProducts.BookedOptionsSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookedOptionsSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookedOptionsAcc_HeaderLocator)
                .text().equals( myDSLProducts.BookedOptionsAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.BookedOptionsAcc_TextLocator)
                .text().equals( myDSLProducts.BookedOptionsAcc_TextCL);

        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.ConfigurationsSO_HeaderLocator)
                .text().equals( myDSLProducts.ConfigurationsSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.ConfigurationsSO_TextLocator)
                .text().equals( myDSLProducts.ConfigurationsSO_TextCL);
        myDSLProducts.click(myDSLProducts.ConfigurationsSO_Locator);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.ConfigurationsSO_Locator)
                .exists();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.ConfigurationsAcc_HeaderLocator)
                .text().equals( myDSLProducts.ConfigurationsAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.ConfigurationsAcc_TextLocator)
                .text().equals( myDSLProducts.ConfigurationsAcc_TextCL);
    }

    @Test(groups = {"WFBT-8298", "regression"})
    @Description(" GC09 || verify 'Geräte tab' SM - Page - accordion")
    private void GC09(){
        dsl_dashboard = new DSL_Dashboard(driver);
        myDSLProducts = new MyDSLProducts(driver);
        dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.MyProductsPageHeaderLocator)
                .text().equals( myDSLProducts.MyProductsPageHeaderCL);
        DevicesPage devicesPage = myDSLProducts.clickTab(myDSLProducts.DevicesTabLocator);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.PageHeaderLocator)
                .text().equals( devicesPage.PageHeaderCl);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.DevicesTabTextLocator)
                .text().equals( devicesPage.DevicesTabTextCL);

        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipSO_HeaderLocator)
                .text().equals( devicesPage.RentEquipSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipSO_TextLocator)
                .text().equals( devicesPage.RentEquipSO_TextCL);

        devicesPage.click(devicesPage.RentEquipSO_Locator);

        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_HeaderLocator)
                .text().equals( devicesPage.RentEquipAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_TextLocator)
                .text().equals( devicesPage.RentEquipAcc_TextCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_SectionLabelLocator)
                .text().equals( devicesPage.RentEquipAcc_SectionLabelCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_SectionTitleLocator)
                .text().equals( devicesPage.RentEquipAcc_SectionTitleCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_SectionSubTitleLocator)
                .text().equals( devicesPage.RentEquipAcc_SectionSubTitleCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.RentEquipAcc_SectionCTA_Locator)
                .text().equals( devicesPage.RentEquipAcc_SectionCTA_CL);


        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesSO_HeaderLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesSO_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesSO_TextLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesSO_TextCL);

        devicesPage.click(devicesPage.BuyDevicesAndAccessoriesSO_Locator);

        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesAcc_HeaderLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesAcc_HeaderCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesAcc_TextLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesAcc_TextCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesAcc_SectionTitleLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesAcc_SectionTitleCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesAcc_SectionSubTitleLocator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesAcc_SectionSubTitleCL);
        Validations.assertThat()
                .element(driver.getDriver(), devicesPage.BuyDevicesAndAccessoriesAcc_SectionCTA_Locator)
                .text().equals( devicesPage.BuyDevicesAndAccessoriesAcc_SectionCTA_CL);
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSL/ST" + "_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSL/ST/" + className + ".json");
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}