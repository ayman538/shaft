package de.vodafone.tests.CentralLandingPage.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.CentralLandingPage.ContractChooser;
import de.vodafone.pages.CentralLandingPage.MainCentralLandingPage;
import de.vodafone.pages.CentralLandingPage.UploadDocument;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Epic("Central Landing Page")
@Feature("SIT")
@Story("WFAT_13286")
public class WFAT_13286 extends CentralLandingPageSetup {
    public String userName;
    public String userPassword;
    @Test(groups = {"WFAT_13286", "regression"})
    @Description("non-logged user - login - user has one subscriber -Verify redirection to upload documentation page")
    public void GC01(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        new MainCentralLandingPage(driver).chooseLoginOption().loginToUploadDocument(userName, userPassword);
        uploadDocumentValidation();
    }
    @Test(groups = {"WFAT_13286", "regression"})
    @Description("non-logged user - login - user has multi subscriber -Verify redirection to contract chooser then upload documentation page")
    public void GC02(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        new MainCentralLandingPage(driver).chooseLoginOption().loginToContractChooser(userName, userPassword);
        Validations.assertThat()
                .element(driver.getDriver(), ContractChooser.PageHeader_text)
                .text()
                .contains(ContractChooser.PageHeader)
                .withCustomReportMessage("Check that  Page header  text is correct ")
                .perform();
        new ContractChooser(driver).chooseContract();
        uploadDocumentValidation();
    }
    private void uploadDocumentValidation(){
        Validations.assertThat()
                .element(driver.getDriver(), UploadDocument.PageHeader_text)
                .text()
                .contains(UploadDocument.PageHeader)
                .withCustomReportMessage("Check that  Page header  text is correct ")
                .perform();
    }

}
