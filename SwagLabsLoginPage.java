package my_work.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsLoginPage {
    public SwagLabsLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private WebDriver driver;


    private String urlPage = "https://www.saucedemo.com/";
    private By setTextInUsernameField = By.id("user-name");
    private By setPasswordInPasswordField = By.id("password");
    private By loginButton =  By.id("login-button");


    public void openSwagLabPage(){
        driver.get(urlPage);
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(setTextInUsernameField).sendKeys(username);
        driver.findElement(setPasswordInPasswordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getTitle(){
        return driver.getTitle();
    }



    }




