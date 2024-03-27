package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class OrderPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By WorkOrderCard = By.xpath("//a[@automation-id='workOrdersTab_lv']//span");
    //Constructor
    public OrderPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    //Methods
    @Step("validate work order card title")
    public void validateWorkOrderCardTitle(String WorkOrderCardCL){
        driver.assertThat().element(WorkOrderCard).textTrimmed().isEqualTo(WorkOrderCardCL).perform();
    }
}
