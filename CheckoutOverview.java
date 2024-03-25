package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview {
    WebDriver driver;

    private By description = By.className("inventory_item_desc");
    private By finishButton = By.id("finish");


    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }
    public void checkDescription(){
        driver.findElement(description).getText();
    }

    public CheckoutComplete finishOrder(){
        driver.findElement(finishButton).click();
        return new CheckoutComplete(driver);
    }
}
