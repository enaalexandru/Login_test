package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {
    WebDriver driver;

    private By orderSuccessful = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessfulOrderMessage(){
        return driver.findElement(orderSuccessful).getText();
    }

    public SwagLabsLoginPage backHome(){
        driver.findElement(backHomeButton).click();
        return new SwagLabsLoginPage(driver);
    }


}
