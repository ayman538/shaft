package de.vodafone.pages.ASP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class ASPSalesAgentPage {
        // Locators
        private static SHAFT.GUI.WebDriver driver;
        public static final By PageHeader = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
        public static final By steaperHeader = By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
        public static final By Callusbutton = By.xpath("//*[@automation-id='call-us_title_tv']");
        public static final By CallusDescreption = By.xpath("//*[@automation-id='call-us_description_tv']");
        public static final By WhatsAppButton = By.xpath("//*[@automation-id='chat-us_title_tv']");
        public static final By WhatsAppDescreption = By.xpath("//*[@automation-id='chat-us_description_tv']");
        public static final By CallBackbutton = By.xpath("//*[@automation-id='our-recall_title_tv']");
        public static final By CallBackDescreption = By.xpath("//*[@automation-id='our-recall_description_tv']");
        public static final By Cancelbutton = By.xpath("//*[@automation-id='cancel-now_title_tv']");
        public static final By CancelbuttonDescreption = By.xpath("//*[@automation-id='cancel-now_description_tv']");
        //CL
        private String PageHeader_CL = "Wir sind für Dich da";
        private String steaperHeader_CL = "Sprich uns an";
        private String Callusbutton_CL = "Ruf uns an: 0800 50 54 734";
        private String CallusDescreption_CL = "Montags bis freitags 8 bis 18 Uhr, außer an Feiertagen.";
        private String WhatsAppButton_CL = "Chatte mit uns";
        private String WhatsAppDescreption_CL = "Inhalt muss noch festgelegt werden.";
        private String CallBackbutton_CL = "Unser Rückruf";
        private String CallBackDescreption_CL = "Sag uns, wann wir Dich zurückrufen sollen.";
        private String Cancelbutton_CL_Revoaction = "Vertrag jetzt widerrufen";
        private String Cancelbutton_CL_Termination = "Vertrag jetzt kündigen";
        private String CancelbuttonDescreption_CL = "Rücksendeunterlagen für Dein Gerät erhalten.";

        // Constructor
        public ASPSalesAgentPage(SHAFT.GUI.WebDriver driver) {
                this.driver = driver;
        }
        //Validations
        @Step("Validate SalesAgent Page")
        public void salesAgentValidation() {
                driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeader_CL).perform();
                driver.verifyThat().element(steaperHeader).text().isEqualTo(steaperHeader_CL).perform();
                driver.verifyThat().element(CallusDescreption).text().isEqualTo(CallusDescreption_CL).perform();
                /*driver.verifyThat().element(WhatsAppButton).text().isEqualTo(WhatsAppButton_CL).perform();
                driver.verifyThat().element(WhatsAppDescreption).text().isEqualTo(WhatsAppDescreption_CL).perform();*/
                driver.verifyThat().element(CallBackbutton).text().isEqualTo(CallBackbutton_CL).perform();
                driver.verifyThat().element(CallBackDescreption).text().isEqualTo(CallBackDescreption_CL).perform();
                driver.verifyThat().element(Cancelbutton).text().isEqualTo(Cancelbutton_CL_Revoaction).perform();
                driver.verifyThat().element(CancelbuttonDescreption).text().isEqualTo(CancelbuttonDescreption_CL).perform();
        }
        @Step("Validate SalesAgent Page for Camel user")
        public void CamelsalesAgnetValidation() {
                driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeader_CL).perform();
                driver.verifyThat().element(steaperHeader).text().isEqualTo(steaperHeader_CL).perform();
                driver.verifyThat().element(CallusDescreption).text().isEqualTo(CallusDescreption_CL).perform();
                /*driver.verifyThat().element(WhatsAppButton).text().isEqualTo(WhatsAppButton_CL).perform();
                driver.verifyThat().element(WhatsAppDescreption).text().isEqualTo(WhatsAppDescreption_CL).perform();
                driver.verifyThat().element(CallBackbutton).text().isEqualTo(CallBackbutton_CL).perform();
                driver.verifyThat().element(CallBackDescreption).text().isEqualTo(CallBackDescreption_CL).perform();*/
                driver.verifyThat().element(Cancelbutton).text().isEqualTo(Cancelbutton_CL_Revoaction).perform();
                driver.verifyThat().element(CancelbuttonDescreption).text().isEqualTo(CancelbuttonDescreption_CL).perform();
        }
        @Step("Validate SalesAgent Page for Fox User")
        public void FoxsalesAgnetValidation() {
                driver.verifyThat().element(PageHeader).text().isEqualTo(PageHeader_CL).perform();
                driver.verifyThat().element(steaperHeader).text().isEqualTo(steaperHeader_CL).perform();
                driver.verifyThat().element(CallusDescreption).text().isEqualTo(CallusDescreption_CL).perform();
                /*driver.verifyThat().element(WhatsAppButton).text().isEqualTo(WhatsAppButton_CL).perform();
                driver.verifyThat().element(WhatsAppDescreption).text().isEqualTo(WhatsAppDescreption_CL).perform();
                driver.verifyThat().element(CallBackbutton).text().isEqualTo(CallBackbutton_CL).perform();
                driver.verifyThat().element(CallBackDescreption).text().isEqualTo(CallBackDescreption_CL).perform();*/
                driver.verifyThat().element(Cancelbutton).text().isEqualTo(Cancelbutton_CL_Revoaction).perform();
                driver.verifyThat().element(CancelbuttonDescreption).text().isEqualTo(CancelbuttonDescreption_CL).perform();
        }


        //Actions
        public ASPFormStep1 clickCancelButton(){
                driver.element().click(Cancelbutton);
                return new ASPFormStep1(driver);
        }
}
