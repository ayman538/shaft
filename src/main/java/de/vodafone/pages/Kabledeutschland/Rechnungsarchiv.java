package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Rechnungsarchiv {
    private SHAFT.GUI.WebDriver driver;

    public Rechnungsarchiv(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By getProductOrder(String order){
        return By.xpath("(//span[@class='ws10-hybrid-table__text ws10-hybrid-table__text-limit'])["+order+"]");
    }
    public void assertOnProductCl(String order, String productCl){
        driver.verifyThat().element(getProductOrder(order)).textTrimmed().isEqualTo(productCl).withCustomReportMessage("Assert on product Cl").perform();
    }
}
