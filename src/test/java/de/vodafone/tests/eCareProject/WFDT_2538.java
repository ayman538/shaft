package de.vodafone.tests.eCareProject;

import com.shaft.validation.Validations;
import de.vodafone.pages.eCareProject.MobileNotRegistered;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("eCare Project")
public class WFDT_2538 extends eCareProjectSetup {

    //Test
    @Test
    @Description("GC01 - Marie - Check Contract accordion for user has only one not registered subscriber")
    private void gc01(){

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_Title_CL)
                .withCustomReportMessage("Check that unregistered Section title is exist and correct CL")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle_CL)
                .withCustomReportMessage("Check that unregistered Section subtitle is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that link out icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the first unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that unregistered subscriber title is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber)
                .doesNotExist()
                .withCustomReportMessage("Check that User has only one unregistered subscriber")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.ShowMore_Unregistered_BTN)
                .doesNotExist()
                .withCustomReportMessage("Check that User Show more unregistered subscribers button is not exist")
                .perform();
    }

    @Test
    @Description("GC02 - Kay - Check Contract accordion for user has 2 unregistered subscriber and Navigation to \"Add subscriber\" transaction")
    private void gc02(){
        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_Title_CL)
                .withCustomReportMessage("Check that unregistered Section title is exist and correct CL")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle_CL)
                .withCustomReportMessage("Check that unregistered Section subtitle is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that linkout icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the first unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that unregistered subscriber title is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in Second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that lin kout icon in Second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the Second unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that Second unregistered subscriber title is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.ShowMore_Unregistered_BTN)
                .doesNotExist()
                .withCustomReportMessage("Check that Show more unregistered subscribers button is not exist")
                .perform();

        new MobileNotRegistered(driver).NavigateToAddSubscriberPage();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Add_Subscriber_Page_Title)
                .exists()
                .withCustomReportMessage("Check that user navigated to add subscriber transaction page")
                .perform();

    }

    @Test
    @Description("GC03 - Kay - Check \"Show more\" in contract accordion for has more than 2 unregistered subscriber")
    private void gc03(){
        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_Title_CL)
                .withCustomReportMessage("Check that unregistered Section title is exist and correct CL")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle_CL)
                .withCustomReportMessage("Check that unregistered Section subtitle is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that linkout icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the first unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that unregistered subscriber title is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in Second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that lin kout icon in Second unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the Second unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Second_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that Second unregistered subscriber title is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.ShowMore_Unregistered_BTN)
                .exists()
                .withCustomReportMessage("Check that Show more unregistered subscribers button is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.ShowMore_Unregistered_Icon)
                .exists()
                .withCustomReportMessage("Check that Show more unregistered subscribers icon is exist")
                .perform();

        new MobileNotRegistered(driver).clickOnShowMoreButton();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Third_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that Third unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Third_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in Third unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Third_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that lin kout icon in Third unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Third_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the Third unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Third_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that Third unregistered subscriber title is exist and correct CL")
                .perform();

        new MobileNotRegistered(driver).NavigateToAddSubscriberPage();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Add_Subscriber_Page_Title)
                .exists()
                .withCustomReportMessage("Check that user navigated to add subscriber transaction page")
                .perform();

    }

    @Test
    @Description("GC04 - Kay - Check Contract accordion for user has NO unregistered subscribers")
    private void gc04(){
        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Subscribers_Section)
                .doesNotExist()
                .withCustomReportMessage("Check that Unregistered subscribers section is not exist")
                .perform();

    }

    @Test
    @Description("GC05 - Multiple Kay - Check Contract accordions for user has 2 unregistered subscribers and user has NO unregistered subscribers")
    private void gc05(){

        new MobileNotRegistered(driver).ExpandContractAccordionHasNOUnregistered();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Subscribers_Section)
                .doesNotExist()
                .withCustomReportMessage("Check that Unregistered subscribers section is not exist")
                .perform();

        new MobileNotRegistered(driver).ExpandContractAccordionHasUnregistered();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_Title_CL)
                .withCustomReportMessage("Check that unregistered Section title is exist and correct CL")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Section_Subscribers_SubTitle_CL)
                .withCustomReportMessage("Check that unregistered Section subtitle is exist and correct CL")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber)
                .exists()
                .withCustomReportMessage("Check that first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Icon)
                .exists()
                .withCustomReportMessage("Check that plus icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Link)
                .exists()
                .withCustomReportMessage("Check that linkout icon in first unregistered subscriber tile is exist")
                .perform();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Num)
                .exists()
                .withCustomReportMessage("Check that number of the first unregistered subscriber tile is exist")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MobileNotRegistered.First_Unregistered_Subscriber_Title)
                .text().isEqualTo(MobileNotRegistered.Unregistered_Subscriber_Title_CL)
                .withCustomReportMessage("Check that unregistered subscriber title is exist and correct CL")
                .perform();

        new MobileNotRegistered(driver).NavigateToAddSubscriberPage();

        Validations.verifyThat().element(driver.getDriver(), MobileNotRegistered.Add_Subscriber_Page_Title)
                .exists()
                .withCustomReportMessage("Check that user navigated to add subscriber transaction page")
                .perform();


    }


}
