package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class DashboardPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators

    public static By acceptCookies_button=By.xpath("//button//span[contains(text(),'ablehnen')]");

    public static By headline_text = By.xpath("//*[@id='content']//welcome-page/div/div[1]");
    public static By firstSubHeadline_text = By.xpath("//*[@id='content']//welcome-page/div/h6");
    public static By secondSubHeadline_text = By.xpath("//*[@id='content']//welcome-page/div/p[1]");
    public static By thirdSubHeadline_text = By.xpath("//*[@id='content']//welcome-page/div/p[2]");
    public static By neinButton_btn = By.xpath("//*[@automation-id='navigate_btn_Link']");
    public static By jeButton_btn = By.xpath(" //a[@automation-id='thankYouPage_btn_Link']");

    //CL
    public static String headlineText = "Teste Deine Router-Verbindung";
    public static String firstSubHeadlineText = "Probier bitte mal aus, ob das Internet an Deinem Router schon funktioniert. Wie das geht, siehst Du hier.";
    public static String secondSubHeadlineText = "Wenn's funktioniert, hat der Techniker seine Arbeit direkt am Hauptverteiler erledigt und brauchte nicht in Deine Wohnung.";
    public static String thirdSubHeadlineText = "Wenn's nicht funktioniert, gib uns hier bitte Bescheid. Dann siehst Du die nächsten Schritte.";
    public static String neinButton = "Nein, geht leider nicht.";
    public static String jeButton = "Ja, mein Internet funktioniert.";

    //constructor
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public DashboardPage acceptCookies(){
        driver.element().click( acceptCookies_button);
        return this;
    }

    public DashboardPage clickOnNeinButton() {
        driver.element().click(neinButton_btn);
        return this;
    };

    public SuccessPage clickOnJeButton() {
        driver.element().click(jeButton_btn);
        return new SuccessPage(driver);
    }
}
