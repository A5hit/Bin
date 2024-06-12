package org.Adobe.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutoLogin {
    WebDriver driver;
    LoginPage loginpage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashit/Desktop/chromedriver"); // add you webdriver's directory
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://new.express.adobe.com/");
    }

    @Test
    public void Login() throws InterruptedException {

        loginpage.emailInput().sendKeys("IshaanIshaan2484@tmspalam.onmicrosoft.com");
        loginpage.getEmailContinue().click();
        Thread.sleep(2000);
        loginpage.passwordField().sendKeys("Student@2024");
        Thread.sleep(2000);
        loginpage.getPasswordContinue().click();
        Thread.sleep(2000);
        loginpage.clickRememberMeButton();

        // Click Continue button falls under Shadow DOM
        SearchContext shadowHost2 = driver.findElement(By.cssSelector("x-welcome-modal[size='l']")).getShadowRoot();
        WebElement shadowContinueButton = shadowHost2.findElement(By.cssSelector("sp-button[size='l']"));
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
