package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutAddInformation {

    WebDriver driver;
    public CheckoutAddInformation(WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("//span[@class='title']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By submitButton = By.id("continue");

    public void checkTitle(){
        driver.findElement(title).getText();
    }

    public CheckoutOverview submit(String firstname, String lastname, String postalcode){
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(postalCode).sendKeys(postalcode);
        driver.findElement(submitButton).click();
        return new CheckoutOverview(driver);

    }


}
