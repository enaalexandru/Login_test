package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");
    private By backpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By checkItem = By.className("shopping_cart_badge");
    private By shopingCartBadge = By.className("shopping_cart_link");



    public boolean isBurgerMenuButtonVisible(){
        return driver.findElement(burgerMenu).isDisplayed();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public void clickBurgerMenu(){
        driver.findElement(burgerMenu).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
        new SwagLabsLoginPage(driver);
    }

    public void addBackpackInCart(){
        driver.findElement(backpackToCart).click();
    }

    public boolean itemIsAddCorectlyToCart(){
        return driver.findElement(checkItem).isDisplayed();
    }

    public CartPage clickCartBadge(){
        driver.findElement(shopingCartBadge).click();
        return new CartPage(driver);
    }
}
