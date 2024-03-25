package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By quantityLabel = By.className("cart_quantity_label");
    private By checkoutButton = By.id("checkout");


    public void isQuantityLabelDisplayed(){
        driver.findElement(quantityLabel).isDisplayed();
    }

    public CheckoutAddInformation checkout(){
        driver.findElement(checkoutButton).click();
        return new CheckoutAddInformation(driver);
    }


}
