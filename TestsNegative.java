package my_work;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTestClass;

import java.time.Duration;

public class TestsNegative extends BaseTestClass {
    @Test
    public void testNegative(){

        String url = "https://www.saucedemo.com";
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        String curentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/",curentUrl);

        String logInErorr = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        Assert.assertEquals("Login text error are not correct", logInErorr, actualMessage);

    }
}
