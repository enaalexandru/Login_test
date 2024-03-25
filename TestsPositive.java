package my_work;

import my_work.Pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTestClass;

import java.time.Duration;

public class TestsPositive extends BaseTestClass {
    @Test
    public void testPositive(){

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        String urlPage = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(urlPage, driver.getCurrentUrl());
        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        wait2.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        //driver.findElement(By.id("logout_sidebar_link")).click();

        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @Test
    public void testsPositiveWithPom(){

        SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
        swagLabsLoginPage.openSwagLabPage();

        ProductsPage productsPage = swagLabsLoginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isBurgerMenuButtonVisible());
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals("Url is not correct", expectedUrl, productsPage.getPageUrl());

        /*productsPage.clickBurgerMenu();
        productsPage.clickLogoutButton();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(expectedTitle, swagLabsLoginPage.getTitle());*/

        productsPage.addBackpackInCart();
        Assert.assertTrue(productsPage.itemIsAddCorectlyToCart());
        productsPage.clickCartBadge();

        CartPage cartPage = productsPage.clickCartBadge();
        cartPage.isQuantityLabelDisplayed();
        CheckoutAddInformation checkoutAddInformation = cartPage.checkout();
        checkoutAddInformation.checkTitle();

        CheckoutOverview checkoutOverview = checkoutAddInformation.submit("Alexandru","Enache", "700770");
        checkoutOverview.checkDescription();
        CheckoutComplete checkoutComplete = checkoutOverview.finishOrder();
        String expectedSuccessfulOrder = "Thank you for your order!";
        Assert.assertEquals("Message for success order is wrong", expectedSuccessfulOrder, checkoutComplete.getSuccessfulOrderMessage());
        checkoutComplete.backHome();



    }
}
