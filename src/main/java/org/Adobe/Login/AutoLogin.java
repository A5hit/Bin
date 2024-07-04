package org.Adobe.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutoLogin extends Utils {
    WebDriver driver;
    LoginPage loginpage;
    GoogleLogin googlelogin;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "//Users//45hit//Desktop//chromedriver"); // add you webdriver's directory
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        googlelogin = new GoogleLogin(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://new.express.adobe.com/");
    }

    @Test
    public void Login() throws InterruptedException {

        loginpage.emailInput().sendKeys(getEmail());
        loginpage.getEmailContinue().click();
        Thread.sleep(3000);
        if (googlelogin.getGEmailField().isDisplayed()){
            googlelogin.getGEmailField().sendKeys(getEmail());
            googlelogin.getGContinueButton().click();
            Thread.sleep(3000);
            googlelogin.getGPasswordField().sendKeys(getPassword());
            googlelogin.getGContinueButton().click();
        }else {
            loginpage.passwordField().sendKeys(getPassword());
            Thread.sleep(2000);
            loginpage.getPasswordContinue().click();
            loginpage.clickRememberMeButton();
        }
        Thread.sleep(5000);
        // Click Continue button falls under Shadow DOM
        SearchContext shadowHost0 = driver.findElement(By.cssSelector("x-app[dir='ltr']")).getShadowRoot();
        SearchContext shadowHost1 = shadowHost0.findElement(By.cssSelector("x-welcome-modal-host[dir='ltr']")).getShadowRoot();
        SearchContext shadowHost2 = shadowHost1.findElement(By.cssSelector("x-welcome-modal[slot='click-content']")).getShadowRoot();
        WebElement shadowContinueButton = shadowHost2.findElement(By.cssSelector("sp-button[role='button']"));
        shadowContinueButton.click();
        Thread.sleep(3000);
        shadowContinueButton.click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            try{
                Thread.sleep(10000);
            }catch (InterruptedException ignores){}
             driver.quit();
        }
    }


}
