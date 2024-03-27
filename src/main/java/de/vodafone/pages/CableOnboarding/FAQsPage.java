package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class FAQsPage {


    // Variables
    private final SHAFT.GUI.WebDriver driver;



    //Locators
    public static final By header_Cl = By.xpath("//app-header//h1");
    public static final By subHeader_Cl = By.xpath("//app-self-and-tech-install-accordion/div/p");


    public static final By selfInstall_werInstalliertMeinenRouter_Accordion = By.xpath("//*[@automation-id='Wer installiert meinen Router?']//label/span");
    public static final By selfInstall_werInstalliertMeinenRouter_AccordionDescribtion = By.xpath("//*[@automation-id='Wer installiert meinen Router?']//p");
    public static final By selfInstall_wannbeginntmeinVertrag_Accordion = By.xpath("//*[@automation-id='Wann beginnt mein Vertrag?']//label/span");
    public static final By selfInstall_wannbeginntmeinVertrag_AccordionDescribtion = By.xpath("//*[@automation-id='Wann beginnt mein Vertrag?']//p");
    public static final By selfInstall_WasistderAnbieterwechsel_Accordion = By.xpath("//*[@automation-id='Was ist der Anbieterwechsel?']//label/span");
    public static final By selfInstall_WasistderAnbieterwechsel_AccordionDescribtion = By.xpath("//*[@automation-id='Was ist der Anbieterwechsel?']//p");
    public static final By selfInstall_AbwannkannichdasInternetnutzen_Accordion = By.xpath("//*[@automation-id='Ab wann kann ich das Internet nutzen?']//label/span");
    public static final By selfInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion = By.xpath("//*[@automation-id='Ab wann kann ich das Internet nutzen?']//p");

    public static final By TechInstall_werInstalliertMeinenRouter_Accordion = By.xpath("//*[@automation-id='Wer installiert meinen Router?']//label/span");
    public static final By TechInstall_werInstalliertMeinenRouter_AccordionDescribtion = By.xpath("//*[@automation-id='Wer installiert meinen Router?']//p");
    public static final By TechInstall_wannbeginntmeinVertrag_Accordion = By.xpath("//*[@automation-id='Wann beginnt mein Vertrag?']//label/span");
    public static final By TechInstall_wannbeginntmeinVertrag_AccordionDescribtion = By.xpath("//*[@automation-id='Wann beginnt mein Vertrag?']//p");
    public static final By TechInstall_WasistderAnbieterwechsel_Accordion = By.xpath("//*[@automation-id='Was ist der Anbieterwechsel?']//label/span");
    public static final By TechInstall_WasistderAnbieterwechsel_AccordionDescribtion = By.xpath("//*[@automation-id='Was ist der Anbieterwechsel?']//p");
    public static final By TechInstall_AbwannkannichdasInternetnutzen_Accordion = By.xpath("//*[@automation-id='Ab wann kann ich das Internet nutzen?']//label/span");
    public static final By TechInstall_AbwannkannichdasInternetnutzen_AccordionDescribtion = By.xpath("//*[@automation-id='Ab wann kann ich das Internet nutzen?']//p");
    public static final By TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion = By.xpath("//*[@automation-id='Wie kann ich bei Anbieterwechsel meinen Anschluss sofort aktivieren?']//label/span");
    public static final By TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_AccordionDescribtion
            = By.xpath("//*[@automation-id='Wie kann ich bei Anbieterwechsel meinen Anschluss sofort aktivieren?']//p");
    public static final By TechInstall_WasistderWechselservice_Accordion = By.xpath("//*[@automation-id='Was ist der Wechselservice?']//label/span");
    public static final By TechInstall_WasistderWechselservice_AccordionDescribtion = By.xpath("//*[@automation-id='Was ist der Wechselservice?']//p");
    public static final By TechInstall_WienutzeichdenWechselservice_Accordion = By.xpath("//*[@automation-id='Wie nutze ich den Wechselservice?']//label/span");
    public static final By TechInstall_WienutzeichdenWechselservice_AccordionDescribtion = By.xpath("//*[@automation-id='Wie nutze ich den Wechselservice?']//p");



    //constructor
    public FAQsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public FAQsPage Self_Install_ClickOnWerInstalliertMeinenRouter_Accordion(){
        driver.element().click(selfInstall_werInstalliertMeinenRouter_Accordion);
        return this;
    }
    public FAQsPage Self_Install_ClickOnWannbeginntmeinVertrag_Accordion(){
        driver.element().click(selfInstall_wannbeginntmeinVertrag_Accordion);
        return this;
    }
    public FAQsPage Self_Install_ClickOnWasistderAnbieterwechsel_Accordion(){
        driver.element().click(selfInstall_WasistderAnbieterwechsel_Accordion);
        return this;
    }
    public FAQsPage Self_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion(){
        driver.element().click(selfInstall_AbwannkannichdasInternetnutzen_Accordion);
        return this;
    }


    public FAQsPage Tech_Install_ClickOnWerInstalliertMeinenRouter_Accordion(){
        driver.element().click(TechInstall_werInstalliertMeinenRouter_Accordion);
        return this;
    }
    public FAQsPage Tech_Install_ClickOnWannbeginntmeinVertrag_Accordion(){

        driver.element().click(TechInstall_wannbeginntmeinVertrag_Accordion);
        return this;
    }

    public FAQsPage Tech_Install_ClickOnAbwannkannichdasInternetnutzen_Accordion(){
        driver.element().click(TechInstall_AbwannkannichdasInternetnutzen_Accordion);
        return this;
    }

    public FAQsPage Tech_Install_ClickOnWasistderAnbieterwechsel_Accordion(){
        driver.element().click(TechInstall_WasistderAnbieterwechsel_Accordion);
        return this;
    }

    public FAQsPage Tech_Install_ClickOnWiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion(){
        driver.element().click(TechInstall_WiekannichbeiAnbieterwechselmeinenAnschlusssofortaktivieren_Accordion);
        return this;
    }
    public FAQsPage Tech_Install_ClickOnWasistderWechselservice_Accordion(){
        driver.element().click(TechInstall_WasistderWechselservice_Accordion);
        return this;
    }
    public FAQsPage Tech_Install_ClickOnWienutzeichdenWechselservice_Accordion(){
        driver.element().click(TechInstall_WienutzeichdenWechselservice_Accordion);
        return this;
    }

}
